package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune3.*
import org.agoranomic.assessor.dsl.ministries.ministriesJun15
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.addToHolder
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.Ministry.*

@UseAssessment
fun `assessment 8431 to 8441`() = assessment {
    name("8431-8441")
    quorum(7)

    val offices = officeMapOf(
        ADoP to RLee,
        Arbitor to G,
        Assessor to Jason,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to Aris,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to G,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nch
    )

    strengths {
        default(3)
        min(0)
        max(15)

        ministriesJun15(offices, allProposals)
        addToHolder(offices, Speaker, 1)
    }

    proposals(v1) {
        proposal(8431) {
            title("Proposal Reward Trimming")
            ai("1.0")
            author(Aris)
            coauthors(ais523)
            chamber(Legislation)

            text(
                """
[This reduces proposal rewards by removing AI from the calculation.
As it is, an extremely detailed and well developed AI 1.0 proposal
that is adopted unanimously gets fewer coins than an AI 3.0 bug fix.

Note for the Assessor: Since this proposal is AI 1.0, its
reward is the same in both the old and the new systems. Please adjust
your algorithms for future proposals if this passes.]

Amend Rule 2496, "Rewards", by replacing:

  Being the author of an adopted proposal: a number of coins equal to
  ((the total number of valid ballots cast FOR the decision - the total
  number of valid ballots cast AGAINST) times the adoption index of the
  result) rounded up

with:

  Being the author of an adopted proposal: a number of coins equal to
  (the total number of valid ballots cast FOR the decision - the total
  number of valid ballots cast AGAINST)"""
            )
        }

        proposal(8432) {
            title("The Administrative State")
            ai("3.0")
            author(Aris)
            coauthors(Alexis, Falsifian)
            democratic()

            text(
                """
Amend Rule 1728, "Dependent Action Methods", by adding as new list item
after the third list item:

  3. with N official consent, where N is an integer multiple of 0.1
     with a minimum of 1 ("With official consent" is shorthand for this
     method with N = 1);
and renumbering the list accordingly.

Amend Rule 2595, "Performing a Dependent Action" by changing the text
"without N objections, with N Agoran consent," to read
"without N objections, with N Agoran consent, with N official consent,"

Amend Rule 2124, "Agoran Satisfaction", by adding as a new item at the end
of the list:

  4. The action is to be performed with N official consent, and the
     number of offices held by Supporters of the intent is less than or equal
     to N times the number of offices held by Objectors to the intent.
  5. The action is to be performed with N official consent, the Prime
     Minister is an Objector, and the Speaker is not a Supporter.

Enact a new power 2.0 rule entitled "The Administrative State", with the
following text:

  Each officer CAN, with 2 official consent, enact, amend, or repeal
  eir's own office's Administrative Regulations. Administrative Regulations
  have the following properties:

  1. An officer SHALL abide by eir office's administrative regulations in
     the discharge of eir office.
  2. Any player CAN act on behalf of an officer to exercise eir official
     powers as authorized by eir office's administrative regulations.
  3. All players SHOULD abide by an officer's administrative regulations
     in matters relating to eir area of responsibility."""
            )
        }

        proposal(8433) {
            title("Simpler Heraldry")
            ai("1.5")
            author(Aris)
            coauthors(Alexis, Jason, PSS)
            chamber(Participation)

            text(
                """
Amend Rule 649, "Patent Titles", by appending to the last paragraph:

  Any player CAN award a specified Patent Title to a specified player,
  as authorized by the Herald's Administrative Regulations."""
            )
        }

        proposal(8434) {
            title("Majoritarian Confidence")
            ai("1.0")
            author(Aris)
            chamber(Efficiency)

            text(
                """
Amend Rule 2463, "Motion of No Confidence", by replacing:

  Any player can cause the office of Prime Minister to become vacant
  with 2 Agoran consent by publishing a message with the character
  string "MOTION OF NO CONFIDENCE" in the subject line.

with:
  Any player can cause the office of Prime Minister to become vacant
  with Agoran consent by publishing a message with the character
  string "MOTION OF NO CONFIDENCE" in the subject line."""
            )
        }

        proposal(8435) {
            title("No Confidence Isn't Personal")
            ai("1.0")
            author(Aris)
            chamber(Efficiency)

            text(
                """
Amend Rule 2463, "Motion of No Confidence", by appending:
  Motions of confidence SHOULD used whenever Agorans want to shake things
  up, rather than as a personal judgement of the Prime Minister."""
            )
        }

        proposal(8436) {
            title("Stately Officiation")
            ai("2.0")
            author(Aris)
            chamber(Efficiency)

            text(
                """
Amend each of Rule 1023 ("Agoran Time"), Rule 2496 ("Rewards"), and
Rule 2602 ("Glitter"), in that order, by changing the text
"in an officially timely fashion" to read "in a stately fashion"."""
            )
        }

        proposal(8437) {
            title("Guilderoy Lockhart")
            ai("1.0")
            author(RLee)
            coauthors(G)
            chamber(Legislation)

            text(
                """
Amend rule 2617 by deleting the last three paragraphs and the first
sentence [nonbinding explanatory note: this would make it forbidden to
attempt an action that would ossify the game, but not forbidden to create
or vote FOR a proposal that would have that effect]"""
            )
        }

        proposal(8438) {
            title("Tailor Pay")
            ai("1.0")
            author(RLee)
            chamber(Economy)

            text(
                """
Amend rule 2602 by adding on the end "The amount payable for each
type of glitter is tracked in the Tailor's weekly report""""
            )
        }

        proposal(8439) {
            title("Termination of Candidacy")
            ai("2.0")
            author(PSS)
            chamber(Efficiency)

            text(
                """
Amend Rule 2154, "Election Procedure" by changing the paragraph
beginning, "When an election is initiated," to read in full:

  When an election is initiated, it enters the nomination period,
  which lasts for 4 days. After an election is initiated and until
  nominations close, any player CAN become a candidate by
  announcement. A candidate ceases to be a candidate if e ceases to
  be a player during the election or if holding the office would
  make em Overpowered. During the nomination period, a candidate CAN
  cease to be a candidate by announcement if there is at least one
  other candidate."""
            )
        }

        proposal(8440) {
            title("0 blots patch")
            ai("1.7")
            author(RLee)
            coauthors(PSS)
            chamber(Justice)

            text(
                """
Amend rule 2557 "Sentencing Guidelines" by replacing "- B is at least
1 and at most twice the base value of the violation" with "- B is at most
twice the base value of the violation"."""
            )
        }

        proposal(8441) {
            title("Transmutation")
            ai("1.0")
            author(nch)
            coauthors(Trigon)
            chamber(Economy)

            text(
                """
Enact a new Power=1 rule titled "Transmutation" with the text:

  A player CAN pay 3 Cards (syn. transmute) to earn a Card of a
  specified type."""
            )
        }
    }

    voting {
    }
}
