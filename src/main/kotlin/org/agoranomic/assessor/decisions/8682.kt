package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8682() = assessment {
    name("8682")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2022-June/016061.html")
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
            author(snail)
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

        votes(juan) {
            PRESENT on 8682
        }

        votes(Madrid) {
            FOR on all
        }

        votes(Jason) {
            PRESENT on 8682
        }

        votes(G) {
            AGAINST on 8682
        }

        votes(ais523) {
            AGAINST on 8682
        }

        votes(snail) {
            FOR on 8682
        }
    }
}