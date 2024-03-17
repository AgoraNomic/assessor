package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.dsl.votes.powerStone

@UseAssessment
fun assessment9068to9069() = assessment {
    name("9068-9069")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)
            powerDream(Jimmy, 2)

            powerStone(Janet, 3)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy nix
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy snail
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Jimmy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
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
        proposal(9068) {
            title("Agora of Empires")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
//Comment:  This subgame is a very rule-light and
experimental worldbuilding game that is officerless but CfJ-reliant (so I
encourage people to take into account the Arbitor's opinion on this). I
intend to play as some fantasy race and progress my civilization one step
at a time but feel free to play in any way you want - what goes and doesn't
will ultimately depend on our collective CfJs.

Create a new Power-1 rule called "Agora of Empires" with this content:

"There exists a document known as the Empireworld, which should describe in
some way a fictional world. Each player that has amended this document is
said to have their own Empire in the Empireworld, and such players are
Imperials.

A player CAN amend the Empireworld once per week by announcement to
narratively progress the Empireworld in some reasonable fashion. The
message with this kind of announcement MUST include the latest form of the
Empireworld post-amendment. These amendments MUST follow relevant guidance
given in CfJs. Imperials are ENCOURAGED to shape this subgame through CfJs.

Any person can amend the Empireworld without 2 objections and Imperials are
ENCOURAGED to attempt this action when ey believe it to be appropriate.

An Imperial can, by announcement, win the game without 2 objections if the
Empireworld shows that ey have accomplished at least 3 extraordinary feats
in the fictional world that the Empireworld describes since ey last won the
game in this way. This rule does not describe what qualifies as an
extraordinary feat.""""
            )
        }

        proposal(9069) {
            title("Coauthored Crystals")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2685 (Crystals) by replacing
{

- If that crystal's owner is not the author of that proposal, the
        instability of that crystal is increased by 3.

}

with


{

- If that crystal's owner is not the author of that proposal, the
        instability of that crystal is increased by 1.

- If that crystal's owner is not the author or coauthor of that proposal,
the
        instability of that crystal is increased by 2.

}

[This makes the rule function the same when there's no coauthors, but if
there's a coauthor that owns the crystal of the modified rule, its
instability is only increased by 1 instead of 3.]"""
            )
        }
    }

    voting {
    }
}
