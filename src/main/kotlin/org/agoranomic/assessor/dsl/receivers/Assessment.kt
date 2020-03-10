package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet

@AssessmentDSL
interface AssessmentReceiver {
    fun strengths(block: VotingStrengthReceiverInit)
    fun voting(block: VotingReceiverInit)
    fun quorum(value: AssessmentQuorum)
    fun name(value: String)

    object Version0
    val v0 get() = Version0

    object Version1
    val v1 get() = Version1

    fun proposals(v0: Version0, block: ProposalsReceiverV0Init)
    fun proposals(v1: Version1, block: ProposalsReceiverV1Init)
}

typealias AssessmentReceiverInit = DslInit<AssessmentReceiver>

fun AssessmentReceiver.quorum(value: Int) = quorum(AssessmentQuorum(value))

@AssessmentDSL
class AssessmentReceiverImpl : AssessmentReceiver {
    private val votingStrengthsBlockValue = DslValue<VotingStrengthReceiverInit>()
    private val proposalsValue = DslValue<ImmutableProposalSet>()
    private val proposalVotesValue = DslValue<ImmutableMap<ProposalNumber, SingleProposalVoteMap>>()
    private val quorumValue = DslValue<AssessmentQuorum>()
    private val nameValue = DslValue<String>()

    override fun strengths(block: VotingStrengthReceiverInit) {
        votingStrengthsBlockValue.set(block)
    }

    override fun proposals(v0: AssessmentReceiver.Version0, block: ProposalsReceiverV0Init) {
        proposalsValue.set(buildProposalsV0(block))
    }

    override fun proposals(v1: AssessmentReceiver.Version1, block: ProposalsReceiverV1Init) {
        proposalsValue.set(buildProposalsV1(block))
    }

    override fun voting(block: VotingReceiverInit) {
        proposalVotesValue.set(buildVoting(proposalsValue.get(), block))
    }

    override fun quorum(value: AssessmentQuorum) {
        quorumValue.set(value)
    }

    override fun name(value: String) {
        nameValue.set(value)
    }

    fun compile(): AssessmentData {
        val name = nameValue.get()
        val quorum = quorumValue.get()
        val proposals = proposalsValue.get()
        val proposalVotes = proposalVotesValue.get()
        val votingStrengthsBlock = votingStrengthsBlockValue.get()
        val votingStrengths = buildVotingStrength(proposals, votingStrengthsBlock)

        for (proposalNumber in proposalVotes.keys) {
            if (proposals.find { it.number == proposalNumber } == null) error("Votes specified for unknown proposal $proposalNumber")
        }

        for (proposal in proposals.map { it.number }) {
            if (!(proposalVotes.containsKey(proposal))) error("Votes not specified for proposal $proposal")
        }

        return AssessmentData(
            name,
            quorum,
            votingStrengths,
            proposals,
            MultiProposalVoteMap(proposalVotes)
        )
    }
}
