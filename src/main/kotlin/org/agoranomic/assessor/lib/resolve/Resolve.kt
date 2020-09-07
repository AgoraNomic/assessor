package org.agoranomic.assessor.lib.resolve

import io.github.random_internet_cat.util.getOrFail
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.proposal.*
import org.agoranomic.assessor.lib.proposal.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.toImmutableProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.toProposalSet
import org.agoranomic.assessor.lib.vote.MultiPersonPendingVoteMap
import org.agoranomic.assessor.lib.vote.SimplifiedSingleProposalVoteMap
import org.agoranomic.assessor.lib.vote.SingleProposalVoteMap
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthTrailForPersons

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

data class ResolutionData(
    val result: ProposalResult,
    val strengths: AIStrengths,
    val votes: SimplifiedSingleProposalVoteMap,
)

fun resolve(
    quorum: ProposalQuorum,
    votingStrengthMap: VotingStrengthTrailForPersons,
    ai: ProposalAI,
    rawVotes: SingleProposalVoteMap,
): ResolutionData {
    val simplifiedVotes = rawVotes.simplified()

    val aiStrengths = aiStrengthsFor(simplifiedVotes, votingStrengthMap)

    if (failsQuorum(simplifiedVotes, quorum)) {
        return ResolutionData(
            result = ProposalResult.FAILED_QUORUM,
            strengths = aiStrengths,
            votes = simplifiedVotes
        )
    }

    val isAdopted = isAIAdopted(ai, aiStrengths)

    return ResolutionData(
        result = if (isAdopted) ProposalResult.ADOPTED else ProposalResult.REJECTED,
        strengths = aiStrengths,
        votes = simplifiedVotes
    )
}

data class ProposalResolutionMap(
    val metadata: AssessmentMetadata,
    val proposals: ImmutableProposalSet,
    private val resolutions: ImmutableMap<ProposalNumber, ResolutionData>,
    val quorum: AssessmentQuorum,
    val votingStrengths: ImmutableMap<ProposalNumber, VotingStrengthTrailForPersons>,
) {
    constructor(
        metadata: AssessmentMetadata,
        proposals: ProposalSet,
        resolutions: Map<ProposalNumber, ResolutionData>,
        quorum: AssessmentQuorum,
        votingStrengths: Map<ProposalNumber, VotingStrengthTrailForPersons>,
    ) : this(
        metadata,
        proposals.toImmutableProposalSet(),
        resolutions.toImmutableMap(),
        quorum,
        votingStrengths.toImmutableMap()
    )

    init {
        require(proposals.map { it.number }.toSet() == votingStrengths.keys.toSet())
        require(proposals.map { it.number }.toSet() == resolutions.keys.toSet())
    }

    private fun requireHasProposal(proposal: ProposalNumber) {
        require(proposals.contains(proposal)) { "No data for proposal $proposal" }
    }

    fun resolutionOf(proposal: ProposalNumber): ResolutionData {
        requireHasProposal(proposal)
        return resolutions.getOrFail(proposal)
    }

    fun votingStrengthsFor(proposal: ProposalNumber): VotingStrengthTrailForPersons {
        requireHasProposal(proposal)
        return votingStrengths.getOrFail(proposal)
    }

    fun proposalsWithResult(result: ProposalResult) =
        proposals
            .filter { resolutionOf(it.number).result == result }
            .toProposalSet()

}

fun ProposalResolutionMap.adoptedProposals() = proposalsWithResult(ProposalResult.ADOPTED)

inline class AssessmentUrl(val raw: String) {
    override fun toString(): String = raw
}

data class AssessmentMetadata(
    val minNumber: ProposalNumber,
    val maxNumber: ProposalNumber,
    val suffix: String?,
    val url: AssessmentUrl?,
) {
    init {
        require(minNumber <= maxNumber)
    }

    private val suffixOrEmpty
        get() = suffix ?: ""

    val name
        get() =
            if (minNumber == maxNumber)
                "$minNumber$suffixOrEmpty"
            else
                "$minNumber$suffixOrEmpty-$maxNumber$suffixOrEmpty"
}

data class AssessmentData(
    val metadata: AssessmentMetadata,
    val quorum: AssessmentQuorum,
    val votingStrengths: ImmutableMap<ProposalNumber, VotingStrengthTrailForPersons>,
    val proposals: ImmutableProposalSet,
    val votes: MultiPersonPendingVoteMap,
) {
    constructor(
        metadata: AssessmentMetadata,
        quorum: AssessmentQuorum,
        votingStrengths: Map<ProposalNumber, VotingStrengthTrailForPersons>,
        proposals: ProposalSet,
        votes: MultiPersonPendingVoteMap,
    ) : this(
        metadata,
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
        val strengthTrails = assessmentData.votingStrengthsOf(proposal.number)
        val votes = resolvedVotes[proposal.number]

        resolve(
            ProposalQuorum(assessmentData.quorum.generic()),
            strengthTrails,
            proposal.ai,
            votes
        )
    }.mapKeys { (proposal, _) -> proposal.number }

    return ProposalResolutionMap(
        assessmentData.metadata,
        assessmentData.proposals,
        map,
        assessmentData.quorum,
        assessmentData.votingStrengths
    )
}
