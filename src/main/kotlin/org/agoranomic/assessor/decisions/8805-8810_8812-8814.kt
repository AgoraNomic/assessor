package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.resolvedConditional
import org.agoranomic.assessor.lib.vote.VoteKind.*
import org.agoranomic.assessor.lib.vote.finalResolution
import org.agoranomic.assessor.lib.vote.voteIfVoted

@UseAssessment
fun assessment8805to8810and8812to8814() = assessment {
    name("8805-8810, 8812-8814")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2022-July/016187.html")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)
    }

    proposals(v4) {
        proposal(8805) {
            title("Removal of vote points v2")
            ai("1.0")
            author(Jason)
            ordinary()

            text("""
Amend Rule 2657 by, as a single amendment, removing all list items that
contain the text "AGAINST" or "FOR".""")
        }

        for (i in 8806..8810) {
            proposal(i) {
                title("Filler")
                ai("1.0")
                author(Jason)
                ordinary()

                text("""
This proposal has no effect.""")
            }
        }

        proposal(8812) {
            title("Quorum for all")
            ai("3.0")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 879 (Quorum) by replacing "2/3 of the number of voters on the
referendum that had been most recently resolved" with "2/3 of the number of
voters on the Agoran decision that had been most recently resolved".""")
        }

        proposal(8813) {
            title("Spam Blocker")
            ai("3.0")
            author(Secretsnail9)
            ordinary()

            text("""
Amend Rule 2350 (Proposals) by replacing "A player CAN create a proposal by
announcement" with "Five times per week, each player CAN create a proposal
by announcement".""")
        }

        proposal(8814) {
            title("Effective activity")
            ai("3.0")
            author(Jason)
            ordinary()

            text("""
Set the power of Rule 2646 (Activity) to 3.

[Rule 2646 cannot authorize deregistration at power 1 because
Citizenship is secured at power 3.]""")
        }
    }

    voting {
        votes(ais523) {
            FOR on 8805
            for (i in 8806..8810) AGAINST on i
            AGAINST on 8812
            FOR on 8813
            FOR on 8814
        }

        votes(Jason) {
            FOR on 8805
            for (i in 8806..8810) PRESENT on i
            AGAINST on 8812
            PRESENT on 8813
            FOR on 8814
        }

        votes(G) {
            AGAINST on 8805
            for (i in 8806..8810) AGAINST on i
            AGAINST on 8812

            function { ctx ->
                if (
                    ctx.resolve(ctx.currentProposal, ais523)?.finalResolution(ctx)?.voteIfVoted == FOR &&
                    ctx.resolve(ctx.currentProposal, Jason)?.finalResolution(ctx)?.voteIfVoted == FOR
                ) {
                    resolvedConditional(FOR, "Both ais523 and Jason voted FOR")
                } else {
                    resolvedConditional(AGAINST, "At least one of ais523 and Jason did not vote FOR")
                }
            } on 8813

            FOR on 8814
        }

        votes(Murphy) {
            PRESENT on 8805
            AGAINST on 8806
            AGAINST on 8807
            AGAINST on 8808
            FOR on 8809
            AGAINST on 8810
            AGAINST on 8812
            PRESENT on 8813
            FOR on 8814
        }

        votes(Secretsnail9) {
            FOR on 8805
            for (i in 8806..8810) AGAINST on i
            FOR on 8812
            FOR on 8813
            PRESENT on 8814
        }
    }
}