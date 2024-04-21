package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*
import org.agoranomic.assessor.lib.vote.commented
import org.agoranomic.assessor.lib.vote.finalResolution
import org.agoranomic.assessor.lib.vote.voteIfVoted

@UseAssessment
fun assessment9073to9086() = assessment {
    name("9073-9086")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2024-April/017715.html")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)
            powerDream(Jimmy, 2)

            powerStone(ais523, 3)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy nix
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Geologist"(1) heldBy RLee
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy snail
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Jimmy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy snail
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9073) {
            title("In case of unexpected nonplayerhood")
            ai("1.0")
            author(Kate)
            coauthors(Gaelan)
            ordinary()

            text(
                """
In Rule 2492 (Recusal),

s/deregistered/unregistered

[Allows a judge to be removed if, through some mishap, the CFJ has
 been assigned to someone who has never been a player or who ceased to
 be a player through some means other than deregistration. Composition
 fully intended to annoy Janet, but I think completely effective under
 the new standard of "clear to a reasonable player".]"""
            )
        }

        proposal(9074) {
            title("Close enough")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 105 by deleting the text " and the next change identifier".

[Remove the reference to "change identifiers" (presumably just revision
numbers) for reenactment.]


Amend Rule 1681 by, as a single amendment, deleting the text ", revision
number, " and inserting the following paragraph after the paragraph
beginning "The listing of each rule in the SLR":

{

The listing of each rule in the SLR must additionally include a
reasonably accurate approximation of the number of changes made to the
rule (the rule's revision number). The Rulekeepor may exercise
reasonable discretion in calculating revision numbers.

}

[Define what a rule's "revision number" is and explicitly grant the
Rulekeepor discretion in calculating it (e.g. not counting certain
amendments (back when we used Suber-style proposals that re-numbered
rules) or skipping revision numbers (for historical reasons).]"""
            )
        }

        proposal(9075) {
            title("No Hidden Ownership Restrictions")
            ai("3.0")
            author(nix)
            coauthors(Janet, kiako)
            democratic()

            text(
                """
[Right now, sentences like "Blank are an asset ownable by..." is
interpreted to adding to a default within R2576. This seems unintuitive.
This proposal makes that default only apply if there's no mention of
ownership.]

Amend R2576 (Ownership) by replacing:

    If ownership of an asset is restricted to a class of entities, then
    that asset CANNOT be gained by or transferred to an entity outside
    that class. By default, ownership of an asset is restricted to
    Agora, players, and contracts, but an asset's backing document may
    modify this.

with:

    An asset CANNOT be gained by or transferred to an entity unless its
    backing document specifies that entity can own it. If an asset's
    backing document is otherwise silent on which entities can own it,
    then it can be owned by Agora, players, and contracts.

Amend R2659 (Stamps) by replacing:

    Stamps are a category of asset ownable by players .

with:

    Stamps are a category of asset ownable by players and Agora."""
            )
        }

        proposal(9076) {
            title("FUNgibility")
            ai("3.0")
            author(nix)
            democratic()

            text(
                """
[Right now, sentences like "Blank are an asset ownable by..." is
interpreted to adding to a default within R2576. This seems unintuitive.
This proposal makes that default only apply if there's no mention of
ownership.]

Retitle R2578 (Currencies) to "Fungibility"

Amend R2578 to read in full:

    A fungible asset is one where two instances of it are considered
    equivalent if they have the same owner, for the purposes of
    specification, granting, and transferring. The total amount of a
    fungible asset that an entity owns is also know as that entities
    "balance" of that asset.

Amend R2659 (Stamps) by replacing:

    Stamps of a given type are a currency.

with:

    Stamps of a given type are fungible.

Amend R2555 (Blots) by replacing:

    Blots are an indestructible fixed currency

with:

    Blots are an indestructible fixed fungible asset"""
            )
        }

        proposal(9077) {
            title("Less Fragile Crystals")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
[Makes it so crystals can't be destroyed by the player that owns them,
which doesn't seem fun. Also gets rid of the "repeal this rule once someone
wins" part since we can just do that by proposal if we want. I'd rather it
stay around by default.]

Amend Rule 2685 (Crystals) by replacing

{
A crystal is an asset with secured integer switches identity, size
      (default 0), and instability (default 0).
}

with

{
A crystal is an indestructible asset with secured integer switches
identity, size
      (default 0), and instability (default 0).
}

and by replacing

{
      Any player CAN, by announcement, Shatter the System, specifying
      each crystallized player, and provided that no player has done so
      in the past 30 days. When a player does so, each crystallized
      player wins the game.

      If at least 4 days have passed since any player won the game in
      this manner, any player CAN repeal this rule by announcement.
}

with

{
      Any player CAN, by announcement, Shatter the System, specifying
      at least 1 crystallized player, and provided that no person has done
so
      in the past 30 days. When a player does so, each crystallized
      player wins the game.

      If a player won the game in this manner 4 days ago, then all existing
      crystals are destroyed.
}"""
            )
        }

        proposal(9078) {
            title("Empire fixes")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend the Rule entitled "Agora of Empires" by, as a single amendment
(using the following steps, as if they were applied in order, to compute
the final text):

* Replacing the text "There exists a document known as the Empireworld"
with "There exists a document, initially empty, known as the Empireworld".

* Replacing each instance of the text "CfJ" with the text "CFJ".

* Replacing the text "when ey believe it to be appropriate" with "when
they believe it to be appropriate". [The antecedent is "Imperials",
which is plural.]

* Replacing the final paragraph with the following:

{

An Imperial CAN, without 2 objections, Dominate the World provided that
(1) the Empireworld shows that e has accomplished at least 3
extraordinary feats in the fictional world that the Empireworld
describes since e last won the game as a result of this Rule and that
(2) no person has won the game as a result of this Rule in the past 30
days. When a player Dominates the World, e wins the game.

This Rule does not describe what qualifies as an extraordinary feat.

}


Set the Empireworld to what it would be had it been empty initially
after the enactment of the Rule entitled "Agora of Empires".


[Fixes the uninitialized state, fixes minor grammar issues, does the
standard win indirection, and removes the double "by announcement" and
"without 2 objections" method for winning (which *shouldn't* allow by
announcement wins by precedent, but should be fixed in any case).]"""
            )
        }

        proposal(9079) {
            title("Spendies v1.1")
            ai("2.0")
            author(nix)
            coauthors(Janet, kiako)
            ordinary()

            text(
                """
[Spendies are simple. We all start with the same amount every month,
and if you don't use them you lose them. You can transfer them, put
them in contracts, etc. But they will go away. What's important is what
you do with them in that month.]

Enact a new (Power=1) rule titled Spendies with the text:

    Spendies are a currency ownable by players and contracts. Spendies
    are tracked by the Spendor in eir weekly report.

    At the end of each month, all Spendies are destroyed. At the
    beginning of each month, every player is granted 20 Spendies.

[Quick compatibility with another proposal]

If a proposal titled "FUNgibility" and authored by nix has been adopted
within the last 90 days, amend the rule titled "Spendies" to replace
"currency" with "fungible liquid asset".

[Delete dream of wandering.]

Repeal R2675 (Dream of Wandering).

[Below stones are simplified, similarly to the stamp specialization
proposal I made previously. You simply buy them for a cost that
decreases every month while the stone has the same owner.]

Amend R2640 (Stones) by replacing:

    A stone is a unique indestructible liquid asset

with:

    A stone is a unique indestructible fixed asset

and deleting its last two paragraphs.

Amend R2641 (Wielding Stones) by replacing:

    While a stone is hot, it is IMPOSSIBLE to wield it or to transfer it
    by announcement.

with:

    While a stone is hot, it is IMPOSSIBLE to wield it.

Retitle R2642 (Gathering Stones) to "Stone Cost" and then amend R2642 to
read in full:

    Stone Cost is a Stone switch with values of non-negative integers
    and a default of 10. Stone Cost is tracked by the Stonemason.

    Any player CAN pay a fee of X Spendies to transfer a specified stone
    to emself, where X is the current Stone Cost of the specified stone.

    When a stone is transferred, its Stone Cost is set to the default.
    At the beginning of every week, the Stone Cost for each stone is
    reduced by 1, to a minimum of 0.

Repeal R2642 (Gathering Stones).

[Similarly, let's include stamps. Remember Dreams are gone, so this is
now the primary way to get new stamps. Use Spendies to get stamps from
L&FD, or mint more of your own. There's some modifications to the cost
to account for scale, which also discourages timing scams somewhat.]

Amend R2659 (Stamps) by appending the following paragraphs:

    Any player CAN pay a fee of 5 Spendies to grant emself X stamps of
    eir own type. When less than 8 Stamps of eir type exist, X is 2.
    When 8 to 15 Stamps of eir type exist, X is 1. When 16 or more
    stamps of eir type exist, X is 0.

    Any player CAN pay a fee of 5 + (X) Spendies to transfer a
    specified stamp from the L&FD to emself. X is equal to the number of
    times e has already done so in the current month.

[Finally, you can buy some radiance, tho the cost is fairly high. Might
push you across the finish line tho, or at least give a use for some
spare Spendies.]

Amend R2656 (Radiance) by appending the following paragraph:

    Any player CAN increase eir radiance by 1 by paying a fee of 2
    Spendies."""
            )
        }

        proposal(9080) {
            title("One from the archives")
            ai("1.0")
            author(Gaelan)
            coauthors(Kate)
            ordinary()

            text(
                """
Re-enact rule 417, with the following text: {
The Archivist is an office; its holder is responsible for ensuring
the continued availability of documents of historical interest.

The archivist’s monthly report contains:
  * Instructions for accessing collections of:
    * Texts of each historic rule revision.
    * Texts of each proposal.
    * Judicial cases.
    * Public messages.
    * Messages to discussion fora.
    * Theses for which a person was awarded a degree.
    * Optionally, any other documents the Archivist deems worthy
      of archival.
  * A description of the completeness of each of the above
    collections.

The referenced collections NEED NOT be perfectly complete or
accurate, but the Archivist SHOULD work towards improving
their completeness and accuracy.
}

Re-title rule 417 to “The Archivist”.

Amend Rule 2581 by appending the following item to the list: {
- Archaeologist, awardable by the Archivist to any player who
  makes a significant contribution to filling in missing
  historical records.
}

Make Gaelan the Archivist.

[History for the Rulekeepor’s benefit, copied from Zefram’s rule
archive:
??? by Proposal 417 [presumably enacted - Gaelan]
Amended(1) by Proposal 1302, 4 November 1994
Amended(2) by Proposal 1700, 1 September 1995
Amended(3) by Proposal 1735, 15 October 1995
Amended(4) by Proposal 1741, 15 October 1995
Amended(5) by Proposal 2029, 28 November 1995
Infected and Amended(6) by Rule 1454, 23 January 1996
Amended(7) by Proposal 2662, 12 September 1996
Amended(8) by Proposal 2696, 10 October 1996
Null-Amended(9) by Proposal 2710, 12 October 1996
Repealed as Power=1 Rule 417 by Proposal 3787 (Steve), 8 September 1998
]

[This is intentionally written loosely to allow the Archivist to
defer to existing archives - for example that maintained by the
CotC - where appropriate.]"""
            )
        }

        proposal(9081) {
            title("Don't humiliate the recently departed")
            ai("2.0")
            author(Gaelan)
            ordinary()

            text(
                """
Amend rule 2168 ("Extending the Voting Period”) by replacing "despite being
eligible” with "despite being eligible players”."""
            )
        }

        proposal(9082) {
            title("yes, yes, I got the memo")
            ai("1.7")
            author(Gaelan)
            ordinary()

            text(
                """
Amend rule 2478 (“Justice”) by replacing: {
  A player CAN, by announcement, "note" an unforgiven infraction
  committed by any other player in the last 14 days, specifying the
  incident and the rule it violates (or name of the Infraction if
  it has one).
} with {
  A player CAN, by announcement, "note" an unforgiven infraction
  committed by any other player in the last 14 days, specifying the
  incident and the rule it violates (or name of the Infraction if
  it has one); but a player CANNOT note an infraction that has
  already been investigated.
}

[Currently, if an infraction is noted after it is investigated,
the Investigator SHALL but CANNOT investigate it. This would be
automatically forgiven by 2531, so it’s not an issue in practice,
but let’s fix it properly.]"""
            )
        }

        proposal(9083) {
            title("SLR ratification 2023-12-31")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Ratify the Short Logical Ruleset published by Janet on or about December
31, 2023 at 21:12:14 UTC, available at [0].

[0]
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2023-December/017538.html


[I was required to submit such a proposal for Ratify the Ruleset Week
but forgot to. Sorry.]"""
            )
        }

        proposal(9084) {
            title("Oneironauts in the Ocean")
            ai("2.0")
            author(kiako)
            ordinary()

            text(
                """
Amend Rule 2675 ("Dream of Wandering") so that the list of Dreams reads in
its entirety:

{
- Wandering: This dream has no effect.

- Charity: Immediately after a wandering, one stamp (chosen by
most-to-least owned by the L&FD at time of transfer, tie-broken
alphabetically) is transferred to each Charity Dreamer (in order from
least-to-most stamps owned, tie-broken alphabetically) from the L&FD. If
the number of Wealth Dreamers is more than the number of Charity Dreamers,
this process happens a second time. If it is more than twice the number of
Charity Dreamers, this happens a third time.


- Justice: Immediately after a wandering, a number of blots are expunged
from each Justice Dreamer equal to one-half the number of Power Dreamers,
rounded up. If a Justice Dreamer had no blots immediately after a
wandering, e CAN once expunge one blot, by announcement, from a specified
player before the next wandering.


- Sharing: Immediately after a wandering, each Sharing Dreamer has eir
Radiance increased by X/Y, rounded down, where X is the number of
non-Wandering, non-Sharing Dreamers, and Y is the number of Sharing
Dreamers.


- Wealth: Immediately after a wandering, X stamps of eir own type are
granted to each Wealth Dreamer, where X is the minimum of the following:

  - One more than the number of true statements among the following:
    - Fewer than 8 stamps of eir own type exist.
    - There are at least 3 Wealth Dreamers.
    - There are at most 2 Charity Dreamers.

  - 16 minus the number of stamps of eir own type that exist, to a minimum
of 0.


- Gardens: Immediately after a wandering, the Base Rockiness of each
Gardens Dreamer is increased by the number of Gardens Dreamers, and the
Base Rockiness of each non-Gardens Dreamer is decreased by 1 to a minimum
of 0.


- Power: Let Y be the number of Dreamers of the non-Wandering, non-Power
Dream with the most Dreamers. Each Power Dreamer has eir voting strength
increased by X for referenda on ordinary proposals, where X is

  - 1 if Y is at most 2,
  - 2 if Y is between 3 and 5 (inclusive),
  - 3 if Y is between 6 and 9 (inclusive), and
  - 4 if Y is at least 10.

- Revolution: A revolution is happening if the majority of active players
are Revolution Dreamers. Immediately after a wandering, if a revolution is
not happening, then all Revolution Dreamers have eir radiance decreased by
1 to a minimum of 0. Immediately after a wandering, if a revolution is
happening, then all players have eir radiance set to 100-X, where X was eir
radiance when the wandering occurred, and all player's Dreams are set to
Wandering.

}"""
            )
        }

        proposal(9085) {
            title("Fix truthfulness loophole")
            ai("1.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2471, replace
"The author believed the statement to be not true."
with
"The author did not believe the statement to be true."

[Under the existing rules, it's possible to legally make a statement
under penalty of No Faking, when you have no idea whether or not the
statement is true – neither of the existing clauses apply, because you
neither believe it to be not true, nor should have known that it was
false. This makes the "penalty of No Faking" ineffective for one of its
primary purposes, of allowing people to introduce new facts into the
judicial record based on their own personal knowledge.]"""
            )
        }

        proposal(9086) {
            title("Trimming the most useless rule in the ruleset")
            ai("1.0")
            author(RLee)
            ordinary()

            text(
                """
Repeal rule 2683 'The Boulder'"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9073
            FOR on 9074
            FOR on 9075
            FOR on 9076
            FOR on 9077
            FOR on 9078
            FOR on 9079
            FOR on 9080
            FOR on 9081
            AGAINST on 9082
            endorse(Janet) on 9083
            PRESENT on 9084
            endorse(ais523) on 9085
            AGAINST on 9086
        }

        votes(nix) {
            FOR on 9073
            FOR on 9074
            FOR on 9075
            FOR on 9076
            PRESENT on 9077
            PRESENT on 9078
            FOR on 9079
            FOR on 9080
            PRESENT on 9081
            PRESENT on 9082
            FOR on 9083
            FOR on 9084
            FOR on 9085
            PRESENT on 9086
        }

        votes(Gaelan) {
            endorse(Kate) on 9073
            PRESENT on 9074
            endorse(nix) on 9075
            endorse(nix) on 9076
            endorse(snail) on 9077
            endorse(Janet) on 9078
            function { ctx ->
                if (ctx.resolve(ctx.currentProposal, nix)?.finalResolution(ctx)?.voteIfVoted == AGAINST)
                    resolvedConditional(AGAINST, "${nix.name} voted AGAINST")
                else
                    endorse(snail).commented("${nix.name} did not vote AGAINST")
            } on 9079
            FOR on 9080
            FOR on 9081
            PRESENT on 9082
            endorse(Janet) on 9083
            FOR on 9084
            endorse(ais523) on 9085
            resolvedConditional(AGAINST, "The Boulder is not at 0 or 1.") on 9086
        }

        votes(kiako) {
            endorse(Janet) on 9074 comment "${Janet.name} is the Rulekeepor"
            endorse(nix) on 9079
            endorse(Janet) on 9081 comment "${Janet.name} is the Assessor"
            AGAINST on 9082
            endorse(Janet) on 9083 comment "${Janet.name} is the Rulekeepor"
            AGAINST on 9086
            FOR on others
        }

        votes(RLee) {
            AGAINST on 9073
            AGAINST on 9074
            AGAINST on 9075
            FOR on 9076
            FOR on 9077
            PRESENT on 9078
            FOR on 9079
            AGAINST on 9080
            AGAINST on 9081
            FOR on 9082
            PRESENT on 9083
            AGAINST on 9084
            FOR on 9085
            FOR on 9086
        }

        votes(juan) {
            FOR on 9073
            endorse(snail) on 9074
            FOR on 9075
            FOR on 9076
            FOR on 9077
            FOR on 9078
            FOR on 9079
            FOR on 9080
            FOR on 9081
            PRESENT on 9082
            FOR on 9083
            PRESENT on 9084
            PRESENT on 9085
            AGAINST on 9086
        }

        votes(Janet) {
            FOR on 9073
            FOR on 9074
            FOR on 9075
            FOR on 9076
            PRESENT on 9077
            FOR on 9078
            FOR on 9079
            FOR on 9080
            PRESENT on 9081
            FOR on 9082
            PRESENT on 9083
            AGAINST on 9084
            FOR on 9085
            endorse(ais523) on 9086
        }

        votes(ais523) {
            FOR on 9073
            AGAINST on 9074
            FOR on 9075
            resolvedConditional(FOR, "${ais523.name} was not endorsed") on 9076
            PRESENT on 9077
            FOR on 9078
            FOR on 9079
            FOR on 9080
            FOR on 9081
            FOR on 9082
            FOR on 9083
            PRESENT on 9084
            FOR on 9085
            AGAINST on 9086
        }

        votes(Murphy) {
            FOR on 9073
            endorse(Janet) on 9074 comment "${Janet.name} is the Rulekeepor"
            FOR on 9075
            PRESENT on 9076
            endorse(RLee) on 9077 comment "${RLee.name} is the Geologist"
            FOR on 9078
            FOR on 9079
            FOR on 9080
            FOR on 9081
            FOR on 9082
            FOR on 9083
            endorse(snail) on 9084 comment "${snail.name} is the Dream Keeper"
            FOR on 9085
            AGAINST on 9086
        }
    }
}
