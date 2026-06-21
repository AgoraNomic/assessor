package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9351to9352() = assessment {
    name("9351-9352")
    quorum(6)

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
                "Prime Minister"(0) heldBy Kate
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

    voting {
        votes(msh210) {
            // NO VOTE on 9351
            FOR on 9352
        }

        votes(Mischief) {
            FOR on 9351
            FOR on 9352
        }

        votes(Murphy) {
            FOR on 9351
            endorseOfficer("Speaker", Janet) on 9352
        }

        votes(Trigon) {
            PRESENT on 9351
            FOR on 9352
        }

        votes(Galle) {
            PRESENT on 9351
            endorseOfficer("Speaker", Janet) on 9352
        }
    }
}
