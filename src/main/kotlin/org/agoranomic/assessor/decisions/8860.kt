package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8860() = assessment {
    name("8860")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8860) {
            title("Contests")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Create a rule titled "Contests" with this text:

      Tourney Level is a natural switch for contracts, tracked by the
      Notary, with a default of 0 and a maximum of 10. A contract with
      nonzero tourney level is called a Contest.

      The Notary CAN flip a contract's tourney level to a non-default
      value with 3 Agoran consent. Any player CAN flip a contract's
      tourney level to 0 with Agoran consent.

Amend Rule 2657 (Scoring) by replacing the first paragraph with:

      Each time a player fulfills a scoring condition defined by the
      rules or a Contest, e earns the associated amount of points,
      rounded down, and (if defined by a Contest) reduced as needed
      so that the total points e earned that week from that Contest
      does not exceed its tourney level.

      When a player earns a non-zero number of points, the officer or
      other person associated with the condition by the Pointer CAN once
      by announcement, and SHALL in an officially timely fashion, add
      that many points to that player's score."""
            )
        }
    }

    voting {
    }
}