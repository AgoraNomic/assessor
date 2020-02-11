package org.agoranomic.assessor.dsl

import org.agoranomic.assessor.dsl.receivers.AssessmentReceiver
import org.agoranomic.assessor.dsl.receivers.AssessmentReceiverImpl
import org.agoranomic.assessor.lib.AssessmentData

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class AssessmentDSL

fun assessment(block: AssessmentReceiver.() -> Unit): AssessmentData {
    val receiver = AssessmentReceiverImpl()
    receiver.block()
    return receiver.compile()
}
