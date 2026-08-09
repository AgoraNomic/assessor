package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9363to9366() = assessment {
    name("9363-9366")
    quorum(7)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy pizza723
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy Kate
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

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

    voting {
        votes(Galle) {
            FOR on 9363
            FOR on 9364
            FOR on 9365
            FOR on 9366
        }

        votes(msh210) {
            FOR on 9364
            FOR on 9366
        }

        votes(Mischief) {
            resolvedConditional(endorseOrElse(Murphy, AGAINST), "${Murphy.name} is the Land Managor") on 9363
            FOR on 9364
            FOR on 9365
            FOR on 9366
        }

        votes(Despi) {
            FOR on 9363
            FOR on 9364
            FOR on 9365
            FOR on 9366
        }

        votes(juan) {
            PRESENT on 9363
            FOR on 9364
            FOR on 9365
            PRESENT on 9366
        }

        votes(Murphy) {
            FOR on 9363
            endorseOfficer("Absurdor", juan) on 9364
            FOR on 9365
            FOR on 9366
        }

        votes(juniper) {
            PRESENT on 9363
            AGAINST on 9364
            AGAINST on 9365
            FOR on 9366
        }

        votes(pizza723) {
            FOR on 9363
            FOR on 9364
            FOR on 9365
            FOR on 9366
        }

        votes(snail) {
            FOR on 9363
            FOR on 9364
            FOR on 9365
            FOR on 9366
        }

        votes(Janet) {
            AGAINST on 9363
            PRESENT on 9364
            AGAINST on 9365
            PRESENT on 9366
        }
    }
}
