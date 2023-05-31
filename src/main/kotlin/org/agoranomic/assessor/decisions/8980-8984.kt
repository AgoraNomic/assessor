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
fun assessment8980to8984() = assessment {
    name("8980-8984")
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
        proposal(8980) {
            title("Riding with training wheels")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
/* Comment: This is intended to allow players, especially less fluent ones,
to perform (by proxy) actions that they intend to do when they might mess
up the exact wording that they'd need to use to do so. Or, at least, it
adds an explicit flag for review of what they're trying to do and a request
for notification if they've messed up. It's also intended to be very easy
to use, you'd just need to add "I invoke" to a message and you're good to
go.*/

Create the following rule at Power 1 with the title "Invocation":

A player can Invoke by announcement.

When a player Invokes in a message, an attempt to perform an action in that
message is Invocable if all of the following is true:
- Such an attempt has failed to perform an action or it would produce an
effect other than what seems to be its intent.
- Such an attempt is not older than 24 hours.
- Nobody has Responded to that Invocation.
Any player can Respond to the Invocation by acting on the Invoker's behalf
to perform what reasonably would be the intended action of an Invocable
attempt to perform an action.

Players are ENCOURAGED to publicly make it known when an attempt to perform
an action is Invocable, if it hasn't been already."""
            )
        }

        proposal(8981) {
            title("Stone fixes")
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

[Ensure that these stones don't break when used with the Recursion Stone.]


Amend Rule 2642 by replacing the paragraph beginning "At the beginning
of each week" with the following paragraph:

{

At the beginning of each week, a player has an active reach if e reached
for a stone in the previous week and that stone is currently owned by
Agora, and the stone reached for by the player with an active reach who
has the highest Modified Rockiness is transferred to em. In a tie, the
reached for by the tied player with an active reach who reached first in
the previous week is transferred. When a player receives a stone in this
way, eir Base Rockiness is set to 0.

}

[Ensure that stones aren't transferred between players due to reaching.]"""
            )
        }

        proposal(8982) {
            title("Reward the Speaker!")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Enact a new rule at power 2 with the title "Speaker's Strength" and the
following text:

{
The Speaker's voting strength is increased by 1 for referenda on ordinary
proposals.
}"""
            )
        }

        proposal(8983) {
            title("Sacrilege")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Repeal Rule 2680 ("Ritual Paper Dance")."""
            )
        }

        proposal(8984) {
            title("Clarifying Intentions")
            ai("3.0")
            author(nix)
            coauthors(ais523)
            democratic()

            text(
                """
[The current wording seems to suggest that players should say something
like "I intend to register." While effective, it's quite different than
the conventional way of doing most actions. This version disambiguates
that.]

Amend R869 by replacing:

      An Unregistered person CAN (unless explicitly forbidden or
      prevented by the rules) register by publishing a message that
      indicates reasonably clearly and reasonably unambiguously that e
      intends to become a player at that time. No person can be a player
      if e is part of another player or another player is part of em.

with:

      An Unregistered person CAN (unless explicitly forbidden or
      prevented by the rules) register by publishing a message that
      indicates reasonably clearly and reasonably unambiguously eir
      desire to become a player at that time (for example, by saying "I
      register"). No person can be a player if e is part of another
      player or another player is part of em."""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 8980
            AGAINST on 8981
            FOR on 8982
            FOR on 8983
            FOR on 8984
        }

        votes(Beokirby) {
            FOR on all
        }

        votes(nix) {
            AGAINST on 8980
            AGAINST on 8981
            AGAINST on 8982
            FOR on 8983
            FOR on 8984
        }

        votes(inalienableWright) {
            FOR on 8980
            FOR on 8981
            FOR on 8982
            PRESENT on 8983
            FOR on 8984
        }

        votes(Forest) {
            AGAINST on 8983
        }

        votes(Yachay) {
            FOR on 8980
            AGAINST on 8981
            FOR on 8982
            FOR on 8983
            FOR on 8984
        }

        votes(G) {
            AGAINST on 8980
            PRESENT on 8981
            FOR on 8982
            FOR on 8983
            FOR on 8984
        }

        votes(juan) {
            AGAINST on 8980
            PRESENT on 8981
            AGAINST on 8982
            FOR on 8983
            FOR on 8984
        }
    }
}
