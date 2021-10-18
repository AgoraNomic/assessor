package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.festival
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.proposal.DecisionAI
import org.agoranomic.assessor.lib.proposal.ProposalAI
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

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
            FOR on 8630
        }

        votes(ATMunn) {
            FOR on 8630
        }
    }
}
