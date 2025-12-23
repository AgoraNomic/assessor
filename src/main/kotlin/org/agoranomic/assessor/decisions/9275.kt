package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9275() = assessment {
    name("9275")
    quorum(7)

    proposals(v4) {
        proposal(9275) {
            title("Determinate determinacy")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2518 ("Determinacy") by replacing the text "If a value CANNOT
be reasonably determined" with the text "If a value cannot be reasonably
determined".

[We almost certainly mean "cannot" here in the natural language sense:
determining something (in this sense) is not a regulated action; it
requires thought and potentially a judicial process.]"""
            )
        }
    }
}
