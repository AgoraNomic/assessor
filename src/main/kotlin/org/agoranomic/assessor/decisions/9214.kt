package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment9214() = assessment {
    name("9214")
    quorum(6)

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
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Mischief
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }


    proposals(v4) {
        proposal(9214) {
            title("Stone Badgers")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[I pulled this list together based on Stonemason reports. Worst case, if
this omits someone the Herald can rectify this via rule 2415's mechanism.]

Revoke the patent title of Stone Badge from any person who holds it

Award the patent title of Stone Badge to the following people:

4st
ais523
Aris
ATMunn
Ben
Beokirby
Cuddlebeam
Falsifian
G.
Gaelan
Goren
inalienableWright
Jaff
Janet
juan
Kate
kiako
literallyAmbiguous
Mercury
Mischief
Murphy
nix
R. Lee
Shy Owl
snail
Trigon
Yachay Wayllukuq"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9214
        }

        votes(ais523) {
            FOR on 9214
        }

        votes(Mischief) {
            FOR on 9214
        }
    }
}
