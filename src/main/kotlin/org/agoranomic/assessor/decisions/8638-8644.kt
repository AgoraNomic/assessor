package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty

@UseAssessment
fun assessment8638to8644() = assessment {
    name("8638-8644")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Madrid, 7 / 3)
        blotPenalty(Trigon, 4 / 3)
        blotPenalty(nix, 4 / 3)
        blotPenalty(cuddlybanana, 3 / 3)
    }

    proposals(v4) {
        proposal(8638) {
            title("Cyan Ribbon Patch")
            ai("3.0")
            author(Secretsnail9)
            democratic()
            sponsored()

            text("""
Amend Rule 2438 (Ribbons) by replacing "Cyan (C): When a person
deputises for an office, that person earns a Cyan Ribbon" with
"Cyan (C): When a person deputises for an office, and that person has not
held or deputized for that office within the past 7 days, that person earns
a Cyan Ribbon".

[Fixes an issue which lets a player repeatedly deputize for an office and
award emself up to 5 cyan glitter.]""")
        }

        proposal(8639) {
            title("sole quorum")
            ai("3.0")
            author(G)
            democratic()
            sponsored()

            text("""
Amend Rule 879 (Quorum) by changing its power to 3.

[the basic definition of quorum should be power-3 along with the rest of
voting, right?]


Amend Rule 879 (Quorum) by replacing:
  As an exception to the previous paragraph, the quorum of an
  Agoran decision can never be less than 2. If the rules would
  attempt to set the quorum of an Agoran decision to less than 2,
  it is set to 2 instead.
with:
  As an exception to the previous paragraph, the minimum quorum of
  an Agoran decision is 2, or 1 if there are fewer than 2 players in
  the game. If the rules would attempt to set the quorum of an Agoran
  decision to less than the minimum quorum, it is set to the minimum
  instead.

[If 1 person is the only player, that should be quorum.  Less than 1 is
game-breaking trouble, so minimum=1 protects extra against the final
deregistration]""")
        }

        proposal(8640) {
            title("Minor ruleset edits")
            ai("2.0")
            author(RLee)
            ordinary()
            sponsored()

            text("""
Amend rule 1023, "Agoran Time" by removing the text "Eastman
weeks begin at midnight UTC on the 1st, 8th, 15th, 22nd,
and 29th of each Gregorian month; the fifth one of the
month (if any) lasts till the end of the month."

and by removing the text

"(e.g. Eastman weeks)"


Amend rule 2531, "Defendant's Rights" by removing the last semicolon
and the last "or" after section (9) and by inserting the text " or"
between the word "Finger" and the semicolon at the end of section (8).

Retitle rule 2531, "Defendant's Rights" to "Defendants' Rights"""")
        }

        proposal(8641) {
            title("Degrees are for persons")
            ai("2.0")
            author(Jason)
            coauthors(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 1367 ("Degrees") by replacing "A specified degree CAN be
awarded" with "A specified degree CAN be awarded to a person".

[Require that degrees are given to persons for their hard work, rather
than arbitrary entities.]""")
        }

        proposal(8642) {
            title("Hot Potato patch v2")
            ai("2.0")
            author(Jason)
            coauthors(Oerjan)
            ordinary()
            sponsored()

            text("""
Amend Rule 2645 (The Stones) by replacing "This stone cannot otherwise
be transferred" with "If this stone is not owned by Agora, it cannot
otherwise be transferred".

[Allows transferring the Hot Potato stone from Agora in order to allow
it to actually be auctioned off.]""")
        }

        proposal(8643) {
            title("Firing Judge Dredd")
            ai("1.7")
            author(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2478 (Vigilante Justice) by replacing:
  The above notwithstanding, the investigator CANNOT resolve a
  Finger Pointing for which e is the perp.
with:
  The above notwithstanding, the investigator CANNOT resolve a
  Finger Pointing for which e is the perp or the finger-pointer.


[if referee is vacant, someone could point a finger and deputise to
resolve it in the same message - independence needed].""")
        }

        proposal(8644) {
            title("Device repeal patch")
            ai("1.0")
            author(Jason)
            coauthors(ais523)
            ordinary()
            sponsored()

            text("""
Amend Rule 2655 by replacing "repeal both that rule and this one" with
"repeal that rule, then this one".""")
        }
    }

    voting {
    }
}
