package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.InextricableResolvingVote
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9142to9143() = assessment {
    name("9142-9143")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy nix
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Jimmy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Simplifior"(1) heldBy juniper
                "Speaker"(0) heldBy Jaff
                "Spendor"(1) heldBy nix
                "Stonemason"(1) heldBy juniper
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9142) {
            title("Potential Further Absurdity")
            ai("1.0")
            author(Mischief)
            coauthors(Janet)
            ordinary()

            text(
                """
Create a rule entitled "The Veblen" with power 0.5 reading:

       The Veblen is a unique indestructible fixed asset.

       Ownership of the Veblen is entirely restricted to Agora and
       players. If the Veblen is owned by the Lost and Found Department
       or in abeyance, it is immediately transferred to Agora.

       The Veblen Cost is a secured singleton switch with values of
       positive integers and a default of 1.

       Any player CAN pay a fee of X Spendies to transfer the Veblen to
       to emself, where X is a value greater than or equal to the
       current Veblen Cost. Upon doing so, e gains ownership of the
       Veblen, and the Veblen Cost is set to X+1.

       The Veblen Cost and the ownership of the Veblen are tracked by
       the Absurdor.

       The owner of the Veblen SHOULD conspicuously show off eir
       ownership of it from time to time."""
            )
        }

        proposal(9143) {
            title("A new duel")
            ai("1.0")
            author(Janet)
            coauthors(Mischief)
            ordinary()

            text(
                """
All bangs are hereby destroyed. The vitality of each player hereby
becomes ghostly.

Amend the Rule entitled "Bang!" to read as follows:

{
Vitality is an untracked player switch with possible values of alive,
unalive, and ghostly (default). Bangs are a fungible asset.

Match state is an untracked singleton switch with possible values none
(default), initializing, and ongoing. If the match state is none and has
not changed in the past 7 days, a player CAN by announcement flip it to
initializing. When the match state is flipped to none or to
initializing, each player becomes ghostly (if e is not already), then all
bangs are destroyed.

While the match state is initializing:
* A player CAN by announcement incarnate, thereby flipping eir vitality
to alive.
* A player CAN by announcement trigger the match, provided the match
state has not changed in the past 7 days.
* At the beginning of each Agoran week, if any player triggered the
match in the previous Agoran week, and if there at least three alive
players, the match state is flipped to ongoing, after which each alive
player gains a bang.

If the match state is ongoing, no player has won the game as a result of
this Rule in the past 28 days, and a single player is alive, that player
CAN stand alone by announcement. When a player stands alone, e wins the
game. If a player won the game in this manner 4 days ago, then the match
state is flipped to none (if it is not already).

When a player takes an action that causes one or more vitalities or bang
balances to change, e SHOULD recite all such changes in the same message
as which e takes that action. A document reciting all bang balances and
vitalities SHOULD be published and ratified as needed.
}

Enact a new rule at power 1 entitled "Bang actions" with the following text:
{
While the match state is ongoing, a player CAN by announcement load a
round, specifying a document (the sealed orders), provided that e has
not done so in the current Agoran week.

While the match state is ongoing, a player CAN by announcement fire a
round, specifying a document (the revealed orders), provided that all of
the following are true:
* E was an alive player at the beginning of the current Agoran week.
* E has not done so in the current Agoran week.
* In the previous Agoran week, e loaded a round with sealed orders that
are a fingerprint for the revealed orders.
* The order list explicitly and unconditionally specifies a single
clear, unambiguous, and unconditional list of persons to target (the
target list).

When a player (the shooter) fires a round, sequentially for each person
(the target) in the target list, if the shooter is alive and has two
bangs, and the target is an alive player, then two of the shooter's
bangs are destroyed, after which the target is eliminated.

When a player is eliminated, if eir vitality is alive, then the
following happen in order:
* Eir vitality is flipped to unalive.
* E gains one bang.

A player who loaded a round in one Agoran week SHALL, within the first
four days of the next Agoran week, fire a round, provided the match
state has not changed during either period; failure to do so is the
class 1 infraction of wasting ammunition.

If the match state is ongoing and has not changed in the past 7 days,
and if no player has loaded a round or fired a round in this Agoran week
or the previous two Agoran weeks, then the match state becomes none.
}

[
A complete rewrite of bangs with many changes, including but not limited to:
* Petty capitalization changes.
* Remove "CAN publish".
* Explicitly have match phases.
* Slow down the game a lot.
* Actions peformed with hashing rather than first-come first-serve.
]"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9142
            endorse(Janet) on 9143
        }

        votes(juan) {
            InextricableResolvingVote on 9142 comment "endorsement of self"
            PRESENT on 9143
        }

        votes(Mischief) {
            FOR on 9142
            FOR on 9143
        }

        votes(Janet) {
            AGAINST on 9142
            FOR on 9143
        }
    }
}
