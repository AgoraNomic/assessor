package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9346to9350() = assessment {
    name("9346-9350")
    quorum(7)

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
}
