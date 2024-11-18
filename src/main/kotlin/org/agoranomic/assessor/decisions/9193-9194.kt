package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9193to9194() = assessment {
    name("9193-9194")
    quorum(3)

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
}
