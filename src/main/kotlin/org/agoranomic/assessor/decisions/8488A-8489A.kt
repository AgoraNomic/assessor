package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.proposal.Ministry.Economy
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8488Ato8489A() = assessment {
    suffix("A")
    quorum(5)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Coopor to RLee,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nix,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to grok,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Gaelan, 4 / 3)
        blotPenalty(RLee, 81 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_08_02(offices, allProposals)
    }

    proposals(v2) {
        proposal(8488) {
            title("Empty the escalator v1")
            ai("3.0")
            author(Falsifian)
            coauthors(Jason, omd)
            democratic()
            sponsored()

            text("""
Amend Rule 2577 by adding the sentence "Attempts to destroy no assets
are successful." before the sentence that begins "An indestructible asset".

Amend Rule 2577 by adding the sentence "Attempts to transfer no assets
are successful." before the sentence that begins "A fixed asset".

Amend Rule 2579 by deleting the paragraph that ends with "0 or empty fee".""")
        }

        proposal(8489) {
            title("Interesting economics")
            ai("1.0")
            author(Jason)
            chamber(Economy)
            sponsored()

            text("""
Amend Rule 2624 by appending the following sentence to the first
paragraph: "The type of card with the fewest existing instances is
associated with the Ministry of Economy."""")
        }
    }

    voting {
        votes(Aris) {
            FOR on 8488
            FOR on 8489
        }

        votes(Telnaior) {
            endorse(Aris) on all
        }
    }
}
