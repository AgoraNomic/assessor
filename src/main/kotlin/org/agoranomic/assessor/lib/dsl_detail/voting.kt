package org.agoranomic.assessor.lib.dsl_detail

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotingReciever(private val proposals: ImmutableList<Proposal>) {
    constructor(proposals: List<Proposal>) : this(proposals.toImmutableList())

    private val votes = mutableMapOf<Player, Map<ProposalNumber, PendingVote>>()

    infix fun Player.matches(other: Player) = votes(this) {
        functionVote { proposal, context -> context.resolve(proposal, other) } on all
    }

    fun votes(player: Player, block: _VotesReceiver.() -> Unit) {
        require(!votes.containsKey(player)) { "Votes already specified for player ${player.name}" }

        val receiver = _VotesReceiver(proposals.map { it.number })
        receiver.block()
        val result = receiver.compile()

        votes[player] = result
    }


    private fun resolveVote(proposal: Proposal, player: Player, vararg playersSeen: Player): Vote? {
        if (playersSeen.contains(player)) return InextricableVote(comment = null)

        val newPlayersSeen = (playersSeen.toList() + player).toTypedArray()
        val nextResolve: ResolveFunc = { nextProp, nextPlayer -> resolveVote(nextProp, nextPlayer, *newPlayersSeen) }

        val lookupProposal = LookupProposal { this.proposals.lookupOrFail(it) }

        if (votes.containsKey(player)) {
            val playerVotes = votes.getOrFail(player)

            if (playerVotes.containsKey(proposal.number)) {
                return playerVotes.getOrFail(proposal.number).compile(
                    proposal,
                    StandardVoteContext(resolveFunc = nextResolve, lookupProposal = lookupProposal)
                )
            }
        }

        return null
    }

    fun compile(): Map<ProposalNumber, SingleProposalVoteMap> {
        val allProposalVotes = mutableMapOf<ProposalNumber, SingleProposalVoteMap>()

        val voters = votes.keys

        for (proposal in proposals) {
            val proposalVotes = mutableMapOf<Player, Vote>()

            for (voter in voters) {
                val vote = resolveVote(proposal, voter)
                if (vote != null) proposalVotes[voter] = vote
            }

            allProposalVotes[proposal.number] = SingleProposalVoteMap(proposalVotes)
        }

        return allProposalVotes
    }
}
