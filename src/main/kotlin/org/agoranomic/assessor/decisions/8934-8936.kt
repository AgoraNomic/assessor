package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8934to8936() = assessment {
    name("8934-8936")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Janet, 3 / 3)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)
            powerDream(Aspen, 2)

            powerStone(Janet, 3)

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
                "Prime Minister"(0) heldBy nix
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
        proposal(8934) {
            title("H4x0r5")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Each player who votes FOR this proposal
commits the crime of ???, which is an infraction of power 10.

Each player who votes FOR this proposal gains 30 radiance."""
            )
        }

        proposal(8935) {
            title("Quicker Peer Expungement")
            ai("2.0")
            author(nix)
            coauthors(Aspen, G)
            ordinary()

            text(
                """
Amend R2555 by replacing:

       Any player who has not expunged a blot by this method this week
       CAN expunge 1 blot from a specified player who has not gained a
       blot this or the previous week, by announcement.

with

       Any player who has not expunged a blot by this method this week
       CAN expunge 1 blot from a specified player by announcement. E
       CANNOT specify emself for this if e has gained any blots this or
       the previous week."""
            )
        }

        proposal(8936) {
            title("Oh come on guys folks")
            ai("2.0")
            author(Forest)
            ordinary()

            text(
                """
Amend Rule 2423 ("First Among Equals") by replacing
"guy" with "person"."""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 8934
            FOR on 8935
            PRESENT on 8936
        }

        votes(nix) {
            AGAINST on 8934
            FOR on 8935
            FOR on 8936
        }

        votes(Yachay) {
            FOR on 8934
            FOR on 8935
            // Second attempted vote of PRESENT on 8935 fails due to not withdrawing
            FOR on 8936
        }

        votes(juan) {
            AGAINST on 8934
            AGAINST on 8935
            FOR on 8936
        }

        votes(Forest) {
            FOR on 8934
            endorse(Murphy) on 8935
            endorse(cuddlybanana) on 8936
        }

        votes(G) {
            FOR on all
        }
    }
}
