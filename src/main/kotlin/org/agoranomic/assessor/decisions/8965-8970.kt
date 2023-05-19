package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8965to8970() = assessment {
    name("8965-8970")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(G, 2)
            powerDream(Aspen, 2)
            powerDream(Forest, 2)
            powerDream(Janet, 2)

            powerStone(Janet, 3)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy nix
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy nix
            }
        }
    }

    proposals(v4) {
        proposal(8965) {
            title("Registrar Tracks Birthdays")
            ai("1.0")
            author(nix)
            ordinary()

            text(
                """
[For a while I was both Herald and Registrar, so I kept track of
birthdays in the same documents that I kept track of active players.
Since Registrar was taken over by someone else, I've clearly been much
worse at tracking them. It makes more sense to put this with the office
that already tracks earliest registration dates (which are the
definition of birthdays).

Amend R2585 by replacing:

      In a timely manner after the start of a player's Agoran Birthday,
      the Herald SHALL announce it.

with:

      In a timely manner after the start of a player's Agoran Birthday,
      the Registrar SHALL announce it."""
            )
        }

        proposal(8966) {
            title("8639 rerun")
            ai("3.0")
            author(Janet)
            coauthors(G)
            democratic()

            text(
                """
Set the power of Rule 879 ("Quorum") to 3.

[Proposal 8639 (https://agoranomic.org/assessor/proposal/8639.txt)
failed to make this change because it used "amend" for a power change.]"""
            )
        }

        proposal(8967) {
            title("Campaign Please")
            ai("2.0")
            author(nix)
            ordinary()

            text(
                """
[This adds text with no real mechanical impact, but may clarify how we
would like elections to run for newer players.]

Amend R2154 (Election Procedure) by adding, after the first paragraph:

       Each candidate in an election is ENCOURAGED to campaign by
       indicating why e would be the best choice, and (if applicable)
       how e would run the office differently than the previous holder.
       The ADoP SHOULD remind candidates to campaign."""
            )
        }

        proposal(8968) {
            title("April Awards Extension")
            ai("1.0")
            author(snail)
            coauthors(nix, Aspen, G)
            ordinary()

            text(
                """
Amend Rule 2582 (Annual Awards) by replacing:
{
      The following Patent Titles CAN be awarded by the indicated
      Officers with 2 Agoran consent, provided the intent to make
      the awards is announced during awards month, and the award is
      made to commemorate acts performed in the previous Agoran year.
      The full name of each awarded Patent Title is [Title Below] NNNN,
      where NNNN is the year each act was performed.
}
with
{
      The following Patent Titles CAN be awarded by the indicated Officers
with 2 Agoran consent. The Patent Titles SHOULD be awarded during Awards
Month, and the award SHOULD be made to commemorate acts performed in the
previous Agoran year. The full name of each awarded Patent Title is [Title
Below] NNNN, where NNNN is the year each act was performed.

The Herald SHALL announce it is Awards Month in an officially timely
fashion after it begins. E SHOULD petition officers to award their awards
if they have not done so by the end of Awards Month.
}.

[The restriction on making award intents during Awards Month causes more
problems than it's worth: this version is more flexible in case deadlines
are missed and adds herald-induced reminders to get the awards out on time.]"""
            )
        }

        proposal(8969) {
            title("The Rice Game")
            ai("1.0")
            author(Yachay)
            coauthors(nix)
            ordinary()

            text(
                """
/* Comment: This is intended to be a game that intends to be a very
simplified, "arcade" version of a nomic that is entirely dominated by the
overwhelming power of proposals, rather than the rules and subgames they
create. Rice is a stand-in for any sort of point/resource/power/achievement
score or tally, Rice Plans are stand-ins for Proposals, Signatures are
stand-ins for votes. */

Create a rule called "The Rice Game" at Power 1, and the following text:
{
The Ricemastor is an office, in charge of tracking Rice, Rice Plans and
Signatures. Rice is a fixed asset, ownable only by players. Any active
player can create a Rice Plan by announcement, if e hasn't done so yet in
the current week. Rice Plans can have Signatures, and each Signature must
be of an active player. A Rice Plan has an active player's Signature as
long as that player is consenting to it. An active player can destroy a
Rice Plan that e has created by announcement.

A Harvest occurs at the beginning of each week. When this occurs:
- If there is only one Rice Plan with the most Signatures, that Rice Plan
is Harvested.
- If there is more than one Rice Plan with the most Signatures, the one
that was created earliest is Harvested.
- In all other cases, nothing happens.
And then all Rice Plans are destroyed and the Harvest ends.

Rice Plans consist of two lists of players, with each list having no
repeated players, and the lists can be empty. One of these lists is its
Rice Up list, and the other is its Rice Down list. When a Rice Plan is
Harvested, for each player listed in its Rice Up list, if that player is
active, e gains 1 Rice; and for each player listed in its Rice Down list,
if e has at least 1 Rice then e lose 1 Rice.

If after a Harvest there is a single active player with at least 2 Rice and
more Rice than any other player, then that player wins the game, and all
Rice is destroyed. When the game has been won in this manner three times,
this rule repeals itself.
}

Yachay becomes the Ricemastor."""
            )
        }

        proposal(8970) {
            title("Black Ribbon & Friends")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
For each active player that voted FOR this Proposal, if they don't own a
Black Ribbon, award them a Black Ribbon. If they already own a Black
Ribbon, grant them 2 Stamps of the Aristotle type instead."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8965
            FOR on 8966
            FOR on 8967
            FOR on 8968
            FOR on 8969
            AGAINST on 8970
        }

        votes(Forest) {
            PRESENT on 8969
            PRESENT on 8970
        }
    }
}
