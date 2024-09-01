package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.proposal.DecisionAI
import org.agoranomic.assessor.lib.proposal.ProposalAI
import org.agoranomic.assessor.lib.vote.VoteKind.*
import java.math.BigDecimal

@UseAssessment
fun assessment9156to9158() = assessment {
    name("9156-9158")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2024-August/017958.html")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Simplifior"(1) heldBy juniper
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy nix
                "Stonemason"(1) heldBy juniper
                "Tailor"(1) heldBy Murphy
                "Tracker of Hats"(1) heldBy Mischief
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9156) {
            title("Yo Ho Ho!")
            ai("1.0")
            author(Mischief)
            coauthors(Immae)
            ordinary()

            text(
                """
Amend rule 2690 (Spendies) by replacing the sentence reading:

       At the beginning of each month, every player is granted 20
       Spendies.

with:

       At the beginning of each month, every player is granted 5 + N
       Spendies, where N is the lesser of 20 or the total number of
       times that players contributed to anti-pirate defense in the
       previous month.

and appending at the end of that rule, as a new paragraph:

       A player may contribute to anti-pirate defense by paying a fee
       of 5 Spendies."""
            )
        }

        proposal(9157) {
            title("Shameless Bribery")
            proposalAI(ProposalAI(BigDecimal("1.0")))
            decisionAI(DecisionAI(BigDecimal("2.0")))
            author(Mischief)
            ordinary()

            text(
                """
All players who cast valid unconditional ballots FOR the referendum
adopting this proposal earn a Black Ribbon"""
            )
        }

        proposal(9158) {
            title("Single resolution")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2124 by replacing the text from "A rule purporting to allow"
to "With T notice: e is the sponsor of a ripe intent created at least T
ago." (inclusive on both ends) with the following:

{

A rule purporting to allow a person to perform a tabled action allows em
to do so by announcement, indicating an intent for that action/method,
provided such action has never before been performed with respect to
that intent, and if that intent is:

* With N support: that intent is ripe, e is a sponsor or supporter of
it, and it has at least N supporters.

* Without N objections: that intent is mature and ripe, e is a sponsor
of it, and it has less than N objectors.

* With N Agoran consent: that intent is mature and ripe, e is a sponsor
or supporter of it, and it has at least N times as many supporters as it
has objectors (in which case e SHOULD list its supporters and objectors).

* With T notice: that intent is ripe, was created at least T ago, e is a
sponsor of it.

}


[Prohibit resolving the same intent twice. As a side effect, this
requires resolutions of tabled actions to "indicate" (intended to be
weaker than "specify" so that just quoting an intent without actually
referencing it counts) the intent that is being resolved, so that only
that one intent is invalidated.]"""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 9156
            AGAINST on 9157
            FOR on 9158
        }

        votes(juan) {
            PRESENT on 9156
            FOR on 9157
            endorse(Janet) on 9158
        }

        votes(lare290) {
            AGAINST on 9156
            FOR on 9157
            PRESENT on 9158
        }

        votes(Mischief) {
            FOR on 9156
            FOR on 9157
            AGAINST on 9158
        }

        votes(Gaelan) {
            PRESENT on 9156
            FOR on 9157
            AGAINST on 9158
        }

        votes(Immae) {
            FOR on 9156
            FOR on 9157
            PRESENT on 9158
        }

        votes(Kate) {
            AGAINST on 9156
            AGAINST on 9157
            AGAINST on 9158
        }

        votes(Yachay) {
            AGAINST on 9156
            FOR on 9157
            PRESENT on 9158
        }

        votes(Janet) {
            AGAINST on 9156
            AGAINST on 9157
            AGAINST on 9158
        }

        votes(Forest) {
            AGAINST on 9157
        }

        votes(Murphy) {
            PRESENT on 9156
            AGAINST on 9157
            FOR on 9158
        }
    }
}
