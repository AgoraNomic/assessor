package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9182to9183() = assessment {
    name("9182-9183")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy oliver
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

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
