package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.resolvedConditional
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9215to9223() = assessment {
    name("9215-9223")
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
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Mischief
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9215) {
            title("Predictable Judicial Timelines")
            ai("1.7")
            author(Kate)
            ordinary()

            text(
                """
Amend Rule 591 ("Delivering Judgements") by replacing "in a timely
fashion" with "in an officially timely fashion".

Comment: This moves CFJ deadlines to always be at the end of an Agoran
week, hopefully ensuring judges are less frequently caught by surprise
even if the Arbitor does not perform eir duties at the same time every
week."""
            )
        }

        proposal(9216) {
            title("Closing Off a Potential Scam")
            ai("1.5")
            author(Mischief)
            ordinary()

            text(
                """
Amend rule 2700 (Candles) by replacing "the amount of radiance to award
(N)"
with "a non-negative amount of radiance to award (N)""""
            )
        }

        proposal(9217) {
            title("Reload")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[Provides a mechanism to slowly ratchet up the pressure. The delay is
deliberately designed to avoid giving an advantage to someone who both
orders ammo and loads a round right before the end of a week.]

Amend rule 2696 (Bang actions) by adding at the end:

       A player may order more ammo by announcement if both of the
       following are true: the match state is ongoing and has not
       changed in the past 21 days; and no one has ordered more ammo in
       the current or prior week. When a player orders more ammo, at the
       end of the following week each alive player gains one bang."""
            )
        }

        proposal(9218) {
            title("Archival Grammar Adjustment")
            ai("1.0")
            author(ShyOwl)
            ordinary()

            text(
                """
Amend Rule 417 ("The Archivist") by replacing the phrase

[
* Optionally, any other documents the Archivist deems worthy
of archival.
]

with the phrase:

[
* Optionally, any other documents the Archivist deems worthy
of archival preservation.
]"""
            )
        }

        proposal(9219) {
            title("Automatic Registration")
            ai("3.0")
            author(Kate)
            coauthors(Murphy)
            democratic()

            text(
                """
Amend Rule 869, "How to Join and Leave Agora", by replacing "desire to
become a player" with "desire to be a player".

COMMENTS:

This was suggested in Murphy's comments on CFJ 4100 subsequent to its
first judgement. The objective is to allow unregistered people who
believe they have already become registered just by signing up to the
mailing list to automatically become players when they attempt to take
an action by announcement, hopefully eliminating a common pitfall.

This legislatively overturns the precedent originally set by CFJ 3776
and reaffirmed by CFJ 4100.

I'm not certain this will be a popular change; it does represent a shift
in longstanding game custom. But Agora is a game about the rules
changing, and maybe it's time for this one to. At the least, I thought
it would be good to bring it to a vote."""
            )
        }

        proposal(9220) {
            title("Ribbon Responsibility")
            ai("3.0")
            author(Kate)
            democratic()

            text(
                """
Amend Rule 2438, "Ribbons", by replacing this text:

        - If e has not owned that type of Ribbon within the preceding 7
          days, any player CAN, by announcement, award em that type of
          Ribbon.

with:

        - If e has not owned that type of Ribbon within the preceding 7
          days, e CAN, by announcement, award emself that type of
          Ribbon.

COMMENTS:

This was provoked by Mischief awarding me a Violet Ribbon just now.
This was profoundly annoying; I intended to leave it as long as possible
to award myself the ribbon, extending the period for which the Violet
Ribbon would count towards a Transparent Ribbon after I Raised my
Banner. Mischief also awarded a Violet Ribbon to several other people
who do not yet own a Transparent Ribbon, potentially making it more
difficult for them to do so in the future.

I suspect Mischief was not aware this would be negatively received,
believed e was doing people a favour, and will be disappointed to hear
otherwise. I think it would be less frustrating all around if this were
simply not possible. I don't think it is unreasonable to expect people
to notice they qualify for Ribbons in order to receive them."""
            )
        }

        proposal(9221) {
            title("Trash 'em")
            ai("3.0")
            author(Mischief)
            coauthors(Kate)
            democratic()

            text(
                """
Amend rule 2438 (Ribbons) by, after the paragraph reading:

       To "award a person a <Ribbon type>" is to flip that person's
       <that type> Ribbon Ownership to True. A person "owns a <Ribbon
       type>" if eir <that type> Ribbon Ownership is True.

adding a paragraph reading:

       A person CAN flip eir <Ribbon type> Ribbon Ownership to False by
       announcement.

[The 7-day timeout on ribbons means the person forfeits the current
opportunity, but e can still set emself up for a later shot at a
Transparent
Ribbon if e prefers.]"""
            )
        }

        proposal(9222) {
            title("Codify the Loophole")
            ai("3.0")
            author(Mischief)
            coauthors(Kate)
            democratic()

            text(
                """
Amend rule 2438 (Ribbons) by replacing:

       Transparent (T): A person qualifies for a Transparent Ribbon while
       the number of other types of Ribbon that that person qualifies
       for, earns, and/or was awarded within the previous 7 days is at
       least 5.

with:

       Transparent (T): A person qualifies for a Transparent Ribbon
       while the number of other types of Ribbon that that person
       qualifies for within the previous 7 days, earns within the
       previous 7 days, and/or was awarded within the previous 14 days
       is at least 5."""
            )
        }

        proposal(9223) {
            title("Yet Another Transparent Ribbon Solution")
            ai("3.0")
            author(Kate)
            coauthors(Mischief, ais523, Janet)
            democratic()

            text(
                """
Amend Rule 2438, "Ribbons", by performing the following changes to its
text in order as a single amendment.

Replace the four paragraphs beginning "White", "Black", "Gray" and
"Transparent" with the following text:

      White (W): A player qualifies for a White Ribbon if e has never
      previously owned a White Ribbon (including under previous
      rulesets). A player who has been registered for the past 30+ days
      or 180+ cumulative days and has never acted on eir own behalf to
      cause another person to gain a White Ribbon (including under a
      previous ruleset) CAN act on eir own behalf to cause another
      person to earn a White Ribbon by announcement.

      Black (K): An instrument CAN, as part of its effect, cause a
      person to earn a Black Ribbon.

      Gray (A): Once per month the Tailor CAN, by announcement, cause a
      specified player to earn a Gray Ribbon. E is ENCOURAGED to do so
      in the same message in which e publishes eir monthly report.

      Transparent (T): A person qualifies for a Transparent Ribbon while
      the number of other types of Ribbon that that person qualified for
      within the previous 7 days is at least 5.

      When a person earns a White, Black or Gray Ribbon, this Rule
      awards that person a Ribbon of that type.

If a proposal entitled "Codify the Loophole" has been adopted in the
past 14 days (including earlier in the same message), then, in the
paragraph starting "Transparent", replace "7 days" with "14 days".

COMMENTS:

This is an alternative solution to the Transparent Ribbon question:
instead of codifying the way it works now, it rephrases the White and
Gray Ribbons so that they uses the same earn/qualify framework as the
other Ribbons. This removes the need for Transparent to reference the
concept of "awarding" at all, therefore removing any ability to extend
the Transparent Ribbon contribution time by delaying a ribbon award.

I *believe* this removes any (in-game) incentives to delay awarding a
Ribbon or Raising a Banner when it is POSSIBLE to do so (which none of
the other proposed fixes do, yet; "Codify the Loophole" makes the impact
smaller by making the timescale more generous, but awarding a Ribbon
late still extends the window to contribute to Transparent).

This proposal isn't mutually exclusive with "Trash 'em" or "Ribbon
Responsibility". It does conflict with "Codify the Loophole"; if both
proposals pass, this one takes precedence (assuming the Assessor
resolves them in order), but extends the time limit to the maximum that
would have been possible under the existing system.

I intend to vote FOR all the current fix proposals, including this one,
unless bugs are discovered."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9215
            FOR on 9216
            FOR on 9217
            PRESENT on 9218
            PRESENT on 9219
            PRESENT on 9220
            AGAINST on 9221
            PRESENT on 9222
            PRESENT on 9223
        }

        votes(Kate) {
            FOR on 9215
            FOR on 9216
            PRESENT on 9217
            endorse(Gaelan) on 9218 comment "${Gaelan.name} is the Archivist"
            FOR on 9219
            FOR on 9220
            AGAINST on 9221
            FOR on 9222
            FOR on 9223
        }

        votes(ais523) {
            AGAINST on 9215
            AGAINST on 9216
            AGAINST on 9217
            PRESENT on 9218
            FOR on 9219
            AGAINST on 9220
            AGAINST on 9221
            // TODO resolve conditional vote: AGAINST if 9223 was or could be adopted; otherwise, FOR
            FOR on 9223
        }

        votes(ShyOwl) {
            FOR on 9215
            AGAINST on 9216
            PRESENT on 9217
            FOR on 9218
            AGAINST on 9219
            FOR on 9220
            AGAINST on 9221
            AGAINST on 9222
            AGAINST on 9223
        }

        votes(Mischief) {
            AGAINST on 9215
            FOR on 9216
            FOR on 9217
            endorse(Gaelan) on 9218 comment "${Gaelan.name} is the Archivist"
            FOR on 9219
            PRESENT on 9220
            AGAINST on 9221
            AGAINST on 9222
            FOR on 9223
        }

        votes(Forest) {
            AGAINST on 9220
            FOR on 9221
            AGAINST on 9222
            FOR on 9223
        }

        votes(Janet) {
            FOR on 9215
            PRESENT on 9216
            PRESENT on 9217
            AGAINST on 9218
            PRESENT on 9219
            // TODO: resolve conditional vote on 9220: AGAINST if 9223 adopted or could be adopted; otherwise FOR
            AGAINST on 9221
            AGAINST on 9222
            FOR on 9223
        }

        votes(juan) {
            endorse(Kate) on 9215 comment "${Kate.name} is the Arbitor"
            AGAINST on 9216
            PRESENT on 9217
            AGAINST on 9218
            FOR on 9219
            endorse(Murphy) on 9220 comment "${Murphy.name} is the Tailor"
            endorse(Murphy) on 9221 comment "${Murphy.name} is the Tailor"
            endorse(Murphy) on 9222 comment "${Murphy.name} is the Tailor"
            endorse(Murphy) on 9223 comment "${Murphy.name} is the Tailor"
        }

        votes(kiako) {
            FOR on 9215
            AGAINST on 9216
            PRESENT on 9217
            endorse(Janet) on 9218 comment "${Janet.name} is the Rulekeepor"
            endorse(ais523) on 9219
            resolvedConditional(endorse(Murphy), "${Murphy.name} is the Tailor and voted") on 9220
            AGAINST on 9221
            // TODO resolve conditional vote on 9222: FOR if 9223 has been or would be ADOPTED; otherwise, AGAINST
            resolvedConditional(endorse(Murphy), "${Murphy.name} is the Tailor and voted") on 9223
        }

        votes(Murphy) {
            FOR on 9215
            FOR on 9216
            PRESENT on 9217
            endorse(Gaelan) on 9218 comment "${Gaelan.name} is the Archivist"
            FOR on 9219
            PRESENT on 9220
            FOR on 9221
            FOR on 9222
            FOR on 9223
        }
    }
}
