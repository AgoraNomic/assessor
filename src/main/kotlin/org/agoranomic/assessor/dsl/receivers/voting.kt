package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.*

@AssessmentDSL
class _VotingReciever(private val proposals: ImmutableList<Proposal>) {
    constructor(proposals: List<Proposal>) : this(proposals.toImmutableList())

    private val votes = mutableMapOf<Person, Map<ProposalNumber, PendingVote>>()

    infix fun Person.matches(other: Person) = votes(this) {
        functionVote { proposal, context -> context.resolve(proposal, other) } on all
    }

    fun votes(person: Person, block: _VotesReceiver.() -> Unit) {
        require(!votes.containsKey(person)) { "Votes already specified for player ${person.name}" }

        val receiver = _VotesReceiver(proposals.map { it.number })
        receiver.block()
        val result = receiver.compile()

        votes[person] = result
    }


    private fun resolveVote(proposal: Proposal, person: Person, vararg playersSeen: Person): Vote? {
        if (playersSeen.contains(person)) return InextricableVote(comment = null)

        val newPlayersSeen = (playersSeen.toList() + person).toTypedArray()
        val nextResolve: ResolveFunc = { nextProp, nextPlayer -> resolveVote(nextProp, nextPlayer, *newPlayersSeen) }

        val lookupProposal = LookupProposal { this.proposals.lookupOrFail(it) }

        if (votes.containsKey(person)) {
            val playerVotes = votes.getOrFail(person)

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
            val proposalVotes = mutableMapOf<Person, Vote>()

            for (voter in voters) {
                val vote = resolveVote(proposal, voter)
                if (vote != null) proposalVotes[voter] = vote
            }

            allProposalVotes[proposal.number] = SingleProposalVoteMap(proposalVotes)
        }

        return allProposalVotes
    }
}
