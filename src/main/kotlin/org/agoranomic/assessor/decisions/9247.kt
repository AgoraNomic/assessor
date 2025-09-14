package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9247() = assessment {
    name("9247")
    quorum(4)

    proposals(v4) {
        proposal(9247) {
            title("Allow no-ops")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2667 (Succumbing to Time) to read:

       A player CAN Succumb by announcement. Upon doing so, if e has not
       already Succumbed that month, then each of eir deadlines to
       perform an Officer's duty or judge a Call for Judgement is
       extended by 1 day if it would otherwise expire within the next
       week.

[My recordkeeping software currently doesn't check "did this player
  already succumb this month", though I checked the database and didn't
  find any oversights that weren't already corrected. I could get around
  to implementing a check, or alternatively I could make it only matter
  if/when someone actually bothers to note an infraction.]"""
            )
        }
    }
}