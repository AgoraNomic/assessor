package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9288to9291() = assessment {
    name("9288-9291")
    quorum(5)

    proposals(v4) {
        proposal(9288) {
            title("Overexertion v1.1")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2683 (The Boulder) by replacing this text:

       Each player CAN, once a week, by announcement, push the boulder.
       When a player pushes the Boulder, its Height is increased by 1.
       At the beginning of each week, if the boulder was pushed in the
       previous week at least as many times as the Boulder's Slope, then
       the Boulder's Slope is increased by 1; otherwise, the Boulder's
       Height is set to 0, and the Boulder's Slope is set to 1. The
       Absurdor SHOULD list the largest Height and Slope of the Boulder
       ever reached in eir report.

with this text:

       The Boulder's Instability is an untracked integer switch,
       defaulting to 0.

       Boulder Waivers are a currency, tracked by the Absurdor. A
       player CAN pay a fee of one or more Boulder Waivers to affect
       the Boulder's Instability as described by this rule.

       When the Boulder Falls, all its switches are set to their
       default values.

       Each player CAN, once a week, by announcement, push the boulder.
       When a player pushes the Boulder, its Height is increased by 1.

       At the beginning of each week, the Boulder's Instability is set
       to ceiling(S/(P+W)), where S is its Slope, P is the number of
       distinct players who pushed it in the previous week, and V is the
       the number of Boulder Waivers spent in the previous week.

         * If P+W is zero, then the Boulder Falls.

         * Otherwise, during that week, the Absurdor SHALL select and
           announce a number of random integers from 1 to 10 (inclusive)
           equal ot the Boulder's Instability. If none of them are 1,
           then the Boulder's Instability is set to 0.

       At the end of each week, if the Boulder's Instability is greater
       than zero, then the Boulder Falls.

[Make it possible, though unreliable, for a smaller set of players to
  push the Boulder up a steeper Slope. Methods and incentives for
  obtaining Boulder Waivers is left to future proposals.]"""
            )
        }

        proposal(9289) {
            title("Pyrite equity")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
If juan failed to gain any pyrite on or about 2026-01-26 15:04:47 UTC,
then create 1000 pyrite in juan's possession."""
            )
        }

        proposal(9290) {
            title("Welcome Cards")
            ai("1.0")
            author(Trigon)
            ordinary()

            text(
                """
If the rule 2713 "Scoring Numbers" does not include the text "Whenever a
player scores a date" then add the following paragraph to said rule
after the paragraph beginning "Whenever a player scores a number":
{
Whenever a player scores a date, e scores that date in zero-padded MMDD
format (for instance, scoring the thirtieth of June would result in
scoring the number 0630).
}

Amend Rule 2499 "Welcome Packages" by appending to the final paragraph:
"When a player receives a welcome package, e scores the date of eir
registration.""""
            )
        }

        proposal(9291) {
            title("Birthday Cards")
            ai("1.0")
            author(Trigon)
            ordinary()

            text(
                """
If the rule 2713 "Scoring Numbers" does not include the text "Whenever a
player scores a date" then add the following paragraph to said rule
after the paragraph beginning "Whenever a player scores a number":
{
Whenever a player scores a date, e scores that date in zero-padded MMDD
format (for instance, scoring the thirtieth of June would result in
scoring the number 0630).
}

Amend Rule 2585 "Birthday Gifts" by appending a paragraph with the text
"Upon a correct announcement by a player that eir Agoran Birthday has
occurred in the last 15 days, e scores eir Agoran Birthday if e has not
scored eir Agoran Birthday by this method for that instance of eir
Agoran Birthday.""""
            )
        }
    }
}
