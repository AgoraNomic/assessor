package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9246() = assessment {
    name("9246")
    quorum(4)

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
}
