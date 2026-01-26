package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9284to9286() = assessment {
    name("9284-9286")
    quorum(5)

    proposals(v4) {
        proposal(9284) {
            title("Protecting Farmer's Sovereignty")
            ai("1.0")
            author(juan)
            ordinary()

            text(
                """
[Argument: The low price for destroying a crop makes it so players that
are not engaging with this subgame can effectively sabotage it without
playing at all, since everyone gets basically 2000 Pyrite every month.]

In the paragraph of Rule 2710 that reads

    Once per Crop Season, a player CAN pay a fee of 1000 Pyrite to remove
    a type of out-of-season Crop.

replace the number ô1000ö with ô10000ö:"""
            )
        }

        proposal(9285) {
            title("Push to 1000")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2683 (The Boulder) by replacing this text:

       The Boulder's Slope is a singleton integer switch defaulting to 1,
       tracked by the Absurdor.

       Each player CAN, once a week, by announcement, push the boulder.
       When a player pushes the Boulder, its Height is increased by 1.
       At the beginning of each week, if the boulder was pushed in the
       previous week at least as many times as the Boulder's Slope, then
       the Boulder's Slope is increased by 1; otherwise, the Boulder's
       Height is set to 0, and the Boulder's Slope is set to 1. The
       Absurdor SHOULD list the largest Height and Slope of the Boulder
       ever reached in eir report.

with this text:

       Each player CAN, by announcement, push the Boulder, unless e was
       the most recent player to do so. When a player pushes the Boulder,
       if e correctly and unambiguously specified its previous Height,
       then its Height is increased by 1; otherwise, its Height is set to
       0. At the beginning of each week, if the Boulder was not pushed in
       the previous week, then its Height is set to 0. The Absurdor
       SHOULD list the largest Height of the Boulder ever reached in eir
       report.

       Upon a correct announcement that the Boulder's Height is at least
       1000, each player who pushed it at least once since its Height was
       last 0 Reaches the Summit, then its Height is set to 0. When a
       player Reaches the Summit, e wins the game.

[Inspired by a Discord bot on another server that implements the same
  challenge. I've been watching it for a couple months now; it's failed
  in the 300-600 range about three times, one of which was my fault due
  to not scrolling down properly.]"""
            )
        }

        proposal(9286) {
            title("Less harsh weather")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2709 (The Growth Cycle) by replacing this text:

       Good, Neutral, or Bad (each of which has an equal probability).

with this text:

       Good (probability 30%), Neutral (probability 60%), or Bad
       (probability 10%)."""
            )
        }
    }
}
