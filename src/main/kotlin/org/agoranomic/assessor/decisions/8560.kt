package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.powerStone

@UseAssessment
fun assessment8560() = assessment {
    name("8560")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 7 / 3)
        powerStone(Jason, 3)
    }

    proposals(v4) {
        proposal(8560) {
            title("simplify indictments")
            ai("1.7")
            author(G)
            coauthors(nix)
            ordinary()
            sponsored()

            text(
                """
Repeal Rule 2619 (Indictment).

Amend Rule 2557 (Sentencing Guidelines) by appending the following paragraph:

  When the rules authorize an investigator to issue an Indictment
  for a violation, e CAN do so by levying a fine on the perp, with
  1.5 Agoran Consent, provided that levying the fine would be
  otherwise LEGAL and EFFECTIVE.

[
Turns indictment into a simple "if we want to apply a punishment outside
the 1...2xBase violation range (either higher or lower), we do so with 1.5
Consent and call that an indictment."  The 1.5 level was chosen to match
the AI of the current indictment proposals.

The "otherwise LEGAL and EFFECTIVE" clause is so that this ability is
still limited by Defendant's Rights.
]"""
            )
        }
    }
}
