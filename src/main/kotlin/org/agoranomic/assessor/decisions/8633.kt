package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8633() = assessment {
    name("8633")
    quorum(8)

    proposals(v4) {
        proposal(8633) {
            title("Disbanded distribution")
            ai("3.0")
            author(Falsifian)
            democratic()

            text("""
In Rule 1607 "Distribution", delete the sentence:

  E SHALL then distribute those undistributed proposals the next
  Agoran week.""")
        }
    }
}
