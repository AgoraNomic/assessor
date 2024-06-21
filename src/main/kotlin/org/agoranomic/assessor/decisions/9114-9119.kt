package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9114to9119() = assessment {
    name("9114-9119")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerStone(nix, 3)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy nix
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy null
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy null
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Jimmy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9114) {
            title("Grind Stone")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by replacing

{
      - Anti-Equatorial Stone (monthly): When wielded, the mossiest
        non-immune stone is transferred to the wielder. If more than one
        such stone is tied for mossiest, a specified one is transferred.
        When this happens, the wielded stone's mossiness is incremented
        by 1.
}

with

{
      - Grind Stone (quarterly): When wielded, if this is the 5th time the
wielder has wielded the Grind Stone (not the recursion stone) since any
other player wielded it, e wins the game.
}"""
            )
        }

        proposal(9115) {
            title("Lode Stone")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by replacing

{
      - Loud Stone (monthly): When wielded, a specified player's
        Dream is set to a specified Dream, and then e is Beguiled;
        Beguiling is secured. A player's Dream CANNOT be flipped if e
        was Beguiled in the last 7 days, rules to the contrary
        notwithstanding.
}

with

{
      - Lode Stone (monthly): If e has wielded this stone in the same
message, any player CAN pay a fee of X-2 Spendies to transfer a specified
stone to emself, where X is the current Stone Cost of the specified stone.
}"""
            )
        }

        proposal(9116) {
            title("A friendly game v2")
            ai("1.0")
            author(snail)
            coauthors(juan, Janet, ais523, Yachay)
            ordinary()

            text(
                """
Enact the following rule with title "Bang!" and the following text:

{
Bangs are a fungible asset.

Vitality is an untracked player Switch with possible values of
Invulnerable, Alive, Unalive, or Ghostly (default). A player with a
Vitality that is not Ghostly is called “corporeal”, else e is called
"ghostly".

To "incarnate" is to flip one's Vitality to Invulnerable. A ghostly player
CAN
incarnate by announcement, provided there are only Invulnerable or Ghostly
players.

Each corporeal player SHOULD list eir Vitality and Bang Balance in all eir
messages.

Any player CAN publish a report of all Bang Balances and Vitalities. Such a
report SHOULD be made and Ratified Without Objection as needed.

Each Alive player CAN eliminate another specified Alive player by paying a
fee of 1 bang. Eliminating a player makes em Unalive, and then grants em 1
bang.

Any Alive player CAN Stand Alone by announcement, if there are no other
players that are Alive, and no person has won the game by doing so in the
past 7 days. When a player Stands Alone, e wins the game. If a player won
the game in this manner 4 days ago, then the match is reset.

When the match is reset, each player is set to Ghostly, all bangs are
destroyed, and then each player gains 1 bang.

When 7 days have passed since the match is reset, all Invulnerable
players have eir Vitality set to Alive.

When 14 days have passed since a player was last eliminated, the match
resets, and then each player that was alive immediately before the match
reset gains 1 bang.
}

The match is hereby reset."""
            )
        }

        proposal(9117) {
            title("Self-Elimination")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[Perhaps someone will find an interesting reason to do this. This proposal
should work with either version of the game.]

Amend the rule titled "Bang!" by replacing every instance of "another
specified Alive player" with "a specified Alive player"

Amend the rule titled "Bang for your Buck" by replacing every instance of
"another specified Alive player" with "a specified Alive player""""
            )
        }

        proposal(9118) {
            title("Recursion")
            ai("1.0")
            author(juniper)
            ordinary()

            text(
                """
Enact the following rule, with the title 'Metarule 1' and the following
text:

{

If a player creates a proposal that passes but e did not vote for eir
own proposal, e obtains 5 spendies.

}"""
            )
        }

        proposal(9119) {
            title("Say It Once Mk II")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
[This proposal quotes text that explicitly includes both references, so
this should be safe against unintended conflicts with other changes.]

Amend rule 1950 (Decisions with Adoption Indices) by, in the text reading:

       Adoption index (AI) is an untracked switch possessed by Agoran
       decisions and proposals, secured at power 2.  For decisions, the
       possible values are "none" (default) or integral multiples of 0.1
       from 1.0 to 9.9. For proposals, the possible values are integral
       multiples of 0.1 from 1.0 to 9.9 (default 1.0).

       The adoption index of a referendum CANNOT be set or changed to
       "none" or to a value less than that of its associated proposal. If
       a referendum ever has an adoption index of "none" or an adoption
       index less than that of its associated proposal, it is immediately
       set to the adoption index of the associated proposal.

       Adoption index is secured with a Power Threshold of 2.

deleting the sentence "Adoption index is secured with a Power Threshold of
2.""""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9114
            FOR on 9115
            FOR on 9116
            FOR on 9117
            AGAINST on 9118
            FOR on 9119
        }

        votes(Yachay) {
            FOR on 9114
            PRESENT on 9115
            FOR on 9116
            FOR on 9117
            AGAINST on 9118
            PRESENT on 9119
        }

        votes(Mischief) {
            FOR on 9114
            FOR on 9115
            FOR on 9116
            FOR on 9117
            PRESENT on 9118
            AGAINST on 9119
        }

        votes(juan) {
            PRESENT on 9114
            PRESENT on 9115
            FOR on 9116
            FOR on 9117
            AGAINST on 9118
            FOR on 9119
        }

        votes(Janet) {
            PRESENT on 9114
            PRESENT on 9115
            AGAINST on 9116
            PRESENT on 9117
            AGAINST on 9118
            FOR on 9119
        }

        votes(Forest) {
            FOR on all
        }

        votes(Jaff) {
            PRESENT on 9114
            FOR on 9115
            FOR on 9116
            FOR on 9117
            PRESENT on 9118
            FOR on 9119
        }
    }
}
