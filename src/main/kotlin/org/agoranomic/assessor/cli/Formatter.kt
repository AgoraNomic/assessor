package org.agoranomic.assessor.cli

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.proposal.proposal_set.toProposalSet
import org.agoranomic.assessor.lib.report.*
import org.agoranomic.assessor.lib.resolve.AssessmentData
import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap
import org.agoranomic.assessor.lib.resolve.resolve

private class BytesHolder(data: ByteArray) {
    private val data: ByteArray = data.copyOf()

    fun bytes(): ByteArray {
        return data.copyOf()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is BytesHolder) return false

        return this.data contentEquals other.data
    }

    override fun hashCode(): Int {
        return this.data.contentHashCode()
    }

    override fun toString(): String {
        return this.data.contentToString()
    }
}

sealed class AssessmentOutputData {
    data class Text(val data: String) : AssessmentOutputData()

    data class Bytes private constructor(private val data: BytesHolder, val extension: String) :
        AssessmentOutputData() {
        constructor(data: ByteArray, extension: String) : this(BytesHolder(data), extension)

        fun bytes(): ByteArray {
            return data.bytes()
        }
    }

    data class Nested(val subData: ImmutableMap<String, AssessmentOutputData>) : AssessmentOutputData() {
        constructor(subData: Map<String, AssessmentOutputData>) : this(subData.toImmutableMap())
    }
}

data class AssessmentFormatOutput(val outputs: AssessmentOutputData.Nested)

interface AssessmentFormatter {
    fun formatBatch(assessments: List<AssessmentData>): AssessmentFormatOutput
}

abstract class ResolvedAssessmentFormatter : AssessmentFormatter {
    final override fun formatBatch(assessments: List<AssessmentData>): AssessmentFormatOutput {
        return formatResolvedBatch(assessments.associate { it.metadata.name to resolve(it) })
    }

    protected abstract fun formatResolvedBatch(assessments: Map<String, ProposalResolutionMap>): AssessmentFormatOutput
}

abstract class AssessmentIndependentTextFormatter : ResolvedAssessmentFormatter() {
    final override fun formatResolvedBatch(assessments: Map<String, ProposalResolutionMap>): AssessmentFormatOutput {
        return AssessmentFormatOutput(
            AssessmentOutputData.Nested(
                assessments.mapValues { (_, v) -> AssessmentOutputData.Text(formatSingle(v)) }
            ),
        )
    }

    abstract fun formatSingle(assessment: ProposalResolutionMap): String
}

data class HumanReadableFormatter(val config: ReadableReportConfig) : AssessmentIndependentTextFormatter() {
    override fun formatSingle(assessment: ProposalResolutionMap): String {
        return readableReport(assessment, config)
    }
}

object JsonFormatter : AssessmentIndependentTextFormatter() {
    override fun formatSingle(assessment: ProposalResolutionMap): String {
        return jsonReport(assessment)
    }
}

object RewardsFormatter : AssessmentIndependentTextFormatter() {
    override fun formatSingle(assessment: ProposalResolutionMap): String {
        return rewardsReport(calculateRewards(assessment))
    }
}

object StrengthAuditFormatter : AssessmentIndependentTextFormatter() {
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
            resolutionsByProposal
                .asIterable()
                .associate { (proposal, resolutions) ->
                    val text = run {
                        val resolutionsText = resolutions.joinToString("\n") { resolution ->
                            val resolutionText = renderReadableProposalResolution(
                                reportConfig,
                                proposal,
                                resolution.resolutionOf(proposal.number),
                                resolution.votingStrengthsFor(proposal.number),
                            )

                            val metadataText = if (resolution.metadata.urls != null) {
                                "\nResolved at: ${resolution.metadata.urls.joinToString(" and ")}\n"
                            } else {
                                ""
                            }

                            resolutionText + metadataText
                        }

                        resolutionsText + "\n" + renderProposalText(proposal)
                    }

                    proposal.number.toString() to AssessmentOutputData.Text(text)
                }
                .let {
                    AssessmentOutputData.Nested(it)
                }
        )
    }
}
