package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone

@UseAssessment
fun assessment8888() = assessment {
    name("8888")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerStone(snail, 3)

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
                "Prime Minister"(0) heldBy Murphy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy null
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(8888) {
            title("More Powerful Dreams")
            ai("2.0")
            author(nix)
            ordinary()

            text(
                """
Amend R2675 ("Dream of Wandering") by replacing:

       - Charity: The Charity Item is the item type that the L&FD owns
         the most of (if there is a tie, the first the L&FD owned, and if
         still tied, the first alphabetically). Immediately after a
         wandering, for each Charity Dreamer, in reverse order of when
         eir Dream was last flipped (and in reverse order of registration
         if tied), one item of the Charity type is transferred from the
         L&FD to em.

with:

       - Charity: A Charity Stamp is a stamp of the type that the L&FD
         owns the most of (if there is a tie, the first the L&FD owned,
         and if still tied, the first alphabetically). Immediately after
         a wandering, for each Charity Dreamer, in reverse order of when
         eir Dream was last flipped (and in reverse order of registration
         if tied), one Charity Stamp is transferred from the L&FD to em.
         If the number of Stamps the L&FD owns is greater than the number
         of active players, this process happens a second time. If it is
         more than twice the number of active players, this process
         happens a third time.

and replacing:

       - Revolution: A revolution is happening if the majority of active
         players are Revolution Dreamers. Immediately after a wandering,
         if a revolution is not happening, then all Revolution Dreamers
         have eir score decreased by 1 to a minimum of 0. Immediately
         after a wandering, if a revolution is happening, then all
         players have eir score set to 100-X, where X was eir score when
         the wandering occured, and all player's Dreams are set to
         Wandering.

with:

       - Revolution: A revolution is happening if the majority of active
         players are Revolution Dreamers. Immediately after a wandering,
         if a revolution is not happening, then all Revolution Dreamers
         have eir score decreased by 1 to a minimum of 0. Immediately
         after a wandering, if a revolution is happening, then all
         players have eir score set to X/Y (rounded down), where X is the
         sum of all scores when the wandering occurred, and Y is the
         number of active players."""
            )
        }
    }

    voting {
    }
}
