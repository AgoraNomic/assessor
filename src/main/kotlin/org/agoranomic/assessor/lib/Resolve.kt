package org.agoranomic.assessor.lib

import io.github.random_internet_cat.util.getOrFail
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.toProposalSet

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
    val votes: SimplifiedSingleProposalVoteMap
)

fun resolve(
    quorum: ProposalQuorum,
    votingStrengthMap: VotingStrengthMap,
    ai: ProposalAI,
    rawVotes: SingleProposalVoteMap
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
    val assessmentName: String,
    val assessmentUrl: AssessmentUrl?,
    val proposals: ImmutableProposalSet,
    private val resolutions: ImmutableMap<ProposalNumber, ResolutionData>,
    val quorum: AssessmentQuorum,
    val votingStrengths: ImmutableMap<ProposalNumber, ImmutableVotingStrengthMap>
) {
    constructor(
        assessmentName: String,
        assessmentUrl: AssessmentUrl?,
        proposals: ProposalSet,
        resolutions: Map<ProposalNumber, ResolutionData>,
        quorum: AssessmentQuorum,
        votingStrengths: Map<ProposalNumber, ImmutableVotingStrengthMap>
    ) : this(
        assessmentName,
        assessmentUrl,
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

    fun resolutionOf(proposal: ProposalNumber): ResolutionData{
        requireHasProposal(proposal)
        return resolutions.getOrFail(proposal)
    }

    fun votingStrengthsFor(proposal: ProposalNumber): ImmutableVotingStrengthMap {
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

data class AssessmentData(
    val name: String,
    val url: AssessmentUrl?,
    val quorum: AssessmentQuorum,
    val votingStrengths: ImmutableMap<ProposalNumber, ImmutableVotingStrengthMap>,
    val proposals: ImmutableProposalSet,
    val votes: MultiPersonPendingVoteMap
) {
    constructor(
        name: String,
        url: AssessmentUrl?,
        quorum: AssessmentQuorum,
        votingStrengths: Map<ProposalNumber, ImmutableVotingStrengthMap>,
        proposals: ProposalSet,
        votes: MultiPersonPendingVoteMap
    ) : this(
        name,
        url,
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
            ProposalQuorum(assessmentData.quorum.generic()),
            assessmentData.votingStrengthsOf(proposal.number),
            proposal.ai,
            resolvedVotes[proposal.number]
        )
    }.mapKeys { (proposal, _) -> proposal.number }

    return ProposalResolutionMap(
        assessmentData.name,
        assessmentData.url,
        assessmentData.proposals,
        map,
        assessmentData.quorum,
        assessmentData.votingStrengths
    )
}
