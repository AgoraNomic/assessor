package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun `assesssment 8366 to 8367`() = assessment {
    name("8366-8367")
    quorum(7)

    proposals(v1) {
        proposal(8366) {
            title("Asset Determinacy")
            ai("3.0")
            author(Aris)
            coauthors(twg)
            democratic()

            text(
                """
Amend Rule 2576, "Ownership", by changing the text
  "If an asset would otherwise lack an owner, it is owned by the Lost
   and Found Department"
to read
   "If an asset would otherwise lack an owner, or if its ownership
    would otherwise be indeterminate, it is owned by the Lost and Found
    Department.

If there is a rule titled "A Coin Award", repeal it."""
            )
        }

        proposal(8367) {
            title("Slow burn")
            ai("3.0")
            author(Murphy)
            coauthors(Falsifian)
            democratic()

            text(
                """
Amend Rule 1789 (Cantus Cygneus) by replacing "Registrar's Report" with
"Registrar's monthly report"."""
            )
        }
    }
}
