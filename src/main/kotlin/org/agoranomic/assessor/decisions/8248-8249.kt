package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.VoteKind.FOR
import org.agoranomic.assessor.lib.VoteKind.PRESENT
import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.votes.endorse

@UseAssessment
fun `assessment 8248 to 8249`() = assessment {
    name("8248-8249")
    quorum(5)

    strengths {
        default(3)

        G strength 4 comment PM
    }

    proposals(v0) {
        proposal(8248) {
            title("Publishing definition")
            ai(3.0)
            author(Jason)
            coauthors(Aris)

            text(
                """
Amend Rule 478 ("Fora") by replacing the text

  A person "publishes" or "announces" something by sending a public
  message.

with the text

  To "publish" or "announce" something is to send a public message
  whose body contains that thing."""
            )
        }

        proposal(8249) {
            title("No Harm No Foul")
            ai(1.0)
            author(JacobArduino)
            coauthors(twg)

            text(
                """
Amend rule 2143, "Official Reports and Duties", by removing
the paragraph starting "A person SHALL NOT publish information
that is inaccurate or misleading".

[This clause is duplicated by No Faking, except that it also
illegalises _accidentally_ publishing an inaccurate report,
or deliberately and obviously publishing an inaccurate report
for the public good, both of which I think ought to be
allowed.]"""
            )
        }
    }

    voting {
        votes(Jason) {
            FOR on 8248
            FOR on 8249
        }

        votes(Bernie) {
            endorse(Jason) on all
        }

        votes(Trigon) {
            FOR on 8248
            FOR on 8249
        }

        votes(Murphy) {
            FOR on 8248
            FOR on 8249
        }

        votes(Gaelan) {
            endorse(Murphy) on all
        }

        votes(twg) {
            endorse(Murphy) on all
        }

        votes(JacobArduino) {
            endorse(twg) on all
        }

        votes(Falsifian) {
            endorse(Jason) on 8248
            FOR on 8249 comment conditional("No veto, twg not AGAINST")
        }

        votes(ATMunn) {
            endorse(Falsifian) on all
        }

        votes(Aris) {
            FOR on 8248
            PRESENT on 8249 comment NO_VETO
        }

        votes(G) {
            FOR on 8248
            FOR on 8249
        }

        Rance matches G

        votes(o) {
            endorse(Trigon) on all
        }
    }
}
