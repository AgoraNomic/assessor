package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8822to8828() = assessment {
    name("8822-8828")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8822) {
            title("Horse Racing")
            ai("1.0")
            author(Secretsnail9)
            coauthors(Murphy)
            ordinary()

            text(
                """
Enact a new rule with title "Horses" and the following text:

{

Horses are indestructible assets, ownable only by players and Agora. Any
horses owned by the lost and found department are immediately transferred
to Agora.

Alexia, Baxter, Cannon, Destructor, Fargo, Nacho, Rubert, and Sugar are
each a horse. These are their names.

Dollaries (singular: dollary) are a fixed currency. Hooves (singular: hoof)
are a fixed currency.

The Horsened is an office and the recordkeepor of dollaries, hooves, and
horses.

Race Position is a Horse switch with possible values of the integers from 0
(default) to 16, tracked by the Horsened.

Race Place is a Horse switch with possible values of first, second, third,
and none (default), tracked by the Horsened.

A horse is Running if it has a Race Place of none.

When the race starts anew, each horse's Race Position is set to 0, each
horse's Race Place is set to none, all horses are transfered to Agora, all
dollaries and hooves are destroyed, and each player receives 10 dollaries.

}


Enact a new rule with title "The Horses Run" and the following text:

{

The horses Run at the start of each week, unless the horses were not
motivated within the last week.

When the horses run, each player gains 1 hoof, movement resolves, and then
if any horses have a Race Position of 16 and a Race Place of none, those
horses cross the finish line in alphabetical order of their names.

When a horse crosses the finish line:

* If no horse has a Race Place of first, the horse's Race Place is set to
first.

* Otherwise, if no horse has a Race Place of second, the horse's Race Place
is set to second.

* Otherwise, the horse's Race Place is set to third and the race ends, and
no horse can cross the finish line until the horses are next motivated.

}


Enact a new rule with title "Horse Victory" and the following text:

{

When the race ends, the following happen, in order:

* the player that owns the horse with a Race Place of first gains 50
dollaries.

* the player that owns the horse with a Race Place of second gains 30
dollaries.

* the player that owns the horse with a Race Place of third gains 15
dollaries.

* For each horse, each player that got both a jersey and a helmet for that
horse since the last time the race started anew gains 5 dollaries.

* For each horse, each player gains a number of dollaries equal to that
horse's current multiplier * the number of dollaries e bet on that horse
since the last time the race started anew.

* The score of the player that has the most dollaries is increased by 15.
In the event of a tie, instead, no score change occurs.

* The race starts anew.

}


Enact a new rule with title "Horse Multiplier" and the following text:

{

A horse's current multiplier is based on the following chart:

1, 2, 3: The horse's Race Place is first, second, or third, respectively.
O: The horse's Race Place is none and Race Position is 12 or more.
X: The horse's Race Place is none and Race Position is less than 12.


HORSE           1 2 3 O X
--------------------
Alexia          5 4 3 1 0
Baxter          5 4 3 1 0
Cannon          6 5 4 1 0
Destructor      6 5 4 1 0
Fargo           7 6 5 1 0
Nacho           7 6 5 1 0
Rubert          9 8 7 1 0
Sugar           9 8 7 1 0

}


Enact a new rule with title "Weekly Race Actions" and the following text:

{

Each player CAN take one of the following actions (weekly race actions) if
they have not already taken one this week:

* bet 1, 2, or 3 dollaries on a specified horse by paying a fee of 1, 2, or
3 dollaries respectively.

* get a jersey for a specified horse, also specifying a horse to be added
to that horse's pull, by paying 1 hoof.

* get a helmet for a specified horse by paying 1 hoof.

* transfer a specified horse owned by Agora to emself by paying a fee equal
to the horse's cost.

* increase or decrease a specified Running horse's Race Position by 1,
twice, by paying 3 hooves.

* take an action defined as a weekly power of a horse e owns by the rules.

* gain 4 dollaries by announcement.

A player CANNOT bet on a horse with a Race Position of 12 or higher unless
e got a helmet for that horse since the race last started anew.

A player CANNOT get a jersey for a horse e has already gotten a jersey for
since the race last started anew.

A player CANNOT get a helmet for a horse e has already gotten a helmet for
since the race last started anew.

The Horsened's weekly report includes, since the race last started anew,
which horses each player has gotten helmets and jerseys for.

}


Enact a new rule with title "Motivating Horses" and the following text:

{

Any player CAN, by announcement if no player has done so yet this week,
motivate the horses, specifying a random horse (the galloper) and a random
number choice of 1, 2, or 3. When movement resolves, the galloper's Race
Position is increased by 1 a number of times equal to the random number
choice, and then each of the galloper's pulls have their Race Position
increased by 1 in alphabetical order of their names.

The horsened SHALL NOT let a week go by without the horses having been
motivated.

Each horse has an associated non-repeating set of horses, their "pulls",
tracked by the Horsened.

When the race begins anew, the horse's pulls are set to the following:

HORSE           PULLS
------------------------
Alexia          Nacho
Baxter          Fargo
Cannon          Alexia
Destructor      Baxter
Fargo           Alexia, Destructor
Nacho           Baxter, Cannon
Rubert          Alexia, Cannon
Sugar           Baxter, Destructor

}


Enact a new rule with title "Horse Powers" and the following text:

{

Each horse has a power which applies only to the player that owns it (the
owner), and a cost (in dollaries). They are listed below.

HORSE           COST (dollaries)
--------------------
Alexia          10
Baxter          10
Cannon          8
Destructor      8
Fargo           6
Nacho           6
Rubert          4
Sugar           4

Alexia's power: Once per month, the owner CAN take a weekly race action, so
long as e specifies it's via this power in the same message.

Baxter's power: Whenever Baxter moves forward because of being chosen as
the galloper, the owner gains 2 dollaries.

Cannon's power: Once per month, the owner CAN increase Cannon's Race
Position by 1 by announcement, if Cannon is Running.

Destructor's power: Once per month, the owner CAN decrease a specified
Running horse's Race Position by 1, twice, by announcement.

Fargo's power: (WEEKLY POWER)  * get a helmet for and bet 2 dollaries on a
specified horse, by paying 1 hoof.

Nacho's power: (WEEKLY POWER)  * get a jersey for a specified horse, also
specifying a horse to be added to another specified horse's pull, by paying
1 hoof.

Rubert's power: (WEEKLY POWER)  * bet 1, 2, or 3 dollaries on a specified
horse, and if the horse has the lowest race position or is tied for the
lowest race position, increase its race position by 1, 3 times, by paying a
fee of 1, 2, or 3 dollaries respectively.

Sugar's power: (WEEKLY POWER)  * get a helmet for and increase the Race
Position of a specified horse by 1, by paying 1 hoof.

}"""
            )
        }

        proposal(8823) {
            title("Bird Overhaul")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text(
                """
[Getting rid of terms in the bird scrolls that no longer make sense, and
replacing them with new powers.]

Amend Rule 2665 (The Birds) by replacing

"Owl: A specified player (defaulting to the playmate if not

        specified) gains the Grant associated with a specified Ministry."

with

"Owl: A specified bird cannot be played with until next month, rules to

 the contrary notwithstanding.",

replacing

"Pigeon: The playmate gains 2 blots and 1 Blot-B-Gone."

with

"Pigeon: The playmate gains 2 blots.",

replacing

"Penguin: If the playmate is Beast Permitted, e gains
        1 Winsome, 1 Blot-B-Gone, 1 Pendant, and 1 Votive. Otherwise,
        the playmate gains 1 blot, 1 Pendant, and 1 Votive."

with

"Penguin: If the playmate is Beast Permitted, e gains
        6 boatloads of coins. Otherwise,
        the playmate gains 1 blot and 3 boatloads of coins.",

replacing

"Cockatiel: A specified player that is not the playmate gains a
        specified Product."

with

"Cockatiel: A specified player that is not the playmate buys bird food
2 times.",

and replacing

"Jay: The Pended switch of a specified proposal is set to True,
        and that proposal becomes sponsored. The playmate then gains 1
        Votive."

with

"Jay: The voting strength of the playmate on a specified referendum is
increased by 3.""""
            )
        }

        proposal(8824) {
            title("Cleaning Sets Remnants")
            ai("1.0")
            author(Secretsnail9)
            ordinary()

            text(
                """
Repeal Rule 2636 (The Ministor).

Repeal Rule 2621 (VP Wins)."""
            )
        }

        proposal(8825) {
            title("Ticking Stone")
            ai("2.0")
            author(Secretsnail9)
            coauthors(Forest)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by adding another paragraph:
"- Ticking Stone (Monthly, 70%): In the same message as which e wields this
stone, the wielder CAN Flip the Device On or Off by announcement. In the
same message as which e wields this stone, the wielder CAN act on behalf of
the device, by announcement, to take any action the device CAN take by
announcement."

Then, create the Ticking Stone under the ownership of Agora."""
            )
        }

        proposal(8826) {
            title("Dream of Wandering")
            ai("1.0")
            author(Secretsnail9)
            coauthors(Forest, nix, Madrid, Jason)
            ordinary()

            text(
                """
Enact a new rule with the title "Dream of Wandering" and the following text:

{{

The Dreamor is an office; its holder is responsible for keeping track of
the dreams of all active players.

Mindset is a secured active player switch,
tracked by the Dreamor in eir monthly report,
with possible values Dream of Wandering (the default) and any Dream.

An active player CAN Plan to Flip eir own Mindset,
specifying any valid value for eir Mindset, by announcement.
When the rules state that the wandering occurs,
every active player's Mindset is set to the value e most
recently specified by Planning to Flip. If a player did not Plan to Flip
eir Mindset switch since the last wandering, it not Flipped.

The wandering occurs at the beginning of each month.

At any time, each active player is either a Sleeping Dreamer (Default), a
New Dreamer, or a Recurring Dreamer. The state of each player is included
in the Dreamor's monthly report, which SHALL be published in a timely
fashion from the beginning of the month.

If an active player's Mindset is flipped when the wandering occurs, e
becomes a New Dreamer; otherwise, e becomes a Recurring dreamer.

The following rules apply to each active player
based on that player's Mindset:
- Dream of Victory:
  Upon a correct announcement of being the only player with eir Mindset
  Flipped to Dream of Victories, e wins the game. Upon winning the game,
  e has eir Mindset immediately Flipped to the Dream of Wandering and
  becomes a Sleeping Dreamer.
  While e is a New Dreamer, e CAN, once by announcement, gain 10 points,
  then become a Sleeping Dreamer.
- Dream of Wealth:
  While e is a New or Recurring Dreamer, e CAN,
  once by announcement, grant 5 stamps of eir own type to emself,
  then become a Sleeping Dreamer.
- Dream of Justice:
  While e is a New or Recurring Dreamer, e CAN,
  once by announcement, expunge up to 4 blots from emself,
  then become a Sleeping Dreamer.
- Dream of Wandering:
  While e is a Recurring Dreamer, e CAN, once by announcement,
  set eir mindset to a specified Dream, and become a New Dreamer.
- Dream of Machines:
  E CAN Flip the Device to either on or off with Agoran Consent.
  E CAN act on behalf of the device to take any
  action the device CAN take by announcement with 1 support.
- Dream of Beasts:
  E CAN buy bird food by paying a fee of 3 boatloads of coins.
  E CAN buy a Beast Permit by paying a fee of 40 boatloads of coins.
  E CAN renew a Beast Permit by paying a fee of 20 boatloads of coins.
- Dream of Gardens:
  While E is a New or Recurring Dreamer, E CAN once pay a fee of N stamps,
  specifying one stone e owns, and that stone has its escape chance
  reduced by N*5%, to a minimum of 0%, where N is a positive integer,
  then become a Sleeping Dreamer.
  This reduction can only apply to one stone e owns.
  This reduction is removed after
  the Stonemason publishes a collection notice.
- Dream of Power: Eir Voting Strength is 2 greater.

}}"""
            )
        }

        proposal(8827) {
            title("Speckles")
            ai("2.0")
            author(Forest)
            coauthors(nix)
            ordinary()

            text(
                """
Enact a new rule titled "Speckles" with power=2
with the text:
{
Speckles are an indestructible fixed currency with ownership
restricted to persons. A person with 1 or more speckles is Impure,
a person with 0 speckles is Pure.
The Referee is an office, and the recordkeepor for speckles.

To erase a speckle is to destroy it. Destroying speckles is secured
with a Power Threshold of 1.7.

A person CAN, by announcement, create a specified number of speckles
in eir possession.

At the beginning of each month, half (rounded up) of each
player's speckles are destroyed.

For entity A to take N speckles from entity B is to
simultaneously
1. erase N speckles in entity B's possession
2. and create N speckles in entity A's possession.

Speckles can be taken by announcement by clearly and unambiguously
stating the entity to take from and the amount of speckles.

If a player is to take speckles that do not exist,
create those speckles in that player's possession.

Prior to paying a fee of N speckles,
2*N speckles are first created in that player's possession.
}"""
            )
        }

        proposal(8828) {
            title("Speckle Penalty")
            ai("1.7")
            author(Forest)
            coauthors(nix)
            ordinary()

            text(
                """
Enact a new rule titled "Speckle Penalty" with power=1.7
with the text:
{
At the beginning of the month, after speckles are erased, the player(s)
with both:
1. nonzero speckles and
2. the most speckles
each earn 4 blots.For up to two weeks after these blots are awarded to
the players, these players are bespeckled. After those two weeks, they are
no
longer bespeckled.

If a player is bespeckled, they may, by announcement and up to 4 times,
1. pay a fee of 1 boatload of coins or
2. pay a fee of 1 point
to expunge a blot that is in eir possession.
After this is done for the fourth time, a player is no longer bespeckled.
}"""
            )
        }
    }

    voting {
        votes(Secretsnail9) {
            FOR on 8822
            FOR on 8823
            FOR on 8824
            FOR on 8825
            FOR on 8826
            PRESENT on 8827
            AGAINST on 8828
        }

        votes(G) {
            // TODO: resolve conditional vote on all: AGAINST if Madrid voted FOR, else FOR
        }

        votes(juan) {
            FOR on 8822
            FOR on 8823
            FOR on 8824
            FOR on 8825
            FOR on 8826
            FOR on 8827
            AGAINST on 8828
        }

        votes(Madrid) {
            FOR on all
        }

        votes(Jason) {
            AGAINST on 8822
            PRESENT on 8823
            FOR on 8824
            AGAINST on 8825
            AGAINST on 8826
            AGAINST on 8827
            AGAINST on 8828
        }
    }
}