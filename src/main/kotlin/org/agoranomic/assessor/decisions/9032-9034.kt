package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9032to9034() = assessment {
    name("9032-9034")
    quorum(6)

    proposals(v4) {
        proposal(9032) {
            title("Rules as Items v6")
            ai("1.0")
            author(Forest)
            coauthors(Janet, kiako, snail)
            ordinary()

            text(
                """
Enact the following rule entitled "Crystals":{
The Geologist is an office that tracks crystals.

A crystal is an asset with secured integer switches identity, size (default
0), and instability (default 0).

Each quarter, each crystal whose identity is not equal to the ID of any
rule in the current ruleset has its size increased by 3.

If a proposal amends or repeals a rule, if a crystal exists whose identity
equals that rule's id, that crystal absorbs that proposal. Otherwise, grant
to the author of the proposal a crystal with identity equal to the ID of
that rule, then that crystal absorbs that proposal. Each crystal can only
absorb a given proposal once by this method.

When a crystal absorbs a proposal, the following occur in sequence:
- The size of that crystal is increased by the power of that proposal
(rounded down).
- If that crystal's owner is not the author of that proposal, the
instability of that crystal is increased by 3.
- If the instability of that crystal is greater than its size, it is
transferred to the author of the proposal, then its instability becomes
equal to its size.

A player is crystallized if the total size of crystals e owns is at least
the number of rules in the current ruleset.

Any player CAN, by announcement, Shatter the System, specifying each
crystallized player, and provided that no player has done so in the past 30
days. When a player does so, each crystallized player wins the game.

If at least 4 days have passed since any player won the game in this
manner, any player CAN repeal this rule by announcement.
}"""
            )
        }

        proposal(9033) {
            title("It's been 4 years, Agora. 4 YEARS.")
            ai("3.0")
            author(Forest)
            coauthors(Janet, nix, snail)
            democratic()

            text(
                """
Ratify the Short Logical Ruleset published on the 19th of June, 2023,
available here [1].

[1]
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2023-June/017167.html"""
            )
        }

        proposal(9034) {
            title("A simple fix")
            ai("1.0")
            author(snail)
            coauthors(nix)
            ordinary()

            text(
                """
[We tried to fix this back in April but it got wrapped up in a bigger stamp
rework proposal, which failed.]

Amend R2659 (Stamps) by replacing:

      Any player CAN win by paying N Stamps

with:

      Any active player CAN win by paying N Stamps"""
            )
        }
    }
}
