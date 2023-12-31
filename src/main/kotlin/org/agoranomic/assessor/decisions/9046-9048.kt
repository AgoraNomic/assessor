package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9046to9048() = assessment {
    name("9046-9048")
    quorum(6)

    proposals(v4) {
        proposal(9046) {
            title("Crystal fix 1")
            ai("1.0")
            author(Forest)
            coauthors(ais523, Gaelan)
            ordinary()

            text(
                """
Amend Rule 2685 ("Crystals") by replacing {
The size of that crystal is increased by the power of that
        proposal (rounded down).
} with {
The size of that crystal is increased by the power of that
        proposal when that proposal's power was greater than 0 (rounded
down).
}

Amend Rule 2685 ("Crystals") by replacing {
Each quarter, each crystal whose identity is not equal to the ID
      of any rule in the current ruleset has its size increased by 3.
} with {
At the beginning of each quarter, each crystal whose identity is not equal
to the ID
      of any rule in the current ruleset has its size increased by 3.
}

Change the size of crystal 2659 to 1."""
            )
        }

        proposal(9047) {
            title("Shameless copy of Adoption AI Security with the right AI")
            ai("3.0")
            author(Forest)
            coauthors(Janet, ais523)
            democratic()

            text(
                """
Amend Rule 1607 ("Distribution") by deleting the text ", or 1.0 if the
proposal does not have one".

[A proposal always has a numeric AI, so this clause can never be
triggered. And, even if it could be triggered, this isn't the right
behavior (AI 3 would be a more sensible default, but we don't add that
here because it's impossible).]


Amend Rule 106 ("Adopting Proposals") by replacing "its power is set to
the minimum of four and its adoption index" with "its power is set to
the minimum of four, the adoption index of the proposal, and the
adoption index of the referendum".

[Defend against any case where a proposal does not have an AI but the
referendum does, or where the referendum has a lower AI than the proposal.]


[Currently, these issues combine so that if there were somehow a
proposal without an AI (which cannot exist not but has been possible in
the past, according to ais523), it would be voted on at AI 1.0 but
adopted at power 4; this fixes both: it would no longer be
distributable, and if it were to take effect it would only take effect
at power 1.]"""
            )
        }

        proposal(9048) {
            title("It's been 4+ years, Agora. 4+ YEARS.")
            ai("3.0")
            author(nix)
            coauthors(Forest, snail)
            democratic()

            text(
                """
Ratify the Short Logical Ruleset published on the 19th of June, 2023,
available here [1].

[1]
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2023-June/017167.html"""
            )
        }
    }
}
