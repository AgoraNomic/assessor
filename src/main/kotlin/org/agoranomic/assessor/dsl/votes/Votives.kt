package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.receivers.GeneralVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthModificationDescription

fun GeneralVotingStrengthReceiver.votives(person: Person, amount: VotingStrengthDifference) {
    person add amount describedAs VotingStrengthModificationDescription(
        readable = "Increased by $amount due to votives",
        kind = "votive",
        parameters = mapOf(
            "bonus" to amount.toString(),
        ),
    )
}

fun GeneralVotingStrengthReceiver.votives(person: Person, amount: Int) =
    votives(person, VotingStrengthDifference(amount))
