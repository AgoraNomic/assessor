package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9329to9337() = assessment {
    name("9329-9337")
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
                "Notary"(2) heldBy Nilrem
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy ais523
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Mischief
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9329) {
            title("Ruleset ratification")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Ratify the purported Short Logical Ruleset published by Janet on or
about October 12, 2025, 21:54:48 UTC, available at [0]

[0]:
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2025-October/018737.html

[This proposal is brought to you by Rule 2686 (and is very late because
I forgot, oops). I believe every ruleset since November 11, 2025 has
been wrong under the judgements in CFJ 4143 and 4144, so I've picked a
ruleset from October of last year that, to my knowledge, has no errors.]"""
            )
        }

        proposal(9330) {
            title("Operands")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Create a rule titled "Operands" with this text:

       Operand is a player switch, tracked by the Numerator, with values
       Sum (default), Difference, Product, and Quotient.

       Once per month, a player CAN flip eir Operand by announcement.

Amend Rule 2714 (Spending Number Cards) by replacing the paragraph
starting "For any two decimal digits X and Y" with this text:

       For any two decimal digits X and Y (which may be the same), a
       player CAN pay 2 spendies, a number card of type X, and a number
       card of type Y to grant emself a number card whose type is equal
       (modulo 10) to:

         * X+Y, if eir Operand is Sum

         * X-Y or Y-X, if eir Operand is Difference

         * X*Y, if eir Operand is Product

         * A/B, if eir Operand is Quotient, for some numbers A and B
           such that A = X (modulo 10) and B = Y (modulo 10)"""
            )
        }

        proposal(9331) {
            title("Imperative Business")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
Amend rule 2449 (Winning the Game) by replacing the text "The Herald is
then authorized to award those persons the Patent Title of Champion
once, by announcement." with "The Herald CAN once by announcement, and
SHALL in a timely fashion, award those persons the Patent Title of
Champion."

[As it stands now, if the Herald is AWoL this can't be deputized for.]"""
            )
        }

        proposal(9332) {
            title("Fix Proposal I Couldn't Think Of A Good Title For")
            ai("2.0")
            author(Kate)
            ordinary()

            text(
                """
Amend Rule 991, "Calls for Judgement", by performing the single revision
of removing the following text:

       In the same message in which e does so, e SHALL also (and CAN by
       announcement or by clear specification) assign it an ID number,
       unless it already has one.

and inserting the following as a new paragraph immediately preceding the
last paragraph:

       If a CFJ does not have an ID number, the Arbitor CAN by
       announcement or by clear specification assign an ID number to it,
       and SHALL do so in any message in which e assigns a player to
       judge it.

Assign the ID number 4140 to the CFJ called by Galle on 2026-02-26.

Grant Janet one number card of type 0; one number card of type 1; and
two number cards of type 4."""
            )
        }

        proposal(9333) {
            title("Whither Weather?")
            ai("1.0")
            author(Galle)
            ordinary()

            text(
                """
Amend Rule 2708 ("Crops") to read as follows:
---
Creating and destroying types of Crop is secured.

Growing Season, Seed Cost, Growth Duration, Resilience, Opportunity, and
Sell Price are Crop type switches, tracked by the Land Managor, with
these values:

- Growing Season - all Crop Seasons
- Seed Cost - integers from 50 to 200 inclusive
- Growth Duration - integers from 3 to 24 inclusive
- Resilience - integers from 70 to 100 inclusive
- Opportunity - integers from 1 to 30 inclusive
- Sell Price - integers from 100 to 400 inclusive

Rules to the contrary notwithstanding, a Crop type CANNOT be planted
while its Seed Cost is null, and CANNOT be harvested while its Growth
Duration or Sell Price is null.

When rounding Seed Cost or Growth Duration, ties are broken toward the
larger value.

An in-season Crop is one whose Growth Season is in progress. All others
are out-of-season.
---

Amend Rule 2709 ('The Growth Cycle') to read as follows:
---
A player CAN plant an in-season Crop by paying a fee in Pyrite equal to
its Seed Cost, provided that eir number of Hectares is greater than the
number of unlost, unharvested Crops e planted earlier in the current
Crop Season. <Growth Duration> days after it is planted, an unlost Crop
ripens.

Once per ripe, unlost, unharvested Crop that a player planted, e CAN
harvest it by announcement gaining Pyrite equal to its Sell Price
(exception: if the Weather for the week e planted it had already been
selected at the time e planted it, e CANNOT harvest it before the end of
the week after the week e planted it).

When the Fields Wither, all unharvested Crops are lost.

Weather is a secured singleton integer switch with values between 1 and
100 inclusive, tracked by the Land Managor, with a default value of 50.
Once per week, the Land Managor SHALL select and announce a random
integer between 1 and 100 to be that week's Weather. Upon such an
announcement, the Weather is flipped to that value. At the end of each
week, all crops with Resilience lower than the current Weather are lost
and all crops with Opportunity greater than the current Weather ripen.

At the end of each Crop Season, the Fields Wither.
---

Amend the second sentence of the first paragraph of Rule 2710 ('Genetic
Modification') to read as follows:
---
The Land Managor CAN once by announcement, and SHALL in a timely
fashion, set its Growth Season, Seed Cost, Growth Duration, Resilience,
Opportunity, and Sell Price to randomly selected valid values.
---

Amend the second paragraph of Rule 2710 ('Genetic Modification') to read
as follows:
---
Once per Crop Season, a player CAN pay a fee of 750 Pyrite to alter a
type of out-of-season Crop's Seed Cost, Growth Duration, Resilience,
Opportunity, or Sell Price by up to 25% in either direction.
---

Set the Resilience of all Crop types to 90. Set the Opportunity of all
Crop types to 20."""
            )
        }

        proposal(9334) {
            title("Pig Pen")
            ai("2.0")
            author(Murphy)
            coauthors(Nilrem)
            ordinary()

            text(
                """
Create a rule titled "Aggression" with Power 2 and this text:

       Aggression is a player switch, tracked by the Referee, with values
       Negligible (default) and Ruthless.

       A player CAN flip eir Aggression from Negligible to Ruthless by
       announcement.

       A player CAN flip eir Aggression from Ruthless to Negligible with
       Agoran consent, or by announcement if e last became Ruthless at
       least three months ago.

       The voting strength of Ruthless players is increased by 1.

       If a Ruthless player commits an infraction, then all players
       SHOULD note it (if not already noted), and the Investigator SHOULD
       assign as large a penalty as possible when investigating it.

[Needs to be Power 2 to affect voting strength.]"""
            )
        }

        proposal(9335) {
            title("Infraction reporting requirements")
            ai("1.7")
            author(Murphy)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 2478 (Justice) by replacing this text:

       The Referee's weekly report contains a list of noted and
       investigated Infractions committed in the previous week.

with this text:

       The Referee's weekly report includes a list of infractions
       noted, investigated, and/or non-automatically forgiven in the
       previous week.

[Adjust scope to look at when an infraction was responded to, not when
  it was committed. Include infractions noted and not yet investigated,
  in case the Referee has not yet decided how many Blots are appropriate,
  plus infractions forgiven with Agoran consent.]"""
            )
        }

        proposal(9336) {
            title("Counter-revolution")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
Repeal any rule titled "Purchased Re-enactment"

Repeal any rule that includes this {}-delimited text in its body
(whitespace and case insensitive:

{
For the purpose of this rule, a proposal or former proposal is an
"adopted proposal" if any past referendum on that proposal or former
proposal had an outcome oF ADOPTED.

A player CAN revive an adopted proposal by paying a fee of 25
Spendies. When a player does so, this rule performs the same rules
changes that that adopted proposal would perform if it took effect
right now.
}

Repeal any rule that includes "Janet" or "ais523" in its body (case
insensitive)"""
            )
        }

        proposal(9337) {
            title("Counter-revolution Mk II")
            ai("3.0")
            author(Mischief)
            coauthors(Kate)
            democratic()

            text(
                """
[Includes a carveout for R2486 as suggested by qenya, unless the
would-be duumvirate tries to exploit it.]

Repeal any rule titled "Purchased Re-enactment"

Repeal any rule that includes this {}-delimited text in its body
(whitespace and case insensitive:

{
For the purpose of this rule, a proposal or former proposal is an
"adopted proposal" if any past referendum on that proposal or former
proposal had an outcome oF ADOPTED.

A player CAN revive an adopted proposal by paying a fee of 25
Spendies. When a player does so, this rule performs the same rules
changes that that adopted proposal would perform if it took effect
right now.
}

Repeal any rule that includes "Janet" or "ais523" in its body (case
insensitive), except for rule 2486 if its body is exactly identical to
its body as of the beginning of this year."""
            )
        }
    }

    voting {
        votes(Cosmo) {
            FOR on 9329
            FOR on 9330
            FOR on 9331
            PRESENT on 9332
            FOR on 9333
            FOR on 9334
            FOR on 9335
            FOR on 9336
            FOR on 9337
        }

        votes(Murphy) {
            endorseOfficer("Rulekeepor", Janet) on 9329
            endorseOfficer("Numerator", Trigon) on 9330
            FOR on 9331
            FOR on 9332
            PRESENT on 9333
            FOR on 9334
            FOR on 9335
            FOR on 9336
            FOR on 9337
        }

        votes(Galle) {
            FOR on 9329
            FOR on 9330
            FOR on 9331
            FOR on 9332
            FOR on 9333
            FOR on 9334
            FOR on 9335
            AGAINST on 9336
            FOR on 9337
        }

        votes(Trigon) {
            PRESENT on 9329
            AGAINST on 9330
            FOR on 9331
            FOR on 9332
            PRESENT on 9333
            PRESENT on 9334
            FOR on 9335
            FOR on 9336
            FOR on 9337
        }

        votes(Forest) {
            FOR on 9329
            FOR on 9335
            AGAINST on 9336
            AGAINST on 9337
        }

        votes(Janet) {
            PRESENT on 9329
            AGAINST on 9330
            FOR on 9331
            FOR on 9332
            AGAINST on 9333
            AGAINST on 9334
            FOR on 9335
            AGAINST on 9336
            AGAINST on 9337
        }

        votes(juan) {
            FOR on 9329
            PRESENT on 9330
            FOR on 9331
            FOR on 9332
            PRESENT on 9333
            FOR on 9334
            PRESENT on 9335
            PRESENT on 9336
            PRESENT on 9337
        }

        votes(Mischief) {
            endorseOfficer("Rulekeepor", Janet) on 9329
            FOR on 9330
            FOR on 9331
            FOR on 9332
            endorseOfficer("Land Managor", Murphy) on 9333
            FOR on 9334
            endorseOfficer("Referee", ais523) on 9335
            FOR on 9336
            FOR on 9337
        }
    }
}
