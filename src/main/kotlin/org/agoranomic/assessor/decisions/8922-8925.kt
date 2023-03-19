package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.AGAINST
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8922to8925() = assessment {
    name("8922-8925")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)

            powerStone(snail, 6)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy nix
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Horsened"(1) heldBy snail
                "Mad Engineer"(1) heldBy Janet
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy nix
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Janet
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8922) {
            title("What's a paragraph anyway?")
            ai("1.0")
            author(G)
            ordinary()

            text(
                """
Amend Rule 2429 (Bleach) by replacing:
      Replacing a non-zero amount of whitespace with a different
      non-zero amount of whitespace is generally insignificant, except
      for paragraph breaks.
with:
      Replacing a non-zero amount of whitespace with a different
      non-zero amount of whitespace is generally insignificant, except
      if doing so substantially changes the semantic, logical, or
      artistic structure of the text."""
            )
        }

        proposal(8923) {
            title("Department of Defense")
            ai("2.0")
            author(G)
            ordinary()

            text(
                """
Amend Rule 2451 (Executive Orders) by appending the following list item:
      - Research Funding (Mad Engineer): The Prime Minister specifies
an existing
      Rule.  Rules to the contrary notwithstanding, the Mad Engineer CAN and
      SHALL use that rule instead of making a random rule selection as
part of eir weekly
      duties for the following week."""
            )
        }

        proposal(8924) {
            title("A Populist PM")
            ai("2.0")
            author(G)
            coauthors(Janet)
            ordinary()

            text(
                """
Amend Rule 2451 (Executive Orders) by appending the following list item:
      - Proxy (Assessor): The Prime Minister specifies another active
        player.  A player's voting strength on an ordinary referendum
        is increased by 4 for each time Proxy was specified for em in
        its voting period."""
            )
        }

        proposal(8925) {
            title("Codify Conditionality")
            ai("3.0")
            author(G)
            coauthors(Janet, Murphy)
            democratic()

            text(
                """
[Since a recent win was performed with a slightly-complex conditional
action, there has been discussion in DIS and on discord about
codifying conditional actions.  There is much debate and difference of
approach in the Discord discussion, but it would be good not to stall
out.  This paragraph is intended to essentially change no mechanics,
and legislatively codify our current common-law precedent - thus
acknowledging that conditionals exist at least, which can be changed
in later proposals].

Amend Rule 2518 (Determinacy) by appending the following paragraph:
      A communication purporting to express conditional intent to
      perform an action is considered unclear and ambiguous unless, at a
      minimum, the conditional is determinate, true, and reasonably
      straightforward to evaluate with publicly-available information at
      the time of communication. The communicator SHOULD explain
      specific reasons for being uncertain of the outcome when e makes
      the communication."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 8922
            FOR on 8923
            AGAINST on 8924
            FOR on 8925
        }

        votes(G) {
            FOR on all
        }

        votes(Forest) {
            endorse(cuddlybanana) on 8922
            endorse(snail) on 8923
            endorse(Murphy) on 8924
            endorse(G) on 8925
        }
    }
}
