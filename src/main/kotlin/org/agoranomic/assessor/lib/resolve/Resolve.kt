package org.agoranomic.assessor.lib.resolve

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.proposal.*
import org.agoranomic.assessor.lib.proposal.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.toImmutableProposalSet
import org.agoranomic.assessor.lib.proposal.proposal_set.toProposalSet
import org.agoranomic.assessor.lib.vote.MultiPersonPendingVoteMap
import org.agoranomic.assessor.lib.vote.SimplifiedSingleProposalVoteMap
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
    val aiStrengths: AIStrengths,
    val votingStrengths: VotingStrengthTrailForPersons,
    val votes: SimplifiedSingleProposalVoteMap,
)

fun resolve(
    quorum: ProposalQuorum,
    votingStrengthMap: VotingStrengthTrailForPersons,
    ai: ProposalAI,
    votes: SimplifiedSingleProposalVoteMap,
): ResolutionData {
    val aiStrengths = aiStrengthsFor(votes, votingStrengthMap)

    return ResolutionData(
        result = if (meetsQuorum(votes, quorum)) {
            if (isAIAdopted(ai, aiStrengths))
                ProposalResult.ADOPTED
            else
                ProposalResult.REJECTED
        } else {
            ProposalResult.FAILED_QUORUM
        },
        aiStrengths = aiStrengths,
        votingStrengths = votingStrengthMap,
        votes = votes,
    )
}

data class ProposalResolutionMap(
    val metadata: AssessmentMetadata,
    val proposals: ImmutableProposalSet,
    private val resolutions: ImmutableMap<ProposalNumber, ResolutionData>,
    val quorum: AssessmentQuorum,
) {
    constructor(
        metadata: AssessmentMetadata,
        proposals: ProposalSet,
        resolutions: Map<ProposalNumber, ResolutionData>,
        quorum: AssessmentQuorum,
    ) : this(
        metadata,
        proposals.toImmutableProposalSet(),
        resolutions.toImmutableMap(),
        quorum,
    )

    init {
        require(proposals.map { it.number }.toSet() == resolutions.keys.toSet())
    }

    val votingStrengths by lazy {
        resolutions.mapValues { (_, v) -> v.votingStrengths }.toImmutableMap()
    }

    val proposalResolutions by lazy { resolutions.values.toImmutableList() }

    private fun requireHasProposal(proposal: ProposalNumber) {
        require(proposals.contains(proposal)) { "No data for proposal $proposal" }
    }

    fun resolutionOf(proposal: ProposalNumber): ResolutionData {
        requireHasProposal(proposal)
        return resolutions.getValue(proposal)
    }

    fun votingStrengthsFor(proposal: ProposalNumber): VotingStrengthTrailForPersons {
        return resolutionOf(proposal).votingStrengths
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
    val name: String,
    val url: AssessmentUrl?,
)

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
    )
}
