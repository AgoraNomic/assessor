package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.dsl.DslValueMap
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.get
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet
import org.agoranomic.assessor.lib.util.getOrFail

@AssessmentDsl
interface MultiPersonVotesReceiver {
    infix fun Person.matches(other: Person)
    fun votes(person: Person, block: PersonVotesReceiverInit)
}

typealias MultiPersonVotesReceiverInit = DslInit<MultiPersonVotesReceiver>

@AssessmentDsl
private class MultiPersonVotesReceiverImpl(private val proposals: ImmutableProposalSet) : MultiPersonVotesReceiver {
    constructor(proposals: ProposalSet) : this(proposals.toImmutableProposalSet())

    private val personVoteMap = DslValueMap<Person, Map<ProposalNumber, PendingVote>>()

    override infix fun Person.matches(other: Person) = votes(this) {
        functionVote { proposal, context -> context.resolve(proposal, other) } on all
    }

    override fun votes(person: Person, block: PersonVotesReceiverInit) {
        require(!personVoteMap.containsKey(person)) { "Votes already specified for player ${person.name}" }

        personVoteMap[person] = buildPersonVotes(proposals.map { it.number }, block)
    }


    private fun resolveVote(proposal: Proposal, person: Person, vararg playersSeen: Person): Vote? {
        if (playersSeen.contains(person)) return InextricableVote(comment = null)

        val newPlayersSeen = (playersSeen.toList() + person).toTypedArray()
        val nextResolve: ResolveFunc = { nextProp, nextPlayer -> resolveVote(nextProp, nextPlayer, *newPlayersSeen) }

        val lookupProposal = LookupProposal { this.proposals[it] }

        if (personVoteMap.containsKey(person)) {
            val playerVotes = personVoteMap[person]

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
        val personVotes = personVoteMap.compile()
        val voters = personVotes.keys

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

fun buildMultiPersonVotes(
    proposals: ProposalSet,
    block: MultiPersonVotesReceiverInit
): ImmutableMap<ProposalNumber, SingleProposalVoteMap> {
    return MultiPersonVotesReceiverImpl(proposals).also(block).compile().toImmutableMap()
}
