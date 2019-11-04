package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotingReciever(private val m_proposals: List<Proposal>) {
    private val m_totalEndorsements = mutableMapOf<Player, Player>()
    private val m_votes = mutableMapOf<Player, Map<ProposalNumber, PendingVote>>()

    infix fun Player.matches(other: Player) {
        m_totalEndorsements[this] = other
    }

    fun votes(player: Player, block: _VotesReceiver.() -> Unit) {
        require(!(m_votes.containsKey(player) || m_totalEndorsements.containsKey(player))) { "Votes already specified for player ${player.name}" }

        val receiver = _VotesReceiver(m_proposals, player)
        receiver.block()
        val result = receiver.compile()

        m_votes[player] = result
    }


    private fun resolveVote(proposal: Proposal, player: Player, vararg playersSeen: Player): Vote? {
        if (playersSeen.contains(player)) return InextricableVote(comment = null)

        val newPlayersSeen = (playersSeen.toList() + player).toTypedArray()
        val nextResolve: ResolveFunc = { nextProp, nextPlayer -> resolveVote(nextProp, nextPlayer, *newPlayersSeen) }

        if (m_totalEndorsements.containsKey(player)) return nextResolve(proposal, m_totalEndorsements.getOrFail(player))

        if (m_votes.containsKey(player)) {
            val playerVotes = m_votes.getOrFail(player)

            if (playerVotes.containsKey(proposal.number)) {
                return playerVotes.getOrFail(proposal.number).compile(proposal, nextResolve)
            }
        }

        return null
    }

    fun compile(): Map<ProposalNumber, SingleProposalVoteMap> {
        val allProposalVotes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()

        val allPlayers = (m_votes.keys + m_totalEndorsements.keys).distinct()

        for (proposal in m_proposals) {
            val proposalVotes = mutableMapOf<Player, Vote>()

            for (player in allPlayers) {
                val vote = resolveVote(proposal, player)
                if (vote != null) proposalVotes[player] = vote
            }

            allProposalVotes[proposal.number] = SingleProposalVoteMap(proposalVotes)
        }

        return allProposalVotes
    }
}