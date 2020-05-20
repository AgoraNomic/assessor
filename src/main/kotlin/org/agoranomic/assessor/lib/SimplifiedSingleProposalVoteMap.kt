package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap

data class SimplifiedSingleProposalVoteMap(private val data: ImmutableMap<Person, SimpleVote>) {
    constructor(map: Map<Person, SimpleVote>) : this(map.toImmutableMap())

    val voters get() = Persons(data.keys)
    val voteCount get() = voters.size

    operator fun get(p: Person) = data[p] ?: throw IllegalArgumentException("Player is not a voter")

    fun personsWithVote(kind: VoteKind): Persons {
        return Persons(data.filterValues { vote -> vote.kind == kind }.keys)
    }

    fun votesWithComments(): SimplifiedSingleProposalVoteMap {
        return SimplifiedSingleProposalVoteMap(data.filterValues { it.comment != null })
    }
}

fun SimplifiedSingleProposalVoteMap.votersFor() = personsWithVote(VoteKind.FOR)
fun SimplifiedSingleProposalVoteMap.votersAgainst() = personsWithVote(VoteKind.AGAINST)

fun strengthWithVote(
    targetVote: VoteKind,
    votes: SimplifiedSingleProposalVoteMap,
    strengths: VotingStrengthMap
) =
    votes.personsWithVote(targetVote)
        .map { strengths[it] }
        .fold(VotingStrength.zero()) { acc, next -> acc + next.value }
