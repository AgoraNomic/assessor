package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8667to8668() = assessment {
    name("8667-8668")
    quorum(5)

    proposals(v4) {
        proposal(8667) {
            title("welcome fix")
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2499 (Welcome Packages) by replacing:
    Any player CAN grant
with:
    Any player CAN, by announcement, grant""")
        }

        proposal(8668) {
            title("a light on darkness")
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Repeal Rule 2617 (Defense Against the Dark Arts).""")
        }
    }
}
