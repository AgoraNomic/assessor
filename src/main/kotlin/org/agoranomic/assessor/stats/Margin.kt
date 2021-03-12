package org.agoranomic.assessor.stats

import jetbrains.letsPlot.Stat
import jetbrains.letsPlot.geom.geom_bar
import jetbrains.letsPlot.geom.geom_boxplot
import jetbrains.letsPlot.ggsize
import jetbrains.letsPlot.label.ggtitle
import jetbrains.letsPlot.lets_plot
import jetbrains.letsPlot.sampling.sampling_none
import jetbrains.letsPlot.scale.scale_x_discrete
import jetbrains.letsPlot.scale.scale_y_continuous
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.resolve.ProposalResult
import org.agoranomic.assessor.lib.resolve.ResolutionData
import java.math.BigDecimal

private fun marginOf(it: ResolutionData): BigDecimal {
    return it.aiStrengths.strengthFor.raw.toBigDecimal() -
            it.aiStrengths.strengthAgainst.raw.toBigDecimal() * it.proposal.ai.raw
}

private fun calculateMarginStats(data: List<ResolutionData>): List<BigDecimal> {
    return data.map { marginOf(it) }
}

private fun Map<Person, List<ResolutionData>>.calculateMargins(): Map<Person, List<BigDecimal>> {
    return this.filterValues { it.isNotEmpty() }.mapValues { (_, v) -> calculateMarginStats(v) }
}

fun buildMarginStats(authors: List<Person>, resolutions: List<ResolutionData>) = buildStatistics {
    val resolutionsByAuthor = resolutions.groupBy { it.proposal.author }

    val averageAllMarginByAuthor =
        resolutionsByAuthor
            .calculateMargins()

    val averageAdoptedMarginByAuthor =
        resolutionsByAuthor
            .mapValues { (_, v) -> v.filter { it.result == ProposalResult.ADOPTED } }
            .calculateMargins()

    val averageRejectedMarginByAuthor =
        resolutionsByAuthor
            .mapValues { (_, v) -> v.filter { it.result == ProposalResult.REJECTED } }
            .calculateMargins()

    yieldSingleMarginStat(
        authors = authors,
        marginsByAuthor = averageAllMarginByAuthor,
        kind = "all",
    )

    yieldSingleMarginStat(
        authors = authors,
        marginsByAuthor = averageAdoptedMarginByAuthor,
        kind = "adopted",
    )

    yieldSingleMarginStat(
        authors = authors,
        marginsByAuthor = averageRejectedMarginByAuthor,
        kind = "rejected",
    )
}

private fun StatisticsBuilderScope.yieldSingleMarginStat(
    authors: List<Person>,
    marginsByAuthor: Map<Person, List<BigDecimal>>,
    kind: String,
) {
    val orderedMarginsByAuthor =
        authors
            .filter { it in marginsByAuthor.keys }
            .associateWith { marginsByAuthor.getValue(it) }

    yieldMarginGraphs(
        authors,
        orderedMarginsByAuthor,
        name = "author_avg_${kind}_strength_margin",
        barGraphTitle = "Average ${kind.toUpperCase()} voting strength margin by author",
        boxPlotTitle = "${kind.toUpperCase()} strength margins by author",
    )

    val averageMarginByAuthor = orderedMarginsByAuthor.mapValues { (_, v) ->
        v.map { it.toDouble() }.onEach { check(it.isFinite()) }.average()
    }

    yieldData(
        "author_avg_${kind}_strength_margin",
        averageMarginByAuthor,
    )
}

private fun StatisticsBuilderScope.yieldMarginGraphs(
    authors: List<Person>,
    marginsByAuthor: Map<Person, List<BigDecimal>>,
    name: String,
    barGraphTitle: String,
    boxPlotTitle: String,
) {
    data class MarginAverageEntry(val authorName: String, val averageMargin: Double)

    val marginAverageEntries = marginsByAuthor.map { entry ->
        MarginAverageEntry(
            authorName = entry.key.name,
            averageMargin = entry.value.map { it.toDouble() }.onEach { check(it.isFinite()) }.average(),
        )
    }

    yieldGraph(
        name,
        lets_plot(mapOf(
            "author" to marginAverageEntries.map { it.authorName },
            "margin" to marginAverageEntries.map { it.averageMargin },
        )) +
                geom_bar(stat = Stat.identity, sampling = sampling_none) {
                    x = "author"
                    y = "margin"
                } +
                ggsize(marginsByAuthor.keys.size * 60 + 60, 1000) +
                scale_x_discrete(name = "Author", limits = authors.map { it.name }) +
                scale_y_continuous(name = "Average margin") +
                ggtitle(barGraphTitle)
    )

    val boxPlotData: List<Pair<String, Double>> = marginsByAuthor.flatMap { (author, margins) ->
        margins.map { margin -> author.name to margin.toDouble().also { check(it.isFinite()) } }
    }

    yieldGraph(
        name + "_box_plot",
        lets_plot(mapOf(
            "author" to boxPlotData.map { it.first },
            "margin" to boxPlotData.map { it.second },
        )) +
                geom_boxplot(sampling = sampling_none) {
                    x = "author"
                    y = "margin"
                } +
                ggsize(marginsByAuthor.keys.size * 60 + 60, 1000) +
                scale_x_discrete(name = "Author", limits = authors.map { it.name }) +
                scale_y_continuous(name = "Margin") +
                ggtitle(boxPlotTitle)
    )
}
