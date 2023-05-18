package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8559() = assessment {
    name("8559")
    quorum(3)
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-May/014927.html")

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 7 / 3)
        powerStone(Janet, 3)
    }

    proposals(v4) {
        proposal(8559) {
            title("Paper Shredding")
            ai("2.5")
            author(ATMunn)
            coauthors(G, Aspen)
            democratic()
            sponsored()

            text(
                """
Amend Rule 1742 "Contracts" by appending the following:

  Any player CAN cause a contract to be terminated (syn. "shred")
  without 2 objections. This SHOULD only be done to remove unused
  contracts or contracts deemed detrimental to the game as a whole."""
            )
        }
    }

    voting {
        votes(Falsifian) {
            endorse(ATMunn) on 8559
        }

        votes(Janet) {
            endorse(ATMunn) on 8559
        }

        votes(ATMunn) {
            FOR on 8559
        }

        votes(Murphy) {
            FOR on 8559
        }
    }
}
