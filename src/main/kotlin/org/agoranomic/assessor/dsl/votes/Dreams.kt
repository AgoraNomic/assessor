package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.receivers.GeneralVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthModificationDescription

fun GeneralVotingStrengthReceiver.powerDream(person: Person, amount: VotingStrengthDifference) {
    person add amount describedAs VotingStrengthModificationDescription(
        readable = "Increased by $amount due to Dream of Power",
        kind = "power_dream",
        parameters = mapOf(
            "bonus" to amount.toString(),
        ),
    )
}

fun GeneralVotingStrengthReceiver.powerDream(person: Person, amount: Int) =
    powerDream(person, VotingStrengthDifference(amount))