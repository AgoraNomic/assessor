package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8645to8654() = assessment {
    name("8645-8654")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Madrid, 7 / 3)
        blotPenalty(Trigon, 4 / 3)
        blotPenalty(nix, 4 / 3)
        blotPenalty(cuddlybanana, 3 / 3)

        onOrdinaryProposals {
            powerStone(Jason, 3)
            powerStone(Jason, 3)
            votives(Secretsnail9, 10)
            votives(Jason, 6)
        }
    }

    proposals(v4) {
        proposal(8645) {
            title("Some RTRW Clean-Ups")
            ai("3.0")
            author(ATMunn)
            coauthors(nix)
            democratic()
            sponsored()

            text("""
Amend R2464 by replacing "set of regulations," with "a set of
regulations,".

Amend R2493 by:

      * replacing "an textual entity" with "a textual entity"; and
      * replacing "an person" with "a person".

Amend R2495 by replacing "This title" with "These regulations".

Amend R2471 by replacing "be not to be true" with "be not true".

Amend R2602 by removing any quotation marks and replacing "or e
corresponding" with "or the corresponding".""")
        }

        proposal(8646) {
            title("Deputisation rewrite")
            ai("3.0")
            author(Jason)
            coauthors(G, ais523)
            democratic()
            sponsored()

            text("""
Amend Rule 2160 ("Deputisation") by replacing the sole list with the
following:
{
  1. the rules require the holder of that office, by virtue of holding
  that office, to perform the action (this requirement is fulfilled by the
  deputy performing the action); and, it would be POSSIBLE for the deputy
  to perform the action, other than by deputisation, if e held the office;
  and, the deputy, when performing the action, announces that e is doing
  so by deputisation or by temporary deputisation; and, the deputy has not
  held the office in the past 7 days; and,

  2. any of the following are true:
     (A) the office is vacant;
     (B) a time limit by which the rules require the action to be
         performed has expired, the office's holder has not changed
         in the past 7 days, and any of the following are true:

           (i) the deputy announced between two and fourteen days earlier
               that e intended to deputise for that office for the purposes
               of the particular action;
          (ii) the time limit expired between 14 days ago and 28 days ago;
         (iii) the time limit expired more than 28 days ago and the
               deputisation is temporary;
}

[This simplifies the list significantly, hopefully making it clearer. It
also makes the following substantive changes: allows only temporarily
deputisation (or deputisation with notice) for old duties, prohibits
deputies who have held the office in the past 7 days, and prohibits
deputising for an office whose holder has changed in the past 7 days, to
allow a holder time to catch up when they assume a new office, and to
prevent rapid-fire changes resulting from deputisation fights.]""")
        }

        proposal(8647) {
            title("Birds!")
            ai("2.0")
            author(Secretsnail9)
            coauthors(Jason, Telna)
            ordinary()
            sponsored()

            text("""
Create a rule with title "Birds", power 2.0, and the following text:
{
  A bird is a unique indestructible liquid asset defined by the
  rules. To define a bird, the definition must include:
    (i) A name unique among birds;
   (ii) A scroll, which is a document specifying the effects of the
        bird.

  Ownership of birds is entirely restricted to Agora and active
  players. If a bird is owned by the Lost and Found Department or
  in abeyance, it is immediately transferred to Agora.

  The Avicultor is an office, and the recordkeepor of birds.

  A player that is not Beast Permitted SHALL NOT transfer a bird e
  owns to another player; doing so is the Class 3 Crime of
  Unpermitted Beast Transit.
}

Create a rule with title "Permits", power 2.0, and the following text:
{
  Beast Permitted is a secured negative boolean person switch,
  tracked by the Avicultor in eir weekly report. A player with a
  Beast Permitted switch set to True is 'Beast Permitted'.

  A player CAN buy a beast permit by paying a fee of 50 boatloads
  of coins. When a player buys a beast permit, eir Beast Permitted
  switch is set to True.

  A player CAN relinquish eir beast permit by announcement. When a
  player relinquishes eir beast permit, eir Beast Permitted switch
  is set to False.

  A player CAN renew eir beast permit by paying a fee of 25
  boatloads of coins.

  When permits expire, the Avicultor CAN and SHALL review each
  Beast Permitted player, with notice, in a timely fashion. When a
  Beast Permitted player is reviewed, if e has neither bought a
  beast permit nor renewed eir beast permit in the past 30 days,
  eir Beast Permitted switch is set to False.
}

Create a rule with title "Playing with Birds", power 2.0, and the following
text:
{
  Except as otherwise specified by the rules, the owner of a bird
  CAN play with it by announcement, specifying any values needed
  to interpret the bird's effects.

  When a bird is played with, the Rule defining that bird applies
  the effects in that bird's scroll, and then that bird is
  transferred to Agora.
}

Create a rule with title "Bird Migration", power 2.0, and the following
text:
{
  A player CAN buy bird food by paying a fee of 5 boatloads of
  coins.

  A player CAN release a bird e owns, by announcement. When a
  bird is released, it is transferred to Agora.

  Once per month, a Beast Permitted Player CAN transfer a bird
  owned by Agora from Agora to emself by announcement.

  Once per month, the Avicultor CAN publish a migration notice by
  announcement, specifying all necessary information and choices;
  this constitutes eir monthly report. The Avicultor SHALL publish
  such a notice in a timely fashion after the beginning of each
  Agoran month.

  The number of times each player bought bird food in the previous
  month is included in the migration notice.

  A bird not owned by the player(s) who bought bird food the most
  times during the previous month is a Hungry Bird.

  For each Hungry Bird, a random choice among all players who
  bought bird food during the previous month is included alongside
  that bird in the migration notice.

  When a migration notice is published, Hungry Birds are
  transferred to their corresponding randomly chosen players in an
  order specified by the migration notice.

  If a bird being transferred to a player would cause that player
  to have more birds than the number of times e bought bird food
  during the previous month, that bird is instead transferred to
  Agora.
}


Create a rule with title "One with Nature", power 2.0, and the following
text:
{
  A player CAN, by announcement, Free the Birds, specifying
  a single player that owns 10 or more birds, provided that no
  person has won the game by doing so in the past 30 days.

  When the Birds are Freed, the specified player wins the game.
  If a player won the game in this manner 4 days ago, then all
  existing birds are transferred to Agora and permits expire.
}

Create a rule with title "The Birds", power 1.0, and the following text:
{
  'The playmate' is the player who played with the bird to make
  its scroll activate. Players are ENCOURAGED to propose an
  addition to this rule if it has not been changed within the last
  30 days.

  The following birds are defined, one per paragraph, with the
  following format: Bird Name: Scroll.

  - Seagull: A specified player (defaulting to the playmate if not
    specified) buys bird food 3 times.

  - Goldfinch: A specified player (defaulting to the playmate if
    not specified) gains N boatloads of coins, where N is the
    number of times e has bought bird food this month.

  - Raven: A specified bird is transferred to Agora.

  - Emu: A specified player gains 1 blot.

  - Owl: A specified player (defaulting to the playmate if not
    specified) gains the Grant associated with a specified
    Ministry.

  - Magpie: A specified:
        * Card,
        * Product,
        * or Bird
    that is owned by a player is transferred to the playmate.

  - Pigeon: The playmate gains 2 blots and 1 Blot-B-Gone.

  - Penguin: If the playmate is Beast Permitted, e gains
    1 Winsome, 1 Blot-B-Gone, 1 Pendant, and 1 Votive. Otherwise,
    the playmate gains 1 blot, 1 Pendant, and 1 Votive.

  - Cockatiel: A specified player that is not the playmate gains a
    specified Product.

  - Jay: The Pended switch of a specified proposal is set to True,
    and that proposal becomes sponsored. The playmate then gains
    1 Votive.
}""")
        }

        proposal(8648) {
            title("Scoring Integer Points")
            ai("1.0")
            author(Secretsnail9)
            ordinary()
            sponsored()

            text("""
Amend Rule 2657 (Scoring) by replacing "add to that player's score the
associated amount of points" with "add to that player's score the floor of
the associated amount of points".

(This would let players score points for proposals with non-integer AIs.)""")
        }

        proposal(8649) {
            title("The Devices v1.1")
            ai("1.0")
            author(Murphy)
            ordinary()
            sponsored()

            text("""
Amend Rule 2654 (The Device) by replacing "When the device is on:" with
"The following apply to devices that are on:", and by replacing "When
the device is off:" with "The following apply to devices that are off:".

Amend Rule 2655 (The Mad Engineer) by replacing this text:

  The Mad Engineer is an office; its holder is responsible for
  building, tracking, and maintaining the Device.  The device is a
  singleton switch with values off (default) and on.  The Mad
  Engineer CAN flip the device to either on or off with Agoran
  Consent; any other player CAN do so with 2 Agoran Consent.

  The Mad Engineer CAN act on behalf of the device to take any
  action that the device may take, and SHALL act on behalf of the
  device to ensure that the device fulfills all of its duties.

with this text:

  The Mad Engineer is an office; its holder is responsible for
  building, tracking, and maintaining devices. Each device is a
  singleton switch with values off (default) and on. The Mad
  Engineer CAN flip a device to either on or off with Agoran
  Consent; any other player CAN do so with 2 Agoran Consent.

  The Mad Engineer CAN act on behalf of a device to take any
  action that that device may take, and SHALL act on behalf of a
  device to ensure that that device fulfills all of its duties.

  If there are ever no devices, then the Mad Engineer CAN create
  one by announcement, and SHALL do so in a timely fashion.""")
        }

        proposal(8650) {
            title("It's an even grayer world.")
            ai("1.0")
            author(Jason)
            ordinary()
            sponsored()

            text("""
Repeal Rule 2602 (Glitter).""")
        }

        proposal(8651) {
            title("Temporal Incursion Modification and Exclusion Act")
            ai("3.0")
            author(Jason)
            coauthors(Aspen, Oerjan)
            democratic()
            sponsored()

            text("""
Amend Rule 1551 (Ratification) to read, in whole:

{

  A retroactive change is one that changes the game's record of past
  events. Retroactive changes are secured with power threshold 3.

  When a document or statement (hereafter "document") is to be ratified,
  the following definitions apply:
  * The publication time is the instant at which the document to be
    ratified was published.
  * The truth time is the instant at which the document specifies that it
    was true, or the publication time if such an instant is not specified.
  * The application time is the instant at which the document to be
    ratified is ratified.

  Ratification CANNOT occur if the truth time would be after the
  application time, or if the publication time would be after the
  application time.

  Rules to the contrary notwithstanding, when a document is ratified, the
  gamestate is modified to what it would be if, at the truth time, the
  gamestate had been minimally modified to make the ratified document as
  true and accurate as possible.

  Ratification CANNOT occur if it would add inconsistencies between the
  gamestate and the rules.

  Ratification CANNOT occur if the required modification to the gamestate
  is not possible or if multiple substantially distinct possible
  modifications would be equally appropriate.

  If the minimal modification would include past or present rule changes,
  they are instead excluded unless the ratified document explicitly and
  unambiguously recites either the changes or the resulting properties of
  the rule(s).

  An internally inconsistent document generally CANNOT be ratified;
  however, if such a document can be divided into a summary section and a
  main section, where the only purpose of the summary section is to
  summarize information in the main section, and the main section is
  internally consistent, ratification of the document proceeds as if it
  contained only the main section.

  Text purportedly about previous instances of ratification (e.g. a
  report's date of last ratification) is excluded from ratification. The
  rules may define additional information that is considered to be part of
  the document for the purposes of ratification; such definitions are
  secured with power threshold 3.

  Ratification is secured with power threshold 3.

}


[This is mostly intended to be a clarification; it shouldn't change how
ratification is supposed to work, except that it explicitly excludes
silent rule changes from the modification (it's currently ambiguous
whether they're excluded or make the whole ratification fail). This also
secures all retroactive changes, where retroactive changes are defined
as altering the game's record of the past. This mirrors the way that
Falsifian found ratification works in eir law thesis.]""")
        }

        proposal(8652) {
            title("Geometry v3")
            ai("1.0")
            author(Secretsnail9)
            coauthors(Jason)
            ordinary()
            sponsored()

            text("""
Create a rule with title "Geometry" and text:
{
  The Geometor is an office. The Geometor is the recordkeepor for polygons
  and polyhedra.

  Polygons are a class of asset. Polygons have a corresponding positive
  integer type. For each integer N >= 3, polygons of type N are a currency.
  A player CAN grant emself a polygon of type N by specifying a valid type
  (N) and paying a fee of N^2 boatloads of coins, where N >= 3 and N is an
  integer.

  At the beginning of each month, each player is granted a polygon of type 3.

  A player CAN once per week conglomerate polygons by announcement,
  specifying 2 polygons e owns. When a player conglomerates polygons, a
  new polygon is created in eir possession with type equal to (the sum
  of the two specified polygons' types) minus one, and then the two
  specified polygons are destroyed.

  The Geometer CAN and SHALL once, by announcement and in a timely fashion
  from the end of the month, increase the score of the player(s) who owned
  a polygon with the largest type among all existing polygons at the end of
  the month by a number of points equal to that type.

  A player can, with support, propagate a specified polygon they do not own
  by paying a fee of 1 polygon they own. A propagated polygon is destroyed,
  causing Agora to be granted a polyhedron with the destroyed polygon's type.

  Polyhedra are an indestructible asset with a positive integer type that
  can only be owned by Agora. All polyhedra not owned by agora are
  immediately transferred to Agora.
}""")
        }

        proposal(8653) {
            title("Device Reconstruction")
            ai("1.0")
            author(ais523)
            ordinary()
            sponsored()

            text("""
In rule 2654, replace:
{{{
    * If a Device has no judge assigned, then any player eligible to
      judge that Device CAN assign it to emself without 3
      objections.
    * The Rulekeepor SHOULD also include any other information which
      e feels may be helpful in the use of the Device in the FLR.
    * Then, the Device changes, following which each active player
      gains 1 card of each type and eir grant (if any).
}}}
with
{{{
    * If a Device has no judge assigned, then any player eligible to
      judge that Device CAN assign it to emself without 3
      objections.
    * Then, the Device changes, following which each active player
      gains 1 card of each type and eir grant (if any).
    * The Rulekeepor SHOULD also include any other information which

  e feels may be helpful in the use of the Device in the FLR.
}}}
[The current version of the rule makes drastic changes to the economy
on a very vaguely defined trigger (possibly dependent on the
Rulekeepor's mental state) which might potentially be set off without
us realising it. This reorders the sections of the rule to make the
trigger something that we have more control over - this is the order I
had in mind when trying to construct the Device originally.]""")
        }

        proposal(8654) {
            title("Cheaters shouldn't prosper")
            ai("1.7")
            author(G)
            ordinary()
            sponsored()

            text("""
[
- clarifies timing of JC grant paragraph
- the default penalty is 2 blots.  a set-complete JC removes 2.5
  blots.  A perp shouldn't profit from their crime by pointing
  at themselves and getting a JC for it.  So this removes self-points
  from the counting.
]

Amend Rule 2478 (Vigilante Justice) by replacing:
  The player who initiated the most Finger Pointings that resulted
  in a Warning, Indictment, or Cold Hand of Justice in the previous
  Agoran Week CAN once grant emself a Justice Card by announcement.
with:
  The player who initiated the most Finger Pointings at other
  players that, in the previous Agoran Week, resulted
  in a Warning, Indictment, or Cold Hand of Justice, CAN once
  grant emself a Justice Card by announcement.""")
        }
    }

    voting {
        votes(nix) {
            FOR on 8645
            PRESENT on 8646
            endorse(Secretsnail9) on 8647
            FOR on 8648
            FOR on 8649
            AGAINST on 8650
            endorse(G) on 8651
            endorse(Secretsnail9) on 8652
            AGAINST on 8653
            FOR on 8654
        }
    }
}
