package org.evomaster.core.problem.rest.resource.model

import org.evomaster.core.Lazy
import org.evomaster.core.database.DbAction
import org.evomaster.core.database.DbActionUtils
import org.evomaster.core.problem.rest.SampleType
import org.evomaster.core.search.Action
import org.evomaster.core.search.Individual
import org.evomaster.core.search.gene.Gene
import org.evomaster.core.search.gene.GeneUtils
import org.evomaster.core.search.service.Randomness
import org.evomaster.core.search.tracer.TrackOperator

class RestResourceIndividual (
        private val resourceCalls: MutableList<RestResourceCalls>,
        val sampleType: SampleType,
        val sampleSpec : SamplerSpecification? = null,
        val dbInitialization: MutableList<DbAction> = mutableListOf(),
        trackOperator: TrackOperator? = null,
        traces : MutableList<RestResourceIndividual>?=null
): Individual (trackOperator, traces){


    override fun copy(): Individual {
        return RestResourceIndividual(
                resourceCalls.map { it.copy() }.toMutableList(),
                sampleType,
                sampleSpec?.copy(),
                dbInitialization.map { d -> d.copy() as DbAction } as MutableList<DbAction>
        )
    }

    override fun canMutateStructure(): Boolean {
        return sampleType == SampleType.RANDOM ||
                sampleType == SampleType.SMART_GET_COLLECTION ||
                sampleType == SampleType.SMART_RESOURCE
    }

    override fun seeActions(): List<Action> = resourceCalls.flatMap { it.actions }

    fun removeResourceCall(position : Int) {
        if(position >= resourceCalls.size)
            throw IllegalArgumentException("position is out of range of list")
        resourceCalls.removeAt(position)
    }

    fun addResourceCall(position: Int, restCalls : RestResourceCalls) {
        if(position > resourceCalls.size)
            throw IllegalArgumentException("position is out of range of list")
        resourceCalls.add(position, restCalls)
    }

    fun replaceResourceCall(position: Int, restCalls: RestResourceCalls){
        if(position > resourceCalls.size)
            throw IllegalArgumentException("position is out of range of list")
        resourceCalls.set(position, restCalls)
    }

    fun swapResourceCall(position1: Int, position2: Int){
        if(position1 > resourceCalls.size || position2 > resourceCalls.size)
            throw IllegalArgumentException("position is out of range of list")
        if(position1 == position2)
            throw IllegalArgumentException("It is not necessary to swap two same position on the resource call list")
        val first = resourceCalls[position1]
        resourceCalls.set(position1, resourceCalls[position2])
        resourceCalls.set(position2, first)
    }

    override fun seeGenesIdMap() : Map<Gene, String>{
        return resourceCalls.flatMap { r -> r.seeGenesIdMap().map { it.key to it.value } }.toMap()
    }

    override fun next(trackOperator: TrackOperator) : RestResourceIndividual?{
        return RestResourceIndividual(
                resourceCalls.map { it.copy() }.toMutableList(),
                sampleType,
                sampleSpec?.copy(),
                dbInitialization.map { d -> d.copy() as DbAction } as MutableList<DbAction>,
                trackOperator,
                if (getTracking() == null) mutableListOf() else getTracking()!!.plus(this).map { (it as RestResourceIndividual).copy() as RestResourceIndividual }.toMutableList()
        )
    }

    override fun copy(withTrack: Boolean): RestResourceIndividual {
        when(withTrack){
            false-> return copy() as RestResourceIndividual
            else ->{
                getTracking()?:return copy() as RestResourceIndividual
                return RestResourceIndividual(
                        resourceCalls.map { it.copy() }.toMutableList(),
                        sampleType,
                        sampleSpec?.copy(),
                        dbInitialization.map { d -> d.copy() as DbAction } as MutableList<DbAction>,
                        trackOperator,
                        getTracking()!!.map { (it as RestResourceIndividual).copy() as RestResourceIndividual }.toMutableList()
                )
            }
        }
    }

    fun getResourceCalls() : List<RestResourceCalls> = resourceCalls.toList()

    override fun seeGenes(filter: GeneFilter): List<Gene> {
        return when (filter) {
            GeneFilter.ALL -> dbInitialization.flatMap(DbAction::seeGenes).plus(seeActions().flatMap(Action::seeGenes))
            GeneFilter.NO_SQL -> seeActions().flatMap(Action::seeGenes)
            GeneFilter.ONLY_SQL -> dbInitialization.flatMap(DbAction::seeGenes)
        }
    }

    override fun size(): Int  = seeActions().size

    //following is same with [RestIndividual]
    override fun verifyInitializationActions(): Boolean {
        return DbActionUtils.verifyActions(dbInitialization.filterIsInstance<DbAction>())
    }

    override fun repairInitializationActions(randomness: Randomness) {
        /**
         * First repair SQL Genes (i.e. SQL Timestamps)
         */
        GeneUtils.repairGenes(this.seeGenes(Individual.GeneFilter.ONLY_SQL).flatMap { it.flatView() })

        /**
         * Now repair database constraints (primary keys, foreign keys, unique fields, etc.)
         */
        if (!verifyInitializationActions()) {
            DbActionUtils.repairBrokenDbActionsList(dbInitialization, randomness)
            Lazy.assert{verifyInitializationActions()}
        }
    }

    fun repairDBActions(){
        val previousDbActions = mutableListOf<DbAction>()

        getResourceCalls().forEach {
            if (it.dbActions.isNotEmpty()){
                var result = try{
                    DbActionUtils.verifyActions(it.dbActions) || DbActionUtils.verifyActions(previousDbActions.plus(it.dbActions))
                }catch (e : IllegalArgumentException ){false}

                if(!result){
                    it.dbActions.forEach { db->
                        DbActionUtils.repairFK(db, previousDbActions)
                        previousDbActions.add(db)
                    }

                }else{
                    previousDbActions.addAll(it.dbActions)
                }
            }
        }
    }

    private fun validateSwap(first : Int, second : Int) : Boolean{
        val position = getResourceCalls()[first].shouldBefore.map { r ->
            getResourceCalls().indexOfFirst { it.resourceInstance.getAResourceKey() == r }
        }

        if(!position.none { it > second }) return false

        getResourceCalls().subList(0, second).find { it.shouldBefore.contains(getResourceCalls()[second].resourceInstance.getAResourceKey()) }?.let {
            return getResourceCalls().indexOf(it) < first
        }
        return true

    }

    /**
     * @return movable position
     */
    fun getMovablePosition(position: Int) : List<Int>{
       return (0..(getResourceCalls().size-1))
               .filter {
                   if(it < position) validateSwap(it, position) else if(it > position) validateSwap(position, it) else false
               }
    }

    /**
     * @return whether the call at the position is movable
     */
    fun isMovable(position: Int) : Boolean{
        return (0..(getResourceCalls().size-1))
                .any {
                    if(it < position) validateSwap(it, position) else if(it > position) validateSwap(position, it) else false
                }
    }

}