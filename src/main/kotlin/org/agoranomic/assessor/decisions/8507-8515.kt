package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_06_30.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_08_02
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
import org.agoranomic.assessor.lib.vote.finalResolution
import org.agoranomic.assessor.lib.vote.voteIfVoted

@UseAssessment
fun assessment8507to8515() = assessment {
    name("8507-8515")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-October/014335.html")
    quorum(5)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Coopor to G,
        Distributor to omd,
        Herald to PSS,
        Notary to ATMunn,
        PrimeMinister to ATMunn,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Janet,
        Speaker to G,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(Gaelan, 4 / 3)
        blotPenalty(RLee, 81 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_08_02(offices, allProposals)
    }

    proposals(v2) {
        proposal(8507) {
            title("Happy Belated Birthday v3")
            ai("1.0")
            author(ATMunn)
            coauthors(G, Falsifian)
            chamber(Participation)
            sponsored()

            text("""
Amend Rule 2585, "Birthday Gifts", by deleting the sentence "Every time
it is a player's Agoran Birthday, each of the other players CAN once
grant em 3 coins by announcement.", and inserting the following
paragraph in its place:

  During a player's Agoran Birthday and the 7 days following, each
  other player CAN, once, grant em X coins, where X is 3 if it is
  actually the day of the player's birthday, and 2 otherwise.

[This simplifies the rule change and fixes the bugs mentioned by
Falsifian. There's no real reason to prevent players from granting the
belated birthday gift just because people already granted the birthday
gift.]""")
        }

        proposal(8508) {
            title("No Zombie Races")
            ai("2.0")
            author(Falsifian)
            chamber(Efficiency)
            sponsored()

            text("""
Amend Rule 1885 by replacing "existed at the beginning of the month" with
"exist".

[Comment: With the current text, the Registrar is in an awkward position
if at least one eligible talisman existed at the start of the month, but
none exist by the time e gets around to starting an auction.]""")
        }

        proposal(8509) {
            title("Dependent De-escalation")
            ai("3.0")
            author(BaronVV)
            coauthors(Janet, Trigon)
            democratic()
            sponsored()

            text("""
Change the power of Rule 2124 to 3.

[Currently, Rule 2124 is at power 2. This means a power 2 dictatorship
could amend that rule to approve any of its intents, then ratify without
objection anything it wants, which is certainly enough to get to power 3.]""")
        }

        proposal(8510) {
            title("Festival Pending")
            ai("2.1")
            author(BaronVV)
            coauthors(Janet, Trigon)
            chamber(Legislation)
            sponsored()

            text("""
Amend Rule 2481 by adding the following item to the sole list:
  "Non-Festive players CANNOT cause proposals to become Pended."

[This was here when I joined, then removed because we didn't have a concept
 of pending. I think this is a good restriction during festivals, so this
 proposal adds it back.]""")
        }

        proposal(8511) {
            title("VP Win indirection")
            ai("1.0")
            author(BaronVV)
            coauthors(Janet, Trigon)
            chamber(Participation)
            sponsored()

            text("""
[

Current text:

{
  If a player has at least 20 more Victory Points than any other player, e
  CAN win by announcement. When a player wins this way, all Cards and
  all Products are destroyed. Then each non-zombie player is granted 1 card
  of each type.
}



This doesn't use an indirect method for winning, unlike most other rules.
This proposal changes that.

]



Amend Rule 2621 to read in whole:

{
  If a player has at least 20 more Victory Points than any other player, e CAN
  Take Over the Economy by announcement. When a player does so, e wins the
  game, all Cards and all Products are destroyed, then each non-zombie player
  is granted 1 card of each type.
}""")
        }

        proposal(8512) {
            title("Lime Debait")
            ai("3.0")
            author(Gaelan)
            coauthors(Janet)
            democratic()
            sponsored()

            text("""
  In Rule 2438 "Ribbons", replace the paragraph beginning "Lime,"
  replace "three or more proposals" with "three or more proposals with
  different authors".""")
        }

        proposal(8513) {
            title("Our Heroic Distributor")
            ai("3.0")
            author(Aspen)
            democratic()
            sponsored()

            text("""
WHEREAS, since 2003, omd has served as Distributor, hosting and maintaining
the Agoran lists and website;

WHEREAS the period of eir Distributorship comprises the majority of Agoran
history;

WHEREAS e has been diligent about keeping the technical underpinnings of Agoran
play running through good times and bad, even when e was not active within
the game itself; and

WHEREAS eir service, a substantial portion of which was performed without
official recognition under the rules, has been well above and beyond the
call of duty:

BE IT HEREBY ENACTED BY THE PLAYERS OF AGORA that omd is
NOW AND FOREVERMORE a Hero of Agora Nomic, and that e is granted the
Patent Title recognizing such.""")
        }

        proposal(8514) {
            title("The Buoyant Economy")
            ai("3.0")
            author(Aspen)
            coauthors(nix, Trigon, G, Janet, ATMunn)
            democratic()
            sponsored()

            text("""
Enact a new power 1.0 rule, entitled "Buoyancy Control", with the following
text:
  The Total Buoyancy is a singleton integer switch, tracked by the
  the Treasuror in eir monthly report.

  The Treasuror CAN, by announcement, set the Total Buoyancy to a specified
  value approximately equal to the sum of all coin balances at a specified
  point within the first Eastman week of the current month. Whenever e does so,
  e SHALL endeavor to calculate the correct sum for eir chosen point. E
  SHALL set the Total Buoyancy once a month.

  The Treasuror CAN and MAY exercise reasonable judgement in calculating the
  Total Buoyancy. The Total Buoyancy will be deemed set so long as the value
  chosen by the Treasuror is not obviously and grossly incorrect. The Treasuror
  CAN and MAY set the Total Buoyancy more than once a month, but SHOULD NOT do
  so unless there is reason to believe eir previous setting of the value
  failed.


[The divisor, 2500, was selected based on some testing suggesting that
it would work well at meeting the dual goals of promoting social
mobility and keeping inflation manageable. We can tweak it later
as needed.

Re the term boatloads, which may be the best part of this, I want to
thank nix and G. for pointing me in the right direction, and most of all
Trigon for suggesting the term.]

Enact a new power 1.0 Rule entitled "Floating Rate Fleet", with the
following text:

  The Unit of Flotation is equal to 1/2500 times the Total Buoyancy,
  unrounded. A boatload of something is a quantity of that thing equal in
  count to the Unit of Floatation. When a quantity of assets is
  expressed in boatloads, it is rounded up to the next whole asset.

  The Floating Rate Schedule is part of the Treasuror's monthly report. It
  contains the Total Buoyancy, the Unit of Flotation, and the real value
  of every quantity that is expressed in boatloads in a rule or regulation. The
  Treasuror is ENCOURAGED to also consider including quantities in contracts.
  The Treasuror SHOULD publish the Floating Rate Schedule immediately after
  setting the Total Buoyancy.

  When taking an action, a person SHOULD expand all quantities that are
  expressed in boatloads.

[This means that the changes don't really take effect until the Treasuror
publishes the first Floating Rate Schedule.]
Set the Total Buoyancy to 2500.

[This incorporates Trigon's proto, "End monthly officer stipends".]

Amend Rule 2559 "Paydays" so it reads:
  Whenever a Payday occurs, each active player earns 10 boatloads of coins.

  The occurrence of Paydays is secured. At the beginning of each
  month, a Payday occurs.

# MINOR COIN CLEANUP THAT YOU CAN PROBABLY IGNORE

[There is literally no reason Agora should ever have any coins.]

Revoke all coins from Agora.

Amend Rule 2483, Economics, by changing

  "They can be owned by Agora, players, and contracts."

to read

  "They can only be owned by players, contracts, and the Lost and
  Found Department."

# TECHNICAL AND CONFORMING AMENDMENTS


Amend Rule 2496, "Rewards", by replacing each instance of "coins" with
"boatloads of coins".
Amend Rule 2499, "Welcome Packages", by replacing "coins" with "boatloads
of coins".
Amend Rule 2602, "Glitter", by replacing "coins" with "boatloads of coins".
Amend Rule 2631, "Charities", by replacing "coins" with "boatloads of coins".

[This one is phrased like this in case some version of ATMunn's birthday
proposal passes.]
Amend Rule 2585, "Birthday Gifts", by replacing each instance of "coins" with
"boatloads of coins".""")
        }

        proposal(8515) {
            title("adMinistration v1.1")
            ai("2.0")
            author(nix)
            coauthors(Trigon, Aspen)
            chamber(Economy)
            sponsored()

            text("""
Amend R2605, "Ministries", to read in full:

  A Ministry is an entity defined as such by this rule. Each
  Ministry has a goal. The Ministries of Agora, and their goals,
  are as follows:

  A. Ministry of Compliance: Ensure players follow rules and
  voluntary agreements and receive appropriate sanctions when they
  do not.
  B. Ministry of Legislation: Enable and encourage gameplay
  related to the rules themselves.
  C. Ministry of Economy: Enable and encourage gameplay related to
  assets and currencies.
  D. Ministry of Legacy: Track and reward great Agoran
  achievements
  E. Ministry of Participation: Track information about the
  participation of people in Agora.

(Reworked the list to hopefully have a better distribution in offices
and proposals)

Enact a new Power=1 rule titled "The Ministor" with the following text:

  The Ministor is an office, tasked with overseeing gameplay
  related to Ministries. The Ministor SHALL publish eir monthly
  report in a timely manner from the beginning of the month.

Nix assumes the office of Ministor.

(New office with a special time sensitive monthly report, to ensure
these things are easy for players to keep up on)

Enact a new Power=2 rule titled "Office Interests" with the following
text:

  Ministry Interest (or just Interest) is a secured office switch,
  tracked by the Ministor in eir monthly report, whose possible
  values are lists of ministries, defaulting to the empty list. The
  Ministor CAN flip an office's Ministry Interests without
  objection.

  For each item of each office's Ministry Interest, that office's
  holder's voting strength is increased by 2 on proposals whose
  Ministry Impact is set to that Ministry.

(Note that this moves a duty that used to belong to ADoP to Ministor.
It just makes a bit more sense here.)

When this proposal passes flip the Ministry Interest switch of every
office to the value of that office's Interest switch immediately before
this proposal passed with the following changes, applied in order:

* replace every instance of "justice" with "compliance"
* replace every instance of "efficiency" with "participation"

(This will ensure that every office still has at least one interest,
but it will also change some switches in undesirable ways. I'll, as
Ministor, separately intend to fix a bunch of these offices' interests
to better match the new categories)

Enact a new Power=2 rule titled "Player Focuses" with the following
text:

  Ministry Focus (or just Focus) is a secured active player switch,
  tracked by the Ministor in eir monthly report, with possible values
  Unfocused (the default) and any Ministry.

  An active player CAN Plan to Flip eir own Ministry Focus,
  specifying any valid value for eir Ministry Focus, by
  announcement. At the beginning of a month, every active player's
  Ministry Focus is set to the value e mostly recently specified by
  Planning to Flip. If a player did not Plan to Flip eir Ministry
  Focus switch in the last month, it is not flipped.

(This, combined with the below rule, will take over the card grants
that offices used to get, making it less gerontocratic and more
strategic.)

Amend R2624, "Card Administration", to be titled "Focus Grants" and to
read in full:

  Each of the following Ministries has a Grant, listed below.

  Ministry of Compliance: 1 Justice Card
  Ministry of Legislation: 1 Legislative Card
  Ministry of Participation: 1 Voting Card
  Ministry of Economy: 50 coins divided by X, rounded up; where X
  is the number of players with their Ministry Focus set to
  Economy. The Ministor SHALL report this value in a timely manner
  after the beginning of the month.

  A player CAN once a month grant eir Ministry Focus' Grant to a
  specified player by announcement.

  The Ministor CAN, once a month and by announcement, and SHALL, in
  a timely manner from the beginning of the month, grant 1 Victory
  Card to a random player whose Ministry Focus is Legacy and 1
  Victory Point to every other player whose Ministry Focus is
  Legacy.

(This system replaces officer grants, in a way that involves a lot more
planning and strategy.)

Amend R2422, "Voting Strength", by replacing the last paragraph with:

  A player CAN Buy Strength by paying 1 Extra Vote and specifying a
  current Agoran decision on which e is a voter. For each time a
  player has Bought Strength on a decision, eir voting strength is
  1 greater on that decision. If the decision is on a proposal, and
  the proposal's chamber and the player's focus are the same value,
  then eir voting strength is instead 2 greater on that decision.
  A player CANNOT Buy Strength for the same decision more than 3
  times.

(Added a clause where if Focus=Chamber, you get 2 strength instead of
1. Flavorful, and potentially makes Extra Votes more useful. We'll
see.)""")
        }
    }

    voting {
        votes(Aspen) {
            FOR on 8507
            FOR on 8508
            FOR on 8509
            FOR on 8510
            FOR on 8511
            endorse(PSS) on 8512
            FOR on 8513
            FOR on 8514
            FOR on 8515
        }

        votes(Telna) {
            endorse(Aspen) on all
        }

        votes(Gaelan) {
            AGAINST on 8512
            endorse(author) on others
        }

        votes(Trigon) {
            FOR on 8507
            FOR on 8508
            FOR on 8509
            FOR on 8510
            FOR on 8511
            PRESENT on 8512
            FOR on 8513
            FOR on 8514
            FOR on 8515
        }

        votes(sukil) {
            endorse(Trigon) on all
        }

        votes(ATMunn) {
            FOR on 8507
            FOR on 8508
            FOR on 8509
            FOR on 8510
            FOR on 8511
            PRESENT on 8512
            FOR on 8513
            FOR on 8514
            FOR on 8515
        }

        votes(PSS) {
            FOR on 8507
            FOR on 8508
            FOR on 8509
            endorse(Aspen) on 8510
            FOR on 8511
            AGAINST on 8512
            FOR on 8513
            FOR on 8514
            PRESENT on 8515
        }

        votes(G) {
            FOR on 8507
            FOR on 8508
            PRESENT on 8509
            PRESENT on 8510
            PRESENT on 8511
            AGAINST on 8512
            FOR on 8513
            PRESENT on 8514
            PRESENT on 8515
        }

        votes(DMargaux) {
            endorse(G) on all
        }

        votes(Janet) {
            FOR on 8507
            FOR on 8508
            FOR on 8509
            FOR on 8510
            FOR on 8511
            AGAINST on 8512
            FOR on 8513
            FOR on 8514
            FOR on 8515
        }

        votes(BaronVV) {
            endorse(Janet) on all
        }

        votes(nix) {
            FOR on 8507
            FOR on 8508
            PRESENT on 8509
            PRESENT on 8510
            FOR on 8511
            endorse(Gaelan) on 8512
            FOR on 8513
            FOR on 8514
            FOR on 8515
        }

        votes(Falsifian) {
            endorse(ATMunn) on 8507
            FOR on 8508
            endorse(Janet) on 8509
            endorse(Janet) on 8510
            endorse(Janet) on 8511
            AGAINST on 8512
            endorse(Aspen) on 8513

            function { context ->
                if (
                    context
                        .resolve(context.currentProposal, Trigon)
                        ?.finalResolution(context)
                        ?.voteIfVoted
                    != PRESENT
                ) {
                    endorse(Trigon) // TODO: annotate conditional somehow
                } else {
                    endorse(Aspen) // TODO: annotate conditional somehow
                }
            } on 8514

            endorse(nix) on 8515
        }

        votes(twg) {
            endorse(Falsifian) on all
        }
    }
}
