package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.Ministry.Economy
import org.agoranomic.assessor.lib.Ministry.Participation

@UseAssessment
fun `assessment 8373 to 8376`() = assessment {
    name("8373-8376")
    quorum(7)

    proposals(v1) {
        proposal(8373) {
            title("Auction resolution fixes")
            ai("1.0")
            author(Jason)
            coauthors(Aris)
            chamber(Economy)

            text(
                """
Amend Rule 2551 by replacing the text from "A person's priority on an
Auction is their" to "the excess lots are not won by any person."
(including both ends) with the following paragraphs:

  The bidders in an Auction are the players who have a non-withdrawn
  bid in that Auction. Priority is a strict total ordering over the
  bidders in an Auction. For two bidders with different bid amounts on
  their non-withdrawn bids, the bidder with the higher bid has higher
  priority than the other bidder; otherwise, the bidder whose
  non-withdrawn bid was placed earlier has higher priority than the
  other bidder.

  Upon the end of an Auction, for each lot, in the order they are to
  be awarded, the bidder with the highest priority in the Auction who
  is not yet the winner of a lot becomes the winner of the lot. If
  there are more lots than there are persons with non-withdrawn bids,
  the excess lots are not won by any person.


See [0] for an explanation on what this does.

[0]:
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-discussion/2020-April/057218.html"""
            )
        }

        proposal(8374) {
            title("Re-Officialization")
            ai("1.0")
            author(Alexis)
            chamber(Participation)

            text(
                """
Append the following to the list of official Patent Titles in Rule 2581
(Official Patent Titles):
{
  - Left in a Huff, awardable by the Registrar to any player deregistered by
  a Writ of FAGE, where the Cantus Cygneus that gave rise to the Writ was due
  to a genuine, serious grievance.

  - {Three, Six, Nine, Twelve} Months Long Service, each awardable by that
  ADoP to a player who has served the appropriate number of months in a
  single office without significant dereliction of duty.
}"""
            )
        }

        proposal(8375) {
            title("Patent Title Unswap")
            ai("2.0")
            author(Alexis)
            chamber(Participation)

            text(
                """
Revoke the Patent titles "Prince of Agora" and "Princess of Andorra" from
Alexis, and award em the Patent titles "Prince of Andorra" and "Princess of
Agora".

[At some point, these appear to have been swapped in Herald's reports.
Since the report was ratified since the mistake was made, a proposal is
necessary to fix them.]"""
            )
        }

        proposal(8376) {
            title("Additional fire retardant")
            ai("3.0")
            author(Falsifian)
            democratic()

            text(
                """
Amend Rule 1789 by replacing "subsequent Registrar Reports" with
"subsequent Registrar monthly Reports"."""
            )
        }
    }
}
