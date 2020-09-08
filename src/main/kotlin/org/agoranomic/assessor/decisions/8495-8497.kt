package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.proposal.Ministry.Legislation
import org.agoranomic.assessor.lib.proposal.Ministry.Participation

@UseAssessment
fun assessment8495to8497() = assessment {
    quorum(5)

    proposals(v2) {
        proposal(8495) {
            title("Please stand by")
            ai("1.0")
            author(G)
            chamber(Participation)
            sponsored()

            text("""
Create a rule, "Please Stand By", with the following text:

  Normal service will resume shortly.""")
        }

        proposal(8496) {
            title("Timely reminders")
            ai("1.0")
            author(Jason)
            coauthors(Aris)
            chamber(Legislation)
            sponsored()

            text("""
Amend Rule 2168 by replacing  the text "Upon such an occurrence" with
the text "Within two days of such an occurrence"""")
        }

        proposal(8497) {
            title("Withdrawal Quick-Fix")
            ai("3.0")
            author(nix)
            democratic()
            sponsored()

            text("""
Amend R2350 "Proposals" by adding, to the last paragraph:

"When a player withdraws a pending proposal, e CAN, by announcement,
grant a Pendant to the player that pended the proposal."""")
        }
    }
}
