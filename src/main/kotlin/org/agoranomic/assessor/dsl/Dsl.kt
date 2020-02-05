package org.agoranomic.assessor.dsl

import org.agoranomic.assessor.dsl.receivers._AssessmentReceiver
import org.agoranomic.assessor.lib.AssessmentData

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class AssessmentDSL

fun assessment(block: _AssessmentReceiver.() -> Unit): AssessmentData {
    val receiver = _AssessmentReceiver()
    receiver.block()
    return receiver.compile()
}
