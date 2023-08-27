package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9005to9008() = assessment {
    name("9005-9008")
    quorum(4)

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
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy Forest
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy ais523
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
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
        proposal(9005) {
            title("Unreality stone")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2643 by replacing the paragraph beginning "A Collection
Notice includes a random" with the following paragraph:

{

A Collection Notice includes a random integer from 1 to 6; this is the
Escape Minimum.

}

["Number" means real number by default.]"""
            )
        }

        proposal(9006) {
            title("Freeing Sisyphus")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Repeal Rule 2683 ("The Boulder")."""
            )
        }

        proposal(9007) {
            title("Shining a flashlight")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Repeal Rule 2056 ("Invisibilitating")."""
            )
        }

        proposal(9008) {
            title("Always at risk")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2683 (The Boulder) to read, in full:
{

      The Absurdor is an office.

      The Boulder's Height is a singleton integer switch defaulting to
      0, tracked by the Absurdor.

      Each player CAN, once a week, by announcement, push the boulder.
      When a player pushes the Boulder, its Height is increased by 1.
      At the beginning of each week, if the boulder was not pushed in the
previous week, the Boulder's Height is set to 0. The Absurdor SHOULD list
the largest Height of the Boulder ever reached in eir report.
}"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9005
            AGAINST on 9006
            FOR on 9007
            FOR on 9008
        }

        votes(juan) {
            PRESENT on 9005
            AGAINST on 9006
            PRESENT on 9007
            FOR on 9008
        }

        votes(Murphy) {
            endorse(Janet) on 9005 comment "${Janet.name} is the Stonemason"
            endorse(juan) on 9006 comment "${juan.name} is the Absurdor"
            FOR on 9007
            endorse(juan) on 9008 comment "${juan.name} is the Absurdor"
        }
    }
}
