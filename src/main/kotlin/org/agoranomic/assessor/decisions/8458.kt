package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.Ministry

@UseAssessment
fun `assessment 8458`() = assessment {
    name("8458")
    quorum(8)

    proposals(v1) {
        proposal(8458) {
            title("Welcome Package Patch")
            ai("1.0")
            author(Aris)
            chamber(Ministry.Economy)

            text(
                """
Amend Rule 2499, "Welcome Packages", by appending to the first paragraph:

  A player CANNOT receive a Welcome Package via this method if e was
  deregistered on account of having excessive blots."""
            )
        }
    }
}
