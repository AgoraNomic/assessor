package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9184to9185() = assessment {
    name("9184-9185")
    url(
        "https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2024-October/018083.html",
        "https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2024-October/018087.html"
    )
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Spendor"(1) heldBy oliver
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9184) {
            title("Ratification fix")
            ai("3.2")
            author(ais523)
            democratic()

            text(
                """
Amend rule 1551 by changing
{{{
* The publication time is the instant at which the document to be
  ratified was published.
}}}
to
{{{
* The publication time can be specified by the instrument allowing
  the ratification, defaulting to the instant at which the document
  to be ratified was published.
}}}

Amend rule 2201 by changing
{{{
- If the rules define it as a self-ratifying attestation to a
  given statement, the statement is ratified.
}}}
to
{{{
- If the rules define it as a self-ratifying attestation to a
  given statement, the statement is ratified, with the publication
  time being the instant at which the document was published.
}}}

[This has been broken for a while, and was observed to be broken a
while ago: self-ratifying attestations, such as proposal results,
currently don't usually self-ratify because the definition of the
publication time doesn't work for them unless the statement being
attested to is explicitly published.

If this proposal is adopted, I encourage the Assessor to explicitly
publish the statement being attested to as part of the resolution
message, in order to ensure that those results self-ratify.]"""
            )
        }

        proposal(9185) {
            title("Gun control")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2692 ("Bang!") by replacing "When a player stands alone, e
wins the game. If a player won the game in this manner 4 days ago, then
the match state is flipped to none (if it is not already)." with the
following: "When a player stands alone, eir radiance is increased by 30,
then the match state is flipped to none (if it is not already).".

[A full win for this relatively fast (even after the changes) subgame
has always seemed like a lot to me.]"""
            )
        }
    }

    voting {
        votes(snail) {
            PRESENT on 9184
            AGAINST on 9185
        }

        votes(Janet) {
            FOR on 9184
            FOR on 9185
        }

        votes(Murphy) {
            FOR on 9184
            PRESENT on 9185
        }

        votes(Kate) {
            FOR on 9184
            AGAINST on 9185
        }

        votes(Mischief) {
            FOR on 9184
            FOR on 9185
        }

        votes(ais523) {
            FOR on 9184
            FOR on 9185
        }

        votes(lare290) {
            FOR on 9184
            PRESENT on 9185
        }
    }
}
