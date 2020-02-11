package org.agoranomic.assessor.dsl

import org.agoranomic.assessor.dsl.receivers.AssessmentReceiver
import org.agoranomic.assessor.dsl.receivers.AssessmentReceiverImpl
import org.agoranomic.assessor.lib.AssessmentData

/**
 * Represents a value that must be set exactly once.
 */
class DslValue<T> {
    private var currentValue: T? = null
    private var isInitialized: Boolean = false

    /**
     * Sets the value. Fails if the value has already been set.
     */
    fun set(value: T) {
        check(!isInitialized)
        currentValue = value
        isInitialized = true
    }

    /**
     * Gets the value. Fails if the value has not been set.
     */
    fun get(): T {
        check(isInitialized)
        return currentValue as T
    }

    /**
     * Gets the value, or a default if the value has not been set. Does not fail.
     */
    fun getOrElse(default: T): T {
        return if (isInitialized) currentValue as T else default
    }
}

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class AssessmentDSL

fun assessment(block: AssessmentReceiver.() -> Unit): AssessmentData {
    val receiver = AssessmentReceiverImpl()
    receiver.block()
    return receiver.compile()
}
