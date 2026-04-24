package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9328() = assessment {
    name("9328")
    quorum(4)

    proposals(v4) {
        proposal(9328) {
            title("Revival")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
Create a new power-2 rule, "Purchased Re-enactment":
{{{
For the purpose of this rule, a proposal or former proposal is an
"adopted proposal" if any past referendum on that proposal or former
proposal had an outcome oF ADOPTED.

A player CAN revive an adopted proposal by paying a fee of 25
Spendies. When a player does so, this rule performs the same rules
changes that that adopted proposal would perform if it took effect
right now.
}}}"""
            )
        }
    }
}
