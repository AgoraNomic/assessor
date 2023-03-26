package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8926to8933() = assessment {
    name("8926-8933")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Janet, 3 / 3)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)

            powerStone(snail, 6)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy nix
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Horsened"(1) heldBy snail
                "Mad Engineer"(1) heldBy Janet
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy nix
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Janet
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8926) {
            title("Just add the sins directly")
            ai("3.0")
            author(Forest)
            coauthors(nix)
            democratic()

            text(
                """
Some rules have synonyms defined (EG CFJ, intend, submit, proposer,
become) and some... don't. Yet somehow they all work based on the
'belief' that they work (like CFJs and airplanes). So the time has come
to codify it. Additionally, some doubt has come based on whether "oppose"
is sufficient to object to Agoran consent, and if other systems are
working on 'belief', then either that should be standardized, or this.
And it is of my opinion that Agorans would rather have things this way,
so...

ThUSLY, Amend R2201 ("Self-Ratification") by replacing:
"(syn. claim of error)" with "(syn. CoE, claim of error)"

AND SO, Amend R2202 ("Ratification Without Objection") by replacing:
"A player CAN, without objection, ratify a specified public document."
with:
"A player CAN, without objection, ratify a specified public document
(syn. RWO).""""
            )
        }

        proposal(8927) {
            title("One More Sin")
            ai("1.0")
            author(Forest)
            coauthors(nix)
            ordinary()

            text(
                """
Amend R1681 ("The Logical Rulesets") by appending the following:
"Generally, R[N] is shorthand for Rule [N].""""
            )
        }

        proposal(8928) {
            title("Acting on commitment")
            ai("1.0")
            author(juan)
            ordinary()

            text(
                """
Enact a rule with power=1.0 entitled "Acting on commitment" with text:

{
A Fingerprint for a document (the Plaintext) is a document that could
not have been reasonably created without knowledge of the Plaintext, and
which is related to the Plaintext in such a way that one could not
reasonably produce another document related to that Fingerprint in the
same way.

Where the rules define an action that a person CAN perform "by
commitment" to a particular kind of document, that person performs
that action by performing it by announcement while, in the same
message, also publishing a what is purportedly a Fingerprint for a
document of that kind.
}"""
            )
        }

        proposal(8929) {
            title("Tabled action security")
            ai("3.0")
            author(Janet)
            coauthors(Murphy, snail)
            democratic()

            text(
                """
Amend Rule 2124 ("Performing Tabled Actions") by deleting the list item
containing "Cease to be a" and by inserting the following after the
first paragraph:

{

A supporter/objector to an intent, acting as emself, CAN by announcement
cease to be a supporter/objector ("withdraw" support/objection) of that
intent.

Limiting the ability to support or object to an intent is secured at the
power of the rule enabling that action to be performed.

}"""
            )
        }

        proposal(8930) {
            title("Rebalancing")
            ai("1.0")
            author(nix)
            coauthors(Murphy, snail)
            ordinary()

            text(
                """
[Little buff to CFJs and nerf to Proposals, now that proposals have
become very common. Wording should work with current version or
Radiance.]

Amend R2657 by replacing:

     "Being the author of a proposal that takes effect: 5"

with:

     "Being the author of a proposal that takes effect: 4"

and replacing:

     "Judging a CFJ that e was assigned to without violating a time
limit to do so, unless at the time of judgement the case was open due to
self-filing a motion to reconsider it: 2"

with:

     "Judging a CFJ that e was assigned to without violating a time
limit to do so, unless at the time of judgement the case was open due to
self-filing a motion to reconsider it: 3""""
            )
        }

        proposal(8931) {
            title("Rhyme Time")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Enact a rule entitled "Rhyme Time" at power=1:
{
Now what this rule will do
Is enumerable by two.

One of which, you will find,
is that this rule must near-rhyme.

The first of which is already done,
Now near-rhyme on new rules of power 1.
}"""
            )
        }

        proposal(8932) {
            title("Only so bright")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2657 by replacing "Each time a player fulfills a radiance
condition, e CAN once by announcement" with "Each time a player fulfills
a radiance condition, e CAN once, within 14 days, by announcement"."""
            )
        }

        proposal(8933) {
            title("Ritual Ratification")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2680 by replacing "Declared ritual numbers are
self-ratifying." with "A purported attempt to declare the ritual number
is a self-ratifying attestation that such attempt was successful and
that the ritual number was declared.""""
            )
        }
    }

    voting {
        votes(Forest) {
            endorse(snail) on 8926
            endorse(G) on 8927
            endorse(G) on 8928
            endorse(snail) on 8929
            endorse(ais523) on 8930
            FOR on 8931
            endorse(RLee) on 8932
            endorse(snail) on 8933
        }

        votes(juan) {
            AGAINST on 8926
            AGAINST on 8927
            FOR on 8928
            FOR on 8929
            FOR on 8930
            AGAINST on 8931
            FOR on 8932
            PRESENT on 8933
        }
    }
}
