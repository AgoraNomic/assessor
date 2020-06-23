package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.receivers.GeneralVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrengthDifference

fun GeneralVotingStrengthReceiver.blotPenalty(person: Person, amount: VotingStrengthDifference) {
    person subtract amount
}

fun GeneralVotingStrengthReceiver.blotPenalty(person: Person, amount: Int) =
    blotPenalty(person, VotingStrengthDifference(amount))
