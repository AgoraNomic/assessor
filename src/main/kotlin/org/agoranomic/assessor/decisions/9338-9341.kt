package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9338to9341() = assessment {
    name("9338-9341")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Janet
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }


    proposals(v4) {
        proposal(9338) {
            title("Claim of Error Withdrawal")
            ai("3.0")
            author(Galle)
            democratic()

            text(
                """
Amend Rule 2201, "Self-Ratification", by inserting the following
paragraph immediately before the final paragraph:
---
As long as the publisher of the original document has not yet responded
in any of the above ways, the issuer of a doubt CAN, by announcement,
withdraw the doubt, causing it to cease to be a doubt. The above
notwithstanding, the publisher of the original document NEED NOT respond
to a withdrawn doubt.
---"""
            )
        }

        proposal(9339) {
            title("Unbearable Confusion")
            ai("2.2")
            author(Nilrem)
            coauthors(ais523)
            ordinary()

            text(
                """
Create a new Rule with power 2.2 Titled "Temporary Helper" with the
following text:

       This rule takes priority over rule 2618.

       The text of a promise CAN be altered after it was created by
       proposals with Adoption Index 2.2 or greater.

For each existing promise, modify its text by replacing all instances of
the phrase "the bearer" with the phrase "the casher".

Repeal the Rule titled "Temporary Helper".

Modify Rule 2618 by replacing the following text:

       In a promise's text, "the bearer" and "the casher" (or the like)
       both refer to the player who cashed the promise, and "this
       promise" (or the like) refers to the promise. The text of the
       promise can refer to the context of the message in which it is
       cashed, but the context of the message does not otherwise change
       the meaning of the promise.

With this text:

       In a promise's text, "this promise" (or the like) refers to the
       promise. The text of the promise can refer to the context of the
       message in which it is cashed, but the context of the message does
       not otherwise change the meaning of the promise."""
            )
        }

        proposal(9340) {
            title("Simultaneous Rule Changes Fix")
            ai("3.0")
            author(Galle)
            democratic()

            text(
                """
Amend Rule 105 ("Rule Changes") by replacing the following text:
---
A rule change is any effect that falls into the above classes. Rule
changes always occur sequentially, never simultaneously. If a
specification would ever be interpreted as causing multiple changes to
happen at once, it is instead interpreted as attempting to cause them to
occur separately, in the order they are listed in the specification.
---

With the following text:
---
A rule change is any effect that falls into the above classes. Rule
changes always occur sequentially, never simultaneously. If a
specification would ever be interpreted as causing multiple changes to
happen at once, it is instead interpreted as attempting to cause them to
occur separately, in the order they are listed in the specification. If
no such order can be inferred, then the specified rule changes are void
and without effect.
---"""
            )
        }

        proposal(9341) {
            title("Alternative simultaneous rule changes v1.1")
            ai("3.0")
            author(Murphy)
            democratic()

            text(
                """
Amend Rule 105 (Rule Changes) by replacing the paragraph containing "A
rule change is any effect that falls into the above classes." with:

       A rule change is any effect that falls into the above classes.
       Rule changes always occur sequentially, never simultaneously. If a
       specification would ever be interpreted as causing multiple
       changes to happen at once, it is instead interpreted as attempting
       to cause them to occur separately, in the order they are listed in
       the specification; or, if no such order is specified, and choosing
       one order over another would not make a substantive difference to
       the gamestate, then in order of increasing rule number (ties
       broken by when the rules were created, earliest to latest).

[Explicitly allows proposals like "Amend all rules containing X by
  replacing X with Y" where it would make no substantive difference which
  order those amendments occurred, as long as they all did occur.

  A malformed proposal amounting to "Repeal all or most rules" would be
  pretty much guaranteed to make a substantive difference, in which case
  this clause would remain silent, and the next paragraph of R105 would
  still negate it due to ambiguity.]"""
            )
        }
    }

    voting {
        votes(Cosmo) {
            FOR on 9338
            PRESENT on 9339
            PRESENT on 9340
            FOR on 9341
        }

        votes(Galle) {
            FOR on 9338
            FOR on 9339
            FOR on 9340
            AGAINST on 9341
        }

        votes(Janet) {
            PRESENT on 9338
            AGAINST on 9339
            FOR on 9340
            AGAINST on 9341
        }

        votes(juan) {
            FOR on 9338
            FOR on 9339
            PRESENT on 9340
            PRESENT on 9341
        }

        votes(Mischief) {
            FOR on 9338
            endorse(Janet) on 9339
            FOR on 9340
            AGAINST on 9341
        }

        votes(ais523) {
            PRESENT on 9338
            FOR on 9339
            FOR on 9340
            AGAINST on 9341
        }

        votes(Kate) {
            FOR on 9338
            FOR on 9339
            AGAINST on 9340
            FOR on 9341
        }
    }
}
