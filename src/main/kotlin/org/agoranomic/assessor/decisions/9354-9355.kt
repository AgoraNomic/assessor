package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9354to9355() = assessment {
    name("9354-9355")
    quorum(5)

    proposals(v4) {
        proposal(9354) {
            title("Don't scribble in my calendar")
            ai("2.0")
            author(Galle)
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

        proposal(9355) {
            title("Active Confederation")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
[Making it clear that the entities themselves confederate; that is, they
are not confederated by some external entity.]

Amend rule 869 (How to Join and Leave Agora) by replacing "confederated"
with "who confederate""""
            )
        }
    }
}
