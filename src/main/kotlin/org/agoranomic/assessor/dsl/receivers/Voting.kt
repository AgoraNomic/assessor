package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.dsl.DslValueMap
import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.proposal_set.toImmutableProposalSet

@AssessmentDsl
interface MultiPersonVotesReceiver {
    infix fun Person.matches(other: Person)
    fun votes(person: Person, block: PersonVotesReceiverInit)
}

typealias MultiPersonVotesReceiverInit = DslInit<MultiPersonVotesReceiver>

interface MultiPersonVotesCompiler {
    fun compile(init: MultiPersonVotesReceiverInit): MultiPersonPendingVoteMap
}

@AssessmentDsl
private class DefaultMultiPersonVotesReceiver(private val personVotesCompiler: PersonVotesCompiler) : MultiPersonVotesReceiver {

    private val personVoteMap = DslValueMap<Person, Map<ProposalNumber, PendingVote>>()

    override infix fun Person.matches(other: Person) = votes(this) {
        functionVote { proposal, context -> context.resolve(proposal, other) } on all
    }

    override fun votes(person: Person, block: PersonVotesReceiverInit) {
        require(!personVoteMap.containsKey(person)) { "Votes already specified for player ${person.name}" }

        personVoteMap[person] = personVotesCompiler.compile(block)
    }

    fun compile(): MultiPersonPendingVoteMap {
        val votes = personVoteMap.compile()
        return MultiPersonPendingVoteMap(votes.mapValues { (_, value) -> SinglePersonPendingVoteMap(value) })
    }
}

class DefaultMultiPersonVotesCompiler(private val personVotesCompiler: PersonVotesCompiler) : MultiPersonVotesCompiler {
    override fun compile(init: MultiPersonVotesReceiverInit): MultiPersonPendingVoteMap {
        return DefaultMultiPersonVotesReceiver(personVotesCompiler).also(init).compile()
    }
}

fun buildMultiPersonVotes(
    proposals: ProposalSet,
    block: MultiPersonVotesReceiverInit
): MultiPersonPendingVoteMap {
    return DefaultMultiPersonVotesCompiler(DefaultPersonVotesCompiler(proposals.numbers().toList())).compile(block)
}
