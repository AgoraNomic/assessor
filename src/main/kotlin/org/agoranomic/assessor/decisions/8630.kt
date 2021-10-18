package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8630() = assessment {
    name("8630")
    quorum(5)

    proposals(v4) {
        proposal(8630) {
            title("A Very Merry Unvictory to Me! ")
            ai("3.0")
            author(CuddleBeam)
            democratic()
            sponsored()

            text("""
Ratify the following: {Cuddlebeam has not won the game by Proposal.}

Then, if it is possible to do, revoke the Title of Champion (by Proposal)
from Cuddlebeam.""")
        }
    }
}
