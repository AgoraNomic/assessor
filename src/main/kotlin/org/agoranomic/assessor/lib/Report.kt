package org.agoranomic.assessor.lib

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonObject
import org.agoranomic.assessor.lib.util.ceil
import org.agoranomic.assessor.lib.util.compareTo
import org.agoranomic.assessor.lib.util.times
import java.math.RoundingMode

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

private fun StringBuilder.emitHeader() {
    emitLine("I hereby resolve the Agoran decisions to adopt the below proposals.")
}

private fun StringBuilder.emitQuorum(quorum: AssessmentQuorum) {
    emitLine("The quorum for all below decisions was ${quorum.raw}.")
}

private fun StringBuilder.emitProposalHeader(proposal: Proposal) {
    emitLine("PROPOSAL ${proposal.number.raw} (${proposal.title})")

    val proposalClassAndChamber = proposal.classAndChamber

    // This val exists to ensure that, should another ProposalClassAndChamber type be added, the compiler will error
    // here unless this is also updated.
    @Suppress("UNUSED_VARIABLE", "LocalVariableName")
    val _ensureExhaustive_ = when (proposalClassAndChamber) {
        is ProposalClassAndChamber.Classless -> {
            /* do nothing */
        }

        is ProposalClassAndChamber.DemocraticClass -> emitLine("CLASS: DEMOCRATIC")
        is ProposalClassAndChamber.OrdinaryClass -> {
            emitLine("CLASS: ORDINARY")
            emitLine("CHAMBER: ${proposalClassAndChamber.chamber.readableName.toUpperCase()}")
        }
    }
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
    strengthMap: VotingStrengthMap,
    voteKindVoteCounts: Boolean
) {
    val actualFootnotes =
        strengthFootnoteMarkerMap
            .mapKeys { (k, _) -> VotingStrength(k) }
            .filterKeys { it != strengthMap.defaultStrength }

    fun emitVoteKind(voteKind: VoteKind) {
        val matchingVotes = voteMap.filterVoteKind(voteKind)

        emitString("${voteKind.name}${if (voteKindVoteCounts) " (${matchingVotes.size})" else ""}: ")
        emitString(matchingVotes.sortedBy { it.name }
            .map { "${it.name}${actualFootnotes[strengthMap[it].value] ?: ""}" }
            .joinToString(", "))
        emitLine()
    }

    emitVoteKind(VoteKind.FOR)
    emitVoteKind(VoteKind.AGAINST)
    emitVoteKind(VoteKind.PRESENT)
}

private fun StringBuilder.emitSingleVotingStrength(person: Person, strength: VotingStrengthWithComment) {
    emitString("${person.name} has voting strength ${strength.value.raw}")

    if (strength.comment != null) {
        emitString(" (${strength.comment})")
    }

    emitLine()
}


private fun StringBuilder.emitVotingStrengths(votingStrengthMap: VotingStrengthMap) {
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

private fun StringBuilder.emitProposalAI(resolutionData: ResolutionData, ai: ProposalAI) {
    emitLine("AI (F/A): ${resolutionData.strengthFor.raw}/${resolutionData.strengthAgainst.raw} (AI=${ai.raw})")
}

private fun StringBuilder.emitProposalOutcome(resolutionData: ResolutionData) {
    emitLine("OUTCOME: ${resolutionData.result.readableName}")
}

private fun StringBuilder.emitVoteComments(resolutionData: ResolutionData) {
    val filteredEntires = resolutionData.votes.map.filterValues { it.comment != null }.entries.sortedBy { it.key.name }

    if (filteredEntires.isNotEmpty()) {
        emitLine("[")
        for ((player, vote) in filteredEntires) {
            emitLine("${player.name}: ${vote.comment}")
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

private fun StringBuilder.emitStrengthFootnotes(allStrengthMaps: Collection<VotingStrengthMap>) {
    check(allStrengthMaps.isNotEmpty())
    check(allStrengthMaps.map { it.defaultStrength }.distinct().size == 1)

    val defaultStrength = allStrengthMaps.first().defaultStrength

    val specialVotingStrengths =
        allStrengthMaps
            .flatMap { strengthMap -> strengthMap.specialPeople.map { player -> strengthMap[player].value.raw } }
            .toSet()

    if (specialVotingStrengths.isNotEmpty()) {
        val footnotes = specialVotingStrengths.sorted().map {
            val intValue = it.toInt()
            intValue to strengthFootnoteMarkerMap[intValue]!!
        }.map { (value, symbol) -> "$symbol: player has voting strength $value" }.joinToString(separator = "\n")

        emitWithDelimiter("Voting Strengths")
        emitLine("Strength is ${defaultStrength.raw} unless otherwise noted.")
        emitString(footnotes)
        emitLine()
    }
}

private fun StringBuilder.emitProposalResolutions(config: ReportConfig, resolutionMap: ProposalResolutionMap) {
    val sortedProposals = resolutionMap.proposals.sortedBy { it.number }

    emitWithDelimiter("PROPOSALS")

    for (proposal in sortedProposals) {
        val resolution = resolutionMap[proposal.number]

        emitProposalHeader(proposal)

        emitProposalVotes(
            resolution.votes,
            resolutionMap.votingStrengthsFor(proposal.number),
            config.voteKindBallotCount
        )

        if (config.totalBallotCount) emitLine("BALLOTS: ${resolution.votes.voteCount}")
        emitProposalAI(resolution, proposal.ai)
        emitProposalOutcome(resolution)
        if (config.voteComments) emitVoteComments(resolution)
        emitLine()
    }
}

private fun StringBuilder.emitWithDelimiter(string: String) {
    emitLine(string)
    emitLine("=".repeat(string.length))
}

data class ReportConfig(
    val voteComments: Boolean = true,
    val totalBallotCount: Boolean = true,
    val voteKindBallotCount: Boolean = true
)

fun report(resolutionMap: ProposalResolutionMap, config: ReportConfig = ReportConfig()): String {
    val sortedProposals = resolutionMap.proposals.sortedBy { it.number }

    val output = StringBuilder()

    output.run {
        emitWithDelimiter("RESOLUTION OF PROPOSALS ${resolutionMap.assessmentName}")
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

fun rewardsReport(resolutionMap: ProposalResolutionMap): String {
    val result =
        resolutionMap
            .adoptedProposals()
            .map {
                val number = it.number
                val author = it.author
                val ai = it.ai

                val votes = resolutionMap[it.number].votes
                val voteCountFor = votes.filterVoteKind(VoteKind.FOR).count()
                val voteCountAgainst = votes.filterVoteKind(VoteKind.AGAINST).count()

                val unroundedReward = (voteCountFor - voteCountAgainst) * ai.raw
                val roundedReward = ceil(unroundedReward)

                val coinAmountString =
                    if (unroundedReward.compareTo(roundedReward) == 0)
                        roundedReward.toString()
                    else
                        "$unroundedReward -> $roundedReward"

                "For the adoption of Proposal ${number.raw}, I grant ${author.name} ($voteCountFor-$voteCountAgainst)*${ai.raw}=$coinAmountString coins."
            }
            .joinToString("\n")

    return result
}
