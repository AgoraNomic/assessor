package org.agoranomic.assessor.stats

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.resolve.ResolutionData
import org.agoranomic.assessor.lib.vote.machineIfPresent
import org.jetbrains.letsPlot.Stat
import org.jetbrains.letsPlot.geom.geomBar
import org.jetbrains.letsPlot.geom.geomText
import org.jetbrains.letsPlot.geom.geomTile
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.label.ggtitle
import org.jetbrains.letsPlot.letsPlot
import org.jetbrains.letsPlot.pos.positionDodge
import org.jetbrains.letsPlot.sampling.samplingNone
import org.jetbrains.letsPlot.scale.scaleFillGradient
import org.jetbrains.letsPlot.scale.scaleXDiscrete
import org.jetbrains.letsPlot.scale.scaleYContinuous
import org.jetbrains.letsPlot.scale.scaleYDiscrete

private data class EndorsementCountSpecification(
    val endorser: String,
    val endorsee: String,
    val count: Int,
)

private data class EndorsementTotals(
    val endorserTimesByPerson: ImmutableMap<String, Int>,
    val endorseeTimesByPerson: ImmutableMap<String, Int>,
) {
    init {
        require(endorserTimesByPerson.keys == endorseeTimesByPerson.keys)
    }

    val persons
        get() = endorseeTimesByPerson.keys

    constructor(
        endorserTimesByPerson: Map<String, Int>,
        endorseeTimesByPerson: Map<String, Int>,
    ) : this(
        endorserTimesByPerson = endorserTimesByPerson.toImmutableMap(),
        endorseeTimesByPerson = endorseeTimesByPerson.toImmutableMap(),
    )
}

private fun endorsementSpecificationsOf(
    proposalResolutions: List<ResolutionData>,
    excludeTotalVotes: Boolean,
): List<EndorsementCountSpecification> {
    return proposalResolutions
        .flatMap { resolution ->
            resolution
                .votes
                .voters
                .map { voter ->
                    voter.name to
                            resolution
                                .votes
                                .voteDescriptionsFor(voter)
                                .let {
                                    if (excludeTotalVotes) {
                                        it.takeIf { it.none { it.machineIfPresent?.kind == "part_of_all_vote" } }
                                    } else {
                                        it
                                    }
                                }
                                ?.mapNotNull { it.machineIfPresent }
                                ?.filter { it.kind == "endorsement" }
                                ?.also { check(it.size <= 1) }
                }
        }
        .groupBy { it.first }
        .mapValues { (_, v) -> v.mapNotNull { it.second }.flatten() }
        .mapValues { (_, v) -> v.groupBy { it.parameters.getValue("endorsee") }.mapValuesToCounts() }
        .flatMap { (endorser, endorseeMap) ->
            endorseeMap.map { (endorsee, count) ->
                EndorsementCountSpecification(
                    endorser = endorser,
                    endorsee = endorsee,
                    count = count
                )
            }
        }
}

private fun endorsementTotalsFor(
    voters: List<Person>,
    endorsementSpecifications: List<EndorsementCountSpecification>,
): EndorsementTotals {
    fun countEndorsementsGroupingBy(
        selector: (EndorsementCountSpecification) -> String,
    ): Map<String, Int> {
        return endorsementSpecifications
            .groupBy(selector)
            .mapValues { (_, v) -> v.sumOf { it.count } }
            .let { data ->
                voters.associate { it.name to data.getOrDefault(it.name, 0) }
            }
    }

    val endorserTimesByPerson = countEndorsementsGroupingBy { it.endorser }
    val endorseeTimesByPerson = countEndorsementsGroupingBy { it.endorsee }

    return EndorsementTotals(
        endorserTimesByPerson = endorserTimesByPerson,
        endorseeTimesByPerson = endorseeTimesByPerson,
    )
}

private fun StatisticsBuilderScope.yieldEndorsementsGraph(
    tag: String,
    voters: List<Person>,
    endorsementSpecifications: List<EndorsementCountSpecification>,
) {
    val voterNames = voters.map { it.name }

    val endorserData = endorsementSpecifications.map { it.endorser }
    val endorseeData = endorsementSpecifications.map { it.endorsee }
    val countData = endorsementSpecifications.map { it.count }

    yieldGraph(
        "endorsement_counts_${tag}",
        letsPlot(
            data = mapOf(
                "endorser" to endorserData,
                "endorsee" to endorseeData,
                "count" to countData,
            ),
        ) {
            x = "endorsee"
            y = "endorser"
        } +
                geomTile(
                    showLegend = true,
                ) {
                    fill = "count"
                } +
                geomText {
                    label = "count"
                } +
                scaleFillGradient(
                    low = "#EDEDED",
                    high = "#326C81",
                ) +
                ggtitle("Endorsement counts") +
                scaleXDiscrete(
                    name = "Endorsee",
                    limits = voterNames,
                ) +
                scaleYDiscrete(
                    name = "Endorser",
                    limits = voterNames.reversed(),
                ) +
                ggsize(voters.size * 40 + 60, voters.size * 40 + 70),
    )
}

private fun StatisticsBuilderScope.yieldEndorseeVsEndorserGraph(
    tag: String,
    endorsementTotals: EndorsementTotals,
) {
    data class SingleEntrySpecification(
        val person: String,
        val count: Int,
        val kind: String,
    )

    val endorseeEntries = endorsementTotals.endorseeTimesByPerson.map {
        SingleEntrySpecification(
            person = it.key,
            count = it.value,
            kind = "ENDORSEE",
        )
    }

    val endorserEntries = endorsementTotals.endorserTimesByPerson.map {
        SingleEntrySpecification(
            person = it.key,
            count = it.value,
            kind = "ENDORSER",
        )
    }

    val allEntries = endorseeEntries + endorserEntries

    yieldGraph(
        "endorsee_endorser_${tag}",
        letsPlot(
            data = mapOf(
                "person" to allEntries.map { it.person },
                "count" to allEntries.map { it.count },
                "kind" to allEntries.map { it.kind },
            ),
        ) +
                geomBar(stat = Stat.identity, position = positionDodge(), sampling = samplingNone) {
                    x = "person"
                    y = "count"
                    fill = "kind"
                } +
                ggtitle("Endorsements") +
                scaleXDiscrete("Person") +
                scaleYContinuous("Count") +
                ggsize(endorsementTotals.persons.size * 60 + 60, 1000),
    )
}

private fun StatisticsBuilderScope.yieldEndorsementCountsStatistic(
    tag: String,
    endorsementTotals: EndorsementTotals,
) {
    yieldData(
        "voter_endorsee_${tag}_times",
        endorsementTotals.endorseeTimesByPerson.mapKeys { (k, _) -> Person(name = k) },
    )

    yieldData(
        "voter_endorser_${tag}_times",
        endorsementTotals.endorserTimesByPerson.mapKeys { (k, _) -> Person(name = k) },
    )
}

private fun StatisticsBuilderScope.doYieldEndorsementStats(
    tag: String,
    voters: List<Person>,
    endorsementsData: List<EndorsementCountSpecification>,
) {
    val endorsementTotals = endorsementTotalsFor(voters, endorsementsData)

    yieldEndorsementsGraph(tag, voters, endorsementsData)
    yieldEndorseeVsEndorserGraph(tag, endorsementTotals)
    yieldEndorsementCountsStatistic(tag, endorsementTotals)
}

fun buildEndorsementStats(voters: List<Person>, proposalResolutions: List<ResolutionData>) = buildStatistics {
    val allEndorsementsData = endorsementSpecificationsOf(proposalResolutions, excludeTotalVotes = false)
    val nonTotalEndorsementsData = endorsementSpecificationsOf(proposalResolutions, excludeTotalVotes = true)

    doYieldEndorsementStats("all", voters, allEndorsementsData)
    doYieldEndorsementStats("non_total", voters, nonTotalEndorsementsData)
}
