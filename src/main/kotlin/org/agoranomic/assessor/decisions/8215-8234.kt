package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.match
import org.agoranomic.assessor.dsl.votes.pmBonus
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun `assessment 8215 to 8234`() = assessment {
    name("8215-8234")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-August/013099.html")
    quorum(9)

    proposals(v0) {
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

    strengths {
        default(3)
        min(0)
        max(5)

        pmBonus(G)

        blotPenalty(Corona, 2)
        blotPenalty(twg, 1)
    }

    voting {
        votes(Falsifian) {
            endorse(G) on 8215
            AGAINST on 8216
            endorse(G) on 8217
            endorse(Jason) on 8218
            PRESENT on 8221
            endorse(Jason) on 8222
            AGAINST on 8223
            PRESENT on 8224
            AGAINST on 8227
            endorse(G) on 8228
            AGAINST on 8229
            FOR on 8230 comment NO_VETO
            AGAINST on 8231
            endorse(Murphy) on 8232
            AGAINST on 8233
            FOR on 8234 comment NO_VETO
        }

        votes(Murphy) {
            FOR on 8215
            AGAINST on 8216
            FOR on 8217
            FOR on 8218
            PRESENT on 8221
            PRESENT on 8222
            PRESENT on 8223
            AGAINST on 8224
            FOR on 8227
            AGAINST on 8228
            AGAINST on 8229
            FOR on 8230
            FOR on 8231
            FOR on 8232
            FOR on 8233
            endorse(G /* Herald */) on 8234
        }

        votes(DMargaux) {
            endorse(G) on 8215 comment "Final non-conditional ballot"
            endorse(G) on 8216 comment "Final non-conditional ballot"
            endorse(G) on 8217 comment "Final non-conditional ballot"
            endorse(G) on 8218 comment "Final non-conditional ballot"
            endorse(G) on 8221 comment "Final non-conditional ballot"
            endorse(G) on 8222 comment "Final non-conditional ballot"
            endorse(G) on 8223 comment "Final non-conditional ballot"
            endorse(G) on 8224 comment "Final non-conditional ballot"
            endorse(Falsifian) on 8227 comment "Final non-conditional ballot"
            endorse(G) on 8228 comment "Final non-conditional ballot"
            endorse(Telnaior) on 8229 comment "Final non-conditional ballot"
            endorse(G) on 8230 comment "Final non-conditional ballot"
            endorse(G) on 8231 comment "Final non-conditional ballot"
            endorse(G) on 8232 comment "Final non-conditional ballot"
            endorse(G) on 8234 comment "Final non-conditional ballot"
        }

        votes(Jason) {
            FOR on 8215
            AGAINST on 8216
            PRESENT on 8217
            FOR on 8218
            FOR on 8221
            FOR on 8222
            AGAINST on 8223
            AGAINST on 8224
            endorse(G) on 8227
            FOR on 8228
            AGAINST on 8229
            AGAINST on 8230
            AGAINST on 8231
            FOR on 8232
            AGAINST on 8233
            FOR on 8234
        }

        votes(G) {
            FOR on 8215
            AGAINST on 8216
            FOR on 8217
            FOR on 8218
            FOR on 8221
            FOR on 8222
            AGAINST on 8223
            AGAINST on 8224
            AGAINST on 8227
            FOR on 8228
            FOR on 8229
            PRESENT on 8230
            PRESENT on 8231
            FOR on 8232
            AGAINST on 8233
            FOR on 8234
        }

        votes(Telnaior) {
            match(G) on all
        }
    }
}
