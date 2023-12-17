package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9040to9045() = assessment {
    name("9040-9045")
    quorum(5)

    proposals(v4) {
        proposal(9040) {
            title("Adoption AI security")
            ai("1.0")
            author(Janet)
            coauthors(ais523)
            ordinary()

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

        proposal(9041) {
            title("Repeal 107")
            ai("3.0")
            author(Forest)
            coauthors(Murphy)
            democratic()

            text(
                """
Repeal Rule 107 ("Initiating Agoran Decisions")"""
            )
        }

        proposal(9042) {
            title("Repeal 2464")
            ai("1.0")
            author(Forest)
            coauthors(Murphy)
            ordinary()

            text(
                """
Repeal Rule 2464 ("Tournaments")"""
            )
        }

        proposal(9043) {
            title("Repeal 2676")
            ai("1.7")
            author(Forest)
            coauthors(Murphy)
            ordinary()

            text(
                """
Repeal Rule 2676 ("Forgiveness")"""
            )
        }

        proposal(9044) {
            title("Repeal 2573")
            ai("2.0")
            author(Forest)
            coauthors(Murphy)
            ordinary()

            text(
                """
Repeal Rule 2573 ("Impeachment")"""
            )
        }

        proposal(9045) {
            title("Repeal 879")
            ai("3.0")
            author(Forest)
            coauthors(Murphy)
            democratic()

            text(
                """
Repeal Rule 879 ("Quorum")"""
            )
        }
    }
}
