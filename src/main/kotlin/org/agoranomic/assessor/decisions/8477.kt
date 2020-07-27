package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.Ministry.Economy

@UseAssessment
fun `assessment 8477`() = assessment {
    name("8477")
    quorum(8)

    proposals(v2) {
        proposal(8477) {
            title("More officer cards")
            ai("1.0")
            author(Jason)
            chamber(Economy)
            sponsored()

            text(
                """
Amend Rule 2624 (Card Administration) by replacing the final paragraph
(including the list) with the following:

{

  The officeholder of an office CAN by announcement grant another player a
  specified type of card, specifying that office, under the following
  conditions:

  * e has not done so in reference to that office in the current Agoran month,

  * that office's interests includes the card's associated ministry,

  * the player receiving the card does not hold an office with the card's
  associated ministry in its interests, and

  * the player receiving the card is not a zombie.

}"""
            )
        }
    }
}
