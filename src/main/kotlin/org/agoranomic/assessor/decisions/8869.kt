package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream

@UseAssessment
fun assessment8869() = assessment {
    name("8869")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Janet, 2)
            powerDream(snail, 2)
        }
    }

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

    voting {
    }
}