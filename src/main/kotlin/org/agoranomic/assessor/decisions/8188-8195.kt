package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.UseAssessment
import org.agoranomic.assessor.lib.VoteKind.AGAINST
import org.agoranomic.assessor.lib.VoteKind.FOR
import org.agoranomic.assessor.dsl.assessment

@UseAssessment
fun `assessment 8188 to 8195`() = assessment {
    name("8188-8195")
    quorum(7)

    strengths {
        default(3)

        G strength 4 comment PM
    }

    proposals {
        proposal(8188) {
            title("Blanket Denial")
            author(G)
            ai(3.0)
            text(
                """
Amend Rule 2201 (Self-Ratification) by replacing:
  do one of the following in a timely fashion:
with
  do one of the following in a timely fashion, in an announcement
  that clearly cites the claim of error:
"""
            )
        }

        proposal(8189) {
            title("Rule 2479 Cleanup (v1.2)")
            author(Jason)
            ai(1.7)
            text(
                """
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
>  imposed on the Referee's own initiative, and not in response to any official proceeding. 
"""
            )
        }

        proposal(8190) {
            title("Report Rewards")
            author(G)
            coauthors(DMargaux)
            ai(2.0)
            text(
                """
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
    an official weekly or monthly duty: 5 coins.
"""
            )
        }

        proposal(8191) {
            title("Spaceships")
            author(RLee)
            ai(1.1)
            text(
                """
Create a spaceship in the possession of each player without a
spaceship
"""
            )
        }

        proposal(8192) {
            title("auctions have fees")
            author(Falsifian)
            ai(1.0)
            text(
                """
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
debt"].
"""
            )
        }

        // Proposal 8193 doesn't exist

        // Proposal 8194 doesn't exist

        proposal(8195) {
            title("Timeline Control Ordnance v2")
            author(Aris)
            coauthors(omd, Jason)
            ai(3.0)
            text(
                """
Create a spaceship in the possession of each player without a
spaceship
"""
            )
        }
    }

    voting {
        votes(G) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            AGAINST on 8191
            FOR on 8192
            FOR on 8195
        }

        Telnaior matches G

        votes(Jason) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            FOR on 8195
        }

        votes(Falsifian) {
            FOR on 8188
            FOR on 8189
            FOR on 8190
            FOR on 8191
            FOR on 8192
            FOR on 8195
        }
    }
}
