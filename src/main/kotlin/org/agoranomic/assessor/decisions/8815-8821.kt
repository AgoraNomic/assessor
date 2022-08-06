package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8815to8821() = assessment {
    name("8815-8821")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8815) {
            title("Proposal terminology fix")
            ai("3.0")
            author(ais523)
            ordinary()

            text(
                """
Amend rule 2350 by changing "A player CAN create a proposal" to "A
player CAN create (syn. submit) a proposal".


Amend rule 2350 by changing "The author (syn. proposer) of a proposal
is the person who submitted it." to "The author (syn. proposer) of a
proposal is the person who created it.".

[Ensures that "creating" and "submitting" a proposal are synonyms – the
current rules aren't clear enough on this issue.]"""
            )
        }

        proposal(8816) {
            title("No Duplication Allowed")
            ai("3.05")
            author(Secretsnail9)
            ordinary()

            text(
                """
Enact a new rule with power 3.05, title "No Duplication Allowed", and the
following text:

{
An entity CANNOT be created if it already exists.
}

[This would codify the invisible requirement that presumably already
exists. Thus creating it again?]"""
            )
        }

        proposal(8817) {
            title("No Duplication Allowed")
            ai("3.05")
            author(Secretsnail9)
            ordinary()

            text(
                """
Enact a new rule with power 3.05, title "No Duplication Allowed", and the
following text:

{
An entity CANNOT be created if it already exists.
}

[This would codify the invisible requirement that presumably already
exists. Thus creating it again?]"""
            )
        }

        proposal(8818) {
            title("Tabled action condition ambiguity v2")
            ai("3.0")
            author(Jason)
            ordinary()

            text(
                """
Amend Rule 2124 ("Performing Tabled Actions") by replacing "its
conditions, if any are met" with "its conditions, if any, are each
clearly and unambiguously met"."""
            )
        }

        proposal(8819) {
            title("A Quick Anti-Contrarian Compromise")
            ai("1.0")
            author(nix)
            ordinary()

            text(
                """
Amend R2657, "Scoring", by replacing:

         * Having a valid unconditional AGAINST vote on a referendum when
           it is resolved to be ADOPTED, or, similarly, FOR when
           REJECTED: 1 (Assessor).

with:

         * Having a valid unconditional AGAINST vote on a referendum when
           it is resolved to be ADOPTED: 1 (Assessor)."""
            )
        }

        proposal(8820) {
            title("Another Quick Anti-Contrarian Compromise")
            ai("1.0")
            author(Murphy)
            coauthors(nix)
            ordinary()

            text(
                """
In Rule 2657 (Scoring), replace:

        * Having a valid unconditional AGAINST vote on a referendum when
          it is resolved to be ADOPTED, or, similarly, FOR when
          REJECTED: 1 (Assessor).

with:

        * Having a valid unconditional AGAINST vote on a referendum when
          it is resolved to be ADOPTED: 1 (Assessor). Similarly for FOR
          when REJECTED, but only if (a) it would have been ADOPTED if
          the total strength of all valid ballots cast FOR it had been
          twice as large, and (b) the player has not already gained five
          or more points this way since the start of the week."""
            )
        }

        proposal(8821) {
            title("More Intuitive Rule Changes")
            ai("3.0")
            author(nix)
            coauthors(Jason, Secretsnail9)
            ordinary()

            text(
                """
Amend R105, Rule Changes, by replacing:

       4. amend the text of a rule.

       5. retitle a rule.

with:

       4. amend the title (syn. retitle) and/or text of a rule."""
            )
        }
    }

    voting {
    }
}