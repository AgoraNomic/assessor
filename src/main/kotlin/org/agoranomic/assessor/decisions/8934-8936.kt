package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8934to8936() = assessment {
    name("8934-8936")
    quorum(5)

    proposals(v4) {
        proposal(8934) {
            title("H4x0r5")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Each player who votes FOR this proposal
commits the crime of ???, which is an infraction of power 10.

Each player who votes FOR this proposal gains 30 radiance."""
            )
        }

        proposal(8935) {
            title("Quicker Peer Expungement")
            ai("2.0")
            author(nix)
            coauthors(Aspen, G)
            ordinary()

            text(
                """
Amend R2555 by replacing:

       Any player who has not expunged a blot by this method this week
       CAN expunge 1 blot from a specified player who has not gained a
       blot this or the previous week, by announcement.

with

       Any player who has not expunged a blot by this method this week
       CAN expunge 1 blot from a specified player by announcement. E
       CANNOT specify emself for this if e has gained any blots this or
       the previous week."""
            )
        }

        proposal(8936) {
            title("Oh come on guys folks")
            ai("2.0")
            author(Forest)
            ordinary()

            text(
                """
Amend Rule 2423 ("First Among Equals") by replacing
"guy" with "person"."""
            )
        }
    }
}
