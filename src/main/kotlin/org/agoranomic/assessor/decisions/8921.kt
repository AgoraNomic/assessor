package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8921() = assessment {
    name("8921")
    quorum(5)

    proposals(v4) {
        proposal(8921) {
            title("ReGardening")
            ai("2")
            author(nix)
            ordinary()

            text(
                """
Amend R2675 (Dream of Wandering) by replacing:

       - Gardens: Once per week, a Gardens Dreamer CAN, by announcement,
         transfer the mossiest stone (if there is a tie, then a specified
         stone tied for mossiest) Agora owns to emself. E SHOULD specify
         the stone when doing so.

with:

       - Gardens: Immediately after a wandering, the Base Rockiness of
         each Gardens Dreamer is increased by 1."""
            )
        }
    }
}
