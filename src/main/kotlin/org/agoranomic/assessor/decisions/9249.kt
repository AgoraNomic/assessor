package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9249() = assessment {
    name("9249")
    quorum(3)

    proposals(v4) {
        proposal(9249) {
            title("Streamlined fees")
            ai("3.0")
            author(Murphy)
            democratic()

            text(
                """
Amend Rule 2579 (Fee-based Actions) by replacing this text:

       To use a fee-based method, an entity (the Actor) who is otherwise
       permitted to perform the action must announce that e is performing
       the action; the announcement must specify the correct set of
       assets for the fee and indicate intent to pay that fee for the
       sole purpose of using that method to perform that action.

with this text:

       To use a fee-based method, an entity (the Actor) who is otherwise
       permitted to perform the action must announce that e is performing
       the action; such an announcement indicates intent to pay that fee
       for the sole purpose of using that method to perform that action,
       and e SHALL specify the correct set of assets for that fee, though
       simplified wording such as "I buy X" is sufficient if the fee paid
       is reasonably unambiguous.

[This month, there were half a dozen announcements like "I buy X" or "I
  plant X" where there was no ambiguity what was intended. This proposal
  may open up some obscure loopholes, but that still seems preferable to
  repeatedly tripping over wording that seems like it ought to work.]"""
            )
        }
    }
}
