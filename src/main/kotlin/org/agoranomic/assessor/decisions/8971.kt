package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8971() = assessment {
    name("8971")
    quorum(4)

    proposals(v4) {
        proposal(8971) {
            title("A Pox!")
            ai("1.0")
            author(nix)
            ordinary()

            text("Grant each player that did not vote FOR this proposal 2 blots.")
        }
    }
}
