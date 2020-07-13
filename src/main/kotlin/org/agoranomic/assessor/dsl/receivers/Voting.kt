package org.agoranomic.assessor.dsl.receivers

import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.detail.DslInit
import org.agoranomic.assessor.dsl.detail.DslValueMap
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.vote.MultiPersonPendingVoteMap
import org.agoranomic.assessor.lib.vote.PendingVote
import org.agoranomic.assessor.lib.vote.SinglePersonPendingVoteMap

@AssessmentDsl
interface MultiPersonVotesReceiver {
    fun votes(person: Person, block: PersonVotesReceiverInit)
}

typealias MultiPersonVotesReceiverInit = DslInit<MultiPersonVotesReceiver>

interface MultiPersonVotesCompiler {
    fun compile(allProposals: ProposalSet, init: MultiPersonVotesReceiverInit): MultiPersonPendingVoteMap
}

@AssessmentDsl
private class DefaultMultiPersonVotesReceiver(
    private val allProposals: ProposalSet,
    private val personVotesCompiler: PersonVotesCompiler
) : MultiPersonVotesReceiver {

    private val personVoteMap = DslValueMap<Person, Map<ProposalNumber, PendingVote>>()

    override fun votes(person: Person, block: PersonVotesReceiverInit) {
        require(!personVoteMap.containsKey(person)) { "Votes already specified for player ${person.name}" }

        personVoteMap[person] = personVotesCompiler.compile(allProposals, block)
    }

    fun compile(): MultiPersonPendingVoteMap {
        val votes = personVoteMap.compile()
        return MultiPersonPendingVoteMap(votes.mapValues { (_, value) -> SinglePersonPendingVoteMap(value) })
    }
}

class DefaultMultiPersonVotesCompiler(
    private val personVotesCompiler: PersonVotesCompiler = DefaultPersonVotesCompiler()
) : MultiPersonVotesCompiler {
    override fun compile(allProposals: ProposalSet, init: MultiPersonVotesReceiverInit): MultiPersonPendingVoteMap {
        return DefaultMultiPersonVotesReceiver(allProposals, personVotesCompiler).also(init).compile()
    }
}
