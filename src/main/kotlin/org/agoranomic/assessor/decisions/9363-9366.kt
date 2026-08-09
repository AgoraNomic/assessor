package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9363to9366() = assessment {
    name("9363-9366")
    quorum(7)

    proposals(v4) {
        proposal(9363) {
            title("Season Specification")
            ai("2.0")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2710 ("Genetic Modification") by replacing the first paragraph
with the following text:
---
Once per Crop Season, a player CAN pay a fee of 500 Pyrite to create a new
type of Crop, specifying its name and, optionally, its Growth Season. The
Land Managor CAN once by announcement, and SHALL in a timely fashion, set
its Seed Cost, Growth Duration, Resilience, Opportunity, and Sell Price to
randomly selected valid values, as well as its Growth Season if none was
specified. The Land Managor CAN by announcement rename a type of Crop,
specifying its new name, but SHOULD NOT do so unless its current name is
reasonably likely to cause confusion and delay.
---"""
            )
        }

        proposal(9364) {
            title("Sysphyean Effort")
            ai("1.0")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2683 ("The Boulder") by appending the following paragraph:
---
Once per week, each player who has pushed the boulder exactly once that
week can pay a fee of X spendies, where X is equal to 10 plus the Boulder's
Slope, to push the boulder a second time.
---"""
            )
        }

        proposal(9365) {
            title("Unique CFJ IDs v2")
            ai("2.0")
            author(Galle)
            ordinary()

            text(
                """
> Amend Rule 991 ("Calls for Judgement") by replacing the eighth paragraph
with the following text:
> ---
> If a CFJ does not have a unique CFJ ID number, the Arbitor CAN by
announcement or by clear specification assign an ID number to it, and SHALL
do so in any message in which e assigns a player to judge it.
> ---"""
            )
        }

        proposal(9366) {
            title("Greater Genetic Mutation v2")
            ai("1.0")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2710 ("Genetic Modification") by replacing the fourth paragraph
with the following text:
---
Once per Crop Season, the Land Managor CAN and SHALL by announcement set a
randomly select attribute (Seed Cost, Growth Duration, Opportunity,
Resilience, or Sell Price) of a randomly selected type of Crop that was
in-season during the previous season to a randomly selected valid value. If
there is no such type to select, then e SHALL instead announce that fact.
---"""
            )
        }
    }
}
