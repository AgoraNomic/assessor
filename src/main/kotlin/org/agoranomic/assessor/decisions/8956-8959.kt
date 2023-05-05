package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8956to8959() = assessment {
    name("8956-8959")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(G, 2)
            powerDream(Aspen, 2)
            powerDream(Janet, 2)
            powerDream(Forest, 2)

            powerStone(Janet, 2)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Horsened"(1) heldBy snail
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
        proposal(8956) {
            title("Unradiance")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
Repeal Rule 2657"""
            )
        }

        proposal(8957) {
            title("Unradiance v2")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
>From rule 2657, remove "* Being the author of a proposal that takes
effect, at the instant it finishes taking effect: 4 (must specify
proposal number)""""
            )
        }

        proposal(8958) {
            title("Taken for Granite")
            ai("2.0")
            author(Murphy)
            coauthors(nix)
            ordinary()

            text(
                """
Amend Rule 2642 (Gathering Stones) by replacing "Stone Collector"
with "Stonemason"."""
            )
        }

        proposal(8959) {
            title("Noncompetitive Radiance")
            ai("1.5")
            author(ais523)
            ordinary()

            text(
                """
In rule 2656, amend
{{{
     Upon a correct announcement from a player that eir radiance is 100
     or more (correctly specifying the amount), e wins the game. Then,
     eir radiance is set to 0, and all other players' radiance are set
     to half their current value rounded down.
}}}
to
{{{
     A player whose radiance is 100 or more CAN by announcement Become
     Radiant, as long as e correctly specifies the amount of eir
     Radiance in the same message. When a player Becomes Radiant, e
     wins the game; and when a player wins the game by this mechanism,
     eir Radiance is flipped to 0.
}}}

[Removes the reset on radiance; see my recent these for arguments on
why I think this is beneficial. There are also two bugfixes: one that
handles the situation where a higher-powered rule blocks the win, and
one that prevents radiance wins being accidentally triggered by, e.g.,
the Herald's report when the Herald has 100 radiance.]"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8958
            FOR on 8956
            FOR on 8957
            AGAINST on 8959
        }

        votes(Forest) {
            FOR on 8956
            FOR on 8957
            // NO VOTE on 8958
            PRESENT on 8959
        }

        votes(Yachay) {
            FOR on 8956
            FOR on 8957
            PRESENT on 8958
            FOR on 8959
        }

        votes(Janet) {
            AGAINST on 8956
            AGAINST on 8957
            FOR on 8958
            AGAINST on 8959
        }

        votes(juan) {
            FOR on 8959
            AGAINST on 8956
            AGAINST on 8957
            PRESENT on 8958
        }
    }
}
