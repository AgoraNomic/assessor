package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune3.*
import org.agoranomic.assessor.dsl.ministries.ministriesJun15
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.proposal
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.extraVotes
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8458`() = assessment {
    name("8458")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013876.html")
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

        proposal(8458) {
            extraVotes(nch, 3)
            extraVotes(RLee, 3)
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
            FOR on 8458
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
            FOR on 8458
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

        votes(Murphy) {
            PRESENT on 8458
        }
        
        votes(G) {
            FOR on 8458
        }
    }
}
