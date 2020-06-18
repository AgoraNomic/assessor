package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.ministries.ministriesFeb13
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.*
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.Ministry.*
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8322 to 8341`() = assessment {
    name("8322-8341")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-February/013472.html")
    quorum(6)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Comptrollor to Murphy,
        Distributor to omd,
        Herald to Alexis,
        Notary to null,
        PrimeMinister to twg,
        Promotor to Aris,
        Referee to twg,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to Jason,
        Treasuror to twg,
        Tailor to twg
    )

    strengths {
        default(3)
        min(0)
        max(15)

        addToHolder(offices, Speaker, 1)
        ministriesFeb13(offices, allProposals)
    }

    proposals(v1) {
        proposal(8322) {
            title("Unrepetition v1.1")
            ai("3.0")
            author(Falsifian)
            coauthors(Alexis, twg)
            democratic()

            text(
                """
For each of Proposals 8287-8307, if the proposal took effect more than
once, then any changes to rule text caused by the second and later
times the proposal took effect are considered "extra" for the purposes
of this proposal.

Reverse all such "extra" changes, in the reverse of the order in which
they occurred.

[Comment: See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-discussion/2020-February/056587.html
for context. I think the changes this undoes are relatively benign,
but it's nice to have certainty about the state of the ruleset.]"""
            )
        }

        proposal(8323) {
            title("Secure Ribbons")
            ai("3.0")
            author(Jason)
            democratic()

            text(
                """
Amend Rule 2438 (Ribbons) by replacing the text "Ribbon Ownership is a
person switch" with the text "Ribbon Ownership is a secured person switch"."""
            )
        }

        proposal(8324) {
            title("Democratic unassignment")
            ai("2.0")
            author(Falsifian)
            chamber(Legislation)

            text(
                """
If Proposal 8320 (Promotorial Assignment) has been adopted, then amend
the rule entitled "Proposal Chambers" by replacing "If a proposal in
the Proposal Pool has its chamber unset" with "If the chamber of an
ordinary proposal in the Proposal Pool is unset"."""
            )
        }

        proposal(8325) {
            title("Inflation Vote")
            ai("2.0")
            author(Falsifian)
            chamber(Economy)

            text(
                """
[Comments:

Are we just going to let a steady stream of sufficiently dedicated
players claim their standard victories? I say we raise the bar a
little.

There's been some talk of a larger re-working of the economy. In the
meantime, this proposal calls for players to vote on a new number to
replace the 1,000 coin victory fee. The median vote wins, favouring the
higher vote if there are two middle votes.

]

For the purpose of this proposal:

* An Inflation Ballot is a body of text published during the voting
  period of this proposal that clearly, directly and without
  obfuscation specifies a single non-negative integer and that it is an
  Inflation Ballot.

* Each player's Inflation Vote is the integer specified in the last
  Inflation Ballot they published, or "none" if they never published
  one.

* P is the number of players with Inflation Votes other than "none".

* Median is the (unique) integer such that that at least P/2 Inflation
  Votes are integers greater than or equal to Median, and at least
  (P/2+0.5) Inflation votes are integers less than or equal to Median.

Amend Rule 2483 (Economics) by replacing "1,000" with Median, written
in decimal with commas separating groups of three digits, as in
"12,345,678"."""
            )
        }

        proposal(8326) {
            title("Attempted cleanup")
            ai("3.0")
            author(Falsifian)
            democratic()

            text(
                """
Repeal Rule 2604 ("Nothing to see here, Rule 1030,") and Rule 2600 ("Boo!!")."""
            )
        }

        proposal(8327) {
            title("Blink test v1.2")
            ai("1.0")
            author(Falsifian)
            chamber(Legislation)

            text(
                """
Amend Rule 2601 to read in full:

  If this is the only paragraph in this rule, and it has been at
  least one week since this rule was last amended, then any player
  CAN Close the Eye by announcement. When that happens, this rule
  repeals itself."""
            )
        }

        proposal(8328) {
            title("The Eternal Sprit")
            ai("3.0")
            author(Falsifian)
            democratic()

            text(
                """
Amend Rule 869 by replacing the text "is a person" with "is forever a
person"."""
            )
        }

        proposal(8329) {
            title("RtRW Reschedule")
            ai("1.0")
            author(Alexis)
            chamber(Participation)

            text(
                """
Amend Rule 2327 (Read the Ruleset Week) by adding the following paragraph:
{
  The above notwithstanding, due to serious uncertainty surrounding the
  state of the rules during the scheduled Read the Ruleset Week, in the
  year 2020, Read the Ruleset Week is, instead, the week of February 24
  - March 1
}"""
            )
        }

        proposal(8330) {
            title("No looting white ribbons")
            ai("3.0")
            author(G)
            democratic()

            text(
                """
Amend Rule 2438 (Ribbons) by replacing:
  A player who has been registered for at least 30 days
  and has never caused another person to gain a White Ribbon
  (including under a previous ruleset) CAN award a White Ribbon to
  another person by announcement.
with:
  A player who has been registered for at least 30 days
  and has never acted on eir own behalf to cause another person to
  gain a White Ribbon (including under a previous ruleset) CAN act
  on eir own behalf to award a White Ribbon to another person by
  announcement."""
            )
        }

        proposal(8331) {
            title("Promissory cleanliness")
            ai("1.7")
            author(Warrigal)
            chamber(Justice)

            text(
                """
Append the following paragraph to Rule 2450 "Pledges":

The Notary CAN destroy a pledge Without Objection, and SHOULD do so if and
only if the pledge no longer serves any significant purpose."""
            )
        }

        proposal(8332) {
            title("Switch Responsibility Responsibility")
            ai("1.0")
            author(Murphy)
            coauthors(Alexis)
            chamber(Efficiency)

            text(
                """
Amend Rule 2603 (Switch Responsibility) by appending this text:

  The ADoP CAN appoint a player to such an office by announcement,
  and SHOULD appoint the player primarily responsible for its
  existence."""
            )
        }

        proposal(8333) {
            title("Meaningful extra votes")
            ai("2.0")
            author(Murphy)
            coauthors(Alexis)
            chamber(Legislation)

            text(
                """
Amend Rule 2423 (First Among Equals) by replacing "voting strength is
increased by 1" to "voting strength is doubled".

[I think this is a no-op due to Interesting Chambers, though.]

Amend Rule 103 (The Speaker) by replacing "voting strength one greater
than e would have" with "voting strength twice what e would have"."""
            )
        }

        proposal(8334) {
            title("Meaningless extra coins")
            ai("2.0")
            author(Murphy)
            coauthors(Alexis)
            chamber(Economy)

            text(
                """
Amend Rule 2483 (Economics) by appending this text:

  Upon doing so, eir remaining Coins (if any) are destroyed."""
            )
        }

        proposal(8335) {
            title("Consistent ADoP duties")
            ai("2.0")
            author(Murphy)
            chamber(Efficiency)

            text(
                """
Amend Rule 2154 (Election Procedure) by appending to this text:

  If at any point an uncontested election has a single candidate,
  then any player CAN by announcement declare em the winner of the
  election, thereby causing em to win the election. If at any point
  an uncontested election has no candidates, then any player CAN
  declare the election ended with no winner by announcement.

this text:

  In each of these cases, the ADoP SHALL so announce in a timely
  fashion, unless someone else has already done so.

[I think the recent resolutions of Treasuror and Tailor, while still
effective resolutions, didn't count as temporary deputisation because
the ADoP wasn't required to do them.]"""
            )
        }

        proposal(8336) {
            title("Define \"publicly\"")
            ai("3.0")
            author(Jason)
            democratic()

            text(
                """
Amend Rule 478 by appending to the paragraph beginning "A public message
is" the following sentence:

  To do something "publicly" is to do that thing within a public message."""
            )
        }

        proposal(8337) {
            title("Fix Auctions")
            ai("1.0")
            author(Murphy)
            chamber(Economy)

            text(
                """
Amend Rule 2549 (Auction Initiation) by replacing this text:

  An Auction also CANNOT be initiated unless the Auctioneer is able
  to give away each item in each of the Auction's lots.

with this text:

  An Auction also CANNOT be initiated unless the Auctioneer is able
  to give away each item in each of the Auction's lots; however, if
  the Auctioneer is Agora, then it CAN give them away at will."""
            )
        }

        proposal(8338) {
            title("Clarify quorum (option 1)")
            ai("2.0")
            author(Murphy)
            chamber(Legislation)

            text(
                """
If the author's proposal "Clarify quorum (option 2)" has been or
would be adopted with a greater proportion of support, then this
proposal has no effect. Otherwise:

Amend Rule 879 (Quorum) by replacing "Agoran decision to adopt a
proposal" with "Agoran decision on whether to adopt a proposal"."""
            )
        }

        proposal(8339) {
            title("Clarify quorum (option 2)")
            ai("2.0")
            author(Murphy)
            chamber(Legislation)

            text(
                """
If the author's proposal "Clarify quorum (option 1)" has been or
would be adopted with a greater or equal proportion of support, then
this proposal has no effect. Otherwise:

Amend Rule 879 (Quorum) by replacing "Agoran decision to adopt a
proposal" with "Agoran decision that adopted a proposal"."""
            )
        }

        proposal(8340) {
            title("The Paradox of Self-Appointment")
            ai("1.0")
            author(Alexis)
            chamber(Participation)

            text(
                """
Amend Rule 103 (The Speaker) by inserting
{
  If the Prime Minister is emself Laureled, eir power to appoint a
  Speaker continues for the entirety of a message in which e resigns as
  Prime Minister, and if e is the only Laureled player, e CAN void that
  power, and thereby discharge the obligation to use it, by announcing
  that e declines to take the office.
}

at the end of the second paragraph, and by moving the first two
sentences of the second paragraph to the first paragraph."""
            )
        }

        proposal(8341) {
            title("Support of the Person")
            ai("3.0")
            author(Alexis)
            coauthors(G)
            democratic()

            text(
                """
Amend Rule 2124 (Agoran Satisfaction) by:

  1. Replacing "However, the previous sentence notwithstanding, the initiator
     of the intent is not eligible to support it." with "Announcing intent to
     perform an action implicitly announces support for that action; such
     support may be withdrawn as per usual."
  2. Replacing "The action is to be performed With N support, and there are
     fewer than than N Supporters of that intent." with "The action is to be
     performed With N support, and there equal to or fewer than than N
     Supporters of that intent."
  3. Replacing "The action is to be performed with N Agoran consent, and
     the number of Supporters of the intent is less than or equal to N times the
     number of Objectors to the intent." with "The action is to be performed
     with N Agoran consent, and the number of Supporters of the intent is less
     than or equal to O or less than N * O, where O is the number of Objectors
     to the intent.""""
            )
        }
    }

    voting {
        votes(Aris) {
            FOR on 8322
            FOR on 8323
            FOR on 8324
            FOR on 8325
            FOR on 8326
            FOR on 8327
            FOR on 8328
            AGAINST on 8329
            FOR on 8330
            FOR on 8331
            AGAINST on 8332
            AGAINST on 8333
            AGAINST on 8334
            AGAINST on 8335
            FOR on 8336
            FOR on 8337
            FOR on 8338
            AGAINST on 8339
            FOR on 8340
            AGAINST on 8341
        }

        votes(Murphy) {
            FOR on 8322
            FOR on 8323
            FOR on 8324
            FOR on 8325
            FOR on 8326
            FOR on 8327
            FOR on 8328
            PRESENT on 8329
            FOR on 8330
            FOR on 8331
            PRESENT on 8332
            FOR on 8333
            FOR on 8334
            PRESENT on 8335
            FOR on 8336
            FOR on 8337
            FOR on 8338
            PRESENT on 8339
            FOR on 8340
            PRESENT on 8341
        }

        votes(Alexis) {
            PRESENT on 8322
            FOR on 8323
            PRESENT on 8324
            AGAINST on 8325
            FOR on 8326
            FOR on 8327
            AGAINST on 8328
            FOR on 8329
            FOR on 8330
            FOR on 8331
            FOR on 8332
            FOR on 8333
            FOR on 8334
            AGAINST on 8335
            FOR on 8336
            AGAINST on 8337
            FOR on 8338
            AGAINST on 8339
            FOR on 8340
            FOR on 8341
        }

        votes(sukil) {
            PRESENT on 8322
            PRESENT on 8323
            PRESENT on 8324
            PRESENT on 8325
            FOR on 8326
            AGAINST on 8327
            AGAINST on 8328
            FOR on 8329
            PRESENT on 8330
            PRESENT on 8331
            FOR on 8332
            PRESENT on 8333
            FOR on 8334
            FOR on 8335
            FOR on 8336
            PRESENT on 8337
            AGAINST on 8338
            AGAINST on 8339
            PRESENT on 8340
            AGAINST on 8341
        }

        votes(twg) {
            endorse(Falsifian) on 8322
            PRESENT on 8323 comment conditional("Jason did not vote AGAINST")
            endorse(Falsifian) on 8324
            PRESENT on 8325 comment conditional("Falsifian did not vote AGAINST")
            endorse(Falsifian) on 8326
            endorse(Falsifian) on 8327
            endorse(Falsifian) on 8328
            endorse(Alexis) on 8329
            endorse(G) on 8330
            PRESENT on 8331 comment conditional("Warrigal did not vote AGAINST")
            AGAINST on 8332
            AGAINST on 8333
            AGAINST on 8334
            AGAINST on 8335
            endorse(Jason) on 8336
            AGAINST on 8337
            endorse(Murphy) on 8338
            PRESENT on 8339 comment conditional("Murphy did not vote AGAINST")
            endorse(Alexis) on 8340
            AGAINST on 8341
        }

        votes(Bernie) {
            endorse(twg) on all
        }

        votes(Warrigal) {
            PRESENT on 8322
            PRESENT on 8323
            FOR on 8324
            PRESENT on 8325
            FOR on 8326
            FOR on 8327
            FOR on 8328
            AGAINST on 8329
            FOR on 8330
            FOR on 8331
            FOR on 8332
            FOR on 8333
            FOR on 8334
            FOR on 8335
            FOR on 8336
            FOR on 8337
            FOR on 8338
            AGAINST on 8339 comment "Proposal 8338 has sufficient votes to be adopted"
            FOR on 8340
            PRESENT on 8341
        }

        votes(Jason) {
            FOR on 8322
            FOR on 8323
            FOR on 8324
            AGAINST on 8325
            FOR on 8326
            PRESENT on 8327
            PRESENT on 8328
            FOR on 8329
            FOR on 8330
            FOR on 8331
            AGAINST on 8332
            AGAINST on 8333
            AGAINST on 8334
            AGAINST on 8335
            FOR on 8336
            PRESENT on 8337
            FOR on 8338
            AGAINST on 8339
            PRESENT on 8340
            PRESENT on 8341
        }

        votes(Rance) {
            endorse(Jason) on all
        }

        votes(Falsifian) {
            FOR on 8322
            endorse(Jason) on 8323
            FOR on 8324
            FOR on 8325
            FOR on 8326
            FOR on 8327 comment NO_VETO
            FOR on 8328
            PRESENT on 8329 comment NO_VETO
            FOR on 8330
            FOR on 8331
            PRESENT on 8332 comment NO_VETO
            endorse(twg) on 8333 comment NO_VETO
            AGAINST on 8334
            PRESENT on 8335
            endorse(Jason) on 8336
            AGAINST on 8337
            FOR on 8338
            AGAINST on 8339
            endorse(Alexis) on 8340 comment NO_VETO
            endorse(Alexis) on 8341
        }

        votes(G) {
            FOR on 8323
            AGAINST on 8325
            AGAINST on 8326
            AGAINST on 8327
            AGAINST on 8328
            AGAINST on 8329
            AGAINST on 8334
            AGAINST on 8340
        }

        o matches G

        votes(CuddleBeam) {
            for (proposal in listOf(8323, 8325, 8326, 8327, 8328, 8329, 8334, 8340)) {
                FOR on proposal
            }
        }
    }
}
