package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8956to8959() = assessment {
    name("8956-8959")
    quorum(4)

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
}
