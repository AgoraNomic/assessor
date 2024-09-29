package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9182to9183() = assessment {
    name("9182-9183")
    quorum(7)

    proposals(v4) {
        proposal(9182) {
            title("???")
            ai("1.0")
            author(Forest)
            coauthors(oliver)
            ordinary()

            text(
                """
Append the following to Rule 2683 ("The Boulder"):
{
The Boulder's Abstrusity is a singleton integer switch defaulting to 0,
tracked by the Absurdor.
When a player pushes the boulder, e CAN, optionally by announcement in the
same message, confuse the boulder. When a player confuses the boulder, its
Abstrusity is increased by 1.
}"""
            )
        }

        proposal(9183) {
            title("Creation Crystals")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2685 (Crystals) by replacing "If a proposal amends or repeals a
rule" with "If a proposal enacts, amends, or repeals a rule".

[Currently you get crystals for repealing rules but not for enacting them.
It feels like both should be rewarded.]"""
            )
        }
    }
}
