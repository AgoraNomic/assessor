package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9373to9374() = assessment {
    name("9373-9374")
    quorum(7)

    proposals(v4) {
        proposal(9373) {
            title("Dim Prospects v1.1")
            ai("1.5")
            author(Mischief)
            coauthors(snail)
            ordinary()

            text(
                """
[Adding new terms to make the various antecedants more obvious. The one
in the current third bullet is borderline ambiguous, for example; the
intent -- I think -- is to refer to the winning player but it could get
misread as referring to "each other player" in the prior bullet. This
should also reduce the risk of a subsequent amendment breaking an
antecedant somewhere. Additionally, changes a singular "their" to "eir"
in the fifth bullet.]

Amend rule 2711 (Outshining the Sun) by replacing the text reading:

       When a player Outshines the Sun, e wins the game. When a player
       wins the game this way, the following happen in order:

       * Eir radiance is set to 0.

       * The radiance of each other player is set to half its current
         value (rounded down).

       * All Pyrite in eir possession is destroyed.

       * Half of all Pyrite in each other player's possession, rounded
         up, is destroyed.

       * For each player with more than 4000 Pyrite, all but 4000 Pyrite
         in their possession is destroyed.

       * The Fields Wither.

       * All Hectares are destroyed.

       * Each player is granted 16 Hectares.

with:

       When a pure player Outshines the Sun, the following happen in
       order:

       * That player (the Luminary) wins the game.

       * The Luminary's radiance is set to 0.

       * The radiance of each other player (each: a Dim One) is set to
         half its current value (rounded down).

       * All Pyrite in the Luminary's possession is destroyed.

       * Half of all Pyrite in each Dim One's possession, rounded up, is
         destroyed.

       * For each player with more than 4000 Pyrite, all but 4000 Pyrite
         in eir possession is destroyed.

       * The Fields Wither.

       * All Hectares are destroyed.

       * Each player is granted 16 Hectares."""
            )
        }

        proposal(9374) {
            title("Tying Up White Ribbons")
            ai("3.0")
            author(Galle)
            democratic()

            text(
                """
Amend Rule 2438 ("Ribbons") by replacing the following text:
---
White (W): A player qualifies for a White Ribbon if e has never
previously owned a White Ribbon (including under previous rulesets). A
player who has been registered for the past 30+ days or 180+ cumulative
days and has never acted on eir own behalf to cause another person to
gain a White Ribbon (including under a previous ruleset) CAN act on eir
own behalf to cause another person to earn a White Ribbon by announcement.
---

With the following text:
---
White (W): A player qualifies for a White Ribbon if e has never
previously owned a White Ribbon (including under previous rulesets). A
player who has been registered for the past 30+ days or 180+ cumulative
days and has never acted on eir own behalf to cause another person to
earn or gain a White Ribbon (including under a previous ruleset) CAN act
on eir own behalf to cause another person to earn a White Ribbon by
announcement.
---

[The current version of White Ribbons has a possible loophole: players
"gift" White Ribbons by causing other players to EARN White Ribbons, and
then in response Rule 2438 itself causes the earning player to GAIN a
White Ribbon. However, the "you can only do this once" clause only
checks to see if the player has previously directly caused another
player to gain a White Ribbon. You could argue that the current
mechanism counts, because there's a clear chain of causality from
earning to gaining, but given the technical nature of the language here
I think there's definitely a case to be made that the blocking clause
simply doesn't work as-is. The "gain" wording is kept in to make sure
everyone who was already blocked is still blocked.]"""
            )
        }
    }
}
