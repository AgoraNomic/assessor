package org.agoranomic.assessor.cli

import org.agoranomic.assessor.lib.ProposalResolutionMap
import org.agoranomic.assessor.lib.ReportConfig
import org.agoranomic.assessor.lib.jsonReport
import org.agoranomic.assessor.lib.report

interface AssessmentFormatter {
    fun format(assessment: ProposalResolutionMap): String
}

data class HumanReadableFormatter(val config: ReportConfig) : AssessmentFormatter {
    override fun format(assessment: ProposalResolutionMap): String {
        return report(assessment, config)
    }
}

object JsonFormatter : AssessmentFormatter {
    override fun format(assessment: ProposalResolutionMap): String {
        return jsonReport(assessment)
    }
}
