package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap

data class PendingVote(val voteFunc: VoteFunc, val comment: String?) {
    fun compile(proposal: Proposal, context: VoteContext): Vote? {
        val vote = voteFunc(proposal, context) ?: return null

        if (comment != null) {
            if (vote.comment != null) {
                return vote.copyWithComment(vote.comment + ": " + comment)
            }

            return vote.copyWithComment(comment)
        }

        return vote
    }
}

data class SinglePersonPendingVoteMap(private val map: ImmutableMap<ProposalNumber, PendingVote>) {
    constructor(map: Map<ProposalNumber, PendingVote>) : this(map.toImmutableMap())

    val proposals get() = map.keys

    fun voteFor(proposalNumber: ProposalNumber) =
        map[proposalNumber] ?: throw IllegalArgumentException("No vote for proposal $proposalNumber")

    fun hasVoteFor(proposal: ProposalNumber) = proposals.contains(proposal)
}

data class MultiPersonPendingVoteMap(private val data: ImmutableMap<Person, SinglePersonPendingVoteMap>) {
    constructor(map: Map<Person, SinglePersonPendingVoteMap>) : this(map.toImmutableMap())

    init {
        require(data.isNotEmpty())
    }

    val voters get() = data.keys

    fun proposalsWithVotes() = data.values.flatMap { it.proposals }.distinct()

    fun votesFor(person: Person) =
        data[person] ?: throw IllegalArgumentException("No votes for person ${person.name}")

    fun hasVotesFor(person: Person) = voters.contains(person)
}
