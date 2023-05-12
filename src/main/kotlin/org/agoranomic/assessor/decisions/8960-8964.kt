package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8960to8964() = assessment {
    name("8960-8964")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(G, 2)
            powerDream(Aspen, 2)
            powerDream(Forest, 2)

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
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8960) {
            title("Ritual disambiguation")
            ai("1.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2680, amend
{{{
      When a positive integral multiple of 41 is anointed as a ritual
      number for the first time, the person who does so CAN, by
      announcement, Raise the First Speaker in a powerful dance around
      the Town Fountain. Doing so causes each player qualifying under
      this Rule to gain 1 radiance.
}}}
to
{{{
      For each positive integral multiple of 41, when that number is
      anointed as a ritual number for the first time, the person who
      does so CAN, by announcement, Raise the First Speaker in a
      powerful dance around the Town Fountain. Doing so causes each
      player qualifying under this Rule to gain 1 radiance.
}}}"""
            )
        }

        proposal(8961) {
            title("now you don't see it")
            ai("1.0")
            author(G)
            ordinary()

            text(
                """
Re-enact Rule 2056 (Invisibilitating) with the following text:

      Invisibilitating is a Class 1 infraction.


[
Rule 2056 history (confirmed by checking archives):

Enacted (Power=1) by Proposal 4513 "Invisibilitating" (Steve), 10 July 2003.
Repealed by Proposal 4759 "Olive Repeals" (Manu, Sherlock), 15 May 2005.
]"""
            )
        }

        proposal(8962) {
            title("Please behave, Prime Minister")
            ai("1.0")
            author(Yachay)
            ordinary()

            text(
                """
Remove the last sentence of rule 2463."""
            )
        }

        proposal(8963) {
            title("hats")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Enact a new rule with the text
"hats are an untracked player switch that can have any value ever.""""
            )
        }

        proposal(8964) {
            title("Minty Stone")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by replacing

{{
      - Jockey Stone (monthly, 3): When wielded, a specified Running
        horse's Race Position is increased by 1.
}}
with
{{
      - Minty Stone (weekly, 4): When wielded, a specified Player gains a
stamp of eir own type.
}}"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8960
            AGAINST on 8961
            AGAINST on 8962
            AGAINST on 8963
            FOR on 8964
        }

        votes(Forest) {
            // NO VOTE on 8960
            FOR on 8961
            FOR on 8962
            FOR on 8963
            AGAINST on 8964
        }

        votes(nix) {
            FOR on 8960
            FOR on 8961
            AGAINST on 8962
            AGAINST on 8963
            FOR on 8964
        }

        votes(ais523) {
            FOR on 8960
            AGAINST on 8961
            AGAINST on 8962
            AGAINST on 8963
            // TODO: resolve conditional vote on 8964: FOR if snail voted unconditionally FOR on 8960, else AGAINST
        }

        votes(Murphy) {
            PRESENT on 8960
            FOR on 8961
            AGAINST on 8962
            FOR on 8963
            FOR on 8964
        }

        votes(Janet) {
            FOR on 8960
            endorse(G) on 8961
            AGAINST on 8962
            AGAINST on 8963
            endorse(nix) on 8964
        }

        votes(G) {
            FOR on all
        }

        votes(Yachay) {
            // TODO: resolve conditional vote on 8960: FOR if author pledges or is bound by pledge to not claim radiance from passage (if possible), else AGAINST
            AGAINST on 8961
            FOR on 8962
            // TODO: resolve conditional vote on 8963: FOR if author pledges or is bound by pledge to not claim radiance from passage (if possible), else AGAINST
            // TODO: resolve conditional vote on 8964: FOR if author pledges or is bound by pledge to not claim radiance from passage (if possible), else AGAINST
        }
    }
}
