package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9227to9229() = assessment {
    name("9227-9229")
    quorum(5)

    proposals(v4) {
        proposal(9227) {
            title("Art Restoration Act")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
Amend rule 2029 (Town Fountain) by replacing "G." with "Goethe"

[That is how it was originally enacted, and it was later amended
unintentionally -- see CFJ 3902.

As a reminder, even though rule 2029 is power 4, the proposal only needs to
have an AI of 3 to satisfy rule 2140.]"""
            )
        }

        proposal(9228) {
            title("Pacifism")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Repeal Rule 2692 (Bang!).
Repeal Rule 2696 (Bang actions).
Repeal Rule 2697 (The Bounty Board).

[Vibe check.]"""
            )
        }

        proposal(9229) {
            title("Workaholics")
            ai("3.0")
            author(Murphy)
            democratic()

            text(
                """
Repeal Rule 2689 (Vacations & Delegation).

Amend Rule 2438 (Ribbons) by replacing this text:

       Cyan (C): When a person deputises for an office or is the delegate
       for an office while its holder is on vacation, and that person has
       not held or deputised for that office within the past 7 days, that
       person earns a Cyan Ribbon.

with this text:

       Cyan (C): When a person deputises for an office, and that person
       has not held or deputised for that office within the past 7 days,
       that person earns a Cyan Ribbon.

[Vibe check.]"""
            )
        }
    }
}
