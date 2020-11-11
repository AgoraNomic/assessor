package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.speakerBonus
import org.agoranomic.assessor.lib.proposal.MinistryV2.Compliance
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8522() = assessment {
    name("8522")
    quorum(9)

    strengths {
        default(3)
        min(0)
        max(15)

        speakerBonus(G)
        blotPenalty(RLee, 81 / 3)

        // Ministries are broken as of this resolution due to a bug in P8515:
        //    For each item of each office's Ministry Interest, that office's
        //    holder's voting strength is increased by 2 on proposals whose
        //    Ministry Impact is set to that Ministry.
        // "Ministry Impact" is not defined.
    }

    proposals(v3) {
        proposal(8522) {
            title("Theftn't")
            ai("2.0")
            author(ATMunn)
            coauthors(Jason)
            chamber(Compliance)

            text("""
Amend Rule 2531 to read, in whole:
{

Any attempt to levy a fine is INEFFECTIVE if it does not include value
of the fine in blots, the name of the person being fined (the perp), and
the specific reason for the fine.

Any attempt to levy a fine pursuant to the imposition of the Cold Hand
of Justice is INEFFECTIVE if:

  (1) it attempts to levy a fine on a person when that person can't be
established by a preponderance of the evidence to have committed the
action or inaction for which the fine was levied;

  (2) it attempts to levy a fine for an action or inaction which, at the
time the inaction or action occurred, was not prohibited by the rules;

  (3) it attempts to levy a fine on a person for failure to take an
action that e, through no fault of eir own, COULD NOT have performed;

  (4) it attempts to levy a fine on a person for conduct that e, through
no fault of eir own, was obliged to undertake by a rule of equal or
greater power to the one e violated;

  (5) it attempts to levy a fine on a person taking an action or inaction
e could not have avoided when exercising the highest reasonably possible
standard of care;

  (6) it attempts to levy a fine with a value that is blatantly and
obviously unsuited to the conduct which constitutes the reason for its
levy or to the person on whom it is being levied;

  (7) it attempts to levy a fine based upon the investigation of of a
Finger that had been Pointed more than 14 days after the action
constituting the reason for the fine;

  (8) it attempts to levy a fine on a player for failing to take an
action within the time period set by the Rules and that time period had
expired more than 14 days prior to the Pointed Finger, if the fine is
imposed based on an investigation of such Finger;

  (9) it attempts to levy a fine on a player who has already been fined
for the conduct constituting the reason for the levy; or

(10) it attempts to levy a fine on a zombie for an action that its
master performed on its behalf.

} 
"""
            )
        }
    }

    voting {
        votes(Jason) {
            FOR on 8522
        }

        votes(BaronVV) {
            endorse(Jason) on 8522
        }
    }
}
