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
import io.github.random_internet_cat.util.getOrFail

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

    fun compile(): MultiPersonPendingVoteMap {
        val votes = personVoteMap.compile()
        return MultiPersonPendingVoteMap(votes.mapValues { (_, value) -> SinglePersonPendingVoteMap(value) })
    }
}

fun buildMultiPersonVotes(
    proposals: ProposalSet,
    block: MultiPersonVotesReceiverInit
): MultiPersonPendingVoteMap {
    return MultiPersonVotesReceiverImpl(proposals).also(block).compile()
}
