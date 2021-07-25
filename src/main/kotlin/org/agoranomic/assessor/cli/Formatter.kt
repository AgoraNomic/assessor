package org.agoranomic.assessor.cli

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.proposal.proposal_set.toProposalSet
import org.agoranomic.assessor.lib.report.*
import org.agoranomic.assessor.lib.resolve.AssessmentData
import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap
import org.agoranomic.assessor.lib.resolve.resolve

data class AssessmentFormatOutput(val outputsByName: ImmutableMap<String, String>) {
    constructor(outputsByName: Map<String, String>) : this(outputsByName = outputsByName.toImmutableMap())
}

interface AssessmentFormatter {
    fun formatBatch(assessments: List<AssessmentData>): AssessmentFormatOutput
}

abstract class ResolvedAssessmentFormatter : AssessmentFormatter {
    final override fun formatBatch(assessments: List<AssessmentData>): AssessmentFormatOutput {
        return formatResolvedBatch(assessments.associate { it.metadata.name to resolve(it) })
    }

    protected abstract fun formatResolvedBatch(assessments: Map<String, ProposalResolutionMap>): AssessmentFormatOutput
}

abstract class AssessmentIndependentFormatter : ResolvedAssessmentFormatter() {
    final override fun formatResolvedBatch(assessments: Map<String, ProposalResolutionMap>): AssessmentFormatOutput {
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

data class ProposalsReadableFormatter(
    private val reportConfig: ReadableProposalReportConfig,
) : ResolvedAssessmentFormatter() {
    override fun formatResolvedBatch(assessments: Map<String, ProposalResolutionMap>): AssessmentFormatOutput {
        val allResolutions = assessments.values
        val allProposals = allResolutions.flatMap { it.proposals }.toProposalSet()

        val resolutionsByProposal =
            allProposals
                .sortedBy { it.number }
                .associateWith { proposal -> allResolutions.filter { it.proposals.contains(proposal.number) } }
                .mapValues { (_, v) -> v.sortedBy { it.metadata.name } }

        return AssessmentFormatOutput(
            resolutionsByProposal.asIterable().associate { (proposal, resolutions) ->
                proposal.number.toString() to
                        resolutions.joinToString("\n") { resolution ->
                            renderReadableProposalResolution(
                                reportConfig,
                                proposal,
                                resolution.resolutionOf(proposal.number),
                                resolution.votingStrengthsFor(proposal.number),
                            ) + "\nResolved at: ${resolution.metadata.url}\n"
                        } +
                        "\n" +
                        renderProposalText(proposal)
            }
        )
    }
}
