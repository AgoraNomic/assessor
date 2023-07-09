package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9002() = assessment {
    name("9002")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(G, 2)
            powerDream(Aspen, 2)
            powerDream(Forest, 2)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Buttonmastor"(3) heldBy juan
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy Forest
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Forest
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy null
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy G
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9002) {
            title("Active rocks")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2642 ("Gathering Stones") by replacing "Rockiness is a player
switch" with "Rockiness is an active player switch"."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9002
        }

        votes(Murphy) {
            FOR on 9002
        }

        votes(Janet) {
            FOR on 9002
        }

        votes(juan) {
            PRESENT on 9002
        }
    }
}
