package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty

@UseAssessment
fun assessment8678to8681() = assessment {
    name("8678-8681")
    quorum(4)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(cuddlybanana, 3 / 3)
        blotPenalty(Madrid, 3 / 3)
    }

    proposals(v4) {
        proposal(8678) {
            title("power of succession")
            ai("2.0")
            author(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2423 (First Among Equals) by appending the following new
paragraph:

     The Prime Minister's voting strength on an election for Prime
     Minister is doubled if eir valid ballot does not include emself
     (either conditionally or unconditionally) on the ballot's list
     of options.""")
        }

        proposal(8679) {
            title("Properly Decriminalizing Lateness")
            ai("2.0")
            author(nix)
            coauthors(G, Jason, Secretsnail9, Murphy)
            ordinary()
            sponsored()

            text("""
Amend R2557, "Sentencing Guidelines" by replacing:

    When the rules authorize an investigator to issue a Warning for a
    violation, e CAN do so by announcement if the violation is described
    by the rules as a "Class N Crime" where N is 0 or an expression that
    evaluates to 0.

with:

    When the rules authorize an investigator to issue a Warning for a
    violation, e CAN do so by announcement if:

    * the violation is a crime of class 0, OR
    * the violation is a crime of class 1 and e has not done so for the
      same player for the same crime this month.

Amend R2143, "Official Reports and Duties" by replacing:

    Failure of a person to perform any duty required of em within the
    allotted time is the Class 2 Crime of Tardiness.

with:

    Failure of a person to perform any weekly duty required of em within
    the allotted time is the Class 1+N Crime of Weekly Tardiness, where
    N is the number of times e has previously committed the crime in the
    last month.

    Failure of a person to perform any monthly duty required of em
    within the allotted time is the Class 3 Crime of Monthly Tardiness.

Amend R2138 "The Associate Director of Personnel" by appending:

      4. For filled offices with a weekly report, the number of weeks in
         scope, and the number and percent of those weeks during which
         the officeholder published its weekly report.

      5. For filled offices with a monthly report, the number of months
         in scope, and the number and percent of those months during
         which the officeholder published its monthly report.

      For this purpose, the 13 most recent complete weeks and 3 most
      recent complete months are in scope, but only those for which the
      officeholder held that office continuously since it started; and
      percentages of 0/0 are to be reported as n/a.""")
        }

        proposal(8680) {
            title("Auction conduction fix v2")
            ai("2.0")
            author(Jason)
            coauthors(G)
            ordinary()
            sponsored()

            text("""
Amend Rule 2545 by inserting the following paragraph after the paragraph
beginning "When the rules":

{

While an auction is ongoing, if the rules provide for that class of
auction, or a substantially similar class, the auctioneer generally CAN
conduct that ongoing auction, unless the rules specify otherwise. Any
auction that CANNOT be conducted and COULD NOT have been conducted in
the previous week immediately terminates with no winner.

}

Amend Rule 2629 by replacing "The Treasuror CAN conduct a Victory
Auction if no Victory Auction is ongoing." with "The Treasuror CAN
conduct a Victory Auction if no other Victory Auction is ongoing.".

Amend Rule 2666 by replacing "The Treasuror CAN conduct a L&FD Auction
if no L&FD Auction ongoing." with "The Treasuror CAN conduct a L&FD
Auction if no other L&FD Auction ongoing."

Amend Rule 2642 by replacing "The Stonemason CAN initiate an auction for
any set of stones belonging to Agora for which an auction is not
ongoing" with "The Stonemason CAN conduct an auction for any set of
stones belonging to Agora for which no other auction is ongoing".""")
        }

        proposal(8681) {
            title("Auction convergence")
            ai("1.0")
            author(Jason)
            ordinary()
            sponsored()

            text("""
All ongoing Victory Auctions hereby terminate.

All ongoing stone auctions hereby terminate.

All ongoing L&FD Auctions hereby terminate.

[Forgot to include this in my auction fix proposal, but this converges
the gamestate so that we know exactly what auctions are ongoing.]""")
        }
    }

    voting {
    }
}