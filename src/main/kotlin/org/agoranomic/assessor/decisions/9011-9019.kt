package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.proposal.DecisionAI
import org.agoranomic.assessor.lib.proposal.ProposalAI
import java.math.BigDecimal

@UseAssessment
fun assessment9011to9018() = assessment {
    name("9011-9019")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)

            powerStone(Janet, 3)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy null
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy null
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy ais523
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy null
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9011) {
            title("Sharing Dreams in the Modern Era")
            ai("2.0")
            author(Zipzap)
            ordinary()

            text(
                """
Rule 2675's current text concerning the Sharing Dream

  > Sharing: Immediately after a wandering, each Sharing Dreamer has eir
points increased by X / Y...

is amended to

  > Sharing: Immediately after a wandering, each Sharing Dreamer has eir
radiance increased by X / Y..."""
            )
        }

        proposal(9012) {
            title("Official security")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 1006 ("Offices") by replacing the sentence

{

Officeholder is an office switch tracked by the ADoP, with possible
values of any person or "vacant" (default).

}

with the following sentences:

{

Officeholder is an office switch tracked by the ADoP, with possible
values of any person or "vacant" (default). Each instance of the
Officeholder switch is secured at the power of the Rule defining the
associated office (or the power of this Rule, if the defining Rule's
power is higher).

}


Amend Rule 2632 ("Complexity") by replacing "Complexity is an office
switch" with "Complexity is a secured office switch"."""
            )
        }

        proposal(9013) {
            title("Cool numbers")
            proposalAI(ProposalAI(BigDecimal("1.0")))
            decisionAI(DecisionAI(BigDecimal("2.0")))
            author(Forest)
            ordinary()

            text(
                """
(this goes to show that numbers are trivially entities: see CFJ 4050)
Create a new rule entitled "Cool Numbers" with power=1
and the following text:
{
Coolness is a number switch with a value of any number.
}
Flip 4's coolness to 4."""
            )
        }

        proposal(9014) {
            title("Back from Extinction")
            ai("1.0")
            author(kiako)
            coauthors(Janet)
            ordinary()

            text(
                """
Enact a rule with title "Laserwort", Power 1, and the text:

{{

   Laserwort (syn. laser, silphium) is a currency with ownership wholly
restricted to players and Agora and is tracked by the Florist. If any
amount of laserwort is owned by the Lost and Found Department or would
otherwise be in abeyance, it is transferred to Agora instead.

   The stock is defined as ten times the number of players.

   If the amount of laserwort that exists is ever greater than the
stock, then an amount owned by Agora equal to the difference is
destroyed (or as many as possible, if less). If the amount of laserwort
that exists is ever less than the stock, than an amount equal to the
difference is created in the possession of Agora.

}}

Amend Rule 2499 ("Welcome Packages") to include the following asset(s):
   - 5 laserwort

Grant to each player 5 laserwort."""
            )
        }

        proposal(9015) {
            title("Beaming Towards Victory")
            ai("1.0")
            author(kiako)
            ordinary()

            text(
                """
If a rule named "Laserwort" exists, then enact a rule with the title
"Antitrust Laws", Power 1 and the text:

{{

   Any player CAN, once per week, pay laserwort equal to one-half the
stock to win the game. When a player wins by this method, the following
occur:
   - For each player with fewer than 5 laserwort, that player gains
laserwort equal to the difference.
   - For each player with more than 5 laserwort, that player loses
laserwort equal to one-half the difference (rounded down).

}}"""
            )
        }

        proposal(9016) {
            title("Alluring Gambits")
            ai("1.0")
            author(kiako)
            coauthors(Janet)
            ordinary()

            text(
                """
If a rule named "Laserwort" exists, then do all of the following:
{

Amend the rule titled "Laserwort" by replacing "ownership wholly
restricted to players and Agora" with "ownership wholly restricted to
players, Agora, and the Flower Pot".

Enact a rule with title "Rafflesia Reclamation", Power 1, and the text:

{{

   Rafflesia is a currency with ownership wholly restricted to players
and Agora and is tracked by the Florist. If any amount of Rafflesia
would be in abeyance, it is destroyed instead.

   The Flower Pot is an entity that holds laserwort as the winning pool
for raffles.

   Any player CAN pay 2 laserwort to the Flower Pot to buy a ticket,
creating a Rafflesia in eir possession. The Florist CAN do so on behalf
of Agora, and SHOULD whenever Agora does not own any Rafflesia.

   The Florist CAN by announcement close the raffle, provided that
raffle has not been closed this month, randomly selecting a player or
Agora, weighted proportionally to the number of Rafflesia e owns (or, if
no Rafflesia exists, selecting Agora with probability 1). When e does
so, one-half (rounded up) of the laserwort owned by the Flower Pot are
transferred to the selected entity, then the remaining amount is
transferred to Agora, then all Rafflesia are destroyed.

   If any Rafflesia exist at the beginning of each month and there has
continuously existed at least some Rafflesia since the beginning of the
month, the Florist SHALL close the raffle in a timely fashion after the
beginning of the month.

   If the amount of laserwort that exists is greater than the stock, the
Florist SHOULD encourage players to buy a ticket or otherwise
incentivise players to buy a ticket.

}}

}"""
            )
        }

        proposal(9017) {
            title("Over 9000 Lumens!")
            ai("1.0")
            author(kiako)
            coauthors(Murphy)
            ordinary()

            text(
                """
If a rule named "Laserwort" exists, then enact a rule with the title "Do
Not Look Directly Into Economy with Remaining Eye", Power 1, and the text:

{{

   Any player CAN, once per week, pay laserwort equal to one-twentieth
the stock (rounded up) to gain 5 radiance.

}}"""
            )
        }

        proposal(9018) {
            title("Rocky Refraction")
            ai("1.0")
            author(kiako)
            ordinary()

            text(
                """
If a rule named "Laserwort" exists, then amend Rule 2645 ("The Stones")
to include the following stone:

{{

   - Prismatic Stone (weekly, 4): When this stone is wielded, one-tenth
of the specified target's (defaulting to Agora, if unspecified)
laserwort is transferred to a specified player (defaulting to the
wielder, if unspecified).

}}"""
            )
        }

        proposal(9019) {
            title("Forum restoration")
            ai("3.0")
            author(Janet)
            coauthors(nix, Kate)
            democratic()

            text(
                """
The instance of the publicity switch possessed by the forum that can be
sent to at "agoranomic at groups.io" is hereby flipped to Public."""
            )
        }
    }

    voting {
    }
}
