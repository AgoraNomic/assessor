package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeV2
import org.agoranomic.assessor.dsl.ministries.OfficeV2.*
import org.agoranomic.assessor.dsl.ministries.ministriesV2
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.Ministry.Efficiency
import org.agoranomic.assessor.lib.Ministry.Justice
import org.agoranomic.assessor.lib.VoteKind
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8368 to 8372`() = assessment {
    name("8368-8372")
    quorum(7)

    val offices = mapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Comptrollor to null,
        Distributor to omd,
        Herald to Alexis,
        Notary to Gaelan,
        PrimeMinister to Aris,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to twg,
        Tailor to PSS,
        Treasuror to twg
    )

    strengths {
        default(3)

        offices[Speaker]!! add 1
        twg subtract 2 // BLOTS
        Murphy subtract 1 // BLOTS

        ministriesV2(offices, allProposals)
    }

    proposals(v1) {
        proposal(8368) {
            title("Explicit Accusations")
            ai("1.7")
            author(G)
            chamber(Justice)

            text(
                """
Rule 2478 (Vigilante Justice) by replacing:

  A player CAN by announcement, but subject to the provisions of
  this rule, Point eir Finger at a person (the perp) who plays the
  game, citing an alleged violation of the rules by that person.

with:

  A player CAN by announcement, but subject to the provisions of
  this rule, Point eir Finger at a person (the perp) who plays the
  game; the announcement has to explicitly name the perp and cite a
  specific rule and an alleged violation of that rule by that person.

and by replacing:

  - Imposing the Cold Hand of Justice on the perp, as described
    elsewhere; or

with:

  - Imposing the Cold Hand of Justice on the perp for the cited rule
    violation, as described elsewhere; or"""
            )
        }

        proposal(8369) {
            title("Emergency Termination Notice")
            ai("3.0")
            author(Aris)
            democratic()

            text(
                """
[This gives everyone a bit of warning before someone goes and repeals the
Emergency Regulations, and gives the PM time to potentially extend
the emergency. Note that explicitly specifying the deadline in this rule
means that it can't be extended further.]

Amend the rule entitled "Eclipse Light" by changing the text
  "by announcement"
to read
  "with 7 days notice"."""
            )
        }

        proposal(8370) {
            title("Announced Petitions")
            ai("2.0")
            author(Aris)
            chamber(Efficiency)

            text(
                """
Amend Rule 2143, "Official Reports and Duties", by changing the final
paragraph to read:

A player CAN, by announcement, petition a specified officer to take
a specified action; the officer SHALL publicly respond to the petition
in a timely fashion."""
            )
        }

        proposal(8371) {
            title("Petitio Exitus")
            ai("2.0")
            author(Aris)
            chamber(Efficiency)

            text(
                """
Amend Rule 2143, "Official Reports and Duties", by deleting the final
paragraph."""
            )
        }

        proposal(8372) {
            title("Auction Overhaul")
            ai("3.0")
            author(Alexis)
            coauthors(G, Falsifian)
            democratic()

            text(
                """
Terminate all auctions; this overrides any rule that would prevent an
auction from being terminated.

Repeal Rule 2545 (Auctions).
Repeal Rule 2549 (Auction Initiation).
Repeal Rule 2550 (Bidding).
Repeal Rule 2551 (Auction End).
Repeal Rule 2552 (Auction Termination).
Repeal Rule 2584 (Free Auctions).

Amend Rule 1885 (Zombie Auctions) to read as follows:
{
  A zombie auction is an Agoran decision to award ownership of zombies to
  players. A zombie is eligible for auction if its master switch is set to
  Agora and has a resale value greater than 0.

  While there is at least one zombie eligible for auction, and no zombie
  auction is currently in progress (initiated but not resolved), the
  Registrar CAN initiate a zombie auction. For a zombie auction, the vote
  collector is the Registrar, the quorum is 0, the voting method is auction,
  and the valid options are the zombies a) that were eligible for auction at
  its initiation and b) whose master switch has not changed in the meanwhile.
  A list of the zombies eligible for auction (the "default priorities"),
  ordered by the date they became a zombie with the newest first, is an
  essential parameter of the decision.

  In a timely fashion after a zombie auction is resolved, each winner CAN and
  SHALL pay for eir prize by paying a fee equal to eir valid bid in the
  auction; when e does so, the prize's master switch is set to em. E CANNOT
  and NEED NOT do so if, before e does, the zombie's master switch changes.

  In a timely fashion after the beginning of each Agoran month, the Registrar
  SHALL either initiate a zombie auction, or if there are no zombies eligible
  for auction, announce this fact.
}

Amend Rule 2528 (Voting Methods) by replacing {which must be AI-majority,
instant runoff, or first-past-the-post} with {which must be AI-majority,
instant runoff, first-past-the-post, or auction} and by replacing
{
        2. The valid conditional votes, as defined by rules of power at
           least that of this rule; and
        3. For an instant runoff decision, the ordered lists of entities.
        4. For any other decision, the valid options.
}
with
{
        2. For a decision other than an auction, the valid conditional votes,
            as defined by rules of power at least that of this rule;
        3. For an instant runoff decision, the ordered lists of entities;
        4. For an auction decision, the positive integers (termed "bids"); and
        5. For a decision other than an instant runoff decision or an
  auction, the valid options.

  For an auction, the minimum number of options is one; for any other
  decision, it is two.
}

[I would like to make it so that voting methods don't need to be defined at
power 3, but that's beyond the scope of this proposal. It'll be part of my
administrative reform series I imagine.]

Amend Rule 683 (Voting on Agoran Decisions) by appending
{
  The above notwithstanding, an entity CANNOT withdraw a PRESENT vote on an
  auction
  decision, nor withdraw any other vote except to change eir vote to PRESENT
  or to one with an equal or higher bid.

  An entity CAN, by announcement at any time prior to the end of an auction
  decision's voting period, designate a list of entities as eir priorities
  for that decision, or change eir previously-designated priorities. An
  announcement that an entity is designating priorities for a decision is
  unsuccessful unless it indicates, clearly but not necessarily explicitly,
  that e is changing the previous ones.
}

[Since priorities work only for winners, there is much less need to enforce
validity on the designations, and this will work nicely enough for now. The
requirement for explicitness about changing is to line it up with how
voting works in general; a second set of votes does not replace the first
unless it does so.]

Amend Rule 955 (Determining the Will of Agora) by appending the following
to the list:
{
   4. For an auction, the outcome is an association of voters (winners) to
  valid options (prizes) determined as follows. For each voter (with a valid
  vote) in descending order of bids (breaking ties in favour of the voter
  whose valid vote was submitted first), of the remaining prizes, e is
  assigned the first as-yet unassigned prize that 1) appears first in eir
  priorities for that decision, if any, otherwise 2) the one that appears
  first in the decision's default priorities, if any, otherwise 3) one chosen
  by the vote collector by announcement. Continue in this manner until all
  prizes have been assigned or the list of voters is exhausted. Any remaining
  voters do not win any prize, and any remaining prizes are excess lots.
}

[This allows people to target specific zombies rather than fighting over
which ones they don't want. The bug around zombies that stop being eligible
is fixed by them being considered no longer valid options.]

Amend Rule 107 (Initiating Agoran Decisions) by replacing {The vote
collector for a decision with less than two options CAN and SHALL end the
voting period by announcement} with {The vote collector for a decision with
fewer than its minimum number of options CAN and SHALL end the voting
period by announcement}

Amend Rule 2532 (Zombies) by replacing {bid in a zombie auction;} with
{cast or withdraw a vote in, or designate priorities for, a zombie auction;}"""
            )
        }
    }

    voting {
        votes(Aris) {
            FOR on 8368
            FOR on 8369
            FOR on 8370
            PRESENT on 8371
            AGAINST on 8372
        }

        votes(Alexis) {
            FOR on 8368
            FOR on 8369
            AGAINST on 8370
            AGAINST on 8371
            FOR on 8372
        }

        votes(Warrigal) {
            PRESENT on all
        }

        votes(RLee) {
            FOR on 8368
            AGAINST on 8369
            AGAINST on 8370
            FOR on 8371
            AGAINST on 8372
        }

        votes(PSS) {
            FOR on 8368
            FOR on 8369
            FOR on 8370
            AGAINST on 8371
            AGAINST on 8372
        }

        votes(Falsifian) {
            FOR on 8368
            endorse(Aris) on 8369
            PRESENT on 8370
            PRESENT on 8371
            FOR on 8372
        }

        votes(G) {
            FOR on 8368
            PRESENT on 8369
            FOR on 8370
            PRESENT on 8371
            AGAINST on 8372
        }

        votes(Jason) {
            FOR on 8368
            FOR on 8369
            FOR on 8370
            AGAINST on 8371
            AGAINST on 8372
        }

        votes(Rance) {
            endorse(Jason) on all
        }
    }
}
