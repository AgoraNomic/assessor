package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8911to8913() = assessment {
    name("8911-8913")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy nix
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Horsened"(1) heldBy snail
                "Mad Engineer"(1) heldBy Janet
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy nix
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8911) {
            title("Player-Defined Nonsense")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Do you want to be able to just send "ANGER" to a-b, and for it to mean "I
object to every intent to declare apathy."?
Or "I floop" to motivate the horses, or "Ohgodnotanother" to mean "I submit
the following proposal:"?

Well, now there's this rule! Enact it so you can do these things! WOW!
AMAZING!

Enact a rule entitled "Player-Defined Nonsense" with power=1.0 and the text:
{
The Madman is an office that tracks Player-Defined Nonsense.
The Handle is a secured player switch that contains text.
The Lookup is a secured player switch that contains text.
Each player CAN, once per week by announcement, set their Handle
to any text without whitespace that is not any other Handle.
Each player CAN, once per week by announcement, set their Lookup
to any text.

ONLY when interpreting game-actions (not reports, rules-text, proposal
text, CFJs, or the like),
for each instance of any Handle in full, surrounded by punctuation,
replace it with that player's Lookup.
}

But 4st, what about overwriting certain game actions?!
This isn't a bug, it's a feature!

Remember, always be voting!

(ohgodwhydoIkeepmakingofficesformyself)"""
            )
        }

        proposal(8912) {
            title("How'd that get there?")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2672 (Weekly Race Action) by replacing

       "get a jersey for a specified horse by paying 1 hoof, also
specifying a horse which is thereby added to that horse's pull, by paying 1
hoof."

with

       "get a jersey for a specified horse, also specifying a horse which
is thereby added to that horse's pull, by paying 1 hoof."

[The last fix made a bug so here's a fix for the bug fix bug.]"""
            )
        }

        proposal(8913) {
            title("emself v2")
            ai("3.0")
            author(G)
            coauthors(Murphy)
            democratic()

            text(
                """
Amend Rule 2466 (Acting on Behalf) by appending the following paragraph:
      An agent CANNOT act on behalf of a principal to perform an
      action via a specific method if the rules state that the actor
      acts "as emself" or "on eir own behalf" to perform the action via that
      method.

[supporting both usages]"""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 8911
            FOR on 8912
            FOR on 8913
        }

        votes(Janet) {
            AGAINST on 8911
            PRESENT on 8912
            endorse(G) on 8913
        }

        votes(Forest) {
            AGAINST on 8911
            endorse(G) on 8912
            endorse(juan) on 8913
        }

        votes(juan) {
            FOR on 8911
            PRESENT on 8912
            endorse(G) on 8913
        }
    }
}
