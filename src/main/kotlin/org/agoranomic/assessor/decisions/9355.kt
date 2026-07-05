package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9355() = assessment {
    name("9355")
    quorum(5)

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
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        /*
        proposal(9354) {
            title("Don't scribble in my calendar")
            ai("2.0")
            author(Galle)
            ordinary()

            text(
                """
[ The author of this proposal assumes that the current ruleset allows
players to leverage Scheduled Actions to bypass the limitation that
certain actions be performed as oneself. This assumption is untested.
This proposal aims to close this loophole by banning the creation of
Scheduled Actions on behalf of another player. ]

In rule 2716, replace:

      A player CAN pay a fee of N spendies

With:

      A player CAN, acting as emself, pay a fee of N spendies"""
            )
        }
         */

        proposal(9355) {
            title("Active Confederation")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
[Making it clear that the entities themselves confederate; that is, they
are not confederated by some external entity.]

Amend rule 869 (How to Join and Leave Agora) by replacing "confederated"
with "who confederate""""
            )
        }
    }

    voting {
        votes(Cosmo) {
            // FOR on 9354
            FOR on 9355
        }

        votes(Galle) {
            // FOR on 9354
            FOR on 9355
        }

        votes(Forest) {
            // AGAINST on 9354
            // NO VOTE on 9355
        }

        votes(ais523) {
            // FOR on 9354
            FOR on 9355
        }

        votes(juan) {
            // PRESENT on 9354
            PRESENT on 9355
        }

        votes(Mischief) {
            // FOR on 9354
            FOR on 9355
        }

        votes(pizza723) {
            // FOR on 9354
            FOR on 9355
        }
    }
}
