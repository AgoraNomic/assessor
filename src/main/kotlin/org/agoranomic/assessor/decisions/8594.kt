package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8594() = assessment {
    name("8594")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-July/015106.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8594) {
            title("Nicer Definitions")
            ai("3.0")
            author(RLee)
            democratic()
            sponsored()

            text("""
Amend rule 2152, "Mother May I", by replacing

  "SHOULD NOT, DISCOURAGED, DEPRECATED: Before performing the
  described action, the full implications of performing it should
   be understood and carefully weighed."

with


  ""SHOULD NOT, DISCOURAGED, DEPRECATED: Before performing the
  described action, the full implications of performing it ought to be
  be understood and carefully weighed."


and also by replacing

  "SHOULD, ENCOURAGED, RECOMMENDED: Before failing to perform the
   described action, the full implications of failing to perform
   it should (in the ordinary-language sense) be understood and
   carefully weighed."

with

  "SHOULD, ENCOURAGED, RECOMMENDED: Before failing to perform the
  described action, the full implications of failing to perform
  it ought to be understood and
  carefully weighed."

[Explanation: The word SHOULD is currently defined as meaning the word
should. This is not technically recursive because the upper case terms are
terms of art, but it looks awful. This proposal means that it becomes
"ought to", which just looks better. I also get to remove a terribly clunky
parenthetical.]""")
        }
    }

    voting {
        votes(Murphy) {
            FOR on 8594
        }

        votes(Gaelan) {
            FOR on 8594
        }

        votes(RLee) {
            FOR on 8594
        }

        votes(Falsifian) {
            endorse(RLee) on 8594
        }

        votes(Jason) {
            PRESENT on 8594
        }

        votes(ATMunn) {
            FOR on 8594
        }
    }
}
