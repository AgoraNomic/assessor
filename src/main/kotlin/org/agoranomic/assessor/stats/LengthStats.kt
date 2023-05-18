package org.agoranomic.assessor.stats

import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.resolve.ProposalResult
import org.agoranomic.assessor.lib.resolve.ResolutionData
import org.jetbrains.letsPlot.Stat
import org.jetbrains.letsPlot.geom.geomHistogram
import org.jetbrains.letsPlot.ggplot
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.label.ggtitle
import org.jetbrains.letsPlot.scale.scaleFillDiscrete
import org.jetbrains.letsPlot.scale.scaleXContinuous

fun buildLengthStats(
    resolutionsByProposal: Map<Proposal, List<ResolutionData>>,
) = buildStatistics {
    data class DataEntry(val words: Int, val adopted: Boolean)

    val proposalEntries =
        resolutionsByProposal
            .map { entry ->
                DataEntry(entry.key.textWords(), entry.value.any { it.result == ProposalResult.ADOPTED })
            }
            .partition { it.adopted }
            .let { (adopted, nonAdopted) -> adopted + nonAdopted } // Force order

    yieldGraph(
        name = "proposal_length_bins",
        ggplot() +
                geomHistogram(
                    data = mapOf(
                        "words" to proposalEntries.map { it.words },
                        "adopted" to proposalEntries.map { it.adopted }.map { if (it) "ADOPTED" else "NON-ADOPTED" },
                    ),
                    stat = Stat.bin(binWidth = 100, boundary = 0),
                ) {
                    x = "words"
                    fill = "adopted"
                } +
                scaleXContinuous(name = "Proposal words", limits = 0 to null) +
                scaleFillDiscrete(name = "Adopted?") +
                ggtitle("Count by proposal words") +
                ggsize(1200, 800)
    )
}
