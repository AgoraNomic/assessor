package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8972to8979() = assessment {
    name("8972-8979")
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
                "Ricemastor"(3) heldBy Yachay
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Yachay
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy nix
            }
        }
    }

    proposals(v4) {
        proposal(8972) {
            title("Yes we are EFFECTIVE!")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2152 ("Mother, May I?") by replacing "CAN, POSSIBLE:" with
"CAN, POSSIBLE, EFFECTIVE, VALID:" and by replacing "MAY:" with "MAY,
LEGAL, PERMISSIBLE:".

[Define the positives for all negative terms in R2152. "EFFECTIVE" in
particularly is necessary for R2471/3 to work.]"""
            )
        }

        proposal(8973) {
            title("Not so welcome anymore")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2499 ("Welcome Packages") by removing "* the number of hooves
the player(s) with the most hooves has"."""
            )
        }

        proposal(8974) {
            title("Plan B")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2657 by, as a single amendment, removing the list items and
bullet points for the list items starting with each of the following:
"Charity", "Sharing, "Wealth".

Repeal Rule 2499 ("Welcome Packages").

Repeal Rule 2659 ("Stamps").

Repeal Rule 2680 ("Ritual Paper Dance").

Repeal Rule 2656 ("Radiance").


[Given a new player winning within a month and a half by stamps by
simply trading, something needs to change, and with no other radiance
conditions existing, something needs to change. It doesn't need to be
this, and I don't necessarily *want* it to be this, but the status quo
is clearly not working.]"""
            )
        }

        proposal(8975) {
            title("De-regulating")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2125 by replacing "The Rules SHALL NOT be interpreted so as
to proscribe unregulated actions." with "The Rules are not to be
interpreted so as to proscribe unregulated actions.".

[This doesn't need to be an actual crime.]


Amend Rule 2125 by appending the following paragraph:

{

The above notwithstanding, sending a message (in general or with
specific attributes) is never a regulated action; however, the rules may
be interpreted so as to proscribe sending public messages (in general or
with specific attributes).

}

[Clarify this (sending a message being regulated would be very bad) and
allow prohibiting the sending of messages (e.g. for No Faking).]"""
            )
        }

        proposal(8976) {
            title("Ruleset convergance")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2202 ("Ratification Without Objection") to read, in whole:

{

A public document is part (possibly all) of a public message.

A player CAN, without objection, ratify a specified public document.

Ratification Without Objection CANNOT cause the repeal, amendment,
enactment, or mutation of any Rule, rules to the contrary notwithstanding.

A player SHALL NOT knowingly use or announce intent to use Ratification
Without Objection to ratify a (prior to ratification) document
containing incorrect or Indeterminate information when a corrected
document could be produced with reasonable effort, unless the general
nature of the document's error and reason for ratifying it is clearly
and plainly described in the announcement of intent. Such ratification
or announcement of intent to ratify is the Class 8 Infraction of
Endorsing Forgery.

}


Amend Rule 2422 ("Voting Strength") to read, in whole:

{

The voting strength of an entity on an Agoran decision is an integer
between 0 and 15 inclusive, defined by rules of power 2 or greater. If
not otherwise specified, the voting strength of an entity on an Agoran
decision is 3.

When multiple rules set or modify an entity's voting strength on an
Agoran decision, it shall be determined by first applying the rule(s)
which set it to a specific value, using the ordinary precedence of
rules, and then applying the rules, other than this one, which modify
it, in numerical order by ID. Finally, if the result of the calculation
is not an integer, it is rounded up, and then if it is outside the
allowable range of values for voting strength, it is set to the minimum
value if it was less and the maximum value if it was more.

}


Amend Rule 2139 ("The Registrar") to read, in whole:

{

The Registrar is an office; its holder is responsible for keeping track
of players.

The Registrar's weekly report includes:

1. A list of all players, including information sufficient to identify
and contact each player.

2. The date on which each player most recently became a player.

3. For each forum with non-Foreign publicity, sufficient instructions
for players to receive messages there.

The Registrar's monthly report includes:

1. For each former player for which the information is reasonably
available, the dates on which e registered and deregistered.

}


Amend Rule 103 ("The Speaker") to read, in whole:

{

The Speaker is an imposed office and the figurehead leader of Agora. The
player or players who have most recently won the game are called
Laureled. If at any time the office of Speaker is vacant, or when one or
more players win Agora, then the Prime Minister CAN once appoint a
Laureled player to the office of Speaker by announcement.

Whenever the Prime Minister CAN appoint a Laureled player to the office
of Speaker, e SHALL do so in a timely manner, except that the Prime
Minister MAY defer appointing a new Speaker while there is pending one
or more open CFJs that could plausibly determine or affect the question
of whether a player is Laureled.  If the Prime Minister is emself
Laureled, eir power to appoint a Speaker continues for the entirety of a
message in which e resigns as Prime Minister, and if e is the only
Laureled player, e CAN void that power, and thereby discharge the
obligation to use it, by announcing that e declines to take the office.

If the office of Speaker has been held continuously by the same person
for the past 90+ days, then any player CAN appoint another player to the
office with support.

}


[Reset the above rules to what they should be and were thought to be
before the insufficient power errors were discovered.]"""
            )
        }

        proposal(8977) {
            title("Expedited Proposals")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
[Expedited proposals can be useful for bugfixes, counter-scams, or changes
we can unanimously agree are wanted quickly, so this is a proposal to
implement them safely.]

Amend Rule 2606 (Proposal Classes) to read in full:
{
      Proposals created since the enactment of this rule have a secured
      untracked Class switch with possible values ordinary (the default),
expedited, and democratic.

      When a proposal with an adoption index greater than or equal to
      3.0 is created, its class becomes democratic.

      Each player CAN, with 2 Agoran consent, flip an ordinary proposal's
      class to democratic, provided it is in the Proposal Pool or
      that there is a referendum on it whose voting period has not yet
      ended.

      Each player CAN, with 2 support, flip an ordinary proposal's class to
expedited, provided it is in the Proposal Pool and e has not done so yet
this week. Each player CAN, by announcement, flip an expedited proposal's
class to ordinary, but SHOULD only do so if the proposal is not a bugfix,
emergency, or time-sensitive issue, or if e sees an issue with the proposal.

     Each player CAN distribute an expedited proposal, by announcement.
Each player CAN act on behalf of the Assessor to resolve an unresolved
referendum on an expedited proposal, provided that referendum has no valid
AGAINST ballots cast on it.
}

[Note that democratic (AI 3+) proposals can't be expedited.]"""
            )
        }

        proposal(8978) {
            title("Authorized initiation")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 107 ("Initiating Agoran Decisions") by replacing "A public
notice purporting to initiate an Agoran decision is a self-ratifying
attestation of the notice's validity." with "A public notice purporting
to initiate an Agoran decision is a self-ratifying attestation that the
notice was valid, that the person (if any) publishing the notice was
authorized to initiate the decision, and that such a decision was
initiated.".

[The notice being "valid" is not enough for the decision to have been
initiated, so also ratify that there was authorization and that the
decision was actually initiated. Luckily this shouldn't matter
historically because Rule 2034 ensures that the decision is ratified
into existence at resolution.]"""
            )
        }

        proposal(8979) {
            title("Rationalized Impartial Commencement Equality")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
If all of the following is true:
- An office called the "Ricemastor" exists
- Undercooked players exist (be the "Rice Time" the time between the moment
that "The Rice Game" rule was added to the ruleset, and the 24 hours
posterior, and all players that had gained Rice during that period be known
as "Undercooked" players).
Then, set the Rice of all Undercooked players to 0.

Otherwise, this Proposal does nothing."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8972
            FOR on 8973
            AGAINST on 8974
            FOR on 8975
            FOR on 8976
            FOR on 8977
            FOR on 8978
            FOR on 8979
        }

        votes(Yachay) {
            FOR on 8972
            FOR on 8973
            AGAINST on 8974
            FOR on 8975
            FOR on 8976
            AGAINST on 8977
            AGAINST on 8978
            FOR on 8979
        }

        votes(Forest) {
            FOR on 8976
        }
    }
}
