package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9195to9196() = assessment {
    name("9195-9196")
    quorum(3)

    proposals(v4) {
        proposal(9195) {
            title("Commitment Issues")
            ai("1.0")
            author(Mischief)
            coauthors(Kate, Janet)
            ordinary()

            text(
                """
[This is a useful but under-utilized mechanism; hopefully these tweaks
make it easier to build on.]

Amend rule 2681 (Acting on Commitment) by replacing:

       Where the rules define an action that a person CAN perform "by
       commitment" to a particular kind of document, that person performs
       that action by performing it by announcement while, in the same
       message, also publishing a what is purportedly a Fingerprint for a
       document of that kind.

with:

       A person CAN make a commitment to a particular kind of document
       by publishing a statement that purports to be a Fingerprint for a
       document of that kind. If the statement is in fact such a
       Fingerprint, the person CAN then reveal the commitment by
       publishing the Plaintext corresponding to that Fingerprint and
       clearly indicating which Fingerprint the Plaintext relates to.

       A person making a commitment SHOULD specify the method used to
       produce the Fingerprint from the Plaintext."""
            )
        }

        proposal(9196) {
            title("Use it or lose it")
            ai("1.0")
            author(Murphy)
            coauthors(Alexis)
            ordinary()

            text(
                """
Amend Rule 2690 (Spendies) by appending this text to the paragraph
containing "Spendies are tracked by the Spendor":

       If the Spendor's report is overdue, then other players SHOULD
       deputise to publish it."""
            )
        }
    }
}
