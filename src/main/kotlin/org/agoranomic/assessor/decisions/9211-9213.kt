package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9211to9213() = assessment {
    name("9211-9213")
    quorum(6)

    proposals(v4) {
        proposal(9211) {
            title("De-Convoluting Mooting v1.1")
            ai("1.7")
            author(Kate)
            coauthors(Mischief)
            ordinary()

            text(
                """
Amend Rule 911, "Motions and Moots", by replacing the following text:

      If a judgement has been in effect for less then seven days and has
      not been entered into Moot, then:

      - The judge of that CFJ CAN self-file a Motion to Reconsider the
        case by announcement, if e has not already self-filed a Motion
        to Reconsider that CFJ.
      - Any Player CAN group-file a Motion to Reconsider the case with 2
        support, if the CFJ has not had a Motion to Reconsider
        group-filed for it at any time while it has been assigned to its
        current judge.

      When a Motion to Reconsider is so filed, the case is rendered open
      again.

      If a CFJ has a judgement assigned, a player CAN enter that
      judgement into Moot with N+2 support, where N is the number of
      weeks since that judgement has been assigned, rounded down.

with:

      The judge of a CFJ CAN by announcement self-file a Motion to
      Reconsider it, if its most recent judgement has been in effect for
      less than seven days.

      Any player CAN with 2 support group-file a Motion to Reconsider
      a case, if its most recent judgement had been in effect for less
      than seven days at the time the intent was tabled.

      The above notwithstanding, it is IMPOSSIBLE to file a Motion to
      Reconsider a CFJ whose current judgement has been entered into
      Moot, or that has already had a Motion to Reconsider filed against
      it by the same method since it was most recently assigned to a
      judge.

      When a Motion to Reconsider a case is filed, the case is rendered
      open again.

      If a CFJ has a judgement assigned, a player CAN enter that
      judgement into Moot with N+2 support, where N is the number of
      weeks from the time the judgement was assigned to the time the
      intent was tabled, rounded down.

COMMENTS:

This is attempting to fix the support requirement for Moots so that it
can be predicted at the time the intent is tabled. Currently, it's
dependent on the age of the judgement at the time the intent is
*resolved*, so at the time it's tabled there are several possible values
- and each must be intended individually, because the support
requirement has to be explicitly stated at the time the intent is
tabled.

For consistency, I changed the support requirement for Motions to
Reconsider in the same way (even though this is not troublesome as-is)."""
            )
        }

        proposal(9212) {
            title("Incentives")
            ai("3.0")
            author(Mischief)
            democratic()

            text(
                """
[Shifts things a bit to encourage players to take up offices since we
have multiple vacancies.]

Amend rule 2422 (Voting Strength) by replacing "3" with "2" in the
sentence reading: "If not otherwise specified, the voting strength of an
entity on an Agoran decision is 3.""""
            )
        }

        proposal(9213) {
            title("Twice the pride")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2683 (The Boulder) by replacing the paragraph beginning "Each
player CAN," with this text:

       The Boulder's Slope is a singleton integer switch defaulting to 1,
       tracked by the Absurdor.

       Each player CAN, once a week, by announcement, push the boulder.
       When a player pushes the Boulder, its Height is increased by 1.
       At the beginning of each week, if the boulder was pushed in the
       previous week at least as many times as the Boulder's Slope, then
       the Boulder's Slope is increased by 1; otherwise, the Boulder's
       Height is set to 0, and the Boulder's Slope is set to 1. The
       Absurdor SHOULD list the largest Height and Slope of the Boulder
       ever reached in eir report."""
            )
        }
    }
}
