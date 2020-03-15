package org.agoranomic.assessor.dsl

import org.agoranomic.assessor.dsl.receivers.AssessmentReceiverImpl
import org.agoranomic.assessor.dsl.receivers.AssessmentReceiverInit
import org.agoranomic.assessor.lib.AssessmentData

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class AssessmentDsl

fun assessment(block: AssessmentReceiverInit): AssessmentData {
    val receiver = AssessmentReceiverImpl()
    receiver.block()
    return receiver.compile()
}
