package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8559() = assessment {
    name("8559")
    quorum(3)

    proposals(v4) {
        proposal(8559) {
            title("Paper Shredding")
            ai("2.5")
            author(ATMunn)
            coauthors(G, Aris)
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
}
