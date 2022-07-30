package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8805to8810and8812to8814() = assessment {
    name("8805-8810, 8812-8814")
    quorum(3)

    proposals(v4) {
        proposal(8805) {
            title("Removal of vote points v2")
            ai("1.0")
            author(Jason)
            ordinary()

            text("""
Amend Rule 2657 by, as a single amendment, removing all list items that
contain the text "AGAINST" or "FOR".""")
        }

        for (i in 8806..8810) {
            proposal(i) {
                title("Filler")
                ai("1.0")
                author(Jason)
                ordinary()

                text("""
This proposal has no effect.""")
            }
        }

        proposal(8812) {
            title("Quorum for all")
            ai("3.0")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 879 (Quorum) by replacing "2/3 of the number of voters on the
referendum that had been most recently resolved" with "2/3 of the number of
voters on the Agoran decision that had been most recently resolved".""")
        }

        proposal(8813) {
            title("Spam Blocker")
            ai("3.0")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 2350 (Proposals) by replacing "A player CAN create a proposal by
announcement" with "Five times per week, each player CAN create a proposal
by announcement".""")
        }

        proposal(8814) {
            title("Effective activity")
            ai("3.0")
            author(Jason)
            ordinary()

            text("""
Set the power of Rule 2646 (Activity) to 3.

[Rule 2646 cannot authorize deregistration at power 1 because
Citizenship is secured at power 3.]""")
        }
    }
}