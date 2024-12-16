package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOrElse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9193to9194() = assessment {
    name("9193-9194")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2024-November/018144.html")
    quorum(3)

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
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy oliver
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9193) {
            title("Devaluation")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2695 (The Veblen) by adding this paragraph after the
paragraph beginning "A player CAN pay a fee of X spendies,":

       If the Veblen has not been transferred or devalued within the past
       month, then a player CAN devalue the Veblen by announcement, thus
       setting the Veblen cost to half its current value (rounded up).

[It's been over two months since anyone bought the Veblen. While
  multi-player coalitions are a fine theory, there is no particular
  evidence that the current rule will inspire them to act.]"""
            )
        }

        proposal(9194) {
            title("Ollie Ollie Oxen Free")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[Untracked subgames and variables with long histories are a bad
combination.]

Amend rule 2697 (The Bounty Board) by adding at the end as a new paragraph:

       A player CAN wipe the slate clean by announcement if the match
       state is none and no one has done so in the current quarter. Upon
       doing so, all bounty amounts are flipped to zero."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9193
            FOR on 9194
        }

        votes(Mischief) {
            endorseOrElse(oliver, FOR) on 9193 comment "${oliver.name} owns the Veblen"
            FOR on 9194
        }

        votes(Janet) {
            PRESENT on 9193
            FOR on 9194
        }

        votes(Murphy) {
            FOR on 9193
            FOR on 9194
        }
    }
}
