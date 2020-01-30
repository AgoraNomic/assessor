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

data class SimplifiedSingleProposalVoteMap(val map: ImmutableMap<Person, SimpleVote>) {
    constructor(map: Map<Person, SimpleVote>) : this(map.toImmutableMap())

    val voters = map.keys
    val voteCount = voters.size

    operator fun get(p: Person) = map[p] ?: throw IllegalArgumentException("Player is not a voter")

    fun forEach(f: (Person, SimpleVote) -> Unit) {
        map.forEach(f)
    }

    fun filterVoteKind(kind: VoteKind): Set<Person> {
        return map.filterValues { vote -> vote.kind == kind }.keys
    }
}

data class ResolutionData(
    val result: ProposalResult,
    val strengthFor: VotingStrength,
    val strengthAgainst: VotingStrength,
    val votes: SimplifiedSingleProposalVoteMap
)

fun SingleProposalVoteMap.simplified(): SimplifiedSingleProposalVoteMap {
    return SimplifiedSingleProposalVoteMap(map.mapValues { (_, vote) -> vote.simplified() })
}

fun resolve(
    quorum: Int,
    votingStrengthMap: VotingStrengthMap,
    ai: ProposalAI,
    rawVotes: SingleProposalVoteMap
): ResolutionData {
    val simplifiedVotes = rawVotes.simplified()

    var strengthFor = VotingStrength.zero()
    var strengthAgainst = VotingStrength.zero()

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
        if (strengthFor.raw >= (ai.raw * strengthAgainst.raw) && (strengthFor > strengthAgainst)) ProposalResult.ADOPTED else ProposalResult.REJECTED,
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
    val votingStrengths: ImmutableMap<ProposalNumber, VotingStrengthMap>
) {
    constructor(
        assessmentName: String,
        proposals: Set<Proposal>,
        map: Map<ProposalNumber, ResolutionData>,
        quorum: Int,
        votingStrengths: Map<ProposalNumber, VotingStrengthMap>
    ) : this(
        assessmentName,
        proposals.toImmutableSet(),
        map.toImmutableMap(),
        quorum,
        votingStrengths.toImmutableMap()
    )

    init {
        require(proposals.map { it.number }.toSet() == votingStrengths.keys.toSet())
    }

    operator fun get(proposal: ProposalNumber) = map[proposal] ?: throw IllegalArgumentException("No data for proposal")

    fun votingStrengthsFor(proposal: ProposalNumber) = votingStrengths[proposal]!!
    fun filterResult(result: ProposalResult) = map.filterValues { it.result == result }
}

data class AssessmentData(
    val name: String,
    val quorum: Int,
    val votingStrengths: ImmutableMap<ProposalNumber, VotingStrengthMap>,
    val proposals: ImmutableSet<Proposal>,
    val votes: MultiProposalVoteMap
) {
    constructor(
        name: String,
        quorum: Int,
        votingStrengths: Map<ProposalNumber, VotingStrengthMap>,
        proposals: Set<Proposal>,
        votes: MultiProposalVoteMap
    ) : this(
        name,
        quorum,
        votingStrengths.toImmutableMap(),
        proposals.toImmutableSet(),
        votes
    )

    init {
        require(votingStrengths.keys.toSet() == proposals.map { it.number }.toSet())
    }

    fun votingStrengthsOf(proposal: ProposalNumber) = votingStrengths[proposal]!!
}

fun resolve(assessmentData: AssessmentData): ProposalResolutionMap {
    val map = mutableMapOf<ProposalNumber, ResolutionData>()

    assessmentData.proposals.forEach { proposal ->
        map += proposal.number to resolve(
            assessmentData.quorum,
            assessmentData.votingStrengthsOf(proposal.number),
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
