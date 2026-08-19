package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9368_9371to9372() = assessment {
    name("9368, 9371-9372")
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
        proposal(9368) {
            title("Greater Genetic Mutation v3")
            ai("1.0")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2710 ("Genetic Modification") by replacing the fourth
paragraph with the following text:
---
Once per Crop Season, the Land Managor CAN and SHALL by announcement set
a randomly selected attribute (Seed Cost, Growth Duration, Opportunity,
Resilience, or Sell Price) of a randomly selected type of Crop that was
in-season during the previous season to a randomly selected valid value.
If there is no such type to select, then e SHALL instead announce that fact.
---"""
            )
        }

        proposal(9371) {
            title("The victim")
            ai("1.0")
            author(Janet)
            democratic()

            text(
                """
Janet wins the game."""
            )
        }

        proposal(9372) {
            title("Testing, Testing, 1, 2, 3")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
Create a rule entitled "Test Alpha" reading "Hello, world!"

Create a rule entitled "Test Beta" reading "Hello, world!"

Create a rule entitled "Test Gamma" reading "Hello, world!"

Repeal the rule titled "Test Gamma"

Repeal the rule titled "Test Beta"

Repeal the rule titled "Test Alpha""""
            )
        }
    }

    voting {
        votes(Mischief) {
            FOR on 9368
            AGAINST on 9371
            FOR on 9372
        }

        votes(msh210) {
            FOR on 9368
            FOR on 9371
            AGAINST on 9372
        }
    }
}
