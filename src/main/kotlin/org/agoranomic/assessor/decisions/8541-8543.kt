package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.endorseOrElse
import org.agoranomic.assessor.lib.vote.VoteKind.FOR

@UseAssessment
fun assessment8541to8543() = assessment {
    name("8541-8543")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2021-March/014691.html")
    quorum(5)

    strengths {
        min(0)
        max(15)
        default(3)
    }

    proposals(v4) {
        proposal(8541) {
            title("You CAN, CAN'T You?")
            ai("3.0")
            author(Aspen)
            democratic()
            sponsored()

            text(
                """
[Currently, there are a bunch of CANs without a method that thus fail.]

Amend Rule 2585, "Birthday Gifts", by replacing:

  During a player's Agoran Birthday and the 7 days following, each
  other player CAN, once, grant em X boatloads of coins, where X is
  3 if it is actually the day of the player's birthday, and 2
  otherwise.

with:

  During a player's Agoran Birthday and the 7 days following, each
  other player CAN once grant em X boatloads of coins by announcement,
  where X is 3 if it is actually the day of the player's birthday, and 2
  otherwise.

["Public designation" is used instead of "announcement" so as to not
invalidate the current method of simply publishing a report with the
relevant information.]

Amend Rule 2141, "Role and Attributes of Rules", by replacing:

  Every rule shall have an ID number, distinct among current and
  former rules, to be assigned once by the Rulekeepor.

with:

  Every rule shall have an ID number, distinct among current and
  former rules, to be assigned once by the Rulekeepor by public
  designation.

Amend Rule 2608, "The Notary", by replacing:

  If the Notary is required to report a title, but none has been
  otherwise publicly provided, e CAN select one.

with:

  If the Notary is required to report an entity's title, but none has been
  otherwise publicly provided, e CAN assign one by public designation."""
            )
        }

        proposal(8542) {
            title("Stone Excitement Act")
            ai("2.0")
            author(Jason)
            coauthors(Aspen)
            ordinary()
            sponsored()

            text(
                """
Amend Rule 2643 "Collecting Stones" by replacing the final paragraph
with the following:
{

  A collection notice includes zero or more random choices of whether each
  stone escapes. Each choice results in escape with probability equal to
  its escape risk; a stone escapes if any choice selects escape. When a
  collection notice is published, stones that escape are transferred to
  Agora in an order specified by the collection notice.

  If a stone is immune, there are zero escape choices; otherwise, there is
  one choice if the stone was used in the previous Agoran month, or two if
  it was not.

}"""
            )
        }

        proposal(8543) {
            title("En Passant v2")
            ai("1.0")
            author(Jason)
            coauthors(Aspen, nix)
            ordinary()
            sponsored()

            text(
                """
Amend Rule 2621 "VP Wins" to read, in whole:
{

  If a player has at least 20 more Victory Points than any other player, e
  CAN Take Over the Economy by announcement, provided no person has done
  so in the past 30 days.

  When a player takes over the economy, e wins the game. If a player Took
  Over the Economy 4 days ago, all Cards and all Products are destroyed,
  then each active player is granted 1 card of each type.

}"""
            )
        }
    }

    voting {
        votes(Trigon) {
            FOR on 8541
            FOR on 8542
            FOR on 8543
        }

        votes(Aspen) {
            FOR on 8541
            endorseOrElse(Jason, FOR) on 8542
            FOR on 8543
        }

        votes(Gaelan) {
            FOR on 8541
            FOR on 8542
            FOR on 8543
        }

        votes(Jason) {
            FOR on 8541
            FOR on 8542
            FOR on 8543
        }

        votes(Falsifian) {
            endorse(Aspen) on 8541
            endorse(Jason) on 8542
            endorse(Jason) on 8543
        }

        votes(Murphy) {
            FOR on 8541
            FOR on 8542
            FOR on 8543
        }
    }
}
