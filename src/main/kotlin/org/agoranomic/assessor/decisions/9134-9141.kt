package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9134to9141() = assessment {
    name("9134-9141")
    quorum(6)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy nix
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy null
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Jimmy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Simplifior"(1) heldBy juniper
                "Speaker"(0) heldBy Jaff
                "Spendor"(1) heldBy nix
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9134) {
            title("It takes two")
            ai("1.0")
            author(snail)
            coauthors(ais523)
            ordinary()

            text(
                """
[Adjusts the number of bangs needed to eliminate a player to two. This
should encourage trading and slow down rounds.]

Amend the rule with title "Bang!" by replacing "by paying a fee of 1 bang."
with "by paying a fee of 2 bangs.""""
            )
        }

        proposal(9135) {
            title("Ammo Store")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Enact a new Rule with title "Ammo Store" and the following text:

{
Each player CAN grant emself 1 bang by paying a fee of 13 spendies.
}"""
            )
        }

        proposal(9136) {
            title("Sorting out sortition")
            ai("3.0")
            author(Janet)
            coauthors(Kate, Mischief)
            democratic()

            text(
                """
Amend Rule 2691 ("Sortition Procedure") by, as a single amendment,
replacing the pargraph
{
At the beginning of each quarter, the ADoP CAN by announcement, and
SHALL in a timely manner, initiate a sorition for each sortitioned
office if e has not already done so for that office.
}
with the following paragraphs:
{
A player CAN by announcement initiate a sortition for a vacant
sortitioned office for which a sortition is not ongoing. At the
beginning of each quarter, for each sortitioned office for which a
sortition is not ongoing, the ADoP CAN once by announcement, and SHALL
in a timely fashion, initiate a sortition.

Rules to the contrary notwithstanding, a sortition CANNOT be initiated
for an office for which a sortition is ongoing.
}
and by appending the following paragraph:
{
If a sortition is ever ongoing for a non-sortitioned office (or for an
office that no longer exists), that sortition immediately ends.
}

[Ensure at most one sortition for an office can be ongoing, allow
sortitioning vacant sortition offices, and handle the edge case of the
rules changing during a sortition.]

Amend Rule 1006 ("Offices") by replacing the paragraphs
{
Imposed offices and sortitioned are offices described as such by the
rules that define them. All other offices are elected A person CANNOT be
made the holder of an elected office without eir explicit or reasonably
implied consent.

The holder of an elected office CAN resign it by announcement, causing
it to become vacant. The non-interim holder of an elected office CAN,
with 3 support, resign the office while appointing another player to
become the holder of the office, provided that other player is one of
the Supporters. Any player CAN cause an office to become vacant without
2 objections.
}
with the following paragraphs:
{
Imposed offices and sortitioned offices are offices described as such by
the rules that define them. All other offices are elected. An office is
voluntary if and only if it is elected or sortitioned. The selection
method for a sortitioned office is a sortition for that office. The
selection method for an elected office is an election for that office.

A person CANNOT be made the holder of a voluntary office without eir
consent. A person voluntarily entering emself into the selection method
of that office always satisfies this requirement, regardless of whether
it meets the normal definition of consent.

The holder of a voluntary office CAN resign it by announcement, causing
it to become vacant. Any player CAN cause a voluntary office to become
vacant without 2 objections.

The non-interim holder of an elected office CAN, with 3 support, resign
the office while appointing another player to become the holder of the
office, provided that other player is one of the supporters.
}

[Allow resigning sortitioned offices. Ensure sortitioned offices are
protected with consent. Replace "explicit or reasonably implied consent"
with the normal definition and ensure becoming a candidate/option always
meets it. Restrict w/o 2 objections removal to voluntary offices.]

Amend Rule 2573 ("Impeachment") by replacing the text "elected office"
with the text "voluntary office" and by replacing the text "an election
is immediately opened for that office" with the text "the selection
method for that office is immediately initiated (if possible)".

[Allow impeachment for sortitioned offices.]

Amend Rule 2160 ("Deputisation") by replacing the text "elected office"
with the text "voluntary office".

[Allow deputizing for sortitioned offices.]

Amend Rule 2438 ("Ribbons") by replacing the text "elected office" with
the text "voluntary office".

[Allow sortitioned offices to count for green ribbons.]"""
            )
        }

        proposal(9137) {
            title("A possible patch for a peculiar persisting pledge paradox")
            ai("1.7")
            author(Quadrantal)
            coauthors(Aris)
            ordinary()

            text(
                """
[A fix for pledge indeterminacy (see CFJ 3907). Defaults to the pledge
having been violated, as the infraction system seems to have enough
flexibility to forgive pledges that are broken on a technicality]

Amend Rule 2450 ("Pledges") by appending to the first paragraph as follows:
{
If it would otherwise be indeterminate whether a player has violated a
pledge, then e shall be deemed to have violated that pledge.
}"""
            )
        }

        proposal(9138) {
            title("Stone cost adjustments")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2642 by, as a single amendment:

* Appending the following to the paragraph beginning "Any player CAN": "
When this occurs, the stone cost of that stone is set to its default
value.".

* Replacing the paragraph beginning "At the beginning of each week" with
the following paragraph:

{

At the beginning of each Agoran week, the Stone Cost of each stone is
decreased by 1 (to a minimum of 1). When a stone is transferred to
Agora, its Stone Cost is reset to its default value.

}


[Go back to something close to the old system, since the current system
just results in stone costs decreasing forever. Slightly tweaked so
that, e.g., the Soul Stone doesn't reset costs. If you want the
protection of the higher cost, you should have to pay for it.]"""
            )
        }

        proposal(9139) {
            title("Protection Stone Fix")
            ai("2.0")
            author(Mischief)
            coauthors(Janet)
            ordinary()

            text(
                """
[Under the current rules, whenever the Protection Stone is protecting
itself
and ends up in Agora's possession, it's stuck there permanently.]

Amend rule 2640 (Stones) by replacing

       A stone is immune if and only if a rule of power 2 or more says it
       is immune; otherwise it is non-immune.

with:

       A stone is immune if and only if a rule of power 2 or more says it
       is immune and it is not owned by Agora; otherwise it is non-immune."""
            )
        }

        proposal(9140) {
            title("Whoops, missed one")
            ai("2.0")
            author(Quadrantal)
            coauthors(Janet)
            ordinary()

            text(
                """
[P9096 failed, so Growth was never repealed. This is the language from that
proposal]

Amend Rule 2451 ("Executive Orders") by deleting the list item
(including the bullet point) that contains "Growth""""
            )
        }

        proposal(9141) {
            title("Time for some clarifications")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 1023 ("Agoran Time")  to read, in full:

{

The following terms are defined:

 1. The phrase "in a timely fashion" means "within 7 days". This time
    period is set when the requirement is created (i.e. X days before
    the limit ends). A requirement to perform an action at an exact
    instant (e.g. "when X, Y SHALL Z"), but not "in the same message",
    is instead interpreted as a requirement to perform that action in a
    timely fashion after that instant.
 2. The phrase "in an officially timely fashion" means "before the end
    of the next Agoran week". This time period is set when the
    requirement is created (i.e. between 7 and 14 days before the period
    ends).
 3. Agoran epochs:
     a. Agoran days begin at midnight UTC.
     b. Agoran weeks begin at midnight UTC on Monday. Eastman weeks
        begin at midnight UTC on the 1st, 8th, 15th, 22nd, and 29th of
        each Gregorian month; the fifth one of the month (if any) lasts
        till the end of the month.
     c. Agoran months begin at midnight UTC on the first day of each
        Gregorian month.
     d. Agoran quarters begin when the Agoran months of January, April,
        July, and October begin.
     e. Agoran years begin when the Agoran month of January begins.
     f. A pivot is either the instant at which Agora Nomic began (June
        30, 1993, 00:04:30 GMT +1200) or an instant at which at least
        one person won the game. When used as a period of time, a
        "Round" (historical syn: "game") is the period of time between a
        pivot and the next pivot.
    The "Agoran" qualifier is assumed unless a different definition is
    indicated (e.g. Eastman weeks). These definitions do not apply to
    relative durations (e.g. "within <number> days after <event>").
 4. Two points in time are within a month of each other if:
     a. they occur in the same Agoran month;
     b. they occur in two consecutive Agoran months, and the later of
        the two occurs in an earlier day in the month than the earlier one;
     c. they occur in two consecutive Agoran months on the same day of
        the month, and the later of the two occurs at the same or
        earlier time of day.
 5. Any anniversary, monthly anniversary, or quarterly anniversary that
    would otherwise occur on a day of the month that does not exist
    (after considering any leap day) instead occurs on the following day.

}


[Converge after the question for P9123, and renumber the sub-lists to
use letters. This is a "read in full" amendment because of the question
and because it would be a nightmare to try to specify the changes.]"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9134
            FOR on 9135
            FOR on 9136
            FOR on 9137
            FOR on 9138
            FOR on 9139
            FOR on 9140
            endorse(Janet) on 9141
        }

        votes(ais523) {
            FOR on 9134
            AGAINST on 9135
            FOR on 9136
            FOR on 9137
            FOR on 9138
            FOR on 9139
            FOR on 9140
            PRESENT on 9141
        }

        votes(Janet) {
            FOR on 9134
            AGAINST on 9135
            FOR on 9136
            FOR on 9137
            FOR on 9138
            FOR on 9139
            FOR on 9140
            FOR on 9141
        }

        votes(juniper) {
            FOR on 9134
            AGAINST on 9135
            FOR on 9136
            FOR on 9137
            FOR on 9138
            FOR on 9139
            FOR on 9140
            FOR on 9141
        }

        votes(juan) {
            PRESENT on 9134
            PRESENT on 9135
            FOR on 9136
            FOR on 9137
            PRESENT on 9138
            PRESENT on 9139
            FOR on 9140
            FOR on 9141
        }

        votes(Yachay) {
            FOR on 9134
            AGAINST on 9135
            PRESENT on 9136
            AGAINST on 9137
            FOR on 9138
            FOR on 9139
            FOR on 9140
            FOR on 9141
        }
    }
}
