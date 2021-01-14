package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeState
import org.agoranomic.assessor.dsl.ministries.Office_2020_10_28.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_11_07
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorseOrElse
import org.agoranomic.assessor.lib.proposal.MinistryV2.Economy
import org.agoranomic.assessor.lib.vote.CommentedResolvingVote
import org.agoranomic.assessor.lib.vote.ResolvedVote
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8526() = assessment {
    name("8526")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-December/014513.html")
    quorum(6)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Coopor to null,
        Distributor to omd,
        Herald to null,
        Ministor to nix,
        Notary to ATMunn,
        PrimeMinister to ATMunn,
        Promotor to Aris,
        Referee to null,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to G,
        // Stonemason to Jason,
        Tailor to null,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 9 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_11_07(offices, allProposals)
    }

    proposals(v3) {
        proposal(8526) {
            title("Debarreling")
            ai("1.0")
            author(G)
            chamber(Economy)
            sponsored()

            text("""
Repeal Rule 2627 (The General Store).

Repeal Rule 2628 (Bargains on the Barrel).""")
        }
    }

    voting {
        votes(Jason) {
            FOR on 8526
        }

        votes(Falsifian) {
            FOR on 8526
        }

        votes(ATMunn) {
            FOR on 8526
        }

        votes(Gaelan) {
            offices[Coopor].let {
                if (it is OfficeState.Held)
                    endorseOrElse(it.holder, PRESENT)
                else
                    CommentedResolvingVote(conditional("Coopor is not held"), ResolvedVote(FOR))
            } on 8526
        }

        votes(Aris) {
            FOR on 8526
        }

        votes(nix) {
            FOR on 8526
        }

        votes(Trigon) {
            FOR on 8526
        }
    }
}
