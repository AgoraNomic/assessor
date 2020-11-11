package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune30.*
import org.agoranomic.assessor.dsl.ministries.endorseOfficer
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV1.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8478to8487() = assessment {
    name("8478-8487")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-August/014097.html")
    quorum(6)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Coopor to RLee,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nix,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to Jason,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Gaelan, 4 / 3)
        blotPenalty(RLee, 80 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_08_02(offices, allProposals)
    }

    proposals(v2) {
        proposal(8478) {
            title("another talismans fix")
            ai("3.0")
            author(Jason)
            coauthors(nix, G)
            democratic()
            sponsored()

            text(
                """
Amend Rule 2574 by replacing the list item beginning "If a player
possesses more than one" with the following:

{
  - If a player possesses more than one talisman for persons other than
  emself, specify and transfer one of those talismans to Agora;

}"""
            )
        }

        proposal(8479) {
            title("Competitive Finger Pointing v2")
            ai("1.7")
            author(nix)
            coauthors(Aris, PSS, ATMunn)
            chamber(Justice)
            sponsored()

            text(
                """
Amend R2478, "Vigilante Justice" by adding to the beginning of the
list:

  - Issuing a Warning to the perp, as described elsewhere;

and by adding after the list items:

  Initiating a Finger Pointing found to be Shenanigans is ILLEGAL
  and the Class 0+N Crime of Unjustified Gesticulation, where N is
  the number of times e has previously committed the crime in the
  current Agoran Week.

and by adding, to the very end of the rule:

  The player who initiated the most Finger Pointings that resulted
  in a Warning, Indictment, or Cold Hand of Justice in the previous
  Agoran Week CAN once grant emself a Justice Card by announcement.

Amend R2557 "Sentencing Guidelines" by adding to the end:

  When the rules authorize an investigator to issue a Warning for a
  violation, e CAN do so by announcement if the violation is
  described by the rules as a "Class N Crime" where N is 0 or an
  expression that evaluates to 0.

[There is no ruleset support for class 0 crimes right now. So this
version adds support by introducing a new thing the investigator can do
called a Warning.]"""
            )
        }

        proposal(8480) {
            title("Generic welcome package fix")
            ai("1.0")
            author(Jason)
            chamber(Economy)
            sponsored()

            text(
                """
Amend Rule 2499 by deleting the sentence beginning "A player CANNOT" and
by replacing the final paragraph with the following:

{

  When a player receives a Welcome Package, if e has not received one in
  the past 30 days, then e earns 10 coins and one of each type of Card
  defined in the rules.

}


[This makes protects against all possible infinite welcome package scams
that involve one person receiving infinite welcome packages. With this
change, a person can get infinite welcome packages, but only the first
one in each 30 day period will actually grant any rewards (which likely
makes most scams not worth the hassle).]"""
            )
        }

        proposal(8481) {
            title("If it's not pending we don't care v2")
            ai("3.0")
            author(Trigon)
            coauthors(Aris)
            democratic()
            sponsored()

            text(
                """
Amend Rule 1607 "Distribution" by deleting the paragraph:

  The Promotor's report includes a list of all proposals in the
  Proposal Pool, along with their text and attributes. This portion
  of a public document purporting to be a Promotor's report is
  self-ratifying.

then by replacing:

  If a proposal has been in the proposal pool for more than 7 days
  and is not pending, the Promotor CAN and SHOULD remove it from the
  Pool by announcement.

with:

  The Promotor CAN Drain the Pool by announcement. When e does so,
  each proposal in the Proposal Pool that was there for the entirety
  of the previous Agoran month is destroyed. E SHOULD do so once
  each month.

Amend Rule 2496 "Rewards" by adding a bullet point to the list, before
the one beginning "Publishing an office's weekly or monthly report" that
reads:

  * Initiating a referendum, provided that no other referendum had
    been initiated earlier in that Agoran week: 5 coins (ADoP)"""
            )
        }

        proposal(8482) {
            title("Offices are complex v2")
            ai("1.0")
            author(Trigon)
            coauthors(ATMunn)
            chamber(Efficiency)
            sponsored()

            text(
                """
Enact a new power-1 rule entitled "Complexity" with the text:

  Complexity is an office switch reflecting how complex it is to
  fulfill the duties of its office. Its possible values are all
  integers from 0 to 3 inclusive, where 1 is the default. It is
  tracked in the ADoP's weekly report. The ADoP CAN, with 2 Agoran
  consent, flip the complexity of an office.

Set the complexity switch of the following offices as such:

ADoP:           1
Arbitor:        2 [comment: if we split CotC this should go down]
Assessor:       3
Coopor:         1
Distributor:    0
Herald:         2
Notary:         2
Prime Minister: 0
Promotor:       3
Referee:        2
Registrar:      1
Rulekeepor:     3
Speaker:        0
Tailor:         1
Treasuror:      3
Webmastor:      1

Amend Rule 2496 "Rewards" by replacing the text "5 coins" in the
following bullet points as such:

  - the bullet point beginning "Publishing an office's weekly or monthly
    report": 5 coins times the complexity of the office
  - the bullet point beginning "Resolving a referendum": 5 coins times
    the Assessor's complexity.
  - the bullet point beginning "Initiating a referendum", if it exists: 5
    coins times the Promotor's complexity."""
            )
        }

        proposal(8483) {
            title("a minor adjustment")
            ai("1.0")
            author(G)
            chamber(Legislation)
            sponsored()

            text(
                """
If G., acting as emself, has published a single body of text clearly
labeled as "THE MYSTERY DOCUMENT" after the voting period on the
referendum for this proposal has began, this proposal applies all effects
specified in that body of text."""
            )
        }

        proposal(8484) {
            title("Clarify asset ownership")
            ai("3.0")
            author(Murphy)
            coauthors(CuddleBeam, Aris)
            democratic()
            sponsored()

            text(
                """
Amend Rule 2576 (Ownership) to read:

  Each asset has exactly one owner.

  If ownership of an asset is restricted to a class of entities,
  then that asset CANNOT be gained by or transferred to an entity
  outside that class. By default, ownership of an asset is
  restricted to Agora, players, and contracts, but an asset's
  backing document may modify this.

  If an asset's owner would otherwise be nonexistent, indeterminate,
  or invalid, then it is owned by the Lost and Found Department (if
  possible) or destroyed (otherwise), subject to modification by its
  backing document. Rules to the contrary notwithstanding, the Lost
  and Found Department can own assets of every type. Assets owned by
  the Lost and Found Department can be transferred or destroyed by
  any player without objection."""
            )
        }

        proposal(8485) {
            title("Eternal Personhood")
            ai("3.0")
            author(Gaelan)
            coauthors(Aris)
            democratic()
            sponsored()

            text(
                """
In rule 869 "How to Join and Leave Agora", replace
  {Any organism that is generally capable of freely originating and
  communicating independent thoughts and ideas is a person.}
with
  {Any entity that is or ever was an organism generally capable of freely
  originating and communicating independent thoughts and ideas is a person.}"""
            )
        }

        proposal(8486) {
            title("Fee-based de-escalation")
            ai("3.0")
            author(Jason)
            coauthors(omd)
            democratic()

            text(
                """
Amend Rule 2579 by replacing the final paragraph with the following: {

  If a Rule purports to provide a fee-based method to perform an action
  with a fee of no assets, that Rule enables the performance of the action
  by announcement. When using such a method, the actor SHOULD announce
  that there was a 0 or empty fee.
}"""
            )
        }

        proposal(8487) {
            title("Simpler ribbon switches")
            ai("3.0")
            author(Murphy)
            coauthors(RLee)
            democratic()
            sponsored()

            text(
                """
Amend Rule 2438 (Ribbons) by replacing this text:

  Ribbon Ownership is a secured person switch, tracked by the
  Tailor in eir monthly report, whose values are the subsets of
  the set of types of Ribbon, defaulting to the empty set. If the
  rules are amended to change the types of Ribbon, if a player's
  Ribbon Ownership is subsequently illegal, then it is updated by
  removing all nonexistent types rather than resetting the entire
  value to default.

  To "award a person a <Ribbon type>" is to add that type of Ribbon
  to that person's Ribbon Ownership. A person "owns a <Ribbon type>"
  if that type of Ribbon is an element of eir Ribbon Ownership.

with this text:

  For each type of Ribbon, <type> Ribbon Ownership is a secured
  negative boolean person switch, tracked by the Tailor in eir
  monthly report.

  To "award a person a <Ribbon type>" is to flip that person's
  <that type> Ribbon Ownership to True. A person "owns a <Ribbon
  type>" if eir <that type> Ribbon Ownership is True.

and by replacing this text:

  While a person owns all types of Ribbon, that person can Raise a
  Banner by announcement. This causes that person to win the game.
  That person's Ribbon Ownership becomes the empty set.

with this text:

  While a person owns all types of Ribbon, that person can Raise a
  Banner by announcement. This causes that person to win the game.
  When a person wins this way, for each type of Ribbon, that
  person's <type> Ribbon Ownership is flipped to False.

For each type of Ribbon, for each person whose Ribbon Ownership prior to
the adoption of this proposal included that type, flip eir <that type>
Ribbon Ownership to True."""
            )
        }
    }

    voting {
        votes(RLee) {
            FOR on 8483
            PRESENT on others
        }

        votes(Aris) {
            FOR on 8478
            FOR on 8479
            FOR on 8480
            AGAINST on 8481
            FOR on 8482
            FOR on 8483
            FOR on 8484
            FOR on 8485
            FOR on 8486
            FOR on 8487
        }

        votes(PSS) {
            FOR on 8478
            FOR on 8479
            FOR on 8480
            FOR on 8481
            FOR on 8482
            FOR on 8483
            FOR on 8484
            FOR on 8485
            FOR on 8486
            FOR on 8487
        }

        votes(Jason) {
            FOR on 8478
            PRESENT on 8479
            FOR on 8480
            endorseOfficer(offices, Promotor) on 8481
            FOR on 8482
            FOR on 8483
            PRESENT on 8484
            FOR on 8485
            FOR on 8486
            endorseOfficer(offices, Tailor) on 8487
        }

        votes(Gaelan) {
            FOR on 8478
            FOR on 8479
            FOR on 8480
            AGAINST on 8481
            FOR on 8482
            FOR on 8483 comment conditional("P8483 would be ADOPTED under the specified criteria, with at most omd voting AGAINST")
            AGAINST on 8484
            FOR on 8485
            FOR on 8486
            FOR on 8487
        }

        votes(CuddleBeam) {
            FOR on all
        }

        votes(Falsifian) {
            FOR on 8478
            FOR on 8479
            FOR on 8480
            endorse(Aris) on 8481
            FOR on 8482
            FOR on 8483 comment conditional("P8483 would be ADOPTED even if all parties to the Foot Draggers Union voted AGAINST")
            FOR on 8484
            FOR on 8485
            FOR on 8486
            FOR on 8487
        }

        votes(Trigon) {
            FOR on 8478
            PRESENT on 8479
            FOR on 8480
            endorseOfficer(offices, Promotor) on 8481
            FOR on 8482
            FOR on 8483
            PRESENT on 8484
            FOR on 8485
            FOR on 8486
            PRESENT on 8487
        }

        votes(omd) {
            FOR on 8483 comment conditional("Gaelan did not cast a ballot matching the specified criteria")
        }

        votes(G) {
            FOR on 8483
        }

        votes(twg) {
            FOR on 8483
        }

        votes(Murphy) {
            FOR on 8478
            FOR on 8479
            FOR on 8480
            FOR on 8481
            FOR on 8482
            FOR on 8483
            FOR on 8484
            FOR on 8485
            AGAINST on 8486
            FOR on 8487
        }

        votes(nix) {
            FOR on all
        }
    }
}
