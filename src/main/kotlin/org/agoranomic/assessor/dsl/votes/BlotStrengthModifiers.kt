package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.receivers.GeneralVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrengthDifference
import org.agoranomic.assessor.lib.VotingStrengthModificationDescription

fun GeneralVotingStrengthReceiver.blotPenalty(person: Person, amount: VotingStrengthDifference) {
    person subtract amount describedAs VotingStrengthModificationDescription(
        readable = "Decreased by $amount due to blots",
        kind = "blots",
        parameters = mapOf(
            "penalty" to amount.toString()
        )
    )
}

fun GeneralVotingStrengthReceiver.blotPenalty(person: Person, amount: Int) =
    blotPenalty(person, VotingStrengthDifference(amount))
