package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9377to9380() = assessment {
    name("9377-9380")
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
                "Executor"(1) heldBy Mischief
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy pizza723
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy Kate
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Galle
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9377) {
            title("Numerical planting")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2714 by replacing "25 radiance" with "2000 pyrite".

[We've had several radiance wins involving number cards recently. It
seems like we're handing these out too quickly, and this is the obvious
place to reduce their impact.]"""
            )
        }

        proposal(9378) {
            title("A pause")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2714 by removing the paragraph beginning "A player CAN, once
per week".

[We've had several radiance wins involving number cards recently. This
would temporarily address the problem at the cost of making them
useless. This should presumably be done with an eye towards replacing
this mechanism.]"""
            )
        }

        proposal(9379) {
            title("Lowering the rate limit")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2707 by replacing "fewer than 40 Spendies" with "fewer than
20 Spendies".

[Another proposal to hopefully slow down radiance wins. I don't expect
all three of these to be adopted, but I do think at least one should be.]"""
            )
        }

        proposal(9380) {
            title("intsallation instructions")
            ai("2.0")
            author(Cosmo)
            ordinary()

            text(
                """
Amend Rule 1006 (Offices) by replacing the first paragraph with the
following:

{
An Office is a position described as an Office by the Rules.
Officeholder is an office switch tracked by the ADoP, with possible
values of any player or "vacant" (default). Each instance of the
Officeholder switch is secured at the power of the Rule defining the
associated office (or the power of this Rule, if the defining Rule's
power is higher). To install a player into an office is to flip that
office's Officeholder switch to that player. An officer is the holder of
an office, who may be referred to by the name of that office.
}

[Added the second-to-last sentence since there doesn't seem to be any
definition of what installing someone into an office actually does at
the moment. This shouldn't have any gamestate ramifications though since
officeholder self-ratifies through R2698]"""
            )
        }
    }
}