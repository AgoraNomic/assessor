package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9248() = assessment {
    name("9248")
    quorum(3)

    proposals(v4) {
        proposal(9248) {
            title("Over-Optimization is Boring")
            ai("1.0")
            author(Mischief)
            coauthors(Murphy)
            ordinary()

            text(
                """
Amend rule 2710 (Genetic Modification) by appending the following
paragraph at the end:

       Once per Crop Season, the Land Managor CAN and SHALL by
       announcement randomly select a type of Crop that was in-season
       during the previous season, random attribute (Seed Cost or Sell
       Price), and random value for that attribute (as if the type was
       being created), and change that attribute of that type to that
       value. If there is no such type to select, then e SHALL instead
       announce that fact."""
            )
        }
    }

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
                "Illuminator"(1) heldBy null
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
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

    voting {
        votes(Cosmo) {
            FOR on 9248
        }

        votes(juan) {
            FOR on 9248
        }

        votes(Mischief) {
            FOR on 9248
        }

        votes(Janet) {
            PRESENT on 9248
        }

        votes(Murphy) {
            FOR on 9248
        }
    }
}
