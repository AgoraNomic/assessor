package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9192() = assessment {
    name("9192")
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
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy oliver
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9192) {
            title("Dissolution")
            ai("1.2")
            author(Mischief)
            ordinary()

            text(
                """
[At various times, folks have mentioned that crystals have influenced
how they voted on proposals. Since they've been around a while, I
figured it was worth talking everyone's temperature on them. In order to
make sure crystals don't get repealed on a narrow result, I deliberately
set the AI a little higher than it strictly needs to be. Also, at this
point, I expect to be voting PRESENT personally.]

Repeal rule 2685 (Crystals)"""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 9192
        }

        votes(Mischief) {
            PRESENT on 9192
        }
    }
}
