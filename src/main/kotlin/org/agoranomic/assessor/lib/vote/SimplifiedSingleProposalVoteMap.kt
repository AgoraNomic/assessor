package org.agoranomic.assessor.lib.vote

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.voting_strength.VotingStrength
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthTrailForPersons
import org.agoranomic.assessor.lib.voting_strength.plus

data class SimplifiedSingleProposalVoteMap(
    private val data: ImmutableMap<Person, ResolvingVoteResolvedVote>,
) {
    constructor(map: Map<Person, ResolvingVoteResolvedVote>) : this(map.toImmutableMap())

    val voters get() = Persons(data.keys)
    val voteCount get() = voters.size

    fun personsWithVote(kind: VoteKind): Persons {
        return Persons(data.filterValues { vote -> vote.resolution == kind }.keys)
    }

    fun voteFor(person: Person): VoteKind {
        return data.getValue(person).resolution
    }

    fun voteDescriptionsFor(person: Person): ImmutableList<VoteStepDescription> {
        return data.getValue(person).stepDescriptions
    }

    fun toMap(): ImmutableMap<Person, ResolvingVoteResolvedVote> = data
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
        .fold(VotingStrength.zero()) { acc, next -> (acc.asDifference()) + next }
}
