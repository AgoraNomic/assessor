package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9002() = assessment {
    name("9002")
    quorum(5)

    proposals(v4) {
        proposal(9002) {
            title("Active rocks")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2642 ("Gathering Stones") by replacing "Rockiness is a player
switch" with "Rockiness is an active player switch"."""
            )
        }
    }
}
