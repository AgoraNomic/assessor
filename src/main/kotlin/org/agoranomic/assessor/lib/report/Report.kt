package org.agoranomic.assessor.lib.report

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonObject
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.*
import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap
import org.agoranomic.assessor.lib.resolve.ResolutionData
import org.agoranomic.assessor.lib.resolve.adoptedProposals
import org.agoranomic.assessor.lib.vote.SimplifiedSingleProposalVoteMap
import org.agoranomic.assessor.lib.vote.VoteKind
import org.agoranomic.assessor.lib.voting_strength.VotingStrength
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthTrailForPersons
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthWithComment
import kotlin.math.max

private fun StringBuilder.emitLine() {
    this.append('\n')
}

private fun StringBuilder.emitString(string: String) {
    this.append(string)
}

private fun StringBuilder.emitLine(string: String) {
    emitString(string)
    emitLine()
}

private fun tableRowText(maxLengths: List<Int>, row: List<String>): String {
    require(maxLengths.size == row.size)

    return row.zip(maxLengths) { item, maxLength -> item.padEnd(maxLength) }.joinToString("  ")
}

private fun StringBuilder.emitTable(columnNames: List<String>, dataRows: List<List<String>>) {
    dataRows.forEach { require(it.size == columnNames.size) }

    val maxLengths = columnNames.indices.map { idx ->
        max(columnNames[idx].length, dataRows.map { it[idx] }.maxBy { it.length }?.length ?: 0)
    }

    val headerText = tableRowText(maxLengths, columnNames)

    emitLine(headerText)
    emitLine("-".repeat(headerText.length))

    for (dataRow in dataRows) {
        emitLine(tableRowText(maxLengths, dataRow))
    }
}

private fun StringBuilder.emitSummaryTable(resolutionMap: ProposalResolutionMap) {
    val columnNames = listOf("ID", "Title", "Result")

    val dataRows = resolutionMap.proposals.map {
        listOf(it.number.toString(), it.title, resolutionMap.resolutionOf(it.number).result.readableName)
    }

    emitTable(columnNames, dataRows)
}

private fun StringBuilder.emitHeader() {
    emitLine("I hereby resolve the Agoran decisions to adopt the below proposals.")
}

private fun StringBuilder.emitQuorum(quorum: AssessmentQuorum) {
    emitLine("The quorum for all below decisions was ${quorum.count()}.")
}

private fun StringBuilder.emitProposalV0Header(data: ProposalDataV0) {}

private fun StringBuilder.emitClassAndChamberHeader(classAndChamber: ProposalClassAndChamber) {
    classAndChamber.accept(object : ProposalClassAndChamberVisitor {
        override fun visitClassless() {
            // do nothing
        }

        override fun visitDemocratic() {
            emitLine("CLASS: DEMOCRATIC")
        }

        override fun visitOrdinary(chamber: ProposalChamber) {
            emitLine("CLASS: ORDINARY")
            emitLine("CHAMBER: ${chamber.readableName.toUpperCase()}")
        }
    })
}

private fun StringBuilder.emitProposalV1Header(data: ProposalDataV1) {
    emitClassAndChamberHeader(data.classAndChamber)
}

private fun StringBuilder.emitProposalV2Header(data: ProposalDataV2) {
    emitClassAndChamberHeader(data.classAndChamber)
    emitLine("SPONSORED: ${if (data.sponsored) "YES" else "NO"}")
}

private fun StringBuilder.emitProposalHeader(config: ReadableReportConfig, proposal: Proposal) {
    emitLine("PROPOSAL ${proposal.number} (${proposal.title})")
    if (config.authorLine) emitLine("AUTHOR: ${proposal.author.name}")

    proposal.accept(object : ProposalVisitor {
        override fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0) {
            emitProposalV0Header(versionedData)
        }

        override fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1) {
            emitProposalV1Header(versionedData)
        }

        override fun visitV2(commonData: ProposalCommonData, versionedData: ProposalDataV2) {
            emitProposalV2Header(versionedData)
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

private fun StringBuilder.emitProposalVotes(
    voteMap: SimplifiedSingleProposalVoteMap,
    strengthMap: VotingStrengthTrailForPersons,
    voteKindVoteCounts: Boolean
) {
    val actualFootnotes =
        strengthFootnoteMarkerMap
            .mapKeys { (k, _) -> VotingStrength(k) }
            .filterKeys { it != strengthMap.default }

    fun emitVoteKind(voteKind: VoteKind) {
        val matchingVotes = voteMap.personsWithVote(voteKind)

        emitString("${voteKind.name}${if (voteKindVoteCounts) " (${matchingVotes.size})" else ""}: ")
        emitString(matchingVotes.sortedBy { it.name }
            .map { "${it.name}${actualFootnotes[strengthMap.finalStrengthForPerson(it)] ?: ""}" }
            .joinToString(", "))
        emitLine()
    }

    emitVoteKind(VoteKind.FOR)
    emitVoteKind(VoteKind.AGAINST)
    emitVoteKind(VoteKind.PRESENT)
}

private fun StringBuilder.emitSingleVotingStrength(person: Person, strength: VotingStrengthWithComment) {
    emitString("${person.name} has voting strength ${strength.value}")

    if (strength.comment != null) {
        emitString(" (${strength.comment})")
    }

    emitLine()
}

private fun StringBuilder.emitProposalAI(resolutionData: ResolutionData, ai: ProposalAI) {
    emitLine("AI (F/A): ${resolutionData.strengths.strengthFor}/${resolutionData.strengths.strengthAgainst} (AI=$ai)")
}

private fun StringBuilder.emitProposalPopularity(votes: SimplifiedSingleProposalVoteMap) {
    // As defined by Rule 2623
    val F = votes.personsWithVote(VoteKind.FOR).size
    val A = votes.personsWithVote(VoteKind.AGAINST).size
    val T = votes.voteCount

    val popularity = (F.toDouble() - A.toDouble()) / (T.toDouble())
    val popularityStr = "%.3f".format(popularity)

    emitLine("POPULARITY: $popularityStr")
}

private fun StringBuilder.emitProposalOutcome(resolutionData: ResolutionData) {
    emitLine("OUTCOME: ${resolutionData.result.readableName}")
}

private fun StringBuilder.emitVoteComments(resolutionData: ResolutionData) {
    val votes = resolutionData.votes
    val votersWithComment = votes.votesWithComments().voters

    if (votersWithComment.isNotEmpty()) {
        emitLine("[")

        votersWithComment
            .toList()
            .sortedBy { it.name }
            .forEach { voter ->
                val vote = votes[voter]
                emitLine("${voter.name}: ${vote.comment}")
            }

        emitLine("]")
    }
}

private fun StringBuilder.emitProposalText(proposals: Iterable<Proposal>) {
    fun emitSeparator() {
        emitLine("//////////////////////////////////////////////////////////////////////")
    }

    val sortedProposals = proposals.sortedBy { it.number.raw }

    if (sortedProposals.isNotEmpty()) {
        emitLine("The full text of each ADOPTED proposal is included below:")
        emitLine()

        for (proposal in sortedProposals) {
            emitSeparator()
            emitLine("ID: ${proposal.number}")
            emitLine("Title: ${proposal.title}")
            emitLine("Adoption index: ${proposal.ai}")
            emitLine("Author: ${proposal.author.name}")
            emitLine("Co-authors: ${proposal.coauthors.joinToString(", ") { it.name }}")
            emitLine()
            emitLine()
            emitString(proposal.text.trim())
            emitLine()
            emitLine()
        }

        emitSeparator()
    } else {
        emitLine("No proposals were adopted.")
    }
}

private fun StringBuilder.emitStrengthFootnotes(allStrengthMaps: Collection<VotingStrengthTrailForPersons>) {
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
        val footnotes = specialVotingStrengths.sorted().map {
            val intValue = it.toInt()
            intValue to strengthFootnoteMarkerMap[intValue]!!
        }.map { (value, symbol) -> "$symbol: player has voting strength $value" }.joinToString(separator = "\n")

        emitWithDelimiter("VOTING STRENGTHS")
        emitLine("Strength is ${defaultStrength} unless otherwise noted.")
        emitString(footnotes)
        emitLine()
    }
}

private fun StringBuilder.emitProposalResolutions(config: ReadableReportConfig, resolutionMap: ProposalResolutionMap) {
    val sortedProposals = resolutionMap.proposals.sortedBy { it.number }

    emitWithDelimiter("PROPOSALS")
    emitLine()

    for (proposal in sortedProposals) {
        val resolution = resolutionMap.resolutionOf(proposal.number)

        emitProposalHeader(config, proposal)

        emitProposalVotes(
            resolution.votes,
            resolutionMap.votingStrengthsFor(proposal.number),
            config.voteKindBallotCount
        )

        if (config.totalBallotCount) emitLine("BALLOTS: ${resolution.votes.voteCount}")
        emitProposalAI(resolution, proposal.ai)
        if (config.popularity) emitProposalPopularity(resolution.votes)
        emitProposalOutcome(resolution)
        if (config.voteComments) emitVoteComments(resolution)
        emitLine()
    }
}

private fun StringBuilder.emitWithDelimiter(string: String) {
    emitLine(string)
    emitLine("=".repeat(string.length))
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

    val output = StringBuilder()

    output.run {
        emitWithDelimiter("RESOLUTION OF PROPOSALS ${resolutionMap.metadata.name}")

        run {
            val url = resolutionMap.metadata.url

            if (url != null) {
                emitLine()
                emitLine("THIS IS AN AUTOMATICALLY GENERATED REPORT.")
                emitLine("SOME INFORMATION MAY DIFFER FROM THE HISTORICAL REPORT.")
                emitLine("THE ASSESSMENT SENT TO THE PUBLIC FORUM IS THE DEFINITIVE SOURCE OF HISTORICAL INFORMATION.")
                emitLine()
                emitLine("The official historical report is located at $url")
            }
        }

        if (config.summaryTable) {
            emitLine()
            emitSummaryTable(resolutionMap)
        }

        emitLine()
        emitHeader()
        emitLine()
        emitQuorum(resolutionMap.quorum)
        emitLine()
        emitStrengthFootnotes(resolutionMap.votingStrengths.values)
        emitLine()
        emitProposalResolutions(config, resolutionMap)

        val adoptedProposals = resolutionMap.adoptedProposals()
        emitProposalText(sortedProposals.filter { adoptedProposals.contains(it.number) })
    }

    return output.toString()
}

fun jsonReport(resolutionMap: ProposalResolutionMap): String {
    val out = json(resolutionMap)
    val json = Json(JsonConfiguration.Stable.copy(prettyPrint = true))

    return json.stringify(JsonObject.serializer(), out)
}
