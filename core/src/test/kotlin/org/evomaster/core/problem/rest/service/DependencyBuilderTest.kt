package org.evomaster.core.problem.rest.service

import io.swagger.parser.SwaggerParser
import org.evomaster.client.java.controller.internal.db.SchemaExtractor
import org.evomaster.core.database.SqlInsertBuilder

import org.evomaster.core.database.extract.h2.ExtractTestBaseH2
import org.evomaster.core.database.schema.Table
import org.evomaster.core.problem.rest.RestActionBuilder
import org.evomaster.core.problem.rest.RestCallAction
import org.evomaster.core.problem.rest.resource.model.RestResourceNode
import org.evomaster.core.search.Action
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class DependencyBuilderTest : ExtractTestBaseH2() {

    override fun getSchemaLocation() = "/sql_schema/proxyprint.sql"

    private fun loadAndAssertActions(resourcePath: String, expectedNumberOfActions: Int)
            : MutableMap<String, Action> {

        val swagger = SwaggerParser().read(resourcePath)

        val actions: MutableMap<String, Action> = mutableMapOf()
        RestActionBuilder.addActionsFromSwagger(swagger, actions, listOf(),true)

        assertEquals(expectedNumberOfActions, actions.size)

        return actions
    }

    @Test
    fun testProxyPrint() {
        val schema = SchemaExtractor.extract(connection)
        val sqlInsertBuilder = SqlInsertBuilder(schema)

        val tables = mutableMapOf<String, Table>()
        sqlInsertBuilder.extractExistingTables(tables)

        val actionCluster = loadAndAssertActions("/swagger/proxyprint.json", 115)

        val resourceCluster : MutableMap<String, RestResourceNode> = mutableMapOf()

//        actionCluster.values.forEach { u ->
//            if (u is RestCallAction) {
//                val resource = resourceCluster.getOrPut(u.path.toString()) {
//                    RestResourceNode(u.path.copy(), mutableMapOf())
//                }
//                resource.addMethod(u)
//            }
//        }
//        //assertEquals(79, resourceCluster.size)
//
//        resourceCluster.values.forEach{it.initAncestors(resourceCluster.values.toList())}
//
//        resourceCluster.values.forEach{it.init(true)}
//
//        deriveResourceToTable(resourceCluster.values.toMutableList(), tables)

    }
}