package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune3.*
import org.agoranomic.assessor.dsl.ministries.ministriesJun03
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.Ministry.Economy
import org.agoranomic.assessor.lib.proposal.Ministry.Efficiency
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun `assessment 8405 to 8408`() = assessment {
    name("8405-8408")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013771.html")
    quorum(8)

    val offices = officeMapOf(
        ADoP to RLee,
        Arbitor to G,
        Assessor to Jason,
        Distributor to omd,
        Herald to PSS,
        Notary to RLee,
        PrimeMinister to Aris,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to Trigon,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nch
    )

    strengths {
        default(3)
        min(0)
        max(15)

        ministriesJun03(offices, allProposals)
        addToHolder(offices, Speaker, 1)
    }

    proposals(v1) {
        proposal(8405) {
            title("Generic private assets")
            ai("3.0")
            author(Jason)
            democratic()

            text(
                """
Amend Rule 2166 by replacing the text "one defined by a contract is
private" with the text "any other asset is private".

[This removes an underpowered dependency of Rule 2166 and makes sure
that if we (for some reason) expand Mint Authority we don't forget to
change this.]"""
            )
        }

        proposal(8406) {
            title("Remove churn")
            ai("2.0")
            author(Murphy)
            chamber(Efficiency)

            text(
                """
[The line-item veto has been used approximately zero times, whereas the
requirement to select a new Comptrollor persists. The replacement text
is also considerably more compact.]

Repeal Rule 2597 (Line-item Veto).

Amend Rule 2451 (Executive Orders) by appending the following to the
list of Cabinet Orders:

  - Line Item Veto (Assessor): The Prime Minister clearly, directly,
    and without obfuscation identifies one or more individual
    changes in proposals whose decision's voting periods are
    ongoing. Such changes CANNOT be applied."""
            )
        }

        proposal(8407) {
            title("no stinking auction definitions")
            ai("2.0")
            author(G)
            chamber(Economy)

            text(
                """
Repeal Rule 2584 (Free Auctions)
Repeal Rule 2552 (Auction Termination)
Repeal Rule 2551 (Auction End)
Repeal Rule 2550 (Bidding)
Repeal Rule 2549 (Auction Initiation)

Amend Rule 2545 (Auctions) to read in full:

  An auction is a way for entities to give away specified assets
  (items), grouped into lots, in exchange for a currency. A lot is a
  non-empty list of items to be transferred to a single recipient
  (an auction winner).

  When the rules authorize a person (the auctioneer) to conduct an
  auction, e CAN do so by any wholly public method that would be
  generally recognizable, as specified by the auctioneer at the
  start of the auction, and under common definitions and terms used
  in auctions, as a fair, equitable, and timely means of determining
  the auction winners from among the current players, and enabling
  the appropriate exchange of goods.

  The rule that authorizes the auction further authorizes the
  auctioneer or auction winners to transfer said items as necessary
  to conduct the auction in a manner consistent with the auction
  method. If the authorization is to auction "new" items, it further
  authorizes the creation of said items as per the chosen method.

  The Treasuror is the promulgator for regulations that define
  specific auction methods (i.e. "the default auction method") and
  SHOULD do in order to aid trade and commerce.  For the purposes of
  interpreting auction definitions, such methods are treated as if
  they are defined in this rule. To further aid trade and commerce,
  auction methods should be interpreted in the name of fairness with
  deference to the method's clear intent, if intent can be
  reasonably inferred."""
            )
        }

        proposal(8408) {
            title("Sets v1.4")
            ai("3.0")
            author(nch)
            coauthors(Trigon, Falsifian, PSS, Jason, Aris, G, ais523)
            democratic()

            text(
                """
Enact a new Power=1 rule titled "Cards & Sets" with the text:

  Cards are a type of currency with a corresponding Product.
  Products are also currencies. The types of Cards and their
  corresponding Products are:

  * Victory Cards and Victory Points.

  * Justice Cards and Blot-B-Gones

  * Legislative Cards and Pendants

  * Voting Cards and Extra Votes

  A player CAN pay a 'set' of X Cards of the same type to earn Y
  corresponding Products. The value of X determines the value of Y
  in the following ways:

  * 1 Card = 1 Product

  * 2 Cards = 3 Products

  * 3 Cards = 6 Products

  * 4 Cards = 10 Products

  A player CANNOT pay more than 4 Cards as one 'set'.

  Cards and Products are tracked by the Treasuror.

For each player that is not a zombie, grant em 1 card of each type.

[The core of this proposal. Collect cards to make the other assets.]

Amend rule 2499 "Welcome Packages" by replacing:

  When a player receives a Welcome Package, e earns 10 coins.

with:

  When a player receives a Welcome Package, e earns 10 coins and
  one of each type of Card defined in the rules.

[Simple Welcome package addition]

Amend rule 2483 "Economics" by removing the following line:

  A player CAN win the game by paying a fee of 1,000 Coins.

[Ultimately counter to an economy where we want constant trading and
asset movement.]

Enact a new Power=1 rule titled "VP Wins" with the following text:

  If a player has at least 20 more Victory Points than any other
  player, e CAN win by announcement. When a player wins this way,
  all Cards and all Products are destroyed. Then each non-zombie
  player is granted 1 card of each type.

[Exactly what it says on the tin.]

Amend rule 2555 "Blots" by replacing the following paragraph:

  If a person (the penitent) has neither gained blots nor had more
  than 2 blots expunged from emself in the current Agoran week, then
  any player (the confessor) who has not, by this mechanism,
  expunged any blots in the current Agoran week CAN expunge 1 blot
  from the penitent, by announcement.

with:

  Any player CAN expunge a blot from a specified person (or emself
  if no one is specified) by paying a fee of one Blot-B-Gone.

[Pretty straightforward, now you need to use Blot-B-Gones to get rid of
Blots (except for the fugitive decay, I left that in).]

Amend rule 2350 "Proposals" by replacing:

  Creating a proposal adds it to the Proposal Pool. Once a proposal
  is created, neither its text nor any of the aforementioned
  attributes can be changed. The author (syn. proposer) of a
  proposal is the person who submitted it.

with:

  Creating a proposal adds it to the Proposal Pool. Once a proposal
  is created, its text, author, and AI cannot be changed. The author
  (syn. proposer) of a proposal is the person who submitted it.

[I moved all the pending stuff out of here, but still modified the
language to allow the co-author mechanic.]

Create a new Power=1 rule titled "Pending Proposals" with the following
text:

  Pended is a negative boolean proposal switch tracked by the
  Promotor. Any player CAN pay 1 Pendant to flip the Pended switch
  of a specified proposal to True. If the player did not create the
  proposal and is not listed in the list of co-authors of the
  proposal, e is added to the list of co-authors.

  The Promotor CAN, once a week and with 2 support, flip the Pended
  switch of a proposal in the Proposal Pool to True. E SHOULD NOT do
  so if the author of the proposal has at least one Pendant or
  Legislative Card.

  A proposal with a Pended switch set to True is 'pending'.

[Basically pending is a separate mechanic from the Pool, so that it
interferes with long standing rules about the pool much less.]

Amend 1607 Distribution by replacing:

  The Promotor CAN distribute a proposal which is in the Proposal
  Pool at any time.

  In a given Agoran week, the Promotor SHALL distribute each
  proposal that was in the Proposal Pool at the beginning of that
  week, except for those excepted from automatic distribution by
  other rules, or those that are otherwise removed from the Pool.

with:

  The Promotor CAN distribute a proposal which is in the Proposal
  Pool at any time, but SHALL NOT do so unless it is pending.

  In a given Agoran week, the Promotor SHALL distribute each
  pending proposal that was in the Proposal Pool at the beginning
  of that week, except for those excepted from automatic
  distribution by other rules, or those that are otherwise removed
  from the Pool.

  If a proposal has been in the proposal pool for more than 7 days
  and is not pending, the Promotor CAN and SHOULD remove it from the
  Pool by announcement.

[This looks long but the actual changes are small. Basically where it
says someone can distribute a proposal it now specifies a pending
proposal. Also adds a way to clear out proposals nobody ever pended.]

Amend rule 2422 "Voting Strength" by adding:

  A player CAN Buy Strength by paying 1 Extra Vote and specifying a
  current Agoran decision on which e is a voter. For each time a
  player has Bought Strength on a decision, eir voting strength is 1
  greater on that decision. A player CANNOT Buy Strength for the
  same decision more than 3 times.

[Inserting this in 2422 is a little wonky, but there's no issues with it
afaik. I might proposal a somewhat cleaner solution later.]

Create a new Power=1 rule titled "Popular Proposal Proposer Privilege"
with the following text:

  The player who proposed the proposal with the greatest F/A, as
  defined in rule 955, among all proposals assessed in the last 7
  days CAN once earn one Legislative Card by announcement. If there
  is a tie, all authors of the tied proposals may do so once each.

[This introduces 4 (or more!) Legislative Cards per month. My math says
that this, along with the 6 that can be created by officers should be
enough. But time will tell for sure.]

Create a new Power=1 rule titled "Card Administration" with the
following text:

  Justice Cards are associated with the Ministry of Justice.
  Legislative Cards are associated with the Ministry of Legislation.
  Voting Cards are associated with the ministry of Participation.

  An officer CAN, once per month and by announcement, grant another
  player a specified type of card under the following conditions:

  * the officer holds at least one office with the Card's associated
    ministry in its interests,

  * the player receiving the Card does not hold an office with the
    Card's associated ministry in its interests, AND

  * the player receiving the Card is not a zombie.

[I like this system a lot but I note the PM and Speaker can't receive
cards this way. I'm open to patches but I think they'll likely be able
to trade the cards they can create for the ones they need, so I'm not
immediately concerned.]

Flip the Pended switch of every proposal in the proposal pool to True."""
            )
        }
    }

    voting {
        votes(RLee) {
            FOR on 8405
            // NO VOTE on 8406
            FOR on 8407
            PRESENT on 8408
        }

        votes(nch) {
            FOR on 8405
            AGAINST on 8406
            PRESENT on 8407
            FOR on 8408
        }

        votes(PSS) {
            FOR on 8405
            FOR on 8406
            FOR on 8407
            FOR on 8408
        }

        votes(ATMunn) {
            FOR on 8405
            PRESENT on 8406
            PRESENT on 8407
            FOR on 8408
        }

        votes(Trigon) {
            FOR on 8405
            AGAINST on 8406
            FOR on 8407
            FOR on 8408
        }

        votes(Jason) {
            FOR on 8405
            AGAINST on 8406
            FOR on 8407
            FOR on 8408
        }

        votes(Falsifian) {
            endorse(Jason) on 8405
            AGAINST on 8406
            endorse(G) on 8407
            endorse(nch) on 8408
        }

        votes(Aris) {
            PRESENT on 8405
            AGAINST on 8406
            FOR on 8407
            FOR on 8408
        }

        votes(G) {
            FOR on all
        }
    }
}
