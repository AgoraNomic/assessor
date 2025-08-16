package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9242() = assessment {
    name("9242")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Mischief
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Kate
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9242) {
            title("Currency clarification")
            ai("3")
            author(Janet)
            coauthors(Kate)
            democratic()

            text(
                """
Amend Rule 2578 ("Fungibility") to read as follows:

{

Any two assets within a "fungible" class of assets (syn. "currency")
that have the same owner are considered equivalent for the purposes of
specification, granting, and transferring. The number of such assets an
entity owns is that entity's "balance" of that currency.

}


[Currently, the rule conflates a class of asset and an individual asset.
This fixes that issue and includes the "currency" definition from
Mischief's proposal.]"""
            )
        }
    }

    voting {
        votes(Cosmo) {
            FOR on 9242
        }

        votes(Murphy) {
            FOR on 9242
        }

        votes(Mischief) {
            FOR on 9242
        }

        votes(Janet) {
            FOR on 9242
        }
    }
}
