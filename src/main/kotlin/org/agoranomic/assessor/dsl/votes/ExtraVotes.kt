package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.receivers.ProposalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthModificationDescription
import java.math.BigInteger

fun ProposalVotingStrengthReceiver.extraVotes(person: Person, count: BigInteger) {
    person add VotingStrengthDifference(count) describedAs VotingStrengthModificationDescription(
        readable = "Bought Strength $count times",
        kind = "bought_strength",
        parameters = mapOf(
            "extra_votes" to count.toString()
        )
    )
}

fun ProposalVotingStrengthReceiver.extraVotes(person: Person, count: Int) =
    extraVotes(person, count.toBigInteger())
