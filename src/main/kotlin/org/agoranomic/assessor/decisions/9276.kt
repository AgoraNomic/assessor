package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9276() = assessment {
    name("9276")
    quorum(7)

    proposals(v4) {
        proposal(9276) {
            title("CFJ Number Card Fix")
            ai("1.0")
            author(ais523)
            coauthors(Janet)
            ordinary()

            text(
                """
If exactly one rule contains the text
{{{
Whenever a player scores a number as described in this rule, the
Numerator CAN once, and SHALL in a timely manner, grant its author
}}}
then amend that rule by replacing that text with
{{{
Whenever a player scores a number as described in this rule, the
Numerator CAN once, and SHALL in a timely manner, grant that player
}}}
[This is a fix-forward for text in a rule proposed in a proposal that
has not yet been adopted, written so as to not care about what number
the rule eventually ends up being given.]"""
            )
        }
    }
}
