package org.evomaster.core.problem.rest.resource

import com.google.inject.AbstractModule
import com.google.inject.TypeLiteral
import org.evomaster.core.problem.rest.resource.model.RestResourceIndividual
import org.evomaster.core.problem.rest.resource.service.*
import org.evomaster.core.problem.rest.service.AbstractRestFitness
import org.evomaster.core.remote.service.RemoteController
import org.evomaster.core.search.service.Archive
import org.evomaster.core.search.service.FitnessFunction
import org.evomaster.core.search.service.Sampler
import org.evomaster.core.search.service.mutator.StandardMutator
import org.evomaster.core.search.service.mutator.Mutator
import org.evomaster.core.search.service.mutator.StructureMutator


class ResourceRestModule : AbstractModule(){

    override fun configure() {
        bind(object : TypeLiteral<Sampler<RestResourceIndividual>>() {})
                .to(RestResourceSampler::class.java)
                .asEagerSingleton()

        bind(object : TypeLiteral<Sampler<*>>() {})
                .to(RestResourceSampler::class.java)
                .asEagerSingleton()

        bind(RestResourceSampler::class.java)
                .asEagerSingleton()

        bind(object : TypeLiteral<FitnessFunction<RestResourceIndividual>>() {})
                .to(RestResourceFitness::class.java)
                .asEagerSingleton()

        bind(object : TypeLiteral<AbstractRestFitness<RestResourceIndividual>>() {})
                .to(RestResourceFitness::class.java)
                .asEagerSingleton()

        bind(object : TypeLiteral<Archive<RestResourceIndividual>>() {})
                .asEagerSingleton()

        bind(object : TypeLiteral<Archive<*>>() {})
                .to(object : TypeLiteral<Archive<RestResourceIndividual>>() {})

        bind(RemoteController::class.java)
                .asEagerSingleton()

        bind(object : TypeLiteral<Mutator<RestResourceIndividual>>() {})
                .to(ResourceRestMutator::class.java)
                .asEagerSingleton()

        bind(object : TypeLiteral<StandardMutator<RestResourceIndividual>>() {})
                .to(ResourceRestMutator::class.java)
                .asEagerSingleton()

        bind(ResourceRestMutator::class.java)
                .asEagerSingleton()

        bind(StructureMutator::class.java)
                .to(RestResourceStructureMutator::class.java)
                .asEagerSingleton()

        bind(ResourceManageService::class.java)
                .asEagerSingleton()

        bind(ResourceDepManageService::class.java)
                .asEagerSingleton()

    }
}