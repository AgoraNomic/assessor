package org.agoranomic.assessor.lib.report

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonObject
import org.agoranomic.assessor.lib.proposal.*
import org.agoranomic.assessor.lib.proposal.proposal_set.toProposalSet
import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap
import org.agoranomic.assessor.lib.resolve.ProposalResult
import org.agoranomic.assessor.lib.resolve.ResolutionData
import org.agoranomic.assessor.lib.resolve.adoptedProposals
import org.agoranomic.assessor.lib.vote.SimplifiedSingleProposalVoteMap
import org.agoranomic.assessor.lib.vote.VoteKind
import org.agoranomic.assessor.lib.voting_strength.VotingStrength
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthTrailForPersons
import kotlin.math.max

private fun tableRowText(maxLengths: List<Int>, row: List<String>): String {
    require(maxLengths.size == row.size)

    return row.zip(maxLengths) { item, maxLength -> item.padEnd(maxLength) }.joinToString("  ")
}

private fun renderTable(columnNames: List<String>, dataRows: List<List<String>>) = buildString {
    dataRows.forEach { require(it.size == columnNames.size) }

    val maxLengths = columnNames.indices.map { idx ->
        max(columnNames[idx].length, dataRows.map { it[idx] }.maxByOrNull { it.length }?.length ?: 0)
    }

    val headerText = tableRowText(maxLengths, columnNames)

    appendLine(headerText)
    appendLine("-".repeat(headerText.length))

    for (dataRow in dataRows) {
        appendLine(tableRowText(maxLengths, dataRow))
    }
}

private fun renderSummaryTable(resolutionMap: ProposalResolutionMap): String {
    val columnNames = listOf("ID", "Title", "Result")

    val dataRows = resolutionMap.proposals.map {
        listOf(it.number.toString(), it.title, resolutionMap.resolutionOf(it.number).result.readableName)
    }

    return renderTable(columnNames, dataRows)
}

private fun header() = "I hereby resolve the Agoran decisions to adopt the below proposals."

private fun renderQuorum(quorum: AssessmentQuorum) = "The quorum for all below decisions was ${quorum.count()}."

fun renderPopularProposalsInfo(resolutionMap: ProposalResolutionMap): String? {
    val eligibleProposals =
        resolutionMap.proposals
            .filter { resolutionMap.resolutionOf(it.number).result == ProposalResult.ADOPTED }
            .filter {
                val versionedData = it.versionedData
                versionedData is ProposalSponsoredData && versionedData.sponsored
            }
            .toProposalSet()

    val popularityMap = eligibleProposals.associate {
        it.number to popularityOf(resolutionMap.resolutionOf(it.number).votes)
    }

    val maxPopularity = popularityMap.values.maxOrNull() ?: return null

    val maxPopularityProposals = eligibleProposals.filter { popularityMap.getValue(it.number) == maxPopularity }
    check(maxPopularityProposals.isNotEmpty())

    return "The following sponsored adopted proposals have the highest popularity " +
            "(${formatPopularity(maxPopularity)}): " +
            maxPopularityProposals.joinToString(separator = ", ", postfix = ".") {
                "${it.number} (by ${it.author.name})"
            }
}

private fun <Chamber : AnyMinistry> renderClassAndChamberHeader(
    classAndChamber: ProposalClassAndChamber<Chamber>,
): String {
    return classAndChamber.accept(object : ProposalClassAndChamberMapper<Chamber, String> {
        override fun visitClassless() = ""

        override fun visitDemocratic() = "CLASS: DEMOCRATIC\n"

        override fun visitOrdinary(chamber: Chamber) =
            "CLASS: ORDINARY\nCHAMBER: ${chamber.readableName.toUpperCase()}\n"
    })
}

private fun renderSponsoredHeader(sponsored: Boolean): String {
    return "SPONSORED: ${if (sponsored) "YES" else "NO"}\n"
}

private fun renderProposalV1Header(data: ProposalDataV1) = renderClassAndChamberHeader(data.classAndChamber)

private fun renderProposalV2Header(data: ProposalDataV2) = buildString {
    append(renderClassAndChamberHeader(data.classAndChamber))
    append(renderSponsoredHeader(data.sponsored))
}

private fun renderProposalV3Header(data: ProposalDataV3) = buildString {
    append(renderClassAndChamberHeader(data.classAndChamber))
    append(renderSponsoredHeader(data.sponsored))
}

private fun renderProposalHeader(config: ReadableReportConfig, proposal: Proposal) = buildString {
    appendLine("PROPOSAL ${proposal.number} (${proposal.title})")
    if (config.authorLine) appendLine("AUTHOR: ${proposal.author.name}")

    proposal.accept(object : ProposalVisitor {
        override fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0) {
            /* no header */
        }

        override fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1) {
            append(renderProposalV1Header(versionedData))
        }

        override fun visitV2(commonData: ProposalCommonData, versionedData: ProposalDataV2) {
            append(renderProposalV2Header(versionedData))
        }

        override fun visitV3(commonData: ProposalCommonData, versionedData: ProposalDataV3) {
            append(renderProposalV3Header(versionedData))
        }
    })
}

private val strengthFootnoteMarkerMap = mapOf(
    0 to "~",
    1 to "!",
    2 to "@",
    3 to "#",
    4 to "$",
    5 to "%",
    6 to "^",
    7 to "&",
    8 to "*",
    9 to "+",
    10 to "=",
    11 to "/",
    12 to "?",
    13 to "<",
    14 to ">"
)

private fun renderProposalVotes(
    voteMap: SimplifiedSingleProposalVoteMap,
    strengthMap: VotingStrengthTrailForPersons,
    voteKindVoteCounts: Boolean
) = buildString {
    val actualFootnotes =
        strengthFootnoteMarkerMap
            .mapKeys { (k, _) -> VotingStrength(k) }
            .filterKeys { it != strengthMap.default }

    fun appendVoteKind(voteKind: VoteKind) {
        val matchingVotes = voteMap.personsWithVote(voteKind)

        appendLine(
            "${voteKind.name}${if (voteKindVoteCounts) " (${matchingVotes.size})" else ""}: " +
                    matchingVotes
                        .sortedBy { it.name }
                        .joinToString(", ") {
                            "${it.name}${actualFootnotes[strengthMap.finalStrengthForPerson(it)] ?: ""}"
                        }
        )
    }

    appendVoteKind(VoteKind.FOR)
    appendVoteKind(VoteKind.AGAINST)
    appendVoteKind(VoteKind.PRESENT)
}

private fun renderProposalAI(resolutionData: ResolutionData, ai: ProposalAI) =
    "AI (F/A): ${resolutionData.strengths.strengthFor}/${resolutionData.strengths.strengthAgainst} (AI=$ai)"

private fun popularityOf(votes: SimplifiedSingleProposalVoteMap): Double {
    // As defined by Rule 2623
    val F = votes.personsWithVote(VoteKind.FOR).size
    val A = votes.personsWithVote(VoteKind.AGAINST).size
    val T = votes.voteCount

    return (F.toDouble() - A.toDouble()) / (T.toDouble())
}

private fun formatPopularity(popularity: Double): String {
    return "%.3f".format(popularity)
}

private fun renderProposalPopularity(votes: SimplifiedSingleProposalVoteMap): String {
    return "POPULARITY: ${formatPopularity(popularityOf(votes))}"
}

private fun renderProposalOutcome(resolutionData: ResolutionData) = "OUTCOME: ${resolutionData.result.readableName}"

private fun renderVoteComments(resolutionData: ResolutionData) = buildString {
    val votes = resolutionData.votes
    val votersWithComment = votes.votesWithComments().voters

    if (votersWithComment.isNotEmpty()) {
        appendLine("[")

        votersWithComment
            .toList()
            .sortedBy { it.name }
            .forEach { voter ->
                val vote = votes[voter]
                appendLine("${voter.name}: ${vote.comment}")
            }

        appendLine("]")
    }
}

private fun renderProposalText(proposals: Iterable<Proposal>) = buildString {
    fun appendSeparator() {
        appendLine("//////////////////////////////////////////////////////////////////////")
    }

    val sortedProposals = proposals.sortedBy { it.number.raw }

    if (sortedProposals.isNotEmpty()) {
        appendLine("The full text of each ADOPTED proposal is included below:")
        appendLine()

        for (proposal in sortedProposals) {
            appendSeparator()
            appendLine("ID: ${proposal.number}")
            appendLine("Title: ${proposal.title}")
            appendLine("Adoption index: ${proposal.ai}")
            appendLine("Author: ${proposal.author.name}")
            appendLine("Co-authors: ${proposal.coauthors.joinToString(", ") { it.name }}")
            appendLine()
            appendLine()
            append(proposal.text.trim())
            appendLine()
            appendLine()
        }

        appendSeparator()
    } else {
        appendLine("No proposals were adopted.")
    }
}

private fun renderStrengthFootnotes(allStrengthMaps: Collection<VotingStrengthTrailForPersons>) = buildString {
    check(allStrengthMaps.isNotEmpty())
    check(allStrengthMaps.map { it.default }.distinct().size == 1)

    val defaultStrength = allStrengthMaps.first().default

    val specialVotingStrengths =
        allStrengthMaps
            .flatMap { strengthMap ->
                strengthMap.overriddenPersons.map { person ->
                    strengthMap.finalStrengthForPerson(person).raw
                }
            }
            .toSet()

    if (specialVotingStrengths.isNotEmpty()) {
        val footnotes =
            specialVotingStrengths
                .map { it.intValueExact() }
                .sorted()
                .joinToString(separator = "\n", postfix = "\n") { strength ->
                    "${strengthFootnoteMarkerMap.getValue(strength)}: player has voting strength $strength"
                }

        appendWithDelimiter("VOTING STRENGTHS")
        appendLine()
        appendLine("Strength is $defaultStrength unless otherwise noted.")
        append(footnotes)
    }
}

private fun StringBuilder.emitProposalResolutions(config: ReadableReportConfig, resolutionMap: ProposalResolutionMap) {
    val sortedProposals = resolutionMap.proposals.sortedBy { it.number }

    appendWithDelimiter("PROPOSALS")
    appendLine()

    for (proposal in sortedProposals) {
        val resolution = resolutionMap.resolutionOf(proposal.number)

        append(renderProposalHeader(config, proposal))

        append(
            renderProposalVotes(
                resolution.votes,
                resolutionMap.votingStrengthsFor(proposal.number),
                config.voteKindBallotCount
            )
        )

        if (config.totalBallotCount) appendLine("BALLOTS: ${resolution.votes.voteCount}")
        appendLine(renderProposalAI(resolution, proposal.ai))
        if (config.popularity) appendLine(renderProposalPopularity(resolution.votes))
        appendLine(renderProposalOutcome(resolution))
        if (config.voteComments) append(renderVoteComments(resolution))
        appendLine()
    }
}

private fun StringBuilder.appendWithDelimiter(string: String) {
    appendLine(string)
    appendLine("=".repeat(string.length))
}

data class ReadableReportConfig(
    val voteComments: Boolean = true,
    val authorLine: Boolean = true,
    val totalBallotCount: Boolean = true,
    val voteKindBallotCount: Boolean = true,
    val popularity: Boolean = true,
    val summaryTable: Boolean = false
)

fun readableReport(
    resolutionMap: ProposalResolutionMap,
    config: ReadableReportConfig = ReadableReportConfig()
): String {
    val sortedProposals = resolutionMap.proposals.sortedBy { it.number }

    return buildString {
        appendWithDelimiter("RESOLUTION OF PROPOSALS ${resolutionMap.metadata.name}")

        run {
            val url = resolutionMap.metadata.url

            if (url != null) {
                appendLine()
                appendLine("THIS IS AN AUTOMATICALLY GENERATED REPORT.")
                appendLine("SOME INFORMATION MAY DIFFER FROM THE HISTORICAL REPORT.")
                appendLine("THE ASSESSMENT SENT TO THE PUBLIC FORUM IS THE DEFINITIVE SOURCE OF HISTORICAL INFORMATION.")
                appendLine()
                appendLine("The official historical report is located at $url")
            }
        }

        if (config.summaryTable) {
            appendLine()
            append(renderSummaryTable(resolutionMap))
        }

        appendLine()
        appendLine(header())
        appendLine()
        appendLine(renderQuorum(resolutionMap.quorum))
        appendLine()
        renderPopularProposalsInfo(resolutionMap)?.let {
            appendLine(it)
            appendLine()
        }
        append(renderStrengthFootnotes(resolutionMap.votingStrengths.values))
        appendLine()
        emitProposalResolutions(config, resolutionMap)

        val adoptedProposals = resolutionMap.adoptedProposals()
        append(renderProposalText(sortedProposals.filter { adoptedProposals.contains(it.number) }))
    }
}

fun jsonReport(resolutionMap: ProposalResolutionMap): String {
    val out = json(resolutionMap)
    val json = Json(JsonConfiguration.Stable.copy(prettyPrint = true))

    return json.stringify(JsonObject.serializer(), out)
}
