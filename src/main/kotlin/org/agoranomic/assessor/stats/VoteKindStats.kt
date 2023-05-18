package org.agoranomic.assessor.stats

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.resolve.ResolutionData
import org.agoranomic.assessor.lib.vote.VoteKind
import org.jetbrains.letsPlot.Stat
import org.jetbrains.letsPlot.geom.geomBar
import org.jetbrains.letsPlot.geom.geomHLine
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.label.ggtitle
import org.jetbrains.letsPlot.letsPlot
import org.jetbrains.letsPlot.pos.positionStack
import org.jetbrains.letsPlot.sampling.samplingNone
import org.jetbrains.letsPlot.scale.scaleFillDiscrete
import org.jetbrains.letsPlot.scale.scaleXDiscrete
import org.jetbrains.letsPlot.scale.scaleYContinuous
import org.jetbrains.letsPlot.themes.theme

private fun countVotesOfKindByVoter(
    voteKind: VoteKind,
    voters: Set<Person>,
    resolutions: List<ResolutionData>,
): Map<Person, Int> {
    return voters.associateWith { voter ->
        resolutions.count { resolution ->
            resolution.votes.voters.contains(voter) && (resolution.votes.voteFor(voter) == voteKind)
        }
    }
}

private fun StatisticsBuilderScope.yieldVoteKindCountsStat(
    voters: List<Person>,
    voteKinds: Set<VoteKind>,
    voteCountsByVoterByVoteKind: Map<VoteKind, Map<Person, Int>>,
) {
    for (voteKind in voteKinds) {
        yieldData(
            "voter_votes_${voteKind.name.uppercase()}",
            voters.associateWith { voteCountsByVoterByVoteKind.getValue(voteKind).getValue(it) }.also {},
        )
    }
}

private fun StatisticsBuilderScope.yieldVoteKindRatesStat(
    voters: List<Person>,
    voteKinds: Set<VoteKind>,
    voteCountRatesByVoterByVoteKind: Map<VoteKind, Map<Person, Double>>,
) {
    for (voteKind in voteKinds) {
        // Must use also {} to satisfy type inference.
        @Suppress("ControlFlowWithEmptyBody")
        yieldData(
            "voter_votes_${voteKind.name.uppercase()}_rate",
            voters.associateWith { voteCountRatesByVoterByVoteKind.getValue(voteKind).getValue(it) }.also {},
        )
    }
}

private fun StatisticsBuilderScope.yieldVoteKindsByVoterGraph(
    voters: List<Person>,
    voteCountsByVoterByVoteKind: Map<VoteKind, Map<Person, Int>>,
    proposalResolutionsCount: Int,
) {
    data class VoterVoteKindCountSpecification(
        val voter: Person,
        val voteCount: Int,
        val kind: VoteKind,
    )

    val voteKindOrder = listOf(VoteKind.FOR, VoteKind.AGAINST, VoteKind.PRESENT)

    val voterKindSpecificationList =
        voters
            .flatMap { voter ->
                VoteKind.values().map { voteKind ->
                    VoterVoteKindCountSpecification(
                        voter = voter,
                        kind = voteKind,
                        voteCount = voteCountsByVoterByVoteKind.getValue(voteKind).getValue(voter),
                    )
                }
            }
            .sortedBy { voteKindOrder.indexOf(it.kind) }

    val voterKindData = mapOf(
        "voter" to voterKindSpecificationList.map { it.voter.name },
        "count" to voterKindSpecificationList.map { it.voteCount },
        "kind" to voterKindSpecificationList.map { it.kind.name },
    )

    yieldGraph(
        "vote_kinds",
        letsPlot(voterKindData) +
                geomBar(
                    stat = Stat.identity,
                    sampling = samplingNone,
                    position = positionStack(),
                ) {
                    x = "voter"
                    y = "count"
                    fill = "kind"
                } +
                ggsize(width = voters.size * 45 + 10, height = 500) +
                scaleFillDiscrete(name = "Vote Kind",
                    limits = listOf("FOR", "AGAINST", "PRESENT")
                ) +
                ggtitle("Votes by voter") +
                scaleXDiscrete(
                    name = "Voter",
                    limits = voters.map { it.name },
                ) +
                scaleYContinuous(
                    name = "Votes",
                    limits = 0 to proposalResolutionsCount,
                ) +
                theme().legendPositionTop() +
                geomHLine(yintercept = proposalResolutionsCount, linetype = "dashed", color = "red"),
    )
}

fun buildVoteKindStats(
    voters: List<Person>,
    voteKindsForCountsAndRates: Set<VoteKind>,
    data: AssessmentsDerivedDataCache,
) = buildStatistics {
    val voteCountsByVoterByVoteKind = VoteKind.values().associateWith { kind ->
        countVotesOfKindByVoter(kind, voters.toSet(), data.proposalResolutions)
    }

    val voteCountRatesByVoterByVoteKind =
        voteCountsByVoterByVoteKind
            .mapValues { (voteKind, countsMap) ->
                countsMap.mapValues { (voter, count) ->
                    count.toDouble() / data.voteCountsByVoter.getValue(voter).toDouble()
                }
            }

    yieldVoteKindCountsStat(
        voters = voters,
        voteKinds = voteKindsForCountsAndRates,
        voteCountsByVoterByVoteKind = voteCountsByVoterByVoteKind,
    )

    yieldVoteKindRatesStat(
        voters = voters,
        voteKinds = voteKindsForCountsAndRates,
        voteCountRatesByVoterByVoteKind = voteCountRatesByVoterByVoteKind,
    )

    yieldVoteKindsByVoterGraph(
        voters = voters,
        voteCountsByVoterByVoteKind = voteCountsByVoterByVoteKind,
        proposalResolutionsCount = data.proposalResolutions.size,
    )
}
