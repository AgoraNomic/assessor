package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.collections.immutable.toImmutableSet

enum class ProposalResult {
    FAILED_QUORUM("FAILED QUORUM"), REJECTED, ADOPTED;

    val readableName: String

    constructor() {
        this.readableName = name
    }

    constructor(readableName: String) {
        this.readableName = readableName
    }
}

data class SimplifiedSingleProposalVoteMap(val map: ImmutableMap<Player, SimpleVote>) {
    constructor(map: Map<Player, SimpleVote>) : this(map.toImmutableMap())

    val voters = map.keys
    val voteCount = voters.size

    operator fun get(p: Player) = map[p] ?: throw IllegalArgumentException("Player is not a voter")

    fun forEach(f: (Player, SimpleVote) -> Unit) {
        map.forEach(f)
    }

    fun filterVoteKind(kind: VoteKind): Set<Player> {
        return map.filterValues { vote -> vote.kind == kind }.keys
    }
}

data class ResolutionData(
    val result: ProposalResult,
    val strengthFor: VotingStrengthValue,
    val strengthAgainst: VotingStrengthValue,
    val votes: SimplifiedSingleProposalVoteMap
)

fun simplifyVotes(votes: SingleProposalVoteMap): SimplifiedSingleProposalVoteMap {
    return SimplifiedSingleProposalVoteMap(votes.map.mapValues { (_, vote) ->
        when (vote) {
            is SimpleVote -> vote
            is InextricableVote -> SimpleVote(VoteKind.PRESENT, vote.comment)
        }
    })
}

fun resolve(
    quorum: Int,
    votingStrengthMap: VotingStrengthMap,
    ai: ProposalAI,
    rawVotes: SingleProposalVoteMap
): ResolutionData {
    val simplifiedVotes = simplifyVotes(rawVotes)

    var strengthFor: VotingStrengthValue = 0
    var strengthAgainst: VotingStrengthValue = 0

    simplifiedVotes.forEach { player, vote ->
        val strength = votingStrengthMap[player]

        val _ensureExhaustive_ = when (vote.kind) {
            VoteKind.FOR -> strengthFor += strength.value
            VoteKind.AGAINST -> strengthAgainst += strength.value
            VoteKind.PRESENT -> { /* do nothing */
            }
        }
    }

    if (simplifiedVotes.voters.size < quorum) return ResolutionData(
        ProposalResult.FAILED_QUORUM,
        strengthFor,
        strengthAgainst,
        simplifiedVotes
    )

    // Resolution as specified in R955
    return ResolutionData(
        if (strengthFor >= (ai * strengthAgainst) && (strengthFor > strengthAgainst)) ProposalResult.ADOPTED else ProposalResult.REJECTED,
        strengthFor,
        strengthAgainst,
        simplifiedVotes
    )
}

data class ProposalResolutionMap(
    val assessmentName: String,
    val proposals: ImmutableSet<Proposal>,
    private val map: ImmutableMap<ProposalNumber, ResolutionData>,
    val quorum: Int,
    val votingStrengths: VotingStrengthMap
) {
    constructor(
        assessmentName: String,
        proposals: Set<Proposal>,
        map: Map<ProposalNumber, ResolutionData>,
        quorum: Int,
        votingStrengths: VotingStrengthMap
    ) : this(
        assessmentName,
        proposals.toImmutableSet(),
        map.toImmutableMap(),
        quorum,
        votingStrengths
    )

    operator fun get(proposal: ProposalNumber) = map[proposal] ?: throw IllegalArgumentException("No data for proposal")

    fun filterResult(result: ProposalResult) = map.filterValues { it.result == result }
}

fun resolve(assessmentData: AssessmentData): ProposalResolutionMap {
    val map = mutableMapOf<ProposalNumber, ResolutionData>()

    assessmentData.proposals.forEach { proposal ->
        map += proposal.number to resolve(
            assessmentData.quorum,
            assessmentData.votingStrengths,
            proposal.ai,
            assessmentData.votes[proposal.number]
        )
    }

    return ProposalResolutionMap(
        assessmentData.name,
        assessmentData.proposals,
        map,
        assessmentData.quorum,
        assessmentData.votingStrengths
    )
}
