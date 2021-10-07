package org.agoranomic.assessor.cli

import jetbrains.datalore.plot.PlotSvgExport
import jetbrains.letsPlot.GGBunch
import jetbrains.letsPlot.intern.Plot
import jetbrains.letsPlot.intern.toSpec
import org.agoranomic.assessor.lib.filterKeysNotNull
import org.agoranomic.assessor.lib.resolve.AssessmentData
import org.agoranomic.assessor.lib.vote.VoteKind
import org.agoranomic.assessor.stats.*

private fun <K, V> Iterable<Map.Entry<K, V>>.toMap() = associate { it.toPair() }

private fun buildAllStats(assessments: List<AssessmentData>): List<Statistic> {
    val dataWithCache = AssessmentsDerivedDataCache(assessments)

    val sortedAuthors =
        dataWithCache
            .allAuthors
            .filterNotNull()
            .sortedByDescending { dataWithCache.allProposalsData.countsByAuthor.getValue(it) }

    val sortedCoauthors =
        dataWithCache.allCoauthors.sortedByDescending { dataWithCache.allProposalsData.countsByCoauthor.getValue(it) }

    val sortedVoters = dataWithCache.allVoters.sortedByDescending { dataWithCache.voteCountsByVoter.getValue(it) }

    val allStatistics = mutableListOf<Statistic>()

    fun addStatistics(statistics: List<Statistic>) {
        allStatistics += statistics
    }

    addStatistics(buildStatistics {
        yieldData(
            "author_written",
            dataWithCache.allProposalsData.countsByAuthor.entries.sortedByDescending { it.value }.toMap()
                .filterKeysNotNull(),
        )

        yieldData(
            "coauthor_written",
            dataWithCache.allProposalsData.countsByCoauthor.entries.sortedByDescending { it.value }.toMap(),
        )

        yieldData("voter_votes", dataWithCache.voteCountsByVoter.entries.sortedByDescending { it.value }.toMap())
    })

    addStatistics(
        buildAuthorStats(
            authors = sortedAuthors,
            data = dataWithCache,
        )
    )

    addStatistics(
        buildCoauthorsStats(
            coauthors = sortedCoauthors,
            data = dataWithCache,
        )
    )

    addStatistics(
        buildEndorsementStats(
            voters = sortedVoters,
            proposalResolutions = dataWithCache.proposalResolutions,
        )
    )

    addStatistics(
        buildVotingStrengthStats(
            voters = sortedVoters,
            proposalResolutionsByVoter = dataWithCache.proposalResolutionsByVoter,
        )
    )

    addStatistics(
        buildVoterResultStats(
            voters = sortedVoters,
            proposalResolutionsByVoter = dataWithCache.proposalResolutionsByVoter,
        )
    )

    addStatistics(
        buildVoterMutualAgreementStats(
            voters = sortedVoters,
            proposalResolutions = dataWithCache.proposalResolutions,
        )
    )

    addStatistics(
        buildVoteKindStats(
            voters = sortedVoters,
            voteKindsForCountsAndRates = VoteKind.values().toSet(),
            data = dataWithCache,
        )
    )

    addStatistics(
        buildVoterAuthorAgreementStats(
            voters = sortedVoters,
            authors = sortedAuthors,
            resolutionsByProposal = dataWithCache.resolutionsByProposal,
            votesByVoter = dataWithCache.voteCountsByVoter,
        )
    )

    addStatistics(
        buildVoterDeterminationStats(
            voters = sortedVoters,
            data = dataWithCache,
        )
    )

    addStatistics(buildMarginStats(sortedAuthors, dataWithCache.proposalResolutions))

    addStatistics(buildLengthStats(resolutionsByProposal = dataWithCache.resolutionsByProposal))

    return allStatistics
}

object StatisticsFormatter : AssessmentFormatter {
    override fun formatBatch(assessments: List<AssessmentData>): AssessmentFormatOutput {
        val allStatistics = buildAllStats(assessments)

        val overallMap = mutableMapOf<String, AssessmentOutputData>()
        val graphsMap = mutableMapOf<String, AssessmentOutputData>()

        for (statistic in allStatistics) {
            @Suppress("UNUSED_VARIABLE")
            val ensureExhaustive = when (statistic) {
                is Statistic.KeyValuePairs -> {
                    overallMap[statistic.name] = formatKeyValuePairs(
                        statistic = statistic.data,
                        keyName = statistic.keyName,
                        valueName = statistic.valueName,
                    ).let {
                        AssessmentOutputData.Text(it)
                    }
                }

                is Statistic.Graph -> {
                    graphsMap[statistic.name] =
                        AssessmentOutputData.Bytes(
                            PlotSvgExport.buildSvgImageFromRawSpecs(
                                when (val plot = statistic.plot) {
                                    is Plot -> plot.toSpec()
                                    is GGBunch -> plot.toSpec()
                                    else -> error("Unknown plot type")
                                },
                            ).toByteArray(Charsets.UTF_8),
                            "svg",
                        )
                }
            }
        }

        overallMap["graphs"] = AssessmentOutputData.Nested(graphsMap)
        return AssessmentFormatOutput(AssessmentOutputData.Nested(overallMap))
    }
}
