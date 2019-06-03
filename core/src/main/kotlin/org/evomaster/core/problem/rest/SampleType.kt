package org.evomaster.core.problem.rest

/**
 * Specify how a REST individual was sampled.
 * This info is needed to have custom mutations of the
 * chromosome structures
 *
 * [SMART_RESOURCE] is used to refer resource-based sampling
 */
enum class SampleType {
    RANDOM,
    SMART,
    SMART_RESOURCE,
    SMART_GET_COLLECTION
}