package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8657to8664() = assessment {
    name("8657-8664")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Madrid, 8 / 3)
        blotPenalty(Trigon, 6 / 3)
        blotPenalty(nix, 4 / 3)
        blotPenalty(cuddlybanana, 3 / 3)
        blotPenalty(Secretsnail9, 3 / 3)
        blotPenalty(Jason, 3 / 3)

        onOrdinaryProposals {
            powerStone(Jason, 3)
            powerStone(Jason, 3)
        }
    }

    proposals(v4) {
        proposal(8657) {
            title("Schrodinger's report")
            ai("3.0")
            author(Murphy)
            democratic()
            sponsored()

            text("""
Amend Rule 2480 (Festivals) by replacing this text:

  While Agora's Festivity is 0, Festivity is tracked in the
  Tailor's monthly report. Otherwise, it is tracked in the
  Tailor's weekly report.

with this text:

  Festivity is tracked in the Tailor's monthly report. In addition,
  while Festivity is non-zero, the Tailor SHALL announce its value each
  week; a public document purporting to be such an announcement is
  self-ratifying.

[Now that Glitter has been repealed, the existence of the Tailor's
weekly report depends solely on whether a Festival is in progress. I
would rather give up the occasional extra salary than have to deal with
the extra complexity in the ADoP's report.]""")
        }

        proposal(8658) {
            title("SLR Ratification")
            ai("3.0")
            author(Aspen)
            democratic()
            sponsored()

            text("""
Ratify the Short Logical Ruleset published on the 8th of February, 2022,
available here [1].

[1] https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2022-February/015653.html""")
        }

        proposal(8659) {
            title("Speak Like People")
            ai("3.0")
            author(nix)
            coauthors(G, Secretsnail9)
            democratic()
            sponsored()

            text("""
[Reword welcome packages to unambiguously make "grant" work and also add
a keyword for "cashing in" sets, to fix some clunky language.]

Amend R2577 "Asset Actions" by replacing:

  To grant an entity an asset is to create it in eir possession.

with:

  To grant an entity an asset is to create it in eir possession. To
  grant an entity a set of assets is to create each asset in the set
  in eir possession.

Amend R2499 "Welcome Packages" to read in full:

  A Welcome Package is a set of assets containing:

     * 10 boatloads of coins, AND
     * 1 of each type of card defined in the rules.

  Any player CAN grant a Welcome Package to any player if the grantee
  has neither received one since e last registered nor in the last 30
  days.

Ratify that all current players have received a Welcome Package since
they last registered.

Amend R2620 "Cards & Sets" by replacing:

  A player CAN pay a 'set' of X Cards of the same type

with:

  A player CAN pay a 'set' of (syn: "cash in") X Cards of the same
  type""")
        }

        proposal(8660) {
            title("The End of Sets")
            ai("3.0")
            author(nix)
            coauthors(G, Jason, Secretsnail9)
            democratic()
            sponsored()

            text("""
Amend R2621 "VP Wins" by replacing:

  Then, the winds change, following which each active player gains 1
  card of each type and eir grant (if any).

with:

  Then, the winds die down.

Add a new Power=3 rule titled "The Winds Die Down" with the following
text:

  When the wind dies down, the following happen in order:

  * The following rules are repealed in order: R2620 "Cards & Sets",
    R2623 "Popular Proposal Proposer Privilege", R2629 "Victory
    Auctions", R2624 "Card Administration", R2622 "Pending Proposals",
    R2651 "Proposal Recycling", and R2653 "Buying Strength".

  * All rules including the text "~>" and "<~" are amended in
    ascending numerical order by removing all text between and
    including each "~>" and the first following "<~".

  * This rule is repealed.

Amend R2478 "Vigilante Justice" to replace:

  The player who initiated the most Finger Pointings that resulted in
  a Warning, Indictment, or Cold Hand of Justice in the previous
  Agoran Week CAN once grant emself a Justice Card by announcement.

with:

  ~>The player who initiated the most Finger Pointings that resulted
  in a Warning, Indictment, or Cold Hand of Justice in the previous
  Agoran Week CAN once grant emself a Justice Card by announcement.<~

Amend R2499 "Welcome Packages" to replace:

  * 10 boatloads of coins, AND
  * 1 of each type of card defined in the rules.

with:

  * 10 boatloads of coins~>, AND<~
  ~>* 1 of each type of card defined in the rules.<~

Amend 2645 "The Stones" by replacing:

  - Alchemy Stone (weekly, 70%): Destroy four cards you own. If four
    cards were destroyed this way, gain 7 products of your choice.

with:

  ~>- Alchemy Stone (weekly, 70%): Destroy four cards you own. If four
      cards were destroyed this way, gain 7 products of your choice.<~

Amend R1607 "Distribution" by replacing:

  The Promotor CAN distribute a proposal which is in the Proposal Pool
  at any time, but SHALL NOT do so unless it is pending.

  In a given Agoran week, the Promotor SHALL distribute each proposal
  that was in the Proposal Pool and pending at the beginning of that
  week, except for those excepted from automatic distribution by other
  rules, or those that are otherwise removed from the Pool. If there
  are ten or more pending undistributed proposals in the proposal
  pool, the promotor MAY refrain from distributing the most recently
  added 5 proposals if e distributes each other pending proposal in
  that Agoran week.

  If a proposal has been in the proposal pool for more than 7 days and
  is not pending, the Promotor CAN and SHOULD remove it from the Pool
  by announcement.

with:

  The Promotor CAN distribute a proposal which is in the Proposal Pool
  at any time~>, but SHALL NOT do so unless it is pending<~.

  In a given Agoran week, the Promotor SHALL distribute each proposal
  that was in the Proposal Pool ~>and pending<~ at the beginning of
  that week, except for those excepted from automatic distribution by
  other rules, or those that are otherwise removed from the Pool. If
  there are ten or more ~>pending<~ undistributed proposals in the
  proposal pool, the promotor MAY refrain from distributing the most
  recently added 5 proposals if e distributes each other ~>pending<~
  proposal in that Agoran week.

  ~>If a proposal has been in the proposal pool for more than 7 days
  and is not pending, the Promotor CAN and SHOULD remove it from the
  Pool by announcement.<~

Amend R2481 "Festival Restrictions" by replacing:

  4. Non-Festive players CANNOT cause proposals to become Pended.

with:

  ~>4. Non-Festive players CANNOT cause proposals to become Pended.<~

Amend R2555 "Blots" by replacing:

  Any player CAN expunge a blot from a specified person (or emself if
  no one is specified) by paying a fee of one Blot-B-Gone.

  Any player CAN levy a fine of one blot on a specified person by
  paying a fee of two Blot-B-Gones, provided the specified person has
  not already gained two blots or more in the current week.

with:

  ~>Any player CAN expunge a blot from a specified person (or emself
  if no one is specified) by paying a fee of one Blot-B-Gone.<~

  ~>Any player CAN levy a fine of one blot on a specified person by
  paying a fee of two Blot-B-Gones, provided the specified person has
  not already gained two blots or more in the current week.<~

  Any player who has not expunged a blot by this method this week CAN
  expunge 1 blot from a specified player who has not gained a blot
  this week, by announcement ~>unless either of them is a player<~.""")
        }

        proposal(8661) {
            title("Stamps v1.2")
            ai("1.0")
            author(nix)
            coauthors(G, Jason, Trigon)
            ordinary()
            sponsored()

            text("""
Enact a new Power=1 rule titled "Stamps" with the following text:

  Stamps are a category of asset ownable by players and Agora. The
  Collector is an office. The Collector tracks Stamps in eir weekly
  report.

  For each person there is a corresponding type of stamp.

  Any player CAN pay 3 boatloads of coins to grant emself 1 Stamp of
  eir own type.

  Any player CAN pay 1 Stamp of eir own type to grant emself 1
  boatload of coins.

  Any player CAN pay 1 Stamp of another person's type to grant emself
  2 boatloads of coins.

  Any player CAN win by paying N Stamps, where N is the current
  number of active players and each specified Stamp is of a different
  type.

nix becomes the Collector""")
        }

        proposal(8662) {
            title("Birds! v2")
            ai("1.0")
            author(Secretsnail9)
            coauthors(Jason, Telna)
            ordinary()
            sponsored()

            text("""
Create a rule with title "Birds", power 1.0, and the following text:
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

Create a rule with title "Permits", power 1.0, and the following text:
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
  Beast Permitted player is reviewed, if e has niether bought a
  beast permit nor renewed eir beast permit in the past 30 days,
  eir Beast Permitted switch is set to False.

}

Create a rule with title "Playing with Birds", power 1.0, and the following
text:
{

  Except as otherwise specified by the rules, the owner of a bird
  CAN play with it by announcement, specifying any values needed
  to interpret the bird's effects.

  When a bird is played with, the Rule defining that bird applies
  the effects in that bird's scroll, and then that bird is
  transferred to Agora.

}

Create a rule with title "Bird Migration", power 1.0, and the following
text:
{

  A player CAN buy bird food by paying a fee of 5 boatloads of
  coins.

  A player CAN release a specified bird e owns, by announcement.
  When a bird is released, it is transferred to Agora.

  Once per month, a Beast Permitted Player CAN transfer a
  specified bird owned by Agora to emself by announcement.

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


Create a rule with title "One with Nature", power 1.0, and the following
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

  - Magpie: A specified bird that is owned by a player is
    transferred to the playmate.

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

        proposal(8663) {
            title("The Hexeract")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Create a rule with title "Grids" and the following text:
{

  A grid has D dimensions, where D is a positive integer, and where its 1st
  through Dth dimensions are defined in the rules. Each finite dimension has
  a width of W, where W is a positive integer. A dimension is either wrapping
  (syn. wrapped) or not wrapping (default). A dimension is either infinite or
  finite (default).

  A location on a grid is a vector with D dimensions, where D is the number
  of dimensions the grid has, with each dimension having a value as an entry,
  whose Dth entry is a non-negative integer less than the Dth dimension's
  width if the Dth dimension is neither infinite nor wrapping. All entries
  for a given wrapping dimension are equal modulo that dimension's width. For
  example, in a grid 2 Dimensions of widths 2 then 3, [1,2] would be a valid
  location and [2,1] would not be.

  A grid has a space for each location on that grid, and that space has that
  location as a location.

  A space has a location. A space (A) is adjacent to another space in the
  same grid (B) if you could add 1 or subtract 1 from a single entry in B's
  location to get A's location. For example, on a grid with 2 dimensions of
  widths 2 then 3, [1,2] would be adjacent to [1,0] if the grid was wrapping,
  and not adjacent if it is not wrapping.)

}

Create a rule with title "The Hexeract" and the following text:
{

  The Hexeract is a grid with 6 dimensions. The 1st-6th dimensions all have a
  width of 3.

  Each space on The Hexeract has a list of persons that own a fence on it,
  which is initially empty. A person "owns a fence on" a space if e is in the
  list of persons that own a fence on that space. A space on The Hexeract can
  be referred to by its location.

  PlayerSpace is a secured Player switch tracked by the Hexor with possible
  values from the set on all spaces on The Hexeract, defaulting to
  [1,1,1,1,1,1]. For a player to move to a space is to change eir PlayerSpace
  value to that space. A player is on a space if their PlayerSpace value is
  that space.

  Fencehops, Fences, and Movies are each a currency, tracked by the Hexor.

  Whenever a payday occurs, each active player gains 1 Fencehop, 1 Fence, and
  1 Movie.

  A player CAN once a month grant 1 Fencehop, 1 Fence, or 1 Movie to
  specified player by announcement.

  A player CAN, if e has not already done any of the below this week:

     * move to a specified non-fenced space adjacent to the one e is on by
       announcement.

     * move to a specified fenced space adjacent to the one e is on by
       announcement, provided e owns a fence on that space.

     * move to a specified fenced space adjacent to the one e is on without
       objection from any Player who owns a fence on that space.

     * move to a specified fenced space adjacent to the one e is on by paying
       a fee of 1 Fencehop.

     * move to a specified fenced space e owns a fence on by paying a fee of
       3 Fencehops.

  A player CAN Build a Fence by paying a fee of 1 Fence, provided e doesn't
  already own a fence on the space e is on. When e does so, e is added to the
  list of players who own a fence on that space.

  A player CAN Build a Huge Fence by paying a fee of 5 Fences. When e does
  so, e is added to the list of players who own a fence on each space
  adjacent to the one e is on.

  A player CAN move to a specified non-fenced space adjacent to the one e is
  on by paying a fee of 1 Movie.

  A player CAN swap the locations of two specified spaces by paying a fee of
  5 Movies.

  A mountain has a name, defaulting to the location of the space it is on.
  Each space on The Hexeract with the form [A,B,C,D,E,F], where A, B, C, D,
  E, and F are each either 0 or 2 (the 64 corners of the grid) starts out
  with a mountain on it when created.

  Vertokens are an indestructible fixed asset tracked by the Hexor, with a
  specific mountain as a type. There is a distinct type for each mountain
  that currently exists on a space on The Hexeract.

  A player CAN Climb by announcement, provided e is on a space with a
  mountain on it. When e does so, e gains a Vertoken with that mountain as a
  type, unless e already owns one with that type. When a player Climbs, e can
  optionally specify a name for the mountain. If e does so, the mountain on
  the space e is on is renamed to the specified name.

  If a player has exactly 64 Vertokens, e CAN See the Truth by announcement,
  specifying a set of no more than 3 players, provided no person has won the
  game by doing so in the past 30 days. When e does so, the specified players
  win the game. Four days after such a win occurs, all Fencehops, Fences,
  Movies, and Vertokens are destroyed, all spaces are destroyed and replaced
  with new spaces, and all Players move to [1,1,1,1,1,1].

}""")
        }

        proposal(8664) {
            title("Away with the massive points")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 2657 (Scoring) by deleting the text:
{

  * Having submitted an unconditional ballot AGAINST a referendum
    on a sponsored proposal, provided that the ballot is valid at
    the time the referendum is assessed, and provided that the
    outcome of that assessment is ADOPTED:  points equal to the
    voting player's voting strength on the referendum (Assessor).

}""")
        }
    }

    voting {
        votes(juan) {
            // TODO: resolve conditional vote on all: FOR if simple strict majority of all votes resolve to FOR, else present
        }

        votes(nix) {
            FOR on 8657
            FOR on 8658
            FOR on 8659
            FOR on 8660
            FOR on 8661
            FOR on 8662
            AGAINST on 8663
            endorse(Secretsnail9) on 8664
        }

        votes(G) {
            AGAINST on 8657
            AGAINST on 8658
            FOR on 8659
            FOR on 8660
            FOR on 8661
            PRESENT on 8662
            AGAINST on 8663
            AGAINST on 8664
        }

        votes(Jason) {
            FOR on 8657
            PRESENT on 8658
            FOR on 8659
            FOR on 8660
            FOR on 8661
            AGAINST on 8662
            AGAINST on 8663
            FOR on 8664
        }

        votes(Secretsnail9) {
            endorse(Murphy) on 8657
            endorse(Aspen) on 8658
            endorse(nix) on 8659
            endorse(nix) on 8660
            endorse(nix) on 8661
            FOR on 8662
            AGAINST on 8663
            FOR on 8664
        }

        votes(Murphy) {
            FOR on 8657
            PRESENT on 8658
            FOR on 8659
            PRESENT on 8660
            FOR on 8661
            FOR on 8662
            endorse(Secretsnail9) on 8663
            PRESENT on 8664
        }
    }
}
