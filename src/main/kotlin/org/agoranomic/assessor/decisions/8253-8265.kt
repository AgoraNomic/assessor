package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8253 to 8265`() = assessment {
    name("8253-8265")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-November/013234.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(5)

        G strength 4 comment PM
    }

    proposals(v0) {
        proposal(8253) {
            title("Clarify salary")
            ai("2.0")
            author(Murphy)
            coauthors(G, Jason)

            text(
                """
Amend Rule 2559 (Paydays) by replacing this text:

  2. For each office, if a single player held that office for 16 or
     more days in the previous month and no unforgivable fines were
     levied on em for eir conduct in that office during that time,
     that player earns 5 coins.

with this text:

  2. For each office, if a single player held that office for 16 or
     more days in the previous month and no unforgivable fines were
     levied on em during that month for eir conduct in that office,
     that player earns 5 coins.

[Legislates based on the judgement of CFJ 3774, but also covers edge
cases like "do something in late September, get dinged for it in early
October": you still earn your salary for September, but forfeit it for
October. Covering corner cases like "exit office in early October,
no October salary to forfeit, impose fine/debt against September salary"
is left as an exercise for future proposal authors.]"""
            )
        }

        proposal(8254) {
            title("Anything is POSSIBLE")
            ai("3.0")
            author(Jason)

            text(
                """
Amend Rule 2152 ("Mother, May I?") by replacing the text "CAN:" with the
text "CAN, POSSIBLE:".

["POSSIBLE" is used in the Rules right now, but is never defined; this
defines it.]"""
            )
        }

        proposal(8255) {
            title("Possibly-Indeterminate Switches")
            ai("3.0")
            author(Jason)

            text(
                """
Amend Rule 2162 ("Switches") by replacing the paragraph beginning "If an
action or set of actions" with the following:

  If a type of switch is not explicitly designated as
  possibly-indeterminate by the rule that defines it, and if an action
  or set of actions would cause the value of an instance of that type
  of switch to become indeterminate, that instance instead takes on
  its last determinate and possible value, if any, otherwise it takes
  on its default value.

[Provides an escape hatch so that rules can allow their switches to have
indeterminate values. This has come up in protos by both me and
Falsifian. It is useful to have these possibly-indeterminate properties
be switches, since switches have useful properties and precedent, so the
always-determinate system cuts off some use-cases.]"""
            )
        }

        proposal(8256) {
            title("Yes, Prime Minister")
            ai("2.0")
            author(Murphy)
            coauthors(Gaelan)

            text(
                """
Amend Rule 2193 (The Registrar) by removing this text:

  The Registrar is also responsible for tracking any switches,
  defined in a rule, that would otherwise lack an officer to track
  them, unless the switch is defined as untracked.

Amend Rule 2423 (First Among Equals) by appending this text:

  The Prime Minister is responsible for tracking any switches
  defined by the rules, not defined as untracked, and not defined
  as tracked by another officer."""
            )
        }

        proposal(8258) {
            title("Elections Fix")
            ai("2.0")
            author(Jason)

            text(
                """
Amend Rule 2154 ("Election Procedure") by replacing the text "election
for a specified office" with the text "election for a specified elected
office"."""
            )
        }

        proposal(8260) {
            title("The Low Zombie")
            ai("1.0")
            author(G)

            text(
                """
Create a Rule titled "Boo!" with the following text:
  One week after this rule is repealed, it is reenacted."""
            )
        }

        proposal(8261) {
            title("The High Zombie")
            ai("3.0")
            author(G)

            text(
                """
Create a Power=3 Rule titled "Boo!!" with the following text:
  Rules to the contrary notwithstanding, one week after this rule is
  repealed, it is reenacted."""
            )
        }

        proposal(8262) {
            title("trick candles")
            ai("1.0")
            author(G)

            text(
                """
Create a Rule entitled "Blink" with the following text:
  One week after this sentence is modified in any way, this rule
  is amended by inserting this sentence as the first paragraph of
  this rule."""
            )
        }

        proposal(8263) {
            title("Persistent")
            ai("3.0")
            author(nch)

            text(
                """
I submit the following proposal, "Persistent", AI=3 {

  When this rule is amended, also amend it by appending this sentence to the
  end of the rule.

}"""
            )
        }

        proposal(8264) {
            title("Encouraging Democracy Through Capitalism or Who Pays Subs Full Wages Anyway")
            ai("1.0")
            author(nch)

            text(
                """
Amend rule 2496 by replacing the current text {

  * Publishing an office's weekly or monthly report, provided that
    publication was the first report published for that office in
    the relevant time period (week or month respectively) to fulfill
    an official weekly or monthly duty: 5 coins.

} with the text {

  * Publishing an office's weekly or monthly report, provided that
    publication was the first report published for that office in
    the relevant time period (week or month respectively) to fulfill
    an official weekly or monthly duty: 3 coins for an interim office
    or 5 coins for any other office.

}

Reasoning: This should encourage elections for offices. Elections are Fun
and Cool and help spread the workload and reduce consolidation."""
            )
        }

        proposal(8265) {
            title("")
            ai("3.0")
            author(twg)
            coauthors(Murphy, Aris, Jason)

            text(
                """
Enact a new Rule of Power 3.0 with the text:

  Rules to the contrary notwithstanding:

    * the Rulekeepor's reports NEED NOT include this rule or any
      information about it;

    * the Rulekeepor NEED NOT assign this rule a title;

    * players SHALL NOT clearly identify this rule - doing so is the
      Class 1 Crime of Uttering the Forbidden Name.

   Any player CAN, without objection, exorcise this rule (cause it to
   repeal itself).

/* Changes from Murphy's version: added "any information about it" (like
 * annotations, etc) to the list of things the Rulekeepor doesn't have to
 * publish; added an extra safety so that we can get rid of it quickly if
 * necessary.
 */

/* Changes from my first version: increased to Power 3 to overrule reporting
 * requirements; removed the Rulekeepor's requirement to assign a title without
 * identifying it; added an explicit SHALL NOT to Uttering the Forbidden Name;
 * moved the SHALL NOT to within the RttCN clause to overrule the requirement
 * for freedom of speech.
 */"""
            )
        }
    }

    voting {
        votes(Aris) {
            FOR on 8253
            FOR on 8254
            FOR on 8255
            AGAINST on 8256
            FOR on 8258
            AGAINST on 8260
            PRESENT on 8261
            AGAINST on 8262
            FOR on 8263
            AGAINST on 8264
            FOR on 8265
        }

        votes(nch) {
            FOR on 8253
            endorse(G) on 8254
            PRESENT on 8255
            AGAINST on 8256
            FOR on 8258
            FOR on 8260
            FOR on 8261
            FOR on 8262
            FOR on 8263
            PRESENT on 8264
            FOR on 8265 // Only proposal not listed in message
        }

        votes(Gaelan) {
            FOR on 8253
            FOR on 8254
            FOR on 8255
            AGAINST on 8256
            FOR on 8258
            AGAINST on 8260
            FOR on 8261
            AGAINST on 8262
            FOR on 8263
            AGAINST on 8264
            FOR on 8265
        }

        votes(G) {
            FOR on 8253
            FOR on 8254
            FOR on 8255
            AGAINST on 8256
            FOR on 8258
            AGAINST on 8260
            FOR on 8261
            FOR on 8262
            AGAINST on 8263
            AGAINST on 8264
            AGAINST on 8265
        }

        Rance matches G

        votes(Jason) {
            FOR on 8253
            FOR on 8254
            FOR on 8255
            AGAINST on 8256
            FOR on 8258
            FOR on 8260
            FOR on 8261
            FOR on 8262
            FOR on 8263
            AGAINST on 8264
            FOR on 8265
        }

        votes(omd) {
            FOR on 8253
            FOR on 8254
            PRESENT on 8255
            PRESENT on 8256
            FOR on 8258
            AGAINST on 8260
            AGAINST on 8261
            AGAINST on 8262
            AGAINST on 8263
            FOR on 8264
            FOR on 8265
        }

        votes(Falsifian) {
            FOR on 8253
            FOR on 8254
            FOR on 8255
            PRESENT on 8256
            FOR on 8258
            PRESENT on 8260
            PRESENT on 8261
            PRESENT on 8262
            PRESENT on 8263
            PRESENT on 8264 comment NO_VETO
            AGAINST on 8265
        }

        votes(ATMunn) {
            endorse(Falsifian) on all
        }

        votes(Bernie) {
            endorse(Jason) on all
        }

        votes(twg) {
            endorse(Murphy) on 8253
            endorse(Jason) on 8254
            endorse(Jason) on 8255
            endorse(Murphy) on 8256
            endorse(Jason) on 8258
            endorse(G) on 8260
            endorse(G) on 8261
            endorse(G) on 8262
            endorse(nch) on 8263
            AGAINST on 8264
            FOR on 8265
        }

        votes(pikhq) {
            FOR on 8253
            FOR on 8254
            FOR on 8255
            AGAINST on 8256
            FOR on 8258
            AGAINST on 8260
            FOR on 8261
            FOR on 8262
            AGAINST on 8263
            FOR on 8264
            AGAINST on 8265
        }
    }
}
