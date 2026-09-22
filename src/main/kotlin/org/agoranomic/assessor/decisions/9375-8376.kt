package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9375to9376() = assessment {
    name("9375-9376")
    quorum(5)

    proposals(v4) {
        proposal(9375) {
            title("Acyclic Voting")
            ai("3.0")
            author(pizza723)
            democratic()

            text(
                """
Amend rule 2127 "Conditional Votes" by replacing the sentence

     If the conditional is clearly specified, and evaluates to
     a valid vote, it is counted as that vote; otherwise, it is counted
     as PRESENT.

with

     If the conditional is clearly specified, and evaluates to
     a valid vote that does not depend on its own evaluation, it is
counted as that vote; otherwise, it is counted
     as PRESENT."""
            )
        }

        proposal(9376) {
            title("Cancellation Insurance")
            ai("1.0")
            author(Ronic)
            ordinary()

            text(
                """
Amend Rule 2716 ("Scheduled Actions") by adding the following paragraph:

"When creating a Scheduled Action, its creator CAN pay an additional
fee of 1 Spendie to make it cancellable. The creator of a cancellable
Scheduled Action CAN cancel it by announcement before its Time. When a
Scheduled Action is cancelled, it ceases to exist. Cancelling a
Scheduled Action does not refund any Spendies paid to create it."

Rationale: This creates a paid escape hatch for mistakes and changed
circumstances without making every Scheduled Action reversible for
free."""
            )
        }
    }
}