package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9248() = assessment {
    name("9248")
    quorum(3)

    proposals(v4) {
        proposal(9248) {
            title("Over-Optimization is Boring")
            ai("1.0")
            author(Mischief)
            coauthors(Murphy)
            ordinary()

            text(
                """
Amend rule 2710 (Genetic Modification) by appending the following
paragraph at the end:

       Once per Crop Season, the Land Managor CAN and SHALL by
       announcement randomly select a type of Crop that was in-season
       during the previous season, random attribute (Seed Cost or Sell
       Price), and random value for that attribute (as if the type was
       being created), and change that attribute of that type to that
       value. If there is no such type to select, then e SHALL instead
       announce that fact."""
            )
        }
    }
}
