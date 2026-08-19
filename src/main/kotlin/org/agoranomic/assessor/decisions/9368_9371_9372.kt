package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9368_9371to9372() = assessment {
    name("9368, 9371-9372")
    quorum(7)

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
}
