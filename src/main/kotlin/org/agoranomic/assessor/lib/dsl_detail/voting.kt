package org.agoranomic.assessor.lib.dsl_detail

import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotingReciever(private val proposals: List<Proposal>) {
    private val totalEndorsements = mutableMapOf<Player, Player>()
    private val votes = mutableMapOf<Player, Map<ProposalNumber, PendingVote>>()

    infix fun Player.matches(other: Player) {
        totalEndorsements[this] = other
    }

    fun votes(player: Player, block: _VotesReceiver.() -> Unit) {
        require(!(votes.containsKey(player) || totalEndorsements.containsKey(player))) { "Votes already specified for player ${player.name}" }

        val receiver = _VotesReceiver(proposals, player)
        receiver.block()
        val result = receiver.compile()

        votes[player] = result
    }


    private fun resolveVote(proposal: Proposal, player: Player, vararg playersSeen: Player): Vote? {
        if (playersSeen.contains(player)) return InextricableVote(comment = null)

        val newPlayersSeen = (playersSeen.toList() + player).toTypedArray()
        val nextResolve: ResolveFunc = { nextProp, nextPlayer -> resolveVote(nextProp, nextPlayer, *newPlayersSeen) }

        if (totalEndorsements.containsKey(player)) return nextResolve(proposal, totalEndorsements.getOrFail(player))

        if (votes.containsKey(player)) {
            val playerVotes = votes.getOrFail(player)

            if (playerVotes.containsKey(proposal.number)) {
                return playerVotes.getOrFail(proposal.number).compile(proposal, nextResolve)
            }
        }

        return null
    }

    fun compile(): Map<ProposalNumber, SingleProposalVoteMap> {
        val allProposalVotes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()

        val allPlayers = (votes.keys + totalEndorsements.keys).distinct()

        for (proposal in proposals) {
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
