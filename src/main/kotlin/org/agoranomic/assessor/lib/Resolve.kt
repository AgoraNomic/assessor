package org.agoranomic.assessor.lib

import io.github.random_internet_cat.util.compareTo
import io.github.random_internet_cat.util.times
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.toProposalSet
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

data class SimplifiedSingleProposalVoteMap(private val data: ImmutableMap<Person, SimpleVote>) {
    constructor(map: Map<Person, SimpleVote>) : this(map.toImmutableMap())

    val voters get() = Persons(data.keys)
    val voteCount get() = voters.size

    val size get() = voteCount
    fun isEmpty() = size == 0
    fun isNotEmpty() = !isEmpty()

    operator fun get(p: Person) = data[p] ?: throw IllegalArgumentException("Player is not a voter")

    fun forEach(f: (Person, SimpleVote) -> Unit) {
        data.forEach(f)
    }

    fun personsWithVote(kind: VoteKind): Persons {
        return Persons(data.filterValues { vote -> vote.kind == kind }.keys)
    }

    fun votesWithComments(): SimplifiedSingleProposalVoteMap {
        return SimplifiedSingleProposalVoteMap(data.filterValues { it.comment != null })
    }
}

fun SimplifiedSingleProposalVoteMap.votersFor() = personsWithVote(VoteKind.FOR)
fun SimplifiedSingleProposalVoteMap.votersAgainst() = personsWithVote(VoteKind.AGAINST)

data class ResolutionData(
    val result: ProposalResult,
    val strengthFor: VotingStrength,
    val strengthAgainst: VotingStrength,
    val votes: SimplifiedSingleProposalVoteMap
)

private fun isAIAdopted(ai: ProposalAI, strengthFor: VotingStrength, strengthAgainst: VotingStrength): Boolean {
    return strengthFor.raw >= (ai.raw * strengthAgainst.raw) && (strengthFor > strengthAgainst)
}

typealias RawQuorum = BigInteger

inline class Quorum(val raw: RawQuorum) {
    constructor(raw: Int) : this(raw.toBigInteger())

    override fun toString(): String = raw.toString()
}

operator fun Quorum.compareTo(other: Quorum) = (this.raw).compareTo(other.raw)

typealias RawProposalQuorum = Quorum

inline class ProposalQuorum(val raw: RawProposalQuorum) {
    constructor(raw: Int) : this(Quorum(raw))

    override fun toString(): String = raw.toString()
}

private fun strengthWithVote(
    targetVote: VoteKind,
    votes: SimplifiedSingleProposalVoteMap,
    strengths: VotingStrengthMap
) =
    votes.personsWithVote(targetVote)
        .map { strengths[it] }
        .fold(VotingStrength.zero()) { acc, next -> acc + next.value }

fun resolve(
    quorum: ProposalQuorum,
    votingStrengthMap: VotingStrengthMap,
    ai: ProposalAI,
    rawVotes: SingleProposalVoteMap
): ResolutionData {
    val simplifiedVotes = rawVotes.simplified()

    val strengthFor = strengthWithVote(VoteKind.FOR, simplifiedVotes, votingStrengthMap)
    val strengthAgainst = strengthWithVote(VoteKind.AGAINST, simplifiedVotes, votingStrengthMap)

    if (simplifiedVotes.voters.size < quorum.raw.raw) {
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
    private val resolutions: ImmutableMap<ProposalNumber, ResolutionData>,
    val quorum: AssessmentQuorum,
    val votingStrengths: ImmutableMap<ProposalNumber, VotingStrengthMap>
) {
    constructor(
        assessmentName: String,
        proposals: ProposalSet,
        resolutions: Map<ProposalNumber, ResolutionData>,
        quorum: AssessmentQuorum,
        votingStrengths: Map<ProposalNumber, VotingStrengthMap>
    ) : this(
        assessmentName,
        proposals.toImmutableProposalSet(),
        resolutions.toImmutableMap(),
        quorum,
        votingStrengths.toImmutableMap()
    )

    init {
        require(proposals.map { it.number }.toSet() == votingStrengths.keys.toSet())
    }

    fun resolutionOf(proposal: ProposalNumber) =
        resolutions[proposal] ?: throw IllegalArgumentException("No data for proposal")

    fun votingStrengthsFor(proposal: ProposalNumber) = votingStrengths[proposal]!!

    fun proposalsWithResult(result: ProposalResult) =
        proposals
            .filter { resolutionOf(it.number).result == result }
            .toProposalSet()

}

fun ProposalResolutionMap.adoptedProposals() = proposalsWithResult(ProposalResult.ADOPTED)

typealias RawAssessmentQuorum = Quorum

inline class AssessmentQuorum(val raw: RawAssessmentQuorum) {
    constructor(raw: Int) : this(Quorum(raw))

    override fun toString(): String = raw.toString()
}

data class AssessmentData(
    val name: String,
    val quorum: AssessmentQuorum,
    val votingStrengths: ImmutableMap<ProposalNumber, VotingStrengthMap>,
    val proposals: ImmutableProposalSet,
    val votes: MultiPersonPendingVoteMap
) {
    constructor(
        name: String,
        quorum: AssessmentQuorum,
        votingStrengths: Map<ProposalNumber, VotingStrengthMap>,
        proposals: ProposalSet,
        votes: MultiPersonPendingVoteMap
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
    val resolvedVotes = resolveVotes(assessmentData.votes, assessmentData.proposals)

    val map = assessmentData.proposals.associateWith { proposal ->
        resolve(
            ProposalQuorum(assessmentData.quorum.raw),
            assessmentData.votingStrengthsOf(proposal.number),
            proposal.ai,
            resolvedVotes[proposal.number]
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
