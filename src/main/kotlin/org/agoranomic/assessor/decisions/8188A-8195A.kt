package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.VoteKind.FOR
import org.agoranomic.assessor.lib.VoteKind.PRESENT
import org.agoranomic.assessor.lib.assessment

fun `assessment 8188A to 8195A`(): AssessmentData {
    return assessment {
        name("8188A-8195A")
        quorum(7)

        // TODO update for time of assessment
        strengths {
            default(3)

            G strength 4 comment PM
            Corona strength 1 comment BLOTS
            twg strength 1 comment BLOTS
            DMargaux strength 2 comment BLOTS
            PSS strength 2 comment BLOTS
        }

        proposals {
            proposal(8188) {
                title("Blanket Denial")
                ai(3.0)
                author(G)

                text("""
Amend Rule 2201 (Self-Ratification) by replacing:
  do one of the following in a timely fashion:
with
  do one of the following in a timely fashion, in an announcement
  that clearly cites the claim of error:""")
            }

            proposal(8189) {
                title("Rule 2479 Cleanup (v1.2)")
                ai(1.7)
                author(JasonCobb)

                text("""
Amend Rule 2479 ("Official Justice") as follows:

Replace the text

>  The Referee CAN, subject to the provisions of this rule, impose
>  Summary Judgment on a person who plays the game by levying a fine
>  of up to 2 blots on em. Summary Judgement is imposed on the
>  Referee's own initiative, and not in response to any official
>  proceeding.

with the text

>  Subject to the provisions of this rule, the Referee CAN, by announcement,
>  impose Summary Judgment on a player. When e does so, e levies a fine of
>  up to 2 Blots on em. If e does not specify the number of Blots in the fine,
>  the attempt to impose Summary Judgment is INEFFECTIVE. Summary Judgement is
>  imposed on the Referee's own initiative, and not in response to any official proceeding.""")
            }

            proposal(8190) {
                title("Report Rewards")
                ai(2.0)
                author(G)
                coauthors(DMargaux)

                text("""
Amend Rule 1006 (Offices) by prepending the following text to the 1st
paragraph:
  An Office is a position described as an Office by the Rules.

Amend Rule 2496 (Rewards) by replacing:
  * Publishing a duty-fulfilling report: 5 coins. For each office,
    this reward can only be claimed for the first weekly report
    published in a week and the first monthly report published in a
    month.
with:
  * Publishing an office's weekly or monthly report, provided that
    publication was the first report published for that office in
    the relevant time period (week or month respectively) to fulfill
    an official weekly or monthly duty: 5 coins.""")
            }

            proposal(8191) {
                title("Spaceships")
                ai(1.1)
                author(RLee)

                text("""
Create a spaceship in the possession of each player without a
spaceship""")
            }

            proposal(8192) {
                title("auctions have fees")
                ai(1.0)
                author(G)

                text("""
[The payment rule for auctions just says that if you happen to have an
auction debt, if you pay Agora under any circumstances, it triggers
stuff.  This means, if someone happens to have two auction debts, they
can make one payment and it would count for both.  This brings things
into line.]

Amend Rule 2551 (Auction End) by replacing:
  The winner of a lot SHALL pay the Auctioneer the number of the
  Auction's currency equal to eir bid, in a single payment, in a
  timely fashion.
with:
  The winner of the lot SHALL, in a timely fashion, pay a fee (the
  number of the Auction's currency equal to eir bid) to the
  Auctioneer in order to satisfy eir auction debt.

[This makes "satisfying eir auction debt" a fee-based action governed
under R2579, which didn't exist when the auction rules were written.
R2579 then takes care of the various CANs and method details.  The
transfer of the lots is then a consequence of "satisfying eir auction
debt"].""")
            }

            proposal(8195) {
                title("Timeline Control Ordnance v2")
                ai(3.0)
                author(Aris)

                text("""
Enact a new power 3.1 Rule, entitled "Timelines", with the following text:

  A timeline is a temporal sequence of events and states.

  The Objective Timeline is the timeline of matters as they actually happened.
  On the Objective Timeline, the consequences of an event are determined
  based on the conditions actually in effect, under Agoran law, when that event
  occurred. The Objective Timeline is not part of the gamestate; instead, it
  is the recording of events on reality itself, and changing it retroactively
  without actual time travel is thus IMPOSSIBLE, rules to the contrary
  notwithstanding.

  The Standard Timeline is the timeline used for the purposes of ordinary
  gameplay. By default, the Standard Timeline is defined by events and their
  consequences in the same way that the Objective Timeline is. However,
  the Standard Timeline is part of the gamestate. Accordingly, it can be
  modified retroactively; such retroactive modifications are secured
  at power 3.

  Attempted retroactive changes are to be interpreted as attempts to change the
  Standard Timeline. All changes are to be interpreted as prospective unless
  they are explicitly retroactive.

  By default, any entity with a power less than the power of this rule that
  refers to the past, present, or future is to be interpreted as referring to
  the Standard Timeline; however, entities may explicitly reference
  different timelines.

Amend Rule 1551, "Ratification" by changing the text "the gamestate is modified"
to read "the gamestate is retroactively modified".

Amend Rule 591, "Delivering Judgements", by changing the text

  "The valid judgements for an inquiry case are as follows, based on
  the facts and legal situation at the time the inquiry case was
  initiated, not taking into account any events since that time:"

to read

  "The judgement of an inquiry case should be based on the facts and legal
  situation as they objectively existed at the time the inquiry case was
  initiated, not taking into account any events or retroactive modifications
  since that time.

  The valid judgements for an inquiry case are as follows:"""")
            }
        }

        voting {
            votes(Aris) {
                FOR on 8188
                FOR on 8189
                FOR on 8190
                FOR on 8191
                // TODO resolve conditional vote on 8192: AGAINST IF VETO ELSE FOR
                FOR on 8195
            }

            votes(nch) {
                FOR on 8188
                FOR on 8189
                FOR on 8190
                FOR on 8191
                // TODO resolve conditional vote on 8192: AGAINST IF VETO ELSE FOR
                FOR on 8195
            }

            votes(JasonCobb) {
                PRESENT on 8188
                FOR on 8189
                FOR on 8190
                FOR on 8191
                // TODO resolve conditional vote on 8192: AGAINST IF VETO ELSE FOR
                FOR on 8195
            }

            votes(Trigon) {
                FOR on 8188
                FOR on 8189
                FOR on 8190
                FOR on 8191
                // TODO resolve conditional vote on 8192: AGAINST IF VETO ELSE FOR
                PRESENT on 8195
            }
        }
    }
}