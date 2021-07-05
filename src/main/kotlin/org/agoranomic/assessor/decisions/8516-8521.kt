package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.speakerBonus
import org.agoranomic.assessor.lib.proposal.MinistryV2.Compliance
import org.agoranomic.assessor.lib.proposal.MinistryV2.Economy
import org.agoranomic.assessor.lib.vote.InextricableResolvingVote
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8516to8521() = assessment {
    name("8516-8521")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-November/014382.html")
    quorum(9)

    strengths {
        default(3)
        min(0)
        max(15)

        speakerBonus(G)
        blotPenalty(RLee, 81 / 3)

        // Ministries are broken as of this resolution due to a bug in P8515:
        //    For each item of each office's Ministry Interest, that office's
        //    holder's voting strength is increased by 2 on proposals whose
        //    Ministry Impact is set to that Ministry.
        // "Ministry Impact" is not defined.
    }

    proposals(v3) {
        proposal(8516) {
            title("adJustments")
            ai("2.0")
            author(nix)
            chamber(Economy)
            sponsored()

            text("""
Amend "Office Interests" by replacing "Ministry Impact" with "Chamber".

(Current text does nothing because 'Ministry Impact' means nothing.)

Amend R2624, "Focus Grants", by replacing "50 coins" with "50 boatloads
of coins".

(To match with the upcoming boatloads economy.)""")
        }

        proposal(8517) {
            title("Phasing Out Zombies")
            ai("3.0")
            author(Telna)
            coauthors(Jason, Trigon)
            democratic()
            sponsored()

            text("""
Enact a new power 3.0 rule entitled "Zombie Phase-Out" with the the following
text:

  While a zombie's talisman is owned by Agora, that zombie's resale
  value is continuously set to 0.""")
        }

        proposal(8518) {
            title("Asset Rounding")
            ai("3.0")
            author(Aris)
            coauthors(Falsifian, nix)
            democratic()
            sponsored()

            text("""
Amend Rule 2577, "Asset Actions", by replacing:

  When a rule indicates transferring an amount that is not a natural
  number, the specified amount is rounded up to the nearest natural
  number.

with:

  When a rule indicates creating, destroying, or transferring an amount of
  assets that is not a natural number, the specified amount is rounded up
  to the nearest natural number after all other calculations.


Amend the Rule titled "Floating Rate Fleet" by deleting the text
"When a quantity of assets is expressed in boatloads, it is rounded up
to the next whole asset."""")
        }

        proposal(8519) {
            title("I definitely authored this")
            ai("2.0")
            author(ATMunn)
            coauthors(Jason)
            chamber(Compliance)
            sponsored()

            text("""
Amend Rule 2531 by replacing the first paragraph with the following:
{
  Any attempt to levy a fine is INEFFECTIVE if it does not include value
  of the fine in blots, the name of the person being fined (the perp), and
  the specific reason for the fine.
}

Amend Rule 2531 by renumbering the list so that the numbers start at 1
and end at 10, with each number other than the fist one higher than the
previous.""")
        }

        proposal(8520) {
            title("(untitled)")
            ai("3.0")
            author(PSS)
            coauthors(Jason)
            democratic()
            sponsored()

            text("""
Amend the final item in Rule 2438, "Ribbons" to read as follows: {
  - Otherwise, if e has not been awarded that type of Ribbon or
    the corresponding type of Glitter since e last earned or came
    to qualify for that type of Ribbon, and has not been so
    awarded five or more times within the past 24 hours, any
    player CAN, by announcement, award em that type of Glitter.
}""")
        }

        proposal(8521) {
            title("Stones")
            ai("2.0")
            author(Jason)
            coauthors(G, Aris, nix, Trigon, Gaelan, Falsifian)
            chamber(Economy)
            sponsored()

            text("""
Enact a new rule, power 2, title "Stones", with the following text:
{
  A stone is a unique indestructable liquid asset defined by the rules. To
  define a stone, the definition must include:
  (i)   A name unique among stones;
  (ii)  The escape risk of the stone, which must be a percentage between
  0% and 100% inclusive;
  (iii) A scroll, which is a document specifying the effects of the stone
  (iv)  Optionally, a frequency, which must be one of daily, weekly,
  monthly, or quarterly.

  Ownership of stones is entirely restricted to Agora and active players.
  If a stone is owned by the Lost and Found Department or in abeyance, it
  is immediately transferred to Agora.

  The Stonemason is an office, and the recordkeepor of stones.
}

Enact a new rule, power 2, title "Wielding Stones", with the following text:
{
  Except as otherwise specified by the rules, the owner of a stone CAN
  wield it by announcement specifying any values needed to interpret the
  stone's effects.

  If a stone has a frequency, then it is IMPOSSIBLE to wield that stone if
  it has been previously wielded in the same Agoran time interval as
  indicated by its frequency (e.g. if its frequency is daily, if it has
  been wielded in the same Agoran day).

  When a stone is wielded, the Rule defining that stone applies the
  effects in that stone's scroll.
}

Enact a new rule, power 2, title "Distributing Stones", with the
following text:
{
  The Stonemason CAN initiate an auction for any set of stones belonging
  to Agora for which an auction is not ongoing, with each individual stone
  being an auction lot. The Stonemason is the auctioneer, and the currency
  is coins.

  The Stonemason SHALL so initiate an auction for a set of stones
  consisting of at least one third the stones eligible for auction in a
  timely fashion after publishing a collection notice, provided there any
  eligible stones.
}

Enact a new rule, power 2, title "Collecting Stones", with the following
text:
{
  Once per month, the Stonemason CAN publish a collection notice by
  announcement, specifying all necessary information and choices. The
  Stonemason SHALL publish such a notice in a timely fashion after the
  beginning of each Agoran month.

  A stone is immune if there has been no collection notice after it was
  most recently granted immunity (if ever), as defined by other rules.

  A collection notice includes, for every non-immune stone not belonging
  to Agora, a random choice of whether that stone escapes, escaping with
  probability equal to its escape risk. When a collection notice is
  published, stones that escape are transferred to Agora in an order
  specified by the collection notice.
}


Enact a new rule, power 2, title "The Gauntlet", with the following text:
{
  When a player makes a correct announcement that a single specified
  player owns 5 or more stones, the specified player Wields the Guantlet.

  When a player Wields the Gauntlet, e wins the game and all existing
  stones are transferred to Agora.
}

Enact a new rule, power 2, title "The Stones", with the following text:
{
  The following stones are defined, one per paragraph, with the following
  format: Stone Name (Frequency, Escape Risk): Scroll.

  - Power Stone (weekly, 40%): A specified player hereby buys strength 3
  times on a specified unresolved Agoran decision.

  - Wealth Stone (weekly, 50%): A specified player hereby earns 5
  boatloads of coins.

  - Soul Stone (weekly, 50%): The Soul Stone is hereby transferred to the
  owner of a different specified non-immune stone, then that stone is
  transferred to the wielder.

  - Sabotage Stone (weekly, 80%): The adoption index of a specified
  AI-majority Agoran decision is hereby increased by 1.

  - Concentration Stone (weekly, 60%): A specified player earns the Grant
  associated with eir Focus.

  - Protection Stone (monthly, 70%): A specified stone is granted immunity.
}

Jason hereby becomes the Stonemason.""")
        }
    }

    voting {
        votes(PSS) {
            FOR on 8516
            FOR on 8517
            FOR on 8518
            AGAINST on 8519
            FOR on 8520
            FOR on 8521
        }

        votes(nix) {
            FOR on 8516
            FOR on 8517
            FOR on 8518
            AGAINST on 8519
            endorse(PSS) on 8520
            FOR on 8521
        }

        votes(ATMunn) {
            FOR on 8516
            FOR on 8517
            FOR on 8518
            endorse(Jason) on 8519
            endorse(PSS) on 8520
            FOR on 8521
        }

        votes(Jason) {
            FOR on 8516
            FOR on 8517
            FOR on 8518
            AGAINST on 8519
            FOR on 8520
            FOR on 8521
        }

        votes(BaronVV) {
            endorse(Jason) on all
        }

        votes(Trigon) {
            FOR on 8516
            FOR on 8517
            FOR on 8518
            endorse(Jason) on 8519
            FOR on 8520
            FOR on 8521
        }

        votes(sukil) {
            endorse(Trigon) on all
        }

        votes(Gaelan) {
            endorse(nix) on 8516
            InextricableResolvingVote on 8517 comment "two zombie votes: sukil FOR and D. Margaux PRESENT"
            endorse(Aris) on 8518
            AGAINST on 8519
            AGAINST on 8520
            endorse(Jason) on 8521
        }

        votes(G) {
            PRESENT on all
        }

        votes(DMargaux) {
            PRESENT on all
        }
    }
}
