package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9242() = assessment {
    name("9242")
    quorum(5)

    proposals(v4) {
        proposal(9242) {
            title("Currency clarification")
            ai("3")
            author(Janet)
            coauthors(Kate)
            democratic()

            text(
                """
Amend Rule 2578 ("Fungibility") to read as follows:

{

Any two assets within a "fungible" class of assets (syn. "currency")
that have the same owner are considered equivalent for the purposes of
specification, granting, and transferring. The number of such assets an
entity owns is that entity's "balance" of that currency.

}


[Currently, the rule conflates a class of asset and an individual asset.
This fixes that issue and includes the "currency" definition from
Mischief's proposal.]"""
            )
        }
    }
}
