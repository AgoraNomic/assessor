package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet

@AssessmentDSL
interface AssessmentReceiver {
    fun strengths(block: GlobalVotingStrengthReceiverInit)
    fun voting(block: MultiPersonVotesReceiverInit)
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
    private val votingStrengthsBlockValue = DslValue<GlobalVotingStrengthReceiverInit>()
    private val proposalsBlockValue = DslValue<() -> ImmutableProposalSet>()
    private val proposalVotesBlockValue = DslValue<MultiPersonVotesReceiverInit>()
    private val quorumValue = DslValue<AssessmentQuorum>()
    private val nameValue = DslValue<String>()

    override fun strengths(block: GlobalVotingStrengthReceiverInit) {
        votingStrengthsBlockValue.set(block)
    }

    override fun proposals(v0: AssessmentReceiver.Version0, block: ProposalsReceiverV0Init) {
        @Suppress("MoveLambdaOutsideParentheses") // Lambda is the value, so it should be in parentheses
        proposalsBlockValue.set({ buildProposalsV0(block) })
    }

    override fun proposals(v1: AssessmentReceiver.Version1, block: ProposalsReceiverV1Init) {
        @Suppress("MoveLambdaOutsideParentheses") // Lambda is the value, so it should be in parentheses
        proposalsBlockValue.set({ buildProposalsV1(block) })
    }

    override fun voting(block: MultiPersonVotesReceiverInit) {
        proposalVotesBlockValue.set(block)
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

        val proposalsBlock = proposalsBlockValue.get()
        val proposals = proposalsBlock()

        val proposalVotesBlock = proposalVotesBlockValue.get()
        val proposalVotes = buildMultiPersonVotes(proposals, proposalVotesBlock)

        val votingStrengthsBlock = votingStrengthsBlockValue.get()
        val votingStrengths = buildGlobalVotingStrength(proposals, votingStrengthsBlock)

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
