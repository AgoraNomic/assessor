package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9310to9321() = assessment {
    name("9310-9321")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy null
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy Nilrem
                "Numerator"(1) heldBy Trigon
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
        proposal(9310) {
            title("Paperwork Reduction Act")
            ai("1.0")
            author(Mischief)
            coauthors(Murphy)
            ordinary()

            text(
                """
Amend rule 2585 (Birthday Gifts) by replacing the text reading:

       Upon a correct announcement by a player that eir Agoran Birthday
       has occurred in the last 15 days, e scores eir Agoran Birthday if
       e has not scored eir Agoran Birthday by this method for that
       instance of eir Agoran Birthday.

with:

       Upon a correct announcement that a player's Agoran Birthday has
       occurred in the last 15 days, e scores eir Agoran Birthday if e
       has not scored eir Agoran Birthday by this method for that
       instance of eir Agoran Birthday."""
            )
        }

        proposal(9311) {
            title("Lux Solis")
            ai("1.5")
            author(Mischief)
            coauthors(Murphy)
            ordinary()

            text(
                """
[Outshining the Sun has effects in two separate rules. This
consolidates the effects into a single rule. Given that we probably owe
Janet a win for spotting the welcome package glitch, I wanted to make
extra sure this didn't break anything while that's outstanding, hence
the non-severability.

This also has the side effect of clarifying the relative timing of
R2656's and R2711's effects, in case that ever matters.]

Apply the following rule changes in order and non-severably (that is,
if any one would fail, they all fail):

1. Retitle rule 2711 (Light Overexposure) to "Outshining the Sun"

2. Set rule 2711's power to 1.5

3. Amend rule 2711 to read:

       Upon a correct announcement from a player that eir radiance is 100
       or more (correctly specifying the amount), e Outshines the Sun.

       When a player Outshines the Sun, e wins the game. When a player
       wins the game this way, the following happen in order:

       * Eir radiance is set to 0.

       * The radiance of each other player is set to half its current
         value (rounded down).

       * All Pyrite is destroyed.

       * The Fields Wither.

       * All Hectares are destroyed.

       * Each player is granted 16 Hectares.

4. Amend rule 2656 (Radiance) by removing the text reading:

       Upon a correct announcement from a player that eir radiance is 100
       or more (correctly specifying the amount), e Outshines the Sun.

       When a player Outshines the Sun, e wins the game. When a player
       wins the game this way, the following happen in order:

       * Eir radiance is set to 0.

       * The radiance of each other player is set to half its current
         value (rounded down)."""
            )
        }

        proposal(9312) {
            title("Executive Solution")
            ai("3.0")
            author(Mischief)
            coauthors(ais523, Murphy)
            democratic()

            text(
                """
[Rather than try to write auctions and such into the rules, we can
outsource it to administrative regulations. This also allows for more
flexibility to experiment -- maybe we want to try a raffle instead, or
perhaps just incinerate the assets. Additionally, different potential
approaches could lead to elections actually decided based on policy!]

Create a rule titled "The Executor" with power 2 reading:

       The Executor is an elected office responsible for managing assets
       in the Lost and Found Department.

       The Executor SHOULD maintain administrative regulations
       specifying how e will manage such assets. The Executor is
       ENCOURAGED to draft eir administrative regulations such that any
       actions e takes to manage such assets occur no less frequently
       than quarterly.

Amend rule 2576 (Ownership) by replacing the text reading:

       An asset "in abeyance" is one whose owner is nonexistent,
       indeterminate, or invalid. If an asset would otherwise be in
       abeyance, then it is owned by the Lost and Found Department (if
       possible) or destroyed (otherwise), subject to modification by its
       backing document (provided that the modification either destroys
       it or prevents it from being in abeyance). Rules to the contrary
       notwithstanding, the Lost and Found Department can own assets of
       every type. Assets owned by the Lost and Found Department can be
       transferred or destroyed by any player without objection.

with:

       An asset "in abeyance" is one whose owner is nonexistent,
       indeterminate, or invalid. If an asset would otherwise be in
       abeyance, then it is owned by the Lost and Found Department (if
       possible) or destroyed (otherwise), subject to modification by its
       backing document (provided that the modification either destroys
       it or prevents it from being in abeyance). Rules to the contrary
       notwithstanding, the Lost and Found Department can own assets of
       every type.

       Assets owned by the Lost and Found Department can be transferred
       or destroyed by any player without objection. Assets owned by the
       Lost and Found Department can be transferred or destroyed by the
       Executor, as authorized by the Executor's administrative
       regulations.

Amend rule 2659 (Stamps) by removing the text reading:

       Any player CAN pay a fee of 6 Spendies to transfer a specified
       stamp from the L&FD to emself."""
            )
        }

        proposal(9313) {
            title("Even Fewer Cretan Applications")
            ai("3.0")
            author(Trigon)
            coauthors(Galle)
            democratic()

            text(
                """
Amend rule 2240 "No Cretans Need Apply" by replacing "Rule" with "rule,
contract, or regulation" wherever it appears.

(Comment: For avoidance of doubt when it comes to rule-like objects,
whether or not Galle's CFJ is determined to be a problem. The
replacement language is attested in Rule 1586 "Definition and Continuity
of Entities")"""
            )
        }

        proposal(9314) {
            title("No Overpowered Deputies")
            ai("3.0")
            author(Mischief)
            coauthors(Murphy)
            democratic()

            text(
                """
[Currently, one can repeatedly deputise for an office that would
otherwise make em overpowered. R2160 prevents the deputy from actually
taking office in that case, but that doesn't avoid the resulting
potential conflict of interest / misuse of official power. (However,
I'm leaving that provision in place as additional protection, even
though this change probably makes it redundant.)

Note: this proposal does not conflict with P9305.]

Amend rule 2160 (Deputisation) by inserting after:

        4) The deputy has not held the office in the past 7 days.

a new top-level list bullet reading:

        5) The deputy would not be Overpowered if e held the office.

and then renumbering each of the subsequent top-level list bullets
accordingly; that is, the pre-amendment 5), 6), and 7) become 6), 7),
and 8), respectively."""
            )
        }

        proposal(9315) {
            title("Sisyphean Headgear")
            ai("1.0")
            author(Mischief)
            coauthors(Murphy)
            ordinary()

            text(
                """
Amend rule 2694 (Hats) by replacing the text reading:

         dunce cap: expressing regret or acknowledging a mistake

         floral wreath: resolving conflict

with:

         dunce cap: expressing regret or acknowledging a mistake

         exercise headband: pushing the boulder

         floral wreath: resolving conflict"""
            )
        }

        proposal(9316) {
            title("What was that word, again?")
            ai("3.0")
            author(Murphy)
            coauthors(Mischief)
            democratic()

            text(
                """
Amend Rule 2202 (Ratification Without Objection) by replacing this text:

       A player SHALL NOT knowingly use or announce intent to use
       Ratification Without Objection to ratify a (prior to ratification)
       document containing incorrect or Indeterminate information

with this text:

       A player SHALL NOT knowingly use or announce intent to use
       Ratification Without Objection to ratify a document that (prior to
       ratification) contained incorrect or Indeterminate information

[Of course the document /exists/ prior to ratification; what we care
  about here is whether it was known to be incorrect or Indeterminate,
  prior to trying to ratify it.]

Amend Rule 1023 (Agoran Time) by replacing this text in the definition
of "in a timely fashion":

       (i.e. X days before the limit ends).

with this text:

       (i.e. 7 days before the limit ends).

[Left over from 2013 when we repealed Speed, a singleton switch that
  affected various durations, in this case:

       "within X days", where X is 14 when the Speed is Slow, 7 when it
       is Normal and 5 when it is Fast.
]

Amend Rule 2625 (Proposal Recycling) by replacing this text:

       adding it to the Proposal Pool and causing it to become pended.

with this text:

       adding it to the Proposal Pool.

["Pended" is no longer defined.]"""
            )
        }

        proposal(9317) {
            title("Office cleanup")
            ai("3.0")
            author(Murphy)
            coauthors(Mischief)
            democratic()

            text(
                """
Amend Rule 2689 (Vacations & Delegation) by replacing this text:

       Delegate is an Office switch with possible values of "None" and
       any active player, and default value of "None". Delegates are
       tracked by the ADoP in eir weekly report.

       A player CAN flip the Delegate switch of a specified office to
       emself with Agoran Consent. If the Delegate switch of an office is
       set to "None", the holder of that office CAN flip the Delegate
       switch of that office to a specified player with support from that
       specified player.

with this text:

       Delegate is an Office switch, tracked by the ADoP, with possible
       values "None" (default) and any active player.

       A player CAN flip the Delegate switch of a specified office to
       emself with Agoran Consent, or from "None" to emself with support
       from its holder. The holder of an office CAN flip its Delegate
       switch from "None" to a specified player with support from the
       specified player.

[Allow the with-support option to be initiated by either party, and
  simplify language.]

Amend Rule 1006 (Offices) by replacing this text:

       Officeholder is an office switch tracked by the ADoP, with
       possible values of any person or "vacant" (default).

with this text:

       Officeholder is an office switch tracked by the ADoP, with
       possible values of any player or "vacant" (default).

and removing this text:

       If the holder of an office is ever not a player, it becomes
       vacant.

and replacing this text:

       Immediately after a proposal finishes taking effect, if one or
       more offices exist that did not exist prior to the proposal taking
       effect, each such office, if it is vacant, becomes held by the
       author of the proposal.

with this text:

       Immediately after a proposal finishes taking effect, each vacant
       office that did not exist prior to the proposal taking effect
       becomes held by the author of the proposal.

[Outsource removing non-players from office to Rule 2162's "If an
  instance of a switch would otherwise fail to have a possible value".]

Amend Rule 2651 (The Election Cycle) by replacing this text:

       a) With 2 support (if the office is either interim or term-
       limited) or 4 support (otherwise), and provided that the initiator
       becomes a candidate in the same message.

       b) By announcement, if e is the ADoP (or, if the office is the
       ADoP, if e is the Assessor) and the office is interim, or if e is
       the holder of that office.

with this text:

       a) With 2 support (if the office is either interim or term-
       limited) or 4 support (otherwise), provided that the initiator
       becomes a candidate in the same message.

       b) By announcement, if e is the office's Overseer and the office
       is interim, or if e is the holder of that office.

       The Overseer of the ADoP is the Assessor. The Overseer of all
       other offices (including any held by the ADoP) is the ADoP.

[Overseer is similar to Investigator in Rule 2478. Amending Rule 2472
  to generalize this type of relationship between offices is left as an
  exercise.]

Amend Rule 2154 (Election Procedure) by replacing this text:

       After the nomination period ends, the ADoP (or, if the office is
       the ADoP, the Assessor) CAN and, in a timely fashion, SHALL:

       1) If the election is contested, initiate an Agoran decision to
          select the winner of the election (the poll). For this
          decision, the Vote Collector is the ADoP (or, if the office is
          the ADoP, the Assessor),

with this text:

       After the nomination period ends, the Overseer of the office CAN
       and, in a timely fashion, SHALL:

       1) If the election is contested, initiate an Agoran decision to
          select the winner of the election (the poll). For this
          decision, the Vote Collector is the Overseer of the office,

[Use the new definition from Rule 2651.]"""
            )
        }

        proposal(9318) {
            title("Clarify indeterminacy")
            ai("3.0")
            author(Murphy)
            coauthors(Mischief)
            democratic()

            text(
                """
Amend Rule 2162 (Switches) by replacing this text:

       If a type of switch is not explicitly designated as
       possibly-indeterminate by its backing document, and if an action
       or set of actions would cause the value of an instance of that
       type of switch to become indeterminate, that instance instead
       takes on its last determinate and possible value, if any,
       otherwise it takes on its default value.

with this text:

       If an action or set of actions would cause the value of an
       instance of a switch to become indeterminate, and that type of
       switch is not explicitly designated as possibly-indeterminate by
       its backing document, then that instance instead takes on its last
       determinate and possible value (or, if it has no such value, then
       its default value).

[stop burying the lede.]"""
            )
        }

        proposal(9319) {
            title("Some recommendations")
            ai("2.0")
            author(Murphy)
            coauthors(Mischief, Trigon)
            ordinary()

            text(
                """
Amend Rule 991 (Calls for Judgement) by replacing this text:

       The Arbitor SHOULD consider linking

with this text:

       The Arbitor SHOULD link

[SHOULD already implies "consider".]

Amend Rule 2465 (Victory by Apathy) by appending this text:

       A player SHOULD NOT announce intent to Declare Apathy unless e
       expects it to be reasonably likely to succeed.

[I previously proposed making failed intents an infraction, but it would
  require mind-reading, and the Blots would prevent em from benefiting
  from a successful Apathy if applied too early. Maybe skip the
  infraction and just define a way to give Blots directly, like Dive,
  based on consensus that the intent appeared to be a lazy one?]"""
            )
        }

        proposal(9320) {
            title("Scoring rule numbers")
            ai("1.0")
            author(Murphy)
            coauthors(Mischief, Trigon)
            ordinary()

            text(
                """
Amend Rule 2713 (Scoring Numbers) by inserting this text before the
paragraph beginning "Whenever a player scores a number":

       Whenever a rule is created by a proposal and subsequently assigned
       a rule number, or a rule with a rule number is repealed by a
       proposal, the Assessor SHALL randomly select one player who voted
       FOR that proposal to score its rule number, unless 12 or more rule
       numbers were scored earlier in the same week."""
            )
        }

        proposal(9321) {
            title("Scheduled actions")
            ai("2.0")
            author(Murphy)
            coauthors(Mischief)
            ordinary()

            text(
                """
Create a rule titled "Scheduled Actions" with Power 2 and this text:

       A player CAN pay a fee of N spendies (where N is an integer from 1
       to 7, inclusive) to create a Scheduled Action, specifying a time
       between 0 and N days in the future (the Trigger) and a body of
       text (the Payload). However, a Scheduled Action CANNOT be created
       while another Scheduled Action is taking effect.

       At a Scheduled Action's Trigger, it takes effect (its creator
       performs actions as if e had published its Payload at that time),
       then it is destroyed. Scheduled Actions take effect after any
       actions performed at the same time by other means; multiple
       Scheduled Actions with the same Trigger take effect in order of
       creation.

       Destroying or altering a Scheduled Action is secured.

[Change from proto: Blocked recursive Scheduled Actions. Whether this
  could cause any additional shenanigans when combined with Promises
  and/or act-on-behalf is left as an exercise.]"""
            )
        }
    }

    voting {
        votes(Cosmo) {
            PRESENT on 9310
            FOR on 9311
            PRESENT on 9312
            FOR on 9313
            FOR on 9314
            FOR on 9315
            FOR on 9316
            FOR on 9317
            FOR on 9318
            FOR on 9319
            PRESENT on 9320
            FOR on 9321
        }

        votes(Janet) {
            AGAINST on 9310
            PRESENT on 9311
            FOR on 9312
            FOR on 9313
            AGAINST on 9314
            PRESENT on 9315
            FOR on 9316
            PRESENT on 9317
            PRESENT on 9318
            PRESENT on 9319
            AGAINST on 9320
            AGAINST on 9321
        }

        votes(Trigon) {
            AGAINST on 9310
            FOR on 9311
            FOR on 9312
            FOR on 9313
            FOR on 9314
            endorse(Mischief) on 9315
            FOR on 9316
            FOR on 9317
            PRESENT on 9318
            AGAINST on 9319
            AGAINST on 9320
            AGAINST on 9321
        }

        votes(Nilrem) {
            AGAINST on 9310
            FOR on 9311
            FOR on 9312
            FOR on 9313
            FOR on 9314
            FOR on 9315
            FOR on 9316
            endorseOfficer("ADoP", Murphy) on 9317
            FOR on 9318
            PRESENT on 9319
            AGAINST on 9320
            FOR on 9321
        }

        votes(Murphy) {
            FOR on 9310
            FOR on 9311
            FOR on 9312
            FOR on 9313
            FOR on 9314
            FOR on 9315
            FOR on 9316
            FOR on 9317
            FOR on 9318
            FOR on 9319
            FOR on 9320
            FOR on 9321
        }

        votes(Mischief) {
            FOR on 9310
            FOR on 9311
            FOR on 9312
            FOR on 9313
            FOR on 9314
            FOR on 9315
            FOR on 9316
            FOR on 9317
            FOR on 9318
            FOR on 9319
            endorseOfficer("Assessor", Janet) on 9320
            FOR on 9321
        }
    }
}
