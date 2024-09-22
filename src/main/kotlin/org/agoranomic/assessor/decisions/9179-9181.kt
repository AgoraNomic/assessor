package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9179to9181() = assessment {
    name("9179-9181")
    quorum(8)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy Forest
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy oliver
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9179) {
            title("No Race Conditions")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[The intent here is the order folks fire rounds in a given week
shouldn't matter -- essentially everyone shoots simultaneously. That
way, there's no incentive to schedule things around midnight Monday.]

Amend rule 2692 (Bang!) by replacing "a single player is alive" with "a
single player was alive at the beginning of the week"

Amend rule 2696 (Bang actions) by replacing the paragraph reading:

       When a player (the shooter) fires a round, sequentially for each
       person (the target) in the target list, if the shooter is alive
       and has at least two bangs, and the target is an alive player,
       then two of the shooter's bangs are destroyed, after which the
       target is eliminated.

with:

       When a player (the shooter) fires a round, sequentially for each
       person (the target) in the target list, if the shooter has at
       least two bangs and was alive at the beginning of the week, and
       the target was an alive player at the beginning of the week, then
       two of the shooter's bangs are destroyed, after which the target
       is eliminated."""
            )
        }

        proposal(9180) {
            title("Pragmatic Shootouts")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[Makes the ongoing->none transition non-automatic and adds
initializing->none as a possible transition. In addition, clarifies that
non-players can get eliminated but nothing happens to em.]

Amend rule 2696 (Bang actions) by 1) replacing the paragraph reading:

       When a player is eliminated, if eir vitality is alive, then the
       following happen in order:
       * Eir vitality is flipped to unalive.
       * E gains one bang.

with:

       When a person is eliminated, if e is an alive player then the
       following happen in order:
       * Eir vitality is flipped to unalive.
       * E gains one bang.

2) replacing the paragraph reading:

       If the match state is ongoing and has not changed in the past 7
       days, and if no player has loaded a round or fired a round in this
       Agoran week or the previous two Agoran weeks, then the match state
       becomes none.

with:

       If the match state is ongoing and has not changed in the past 7
       days, and if no player has loaded a round or fired a round in this
       Agoran week or the previous two Agoran weeks, then any player CAN
       flip the match state to none by announcement.

and 3) adding the following paragraph at the end of the rule:

       If the match state is initializing and has not changed in the
       past 28 days, then any player CAN flip the match state to none by
       announcement."""
            )
        }

        proposal(9181) {
            title("A New Economy")
            ai("2.0")
            author(ais523)
            coauthors(kiako)
            ordinary()

            text(
                """
[The main idea: you can request a grantable thing (radiance or certain
selected assets) once per month; the next month, you get an amount of
that thing based on how many other players requested the same thing.
Later in the proposal, some new tradeable requestable assets are added
in order to make this function correctly.]

Create a new power 2 rule, "Allocation":
{{{
      The Allocator is a sortitioned office, responsible for tracking
      Requests and performing the Allocation.

      Once per month, the Allocator CAN by announcement perform the
      Allocation. E SHALL do so in a timely fashion after the start
      of each month, and when e does so, e SHALL list the changes
      to assets and switches that occur as a result (either by stating
      the value after the change or by stating the size and direction
      of the change).

      When the Allocation is performed, the following events happen, in
      sequence:

      * All Pendants are destroyed;
      * All Megaphones are destroyed;
      * One Pardon is revoked from each entity that owns any;
      * For each requestable category of assets and switches, each
        player whose Request is set to that category is granted (S / N)
        rounded down of the relevant asset, or has their value of the
        relevant switch increased by (S / N) rounded down, where S is
        the supply of that category, and N is the number of players
        whose Request is set to that category;
      * Officers are granted Megaphones, as stated elsewhere;
      * Each player's Request becomes unset.
}}}
Create a new power 2 rule, "Requests":
{{{
      Some categories of assets and switches are requestable; each of
      these has a supply. The list of categories of requestable assets
      and switches is as follows:

      * Pendants (supply 24)
      * Spendies (supply 24)
      * Radiance (supply 18)
      * Stamps (supply 12)
      * Pardons (supply 6)
      * Megaphones (supply 6)

      When a player is granted stamps via the Allocation, the stamps
      that are granted are of that player's type.

      Request is an active player switch, tracked by the Allocator,
      for which "unset" is a possible value (and the default), and
      each category of requestable asset is also a possible value.

      A player whose Request is unset can change their Request by
      announcement, as long as the Allocation has already been
      performed in the current month.
}}}

[Tie voting power to an asset. Megaphones are tradeable but temporary
assets that grant voting power, that reset during the Allocation.
Voting power from offices is tied into the Megaphone system, primarily
to make tracking easier for the Assessor.]

Create a new power 2 rule, "Megaphones":
{{{
      Megaphones are fungible assets. The Assessor is the recordkeepor
      of Megaphones. The creation, destruction and transfer of
      Megaphones is secured.

      Each player's voting strength on referenda on ordinary proposals
      is increased by the number of Megaphones e holds.
}}}

In Rule 2632, amend
{{{
      For each office a player holds, eir voting strength is increased
      by the complexity of the office for referenda on ordinary
      proposals, up to a maximum increase of 3 by this method.
}}}
to
{{{
      As part of the Allocation, each player who is an officer
is granted a number of Megaphones equal to the total complexity
      of all offices e holds, to a maximum of 3. The precise timing
      of this grant is stated elsewhere.
}}}

[Add a cost to creating proposals – this helps ensure the economy is
backed by something.]

Create a new power 2 rule, "Pendants":
{{{
      Pendants are fungible assets. The Promotor is the recordkeepor of
      Pendants.

      Immediately after a player submits a proposal, one Pendant is
      revoked from em, if possible.  A player SHALL NOT submit a
      proposal if e owns no Pendants; violating this requirement has
      a Class of 4.

      A player CAN pay a fee of 4 Spendies to grant emself a Pendant.
}}}

To the list in rule 2499, add the following list item:
{{{
      * 3 Pendants, if the Allocation has not been performed since e
        last registered.
}}}

[Allow players to stockpile Blot removal to a limited extent; the
stockpiles decay slightly during the Allocation.]

Delete the following paragraph from rule 2555:
{{{
      Any player CAN pay a fee of 7 Spendies to revoke a blot from a
      specified person.
}}}

Create a new power 1.7 rule, "Pardons":
{{{
      Pardons are fungible assets. The Referee is the recordkeepor of
      Pardons. The creation and transfer of Pardons is secured.

      A player CAN pay a fee of 1 Pardon to revoke 1 Blot from a
      specified person.

      A player CAN pay a fee of 7 Spendies to grant emself 1 Pardon.
}}}

[Unlock everyone's Request switch – otherwise we'll have to wait until
the start of November before the new economy does anything. This won't
change any assets/switches other than converting officer voting power
to the Megaphone system, because all the Requests will be unset.]

Perform the Allocation."""
            )
        }
    }

    voting {
    }
}
