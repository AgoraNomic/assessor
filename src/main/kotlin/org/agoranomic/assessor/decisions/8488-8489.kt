package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.Ministry.Economy

@UseAssessment
fun assessment8488to8489() = assessment {
    name("8488-8489")
    quorum(7)

    proposals(v2) {
        proposal(8488) {
            title("Empty the escalator v1")
            ai("3.0")
            author(Falsifian)
            coauthors(Jason, omd)
            democratic()
            sponsored()

            text(
                """
Amend Rule 2577 by adding the sentence "Attempts to destroy no assets
are successful." before the sentence that begins "An indestructible asset".

Amend Rule 2577 by adding the sentence "Attempts to transfer no assets
are successful." before the sentence that begins "A fixed asset".

Amend Rule 2579 by deleting the paragraph that ends with "0 or empty fee"."""
            )
        }

        proposal(8489) {
            title("Interesting economics")
            ai("1.0")
            author(Jason)
            chamber(Economy)
            sponsored()

            text(
                """
Amend Rule 2624 by appending the following sentence to the first
paragraph: "The type of card with the fewest existing instances is
associated with the Ministry of Economy.""""
            )
        }
    }
}
