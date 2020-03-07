package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDSL
import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.dsl.DslValueMap
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.get
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet

@AssessmentDSL
interface VotingReceiver {
    infix fun Person.matches(other: Person)
    fun votes(person: Person, block: VotesReceiverInit)
}

typealias VotingReceiverInit = DslInit<VotingReceiver>

@AssessmentDSL
private class VotingReceiverImpl(private val proposals: ImmutableProposalSet) : VotingReceiver {
    constructor(proposals: ProposalSet) : this(proposals.toImmutableProposalSet())

    private val votes = DslValueMap<Person, Map<ProposalNumber, PendingVote>>()

    override infix fun Person.matches(other: Person) = votes(this) {
        functionVote { proposal, context -> context.resolve(proposal, other) } on all
    }

    override fun votes(person: Person, block: VotesReceiverInit) {
        require(!votes.containsKey(person)) { "Votes already specified for player ${person.name}" }

        votes[person] = buildVotes(proposals.map { it.number }, block)
    }


    private fun resolveVote(proposal: Proposal, person: Person, vararg playersSeen: Person): Vote? {
        if (playersSeen.contains(person)) return InextricableVote(comment = null)

        val newPlayersSeen = (playersSeen.toList() + person).toTypedArray()
        val nextResolve: ResolveFunc = { nextProp, nextPlayer -> resolveVote(nextProp, nextPlayer, *newPlayersSeen) }

        val lookupProposal = LookupProposal { this.proposals[it] }

        if (votes.containsKey(person)) {
            val playerVotes = votes[person]

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
        val votes = votes.compile()
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

fun buildVoting(proposals: ProposalSet, block: VotingReceiverInit): ImmutableMap<ProposalNumber, SingleProposalVoteMap> {
    return VotingReceiverImpl(proposals).also(block).compile().toImmutableMap()
}
