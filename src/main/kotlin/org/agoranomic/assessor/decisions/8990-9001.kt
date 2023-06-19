package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.dsl.votes.powerStone

@UseAssessment
fun assessment8990to9001() = assessment {
    name("8990-9001")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(G, 2)
            powerDream(Aspen, 2)
            powerDream(Forest, 2)
            powerDream(Janet, 2)

            powerStone(ais523, 3)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy Forest
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy nix
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Ricemastor"(3) heldBy Yachay
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy nix
            }
        }
    }

    proposals(v4) {
        proposal(8990) {
            title("Self-referential stone fixes")
            ai("2.0")
            author(Janet)
            coauthors(nix)
            ordinary()

            text(
                """
Amend Rule 2645 by (as a single amendment) replacing "the Soul Stone is
transferred" with "this stone is transferred",  by replacing: "The
Recursion Stone can be wielded" with "This stone can be wielded", and by
replacing "the Anti-Equatorial Stone's mossiness" with "the wielded
stone's mossiness".

[Ensure that these stones don't break when used with the Recursion Stone.]"""
            )
        }

        proposal(8991) {
            title("Reach clarification")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2642 by replacing the paragraph beginning "At the beginning
of each week" with the following paragraph:

{

At the beginning of each week, a player has an active reach if e reached
for a stone in the previous week and that stone is currently owned by
Agora, and the stone reached for by the player with an active reach who
has the highest Modified Rockiness is transferred to em. In a tie, the
stone reached for by the tied player with an active reach who reached first
in
the previous week is transferred. When a player receives a stone in this
way, eir Base Rockiness is set to 0.

}

[Ensure that stones aren't transferred between players due to reaching.]"""
            )
        }

        proposal(8992) {
            title("Camusian Dream v2")
            ai("1.0")
            author(juan)
            ordinary()

            text(
                """
Enact a Power 0.5 rule with title “The Boulder” and text

{
The Absurdor is an office.

The Boulder's Height is a singleton integer switch defaulting to 0,
tracked by the Absurdor.

Each player CAN, once a week, by announcement, push the boulder. When
a player pushes the Boulder, its Height is increased by 1. Players are
ENCOURAGED to do so. The Boulder MUST be pushed at least once a week.

If at any point the height of the Boulder is 100 or more, it is set to 0.
}

Set the complexity of the Absurdor's office to 0."""
            )
        }

        proposal(8993) {
            title("rice knowing you")
            ai("1.0")
            author(G)
            ordinary()

            text(
                """
Repeal Rule 2682 (The Rice Game)."""
            )
        }

        proposal(8994) {
            title("Not Game Theory")
            ai("1.0")
            author(juan)
            ordinary()

            text(
                """
Create a Power 1.0 rule called “The Button” with text:
{
The Buttonmastor is an office.

The Button is a singleton switch tracked by the Buttonmastor with instants
in time as possible values, defaulting to the instant this rule was created.

Buttonclass is a player switch tracked by the Buttonmastor with possible
values Red, Orange, Yellow, Green, Blue, Indigo, Violet or None, defaulting
to None.

A player CAN, once a week, by announcement, press the button.

When a player presses the button, two things happen:

1. The Button is flipped to the instant e did it.

2. That player's Buttonclass is flipped to a value depending on the amount
of hours passed between the previous value of The Button and the current
one, as specified below:

* Less than 24: Red;
* 24 or more, but less than 48: Orange;
* 48 or more, but less than 72: Yellow;
* 72 or more, but less than 96: Green;
* 96 or more, but less than 120: Blue;
* 120 or more, but less than 144: Indigo;
* 144 or more: Violet.

If value of The Button is more than 168 hours in the past, this rule
repeals itself.

Players are ENCOURAGED to brag on their Buttonclass.
}"""
            )
        }

        proposal(8995) {
            title("Broad Recursion")
            ai("2.0")
            author(Murphy)
            coauthors(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by replacing the definition of the
Recursion Stone with:

       - Recursion Stone (Monthly, 4): The Recursion Stone can be wielded
         once per month as if it had the power of any other stone of your
         choice (the Blueprint Stone), with any references to the
         Blueprint Stone itself changed to the Recursion Stone unless
         they specify otherwise."""
            )
        }

        proposal(8996) {
            title("Narrow Recursion")
            ai("2.0")
            author(Murphy)
            ordinary()

            text(
                """
If the proposal "Broad Recursion" (submitted in the same message as this
one) has been adopted or has sufficient voter support to be adopted,
then this proposal has no effect. Otherwise, amend Rule 2645 (The
Stones) by replacing the definition of the Recursion Stone with:

       - Recursion Stone (Monthly, 4): The Recursion Stone can be wielded
         once per month as if it had the power of any other stone of your
         choice (the Blueprint Stone), with any references to the
         Blueprint Stone itself left unchanged unless they specify
         otherwise."""
            )
        }

        proposal(8997) {
            title("Stamp fungibility")
            ai("1.0")
            author(Janet)
            coauthors(Murphy)
            ordinary()

            text(
                """
Amend Rule 2659 by appending the following to the paragraph beginning
"For each person": " Stamps of any given type are a currency."."""
            )
        }

        proposal(8998) {
            title("Stamp fungibility correction")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Ratify the following document:

{

This document is true at the time of ratification (that is, the truth
time is the application time).

The gamestate, other than the ruleset, is what it would be if Rule 2659
("Stamps") had been enacted with its second paragraph reading "For each
person there is a corresponding type of stamp. Stamps with the same type
and owner are fungible." instead of "For each person there is a
corresponding type of stamp.".

The above notwithstanding, the referendum on the proposal causing this
document to be ratified was validly resolved as ADOPTED, and said
proposal is taking effect.

}"""
            )
        }

        proposal(8999) {
            title("Go Home, You're Drunk")
            ai("3.0")
            author(Yachay)
            democratic()

            text(
                """
// Comment: This is a hotfix to the still-open issue of ais' Dancing Around
the Town Fountain scam.
// Comment: Retroactive changes are secured at Power 3, hence the AI of 3.

Retroactively make it so that this rule has been in effect since this
Proposal was created.

Title: No more Dancing
Power: 3
Persons CANNOT Raise the First Speaker in a powerful dance around the Town
Fountain. Then, if Rule 2680 no longer exists, repeal the rule "No more
Dancing"."""
            )
        }

        proposal(9000) {
            title("Brights")
            ai("1.5")
            author(snail)
            coauthors(Janet, ais523, Yachay)
            ordinary()

            text(
                """
[First let's change how radiance resets work. This should reduce the timing
woes of the current system, and encourage spending stamps:]

Amend Rule 2656 (Radiance) to read, in full:
{
      A player's Radiance is an integer player switch defaulting to 0,
      tracked by the Herald. When a player is "granted" or "gains" a
      specified amount of radiance, eir radiance is increased by that
      amount.

      Brights are a currency, tracked by the Herald. When a player wins the
game, e gains 1 Bright. A player with a radiance of 25 or more CAN, by
announcement, gain 1 bright, thereby decreasing eir radiance by 25.

      At the start of each quarter, the player(s) with the highest radiance
each gain 5 brights, and then each player gains X/25 brights, rounded down,
where X is eir radiance. Then, all radiance switches are set to 0, and all
unsealed stamps are destroyed.

If a player would gain radiance less than 7 days before the beginning of a
Quarter, e instead gains 1/(7-X) times that amount, rounded down, where X
is the number of full days before the beginning of the Quarter.
}

[So you get brights when the quarter ends, if you have enough radiance.
What can you do with them? Lots of things!]

Enact a new rule titled "Bright Abilities" at power 1, with the following
text:
{
A player CAN, by paying a fee of 1 bright, increase eir Base Rockiness by 1.

A player CAN, by paying a fee of 1 bright, seal up to 5 specified stamps.

A player CAN, by paying a fee of 2 brights, transfer a specified liquid
asset from the Lost and Found Department to emself.

A player CAN, by paying a fee of 4 brights, increase the radiance of 5
different specified players by 10 each.

A player CAN, by paying a fee of 5 brights, start a new cascade. A player
CAN, by paying a fee of 3 brights, end a specified cascade. If a cascade
was started at least 7 days ago and has not been ended, any player CAN,
by announcement, destroy all brights. Doing so ends all cascades.

A player CAN, by paying a fee of 10 brights, win the game. 14 days after a
player wins the game this way, all brights are destroyed, and then each
player is granted 1 bright.
}

[What's this about sealed stamps? You can protect your stamps from the
quarterly reset by paying brights or radiance, in exchange for only being
able to use them for the non-radiance wincon.]

Amend Rule 2659 (Stamps) to read, in full:
{
      Stamps are a category of asset ownable by players . The
      Collector is an office. The Collector tracks Stamps in eir weekly
      report.

      For each person there is a corresponding type of stamp.

      Sealed is a negative boolean Stamp switch, tracked by the Collector.
To "seal" a stamp is to make it Sealed. To "unseal" a stamp is to make it
not Sealed (syn. unsealed).

Stamps with the same type and Sealed switch value are fungible.

A player with at least 10 radiance CAN, by announcement, seal a specified
stamp e owns, thereby decreasing eir radiance by 10.

      Any player CAN, once per week, pay X  unsealed Stamps, where each
specified Stamp is a different type, to gain (X^2)-X radiance.

      Any player CAN, once per week, pay X unsealed Stamps, where each
Stamp is the same type, to gain (X-1)*2 radiance.

      Any player CAN win by paying N Stamps, where N is the current
      number of active players and each specified Stamp is of a
      different type.
}

[Note: this should be resolved after proposal "Stamp fungibility" if
adopted.]

[I hope these changes seem good and interesting! The balance may be a bit
off, but we can change it as we go, and add and remove bright abilities as
we see fit. There's bound to be some good ones I couldn't think of!]"""
            )
        }

        proposal(9001) {
            title("More Bright Abilities")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
[A separate rule for more powerful abilities, so changing the lower power
ones will be easier.]

Enact a new rule titled "Tier 2 Bright Abilities" at power 2, with the
following
text:

{
A player CAN, by paying a fee of 1 bright, increase the Adoption Index of a
specified Agoran Decision by 1.

A player CAN, by paying a fee of 2 brights, shine strongly. A player's
voting strength on a referendum on an ordinary proposal is increased by 3
if e shined strongly during the referendum's voting period.

A player CAN, by paying a fee of 2 brights, expunge up to 3 blots from a
specified player.

A player CAN, by paying a fee of 3 brights, wield a specified stone, rules
to the contrary notwithstanding.

A player CAN, by paying a fee of 20 brights, Outshine the Sun. The voting
strength of a player on ordinary referenda is increased by 1 if e has ever
Outshined the Sun. This bonus SHOULD be compensated if repealed.
}"""
            )
        }
    }

    voting {
    }
}
