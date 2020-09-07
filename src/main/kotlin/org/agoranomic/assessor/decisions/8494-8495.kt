package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.Ministry.Legislation

@UseAssessment
fun assessment8494to8495() = assessment {
    quorum(3)

    proposals(v2) {
        proposal(8494) {
            title("nope")
            ai("1.0")
            author(Gaelan)
            chamber(Legislation)
            sponsored()

            text("Repeal rule 2633.")
        }

        proposal(8495) {
            title("nopenopenope")
            ai("3.0")
            author(Gaelan)
            democratic()
            sponsored()

            text("Repeal rule 2633.")
        }
    }
}
