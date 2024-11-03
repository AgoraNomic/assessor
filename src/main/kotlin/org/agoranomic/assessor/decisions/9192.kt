package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9192() = assessment {
    name("9192")
    quorum(5)

    proposals(v4) {
        proposal(9192) {
            title("Dissolution")
            ai("1.2")
            author(Mischief)
            ordinary()

            text(
                """
[At various times, folks have mentioned that crystals have influenced
how they voted on proposals. Since they've been around a while, I
figured it was worth talking everyone's temperature on them. In order to
make sure crystals don't get repealed on a narrow result, I deliberately
set the AI a little higher than it strictly needs to be. Also, at this
point, I expect to be voting PRESENT personally.]

Repeal rule 2685 (Crystals)"""
            )
        }
    }
}
