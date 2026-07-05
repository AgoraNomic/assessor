package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9354_9356to9357() = assessment {
    name("9354, 9356-9357")
    quorum(7)

    proposals(v4) {
        proposal(9354) {
            title("Don't scribble in my calendar")
            ai("2.0")
            author(Salad)
            coauthors(Galle)
            ordinary()

            text(
                """
[ The author of this proposal assumes that the current ruleset allows
players to leverage Scheduled Actions to bypass the limitation that
certain actions be performed as oneself. This assumption is untested.
This proposal aims to close this loophole by banning the creation of
Scheduled Actions on behalf of another player. ]

In rule 2716, replace:

      A player CAN pay a fee of N spendies

With:

      A player CAN, acting as emself, pay a fee of N spendies"""
            )
        }

        proposal(9356) {
            title("Hailboulder")
            ai("1.0")
            author(juan)
            coauthors(Forest)
            ordinary()

            text(
                """
Ammend Rule 2683 by replacing the paragraph beginning with “Each player
CAN” with the following:

     Each player CAN, once a week, by announcement or by paying a fee
     of one number card of any type, push the boulder. When a player
     pushes the Boulder, its Height is increased by 1. At the beginning
     of each week, if the number of times the boulder was pushed in the
     previous week plus the highest type of card paid to do so (0 if
     none) is at least as many times as the Boulder's Slope, then the
     Boulder's Slope is increased by 1; otherwise, the Boulder's Height
     and the Boulder's Slope are updated according to the following rule:

     * If the value is odd, set it to three times its current value plus
one.
     * If the value is even, set it to half of its current value.

     The Absurdor SHOULD list the largest Height and Slope of the Boulder
     ever reached in eir report."""
            )
        }

        proposal(9357) {
            title("(no title)")
            ai("1.0")
            author(msh210)
            ordinary()

            text(
                """
{
For any integer N greater than Agora's Festivity, any player CAN flip
Agora's Festivity to N with 5 support from N-Festive players, unless
Agora's Festivity has had a value greater than or equal to N in the
past 21 days.
}

immediately after and in addition to the existing sentence

{
For any integer N greater than Agora's Festivity, an N-Festive player
CAN flip Agora's Festivity to N with 4 support from other N-Festive
players, unless Agora's Festivity has had a value greater than or
equal to N in the past 21 days.
}

(I don't see why such a person would want to do so, but if e does then
I don't see any reason to stop em.)"""
            )
        }
    }
}
