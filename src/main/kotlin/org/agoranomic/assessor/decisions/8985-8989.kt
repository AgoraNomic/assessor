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
fun assessment8985to8989() = assessment {
    name("8985-8989")
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
        proposal(8985) {
            title("Democratization (low AI version)")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
/*Comment: I'm fine with rewarding officers and such with more voting
power, but it seems obscene to me when certain players can have almost four
(4!!!) times the voting power of a newbie. It's too greedy, too
controlling, too much.

Let's give everyone a more equal chance to be relevant.

This is a low AI version. Amending the rule that gives players the default
3 Voting Strength would require a AI-3 Proposal, which seems difficult to
pass or at least, it would be very easy to block.*/

If the Proposal named "Democratization (high AI version)" is ADOPTED, then
this Proposal does nothing. Otherwise:

Create a new power-1 rule titled "Democratization" that says:

{Each player has their voting strength increased by 5.}"""
            )
        }

        proposal(8986) {
            title("Democratization (high AI version)")
            ai("3.0")
            author(Yachay)
            democratic()

            text(
                """
/*Comment: I'm fine with rewarding officers and such with more voting
power, but it seems obscene to me when certain players can have almost four
(4!!!) times the voting power of a newbie. It's too greedy, too
controlling, too much.

Let's give everyone a more equal chance to be relevant.

This is the high AI version. This is tidier, as it keeps it all in the same
rule, but it would be harder to pass/easier to block because of its
enormous AI requirement.*/

If the Proposal named "Democratization (low AI version)" is ADOPTED, then
this Proposal does nothing. Otherwise:

Amend the first paragraph of Rule 2422 (Power 3) to read in full:

{The voting strength of an entity on an Agoran decision is an integer
between 0 and 15 inclusive, defined by rules of power 2 or greater. If not
otherwise specified, the voting strength of an entity on an Agoran decision
is 8.}"""
            )
        }

        proposal(8987) {
            title("I meant what I said")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2618 ("Promises") by inserting the following paragraph after
the first paragraph:

{

The creation of promises is secured. The text of a promise CANNOT be
altered after it is created.

}


[Prevent power escalation by modifying existing promises to do other
things.]"""
            )
        }

        proposal(8988) {
            title("Rice rewrite")
            ai("1.0")
            author(Janet)
            coauthors(snail)
            ordinary()

            text(
                """
Amend the rule entitled "The Rice Game" to read, in whole:
{
The Ricemastor is an office.

Rice is a fixed asset tracked by the Ricemastor, with ownership wholly
restricted to players. If a rice would otherwise be in abeyance or is
owned by the Lost and Found Department, it is destroyed.

An active player CAN create a rice plan by announcement once per week,
specifying two sets of players (the rice up set and the rice down set).
When a rice plan is harvested, each active player in the rice up set
gains one rice, then one rice is revoked from each player in the rice
down set (if e has any). The Ricemastor's weekly report includes a list
of rice plans. The creator of a rice plan CAN by announcement destroy
it, thereby causing it to cease to be a rice plan.

An active player CAN by announcement sign a specified rice plan. An
active player's signature is on a rice plan if e has signed it or if a
contract e is party to clearly and unambiguously states that eir
signature is on it. The Ricemastor's weekly report includes, for each
rice plan, a list of players with signatures on it.

A harvest occurs at the beginning of each week. When a harvest occurs,
the following happen in order:
* The rice plan with the most signatures (breaking ties in favor of the
earliest created), if any, is harvested.
* All rice plans are destroyed.

Immediately after a harvest, if a single active player has at least 2
rice and more rice than any other player, e wins the game, then all rice
and rice plans are destroyed. If the game has been won in this manner
three times, this rule immediately repeals itself.
}

[
Changes:
- Generally cleaned up wording
- Handle rice at Lost and Found
- Harvesting a plan now grants rice before revoking (handling the case
where a person is in both the up and down sets)
- Use "CAN" for enabling
- Use a by announcement action or contract for signatures, rather than
"consent"
- Added a clarity requirement for contract-based signatures
- Removed Fancy Caps
]"""
            )
        }

        proposal(8989) {
            title("Rice disarmament")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend the rule entitled "The Rice Game" by replacing "at least 2 rice"
with "at least 5 rice".

[Ensure each round takes at least a month. This works under both the
original rule and the rewrite.]"""
            )
        }
    }

    voting {
        votes(Janet) {
            AGAINST on 8985
            AGAINST on 8986
            FOR on 8987
            FOR on 8988
            FOR on 8989
        }

        votes(snail) {
            AGAINST on 8985
            AGAINST on 8986
            FOR on 8987
            FOR on 8988
            AGAINST on 8989
        }

        votes(Beokirby) {
            AGAINST on 8985
            AGAINST on 8986
            FOR on 8987
            PRESENT on 8988
            AGAINST on 8989
        }

        votes(juan) {
            AGAINST on 8985
            AGAINST on 8986
            FOR on 8987
            FOR on 8988
            FOR on 8989
        }

        votes(ais523) {
            AGAINST on 8985
            AGAINST on 8986
            FOR on 8987
            PRESENT on 8988
            // TODO: resolve conditional vote on 8989: AGAINST if ais523 has 1 or more rice, else FOR
        }

        votes(G) {
            AGAINST on 8985
            AGAINST on 8986
            FOR on 8987
        }

        votes(Forest) {
            FOR on 8985
        }

        votes(nix) {
            AGAINST on 8985
            AGAINST on 8986
            PRESENT on 8987
            PRESENT on 8988
            PRESENT on 8989
        }
    }
}
