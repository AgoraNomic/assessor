package org.agoranomic.assessor.stats

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.resolve.ResolutionData
import org.agoranomic.assessor.lib.vote.VoteKind
import org.jetbrains.letsPlot.bistro.corr.CorrPlot
import org.jetbrains.letsPlot.geom.geomTile
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.letsPlot
import org.jetbrains.letsPlot.scale.scaleFillGradient2
import org.jetbrains.letsPlot.scale.scaleXDiscrete
import org.jetbrains.letsPlot.scale.scaleYDiscrete

fun buildVoterAuthorAgreementStats(
    voters: List<Person>,
    authors: List<Person>,
    resolutionsByProposal: Map<Proposal, List<ResolutionData>>,
    votesByVoter: Map<Person, Int>,
) = buildStatistics {
    data class VoterAuthorSpecification(
        val voter: Person,
        val author: Person,
    )

    val voterAuthorAgreementRates =
        voters
            .flatMap { voter ->
                authors.map { author ->
                    VoterAuthorSpecification(voter = voter, author = author)
                }
            }
            .map { specification ->
                specification to
                        resolutionsByProposal
                            .asIterable()
                            .filter { it.key.author == specification.author }
                            .flatMap { it.value }
                            .mapNotNull {
                                if (it.votes.voters.contains(specification.voter))
                                    when (it.votes.voteFor(specification.voter)) {
                                        VoteKind.FOR -> +1
                                        VoteKind.AGAINST -> -1
                                        VoteKind.PRESENT -> 0
                                    }
                                else
                                    null
                            }
                            .average()
            }

    val authorDataList = voterAuthorAgreementRates.map { it.first.author }
    val voterDataList = voterAuthorAgreementRates.map { it.first.voter }
    val rateDataList = voterAuthorAgreementRates.map { it.second }

    yieldGraph(
        "voter_author_agreement_rates",
        letsPlot() +
                geomTile(
                    data = mapOf(
                        "voter" to voterDataList.map { it.name },
                        "author" to authorDataList.map { it.name },
                        "rate" to rateDataList,
                    ),
                    showLegend = true,
                ) {
                    x = "author"
                    y = "voter"
                    fill = "rate"
                } +
                scaleFillGradient2(
                    name = "Agreement",
                    low = "#B3412C",
                    mid = "#EDEDED",
                    high = "#326C81",
                    limits = -1.0 to +1.0,
                ) +
                scaleXDiscrete(
                    name = "Author",
                    limits = authors.map { it.name },
                ) +
                scaleYDiscrete(
                    name = "Voter",
                    limits = voterDataList.distinct().sortedBy { votesByVoter.getValue(it) }.map { it.name },
                ) +
                ggsize(authors.size * 35 + 60, voters.size * 30 + 10),
    )
}

fun buildVoterMutualAgreementStats(
    voters: List<Person>,
    proposalResolutions: List<ResolutionData>,
) = buildStatistics {
    yieldGraph(
        "voter_agreement",
        CorrPlot(
            data = voters
                .associateWith { voter ->
                    proposalResolutions.map { resolution ->
                        if (resolution.votes.voters.contains(voter))
                            when (resolution.votes.voteFor(voter)) {
                                VoteKind.FOR -> 1
                                VoteKind.PRESENT -> 0
                                VoteKind.AGAINST -> -1
                            }
                        else
                            null
                    }
                }
                .mapKeys { (voter, _) -> voter.name },
            title = "Voter agreement",
        ).tiles().build(),
    )
}
