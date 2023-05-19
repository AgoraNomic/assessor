package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8971() = assessment {
    name("8971")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(G, 2)
            powerDream(Aspen, 2)
            powerDream(Forest, 2)

            powerStone(Janet, 3)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy nix
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy nix
            }
        }
    }

    proposals(v4) {
        proposal(8971) {
            title("A Pox!")
            ai("1.0")
            author(nix)
            ordinary()

            text("Grant each player that did not vote FOR this proposal 2 blots.")
        }
    }

    voting {
        votes(nix) {
            FOR on 8971
        }

        votes(Forest) {
            FOR on 8971
        }

        votes(ais523) {
            // TODO: resolve conditional vote on 8971: FOR if the outcome of this decision would be ADOPTED even if this vote resolved to AGAINST, or AGAINST in all other cases
        }

        votes(Janet) {
            FOR on 8971
        }

        votes(G) {
            resolvedConditional(AGAINST, "G. did vote FOR the above proposal") on 8971
        }

        votes(snail) {
            AGAINST on 8971
        }

        votes(Murphy) {
            FOR on 8971
        }
    }
}
