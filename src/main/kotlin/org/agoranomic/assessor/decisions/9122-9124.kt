package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9122to9124() = assessment {
    name("9122-9124")
    quorum(5)

    proposals(v4) {
        proposal(9122) {
            title("Hats")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
Create a rule titled "Hats" reading:

Hats are a secured player switch defaulting to "none" with the following
possible values and associated meanings for the player's current focus:

       none: no particular focus

       armored helm: competing for wins and in sub-games

       dunce cap: expressing regret or acknowledging a mistake

       floral wreath: resolving conflict

       green eyeshade: maintaining accurate records

       hard hat: repairing problems in the rules

       jaunty beret: exploring creative expression

       jester's cap: bringing levity and humor

       judicial wig: ruling on CFJs and interpreting the rules

       knitted cap: finding loopholes and exploits

       plain hat: simplifying the rules

       rugged fedora: researching Agoran and Nomic history

       sleeping cap: reducing eir participation in Agora

       steampunk hat: creating new game mechanics

       traditional mortarboard: conducting research and writing theses

A player CAN change eir hat at any time by notifying the recordkeepor for
eir hat (publicly or privately). Unless otherwise specified by the rules:
1) the recordkeepor for a player's hat is the player emself, and 2)
reporting on hats is OPTIONAL.

Hats do not otherwise limit or restrict a player's actions in any way, and
every player is ENCOURAGED to participate in all aspects of the game
regardless of eir current hat."""
            )
        }

        proposal(9123) {
            title("Anniversaries")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
Amend rule 1023 (Agoran Time) by appending:

       5. Any anniversary, monthly anniversary, or quarterly anniversary
          that would otherwise occur on a day of the month that does not
          exist (after considering any leap day) instead occurs on the
          following day."""
            )
        }

        proposal(9124) {
            title("Rock strat")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2683 (The Boulder) by replacing this text:

       Each player CAN, once a week, by announcement, push the boulder.
       When a player pushes the Boulder, its Height is increased by 1.
       At the beginning of each week, if the boulder was not pushed in
       the previous week, the Boulder's Height is set to 0.

with this text:

       Each player CAN, once a week, pay a fee of N + 1 spendies to push
       the Boulder, where N is the number of times e has already done so
       that month. When a player pushes the Boulder, its Height is
       increased by 1. At the beginning of the week, if the Boulder was
       not pushed in the previous week, the Boulder's Height is decreased
       to half its value, rounded down."""
            )
        }
    }
}
