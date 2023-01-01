package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.proposal.DecisionAI
import org.agoranomic.assessor.lib.proposal.ProposalAI
import org.agoranomic.assessor.lib.vote.VoteKind.*
import java.math.BigDecimal

@UseAssessment
fun assessment8549to8555() = assessment {
    name("8549-8555")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-April/014796.html")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 7 / 3)
        powerStone(Janet, 3)
    }

    proposals(v4) {
        proposal(8549) {
            title("You Can Only Stack Turtles So High")
            ai("2.2")
            author(Aspen)
            coauthors(Gaelan, G)
            ordinary()
            sponsored()

            text(
                """
[This fixes G.'s scam, which would otherwise allow indeterminacy to be
created through infinite promise loops.]

Amend Rule 2618, "Promises", by inserting, after the text:

  A promise's bearer CAN, by announcement, cash the promise,
  provided that any conditions for cashing it specified by its text
  are unambiguously met. By doing so, e acts on the creator of the
  promise's behalf, causing the creator to act as if e published the
  promise's text, and destroys the promise.

the text:

  However, to limit recursion, no promise can be cashed during the execution
  of another promise unless it existed before the execution of that promise
  began."""
            )
        }

        proposal(8552) {
            title("Apathy for all")
            proposalAI(ProposalAI(BigDecimal("1.0")))
            decisionAI(DecisionAI(BigDecimal("2.0")))
            author(Janet)
            coauthors(ais523)
            ordinary()
            sponsored()

            text(
                """
Amend Rule 2465 by replacing, as a single amendment, the text "set of
players" with "set of persons" and the text "specified players" with
"specified persons"."""
            )
        }

        proposal(8553) {
            title("Slightly less apathetic")
            ai("1.0")
            author(Janet)
            ordinary()
            sponsored()

            text(
                """
Amend Rule 2465, "Victory by Apathy", by replacing the final "."
character with the following: ", except for those who have won the game
through this Rule in the past 14 days.""""
            )
        }

        proposal(8554) {
            title("I Want My Promise Back!")
            ai("2.2")
            author(Aspen)
            coauthors(nix)
            ordinary()
            sponsored()

            text(
                """
[This is intended to remove the need to put in a special provision
to a promise allow the creator to destroy a promise in the possession of
the Library. Since that's usually what's wanted, this makes it the
default behavior, while still allowing the creator to override it.]

Amend Rule 2618, "Promises", by inserting, after the text:

  The Library is an entity and CAN own promises. Any player CAN take
  a specified promise from the Library by announcement, provided e
  cashes the promise in the same message.

the text:

  The creator of a promise CAN take or revoke it from the Library by
  announcement, unless the promise's text unambiguously designates
  it as irrevocable."""
            )
        }

        proposal(8555) {
            title("something to vote on")
            ai("1.0")
            author(G)
            ordinary()
            sponsored()

            text(
                """
The player who voted unambiguously FOR, and had the highest
unique[*] voting strength (at the end of the voting period) on,
the decision to adopt this proposal

                      is hereby granted

                  ****  1 Victory Card   *****

[* "Highest unique" means if the top two are 15 and the next
highest is 14, and no one else is at 14, the 14 wins]."""
            )
        }
    }

    voting {
        votes(Aspen) {
            FOR on 8549
            AGAINST on 8552
            AGAINST on 8553
            FOR on 8554
            PRESENT on 8555
        }

        votes(Janet) {
            FOR on 8549
            FOR on 8552
            FOR on 8553
            FOR on 8554
            FOR on 8555
        }

        votes(Gaelan) {
            FOR on 8549
            AGAINST on 8552
            FOR on 8553
            FOR on 8554
            AGAINST on 8555 comment legacyConditionalComment("not highest unique voting strenght")
        }

        votes(Murphy) {
            FOR on 8549
            FOR on 8552
            FOR on 8553
            FOR on 8554
            FOR on 8555
        }

        votes(Madrid) {
            FOR on all
        }

        votes(Falsifian) {
            endorse(Aspen) on 8549
            AGAINST on 8552
            PRESENT on 8553
            endorse(Aspen) on 8554
            AGAINST on 8555
        }

        votes(cuddlybanana) {
            FOR on all
        }

        votes(Trigon) {
            FOR on 8549
            PRESENT on 8552
            AGAINST on 8553
            FOR on 8554
            FOR on 8555
        }

        votes(RLee) {
            AGAINST on 8549 comment legacyConditionalComment("adds text to the ruleset")
            PRESENT on 8552 comment legacyConditionalComment("does not add text to the ruleset")
            AGAINST on 8553 comment legacyConditionalComment("adds text to the ruleset")
            AGAINST on 8554 comment legacyConditionalComment("adds text to the ruleset")
            PRESENT on 8555 comment legacyConditionalComment("does not add text to the ruleset")
        }

        votes(Aenet) {
            AGAINST on 8552
            FOR on others
        }

        votes(ATMunn) {
            FOR on 8549
            PRESENT on 8552
            PRESENT on 8553
            FOR on 8554
            AGAINST on 8555
        }

        votes(G) {
            AGAINST on all
        }
    }
}
