package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8493() = assessment {
    name("8493")
    quorum(3)

    proposals(v2) {
        proposal(8493) {
            title("Minor Adjustments")
            ai("3.0")
            author(G)
            democratic()

            text("Increase the power of Rule 2633 (Rulebending) to 3.")
        }
    }
}
