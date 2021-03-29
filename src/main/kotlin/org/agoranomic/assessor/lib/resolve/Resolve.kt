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
    val proposal: Proposal,
    val result: ProposalResult,
    val quorum: ProposalQuorum,
    val aiStrengths: AIStrengths,
    val votingStrengths: VotingStrengthTrailForPersons,
    val votes: SimplifiedSingleProposalVoteMap,
)

fun resolve(
    proposal: Proposal,
    quorum: ProposalQuorum,
    votingStrengthMap: VotingStrengthTrailForPersons,
    votes: SimplifiedSingleProposalVoteMap,
): ResolutionData {
    val aiStrengths = aiStrengthsFor(votes, votingStrengthMap)

    return ResolutionData(
        proposal = proposal,
        result = if (meetsQuorum(votes, quorum)) {
            if (isAIAdopted(proposal.decisionAI, aiStrengths))
                ProposalResult.ADOPTED
            else
                ProposalResult.REJECTED
        } else {
            ProposalResult.FAILED_QUORUM
        },
        quorum = quorum,
        aiStrengths = aiStrengths,
        votingStrengths = votingStrengthMap,
        votes = votes,
    )
}

data class ProposalResolutionMap(
    val metadata: AssessmentMetadata,
    private val resolutions: ImmutableMap<ProposalNumber, ResolutionData>,
    val quorum: AssessmentQuorum,
) {
    constructor(
        metadata: AssessmentMetadata,
        resolutions: Map<ProposalNumber, ResolutionData>,
        quorum: AssessmentQuorum,
    ) : this(
        metadata,
        resolutions.toImmutableMap(),
        quorum,
    )

    init {
        require(resolutions.all { (number, resolution) -> number == resolution.proposal.number })
    }

    val votingStrengths by lazy {
        resolutions.mapValues { (_, v) -> v.votingStrengths }.toImmutableMap()
    }

    val proposals by lazy { resolutions.values.map { it.proposal }.toImmutableProposalSet() }
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

    return ProposalResolutionMap(
        metadata = assessmentData.metadata,
        resolutions = assessmentData
            .proposals
            .associate { proposal ->
                val strengthTrails = assessmentData.votingStrengthsOf(proposal.number)
                val votes = resolvedVotes[proposal.number]

                proposal.number to resolve(
                    proposal = proposal,
                    quorum = ProposalQuorum(assessmentData.quorum.generic()),
                    votingStrengthMap = strengthTrails,
                    votes = votes,
                )
            },
        quorum = assessmentData.quorum,
    )
}
