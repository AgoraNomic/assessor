package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.toProposalSet
import org.agoranomic.assessor.lib.util.compareTo
import org.agoranomic.assessor.lib.util.times
import java.math.BigInteger

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

private fun isAIAdopted(ai: ProposalAI, strengthFor: VotingStrength, strengthAgainst: VotingStrength): Boolean {
    return strengthFor.raw >= (ai.raw * strengthAgainst.raw) && (strengthFor > strengthAgainst)
}

typealias RawProposalQuorum = BigInteger

inline class ProposalQuorum(val raw: RawProposalQuorum) {
    constructor(raw: Int) : this(raw.toBigInteger())
}

fun resolve(
    quorum: ProposalQuorum,
    votingStrengthMap: VotingStrengthMap,
    ai: ProposalAI,
    rawVotes: SingleProposalVoteMap
): ResolutionData {
    val simplifiedVotes = rawVotes.simplified()

    var strengthFor = VotingStrength.zero()
    var strengthAgainst = VotingStrength.zero()

    simplifiedVotes.forEach { player, vote ->
        val strength = votingStrengthMap[player]

        // This val exists to ensure that, should another VoteKind be added, the compiler will error here unless
        // this is also updated.
        @Suppress("UNUSED_VARIABLE", "LocalVariableName")
        val _ensureExhaustive_ = when (vote.kind) {
            VoteKind.FOR -> strengthFor += strength.value
            VoteKind.AGAINST -> strengthAgainst += strength.value
            VoteKind.PRESENT -> { /* do nothing */
            }
        }
    }

    if (simplifiedVotes.voters.size < quorum.raw) {
        return ResolutionData(
            ProposalResult.FAILED_QUORUM,
            strengthFor,
            strengthAgainst,
            simplifiedVotes
        )
    }

    val isAdopted = isAIAdopted(
        ai = ai,
        strengthFor = strengthFor,
        strengthAgainst = strengthAgainst
    )

    // Resolution as specified in R955
    return ResolutionData(
        result = if (isAdopted) ProposalResult.ADOPTED else ProposalResult.REJECTED,
        strengthFor = strengthFor,
        strengthAgainst = strengthAgainst,
        votes = simplifiedVotes
    )
}

data class ProposalResolutionMap(
    val assessmentName: String,
    val proposals: ImmutableProposalSet,
    private val map: ImmutableMap<ProposalNumber, ResolutionData>,
    val quorum: AssessmentQuorum,
    val votingStrengths: ImmutableMap<ProposalNumber, VotingStrengthMap>
) {
    constructor(
        assessmentName: String,
        proposals: ProposalSet,
        map: Map<ProposalNumber, ResolutionData>,
        quorum: AssessmentQuorum,
        votingStrengths: Map<ProposalNumber, VotingStrengthMap>
    ) : this(
        assessmentName,
        proposals.toImmutableProposalSet(),
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

    fun proposalsWithResult(result: ProposalResult) =
        proposals
            .filter { this[it.number].result == result }
            .toProposalSet()

}

fun ProposalResolutionMap.adoptedProposals() = proposalsWithResult(ProposalResult.ADOPTED)

typealias RawAssessmentQuorum = RawProposalQuorum

inline class AssessmentQuorum(val raw: RawAssessmentQuorum) {
    constructor(raw: Int) : this(raw.toBigInteger())
}

data class AssessmentData(
    val name: String,
    val quorum: AssessmentQuorum,
    val votingStrengths: ImmutableMap<ProposalNumber, VotingStrengthMap>,
    val proposals: ImmutableProposalSet,
    val votes: MultiProposalVoteMap
) {
    constructor(
        name: String,
        quorum: AssessmentQuorum,
        votingStrengths: Map<ProposalNumber, VotingStrengthMap>,
        proposals: ProposalSet,
        votes: MultiProposalVoteMap
    ) : this(
        name,
        quorum,
        votingStrengths.toImmutableMap(),
        proposals.toImmutableProposalSet(),
        votes
    )

    init {
        require(votingStrengths.keys.toSet() == proposals.map { it.number }.toSet())
    }

    fun votingStrengthsOf(proposal: ProposalNumber) = votingStrengths[proposal]!!
}

fun resolve(assessmentData: AssessmentData): ProposalResolutionMap {
    val map = assessmentData.proposals.associateWith { proposal ->
        resolve(
            ProposalQuorum(assessmentData.quorum.raw),
            assessmentData.votingStrengthsOf(proposal.number),
            proposal.ai,
            assessmentData.votes[proposal.number]
        )
    }.mapKeys { (proposal, _) -> proposal.number }

    return ProposalResolutionMap(
        assessmentData.name,
        assessmentData.proposals,
        map,
        assessmentData.quorum,
        assessmentData.votingStrengths
    )
}
