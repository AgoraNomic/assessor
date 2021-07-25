// Have to use also {} calls to satisfy compiler about type inference.
@file:Suppress("ControlFlowWithEmptyBody")

package org.agoranomic.assessor.stats

import jetbrains.letsPlot.Stat
import jetbrains.letsPlot.geom.geomBar
import jetbrains.letsPlot.ggsize
import jetbrains.letsPlot.label.ggtitle
import jetbrains.letsPlot.letsPlot
import jetbrains.letsPlot.sampling.samplingNone
import jetbrains.letsPlot.scale.scaleXDiscrete
import jetbrains.letsPlot.scale.scaleYContinuous
import org.agoranomic.assessor.lib.Person
import java.math.BigInteger

fun buildAuthorStats(
    authors: List<Person>,
    data: AssessmentsDerivedDataCache,
) = buildStatistics {
    val writtenCountsByAuthor = data.allProposalsData.countsByAuthor
    val adoptedProposalsByAuthor = data.adoptedProposalsData.groupedByAuthor
    val adoptedCountsByAuthor = data.adoptedProposalsData.countsByAuthor

    yieldData(
        "author_adopted",
        authors
            .associateWith {
                adoptedCountsByAuthor.getOrDefault(it, 0)
            }
            .also {}
    )

    yieldData(
        "author_adopted_rate",
        authors
            .associateWith {
                (adoptedCountsByAuthor.getOrDefault(it, 0)).toDouble() /
                        (writtenCountsByAuthor.getValue(it)).toDouble()
            }
            .also {},
    )

    val adoptedWordsByAuthor = authors.associateWith { author ->
        adoptedProposalsByAuthor[author]?.sumOf { it.textWords().toBigInteger() } ?: BigInteger.ZERO
    }

    yieldData(
        "author_adopted_words",
        adoptedWordsByAuthor,
    )

    yieldGraph(
        "author_written",
        letsPlot(data = mapOf<String, List<Any>>(
            "author" to authors.flatMap { listOf(it.name, it.name) },
            "count" to authors.flatMap {
                val adoptedCount = adoptedCountsByAuthor.getOrDefault(it, 0)
                val totalCount = writtenCountsByAuthor.getValue(it)
                listOf(adoptedCount, totalCount - adoptedCount)
            },
            "kind" to authors.flatMap { listOf("ADOPTED", "NON-ADOPTED") }
        )) +
                geomBar(stat = Stat.identity, sampling = samplingNone) {
                    x = "author"
                    y = "count"
                    fill = "kind"
                } +
                ggtitle("Adopted proposals by author") +
                scaleXDiscrete(name = "Author", limits = authors.map { it.name }) +
                scaleYContinuous(name = "Proposals") +
                ggsize(authors.size * 60 + 60, 1000),
    )

    data class AdoptedWordsEntry(val authorName: String, val totalWords: Int)

    val adoptedWordsEntries = adoptedWordsByAuthor.map {
        AdoptedWordsEntry(authorName = it.key.name, totalWords = it.value.intValueExact())
    }

    yieldGraph(
        "author_adopted_words",
        letsPlot(data = mapOf<String, List<Any>>(
            "author" to adoptedWordsEntries.map { it.authorName },
            "count" to adoptedWordsEntries.map { it.totalWords },
        )) +
                geomBar(stat = Stat.identity, sampling = samplingNone) {
                    x = "author"
                    y = "count"
                } +
                ggtitle("Adopted proposal words by author") +
                scaleXDiscrete(name = "Author", limits = authors.map { it.name }) +
                scaleYContinuous(name = "Adopted proposal words") +
                ggsize(authors.size * 60 + 60, 1000),
    )
}

fun buildCoauthorsStats(
    coauthors: List<Person>,
    data: AssessmentsDerivedDataCache,
) = buildStatistics {
    val writtenCountsByCoauthor = data.allProposalsData.countsByCoauthor
    val adoptedCountsByCoauthor = data.adoptedProposalsData.countsByCoauthor

    yieldData(
        "coauthor_adopted",
        coauthors
            .associateWith {
                adoptedCountsByCoauthor.getOrDefault(it, 0)
            }
            .also {},
    )

    yieldData(
        "coauthor_adopted_rate",
        coauthors
            .associateWith {
                (adoptedCountsByCoauthor.getOrDefault(it, 0)).toDouble() /
                        (writtenCountsByCoauthor.getValue(it)).toDouble()
            }
            .also {},
    )
}
