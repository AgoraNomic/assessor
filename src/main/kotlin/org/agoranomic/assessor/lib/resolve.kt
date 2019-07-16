package org.agoranomic.assessor.lib

import java.math.BigDecimal

enum class ProposalResult {
    FAILED_QUORUM("FAILED QUORUM"), REJECTED, ADOPTED;

    val readableName: String

    constructor() { this.readableName = name }
    constructor(readableName: String) { this.readableName = readableName }
}

data class ResolutionData(val result: ProposalResult, val strengthFor: VotingStrengthValue, val strengthAgainst: VotingStrengthValue, val votes: SingleProposalVoteMap)

operator fun BigDecimal.times(other: Int) = this * other.toBigDecimal()
operator fun Int.times(other: BigDecimal) = other * this

operator fun BigDecimal.compareTo(other: Int) = this.compareTo(other.toBigDecimal())
operator fun Int.compareTo(other: BigDecimal) = (this.toBigDecimal()).compareTo(other)

fun resolve(quorum: Int, votingStrengthMap: VotingStrengthMap, ai: ProposalAI, votes: SingleProposalVoteMap): ResolutionData {
    var strengthFor: VotingStrengthValue = 0
    var strengthAgainst: VotingStrengthValue = 0

    votes.forEach { player, vote ->
        val strength = votingStrengthMap[player]

        when (vote.kind) {
            VoteKind.FOR -> strengthFor += strength.value
            VoteKind.AGAINST -> strengthAgainst += strength.value
            VoteKind.PRESENT -> { /* do nothing */ }
        }
    }

    if (votes.voters.size < quorum) return ResolutionData(ProposalResult.FAILED_QUORUM, strengthFor, strengthAgainst, votes)

    return ResolutionData(
        if ((ai * strengthAgainst) >= strengthFor) ProposalResult.REJECTED else ProposalResult.ADOPTED,
        strengthFor,
        strengthAgainst,
        votes
    )
}

data class ProposalResolutionMap(val assessmentName: String, val proposals: Set<Proposal>, private val map: Map<ProposalNumber, ResolutionData>, val quorum: Int, val votingStrengths: VotingStrengthMap) {
    operator fun get(proposal: ProposalNumber) = map[proposal] ?: throw IllegalArgumentException("No data for proposal")

    fun filterResult(result: ProposalResult) = map.filterValues { it.result == result }

    fun forEach(block: (ProposalNumber, ResolutionData) -> Unit) {
        map.forEach(block)
    }
}

fun resolve(assessmentData: AssessmentData): ProposalResolutionMap {
    val map = mutableMapOf<ProposalNumber, ResolutionData>()

    assessmentData.proposals.forEach { proposal ->
        map += proposal.number to resolve(assessmentData.quorum, assessmentData.votingStrengths, proposal.ai, assessmentData.votes[proposal.number])
    }

    return ProposalResolutionMap(assessmentData.name, assessmentData.proposals, map, assessmentData.quorum, assessmentData.votingStrengths)
}