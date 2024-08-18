package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9153to9155() = assessment {
    name("9153-9155")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
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
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy nix
                "Stonemason"(1) heldBy juniper
                "Tailor"(1) heldBy Murphy
                "Tracker of Hats"(1) heldBy Mischief
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9153) {
            title("No double harvest")
            ai("3.0")
            author(Murphy)
            coauthors(Janet)
            democratic()

            text(
                """
Amend Rule 2124 (Performing Tabled Actions) by replacing this text:

       An intent is ripe if was tabled within the past 14 days, the
       Speaker hasn't objected to it in the past 48 hours, and its
       conditions, if any, are each clearly and unambiguously met.

with this text:

       An intent is ripe if was tabled within the past 14 days, the
       Speaker hasn't objected to it in the past 48 hours, its
       conditions (if any) are each clearly and unambiguously met,
       and no one has already acted as allowed based on that intent.

[Prevent reusing intents even if they're less than two weeks old. If
  we spot a use case where we agree they should be reusable, then we
  can define an exception mechanism.]"""
            )
        }

        proposal(9154) {
            title("Pragmatic quarters, take two")
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

        Once a quarter, the Referee CAN (and SHALL during its first
        Eastman week) publish a Notice of Clemency, upon which half
        (rounded down) of each fugitive's blots are destroyed.

Amend Rule 2685 (Crystals) by replacing this text:

        At the beginning of each quarter, each crystal whose identity is
        not equal to the ID of any rule in the current ruleset has its
        size increased by 3.

with this text:

        Once a quarter, the Geologist CAN (and SHALL during its first
        Eastman week) publish a Notice of Crystal Growth, upon which each
        crystal whose identity is not equal to the ID of any rule in the
        current ruleset has its size increased by 3.

Amend Rule 2656 (Radiance) by replacing this text:

        At the start of every quarter, all radiance switches are set to
        half their current value rounded down.

with this text:

        Once a quarter, the Illuminator CAN (and SHALL during its first
        Eastman week) publish a Notice of Diminution, upon which all
        radiance switches are set to half their current value rounded
        down.

[Same as before, except the officer is required to do it within the
  first seven days of the quarter. If e's late, then the timing still
  differs, but that may still be better than a platonic event occurring
  but potentially being overlooked.]"""
            )
        }

        proposal(9155) {
            title("Some stones are more equal than others")
            ai("2.0")
            author(Murphy)
            coauthors(Mischief)
            ordinary()

            text(
                """
Amend Rule 2644 (Zen Gardening) by replacing this text:

        A player has an impressive rock collection if e:
          1) owns 10 or more stones; or
          2) owns 8 or more stones and does not own the Tacky Stone.

with this text:

        A player has an impressive rock collection if e owns one or more
        stones with a total Stature of at least 8. The Stature of each
        stone is 1, unless its definition specifies otherwise.

Amend Rule 2645 (The Stones) by replacing this text:

        - Tacky Stone (monthly):

with this text:

        - Tacky Stone (monthly, Stature -1):

[Generalizes the "Tacky Stone is beyond worthless" mechanism, in case
  we want to bump the Stature of any other stones up or down. No effect
  if Tacky Stone wasn't adopted.]"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9153
            PRESENT on 9154
            PRESENT on 9155
        }

        votes(Immae) {
            PRESENT on 9153
            FOR on 9154
            FOR on 9155
        }

        votes(juan) {
            FOR on 9153
            PRESENT on 9154
            PRESENT on 9155
        }

        votes(Mischief) {
            FOR on 9153
            FOR on 9154
            AGAINST on 9155
        }

        votes(Janet) {
            AGAINST on 9153
            PRESENT on 9154
            PRESENT on 9155
        }

        votes(ais523) {
            AGAINST on 9153
            PRESENT on 9154
            AGAINST on 9155
        }

        votes(lare290) {
            PRESENT on 9153
            FOR on 9154
            PRESENT on 9155
        }

        votes(literallyAmbiguous) {
            AGAINST on 9153
            FOR on 9154
            AGAINST on 9155
        }

        votes(Murphy) {
            FOR on 9153
            FOR on 9154
            FOR on 9155
        }
    }
}
