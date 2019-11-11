package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _AssessmentReceiver {
    private var votingStrengths: VotingStrengthMap? = null
    private val proposals = mutableListOf<Proposal>()
    private var proposalVotes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()
    private var quorum: Int? = null
    private var name: String? = null

    fun strengths(block: _VotingStrengthReceiver.() -> Unit) {
        require(votingStrengths == null) { "Voting strengths specified twice" }

        val receiver = _VotingStrengthReceiver()
        receiver.block()
        votingStrengths = receiver.compile()
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

    fun compile(): AssessmentData {
        val name = name ?: error("Must specify name")
        val quorum = quorum ?: error("Must specify quorum")
        val votingStrengths = votingStrengths ?: error("Must specify voting strengths")

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
