package org.agoranomic.assessor.cli

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.report.*
import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap

data class AssessmentFormatOutput(val outputsByName: ImmutableMap<String, String>) {
    constructor(outputsByName: Map<String, String>) : this(outputsByName = outputsByName.toImmutableMap())
}

interface AssessmentFormatter {
    fun formatBatch(assessments: Map<String, ProposalResolutionMap>): AssessmentFormatOutput
}

abstract class AssessmentIndependentFormatter : AssessmentFormatter {
    final override fun formatBatch(assessments: Map<String, ProposalResolutionMap>): AssessmentFormatOutput {
        return AssessmentFormatOutput(assessments.mapValues { (_, v) -> formatSingle(v) })
    }

    abstract fun formatSingle(assessment: ProposalResolutionMap): String
}

data class HumanReadableFormatter(val config: ReadableReportConfig) : AssessmentIndependentFormatter() {
    override fun formatSingle(assessment: ProposalResolutionMap): String {
        return readableReport(assessment, config)
    }
}

object JsonFormatter : AssessmentIndependentFormatter() {
    override fun formatSingle(assessment: ProposalResolutionMap): String {
        return jsonReport(assessment)
    }
}

object RewardsFormatter : AssessmentIndependentFormatter() {
    override fun formatSingle(assessment: ProposalResolutionMap): String {
        return rewardsReport(calculateRewards(assessment))
    }
}

object StrengthAuditFormatter : AssessmentIndependentFormatter() {
    override fun formatSingle(assessment: ProposalResolutionMap): String {
        return strengthAuditReport(assessment)
    }
}
