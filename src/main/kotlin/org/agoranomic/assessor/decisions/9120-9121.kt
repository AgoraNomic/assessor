package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9120to9121() = assessment {
    name("9120-9121")
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
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Jimmy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Jaff
                "Spendor"(1) heldBy nix
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9120) {
            title("Labour Payment")
            ai("1.0")
            author(juniper)
            ordinary()

            text(
                """
Amed rule 2683, 'The Boulder', by replacing
{
  When a player pushes the Boulder, its Height is increased by 1.
}
with
{
  When a player pushes the Boulder, its Height is increased by 1, and e
receives 1 spendie. If e pushes the Boulder such that the Boulder's Height
is equal to 99, e receives 1 spendie for every active player.
}"""
            )
        }

        proposal(9121) {
            title("More Rules, Less Complex")
            ai("1.1")
            author(juniper)
            coauthors(mqyhlkahu)
            ordinary()

            text(
                """
Amend Rule 1681, 'The Logical Rulesets', by appending
{
 The Readable Logical Ruleset (RLR) is a format of the ruleset. In
this format, rules do not have to be individually listed; if multiple
rules have similar concepts as The Simplifior sees fit, then they may
be listed in one paragraph as a Combined Rule.

Rules in the RLR are permitted to be restated approximately, provided
that they mean the same things.

When writing a Combined Rule, The Simplifior must record all rules
referenced in the paragraph immediately after the rule has been
referenced.

The Simplifior need not use the exact wording of the rule referenced
when writing a Combined Rule.

}

 Enact the following rule, with the title 'The Simplifior' and the
following text:

 {

 The Simplifior is an office; its holder is responsible for increasing
the readability of the Short Logical Ruleset by making a more readable
version.

The Simplifior SHOULD maintain the Readable Logical Ruleset when any
rules are amended, enacted, or removed.

The Simplifior's monthly report includes the Readable Logical Ruleset.
The Simplifior's report SHOULD prominently and clearly include a
reminder that the RLR is a summary and only the rules' full text
actually governs.

 }"""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 9120
            PRESENT on 9121
        }

        votes(Forest) {
            FOR on all
        }

        votes(juan) {
            AGAINST on 9120
            AGAINST on 9121
        }

        votes(Mischief) {
            AGAINST on 9120
            FOR on 9121
        }

        votes(Jaff) {
            AGAINST on 9120
            endorse(Janet) on 9121 comment "${Janet.name} is the Rulekeepor"
        }

        votes(Yachay) {
            PRESENT on 9120
            FOR on 9121
        }

        votes(nix) {
            AGAINST on 9120
            endorse(Janet) on 9121 comment "${Janet.name} is the Rulekeepor"
        }

        votes(wunst) {
            AGAINST on 9120
            FOR on 9121
        }

        votes(Janet) {
            AGAINST on 9120
            PRESENT on 9121
        }

        votes(juniper) {
            AGAINST on 9120
            PRESENT on 9121
        }
    }
}
