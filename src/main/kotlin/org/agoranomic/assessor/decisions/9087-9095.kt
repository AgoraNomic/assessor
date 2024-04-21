package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9087to9095() = assessment {
    name("9087-9095")
    quorum(6)

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
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy null
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy RLee
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy null
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
        proposal(9087) {
            title("A repeal")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Repeal the Rule entitled "Agora of Empires".

[The only gameplay this has produced is what was effectively an Apathy
attempt, and it does not appear likely to produce more in the future.]"""
            )
        }

        proposal(9088) {
            title("Spendie Fixie")
            ai("2.0")
            author(nix)
            coauthors(Murphy, ais523, Janet)
            ordinary()

            text(
                """
[Spendies v1.1 both failed to repeal R2643 and may have accidentally
repealed 2642. This proposal fixes both of those.]

Reenact R2642 (Stone Cost) with a Power of 2 and the full text:

    Stone Cost is a Stone switch with values of non-negative integers
    and a default of 10. Stone Cost is tracked by the Stonemason.

    Any player CAN pay a fee of X Spendies to transfer a specified stone
    to emself, where X is the current Stone Cost of the specified stone.

    When a stone is transferred, its Stone Cost is set to the default.
    At the beginning of every week, the Stone Cost for each stone is
    reduced by 1, to a minimum of 0.

[If the rule is repealed, this brings it back. If the rule isn't
repealed, it does nothing.]

Repeal R2643 (Collecting Stones).

If no player has any Spendies, grant each player 20 Spendies.

[Get Spendies running properly if they aren't already.]"""
            )
        }

        proposal(9089) {
            title("Who are you, again, again?")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend the Rule entitled "Spendies" by prepending the following paragraph:

{

The Spendor is an office.

}

The Officeholder of Spendor is hereby flipped to nix."""
            )
        }

        proposal(9090) {
            title("More instability so crystals can actually change hands")
            ai("1.0")
            author(RLee)
            ordinary()

            text(
                """
Amend rule 2685 'Crystals' by replacing

"- If that crystal's owner is not the author of that proposal, the
instability
of that crystal is increased by 1."

      with


"If that crystal's owner is not the author of that proposal, the
instability of that crystal is increased by 2.""""
            )
        }

        proposal(9091) {
            title("Welcome package fix, again, again")
            ai("1.0")
            author(Janet)
            coauthors(Aris)
            ordinary()

            text(
                """
Amend Rule 2499 ("Welcome Packages") to read, in whole:

{

When a player receives a welcome package, if e has not received a
welcome package, including under any previous definition, since e last
registered nor in the last 30 days, e gains the following assets:

* One stamp of eir own type.

A player CAN, by announcement, cause a specified player to receive a
welcome package (syn. "grant" em a welcome package).

}


[Clarify the issues identified with welcome packages previously. There
has been discussion of adding pro-rated spendies, but that will be done
separately. Only a formatting change from V1.]"""
            )
        }

        proposal(9092) {
            title("Paying your time")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
Amend rule 2555 by removing the following text, if present:
{{{
      Any player who has not expunged a blot by this method this week
      CAN expunge 1 blot from a specified player by announcement. E
      CANNOT specify emself for this if e has gained any blots this or
      the previous week.
}}}
Amend rule 2555 by adding the following text, as a new paragraph, prior
to its last sentence:
{{{
      Any player CAN pay a fee of 7 Spendies to revoke a blot from a
      specified person.
}}}
[A straightforward "get fined for crimes" mechanic.]"""
            )
        }

        proposal(9093) {
            title("Stamp down on crime")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
Amend rule 2555 by removing the following text, if present:
{{{
      Any player who has not expunged a blot by this method this week
      CAN expunge 1 blot from a specified player by announcement. E
      CANNOT specify emself for this if e has gained any blots this or
      the previous week.
}}}
Amend rule 2555 by adding the following text, as a new paragraph, prior
to its last sentence:
{{{
      Any player CAN, with notice, pay a fee of 11 Spendies to revoke
      a blot from a specified person. When a blot is revoked this way,
      a Stamp with type corresponding to the person from whom the blot
      was revoked is created in the possession of the player who
      revoked it.
}}}
[A less straightforward "get fined for crimes" mechanic, which could
combine well with my other proposal: the risk of someone else gaining
one of your stamps (leading to a minor but semi-permanent loss of
economic power) serves as an incentive to remove blots, and as a
potential punishment in its own right.]"""
            )
        }

        proposal(9094) {
            title("More instability with a hyphen")
            ai("1.0")
            author(snail)
            coauthors(RLee)
            ordinary()

            text(
                """
Amend rule 2685 (Crystals) by replacing

"- If that crystal's owner is not the author of that proposal, the
instability
of that crystal is increased by 1."

with

"- If that crystal's owner is not the author of that proposal, the
instability of that crystal is increased by 2."

[The above hyphen was missing in the previous version.]"""
            )
        }

        proposal(9095) {
            title("Spendy Sizing")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend rule 2685 (Crystals) by replacing

{
      A player is crystallized if the total size of crystals e owns is
      at least the number of rules in the current ruleset.
}

      with

{
      A player is crystallized if the total size of crystals e owns is
      at least the number of rules in the current ruleset.

      A player CAN increase the size of a specified crystal by 1 by paying
a fee of 11 spendies.
}"""
            )
        }

    }

    voting {
        votes(snail) {
            PRESENT on 9087
            FOR on 9088
            FOR on 9089
            AGAINST on 9090
            FOR on 9091
            FOR on 9092
            AGAINST on 9093
            FOR on 9094
            FOR on 9095
        }

        votes(Janet) {
            FOR on 9087
            FOR on 9088
            FOR on 9089
            AGAINST on 9090
            FOR on 9091
            FOR on 9092
            AGAINST on 9093
            PRESENT on 9094
            AGAINST on 9095
        }

        votes(Murphy) {
            PRESENT on 9087
            FOR on 9088
            FOR on 9089
            FOR on 9090
            FOR on 9091
            FOR on 9092
            FOR on 9093
            FOR on 9094
            FOR on 9095
        }

        votes(Quadrantal) {
            PRESENT on 9087
            FOR on 9088
            FOR on 9089
            AGAINST on 9090
            PRESENT on 9091
            FOR on 9092
            AGAINST on 9093
            FOR on 9094
            FOR on 9095
        }

        votes(juan) {
            PRESENT on 9087
            FOR on 9088
            FOR on 9089
            PRESENT on 9090
            FOR on 9091
            AGAINST on 9092
            FOR on 9093
            PRESENT on 9094
            PRESENT on 9095
        }

        votes(Jaff) {
            FOR on 9087
            FOR on 9088
            FOR on 9089
            PRESENT on 9090
            FOR on 9091
            FOR on 9092
            AGAINST on 9093
            PRESENT on 9094
            PRESENT on 9095
        }

        votes(nix) {
            FOR on 9087
            FOR on 9088
            FOR on 9089
            PRESENT on 9090
            PRESENT on 9091
            FOR on 9092
            PRESENT on 9093
            PRESENT on 9094
            PRESENT on 9095
        }

        votes(wunst) {
            FOR on 9087
            PRESENT on 9088
            FOR on 9089
            AGAINST on 9090
            FOR on 9091
            AGAINST on 9092
            FOR on 9093
            PRESENT on 9094
            FOR on 9095
        }
    }
}
