package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9351to9352() = assessment {
    name("9351-9352")
    quorum(6)

    proposals(v4) {
        proposal(9351) {
            title("Delenda Est")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
Repeal rule 2719 (The Petit Dummvirate)

[It incentivizes administratively burdensome maneuvers to avoid
triggering the automatic penalty, and it doesn't alter the balance of
power between duumvirs and non-duumvirs.]"""
            )
        }

        proposal(9352) {
            title("Cat Wrangling")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
[The new "is ENCOURAGED" sentence is the only substantive change; the
rest is just inserting a paragraph break.]

Amend rule 103 (The Speaker) by replacing the text:

       The Speaker is an imposed office and the figurehead leader of
       Agora. The player or players who have most recently won the game
       are called Laureled. If at any time the office of Speaker is
       vacant, or when one or more players win Agora, then the Prime
       Minister CAN once appoint a Laureled player to the office of
       Speaker by announcement.

with:

       The Speaker is an imposed office and the figurehead leader of
       Agora. The Speaker is ENCOURAGED to remind players and officers of
       upcoming Agoran scheduled events and deadlines

       The player or players who have most recently won the game are
       called Laureled. If at any time the office of Speaker is vacant,
       or when one or more players win Agora, then the Prime Minister CAN
       once appoint a Laureled player to the office of Speaker by
       announcement."""
            )
        }
    }
}
