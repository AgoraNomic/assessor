package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8633() = assessment {
    name("8633")
    quorum(8)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Madrid, 6 / 3)
    }

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

    voting {
        votes(Murphy) {
            PRESENT on 8633
        }

        votes(Falsifian) {
            FOR on 8633
        }

        votes(Jason) {
            endorse(Aspen) on 8633
        }

        votes(RLee) {
            PRESENT on 8633
        }

        votes(Aspen) {
            FOR on 8633
        }
    }
}
