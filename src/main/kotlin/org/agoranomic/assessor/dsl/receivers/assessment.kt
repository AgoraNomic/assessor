package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _AssessmentReceiver {
    private var votingStrengthsBlock: (_VotingStrengthReceiver.() -> Unit)? = null
    private val proposals = mutableListOf<Proposal>()
    private var proposalVotes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()
    private var quorum: Int? = null
    private var name: String? = null

    fun strengths(block: _VotingStrengthReceiver.() -> Unit) {
        require(votingStrengthsBlock == null) { "Voting strengths specified twice" }
        votingStrengthsBlock = block
    }

    fun proposals(block: _ProposalsReceiver.() -> Unit) {
        val receiver = _ProposalsReceiver()
        receiver.block()
        proposals += receiver.compile()
    }

    fun voting(block: _VotingReciever.() -> Unit) {
        val receiver = _VotingReciever(proposals)
        receiver.block()
        proposalVotes.putAll(receiver.compile())
    }

    fun quorum(value: Int) {
        require(quorum == null) { "Quorum specified twice" }

        quorum = value
    }

    fun name(value: String) {
        require(name == null) { "Name specified twice" }

        name = value
    }

    private fun compileVotingStrengths(): Map<ProposalNumber, VotingStrengthMap> {
        val votingStrengthsBlock = votingStrengthsBlock ?: error("Must specify voting strengths")

        val receiver = _VotingStrengthReceiver(proposals.toImmutableList())
        receiver.votingStrengthsBlock()
        return receiver.compile()
    }

    fun compile(): AssessmentData {
        val name = name ?: error("Must specify name")
        val quorum = quorum ?: error("Must specify quorum")
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
            proposals.toSet(),
            MultiProposalVoteMap(proposalVotes)
        )
    }
}
