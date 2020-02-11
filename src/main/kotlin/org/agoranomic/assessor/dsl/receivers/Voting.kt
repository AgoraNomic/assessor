package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.lib.*

@AssessmentDSL
interface VotingReceiver {
    infix fun Person.matches(other: Person)
    fun votes(person: Person, block: _VotesReceiver.() -> Unit)
}

@AssessmentDSL
class VotingReceiverImpl(private val proposals: ImmutableList<Proposal>) : VotingReceiver {
    constructor(proposals: List<Proposal>) : this(proposals.toImmutableList())

    private val votes = mutableMapOf<Person, Map<ProposalNumber, PendingVote>>()

    override infix fun Person.matches(other: Person) = votes(this) {
        functionVote { proposal, context -> context.resolve(proposal, other) } on all
    }

    override fun votes(person: Person, block: _VotesReceiver.() -> Unit) {
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
        val voters = votes.keys

        return proposals.associateWith { proposal ->
            val proposalVotes =
                voters
                    .associateWith { voter -> resolveVote(proposal, voter) }
                    .filterValues { vote -> vote != null }
                    .mapValues { (_, vote) -> vote!! }

            SingleProposalVoteMap(proposalVotes)
        }.mapKeys { (proposal, _) -> proposal.number }
    }
}
