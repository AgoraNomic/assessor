package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.powerStone

@UseAssessment
fun assessment8556() = assessment {
    name("8556")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 7 / 3)
        powerStone(Jason, 3)
    }

    proposals(v4) {
        proposal(8556) {
            title("Ministry Normalization")
            ai("1.0")
            author(Jason)
            coauthors(nix)
            ordinary()
            sponsored()

            text(
                """
Amend Rule 2624 by inserting the following line after the line "Ministry
of Participation: 1 Voting Card": "Ministry of Legacy: 1 Victory Point"
and by deleting "and 1 Victory Point to every other player whose
Ministry Focus is Legacy".

[This allows the Concentration Stone to work (at least partially) for
players focused on Legacy.]"""
            )
        }
    }

    voting {
    }
}
