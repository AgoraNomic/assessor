package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.match
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8248to8249() = assessment {
    name("8248-8249")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-September/013158.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)
    }

    proposals(v0) {
        proposal(8248) {
            title("Publishing definition")
            ai("3.0")
            author(Janet)
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
            ai("1.0")
            author(JacobArduino)
            coauthors(Kate)

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
        votes(Janet) {
            FOR on 8248
            FOR on 8249
        }

        votes(Bernie) {
            endorse(Janet) on all
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

        votes(Kate) {
            endorse(Murphy) on all
        }

        votes(JacobArduino) {
            endorse(Kate) on all
        }

        votes(Falsifian) {
            endorse(Janet) on 8248
            FOR on 8249 comment legacyConditionalComment("No veto, ${Kate.name} not AGAINST")
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

        votes(Rance) {
            match(G) on all
        }

        votes(o) {
            endorse(Trigon) on all
        }
    }
}
