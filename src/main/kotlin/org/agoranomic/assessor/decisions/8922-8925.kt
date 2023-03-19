package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment8922to8925() = assessment {
    name("8922-8925")
    quorum(5)

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
}
