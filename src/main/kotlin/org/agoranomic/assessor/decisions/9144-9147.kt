package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9144to9147() = assessment {
    name("9144-9177")
    quorum(3)

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
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy null
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
        proposal(9144) {
            title("Sortition, again")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
If at least one of the following conditions would be met prior to the
amendment, amend Rule 2691 ("Sortition Procedure") by, as a single
amendment:

* If the Rule contains a paragraph beginning "At the beginning of each
quarter", replacing that paragraph with the following paragraphs:

{

A player CAN by announcement initiate a sortition for a vacant
sortitioned office for which a sortition is not ongoing. At the
beginning of each quarter, for each sortitioned office for which a
sortition is not ongoing, the ADoP CAN once by announcement, and SHALL
in a timely fashion, initiate a sortition.

Rules to the contrary notwithstanding, a sortition CANNOT be initiated
for an office for which a sortition is ongoing.

}

* If the Rule does not contain a single paragraph beginning "If a
sortition is ever ongoing", appending the following paragraph:

{

If a sortition is ever ongoing for a non-sortitioned office (or for an
office that no longer exists), that sortition immediately ends.

}"""
            )
        }

        proposal(9145) {
            title("Pragmatic quarters")
            ai("2.0")
            author(Murphy)
            coauthors(Mischief)
            ordinary()

            text(
                """
Amend Rule 2555 (Blots) by replacing this text:

       At the beginning of each quarter, half (rounded down) of each
       fugitive's blots are destroyed.

with this text:

       Once a quarter, the Referee CAN and SHALL publish a Notice of
       Clemency, upon which half (rounded down) of each fugitive's blots
       are destroyed.

Amend Rule 2685 (Crystals) by replacing this text:

       At the beginning of each quarter, each crystal whose identity is
       not equal to the ID of any rule in the current ruleset has its
       size increased by 3.

with this text:

       Once a quarter, the Geologist CAN and SHALL publish a Notice of
       Crystal Growth, upon which each crystal whose identity is not
       equal to the ID of any rule in the current ruleset has its size
       increased by 3.

Amend Rule 2656 (Radiance) by replacing this text:

       At the start of every quarter, all radiance switches are set to
       half their current value rounded down.

with this text:

       Once a quarter, the Illuminator CAN and SHALL publish a Notice of
       Diminution, upon which all radiance switches are set to half their
       current value rounded down."""
            )
        }

        proposal(9146) {
            title("The Agorans Are Talking")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
The publicity of the forum that can be sent to at the email address
agora-talk@agora.nomic.space is hereby flipped to Discussion.

[In light of omd saying e would prefer someone else to take over
maintenance of the lists, in addition to what appears to be a current
list outage, let's at least start trying a mailing list that is hosted
by someone else.]"""
            )
        }

        proposal(9147) {
            title("Paradox cleanup fix")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
Add a new paragraph to the end of rule 991:
{{{
      If two CFJs become assigned to the same judge in the same
      message, those CFJs are "linked" to each other, unless that
      message specifies that the CFJs should not be linked. The
      Arbitor SHOULD consider linking two CFJs if they inquire about
      the same or substantially similar events and are called at
      approximately the same time.
}}}

Amend the first paragraph of rule 2553 to read:
{{{
      If a CFJ about the effectiveness, possibility, or legality of a
      change in the gamestate has been assigned a judgement of
      PARADOXICAL continuously for between 7 and 90 days, then that
      case's initiator, CAN, by announcement, Transcend Logic,
      specifying that CFJ, provided that e has not already won the game
      with respect to that CFJ or to a CFJ linked to it. When a person
      transcends logic, e wins the game.
}}}"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9144
            AGAINST on 9145
            FOR on 9146
            FOR on 9147
        }

        votes(Mischief) {
            FOR on 9144
            AGAINST on 9145
            FOR on 9146
            FOR on 9147
        }

        votes(Janet) {
            FOR on 9144
            AGAINST on 9145
            PRESENT on 9146
            FOR on 9147
        }

        votes(ais523) {
            FOR on 9144
            AGAINST on 9145
            PRESENT on 9146
            FOR on 9147
        }

        votes(Murphy) {
            FOR on 9144
            FOR on 9145
            FOR on 9146
            FOR on 9147
        }
    }
}
