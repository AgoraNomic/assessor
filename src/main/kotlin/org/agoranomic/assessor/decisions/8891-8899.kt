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
import org.agoranomic.assessor.lib.vote.VoteKind.*
import java.math.BigDecimal

@UseAssessment
fun assessment8891to8899() = assessment {
    name("8891-8899")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerStone(snail, 6)
            powerStone(Murphy, 3)

            powerDream(Forest, 2)
            powerDream(G, 2)
            powerDream(snail, 2)

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
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy null
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Murphy
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8891) {
            title("Destroy current administrative regulations")
            ai("1.0")
            author(Forest)
            coauthors(snail, nix, Janet, G, Aspen)
            ordinary()

            text(
                """
Remove all Administrative Regulations."""
            )
        }

        proposal(8892) {
            title("Destroy Contracts, Promises, and Pledges")
            ai("1.0")
            author(Forest)
            coauthors(nix, Janet, snail, G)
            ordinary()

            text(
                """
Destroy every contract, Promise, and Pledge."""
            )
        }

        proposal(8893) {
            title("Stonemason Fairness")
            ai("2.0")
            author(Forest)
            coauthors(snail, Janet)
            ordinary()

            text(
                """
Amend Rule 2643 ("Collecting Stones") by replacing:
{
When a Collection Notice is published, for each player eir
non-immune stone with the highest slipperiness equal to or above
the Escape Minimum is transferred to Agora. If there is a tie, the
Stone Mason selects which one escapes.
}
with:
{
When a Collection Notice is published, for each player eir
non-immune stone with the highest slipperiness equal to or above
the Escape Minimum is transferred to Agora. If there is a tie, the
Stone Mason randomly selects which one escapes.
}"""
            )
        }

        proposal(8894) {
            title("Load Lightening")
            ai("3.0")
            author(nix)
            democratic()

            text(
                """
Amend R2608 by replacing "The Notary's weekly report contains:" with
"The Notary's monthly report contains:".

Amend R2493 by replacing "Regulations are tracked by the Rulekeepor as
part of eir weekly and monthly reports in a fashion similar to rules."
with "Regulations are tracked by the Rulekeepor as part of eir monthly
report in a fashion similar to rules."

Repeal R2510 (Such is Karma)."""
            )
        }

        proposal(8895) {
            title("Ratifying the Ruleset")
            ai("3.0")
            author(RLee)
            democratic()

            text(
                """
Agora Ratifies that the Short Logical Ruleset published by Janet on
December 4,  2022 in Agoran Time was an accurate statement of the Rules at
that time. This may lead to changes to the Rules so that the Rules at the
publication of December 4 are amended to become consistent with that
Ruleset."""
            )
        }

        proposal(8896) {
            title("It would make me happy")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Snail earns a black ribbon.

[I'd be very grateful to anyone who votes FOR this proposal.]"""
            )
        }

        proposal(8897) {
            title("Does This Potato Kinda Look Like a Pyramid to You?")
            ai("2.0")
            author(nix)
            coauthors(RLee)
            ordinary()

            text(
                """
Amend R2645 by replacing the paragraph that starts with "-Hot Potato
Stone" to read in full:

       - Hot Potato Stone (Weekly, 5):  When this stone is wielded, the
         wielder gains 5 points, every other player who has wielded it
         since Agora last owned it gains 1 point, and it is transferred
         to the specified eligible player. An eligible player is one who
         has not owned this stone since the last time Agora owned it. If
         this  stone is not owned by Agora, it cannot otherwise be
         transferred, other rules notwithstanding. Wielders are
         ENCOURAGED to list all previous wielders. This stone is immune
         if 3 or more players have wielded it since the most recent
         collection notice."""
            )
        }

        proposal(8898) {
            title("Rockier Gardens")
            ai("2.0")
            author(nix)
            coauthors(snail)
            ordinary()

            text(
                """
[The current system for stones is unbalanced. The system in this
proposal creates a sort of investment-based auction, where each player
has a default investment of 0, a handicap of -1 for each stone e owns,
and gains 1 each week that e has the garden dream. Then each week,
players can "reach" for a specified stone, and the player with the
highest value (timing tiebroken) gets eir specified stone. It also makes
the mossiness of a stone Agora owns irrelevant, so you can reach for any
it owns.]

Amend R2642 to read in full:

     Base Rockiness is a player switch, with values of integers and
     default of 0, tracked by the Stone Collector. A player's Modified
     Rockiness is eir Base Rockiness minus the number of stones e owns.

     Once a week each player CAN "reach" for a specified stone owned by
     Agora by announcement.

     At the beginning of each week, the stone specified by the player
     with the highest Modified Rockiness that reached for a stone in the
     previous week is transferred to em. In a tie, the stone specified by
     the tied player who reached first is transferred to em. When a
     player receives a stone in this way, eir Base Rockiness is set to 0.

Amend R2643 by replacing "The mossiness of all stones that are not
transferred" with "The mossiness of all stones not owned by Agora"

Amend R2675 (Dream of Wandering) by replacing the paragraph that starts
with "- Gardens" with:

     - Gardens: Immediately after a wandering, the Base Rockiness of each
                Gardens Dreamer is increased by 1."""
            )
        }

        proposal(8899) {
            title("3rd Time's not the charm")
            proposalAI(ProposalAI(BigDecimal("1.0")))
            decisionAI(DecisionAI(BigDecimal("2.0")))
            author(snail)
            coauthors(Janet)
            ordinary()

            text(
                """
Amend Rule 2668 (Horses) by replacing

{
Race Position is a Horse switch with possible values of the
integers from 0 (default) to 16, tracked by the Horsened.
}

with

{
Race Position is a Horse switch with non-negative integer
possible values, defaulting to 0, tracked by the Horsened.
}


Amend Rule 2669 (The Horses Run) by replacing "if any horses have a Race
Position of 16" with "if any horses have a Race Position of 16 or more".

Amend Rule 2672 (Weekly Race Action) by replacing "by 1, twice" with "by 2".

Amend Rule 2673 (Motivating Horses) by replacing "increased by 1 a number
of times equal to the random number choice" with "increased by the random
number choice".

Amend Rule 2674 (Horse Powers) by replacing "by 1, twice" with "by 2" and
by replacing "by 1, 3 times" with "by 3"."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8891
            FOR on 8892
            FOR on 8893
            FOR on 8894
            FOR on 8895
            FOR on 8896
            FOR on 8897
            FOR on 8898
            FOR on 8899
        }

        votes(Janet) {
            AGAINST on 8891
            AGAINST on 8892
            AGAINST on 8893
            FOR on 8894
            PRESENT on 8895
            AGAINST on 8896
            AGAINST on 8897
            FOR on 8898
            FOR on 8899
        }

        votes(G) {
            AGAINST on 8895
        }
    }
}
