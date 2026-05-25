package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9342to9345() = assessment {
    name("9342-9345")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Janet
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9342) {
            title("Secure Scoring")
            ai("1.0")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2713 ("Scoring Numbers") by appending the following paragraph:
---
Causing a player to score a number is secured.
---"""
            )
        }

        proposal(9343) {
            title("Secure Farming")
            ai("1.0")
            author(Galle)
            ordinary()

            text(
                """
If Proposal 9333 was adopted, amend Rule 2709 ("The Growth Cycle") by
appending the following sentence to the first paragraph:
---
Causing a Crop to ripen is secured.
---"""
            )
        }

        proposal(9344) {
            title("Number make other number go up")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2683 (The Boulder) by replacing the paragraph starting "Each
player CAN, once a week, by announcement, push the boulder." with:

       Each player CAN, once a week, by announcement or by paying a fee
       of one number card of any type, push the boulder. When a player
       pushes the Boulder, its Height is increased by 1. At the beginning
       of each week, if the number of times the boulder was pushed in the
       previous week plus the highest type of card paid to do so (0 if
       none) is at least as many times as the Boulder's Slope, then the
       Boulder's Slope is increased by 1; otherwise, the Boulder's Height
       is set to 0, and the Boulder's Slope is set to 1. The Absurdor
       SHOULD list the largest Height and Slope of the Boulder ever
       reached in eir report."""
            )
        }

        proposal(9345) {
            title("Operands v1.1/1")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Create a rule titled "Operands" with this text:

       Operand is a player switch, tracked by the Numerator, with values
       Sum (default), Difference, Product, and Quotient.

       Once per month, a player CAN flip eir Operand by announcement.

Amend Rule 2714 (Spending Number Cards) by replacing the paragraph
starting "For any two decimal digits X and Y" with this text:

       For any two decimal digits X and Y (which may be the same), a
       player CAN pay 2 spendies, a number card of type X, and a number
       card of type Y to grant emself a number card whose type is equal
       (modulo 10) to:

         * X+Y, if eir Operand is Sum

         * X-Y or Y-X, if eir Operand is Difference

         * X*Y, if eir Operand is Product

         * floor(X/Y) or ceiling(X/Y), if eir Operand is Quotient and Y
           is not 0"""
            )
        }
    }

    voting {
    }
}
