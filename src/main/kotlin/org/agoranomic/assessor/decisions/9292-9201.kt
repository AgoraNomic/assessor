package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorseOfficer
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9292to9301() = assessment {
    name("9292-9301")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Cosmo
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Numerator"(1) heldBy Trigon
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }


    proposals(v4) {
        proposal(9292) {
            title("Fashionable Manners Take II")
            ai("1.0")
            author(Mischief)
            coauthors(Trigon)
            ordinary()

            text(
                """
Amend rule 2713 (Scoring Numbers) by replacing "timely manner" with
"timely fashion""""
            )
        }

        proposal(9293) {
            title("Infractions are fine, really")
            ai("2.0")
            author(Janet)
            coauthors(Cosmo, Mischief)
            ordinary()

            text(
                """
Amend Rule 2451 ("Executive Orders") by replacing the list item
(excluding the preceding hyphen) beginning "Dive (Referee)" with the
following:

{

Dive (Referee): The Prime Minister grants a specified player two blots.
Rules to the contrary notwithstanding, the reason for the fine may be
any grievance held by the Prime Minister, not necessarily a violation of
the rules, against the person to whom the blots are granted.

}


Amend Rule 2531 ("Defendant's Rights") by replacing "it does not include
the specific reason for the fine" with "it does not describe the
specific infraction that occurred".

Amend Rule 2450 ("Pledges") by replacing "in determining an appropriate
fine" with "in determining an appropriate penalty"."""
            )
        }

        proposal(9294) {
            title("In a timely something")
            ai("2.0")
            author(Murphy)
            coauthors(Trigon)
            ordinary()

            text(
                """
Amend Rule 1023 (Agoran Time) by replacing this text:

       The phrase "in a timely fashion" means "within 7 days".

with this text:

       The phrase "in a timely fashion" (syn. "in a timely manner") means
       "within 7 days"."""
            )
        }

        proposal(9295) {
            title("Overexertion v1.11")
            ai("1.0")
            author(Murphy)
            coauthors(ais523, Nilrem)
            ordinary()

            text(
                """
If Rule 2683 (The Boulder) defines Instability, then amend it by
replacing "ceiling(S/(P+V))" with "ceiling(S/(P+W))". Otherwise, amend
it by replacing this text:

       Each player CAN, once a week, by announcement, push the boulder.
       When a player pushes the Boulder, its Height is increased by 1.
       At the beginning of each week, if the boulder was pushed in the
       previous week at least as many times as the Boulder's Slope, then
       the Boulder's Slope is increased by 1; otherwise, the Boulder's
       Height is set to 0, and the Boulder's Slope is set to 1. The
       Absurdor SHOULD list the largest Height and Slope of the Boulder
       ever reached in eir report.

with this text:

       The Boulder's Instability is an untracked integer switch,
       defaulting to 0.

       Boulder Waivers are a currency, tracked by the Absurdor. A
       player CAN pay a fee of one or more Boulder Waivers to affect
       the Boulder's Instability as described by this rule.

       When the Boulder Falls, all its switches are set to their
       default values.

       Each player CAN, once a week, by announcement, push the boulder.
       When a player pushes the Boulder, its Height is increased by 1.

       At the beginning of each week, the Boulder's Instability is set
       to ceiling(S/(P+W)), where S is its Slope, P is the number of
       distinct players who pushed it in the previous week, and W is the
       the number of Boulder Waivers spent in the previous week.

         * If P+W is zero, then the Boulder Falls.

         * Otherwise, during that week, the Absurdor SHALL select and
           announce a number of random integers from 1 to 10 (inclusive)
           equal ot the Boulder's Instability. If none of them are 1,
           then the Boulder's Instability is set to 0.

       At the end of each week, if the Boulder's Instability is greater
       than zero, then the Boulder Falls.

[Make it possible, though unreliable, for a smaller set of players to
  push the Boulder up a steeper Slope. Methods and incentives for
  obtaining Boulder Waivers is left to future proposals, e.g. ais523
  suggested buying them with Spendies.]"""
            )
        }

        proposal(9296) {
            title("Historical gaps")
            ai("2.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2139 (The Registrar) by replacing this text:

       The Registrar's monthly report includes:

       1. For each former player for which the information is reasonably
          available, the dates on which e registered and deregistered.

with this text:

       The Registrar's monthly report includes:

       1. For each current or former player for which the information is
          reasonably available, the dates on which e registered and
          deregistered.

[Monthly Registrar reports have long included this info for current
  players anyway, this just formally includes it in the definition.]"""
            )
        }

        proposal(9297) {
            title("Whoops")
            ai("1.5")
            author(Mischief)
            ordinary()

            text(
                """
Repeal rule 2699 (Contests)

[I should have included this in P9266 ("Repeal Candles"). This switch
isn't otherwise used.]"""
            )
        }

        proposal(9298) {
            title("Daylight Wasting Time")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
Amend rule 1023 (Agoran Time) by replacing the text reading:

          c. they occur in two consecutive Agoran months on the same day
             of the month, and the later of the two occurs at the same or
             earlier time of day.

with:

          c. they occur in two consecutive Agoran months on the same day
             of the month, and the later of the two occurs at the same or
             earlier UTC time of day.

[Sidesteps any potential for daylight saving or other local time
shenanigans.]"""
            )
        }

        proposal(9299) {
            title("Fix Continuity")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 1586, change
{{{
entity that had that name when the rule first came to include that
reference
}}}
to
{{{
entity that had that name when the rule/contract/regulation first came
to include that reference
}}}

[Without the fix, this has a broken reference when a contract or
regulation refers to an entity by name.]"""
            )
        }

        proposal(9300) {
            title("Fix Election Notices")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2651, change
{{{
Once per quarter, the ADoP CAN and SHALL publish a Notice of
Election specifying between 2-4 term-limited offices (if there
fewer than 2 term-limited offices, the ADoP MUST instead list all
them).  Such a notice initiates elections for the specified
offices.  The ADoP SHOULD prioritize offices that have gone
longest since their last elections.
}}}
to
{{{
Once per quarter, the ADoP SHALL publish a document, labeled as a
Notice of Election, that specifies 2-4 term-limited offices for which
elections can be initiated (if fewer than 2 such offices exist, the
notice MAY instead specify all such offices). The first time each
quarter the ADoP does so, elections are initiated for the specified
offices.  The ADoP SHOULD prioritize offices that have gone
longest since their last elections.
}}}

[The old text is broken in a few ways: "can publish a Notice of X" is a
bit confusing and IIRC we're moving away from that terminology; it
isn't clear what happens if the ADoP attempts to do it multiple times;
and it doesn't handle offices that are term-limited but that cannot
have elections initiated (e.g. because there's already an ongoing
election).]"""
            )
        }

        proposal(9301) {
            title("Impeachment removes")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2573, change
{{{
Any player CAN, with 2 Agoran consent, expel (impeach) the holder
of a specified voluntary office.
}}}
to
{{{
Any player CAN, with 2 Agoran consent, expel (impeach) the holder
of a specified voluntary office, causing the office to become vacant.
}}}
[The current rule may be redefining "impeach"/"expel" to cause an
election, which would not cause the office to become vacant.]"""
            )
        }
    }

    voting {
        votes(Cosmo) {
            PRESENT on 9292
            FOR on 9293
            FOR on 9294
            FOR on 9295
            endorseOfficer("Registrar", juan) on 9296
            FOR on 9297
            FOR on 9298
            FOR on 9299
            AGAINST on 9300
            FOR on 9301
        }

        votes(Mischief) {
            FOR on 9292
            FOR on 9293
            FOR on 9294
            AGAINST on 9295
            FOR on 9296
            FOR on 9297
            FOR on 9298
            FOR on 9299
            FOR on 9300
            FOR on 9301
        }
    }
}
