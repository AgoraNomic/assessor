package org.agoranomic.assessor.lib.vote

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.voting_strength.VotingStrength
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthTrailForPersons
import org.agoranomic.assessor.lib.voting_strength.plus

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
    strengths: VotingStrengthTrailForPersons
): VotingStrength {
    return votes
        .personsWithVote(targetVote)
        .map { strengths.finalStrengthForPerson(it) }
        .fold(VotingStrength.zero()) { acc, next -> (acc.absoluteValue) + next }
}
