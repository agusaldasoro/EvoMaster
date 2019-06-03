package org.evomaster.core.problem.rest.resource.model

class CallsTemplate (
        val template: String,
        val independent : Boolean,
        var size : Int = 1,
        var times : Int = 0,
        var sizeAssured : Boolean= !template.contains("POST")
)
