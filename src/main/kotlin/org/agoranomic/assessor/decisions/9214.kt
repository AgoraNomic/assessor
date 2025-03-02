package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9214() = assessment {
    name("9214")
    quorum(6)

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
}
