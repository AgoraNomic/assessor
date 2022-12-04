package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_06_30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_06_30
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV1.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8459to8472() = assessment {
    name("8459-8472")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-July/013921.html")
    quorum(8)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Coopor to G,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to nix,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Janet,
        Speaker to G,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 80 / 3)

        ministries_2020_06_30(offices, allProposals)
        addToHolder(offices, Speaker, 1)
    }

    proposals(v1) {
        proposal(8459) {
            title("Talismans")
            ai("3.0")
            author(Janet)
            coauthors(nix, Falsifian, G)
            democratic()

            text(
                """
For the purposes of this proposal, a player's prior master is eir master
before this proposal applies any effects.

Amend Rule 2532 to read, in whole:
{

  A talisman is an indestructible asset, tracked by the Registrar, and
  with ownership wholly restricted to players and Agora. There exists
  exactly one talisman for each player, and no other talismans; if one
  does not exist for a certain player, it is created in eir posession.
  Talismans CAN only be transferred as explicitly specified by the rules.
  The creation, destruction, and transfer of talismans is secured.

  Rules to the contrary notwithstanding, a player CAN, by announcement,
  transfer the talisman for em to emself. The master of a player is the
  entity that possesses the talisman for em. A player who is eir own
  master is active; any other player is a zombie (syn. inactive).

  The master of a zombie CAN act on behalf of em, except a master CANNOT
  act on behalf of a zombie to:
      - initiate, support, object to, or perform a dependent action;
      - act on behalf of that zombie's zombies;
      - bid in a zombie auction;
      - enter a contract, pledge, or other type of agreement;
      - initiate a Call for Judgement;
      - create blots;
      - deregister.

  If a master causes a zombie to perform an ILLEGAL action, the master
  commits the Class 4+N Crime of Masterminding (where N is the class of
  the illegal action).

  If an active player who was a zombie has not received a Welcome Package
  since e most recently ceased being a zombie, and if eir resale value was
  less than 2 at any point during eir most recent time as a zombie, then
  any player CAN cause em to receive a Welcome Package by announcement.

}

Amend Rule 2574 to read, in whole:
{

  Any player CAN, with notice, transfer the talisman for an active player
  who has not made a public announcement in the past 60 days to Agora.

  Resale value is a secured natural switch for zombies, tracked by the
  Registrar, with a default value of 2. Whenever the talisman for a zombie
  is transferred to a player, that zombie's resale value is decreased by
  1. At the end of a zombie auction, the resale value of every zombie that
  is an excess lot in that auction decreases by 1.

  The talisman for a zombie with zero resale value CANNOT be transferred
  to any player other than that zombie.

  Any player CAN, with notice:
      - If a zombie has been a zombie for the past 90 days and not had
        Agora for a master during any of that time, transfer the talisman for
        em to Agora;
      - If a player possesses more than one talisman, specify and transfer
        one of those talismans to Agora;
      - Deregister a zombie whose resale value is zero and whose master is
        Agora.

  The Registrar SHALL track the date for each zombie on which Agora was
  most recently eir master. The Registrar SHALL perform all POSSIBLE
  actions in the preceding paragraph in a timely fashion after first
  reporting their possibility via the facts in eir weekly report.

}


Amend Rule 1885 to read, in whole:
{

  Whenever a zombie has Agora for a master and has a resale value greater
  than 0, and when eir talisman is not currently a lot in an auction and
  has not been won as an auction lot in the past 14 days, then the
  Registrar CAN put that zombie's talisman (along with any other talismans
  that fulfill the same conditions) up for auction.

  In a timely fashion after the beginning of each month, the Registrar
  SHALL either initiate such an auction or, if no talismans meeting these
  conditions existed at the beginning of the month, announce that no such
  auction is necessary.

  For such an auction, each lot consists of the talisman for one zombie,
  ordered at the discretion of the Registrar. The Registrar is the
  auctioneer, and the minimum bid is 1. The method to be used for this
  auction is the zombie auction method if such a method exists, or
  otherwise the default auction method.

}

Amend Rule 2575 by replacing the final sentence with
  "Rules to the contrary notwithstanding, the talisman for the Distributor
  is possessed by emself (and is transferred to em if it ever is not), and
  e CANNOT deregister or be deregistered."

For each player who is not eir own prior master, transfer the talisman
for em to eir prior master."""
            )
        }

        proposal(8460) {
            title("UV-G Sunblock")
            ai("3.0")
            author(G)
            coauthors(ais523)
            democratic()

            text(
                """
Amend Rule 2438 (Ribbons) by replacing:
  Ultraviolet (U): When a person is awarded the Patent Title
  Champion, that person earns an Ultraviolet Ribbon.
with:
  Ultraviolet (U): When a person is awarded the Patent Title
  Champion, that person earns an Ultraviolet Ribbon, unless
  the Champion title was awarded as the result of winning
  the game via this rule.


Ultraviolet is hereby removed from G.'s Ribbon Ownership."""
            )
        }

        proposal(8461) {
            title("Redoing Adopted Proposals")
            ai("2.0")
            author(RLee)
            coauthors(Aspen)
            chamber(Legislation)

            text(
                """
Amend rule 2450 "Pledges" by inserting the following sentence after
 the words "where N is 2 unless the pledge explicitly states otherwise":
{It is also Oathbreaking for a player to let a pledge expire without taking
 an action e pledged to do in that pledge. }

Amend rule 2531 "Defendant's Rights" by renumbering the list items so that
each item is preceded by a number one above the previous item, except the
first item which is preceded by the number 1.

Amend rule 2557 "Sentencing Guidelines" by replacing "where P is the
minimum of the value of the fine and 3" with "where P is the value of the
fine""""
            )
        }

        proposal(8462) {
            title("Fee-based methods")
            ai("3.0")
            author(Janet)
            coauthors(Falsifian)
            democratic()

            text(
                """
Amend Rule 2579 by replacing the first three paragraphs with the following:

{

  If the Rules associate payment of a set of assets (hereafter the fee for
  the action; syns: cost, price, charge) with performing an action, that
  method for performing that action is a fee-based method.

  If the fee is a non-integer quantity of a fungible asset, the actual fee
  is the next highest integer amount of that asset.

  To use a fee-based method, an entity (the Actor) who is otherwise
  permitted to perform the action must announce that e is performing the
  action; the announcement must specify the correct set of assets for the
  fee and indicate intent to pay that fee for the sole purpose of using
  that method to perform that action.

}

and replacing the final paragraph with the following:

{

  If a fee-based method to perform an action has a fee of no assets, that
  action CAN be performed by announcement, but the actor SHOULD announce
  that there was a 0 or empty fee.

}


[Inspired by Falsifian pointing out that winning the game is/was a
fee-based action, which might have meant that all attempts to win the
game required a fee. This removes actions being fee-based and instead
makes methods fee-based. This change is also designed to keep all
protections and (hopefully) protect existing precedent for fee-based
actions.]"""
            )
        }

        proposal(8463) {
            title("Future-proofing black ribbons")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2438 (Ribbons) by replacing the text "An Instrument CAN, as
part of its effect" with the text "A statute CAN, as part of its effect".


[Legislative intent is that black ribbons are to be awarded for a
dictatorship of any power. The current wording does not reflect this -
it instead permits black ribbons to be awarded for controlling a body of
law. Since part of the idea of bodies of law was to expand them to
regulations and contracts, this is a ticking time-bomb that could result
in giving black ribbons to anybody capable of forming a contract.]"""
            )
        }

        proposal(8464) {
            title("You can certify, but you can't win ever!")
            ai("1.0")
            author(RLee)
            chamber(Justice)

            text(
                """
Amend rule 2626 "Certifiable Patches" to read, in full "Any player
CAN, by announcement, certify a specified proposal, causing it to become
pending. A player SHALL NOT do so. Doing so is the Class-25 crime of
Legislative Misconduct. The amount of Blots given for this crime SHOULD be
significantly reduced in and only in cases of utter and manifest necessity"

Retitle rule 2626 to "Costly Certification""""
            )
        }

        proposal(8465) {
            title("Public defense")
            ai("1.0")
            author(Janet)
            coauthors(PSS)
            chamber(Justice)

            text(
                """
Amend Rule 2617 (Defense Against the Dark Arts) by replacing "Attempting
a forbidden action" with "Publicly attempting a forbidden action".

[This makes joke attempts to a-d or attempts outside of Agora not
punishable.]"""
            )
        }

        proposal(8466) {
            title("the simple option")
            ai("1.0")
            author(ATMunn)
            chamber(Legislation)

            text(
                """
Repeal Rule 2626 "Certifiable Patches"."""
            )
        }

        proposal(8467) {
            title("Talismans auction patch")
            ai("2.0")
            author(Janet)
            coauthors(Trigon)
            chamber(Economy)

            text(
                """
Amend Rule 1885 by deleting the sentence beginning "The method to be
used for this auction".

[This fixes a specification bug in the talismans proposal, since
auctions are now supposed to have their method determined by the
auctioneer, rather than a rule. If talismans has not been adopted, then
this will have no effect.]"""
            )
        }

        proposal(8468) {
            title("Decision resolution patch")
            ai("3.0")
            author(Janet)
            coauthors(nix, G)
            democratic()

            text(
                """
Amend Rule 208 by replacing the text "To be valid, this announcement
must satisfy the following conditions" with the text "To be EFFECTIVE,
such an attempt must satisfy the following conditions".

[This resolves a potential bug that *may* permit the vote collector of a
decision to resolve it without adhering to the conditions in the
numbered list of Rule 208 based on the precise wording of how the
conditions are enforced. The argument that they don't work is that the
sentence doesn't sufficiently override R208's earlier statement that
"The vote collector for an unresolved Agoran decision CAN resolve it by
announcement, indicating the outcome.", because it describes the
announcement, rather than the attempt itself.

Even if that interpretation is wrong, there is enough of an ambiguity
that it should be resolved. The new wording makes this clearer by
describing the /attempt/ as INEFFECTIVE (clearly overriding the earlier
CAN) rather than the "announcement".]"""
            )
        }

        proposal(8469) {
            title("Bureaucratic Reengineering")
            ai("2.0")
            author(Aspen)
            coauthors(Alexis, Falsifian, nix, G)
            chamber(Efficiency)

            text(
                """
If there is a rule entitled "The Administrative State" amend it to have the
text labelled "NEW TEXT" below. Otherwise, enact a new power 2.0 rule entitled
"The Administrative State", with the text labelled "NEW TEXT" below.

NEW TEXT: {
  Each officer CAN, with 1.5 Agoran consent, enact, amend, or repeal
  eir own office's Administrative Regulations. If e has won an election for
  the office in the last 7 days, e CAN repeal them by announcement.
  Administrative Regulations have the following properties:

  1. An officer SHALL NOT violate eir office's administrative regulations in
     the discharge of eir office.
  2. Any player CAN act on behalf of an officer to exercise eir official
     powers as authorized by eir office's administrative regulations.
  3. All players SHOULD abide by an officer's administrative regulations
     in matters relating to eir area of responsibility.
  }"""
            )
        }

        proposal(8470) {
            title("Sponsored Proposals")
            ai("1.0")
            author(nix)
            coauthors(G, Trigon)
            chamber(Legislation)

            text(
                """
Amend R2622, "Pending Proposals", to read in full:

  Pended is an untracked negative boolean proposal switch.

  Any player CAN pay 1 Pendant to flip the Pended switch of a
  specified proposal to True. If the player did not create the
  proposal and is not listed in the list of co-authors of the
  proposal, e is added to the list of co-authors. When e does so,
  the proposal becomes sponsored.

  The Promotor CAN, with 2+X support, flip the Pended switch of a
  proposal in the Proposal Pool to true. For this, X is equal to the
  number of times e has done so in the past 7 days.

  Any player CAN, without objection, flip the Pended switch of a
  proposal in the Proposal Pool to true.

  A proposal with a Pended switch set to True is 'pending'.

Repeal R2626 "Certifiable Patches".

Amend R2623, "Popular Proposal Proposer Privilege", by replacing:

  The player who proposed the adopted proposal whose referendum had
  the greatest popularity among all referenda assessed in the last 7
  days CAN once earn one Legislative Card by announcement, provided
  that no referendum initiated in the same message as it remains
  unresolved. If there is a tie, all authors of the tied proposals
  can do so once each.

with:

  The author of the most popular sponsored proposal adopted in the
  last 7 days CAN once earn one Legislative Card by announcement,
  provided that no referenda initiated in the same message as it
  remain unresolved. If there is a tie, all authors of the tied
  proposals can do so once each.

Amend R2496, "Rewards", by replacing "an adopted proposal" with "an
adopted sponsored proposal"."""
            )
        }

        proposal(8471) {
            title("Only the PM can be arbitrary!")
            ai("1.7")
            author(RLee)
            coauthors(Aspen)
            chamber(Justice)

            text(
                """
Repeal Rule 2479/6 "Official Injustice""""
            )
        }

        proposal(8472) {
            title("Welcoming Back Outlaws, etc.")
            ai("2.0")
            author(Aspen)
            chamber(Participation)

            text(
                """
Amend Rule 2499, "Welcome Packages", by replacing:

  A player CANNOT receive a Welcome Package via this method if e was
  deregistered on account of having excessive blots.
with:
  A player CANNOT receive a Welcome Package via this method if e has been
  deregistered on account of having excessive blots within the last 30
  days.


Amend Rule 2124, "Agoran Satisfaction", by replacing:

  The above notwithstanding, if an action depends on objections, and
  an objection to an intent to perform it has been withdrawn within
  the past 24 hours, then Agora is not Satisfied with that intent.
with:
  The above notwithstanding, if an action is to be performed without N
  objections or with N Agoran consent, and an objection to an intent
  to perform it has been withdrawn within the past 24 hours, then Agora
  is not Satisfied with that intent."""
            )
        }
    }

    voting {
        votes(RLee) {
            FOR on 8459
            FOR on 8460
            FOR on 8461
            FOR on 8462
            AGAINST on 8463
            FOR on 8464
            FOR on 8465
            FOR on 8466
            FOR on 8467
            AGAINST on 8468
            FOR on 8469
            AGAINST on 8470 comment legacyConditionalComment("P8466 was adopted")
            FOR on 8471
            FOR on 8472
        }

        votes(Tcbapo) {
            endorse(RLee) on all
        }

        votes(Madrid) {
            FOR on all
        }

        votes(PSS) {
            FOR on 8459
            FOR on 8460
            FOR on 8461
            FOR on 8462
            FOR on 8463
            AGAINST on 8464
            FOR on 8465
            AGAINST on 8466
            FOR on 8467
            FOR on 8468
            FOR on 8469
            AGAINST on 8470
            AGAINST on 8471
            FOR on 8472
        }

        votes(Janet) {
            FOR on 8459
            endorse(G) on 8460
            FOR on 8461
            FOR on 8462
            FOR on 8463
            AGAINST on 8464
            FOR on 8465
            AGAINST on 8466
            FOR on 8467
            FOR on 8468
            FOR on 8469
            PRESENT on 8470
            AGAINST on 8471
            FOR on 8472
        }

        votes(ATMunn) {
            FOR on 8459
            FOR on 8460
            FOR on 8461
            FOR on 8462
            FOR on 8463
            AGAINST on 8464
            FOR on 8465
            PRESENT on 8466
            FOR on 8467
            FOR on 8468
            FOR on 8469
            FOR on 8470
            FOR on 8471
            FOR on 8472
        }

        votes(omd) {
            FOR on 8459
            PRESENT on 8460
            AGAINST on 8461
            AGAINST on 8462
            PRESENT on 8463
            AGAINST on 8464
            AGAINST on 8465
            AGAINST on 8466
            FOR on 8467
            FOR on 8468
            FOR on 8469
            AGAINST on 8470
            AGAINST on 8471
            FOR on 8472
        }

        votes(nix) {
            FOR on 8459
            PRESENT on 8460
            PRESENT on 8461
            FOR on 8462
            PRESENT on 8463
            PRESENT on 8464
            FOR on 8465
            FOR on 8466
            PRESENT on 8467
            FOR on 8468
            FOR on 8469
            FOR on 8470
            PRESENT on 8471
            FOR on 8472
        }

        votes(Murphy) {
            FOR on 8459
            FOR on 8460
            FOR on 8461
            FOR on 8462
            FOR on 8463
            AGAINST on 8464
            FOR on 8465
            AGAINST on 8466
            FOR on 8467
            FOR on 8468
            FOR on 8469
            FOR on 8470
            AGAINST on 8471
            FOR on 8472
        }

        votes(Falsifian) {
            endorse(Janet) on 8459
            endorse(G) on 8460
            endorse(RLee) on 8461
            endorse(Janet) on 8462
            endorse(Janet) on 8463
            AGAINST on 8464
            endorse(Janet) on 8465
            PRESENT on 8466
            endorse(Janet) on 8467
            PRESENT on 8468
            FOR on 8469 comment legacyConditionalComment("Aris not against")
            endorse(nix) on 8470
            AGAINST on 8471
            FOR on 8472 comment legacyConditionalComment("Aris not against")
        }

        votes(G) {
            FOR on 8459
            FOR on 8460
            endorse(Aspen) on 8461
            FOR on 8462
            FOR on 8463
            FOR on 8464
            FOR on 8465
            FOR on 8466
            FOR on 8467
            FOR on 8468
            FOR on 8469
            FOR on 8470
            FOR on 8471
            FOR on 8472
        }

        votes(twg) {
            endorse(G) on all
        }

        votes(Trigon) {
            FOR on 8459
            endorse(G) on 8460
            FOR on 8461
            FOR on 8462
            PRESENT on 8463
            AGAINST on 8464
            FOR on 8465
            FOR on 8466
            FOR on 8467
            PRESENT on 8468
            FOR on 8469
            FOR on 8470
            PRESENT on 8471
            FOR on 8472
        }
    }
}
