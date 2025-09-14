package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9246() = assessment {
    name("9246")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2025-September/018666.html")
    quorum(4)

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

    proposals(v4) {
        proposal(9246) {
            title("Reduce automatic sortition events v1.1")
            ai("2.0")
            author(Murphy)
            coauthors(Janet)
            ordinary()

            text(
                """
Amend Rule 2691 (Sortition Procedure) by replacing this text:

       Seven days after a sortition is initiated, its lots period ends.
       The ADoP CAN by announcement, and SHALL in a timely fashion after
       a lots period ends, randomly select one of the options for that
       office. When e does so, that player becomes the officeholder for
       that office, then the sortition ends.

       If a sortition's lots period has ended, and the sortition has no
       valid options, then it immediately ends with no selection, and any
       duty to select an option with respect to it is discharged.

or, if Proposal 9245 was adopted, this text:

       Seven days after a sortition is initiated, its lots period ends.

         * If it has two or more valid options, then the ADoP CAN by
           announcement, and SHALL in a timely fashion after its lots
           period ends, randomly select one of those options.

         * If it has exactly one valid option, then any player CAN by
           announcement select that option.

         * If it has no valid options, then any player CAN by
           announcement declare the selection ended with no selection.

       When a player is selected in a sortition as described above, e is
       installed into the associated office and the election ends.

with this text:

       Seven days after a sortition is initiated, its lots period ends,
       after which:

         * If it has two or more valid options, then the ADoP CAN by
           announcement, and SHALL in a timely fashion after its lots
           period ends, randomly select one of those options.

         * If it has exactly one valid option, then any player CAN by
           announcement select that option.

         * If it has no valid options, then any player CAN by
           announcement declare the sortition ended with no selection.

       When a player is selected in a sortition as described above, e is
       installed into the associated office and the sortition ends."""
            )
        }
    }

    voting {
        votes(Cosmo) {
            FOR on 9246
        }

        votes(Mischief) {
            FOR on 9246
        }

        votes(Janet) {
            PRESENT on 9246
        }

        votes(Murphy) {
            FOR on 9246
        }
    }
}
