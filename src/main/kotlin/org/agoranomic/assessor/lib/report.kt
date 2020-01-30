package org.agoranomic.assessor.lib

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonObject

fun StringBuilder.emitLine() {
    this.append('\n')
}

fun StringBuilder.emitString(string: String) {
    this.append(string)
}

fun StringBuilder.emitLine(string: String) {
    emitString(string)
    emitLine()
}

fun StringBuilder.emitHeader() {
    emitLine("I hereby resolve the Agoran decisions to adopt the below proposals.")
}

fun StringBuilder.emitQuorum(quorum: Int) {
    emitLine("The quorum for all below decisions was $quorum.")
}

fun StringBuilder.emitProposalHeader(proposal: Proposal) {
    emitLine("PROPOSAL ${proposal.number.raw} (${proposal.title})")
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

fun StringBuilder.emitProposalVotes(voteMap: SimplifiedSingleProposalVoteMap, strengthMap: VotingStrengthMap, voteKindVoteCounts: Boolean) {
    val actualFootnotes = strengthFootnoteMarkerMap.mapKeys { (k, _) -> VotingStrength(k) }.filterKeys { it != strengthMap.defaultStrength }

    fun emitVoteKind(voteKind: VoteKind) {
        val matchingVotes = voteMap.filterVoteKind(voteKind)

        emitString("${voteKind.name}${if (voteKindVoteCounts) " (${matchingVotes.size})" else ""}: ")
        emitString(matchingVotes.sortedBy { it.name }.map { "${it.name}${actualFootnotes[strengthMap[it].value] ?: ""}" }.joinToString(", "))
        emitLine()
    }

    emitVoteKind(VoteKind.FOR)
    emitVoteKind(VoteKind.AGAINST)
    emitVoteKind(VoteKind.PRESENT)
}

fun StringBuilder.emitSingleVotingStrength(person: Person, strength: VotingStrengthWithComment) {
    emitString("${person.name} has voting strength ${strength.value.raw}")

    if (strength.comment != null) {
        emitString(" (${strength.comment})")
    }

    emitLine()
}


fun StringBuilder.emitVotingStrengths(votingStrengthMap: VotingStrengthMap) {
    val sortedPlayers = votingStrengthMap.specialPeople.sortedBy { it.name }

    if (sortedPlayers.isNotEmpty()) {
        emitLine("Voting strengths (${votingStrengthMap.defaultStrength.raw} unless otherwise noted):")
        for (player in sortedPlayers) {
            emitSingleVotingStrength(player, votingStrengthMap[player])
        }
    } else {
        emitLine("All players have voting strength ${votingStrengthMap.defaultStrength.raw}.")
    }
}

fun StringBuilder.emitProposalAI(resolutionData: ResolutionData, ai: ProposalAI) {
    emitLine("AI (F/A): ${resolutionData.strengthFor.raw}/${resolutionData.strengthAgainst.raw} (AI=${ai.raw})")
}

fun StringBuilder.emitProposalOutcome(resolutionData: ResolutionData) {
    emitLine("OUTCOME: ${resolutionData.result.readableName}")
}

fun StringBuilder.emitVoteComments(resolutionData: ResolutionData) {
    val filteredEntires = resolutionData.votes.map.filterValues { it.comment != null }.entries.sortedBy { it.key.name }

    if (filteredEntires.isNotEmpty()) {
        emitLine("[")
        for ((player, vote) in filteredEntires) {
            emitLine("${player.name}: ${vote.comment}")
        }
        emitLine("]")
    }
}

fun StringBuilder.emitProposalText(proposals: Iterable<Proposal>) {
    fun emitSeparator() {
        emitLine("//////////////////////////////////////////////////////////////////////")
    }

    val sortedProposals = proposals.sortedBy { it.number.raw }

    if (sortedProposals.isNotEmpty()) {
        emitLine("The full text of each ADOPTED proposal is included below:")
        emitLine()

        for (proposal in sortedProposals) {
            emitSeparator()
            emitLine("ID: ${proposal.number.raw}")
            emitLine("Title: ${proposal.title}")
            emitLine("Adoption index: ${proposal.ai.raw}")
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

fun StringBuilder.emitStrengthFootnotes(strengthMap: Iterable<VotingStrengthMap>) {
    val specialVotingStrengths = strengthMap.flatMap { strengthMap -> strengthMap.specialPeople.map { player -> strengthMap[player].value.raw } }.toSet()

    if (specialVotingStrengths.isNotEmpty()) {
        val footnotes = specialVotingStrengths.sorted().map {
            val intValue = it.toInt()
            intValue to strengthFootnoteMarkerMap[intValue]!!
        }.map { (value, symbol) -> "$symbol: player has voting strength $value" }.joinToString(separator = "\n")

        emitWithDelimiter("Voting Strengths")
        emitString(footnotes)
        emitLine()
    }
}

fun StringBuilder.emitWithDelimiter(string: String) {
    emitLine(string)
    emitLine("=".repeat(string.length))
}

data class ReportConfig(
    val voteComments: Boolean = true,
    val totalBallotCount: Boolean = true,
    val voteKindBallotCount: Boolean = true
)

fun report(resolutionMap: ProposalResolutionMap, config: ReportConfig = ReportConfig()): String {
    val sortedProposals = resolutionMap.proposals.sortedBy { it.number.raw }

    val output = StringBuilder()

    output.run {
        emitWithDelimiter("RESOLUTION OF PROPOSALS ${resolutionMap.assessmentName}")
        emitLine()
        emitHeader()
        emitLine()
        emitQuorum(resolutionMap.quorum)
        emitLine()
        emitLine()

        for (proposal in sortedProposals) {
            val resolution = resolutionMap[proposal.number]

            emitProposalHeader(proposal)
            emitProposalVotes(resolution.votes, resolutionMap.votingStrengthsFor(proposal.number), config.voteKindBallotCount)
            if (config.totalBallotCount) emitLine("BALLOTS: ${resolution.votes.voteCount}")
            emitProposalAI(resolution, proposal.ai)
            emitProposalOutcome(resolution)
            if (config.voteComments) emitVoteComments(resolution)
            emitLine()
        }

        emitStrengthFootnotes(resolutionMap.votingStrengths.values)

        emitLine()

        emitProposalText(resolutionMap.filterResult(ProposalResult.ADOPTED).keys.map { it.lookupIn(sortedProposals) })
    }

    return output.toString()
}

fun jsonReport(resolutionMap: ProposalResolutionMap): String {
    val out = json(resolutionMap)
    val json = Json(JsonConfiguration.Stable.copy(prettyPrint = true))

    return json.stringify(JsonObject.serializer(), out)
}
