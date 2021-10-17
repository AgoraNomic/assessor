package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthModificationDescription

fun GlobalVotingStrengthReceiver.festival(
    minStrength: Int,
    maxStrength: Int,
    festivePlayers: Set<Person>,
) {
    default(0) describedAs VotingStrengthModificationDescription(
        readable = "Not Festive",
        kind = "festival",
        parameters = mapOf("festive" to "false"),
    )

    min(minStrength)
    max(maxStrength)

    val festiveDescription = VotingStrengthModificationDescription(
        readable = "Festive",
        kind = "festival",
        parameters = mapOf("festive" to "true"),
    )

    for (person in festivePlayers) {
        person initial maxStrength describedAs festiveDescription
    }
}
