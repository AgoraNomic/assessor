package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8275to8276() = assessment {
    name("8275-8276")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-December/013269.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)
    }

    proposals(v0) {
        proposal(8275) {
            title("\"By announcement\" clarification")
            ai("3.0")
            author(Janet)

            text(
                """
Amend Rule 478 ("Fora") by replacing the text

  Where the rules define an action that CAN be performed "by
  announcement", a person performs that action by unambiguously and
  clearly specifying the action and announcing that e performs it.

with the text

  Where the rules define an action that a person CAN perform "by
  announcement", that person performs that action by unambiguously and
  clearly specifying the action and announcing that e performs it."""
            )
        }

        proposal(8276) {
            title("Various Election Fixes v2")
            ai("2.0")
            author(Janet)

            text(
                """
Amend Rule 2154 ("Election Procedure") by replacing the text "declare em
the winner of the election by announcement" with the text "by
announcement declare em the winner of the election, thereby causing em
to win the election".

[This clarifies that this actually causes the person to win the
election, which could be construed as a distinct action from "declaring
em the winner". The replaced text differs from the one in the most
recent SLR because Falsifian cleaned the text by replacing "them" with
"em" since then.]

Amend Rule 2154 ("Election Procedure") by replacing the text "In a
timely fashion after the nomination period ends, the ADoP CAN and SHALL"
with the text "After the nomination period ends, the ADoP CAN and, in a
timely fashion, SHALL".

[Ensures that the ADoP doesn't lose the ability to initiate an Agoran
Decision for an election after a week passes.]"""
            )
        }
    }

    voting {
        votes(Janet) {
            FOR on 8275
            FOR on 8276
        }

        votes(Kate) {
            endorse(Janet) on 8275
            endorse(Janet) on 8276
        }

        votes(Bernie) {
            endorse(Janet) on all
        }

        votes(Falsifian) {
            endorse(Janet) on 8275
            endorse(Janet) on 8276
        }

        votes(ATMunn) {
            endorse(Falsifian) on all
        }

        votes(G) {
            FOR on 8275
            FOR on 8276
        }
    }
}
