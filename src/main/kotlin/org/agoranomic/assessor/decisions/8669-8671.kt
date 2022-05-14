package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8669to8671() = assessment {
    name("8669-8671")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2022-May/015934.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Trigon, 7 / 3)
        blotPenalty(nix, 5 / 3)
        blotPenalty(cuddlybanana, 3 / 3)
        blotPenalty(Jason, 3 / 3)
    }

    proposals(v4) {
        proposal(8669) {
            title("Quick Stamp Fix")
            ai("1.0")
            author(nix)
            ordinary()
            sponsored()

            text("""
Amend 2659, "Stamps", by replacing:

  Any player CAN pay 3 boatloads of coins to grant emself 1 Stamp of
  eir own type.

with:

  Any player CAN pay 3 boatloads of coins to grant a specified
  player 1 Stamp of the granter's own type.""")
        }

        proposal(8670) {
            title("Monthly Auctions Revisited")
            ai("1.0")
            author(nix)
            coauthors(Secretsnail9)
            ordinary()
            sponsored()

            text("""
Amend R2629, Victory Auctions, to read (in full):

  The Treasuror CAN conduct a Victory Auction if no Victory Auction
  is ongoing. The Treasuror MUST do so at least once a month, and
  SHOULD do so at least twice each month.

  A Victory Auction includes the following lots:

  * one new Win Card.

  The currency of a Victory Auction is coins (minimum bid 1).

[Remove the L&FD lot. Also slightly clean up first paragraph.]

Enact a new Power=1 rule titled "L&FD Auctions" which reads (in full):

  The Treasuror CAN conduct a L&FD Auction if no L&FD Auction is
  ongoing. The Treasuror MUST do so at least once a month, if there
  is at least one asset in the Lost and Found Department of an
  auction-ready type.

  Coins, promises, and all private assets are excluded from L&FD
  Auctions. The non-excluded type(s) of asset(s) that the Lost and
  Found Department owns more of than any other type of non-excluded
  asset are auction-ready.

  When conducting a L&FD Auction, the Treasuror specifies an
  auction-ready asset type. Each asset of that type that the L&FD
  owns is a lot.

  The currency of a L&FD Auction is coins (minimum bid 1).

[This is generalized for nearly any asset, instead of just cards and
products. It also changes from one big pot to spreading out, which
gives a greater range of players access to these assets.]""")
        }

        proposal(8671) {
            title("No finger pointing on behalf")
            ai("1.7")
            author(Jason)
            ordinary()
            sponsored()

            text("""
Amend Rule 2478 by replacing "A player CAN by announcement Point eir
Finger" with "A player, acting as emself, CAN by announcement Point eir
Finger".""")
        }
    }

    voting {
        votes(ais523) {
            PRESENT on 8669
            PRESENT on 8670
            AGAINST on 8671
        }

        votes(G) {
            FOR on all
        }

        votes(Jason) {
            FOR on 8669
            PRESENT on 8670
            FOR on 8671
        }

        votes(Murphy) {
            FOR on 8669
            FOR on 8670
            PRESENT on 8671
        }

        votes(nix) {
            FOR on all
        }

        votes(Secretsnail9) {
            FOR on all
        }
    }
}
