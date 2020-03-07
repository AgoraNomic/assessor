package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet

@AssessmentDSL
interface AssessmentReceiver {
    fun strengths(block: VotingStrengthReceiver.() -> Unit)
    fun voting(block: VotingReceiver.() -> Unit)
    fun quorum(value: AssessmentQuorum)
    fun name(value: String)

    object Version0
    val v0 get() = Version0

    object Version1
    val v1 get() = Version1

    fun proposals(v0: Version0, block: ProposalsReceiverV0.() -> Unit)
    fun proposals(v1: Version1, block: ProposalsReceiverV1.() -> Unit)
}

fun AssessmentReceiver.quorum(value: Int) = quorum(AssessmentQuorum(value))

@AssessmentDSL
class AssessmentReceiverImpl : AssessmentReceiver {
    private val votingStrengthsBlock = DslValue<(VotingStrengthReceiver.() -> Unit)>()
    private val proposals = DslValue<ImmutableProposalSet>()
    private val proposalVotes = DslValue<ImmutableMap<ProposalNumber, SingleProposalVoteMap>>()
    private val quorum = DslValue<AssessmentQuorum>()
    private val name = DslValue<String>()

    override fun strengths(block: VotingStrengthReceiver.() -> Unit) {
        votingStrengthsBlock.set(block)
    }

    override fun proposals(v0: AssessmentReceiver.Version0, block: ProposalsReceiverV0.() -> Unit) {
        proposals.set(buildProposalsV0(block))
    }

    override fun proposals(v1: AssessmentReceiver.Version1, block: ProposalsReceiverV1.() -> Unit) {
        proposals.set(buildProposalsV1(block))
    }

    override fun voting(block: VotingReceiver.() -> Unit) {
        proposalVotes.set(buildVoting(proposals.get(), block))
    }

    override fun quorum(value: AssessmentQuorum) {
        quorum.set(value)
    }

    override fun name(value: String) {
        name.set(value)
    }

    private fun compileVotingStrengths(): Map<ProposalNumber, VotingStrengthMap> {
        val proposals = proposals.get()
        val votingStrengthsBlock = votingStrengthsBlock.get()

        val receiver = VotingStrengthReceiverImpl(proposals)
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
            proposals,
            MultiProposalVoteMap(proposalVotes)
        )
    }
}
