package org.agoranomic.assessor.dsl

import org.agoranomic.assessor.dsl.receivers.AssessmentReceiverInit
import org.agoranomic.assessor.dsl.receivers.DefaultAssessmentCompiler
import org.agoranomic.assessor.lib.AssessmentData

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class AssessmentDsl

fun assessment(block: AssessmentReceiverInit): AssessmentData {
    return DefaultAssessmentCompiler().compile(block)
}
