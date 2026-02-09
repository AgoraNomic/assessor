package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9287() = assessment {
    name("9287")
    quorum(4)

    proposals(v4) {
        proposal(9287) {
            title("Overexertion")
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

       When the Boulder Falls, all its switches are set to their
       default values.

       Each player CAN push the boulder by announcement. When a player
       pushes the Boulder, its Height is increased by 1. At the beginning
       of each week, if the boulder was pushed in the previous week at
       least as many times as the Boulder's Slope, then the Boulder's
       Slope is increased by 1; otherwise, the Boulder Falls. The
       Absurdor SHOULD list the largest Height and Slope of the Boulder
       ever reached in eir report.

       The Boulder's Instability is an untracked singleton integer
       switch defaulting to 0. When a player pushes the Boulder and
       has already done so earlier that week, the Boulder's
       Instability is increased by 1. At the beginning of each week,
       the Boulder's Instability is set to 0.

       If the Boulder's Instability was greater than 0 at the end of
       the previous week, then the Absurdor SHALL select and announce
       that many random integers from 1 to 10 (inclusive). If any of
       them are 1, or if e fails to do so, then the Boulder Falls.

[Make it possible, though unreliable, for a smaller set of players to
  push the Boulder up a steeper Slope.]"""
            )
        }
    }
}
