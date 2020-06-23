package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.author
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.VoteKind.FOR
import org.agoranomic.assessor.lib.VoteKind.PRESENT

@UseAssessment
fun `assessment 8251 to 8252`() = assessment {
    name("8251-8252")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-October/013201.html")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)
    }

    proposals(v0) {
        proposal(8251) {
            title("Ruleset definition")
            ai("3.0")
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
            ai("1.0")
            author(Jason)

            text(
                """
Destroy the contract that is known as the Reformed Church of the Ritual.

[It's useless now.]"""
            )
        }
    }

    voting {
        votes(Jason) {
            FOR on 8251
            FOR on 8252
        }

        votes(twg) {
            endorse(author) on all
        }

        votes(JacobArduino) {
            endorse(twg) on all
        }

        votes(Bernie) {
            endorse(Jason) on all
        }

        votes(Falsifian) {
            FOR on 8251
            PRESENT on 8252
        }

        votes(ATMunn) {
            endorse(Falsifian) on all
        }

        votes(Gaelan) {
            endorse(G) on 8251
            endorse(Jason) on 8252
        }

        votes(Murphy) {
            FOR on 8251
            FOR on 8252
        }

        votes(G) {
            FOR on 8251
            // NO VOTE on 8252
        }

        votes(Rance) {
            FOR on 8251
            // NO VOTE on 8252
        }
    }
}
