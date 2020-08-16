package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.compileProposals
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.v0

fun proposals8188to8195() = compileProposals(v0) {
    proposal(8188) {
        title("Blanket Denial")
        author(G)
        ai("3.0")
        text(
            """
Amend Rule 2201 (Self-Ratification) by replacing:
  do one of the following in a timely fashion:
with
  do one of the following in a timely fashion, in an announcement
  that clearly cites the claim of error:
"""
        )
    }

    proposal(8189) {
        title("Rule 2479 Cleanup (v1.2)")
        author(Jason)
        ai("1.7")
        text(
            """
Amend Rule 2479 ("Official Justice") as follows:

Replace the text

>  The Referee CAN, subject to the provisions of this rule, impose
>  Summary Judgment on a person who plays the game by levying a fine
>  of up to 2 blots on em. Summary Judgement is imposed on the
>  Referee's own initiative, and not in response to any official
>  proceeding.

with the text

>  Subject to the provisions of this rule, the Referee CAN, by announcement,
>  impose Summary Judgment on a player. When e does so, e levies a fine of
>  up to 2 Blots on em. If e does not specify the number of Blots in the fine,
>  the attempt to impose Summary Judgment is INEFFECTIVE. Summary Judgement is
>  imposed on the Referee's own initiative, and not in response to any official proceeding. 
"""
        )
    }

    proposal(8190) {
        title("Report Rewards")
        author(G)
        coauthors(DMargaux)
        ai("2.0")
        text(
            """
Amend Rule 1006 (Offices) by prepending the following text to the 1st
paragraph:
  An Office is a position described as an Office by the Rules.

Amend Rule 2496 (Rewards) by replacing:
  * Publishing a duty-fulfilling report: 5 coins. For each office,
    this reward can only be claimed for the first weekly report
    published in a week and the first monthly report published in a
    month.
with:
  * Publishing an office's weekly or monthly report, provided that
    publication was the first report published for that office in
    the relevant time period (week or month respectively) to fulfill
    an official weekly or monthly duty: 5 coins.
"""
        )
    }

    proposal(8191) {
        title("Spaceships")
        author(RLee)
        ai("1.1")
        text(
            """
Create a spaceship in the possession of each player without a
spaceship
"""
        )
    }

    proposal(8192) {
        title("auctions have fees")
        author(G)
        ai("1.0")
        text(
            """
[The payment rule for auctions just says that if you happen to have an
auction debt, if you pay Agora under any circumstances, it triggers
stuff.  This means, if someone happens to have two auction debts, they
can make one payment and it would count for both.  This brings things
into line.]

Amend Rule 2551 (Auction End) by replacing:
  The winner of a lot SHALL pay the Auctioneer the number of the
  Auction's currency equal to eir bid, in a single payment, in a
  timely fashion.
with:
  The winner of the lot SHALL, in a timely fashion, pay a fee (the
  number of the Auction's currency equal to eir bid) to the
  Auctioneer in order to satisfy eir auction debt.

[This makes "satisfying eir auction debt" a fee-based action governed
under R2579, which didn't exist when the auction rules were written.
R2579 then takes care of the various CANs and method details.  The
transfer of the lots is then a consequence of "satisfying eir auction
debt"].
"""
        )
    }

    // Proposal 8193 doesn't exist

    // Proposal 8194 doesn't exist

    proposal(8195) {
        title("Timeline Control Ordnance v2")
        author(Aris)
        coauthors(omd, Jason)
        ai("3.0")
        text(
            """
Enact a new power 3.1 Rule, entitled "Timelines", with the following text:

  A timeline is a temporal sequence of events and states.

  The Objective Timeline is the timeline of matters as they actually happened.
  On the Objective Timeline, the consequences of an event are determined
  based on the conditions actually in effect, under Agoran law, when that event
  occurred. The Objective Timeline is not part of the gamestate; instead, it
  is the recording of events on reality itself, and changing it retroactively
  without actual time travel is thus IMPOSSIBLE, rules to the contrary
  notwithstanding.

  The Standard Timeline is the timeline used for the purposes of ordinary
  gameplay. By default, the Standard Timeline is defined by events and their
  consequences in the same way that the Objective Timeline is. However,
  the Standard Timeline is part of the gamestate. Accordingly, it can be
  modified retroactively; such retroactive modifications are secured
  at power 3.

  Attempted retroactive changes are to be interpreted as attempts to change the
  Standard Timeline. All changes are to be interpreted as prospective unless
  they are explicitly retroactive.

  By default, any entity with a power less than the power of this rule that
  refers to the past, present, or future is to be interpreted as referring to
  the Standard Timeline; however, entities may explicitly reference
  different timelines.

Amend Rule 1551, "Ratification" by changing the text "the gamestate is modified"
to read "the gamestate is retroactively modified".

Amend Rule 591, "Delivering Judgements", by changing the text

  "The valid judgements for an inquiry case are as follows, based on
  the facts and legal situation at the time the inquiry case was
  initiated, not taking into account any events since that time:"

to read

  "The judgement of an inquiry case should be based on the facts and legal
  situation as they objectively existed at the time the inquiry case was
  initiated, not taking into account any events or retroactive modifications
  since that time.

  The valid judgements for an inquiry case are as follows:""""
        )
    }
}

fun proposals8215to8234() = compileProposals(v0) {
    proposal(8215) {
        title("recusal simplification")
        ai("1.7")
        author(G)

        text(
            """
Amend Rule 591 (Delivering Judgements) by deleting the following text:
  If e does not, the Arbitor CAN remove em from being the judge of that
  case by announcement, and SHALL do so in a timely fashion after the time
  limit expires, unless the judge assigns a valid judgement in the
  mean time.


Amend Rule 2492 (Recusal) to read in full:

  A judge CAN recuse emself from a CFJ e is assigned to, by
  announcement.

  The Arbitor CAN recuse a judge from a case by announcement, if that
  judge has violated a time limit for judging the case and has not
  judged it in the mean time; the Arbitor SHALL do so in a timely
  fashion after the time limit expires, if able.

  If a judge is recused from a case 4+ days after being assigned
  to it, e SHOULD NOT be assigned as a judge until e has apologised
  and or reasonably explained eir actions.


[
- General rewording goes from 12 to 9 lines of text; net -3 lines in
the ruleset.

- It was weird that recusing oneself from a CFJ made one ineligible
to judge for a week, but being recused for lateness didn't.  There
are also honorable reasons to self-recuse (e.g. self-interest in the
case).  Changed this to the idea of "if you're recused in any way after
being assigned 4+ days, let us know why, before getting another case",
and only governed by a SHOULD.  It's as much about helping the Arbitor
figure out if the recused are still interested in judging.
]"""
        )
    }

    proposal(8216) {
        title("NO MORE APATHY")
        ai("1.0")
        author(RLee)

        text(
            """
Repeal rule 2465 "Victory By Apathy""""
        )
    }

    proposal(8217) {
        title("penance as a service")
        ai("2.0")
        author(G)

        text(
            """
Amend Rule 2555 (Blots) by replacing:
  If a player has neither gained blots nor expunged any blots from
  emself in the current Agoran week, e CAN expunge 1 blot from
  emself by announcement.
with:
  If a person (the penitent) has neither gained blots nor had
  more than 2 blots expunged from emself in the current Agoran
  week, then any player (the confessor) who has not expunged
  any blots in the current Agoran week CAN expunge 1 blot from the
  penitent, by announcement.

[Inspired because I wanted to help out Kenyon]."""
        )
    }

    proposal(8218) {
        title("No, you didn't publish that")
        ai("3.0")
        author(Jason)

        text(
            """
Amend Rule 478 ("Fora") by replacing the text

  A person "publishes" or "announces" something by sending a public
  message.

with the text

  A person "publishes" or "announces" something by sending a public
  message whose body contains that thing."""
        )
    }

    proposal(8221) {
        title("Usage de-capitalization")
        ai("3.0")
        author(Jason)
        coauthors(Aris)

        text(
            """
Amend Rule 2574 by replacing all instances of the text "with Notice"
with the text "with notice".

Amend Rule 2594 by replacing the text "With 2 Days Notice" with the text
"with 2 days notice".


Amend Rule 1607 by replacing the text "Without 3 Objections" with the
text "without 3 objections".

Amend Rule 991 by replacing the text "Without 3 Objections" with the
text "without 3 objections".

Amend Rule 2415 by replacing the text "Without Objection" with the text
"without objection".

Amend Rule 2575 by replacing the text "Without Objection" with the text
"without objection".

Amend Rule 2495 by replacing the text "Without 3 Objections" with the
text "without 3 objections".


Amend Rule 1006 by replacing the text "With 3 Support" with the text
"with 3 support".

Amend Rule 2154 by replacing the text "With 2 Support" with the text
"With 2 support".

Amend Rule 911 by replacing the text "with 2 Support" with the text
"with 2 support".

Amend Rule 2488 by replacing the text "with 4 Support" with the text
"with 4 support".

Amend Rule 103 by replacing the text "with Support" with the text "with
support".


Amend Rule 2493 by replacing the text "with 2 Agoran Consent" with the
text "with 2 Agoran consent".

Amend Rule 2573 by replacing the text "with 2 Agoran Consent" with the
text "with 2 Agoran consent".

Amend Rule 2585 by replacing the text "with Agoran Consent" with the
text "with Agoran consent".

Amend Rule 649 by replacing the text "With 2 Agoran Consent" with the
text "with 2 Agoran consent".

Amend Rule 2415 by replacing the text "with Agoran Consent" with the
text "with Agoran consent".

Amend Rule 1367 by replacing the text "with 2 Agoran Consent" with the
text "with 2 Agoran consent".

Amend Rule 2581 by replacing the text "with 2 Agoran Consent" with the
text "with 2 Agoran consent".

Amend Rule 2582 by replacing the text "with 2 Agoran Consent" with the
text "with 2 Agoran consent".

Amend Rule 2463 by replacing the text "with 2 Agoran Consent" with the
text "with 2 Agoran consent".

Amend Rule 2566 by replacing the text "with 2 Agoran Consent" with the
text "with 2 Agoran consent"."""
        )
    }

    proposal(8222) {
        title("Fixing Summary Judgement (v2)")
        ai("2.0")
        author(Jason)

        text(
            """
If Proposal 8203 has never taken effect, this proposal applies the
effects specified by Proposal 8203.


Amend Rule 2531 as follows:

  Amend the list item beginning "it attempts to levy a fine (i) by
  summary judgement" to read:

    it attempts to levy a fine based upon the investigation of of a
    Finger that had been Pointed more than 14 days after the action
    constituting the reason for the fine;

  Amend the list item beginning "it attempts to levy a fine on a
  player for failing to take an action" to read:

    it attempts to levy a fine on a player for failing to take an
    action within the time period set by the Rules and that time
    period had expired more than 14 days prior to the Pointed
    Finger, if the fine is imposed based on an investigation of such
    Finger;"""
        )
    }

    proposal(8223) {
        title("No secret contracts")
        ai("2.5")
        author(RLee)

        text(
            """
Destroy each contract the full text of which has not been posted in
public. If this destroyed Agora, put it back again the same as it was.
Nobody will be able to tell the difference.

Amend the rule "Contracts" by changing "Such an agreement is known as a
contract." to "When the full text of such an agreement is posted in public,
it is known as a contract""""
        )
    }

    proposal(8224) {
        title("Remove Inactive Sods!")
        ai("3.0")
        author(RLee)

        text(
            """
Deregister each player who has not posted to a public forum in 30
days."""
        )
    }

    proposal(8227) {
        title("Fresh start v2")
        ai("3.1")
        author(Falsifian)
        coauthors(G)

        text(
            """
If nch has publicly consented to abide by the rules in clear reference
to this proposal, and not withdrawn consent, then
Register nch and grant em 3 blots.

[Comment: Instead of withholding the welcome package, this version
uses blots, with the intention to prevent victory, as a more
appropriate penalty. I expect em to expunge all three approximately by
the time e would otherwise be able to register again.]"""
        )
    }

    proposal(8228) {
        title("Active Officers")
        ai("3.0")
        author(G)
        coauthors(Jason)

        text(
            """
Amend Rule 2160 (Deputisation) by replacing:
  A player (the deputy)
with:
  An player acting on eir own behalf (the deputy)


Amend Rule 2472/2 (Office Incompatibilities) by inserting this
paragraph:
  A zombie who holds one or more offices is Overpowered.
after the paragraph beginning:
  A player is Overpowered if e holds two offices which are
  incompatible with each other."""
        )
    }

    proposal(8229) {
        title("freeing up space")
        ai("1.0")
        author(G)

        text(
            """
[The universe is imploding!  Can any pro-spaaace heroes rush to the
rescue and propose fixes in time to convince players to keep it???]

Repeal the following rules in this order:
  Rule 2588 (Sectors)
  Rule 2589 (Galaxy Maintenance)
  Rule 2590 (The Astronomor)
  Rule 2591 (Spaceships)
  Rule 2592 (Spaceship Energy)
  Rule 2593 (Space Battles)
  Rule 2594 (Fame)"""
        )
    }

    proposal(8230) {
        title("Close the wormhole")
        ai("1.0")
        author(Murphy)

        text(
            """
Amend Rule 2591 (Spaceships) by replacing this text:

  Spaceships are a class of fixed asset,

with this text:

  Spaceships are a class of indestructible fixed asset,

Set each player's Fame to 0."""
        )
    }

    proposal(8231) {
        title("Three-dimensional space v1.1")
        ai("1.0")
        author(Murphy)
        coauthors(Aris)

        text(
            """
Amend Rule 2588 (Sectors) to read:

  Sectors are entities. Each Sector has an ID number, which is an
  ordered list of three coordinates, each of which is one of
  (-1, 0, +1). There is one Sector for each such list. These ID
  numbers are ordered by their first coordinate, with ties broken
  by the second, then the third.

  If no Spaceship is in a particular Sector, then that Sector is
  "empty"; otherwise it is "occupied".

  Two Sectors are "adjacent" if one of their coordinates differ by
  exactly 1 and their others are the same.

Repeal Rule 2589 (Galaxy Maintenance).

Move spaceships to Sectors as follows, based on their owners:

(-1, -1, -1) omd
(-1, -1,  0) Aris
(-1, -1, +1) Gaelan
(-1,  0, -1) G.
(-1,  0,  0) Cuddle Beam
(-1,  0, +1) Trigon
(-1, +1, -1) Murphy
(-1, +1,  0) R. Lee
(-1, +1, +1) ATMunn
( 0, -1, -1) twg
( 0, -1,  0) D. Margaux
( 0, -1, +1) Baron von Vaderham
( 0,  0, -1) Falsifian
( 0,  0,  0) Bernie
( 0,  0, +1) Rance
( 0, +1, -1) o
( 0, +1,  0) Jason Cobb
( 0, +1, +1) Walker
(+1, -1, -1) nch
(+1, -1,  0) PSS
(+1, -1, +1) Corona
(+1,  0, -1) L
(+1,  0,  0) Hālian
(+1,  0, +1) Jacob Arduino
(+1, +1, -1) Telnaior
(+1, +1,  0) any other non-zombies
(+1, +1, +1) any other zombies"""
        )
    }

    proposal(8232) {
        title("Increased transparency v1.1")
        ai("3.0")
        author(Murphy)
        coauthors(Jason, twg)

        text(
            """
Amend Rule 2438 (Ribbons) by replacing the sections for the relevant
types of ribbons with the following sections:

  Green (G): While a person holds an elected office, has done so
  continuously for the past 30 days, and has not failed to perform
  any duties of that office within the appropriate time limits
  during those 30 days, that person qualifies for a Green Ribbon.

  Magenta (M): When, during Agora's Birthday, a person publicly
  acknowledges it, that person earns a Magenta Ribbon.

  Transparent (T): A person qualifies for a Transparent Ribbon while
  the number of other types of Ribbon that that person qualifies
  for, earns, and/or was awarded within the previous 7 days is at
  least 5."""
        )
    }

    proposal(8233) {
        title("Duties")
        ai("3.0")
        author(Murphy)

        text(
            """
Amend Rule 2152 (Mother, May I?) by appending this text:

  9. DUTY: The person with the duty CAN perform the described
     action by announcement, and SHALL do so in a timely fashion.

Amend Rule 2141 (Role and Attributes of Rules) by replacing this text:

  Every rule shall have a title to aid in identification. If a rule
  ever does not have a title, the the Rulekeepor CAN and SHALL
  assign a title to it by announcement in a timely fashion.

with this text:

  Every rule shall have a title to aid in identification. If a rule
  ever does not have a title, the Rulekeepor has a DUTY to assign a
  title to it.

Amend Rule 2154 (Election Procedure) by replacing this text:

  In a timely fashion after the nomination period ends, the ADoP CAN
  and SHALL:

with this text:

  When the nomination period ends, the ADoP has a DUTY to:

Amend Rule 2478 (Vigilante Justice) by replacing this text:

  When a player Points a Finger, the investigator SHALL investigate
  the allegation and CAN, and in a timely fashion SHALL, conclude
  the investigation by:

with this text:

  When a player Points a Finger, the investigator has a DUTY to
  investigate the allegation and conclude it by:

Amend Rule 991 (Calls for Judgement) by replacing this text:

  When a CFJ's judge is unassigned, the Arbitor CAN assign any
  eligible player to be its judge by announcement, and SHALL do so
  in a timely fashion.

with this text:

  When a CFJ's judge is unassigned, the Arbitor has a DUTY to
  assign an eligible player to be its judge.

Amend Rule 591 (Delivering Judgements) by replacing this text:

  When a CFJ is open and assigned to a judge, that judge CAN assign
  a valid judgement to it by announcement, and SHALL do so in a
  timely fashion after this becomes possible. If e does not, the
  Arbitor CAN remove em from being the judge of that case by
  announcement, and SHALL do so in a timely fashion after the time
  limit expires, unless the judge assigns a valid judgement in the
  mean time.

with this text:

  When a CFJ is open and assigned to a judge, that judge has a DUTY
  to assign a valid judgement to it. If e is in violation of that
  duty, the Arbitor has a DUTY to remove em from being the judge of
  that case.

Amend Rule 911 (Motions and Moots) by replacing this text:

  If a CFJ has a judgement assigned, a player CAN enter that
  judgement into Moot with N+2 support, where N is the number of
  weeks since that judgement has been assigned, rounded down. When
  this occurs, the CFJ is suspended, and the Arbitor is once
  authorized to initiate the Agoran decision to determine public
  confidence in the judgement, which e SHALL do in a timely fashion.

with this text:

  If a CFJ has a judgement assigned, a player CAN enter that
  judgement into Moot with N+2 support, where N is the number of
  weeks since that judgement has been assigned, rounded down. When
  this occurs, the CFJ is suspended, and the Arbitor has a DUTY to
  initiate the Agoran decision to determine public confidence in
  the judgement.

Amend Rule 2589 (Galaxy Maintenance) by replacing this text:

  If there are ever fewer Sectors than the Ideal Sector Count, then
  the Astronomor CAN by announcement and SHALL in a timely fashion
  create a new Sector.

  If there are ever more Sectors than the Ideal Sector Count, then
  the Astronomor CAN by announcement and SHALL in a timely fashion
  destroy an empty Sector.

with this text:

  If there are ever fewer Sectors than the Ideal Sector Count, then
  the Astronomor has a DUTY to create a new Sector.

  If there are ever more Sectors than the Ideal Sector Count, then
  the Astronomor has a DUTY to destroy an empty Sector.

  Amend Rule 2593 (Space Battles) by replacing this text:

  After both combatants have communicated the Energy they will
  spend, or if the time limit to do so has expired, the resolver
  CAN, and SHALL in a timely fashion, resolve the Space Battle by
  announcing the changes in each Spaceship's Energy balance and
  Armour (described below), and the Winner (if any) of the Space
  Battle.

with this text:

  After both combatants have communicated the Energy they will
  spend, or if the time limit to do so has expired, the resolver
  has a DUTY to resolve the Space Battle by announcing the changes
  in each Spaceship's Energy balance and Armour (described below),
  and the Winner (if any) of the Space Battle.

Amend Rule 2511 (Karmic Balance) by replacing this text:

  In a timely fashion after the beginning of each Quarter, the
  Herald CAN and SHALL by announcement, perform the following tasks
  in order:

with this text:

  At the beginning of each Quarter, the Herald has a DUTY to
  perform the following tasks in order:"""
        )
    }

    proposal(8234) {
        title("auto-balance")
        ai("1.0")
        author(G)
        coauthors(Jason)

        text(
            """
Repeal Rule 2511 (Karmic Balance).

Append the following paragraph to Rule 2510 (Such is Karma):
  At the beginning of each quarter, the Karma of every Unregistered
  person is halved (rounding towards 0), then the Karma of Agora is
  set such that the sum of all Karma values in the game equals 0."""
        )
    }
}

fun proposals8235to8242() = compileProposals(v0) {
    proposal(8235) {
        title("Unified fine creation syntax")
        ai("3.0")
        author(Jason)

        text(
            """
Amend Rule 2555 ("Blots") by replacing the text "To Levy a Fine" with
the text "To levy a fine".


Amend Rule 2451 ("Executive Orders") by replacing the sentence

  The Prime Minister levies a 2 Blot fine on a specified player.

with the sentence

  The Prime Minister levies a fine of 2 on a specified player.


Amend Rule 2479 ("Official Justice") by replacing the text "levying a
fine of up to 2 blots on em" with the text "levying a fine of (a value
not exceeding 2) on em"."""
        )
    }

    proposal(8236) {
        title("Definition de-capitalization")
        ai("3.0")
        author(Jason)
        coauthors(Aris)

        text(
            """
Amend Rule 1728 to read, in whole:

  The following methods of taking actions are known as "dependent
  actions":

  1. without N objections, where N is a positive integer no greater
  than 8 ("without objection" is shorthand for this method with N = 1);

  2. with N support, where N is a positive integer ("with support" is
  shorthand for this method with N = 1);

  3. with N Agoran consent, where N is an integer multiple of 0.1 with
  a minimum of 1 ("With Agoran consent" is shorthand for this method
  with N = 1);

  4. with notice; or

  5. with T notice, where T is a time period.

  N is 1 unless otherwise specified.


Amend Rule 2595 as follows:

  In the first sub-bullet under item 2 of the only list, replace the
  text "with T Notice" with the text "with T notice".

  In the second sub-bullet under item 2 of the only list, replace the
  text "Without N Objections, With N Support, or With N Agoran
  Consent" with the text "without N objections, with N support, or
  with N Agoran Consent".

  In the first sub-bullet under item 3 of the only list, replace the
  text "With N Support" with the text "with N support".

  In the second sub-bullet under item 3 of the only list, replace the
  text "Without N Objections, With N Agoran Consent, or With Notice"
  with the text "without N objections, with N Agoran consent, or with
  notice".

  In the third sub-bullet under item 3 of the only list, replace the
  text "With T Notice" with the text "with T notice".

  In the final paragraph, replace the text "with N Agoran Consent"
  with the text "with N Agoran consent".

Amend the only list in Rule 2124 ("Agoran Satisfaction") to read:

  1. The action is to be performed Without N objections, and there are
  at least N Objectors to that intent.

  2. The action is to be performed With N support, and there are fewer
  than than N Supporters of that intent.

  3. The action is to be performed with N Agoran consent, and the
  number of Supporters of the intent is less than or equal to N times
  the number of Objectors to the intent."""
        )
    }

    proposal(8237) {
        title("Repairing Defeated Spaceships v3")
        ai("3.0")
        author(Jason)
        coauthors(twg, Jason)

        text(
            """
Amend Rule 2595 by replacing the text "Any player CAN, by
announcement, spend a coin to increase the Armour of a Pilotable
Spaceship e owns by 1." with the text "Any player CAN pay a fee of 1
coin to increase the Armour of a Pilotable Spaceship in eir possession
by 1 or pay a fee of 3 coins to increase the Armour of a Defeated
Spaceship by 1."

[Comment: Right now, Defeated Spaceships are effectively dead forever.
If a player goes all out and kills the other person's Spaceship, they
are effectively banished from the subgame forever. To solve this, a
slight penalty is added for repairing a Defeated spaceship. The number
of coins remains small because it is just a subgame.]

Amend Rule 2591 by replacing the text "Spaceships are a class of fixed
asset" with "Spaceships are a class of fixed indestructible asset".

[Change from the original: "pay... 1 coin increase" -> "pay... 1 coin to
increase"]"""
        )
    }

    proposal(8238) {
        title("Cancelling Proposals (arr. for violin)")
        ai("3.0")
        author(JacobArduino)
        coauthors(twg, G)

        text(
            """
[ This has bugged me for a while (no pun intended): if a broken proposal makes
   it to its voting period, even if the error is then discovered, it tends not
   to percolate through to everyone doing the voting, and the proposal gets
   adopted anyway. I've been trying to get around this by just endorsing the
   proposal's author, on the basis that e's the most likely to notice if there
   is a problem and can then change eir vote to AGAINST, but that has its own
   problems. I feel this is a fairly neat solution with enough safeguards to
   stop it being abused. ]

[ This second version removes reliance on the Assessor to support the action,
  and adds protection against the Speaker's delay (which would function here
  as a veto). ]

Enact a new rule, "Cancelling Erroneous Proposals", Power=3.0, with the
following text:

  During the voting period of an Agoran decision determining whether or not
  to adopt a proposal, its author CAN with support cancel the decision.

  It is RECOMMENDED that this ability only be used if the proposal contains
  a textual error preventing it from having the effect its author intended.

  The Speaker is not eligible to object to an announcement of intent to
  perform an action permitted by this rule.

Amend Rule 955, "Determining the Will of Agora", by adding the following list
item to the unnumbered list in between the two previously existing items:

  - If the decision has been cancelled, as permitted by rules of power 3 or
    greater, the outcome is instead CANCELLED."""
        )
    }

    proposal(8239) {
        title("The Editor (v2.0.1)")
        ai("1.0")
        author(Jason)
        coauthors(G, Aris, Trigon)

        text(
            """
[Comment: Creates a new role, the Editor, who is the same person as the
Rulekeepor and which is responsible for promulgating regulations
(Editorial Guidelines) about non-substantive elements of the Ruleset.
Currently, guidelines are not written down anywhere official, which
probably contributes to the inconsistency arising in the first place.]

Enact a new Rule with power 1, title "The Editor", and text as follows:

  The Editor is the same person, if any, as the Rulekeepor.

  The Editor CAN, with Agoran consent, enact regulations, collectively
  called "Editorial Guidelines". The Editor CAN, with Agoran consent,
  repeal and amend Editorial Guidelines. The Editor is the Promulgator
  for all Editorial Guidelines.

  Editorial Guidelines SHOULD pertain only to matters that affect
  non-substantive aspects of the Rules, e.g. capitalization or
  spelling. Editorial Guidelines CANNOT place any enforceable
  requirements upon any player and CANNOT cause any changes to the
  gamestate. Whether or not the text of a textual entity conforms to
  the Editorial Guidelines SHOULD NOT affect the interpretation of
  that entity.

  When writing proposals and enacting or amending regulations, players
  SHOULD follow all reasonable directives that are set out in the
  Editorial Guidelines.

  Causing an Editorial Guideline to be inconsistent with any other
  Editorial Guideline is the Class 1 Crime of Editorial Hypocrisy."""
        )
    }

    proposal(8240) {
        title("Regulation clarification")
        ai("3.0")
        author(Jason)

        text(
            """
[Comment: Currently, R2493 reads as if any person who happens to be
Promulgator can enact/amend/repeal _any_ regulation (without otherwise
specified rules) with 2 Agoran Consent. While not the most serious bug,
it's probably not what was intended.]

Amend Rule 2493 ("Regulations") as follows:

  Replace the sentence beginning "By default" with the sentence
    By default, a person CAN, with 2 Agoran consent, enact, amend,
    or repeal a regulation for which e is the Promulgator."""
        )
    }

    proposal(8241) {
        title("Secured switches (v2.0)")
        ai("3.0")
        author(Jason)
        coauthors(Falsifian)

        text(
            """
[Comment: define what it means for switches to be "secured", then use
that definition. This works with default power thresholds since it isn't
R2162 that designates the changes as secured, the Rule that defines the
switch is defined as designating the changes as secured.]

Amend Rule 2162 by appending the following sentence to the paragraph
beginning "At any given time":

  A Rule that designates a switch as "secured" (at a given power
  level) designates changes to the properties of that type of switch
  as secured (at that power level) and designates changes to the value
  of each instance of the switch as secured (at that power level).

Amend Rule 1950 as follows:

  Delete the text "Adoption index is secured with a power threshold of
  2.".

  Replace the text

    Adoption index (AI) is an untracked switch possessed by Agoran
    decisions and proposals.

  with the text

    Adoption index (AI) is an untracked switch possessed by Agoran
    decisions and proposals, secured at power 2.

Amend Rule 2480 as follows:

  Delete the text "Changes to Festivity are secured.".

  Replace the text "Festivity is a singleton switch" with the text
  "Festivity is a secured singleton switch".

Amend Rule 869 as follows:

  Delete the text "Changes to citizenship are secured.".

  Replace the text "Citizenship is a person switch" with the text
  "Citizenship is a secured person switch".

Amend Rule 478 as follows:

  Delete the text "Changes to publicity are secured.".

  Replace the text "Publicity is a forum switch" with the text
  "Publicity is a secured forum switch."."""
        )
    }

    proposal(8242) {
        title("Let the dead rest")
        ai("3.0")
        author(Falsifian)

        text(
            """
If Hālian is a zombie, then deregister em.
[Comment: eir resale value was 0 before R. Lee deregistered, so e was
due to be deregistered.]

Append the following sentence to the end of the first paragraph of
Rule 2532 (Zombies):

  When a zombie's master ceases to be a player, the value of the zombie's
  master switch is set to Agora."""
        )
    }

}
