package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8952to8955() = assessment {
    name("8952-8955")
    quorum(3)

    proposals(v4) {
        proposal(8952) {
            title("Fix Fora")
            ai("3.0")
            author(juan)
            democratic()

            text(
                """
        Ammend Rule 478 by replacing

                “The Registrar may change the publicity of a forum”

        with

                “The Registrar CAN change the publicity of a forum”"""
            )
        }

        proposal(8953) {
            title("Fluidity")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2577 ("Asset Actions") by replacing "A fixed asset is one
defined as such by its backing document, and CANNOT be transferred; any
other asset is liquid." with "A fixed asset is one defined as such by
its backing document, and CANNOT be transferred except as explicitly
specified by its backing document; any other asset is liquid."

[Brings the definition of "fixed" in line with the definition of
"indestructible" as a way to mean "the default doesn't apply" without
making it completely untransferable.]"""
            )
        }

        proposal(8954) {
            title("Closing the barn doors")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2670 by replacing "* The race starts anew." with the following:

{

* The following rules are repealed in ascending numerical order by ID:
Rule 2668, Rule 2669, Rule 2671, Rule 2672, Rule 2673, and Rule 2674.

* This rule repeals itself.

}"""
            )
        }

        proposal(8955) {
            title("Disassembling the Device")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Repeal Rule 2654 (The Device).

Repeal Rule 2655 (The Mad Engineer).

Amend Rule 2675 (Dream of Wandering) by deleting
{
      - Machinery: A Machinery Dreamer CAN Flip the Device with Agoran
        Consent. A Machinery Dreamer CAN take a specified action on
        behalf of the the device with 1 support.
}.

Amend Rule 2451 (Executive Orders) by deleting:
{
      - Research Funding (Mad Engineer): The Prime Minister specifies an
        existing Rule. Rules to the contrary notwithstanding, the Mad
        Engineer CAN and SHALL use that rule instead of making a random
        rule selection as part of eir weekly duties for the following
        week.
}."""
            )
        }
    }
}
