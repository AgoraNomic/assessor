package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9277to9279() = assessment {
    name("9277-9279")
    quorum(6)

    proposals(v4) {
        proposal(9277) {
            title("Bring Back Yellow")
            ai("3.0")
            author(Forest)
            coauthors(snail, Trigon, ais523, Janet)
            democratic()

            text(
                """
[persuasion: Instead of inserting subgames into the rules... we have
been inserting subgames directly into the rules, and creating the
"contests" rule.]
Amend Rule 2348 ("Ribbons") by appending another paragraph after the
one starting with "Orange (O):" with the text:
{
Yellow (Y): When a tournament that a player was a gamemaster of ends
with a winner, that gamemaster earns a Yellow Ribbon.
}"""
            )
        }

        proposal(9278) {
            title("Bring Back Science (fixing the oops)")
            ai("3.0")
            author(Forest)
            coauthors(snail, Trigon, ais523, Janet)
            democratic()

            text(
                """
Amend Rule 2348 ("Ribbons") by appending another paragraph after the
one starting with "Orange (O):" with the text:
{
Infrared (D): When a player earns an Indigo Ribbon, that player CAN,
once by announcement, grant any other person an Infrared Ribbon.
}"""
            )
        }

        proposal(9279) {
            title("Less confusing Speaker nomination")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 103, delete
{{{
If at any time the office of Speaker is
vacant, or when one or more players win Agora, then the Prime
Minister CAN once appoint a Laureled player to the office of
Speaker by announcement.
}}}
and, as a new paragraph immediately after the location from which that
text was deleted, add
{{{
The Prime Minister CAN by announcement appoint a Laureled player to the
office of Speaker if either of the following conditions apply:
a) the office of Speaker is vacant; or
b) the same person has been Speaker continuously since a player most
recently won Agora.
}}}
[The existing rule is unclear about when the win-created ability to
appoint a Speaker ends. For example, suppose a player wins twice in the
same message: under the existing rules that may create an obligation to
reinstall em as Speaker the next time a new Speaker is nominated for
non-win reasons, because only one of the two appointment permissions
was discharged at the time of eir original appointment.]"""
            )
        }
    }
}
