package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9328() = assessment {
    name("9328")
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
                "Arbitor"(2) heldBy null
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy Nilrem
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy ais523
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Mischief
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

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

    voting {
        votes(Cosmo) {
            FOR on 9328
        }

        votes(Murphy) {
            FOR on 9328
        }

        votes(Nilrem) {
            FOR on 9328
        }

        votes(Galle) {
            AGAINST on 9328
        }

        votes(juan) {
            FOR on 9328
        }

        votes(ais523) {
            FOR on 9328
        }
    }
}
