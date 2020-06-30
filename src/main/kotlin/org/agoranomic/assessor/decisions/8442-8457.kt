package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune3.*
import org.agoranomic.assessor.dsl.ministries.endorseOfficer
import org.agoranomic.assessor.dsl.ministries.ministriesJun15
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.Ministry.*
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8442 to 8457`() = assessment {
    name("8442-8457")
    quorum(8)

    val offices = officeMapOf(
        ADoP to null,
        Arbitor to G,
        Assessor to Jason,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nch,
        Promotor to Aris,
        Referee to PSS,
        Rulekeepor to Jason,
        Registrar to Falsifian,
        Speaker to G,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nch
    )

    strengths {
        default(3)
        min(0)
        max(15)

        ministriesJun15(offices, allProposals)
        addToHolder(offices, Speaker, 1)
    }

    proposals(v1) {
        proposal(8442) {
            title("Barrel Barrel Badger Barrel")
            ai("1.0")
            author(G)
            chamber(Economy)

            text(
                """
Create a power-1 rule, "The General Store", with the following text:

  Barrels are a currency tracked by the Coopor (an office) in eir
  monthly report. A player CAN Corner the Market by paying a fee of
  100 barrels.  When a player corners the market, e wins the game.

  A bargain is a specification consisting of a title, a payout (a
  number of barrels between 1 and 10), and a tender (a list of 6 or
  more rules-defined card types; a type may be repeated, with each
  repeat being a separate element on the list).

  A player CAN cash out a specified bargain that's "on the barrel",
  by announcement, provided that, in the same message, e paid cards
  (possibly spread over multiple sets) to successfully earn rules-
  defined products, and those cards match all of the cards types in
  that bargain's tender.  The payment of a particular card instance
  can only match a single tender element for the single cashing out
  of a bargain.

  When a player cashes out a bargain on the barrel, e earns the
  payout for that bargain.

  The Coopor CANNOT cash out a specific bargain in the 14 days
  after putting that bargain on the barrel.


Create a power-1 rule, "Bargains on the Barrel", with the
following text:

  If there are fewer than four bargains on the barrel, the Coopor
  CAN put a bargain on the barrel with notice.  If there are fewer
  than eight bargains on the barrel, the Coopor CAN put a bargain on
  the barrel with 3 support.

  The Coopor CAN take a bargain off the barrel without N objections,
  where N is the number of months, rounded up, since that bargain
  was last placed on the barrel.  Within 14 days after winning an
  election for Coopor, the Coopor CAN take any bargain off the
  barrel with notice.

  The Coopor's monthly report includes a list of all bargains on the
  barrel.  E SHOULD publish such a list whenever e adds or removes a
  bargain from the barrel.


There are no bargains on the barrel.

G. is hereby made Coopor.

An election for Coopor is hereby initiated."""
            )
        }

        proposal(8443) {
            title("Term Limit")
            ai("2.0")
            author(G)
            chamber(Efficiency)

            text(
                """
Amend Rule 2423 (First Among Equals) by appending the following
paragraph:

Rules to the contrary notwithstanding, a player CANNOT become a
candidate in an election for Prime Minister if e has held the office
for 60 or more of the 90 days prior to the election's initiation."""
            )
        }

        proposal(8444) {
            title("Sedate Officiation")
            ai("2.0")
            author(Aris)
            chamber(Efficiency)

            text(
                """
[In case the public wants a change but prefers more conventional
vocabulary.]

Amend each of Rule 1023 ("Agoran Time"), Rule 2496 ("Rewards"), and
Rule 2602 ("Glitter"), in that order, by changing each instance of the text
"in an officially timely fashion" or "in a stately fashion"
to read "in a sedate fashion"."""
            )
        }

        proposal(8445) {
            title("Easier Retitling")
            ai("3.0")
            author(Aris)
            democratic()

            text(
                """
[It's been bothering me for years that it takes a full proposal to fix
an incorrect title. This would simplify that in obvious cases, and is
pretty safe given that titles are non-substantive (while this
could interfere with a proposal, cleanings can already do
that.)]

Amend Rule 2221, "Cleanliness", by adding as a new paragraph:

  Any player CAN refile a rule without objection, specifying a new
  title; the rule is retitled to the specified title by this rule.

Retitle Rule 2221 to "Cleanliness and Tidy Filing""""
            )
        }

        proposal(8446) {
            title("Victory Auctions")
            ai("1.0")
            author(G)
            coauthors(nch)
            chamber(Economy)

            text(
                """
If Proposal 8407 (no stinking auction definitions) has not taken
effect, the rest of this proposal has no effect.


Enact the following rule, Victory Auctions:

  The Treasuror CAN conduct an auction (a "victory auction") if no
  victory auction is ongoing.  The Treasuror MUST do so at least
  once a month, and SHOULD do so at least twice each month.

  A victory auction includes the following lots:

  * one new Victory Card.

  * all of any single type of card or product, currently owned by
    the Lost and Found Department, if any.

  The currency of a victory auction is coins (minimum bid 1)."""
            )
        }

        proposal(8447) {
            title("Rule Infancy")
            ai("1.0")
            author(CuddleBeam)
            chamber(Participation)

            text(
                """
Enact the following rule "Rule Infancy":
  An Infant Rule is a Rule that has been added to the Ruleset within the
  last 90 days. Persons CANNOT perform a scam that relies on an Infant Rule."""
            )
        }

        proposal(8448) {
            title("Populist Administration")
            ai("3.0")
            author(Aris)
            coauthors(Alexis, Falsifian)
            democratic()

            text(
                """
If a proposal titled "The Administrative State" has been adopted in the last
month, the remainder of this proposal has no effect.

Enact a new power 2.0 rule entitled "The Administrative State", with the
following text:

  Each officer CAN, with 1.5 Agoran consent, enact, amend, or repeal
  eir own office's Administrative Regulations. Administrative Regulations
  have the following properties:

  1. An officer SHALL abide by eir office's administrative regulations in
     the discharge of eir office.
  2. Any player CAN act on behalf of an officer to exercise eir official
     powers as authorized by eir office's administrative regulations.
  3. All players SHOULD abide by an officer's administrative regulations
     in matters relating to eir area of responsibility."""
            )
        }

        proposal(8449) {
            title("Simpler Heraldry")
            ai("1.5")
            author(Aris)
            coauthors(Alexis, Jason, PSS)
            chamber(Participation)

            text(
                """
Amend Rule 649, "Patent Titles", by appending to the last paragraph:

  Any player CAN award a specified Patent Title to a specified player,
  as authorized by the Herald's Administrative Regulations."""
            )
        }

        proposal(8450) {
            title("CFJ extensions")
            ai("1.7")
            author(G)
            chamber(Justice)

            text(
                """
Amend Rule 591 (Delivering Judgements) by appending the following
paragraph:

  If the judge of an open CFJ has not violated a time limit for
  assigning it a judgement, and has not previously filed a motion
  to either extend or reconsider the case, e CAN file a motion to
  extend the case by announcement. Doing so extends eir judgement
  deadline for that case by one week. In doing so, e SHOULD include
  a (nonbinding) draft or outline of eir current thoughts on the
  case.

[Self-filed motions to reconsider have been used a handful of times for
the above.  Might as well make it official, removes the Arbitor's
guesswork on when to reassign a late case.  Policy statement: the flip
side is that, as Arbitor I'd be more strict on reassignment deadlines
for people who are late without requesting the extension]."""
            )
        }

        proposal(8451) {
            title("HUMBLE AGORAN FARMER WINS THE GAME")
            ai("1.0")
            author(CuddleBeam)
            chamber(Participation)

            text(
                """
Upon enactment of this Proposal, Cuddlebeam wins the game, and “Humble
Agoran Moral Tripwire” is destroyed."""
            )
        }

        proposal(8452) {
            title("Indictment Fixes")
            ai("1.0")
            author(PSS)
            coauthors(Jason, Trigon)
            chamber(Justice)

            text(
                """
Amend Rule 2619, "Indictment" by inserting "CAN and" prior to "SHALL initiate".

Amend Rule 2619, "Indictment" by inserting ", by announcement,"
following "the investigator CAN".

Amend Rule 2619, "Indictment" by appending the following sentence as a
new paragraph: "If it would be ILLEGAL or INEFFECTIVE for the
Investigator to levy a fine for the stated crime, all decisions
associated with the Indictment cease to exist, and the Judge and
Investigator are freed of any obligations of this rule.""""
            )
        }

        proposal(8453) {
            title("win indirection")
            ai("1.0")
            author(G)
            chamber(Participation)

            text(
                """
Amend Rule 2553 (Win by Paradox) by replacing:

  that case's initiator CAN, by announcement, win the game.

with:

  that case's initiator, CAN, by announcement, Transcend Logic.  When
  a person transcends logic, e wins the game.


[This should make all wins in the rules indirect:  Ribbons,
Tournaments, and Apathy are indirect already]"""
            )
        }

        proposal(8454) {
            title("Judicial non-person fixes")
            ai("2.0")
            author(G)
            coauthors(Jason, PSS)
            chamber(Justice)

            text(
                """
Amend Rule 991 (Calls for Judgement) by replacing:
  When a CFJ's judge is unassigned, the Arbitor CAN assign any
  eligible player to be its judge by announcement, and SHALL do so
  in a timely fashion.
with:
  When an open CFJ's judge is unassigned, the Arbitor CAN assign any
  eligible player to be its judge by announcement, and SHALL do so
  in a timely fashion after it becomes an open and unassigned CFJ.

and by replacing:
  Judge is an untracked CFJ switch with possible values of any
  person or "unassigned" (default).
with:
  Judge is an untracked CFJ switch with possible values of any
  person or former person, or "unassigned" (default).


Every CFJ that had a former person as a judge immediately before Proposal
8134 took effect (02 Dec 2018) hereby has their judge switch flipped to
that judge.

[I'm really, really sure there's been no changes or attempted changes to
former persons' judgeship since Dec 2018, since all those cases were long
before that and I'd remember that].

If G. received any blots in the past two months as the result of failure
to assign a judge in a timely manner to any CFJ whose judge has been
changed by this proposal, that number of blots are expunged from em.

[Don't mind about 1 blot, this is mainly protection against "infinite"
blotting if it happens]"""
            )
        }

        proposal(8455) {
            title("old judgements are good judgements")
            ai("2.0")
            author(G)
            coauthors(Jason, PSS)
            chamber(Justice)

            text(
                """
Amend Rule 991 (Calls for Judgement) by replacing:
  At any time, each CFJ is either open (default), suspended, or
  assigned exactly one judgement.
with:
  At any time, each CFJ is either open (default), suspended, or
  assigned exactly one judgement that was validly assigned.

[Jason pointed out a while ago, that you could argue that when a judgement
option ceased to be defined (like UNDETERMINED has), it ceased to be a
judgement, so the case reverted to open.  Not sure if that's true, but
this makes sure the "validity when assigned" is what matters]."""
            )
        }

        proposal(8456) {
            title("namings")
            ai("1.0")
            author(G)
            coauthors(RLee)
            chamber(Participation)

            text(
                """
enact a rule named "names" with the following text:

  "A player's legal nickname is 'CFJ X' where X is the number of the last
  CFJ they judged.  Failure to refer to someone by their legal nickname in
  public is the class-1 crime of 'oh I'm sorry, I thought you were 3805'.
   If they have never judged a CFJ, their nickname is 'Beverly'.""""
            )
        }

        proposal(8457) {
            title("CHILL BRO")
            ai("2.0")
            author(RLee)
            coauthors(PSS)
            chamber(Efficiency)

            text(
                """
Create a power 2 rule called "Excess Proposals" with the text'

  {A proposal authored by someone who has already authored 6 proposals currently
  in the proposal pool is an Excess Proposal. Rules to the contrary
  notwithstanding, the author of an Excess Proposal is never eligible to be
  granted a reward for the passing of that proposal  The Promotor CAN, by
  announcement, designate an Excess Proposal as Spam, removing it from the
  proposal pool. When e does, assets are created in the possession of the
  pender of that Spam equal to the number of assets e paid to pend that Spam}"""
            )
        }
    }

    voting {
        votes(PSS) {
            FOR on 8442
            AGAINST on 8443
            endorse(Aris) on 8444
            FOR on 8445
            FOR on 8446
            AGAINST on 8447
            FOR on 8448
            FOR on 8449
            FOR on 8450
            AGAINST on 8451
            FOR on 8452
            FOR on 8453
            FOR on 8454
            FOR on 8455
            AGAINST on 8456
            FOR on 8457
        }

        votes(Jason) {
            FOR on 8442
            AGAINST on 8443
            PRESENT on 8444
            FOR on 8445
            FOR on 8446
            AGAINST on 8447
            FOR on 8448
            FOR on 8449
            FOR on 8450
            AGAINST on 8451
            FOR on 8452
            FOR on 8453
            FOR on 8454
            FOR on 8455
            FOR on 8456
            endorseOfficer(offices, Promotor) on 8457
        }

        votes(G) {
            FOR on 8442
            PRESENT on 8443
            AGAINST on 8444
            FOR on 8445
            FOR on 8446
            AGAINST on 8447
            PRESENT on 8448
            AGAINST on 8449
            FOR on 8450
            PRESENT on 8451
            FOR on 8452
            FOR on 8453
            FOR on 8454
            FOR on 8455
            PRESENT on 8456
            AGAINST on 8457
        }

        votes(twg) {
            endorse(G) on all
        }

        votes(nch) {
            endorse(G) on 8442
            PRESENT on 8443
            AGAINST on 8444
            FOR on 8445
            FOR on 8446
            AGAINST on 8447
            FOR on 8448
            // TODO resolve conditional vote on 8449: FOR if 8448 resolved and passed, else AGAINST
            FOR on 8450
            AGAINST on 8451
            endorse(PSS) on 8452
            FOR on 8453
            PRESENT on 8454
            FOR on 8455
            // TODO resolve conditional vote on 8456: endorse(G) unless G FOR, else AGAINST
            AGAINST on 8457
        }

        votes(Trigon) {
            PRESENT on 8442
            AGAINST on 8443
            AGAINST on 8444
            FOR on 8445
            FOR on 8446
            AGAINST on 8447
            FOR on 8448
            FOR on 8449
            PRESENT on 8450
            FOR on 8451
            FOR on 8452
            PRESENT on 8453
            PRESENT on 8454
            PRESENT on 8455
            FOR on 8456
            AGAINST on 8457
        }

        votes(ATMunn) {
            endorse(G) on 8442
            AGAINST on 8443
            AGAINST on 8444
            FOR on 8445
            FOR on 8446
            AGAINST on 8447
            endorse(Aris) on 8448
            PRESENT on 8449
            FOR on 8450
            AGAINST on 8451
            endorse(PSS) on 8452
            PRESENT on 8453
            FOR on 8454
            FOR on 8455
            FOR on 8456
            AGAINST on 8457
        }

        votes(RLee) {
            AGAINST on 8442
            AGAINST on 8443
            AGAINST on 8444
            AGAINST on 8445
            FOR on 8446
            AGAINST on 8447
            AGAINST on 8448
            AGAINST on 8449
            AGAINST on 8450
            AGAINST on 8451
            FOR on 8452
            FOR on 8453
            FOR on 8454
            FOR on 8455
            AGAINST on 8456
            FOR on 8457
        }

        votes(Falsifian) {
            PRESENT on 8442
            AGAINST on 8443
            PRESENT on 8444
            endorse(Aris) on 8445
            endorse(G) on 8446
            PRESENT on 8447
            endorse(Aris) on 8448
            AGAINST on 8449
            endorse(G) on 8450
            AGAINST on 8451
            endorse(PSS) on 8452
            endorse(G) on 8453
            endorse(G) on 8454
            endorse(G) on 8455
            PRESENT on 8456
            endorseOfficer(offices, Promotor) on 8457
        }

        votes(Murphy) {
            FOR on 8442
            FOR on 8443
            AGAINST on 8444
            FOR on 8445
            FOR on 8446
            AGAINST on 8447
            FOR on 8448
            FOR on 8449
            FOR on 8450
            AGAINST on 8451
            FOR on 8452
            FOR on 8453
            FOR on 8454
            FOR on 8455
            AGAINST on 8456
            FOR on 8457
        }
    }
}
