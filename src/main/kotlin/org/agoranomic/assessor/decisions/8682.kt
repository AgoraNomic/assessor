package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8682() = assessment {
    name("8682")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8682) {
            title("Temptation")
            ai("1.0")
            author(Secretsnail9)
            ordinary()
            sponsored()

            text("""
Enact a new rule, with the title "Succumbing to Time" and the following
text:

  Once per month, a player CAN Succumb by announcement. When a player
Succumbs, each of eir deadlines to perform an Officer's duty or judge a
Call for Judgement is extended by 1 day if it would otherwise expire within
the next week.""")
        }
    }

    voting {
        votes(Murphy) {
            FOR on 8682
        }
    }
}