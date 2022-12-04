package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8250() = assessment {
    name("8250")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-October/013192.html")
    quorum(9)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)
    }

    proposals(v0) {
        proposal(8250) {
            title("Finger bending")
            ai("1.7")
            author(Murphy)
            coauthors(twg)

            text(
                """
Amend Rule 2478 (Vigilante Justice) by replacing this text:

  The Referee is by default the investigator for all Finger
  Pointing. When a Finger, other than the Arbitor's, is Pointed over
  an allegation related to the official duties or powers of the
  Referee, then the Arbitor CAN, by announcement, take over the
  investigation and thereby become the investigator.

  The Referee CANNOT Point eir Finger. The Arbitor CANNOT Point eir
  Finger at the Referee.

with this text:

  The above notwithstanding, the investigator CANNOT resolve a
  Finger Pointing for which e is the perp.

  The Referee is by default the investigator for all Finger
  Pointing. If the Referee is the perp, then the Arbitor CAN
  become the investigator of that Finger Pointing by announcement.

[Limiting resolution is more important than limiting initiation, as
offices may change hands during the process.]"""
            )
        }
    }

    voting {
        votes(Trigon) {
            FOR on 8250
        }

        votes(twg) {
            FOR on 8250
        }

        votes(JacobArduino) {
            FOR on 8250
        }

        votes(Falsifian) {
            PRESENT on 8250
        }

        votes(ATMunn) {
            endorse(Falsifian) on 8250
        }

        votes(Janet) {
            FOR on 8250
        }

        votes(Bernie) {
            endorse(Janet) on 8250
        }

        votes(G) {
            PRESENT on 8250
        }

        votes(BaronVV) {
            PRESENT on 8250
        }
    }
}
