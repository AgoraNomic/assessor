package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9353() = assessment {
    name("9353")
    quorum(6)

    proposals(v4) {
        proposal(9353) {
            title("Costlier crafting")
            ai("1.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2714, change "2 spendies" to "6 spendies".

[Right now, there isn't very much incentive to trade number cards
because you can generally get what you need by crafting, and this is
making it too easy to Outshine The Sun because common number cards are
common enough to make that fairly easily possible.

By making crafting much more expensive, it encourages trading for the
rare cards rather than creating new rare cards.]"""
            )
        }
    }
}
