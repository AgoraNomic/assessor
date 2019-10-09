package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.VoteKind
import org.agoranomic.assessor.lib.VoteKind.FOR
import org.agoranomic.assessor.lib.assessment

@UseAssessment
fun `assessment 8251 to 8252`() = assessment {
    name("8251-8252")
    quorum(6)

    strengths {
        default(3)
        G strength 4 comment PM
    }

    proposals {
        proposal(8251) {
            title("Ruleset definition")
            ai(3.0)
            author(G)

            text(
                """
Amend Rule 2141 (Role and Attributes of Rules) by appending the following
text to its first paragraph:
  The ruleset is the set of all currently-existing rules.

[and while we're at it...]
Amend Rule 1030 (Precedence between Rules) by replacing all instances
of "Ruleset" with "ruleset".

[I mean, I think that definition matches what would be the "common"
definition anyway, but may be useful to have it there]."""
            )
        }

        proposal(8252) {
            title("Blasphemy")
            ai(1.0)
            author(JasonCobb)

            text(
                """
Destroy the contract that is known as the Reformed Church of the Ritual.

[It's useless now.]"""
            )
        }
    }

    voting {
        votes(JasonCobb) {
            FOR on 8251
            FOR on 8252
        }
    }
}