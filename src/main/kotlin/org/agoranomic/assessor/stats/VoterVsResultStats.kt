package org.agoranomic.assessor.stats

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.resolve.ProposalResult
import org.agoranomic.assessor.lib.resolve.ResolutionData
import org.agoranomic.assessor.lib.vote.VoteKind
import org.jetbrains.letsPlot.Stat
import org.jetbrains.letsPlot.geom.geomBar
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.label.ggtitle
import org.jetbrains.letsPlot.letsPlot
import org.jetbrains.letsPlot.sampling.samplingNone
import org.jetbrains.letsPlot.scale.scaleFillDiscrete
import org.jetbrains.letsPlot.scale.scaleXDiscrete
import org.jetbrains.letsPlot.scale.scaleYContinuous

private fun calculateVoteToResultCounts(
    voters: List<Person>,
    proposalResolutionsByVoter: Map<Person, List<ResolutionData>>,
    targetResultFor: ProposalResult,
    targetResultAgainst: ProposalResult,
): Map<Person, Int> {
    return voters.associateWith { voter ->
        proposalResolutionsByVoter.getValue(voter).count { resolution ->
            val vote = resolution.votes.voteFor(voter)
            val result = resolution.result

            (vote == VoteKind.FOR && result == targetResultFor) ||
                    (vote == VoteKind.AGAINST && result == targetResultAgainst)
        }
    }
}


fun buildVoterResultStats(
    voters: List<Person>,
    proposalResolutionsByVoter: Map<Person, List<ResolutionData>>,
) = buildStatistics {
    val agreementCountsByVoter = calculateVoteToResultCounts(
        voters = voters,
        proposalResolutionsByVoter = proposalResolutionsByVoter,
        targetResultFor = ProposalResult.ADOPTED,
        targetResultAgainst = ProposalResult.REJECTED,
    )

    yieldData(
        "voter_result_agreement_rate",
        agreementCountsByVoter.mapValues { (voter, agreementCount) ->
            agreementCount.toDouble() / proposalResolutionsByVoter.getValue(voter).count().toDouble()
        }.also {}
    )

    val disagreementCountsByVoter = calculateVoteToResultCounts(
        voters = voters,
        proposalResolutionsByVoter = proposalResolutionsByVoter,
        targetResultFor = ProposalResult.REJECTED,
        targetResultAgainst = ProposalResult.ADOPTED,
    )

    yieldData(
        "voter_result_disagreement_rate",
        disagreementCountsByVoter.mapValues { (voter, disagreementCount) ->
            disagreementCount.toDouble() / proposalResolutionsByVoter.getValue(voter).count().toDouble()
        }.also {}
    )

    yieldGraph(
        "voter_result_agreement",
        letsPlot(
            data = mapOf(
                "voter" to voters.flatMap {
                    listOf(it.name, it.name)
                },
                "count" to voters.flatMap {
                    listOf(agreementCountsByVoter.getValue(it), disagreementCountsByVoter.getValue(it))
                },
                "kind" to voters.flatMap {
                    listOf("AGREEMENT", "DISAGREEMENT")
                },
            )
        ) +
                geomBar(stat = Stat.identity, sampling = samplingNone) {
                    x = "voter"
                    y = "count"
                    fill = "kind"
                } +
                ggtitle("Voter vs. result") +
                scaleXDiscrete(name = "Voter") +
                scaleYContinuous(name = "Count") +
                scaleFillDiscrete(name = "Kind") +
                ggsize(
                    voters.size * 30 + 10,
                    1000,
                ),
    )
}
