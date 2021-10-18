package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.festival
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.proposal.DecisionAI
import org.agoranomic.assessor.lib.proposal.ProposalAI
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8630() = assessment {
    name("8630")
    quorum(5)

    strengths {
        festival(
            minStrength = 0,
            maxStrength = 15,
            festivePlayers = setOf(
                ais523,
                Aspen,
                ATMunn,
                CuddleBeam,
                cuddlybanana,
                Falsifian,
                G,
                Gaelan,
                Jason,
                Murphy,
                nix,
                omd,
                PSS,
                Telna,
                Trigon,
            )
        )

        onOrdinaryProposals {
            powerStone(Jason, 3)
        }
    }

    proposals(v4) {
        proposal(8630) {
            title("A Very Merry Unvictory to Me! ")
            proposalAI(ProposalAI("3.0".toBigDecimal()))
            decisionAI(DecisionAI("3.0".toBigDecimal()))
            author(CuddleBeam)
            democratic()
            sponsored()

            text("""
Ratify the following: {Cuddlebeam has not won the game by Proposal.}

Then, if it is possible to do, revoke the Title of Champion (by Proposal)
from Cuddlebeam.""")
        }
    }

    voting {
        votes(ShyOwl) {
            // NO VOTE on 8630
        }

        votes(ATMunn) {
            FOR on 8630
        }

        votes(G) {
            AGAINST on 8630
        }

        votes(Jason) {
            AGAINST on 8630
        }

        votes(nix) {
            PRESENT on 8630
        }

        votes(ais523) {
            endorse(CuddleBeam) on 8630
        }

        votes(Gaelan) {
            AGAINST on 8630
        }

        votes(Falsifian) {
            AGAINST on 8630
        }

        votes(Telna) {
            FOR on 8630
        }

        votes(Trigon) {
            AGAINST on 8630
        }

        votes(CuddleBeam) {
            FOR on all
        }

        votes(cuddlybanana) {
            FOR on all
        }
    }
}
