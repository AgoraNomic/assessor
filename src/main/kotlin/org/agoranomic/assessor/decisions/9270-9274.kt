package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9270to9274() = assessment {
    name("9270-9274")
    quorum(7)

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
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy null
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9270) {
            title("The Number Cards Game")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 991, after
{{{
When an open CFJ's judge is unassigned, the Arbitor CAN assign any
eligible player to be its judge by announcement, and SHALL do so
in a timely fashion after it becomes an open and unassigned CFJ.
}}},
add
{{{
In the same message in which e does so, e SHALL also (and CAN by
announcement or by clear specification) assign it an ID number, unless
it already has one.
}}}

Create a new power-1 rule, "Number Cards":
{{{
Number cards are a type of asset. Ownership of number cards is
restricted to players and contracts. Each number card has a type, which
is a decimal digit in the range 0 to 9 inclusive. Number cards with the
same type are fungible.

The Numerator is an office, and the recordkeepor of number cards.
}}}

Create a new power-1 rule, "Scoring Numbers":
{{{
Whenever an inquiry case with an ID number is assigned a judgement, if
it had never previously been assigned a judgement, its judge scores its
ID number, unless its initiator had initiated 4 or more other CFJs
earlier in the same week that it was initiated.

Whenever a distributed proposal is adopted, its author scores its ID
number, unless its author had submitted 8 or more proposals earlier in
the same week that it was submitted.

Whenever a player scores a number as described in this rule, the
Numerator CAN once, and SHALL in a timely manner, grant its author
(and, if the number was scored due to the adoption of a proposal, also
a randomly chosen other player who voted FOR on a referendum to adopt
that proposal) a number card for each digit in that number, whose type
is that digit.

Officers SHALL NOT assign ID numbers to distributed proposals or CFJs
that are out of sequence, but are given reasonable discretion to
determine what "in sequence" means (e.g. officers may choose whether to
include or exclude in the numbering sequence entities whose proposal or
CFJ status is disputed or unclear). ID numbers that are more than 5
digits long cannot be scored (this is an exception to the other
paragraphs of this rule and takes precedence over them).
}}}

Create a new power-1 rule, "Spending Number Cards":
{{{
A player CAN, once per week, pay ten number cards, where each of those
number cards is of a different type, to gain 25 radiance.

For any two decimal digits X and Y (which may be the same), a player
CAN pay 2 spendies, a number card of type X, and a number card of type
Y to grant emself a number card whose type is the last digit of the sum
X+Y.
}}}

[Trigon said via IRC/Discord: "ais523: if you draft your idea, you have
my express permission to install me to the office by proposal."]

Flip the Officeholder of the Numerator office to Trigon."""
            )
        }

        proposal(9271) {
            title("Strict typing")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 1688 ("Power") by appending the following paragraph:

{

A Rule that designates the creation of an entity of a given type as
secured (to a given extent) thereby designates the causing of an entity
to have that type as secured (to the same extent). Similarly, a Rule
that designates the destruction of an entity of a given type as secured
(to a given extent) thereby designates the causing of an entity to cease
to have that type as secured (to the same extent).

}


Amend Rule 1607 ("Distribution") by replacing the paragraph beginning
"The destruction of a referendum" with the following paragraph:

{

The destruction of a referendum is secured.

}


Amend Rule 2350 ("Proposals") by replacing "The destruction of a
proposal and the causing of a proposal to cease being a proposal are
secured." with "The destruction of a proposal is secured.".


[More generically handle security around changing the types of entity.
Anything securing the creation of a certain type of entity presumably
also wants to regulate something else becoming that type, and similarly
anything securing the destruction of a certain type of entity presumably
also wants to regulate an entity ceasing to be that type.]"""
            )
        }

        proposal(9272) {
            title("Secure emergencies")
            ai("3.1")
            author(ais523)
            coauthors(Janet)
            democratic()

            text(
                """
If the last paragraph of rule 2614 says
{{{
Rules to the contrary notwithstanding, Emergency Regulations
CANNOT be enacted, amended, or repealed except as described in
this Rule.
}}},
change it to
{{{
Rules to the contrary notwithstanding, Emergency Regulations
CANNOT be enacted, amended, or repealed except as described in
this Rule, nor can an entity that is not an Emergency Regulation be
made to become an Emergency Regulation except as described in this
rule.
}}}"""
            )
        }

        proposal(9273) {
            title("The Weather Forecast")
            ai("1.0")
            author(ais523)
            coauthors(Janet)
            ordinary()

            text(
                """
In rule 2709, before the last paragraph, add a new paragraph:
{{{
Once each week, the Land Managor SHALL randomly select and announce the
Weather for that week, which is either Good, Neutral, or Bad (each of
which has an equal probability). At the end of each week in which Bad
Weather was selected this way, all unharvested Crops are lost.
}}}
and amend the paragraph starting "Once per Crop" to read as follows:
{{{
Once per Crop that a player planted earlier in the current Crop
Season and at least <Growth Duration> days ago, e CAN harvest it
by announcement, gaining Pyrite equal to its Sell Price (exception: if
the Weather for the week e planted it had already been selected at the
time e planted it, e CANNOT harvest it before the end of the week after
the week e planted it).
}}}

[This is intended to reduce the potential for exponential growth in the
farming subgame by introducing a chance that planting crops will fail:
repeatedly investing everything means that eventually everything will
be destroyed by bad weather, so a prudent farmer will keep some
proportion of eir Pyrite back. It still probably grows exponentially,
but at least the strategy is more interesting.

This could potentially be expanded by listing out types of weather with
varying probabilities per season and having different crops respond to
different types of weather in different ways, but I didn't want to make
it unnecessarily complex.]"""
            )
        }

        proposal(9274) {
            title("Bring Back Yellow")
            ai("3.0")
            author(Forest)
            coauthors(snail, Trigon)
            democratic()

            text(
                """
Amend Rule 2348 ("Ribbons") by appending another paragraph after the
one starting with "Orange (O):" with the text:
{
Yellow (Y): When a tournament that a player was a gamemaster of ends
with a winner, that gamemaster earns a Yellow Ribbon. When a player
earns an Indigo Ribbon, that player CAN by announcement in a timely
manner, grant up to three other players a Yellow Ribbon."""
            )
        }
    }

    voting {
        votes(Cosmo) {
            FOR on 9270
            FOR on 9271
            FOR on 9272
            FOR on 9273
            AGAINST on 9274
        }

        votes(ais523) {
            FOR on 9270
            FOR on 9271
            FOR on 9272
            FOR on 9273
            // AGAINST of two or more of {Janet, Murphy, Aris, qenya} vote other than conditionally FOR, else PRESENT
        }

        votes(juan) {
            FOR on 9270
            PRESENT on 9271
            PRESENT on 9272
            AGAINST on 9273
            PRESENT on 9274
        }

        votes(Murphy) {
            FOR on 9270
            FOR on 9271
            FOR on 9272
            PRESENT on 9273
            FOR on 9274
        }

        votes(Mischief) {
            AGAINST on 9270
            // No other votes
        }

        votes(Janet) {
            AGAINST on 9270
            FOR on 9271
            FOR on 9272
            FOR on 9273
            AGAINST on 9274
        }

        votes(snail) {
            FOR on 9270
            FOR on 9271
            FOR on 9272
            FOR on 9273
            AGAINST on 9274
        }

        votes(Trigon) {
            FOR on 9270
            PRESENT on 9271
            FOR on 9272
            PRESENT on 9273
            AGAINST on 9274
        }
    }
}
