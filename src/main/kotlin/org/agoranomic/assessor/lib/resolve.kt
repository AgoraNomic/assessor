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

        val _ensureExhaustive_ = when (vote) {
            is SimpleVote -> {
                when (vote.kind) {
                    VoteKind.FOR -> strengthFor += strength.value
                    VoteKind.AGAINST -> strengthAgainst += strength.value
                    VoteKind.PRESENT -> { /* do nothing */ }
                }
            }

            is InextricableVote -> { /* do nothing */ }
        }
    }

    if (votes.voters.size < quorum) return ResolutionData(ProposalResult.FAILED_QUORUM, strengthFor, strengthAgainst, votes)

    // Resolution as specified in R955
    return ResolutionData(
        if (strengthFor >= (ai * strengthAgainst) && (strengthFor > strengthAgainst)) ProposalResult.ADOPTED else ProposalResult.REJECTED,
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

private fun inextricableToPresent(singleProposalVoteMap: SingleProposalVoteMap): SingleProposalVoteMap {
    return SingleProposalVoteMap(singleProposalVoteMap.map.mapValues { (_, vote) -> if (vote is InextricableVote) SimpleVote(VoteKind.PRESENT, vote.comment) else vote })
}

private fun inextricableToPresent(multiProposalVoteMap: MultiProposalVoteMap): MultiProposalVoteMap {
    return multiProposalVoteMap.copy(map = multiProposalVoteMap.map.mapValues { (_, votes) -> inextricableToPresent(votes) })
}

private fun inextricableToPresent(assessmentData: AssessmentData): AssessmentData {
    return assessmentData.copy(votes = inextricableToPresent(assessmentData.votes))
}

fun resolve(rawAsessmentData: AssessmentData): ProposalResolutionMap {
    val assessmentData = inextricableToPresent(rawAsessmentData)
    val map = mutableMapOf<ProposalNumber, ResolutionData>()

    assessmentData.proposals.forEach { proposal ->
        map += proposal.number to resolve(assessmentData.quorum, assessmentData.votingStrengths, proposal.ai, assessmentData.votes[proposal.number])
    }

    return ProposalResolutionMap(assessmentData.name, assessmentData.proposals, map, assessmentData.quorum, assessmentData.votingStrengths)
}