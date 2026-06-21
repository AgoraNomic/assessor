package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9346to9350() = assessment {
    name("9346-9350")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2026-June/019345.html")
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
        proposal(9346) {
            title("No double scores for new players")
            ai("1.0")
            author(Trigon)
            ordinary()

            text(
                """
Amend rule 2585, Birthday Gifts, by adding after the text "by this
method for that instance of eir Agoran Birthday" the text "and provided
that that instance of eir Agoran Birthday is not eir date of first
registration""""
            )
        }

        proposal(9347) {
            title("Another Use for Number Cards")
            ai("1.0")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2707 ("Pyrite") by appending the following paragraph:

---
A player CAN pay a fee of 1 number card to gain pyrite equal to the
number of the card's type, or 10 pyrite if it was a 0 card.
---"""
            )
        }

        proposal(9348) {
            title("Inconsolable")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
Repeal rule 2717 (Consolation Prize)

[Eh, worth a shot but the idea didn't end up getting used.]"""
            )
        }

        proposal(9349) {
            title("Stay active")
            ai("3.0")
            author(juan)
            democratic()

            text(
                """
Ammend Rule 2646 by replacing “made a public announcement in the past
30 days” with “pushed the boulder in the last 7 days”."""
            )
        }

        proposal(9350) {
            title("No birthday, how sad")
            ai("1.0")
            author(msh210)
            ordinary()

            text(
                """
Replace Rule 2585, Birthday Gifts, with:
<<
It is considered to be a player's Agoran Birthday on the anniversary
of the day e first registered, provided that that anniversary is not
itself on the day e first registered. If the day a player first
registered is unknown, that player CAN, with Agoran consent, declare a
day to be eir Agoran Birthday. As long as the day a player first
registered remains unknown, it is considered to be eir Agoran Birthday
on the anniversary of the day e most recently declared as eir Agoran
Birthday.

In a timely fashion after the start of a player's Agoran Birthday, the
Registrar SHALL announce it.

Upon a correct announcement by a player that eir Agoran Birthday has
occurred in the last 15 days, e scores eir Agoran Birthday if e has
not scored eir Agoran Birthday by this method for that instance of eir
Agoran Birthday.
 >>"""
            )
        }
    }

    voting {
        votes(Cosmo) {
            FOR on 9346
            FOR on 9347
            FOR on 9348
            AGAINST on 9349
            PRESENT on 9350
        }

        votes(juan) {
            endorse(msh210) on 9346
            PRESENT on 9347
            PRESENT on 9348
            FOR on 9349
            endorse(msh210) on 9350
        }

        votes(Galle) {
            AGAINST on 9346
            FOR on 9347
            FOR on 9348
            AGAINST on 9349
            FOR on 9350
        }

        votes(Janet) {
            PRESENT on 9346
            AGAINST on 9347
            PRESENT on 9348
            AGAINST on 9349
            PRESENT on 9350
        }

        votes(Mischief) {
            AGAINST on 9346
            FOR on 9347
            FOR on 9348
            AGAINST on 9349
            FOR on 9350
        }

        votes(msh210) {
            FOR on 9346
            AGAINST on 9349
            FOR on 9350
            // No other votes.
        }

        votes(ais523) {
            resolvedConditional(AGAINST, "the referendum on P9350 could be resolved as ADOPTED") on 9346
            PRESENT on 9347
            AGAINST on 9348
            AGAINST on 9349
            FOR on 9350
        }

        votes(Murphy) {
            FOR on 9346
            endorseOfficer("Numerator", Trigon) on 9347
            AGAINST on 9348
            AGAINST on 9349
            FOR on 9350
        }
    }
}
