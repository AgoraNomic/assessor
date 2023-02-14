package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8889to8890() = assessment {
    name("8889-8890")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Forest, 2)

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
                "Referee"(2) heldBy snail
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
        proposal(8889) {
            title("Forced Mad Engineer Election")
            ai("1.0")
            author(Forest)
            coauthors(G)
            ordinary()

            text(
                """
An election for Mad engineer is hereby initiated."""
            )
        }

        proposal(8890) {
            title("Here comes a new challenger!")
            ai("2.0")
            author(Murphy)
            coauthors(Forest, G)
            ordinary()

            text(
                """
Amend Rule 2651 (The Election Cycle) by replacing this text:

      a) with 2 support, if either the office is interim or term-
      limited, and provided that the initiator becomes a candidate in
      the same message.

with this text:

      a) With 2 support (if the office is either interim or term-
      limited) or 4 support (otherwise), and provided that the initiator
      becomes a candidate in the same message."""
            )
        }
    }

    voting {
        votes(Murphy) {
            FOR on 8889
            FOR on 8890
        }
    }
}
