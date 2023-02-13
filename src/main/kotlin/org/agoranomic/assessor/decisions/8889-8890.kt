package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8889to8890() = assessment {
    name("8889-8890")
    quorum(3)

    proposals(v4) {
        proposal(8889) {
            title("Forced Mad Engineer Election")
            ai("1.0")
            author(Forest)
            coauthors(G)
            ordinary()

            text(
                """
An election for Mad engineer is hereby initiated."""
            )
        }

        proposal(8890) {
            title("Here comes a new challenger!")
            ai("2.0")
            author(Murphy)
            coauthors(Forest, G)
            ordinary()

            text(
                """
Amend Rule 2651 (The Election Cycle) by replacing this text:

      a) with 2 support, if either the office is interim or term-
      limited, and provided that the initiator becomes a candidate in
      the same message.

with this text:

      a) With 2 support (if the office is either interim or term-
      limited) or 4 support (otherwise), and provided that the initiator
      becomes a candidate in the same message."""
            )
        }
    }
}
