package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment8863to8865() = assessment {
    name("8863-8865")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        // At the end of the voting period, Dream of Power applies to all Agoran decsions
        powerDream(Jason, 3)
        powerDream(snail, 3)
    }

    proposals(v4) {
        proposal(8863) {
            title("Exiting REM")
            ai("2.0")
            author(Jason)
            ordinary()

            text(
                """
Amend Rule 2675 by replacing with "Eir Voting Strength is 2 greater."
with "Eir voting strength is increased by 2 for referenda on ordinary
proposals.""""
            )
        }

        proposal(8864) {
            title("Pronoun Correction")
            ai("1.0")
            author(ziproot)
            ordinary()

            text(
                """
Amend Rule 2672 by replacing "Each player CAN take one of the following
actions (weekly race actions) if they have not already taken one this
week" with "Each player CAN take one of the following actions (weekly
race actions) if e has not already taken one this week""""
            )
        }

        proposal(8865) {
            title("Stone Fixes")
            ai("2.0")
            author(nix)
            coauthors(G, ais523, Jason, ziproot)
            ordinary()

            text(
                """
Amend R2645, The Stones, by

removing the bullet point that includes "Tasty Stone";

and removing the bullet point that includes "Wealth Stone";

and replacing:

     A specified player (defaulting to the wielder if not specified)
     hereby Buys Strength 3 times.

with:

     A specified player (defaulting to the wielder if not specified) is
     Power Stoned; Power Stoning is secured. A player's voting strength
     on a referendum on an ordinary proposal is increased by 3 for each
     time that e was Power Stoned during the referendum's voting period.

and adding, to the end of the rule:

     - Score Stone (Weekly, 3): A specified player's (defaulting to the
       wielder if not specified) Score is increased by 3."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8863
            FOR on 8864
            FOR on 8865
        }

        votes(nix) {
            FOR on 8863
            FOR on 8864
            FOR on 8865
        }

        votes(juan) {
            FOR on 8863
            FOR on 8864
            PRESENT on 8865
        }

        votes(Jason) {
            FOR on 8863
            FOR on 8864
            FOR on 8865
        }
    }
}