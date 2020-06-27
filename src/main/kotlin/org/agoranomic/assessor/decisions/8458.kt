package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune3.*
import org.agoranomic.assessor.dsl.ministries.ministriesJun15
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.addToHolder
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.VoteKind.AGAINST
import org.agoranomic.assessor.lib.VoteKind.FOR

@UseAssessment
fun `assessment 8458`() = assessment {
    name("8458")
    quorum(8)

    val offices = officeMapOf(
        ADoP to RLee,
        Arbitor to G,
        Assessor to Jason,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nch,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to G,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nch
    )

    strengths {
        default(3)
        min(0)
        max(15)

        ministriesJun15(offices, allProposals)
        addToHolder(offices, Speaker, 1)

        proposal(ProposalNumber(8458)) {
            nch add 3 // Extra votes
            RLee add 3 // Extra votes
        }
    }

    proposals(v1) {
        proposal(8458) {
            title("Welcome Package Patch")
            ai("1.0")
            author(Aris)
            chamber(Ministry.Economy)

            text(
                """
Amend Rule 2499, "Welcome Packages", by appending to the first paragraph:

  A player CANNOT receive a Welcome Package via this method if e was
  deregistered on account of having excessive blots."""
            )
        }
    }

    voting {
        votes(RLee) {
            AGAINST on 8458
        }

        votes(Tcbapo) {
            AGAINST on 8458
        }

        votes(Falsifian) {
            FOR on 8458
        }

        votes(Jason) {
            FOR on 8458
        }

        votes(nch) {
            AGAINST on 8458
        }

        votes(PSS) {
            FOR on 8458
        }

        votes(ATMunn) {
            FOR on 8458
        }

        votes(Aris) {
            FOR on 8458
        }

        votes(Trigon) {
            FOR on 8458
        }
    }
}
