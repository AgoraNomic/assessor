package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.toProposalSet

@AssessmentDSL
interface AssessmentReceiver {
    fun strengths(block: VotingStrengthReceiver.() -> Unit)
    fun proposals(block: ProposalsReceiver.() -> Unit)
    fun voting(block: VotingReceiver.() -> Unit)
    fun quorum(value: Int)
    fun name(value: String)
}

@AssessmentDSL
class AssessmentReceiverImpl : AssessmentReceiver {
    private val votingStrengthsBlock = DslValue<(VotingStrengthReceiver.() -> Unit)>()
    private val proposals = DslValue<ImmutableList<Proposal>>()
    private val proposalVotes = DslValue<ImmutableMap<ProposalNumber, SingleProposalVoteMap>>()
    private val quorum = DslValue<Int>()
    private val name = DslValue<String>()

    override fun strengths(block: VotingStrengthReceiver.() -> Unit) {
        votingStrengthsBlock.set(block)
    }

    override fun proposals(block: ProposalsReceiver.() -> Unit) {
        val receiver = ProposalsReceiverImpl()
        receiver.block()
        proposals.set(receiver.compile().toImmutableList())
    }

    override fun voting(block: VotingReceiver.() -> Unit) {
        val receiver = VotingReceiverImpl(proposals.get().toProposalSet())
        receiver.block()
        proposalVotes.set(receiver.compile().toImmutableMap())
    }

    override fun quorum(value: Int) {
        quorum.set(value)
    }

    override fun name(value: String) {
        name.set(value)
    }

    private fun compileVotingStrengths(): Map<ProposalNumber, VotingStrengthMap> {
        val proposals = proposals.get()
        val votingStrengthsBlock = votingStrengthsBlock.get()

        val receiver = VotingStrengthReceiverImpl(proposals.toImmutableList())
        receiver.votingStrengthsBlock()
        return receiver.compile()
    }

    fun compile(): AssessmentData {
        val name = name.get()
        val quorum = quorum.get()
        val proposals = proposals.get()
        val proposalVotes = proposalVotes.get()
        val votingStrengths = compileVotingStrengths()

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
            proposals.toProposalSet(),
            MultiProposalVoteMap(proposalVotes)
        )
    }
}
