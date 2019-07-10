package org.agoranomic.assessor.lib

fun StringBuilder.emitNewLine() {
    this.append('\n')
}

fun StringBuilder.emitString(string: String) {
    this.append(string)
}

fun StringBuilder.emitLine(string: String) {
    emitString(string)
    emitNewLine()
}

fun StringBuilder.emitHeader() {
    emitLine("I hereby resolve all of the below proposals.")
}

fun StringBuilder.emitQuorum(quorum: Int) {
    emitLine("The quorum for all below decisions was $quorum.")
}

fun StringBuilder.emitProposalHeader(proposal: Proposal) {
    this.append("RESOLUTION OF PROPOSAL ${proposal.number} (\"${proposal.title}\")")
    emitNewLine()
}

fun StringBuilder.emitProposalVotes(voteMap: SingleProposalVoteMap) {
    fun emitVoteKind(voteKind: VoteKind) {
        emitString("${voteKind.name}: ")
        emitString(voteMap.filterVoteKind(voteKind).map { it.name }.sorted().joinToString(", "))
        emitNewLine()
    }

    emitVoteKind(VoteKind.FOR)
    emitVoteKind(VoteKind.AGAINST)
    emitVoteKind(VoteKind.PRESENT)
}

fun StringBuilder.emitSingleVotingStrength(player: Player, strength: VotingStrength) {
    emitString("${player.name} has voting strength ${strength.value}")

    if (strength.comment != null) {
        emitString(" (${strength.comment})")
    }

    emitNewLine()
}


fun StringBuilder.emitVotingStrengths(votingStrengthMap: VotingStrengthMap) {
    val sortedPlayers = votingStrengthMap.specialPlayers.sortedBy { it.name }

    if (sortedPlayers.isNotEmpty()) {
        emitLine("Voting strengths (${votingStrengthMap.defaultStrength} unless otherwise noted):")
        for (player in sortedPlayers) {
            emitSingleVotingStrength(player, votingStrengthMap[player])
        }
    } else {
        emitLine("All players have voting strength ${votingStrengthMap.defaultStrength}.")
    }
}

fun StringBuilder.emitProposalAI(resolutionData: ResolutionData, ai: ProposalAI) {
    emitLine("AI (F/A): ${resolutionData.strengthFor}/${resolutionData.strengthAgainst} (AI=$ai)")
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

fun StringBuilder.emitProposalText(proposals: Collection<Proposal>) {
    fun emitSeparator() {
        emitLine("//////////////////////////////////////////////////////////////////////")
    }

    val sortedProposals = proposals.sortedBy { it.number }

    if (sortedProposals.isNotEmpty()) {
        emitLine("The full text of each ADOPTED proposal is included below:")
        emitNewLine()

        for (proposal in sortedProposals) {
            emitSeparator()
            emitLine("ID: ${proposal.number}")
            emitLine("Title: ${proposal.title}")
            emitLine("Adoption index: ${proposal.ai}")
            emitLine("Author: ${proposal.author.name}")
            emitLine("Co-authors: ${proposal.coauthors.joinToString(", ") { it.name }}")
            emitNewLine()
            emitNewLine()
            emitString(proposal.text.trim())
            emitNewLine()
            emitNewLine()
        }

        emitSeparator()
    } else {
        emitLine("No proposals were adopted.")
    }
}

fun report(resolutionMap: ProposalResolutionMap): String {
    val sortedProposals = resolutionMap.proposals.sortedBy { it.number }

    val output = StringBuilder()

    output.run {
        emitHeader()
        emitNewLine()
        emitQuorum(resolutionMap.quorum)
        emitNewLine()
        emitVotingStrengths(resolutionMap.votingStrengths)
        emitNewLine()
        emitNewLine()

        for (proposal in sortedProposals) {
            val resolution = resolutionMap[proposal.number]

            emitProposalHeader(proposal)
            emitProposalVotes(resolution.votes)
            emitProposalAI(resolution, proposal.ai)
            emitProposalOutcome(resolution)
            emitVoteComments(resolution)
            emitNewLine()
        }

        emitNewLine()

        emitProposalText(resolutionMap.filterResult(ProposalResult.ADOPTED).keys.map { it.lookupIn(sortedProposals) })
    }

    return output.toString()
}