package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8633() = assessment {
    name("8633")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-November/015506.html")
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
            sponsored()

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

        votes(Janet) {
            endorse(Aris) on 8633
        }

        votes(RLee) {
            PRESENT on 8633
        }

        votes(Aris) {
            FOR on 8633
        }

        votes(ATMunn) {
            PRESENT on 8633
        }

        votes(Trigon) {
            endorse(Aris) on 8633 comment "${Aris.name} is the Promotor"
        }

        votes(G) {
            PRESENT on 8633
        }
    }
}
