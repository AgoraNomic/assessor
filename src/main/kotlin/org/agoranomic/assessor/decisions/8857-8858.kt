package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8857to8858() = assessment {
    name("8857-8858")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8857) {
            title("Voter Protection 3.0")
            ai("3.0")
            author(ziproot)
            democratic()

            text(
                """
If the proposal 8851 did not pass, create the rule, with title "Voter
Protection", and power=3.0, whose text is the text from the fourth
instance of the "{" character at
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2022-August/049846.html
,
to the third instance of the "}" character."""
            )
        }

        proposal(8858) {
            title("Regulation Regulation")
            ai("2.0")
            author(Secretsnail9)
            ordinary()

            text(
                """
Amend Rule 2630 (The Administrative State) by replacing:

{

1. An officer SHALL NOT violate eir office's administrative
         regulations in the discharge of eir office.

}

with:

{

1. An officer SHALL NOT violate requirements in eir office's administrative
         regulations clearly intended to be punishable as rules violations
in
         the discharge of eir office.

}

Amend Rule 2545 (Auctions) by replacing:

  "SHALL NOT violate requirements that auction's method"

with:

  "SHALL NOT violate requirements of that auction's method"

[Makes regulation violations punishable, or at least more clearly so.]"""
            )
        }
    }

    voting {
    }
}