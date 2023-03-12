package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8921() = assessment {
    name("8921")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)

            powerStone(snail, 6)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy nix
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Horsened"(1) heldBy snail
                "Mad Engineer"(1) heldBy Janet
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Janet
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8921) {
            title("ReGardening")
            ai("2")
            author(nix)
            ordinary()

            text(
                """
Amend R2675 (Dream of Wandering) by replacing:

       - Gardens: Once per week, a Gardens Dreamer CAN, by announcement,
         transfer the mossiest stone (if there is a tie, then a specified
         stone tied for mossiest) Agora owns to emself. E SHOULD specify
         the stone when doing so.

with:

       - Gardens: Immediately after a wandering, the Base Rockiness of
         each Gardens Dreamer is increased by 1."""
            )
        }
    }

    voting {
        votes(Forest) {
            FOR on 8921
        }

        votes(nix) {
            FOR on 8921
        }

        votes(Janet) {
            FOR on 8921
        }
    }
}
