package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9247() = assessment {
    name("9247")
    quorum(4)

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
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy null
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Kate
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9247) {
            title("Allow no-ops")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2667 (Succumbing to Time) to read:

       A player CAN Succumb by announcement. Upon doing so, if e has not
       already Succumbed that month, then each of eir deadlines to
       perform an Officer's duty or judge a Call for Judgement is
       extended by 1 day if it would otherwise expire within the next
       week.

[My recordkeeping software currently doesn't check "did this player
  already succumb this month", though I checked the database and didn't
  find any oversights that weren't already corrected. I could get around
  to implementing a check, or alternatively I could make it only matter
  if/when someone actually bothers to note an infraction.]"""
            )
        }
    }

    voting {
        votes(Mischief) {
            FOR on 9247
        }

        votes(juan) {
            FOR on 9247
        }

        votes(Cosmo) {
            FOR on 9247
        }

        votes(Janet) {
            PRESENT on 9247
        }
    }
}