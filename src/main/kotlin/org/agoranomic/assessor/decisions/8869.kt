package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8869() = assessment {
    name("8869")
    quorum(3)

    proposals(v4) {
        proposal(8869) {
            title("Stamp Shenanigans")
            ai("1.0")
            author(ShyOwl)
            ordinary()

            text(
                """
Create one Peter Suber Stamp in possession of the Lost and Found Department."""
            )
        }
    }
}