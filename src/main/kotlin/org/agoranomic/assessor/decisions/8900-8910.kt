package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.InextricableResolvingVote
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8900to8910() = assessment {
    name("8900-8910")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Forest, 2)
            powerDream(G, 2)

            complexityBonuses {
                maxBonus(3)

                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy G
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy nix
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy nix
                "Horsened"(1) heldBy snail
                "Mad Engineer"(1) heldBy Janet
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy Forest
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Murphy
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy Forest
            }
        }
    }

    proposals(v4) {
        proposal(8900) {
            title("Increased collection")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2643 ("Collecting Stones") by replacing the final paragraph
with the following:

{

When a Collection Notice is published, for each player, half (rounded
up) of eir non-immune stones with slipperiness not less than the Escape
Minimum are transferred to Agora. A Collection Notice includes
selections of which eligible stones escape (which shall prevail in
determining which stones are transferred). the mossiness of each stone
that is not transferred is incremented by 1.

}


[Removes the possibility of transferring stones to a single person to
ensure only one can possible escape.]"""
            )
        }

        proposal(8901) {
            title("Clarify deputisation")
            ai("3.0")
            author(Murphy)
            democratic()

            text(
                """
Amend Rule 2160 (Deputisation) to read:

       A player acting as emself (the deputy) CAN perform an action
       ordinarily reserved for an office-holder as if e held the office
       if all of the following are true:

         1) The rules require the holder of that office, by virtue of
            holding that office, to perform the action. (This requirement
            is fulfilled by the deputy performing the action.)

         2) It would be POSSIBLE for the deputy to perform the action,
            other than by deputisation, if e held the office.

         3) The deputy, when performing the action, announces that e is
            doing so by deputisation or by temporary deputisation.

         4) The deputy has not held the office in the past 7 days.

      (If the office is vacant, then the remaining items in this list
      need not be true.)

         5) A time limit by which the rules require the action to be
            performed has expired.

         6) The office's holder has not changed in the past 7 days.

         7) Any of the following are true:

              a) The deputy announced between 2 and 14 days earlier that
                 e intended to deputise for that office for the purposes
                 of the particular action.

              b) The time limit expired between 14 and 28 days ago.

              c) The time limit expired more than 28 days ago, and the
                 deputisation is temporary.

       When a player deputises for an elected office, e becomes the
       holder of that office, unless the deputisation is temporary,
       and/or the action being performed would already install someone
       into that office."""
            )
        }

        proposal(8902) {
            title("More ribbon security")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2438 ("Ribbons") by appending the following paragraph:

{

Qualifying for ribbons is secured. Earning ribbons is secured.

}


[This does not affect black ribbons, which have an explicit opt-out.]"""
            )
        }

        proposal(8903) {
            title("Effective forgiveness")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2679 ("Restrictions on Participation") by replacing "any
unwelcome player may submit a Request for Forgiveness" with "any
unwelcome person may submit a Request for Forgiveness".

[Unwelcome persons cannot be players.]"""
            )
        }

        proposal(8904) {
            title("Nothing to see here")
            ai("3.14")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2468 ("The Royal Parade") by replacing "Jason" with "Janet"."""
            )
        }

        proposal(8905) {
            title("Restricted voting strength")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2422 ("Voting Strength") by replacing "between 0 and 15" with
"between 0 and 9".

[Compromise? Still higher than the cap of 5 before ministries.]"""
            )
        }

        proposal(8906) {
            title("Stone Immunity Correction (Keeping Our Stones) Act")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
[Restore the definition of immunity, and add security to it.]

Amend Rule 2643 ("Collecting Stones") by prepending the following paragraph:

{

A stone is immune if and only if it is defined as such by the rules of
power not less than 2.

A stone is immune if it is owned by Agora. A stone is immune if it has
been granted immunity since the last collection notice. The granting of
immunity is secured.

}


[Explicitly prohibit the Soul Stone from transferring stones owned by
Agora. This isn't technically needed with the previous change, but it's
better to just make it explicit to prevent accidentally it breaking
again in the future.]

Amend Rule 2645 ("The Stones") by replacing "When wielded, the Soul
Stone is transferred to the owner of a different specified non-immune
stone, then that stone is transferred to the wielder." with "When
wielded, the Soul Stone is transferred to the owner of a different
specified non-immune stone not owned by Agora, then that stone is
transferred to the wielder.".


[Disallow theft of Protected stones, and add a tiebreak.]

Amend Rule 2645 ("The Stones") by replacing the list item beginning
"Anti-Equatorial" with the following

{

- Anti-Equatorial Stone (Monthly, 5): When wielded, the mossiest
non-immune stone is transferred to the wielder. If more than one such
stone is tied for mossiest, a specified one is transferred. When this
happens, the Anti-Equatorial Stone's mossiness is incremented by 1.

}"""
            )
        }

        proposal(8907) {
            title("Maybe a little less hot?")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
[Remove the Hot Potato stone's prohibition on collection (collection is
not transfer by a player).]

Amend Rule 2645 ("The Stones") by replacing "If this stone is not owned
by Agora, it cannot otherwise be transferred, other rules
notwithstanding." with "If this stone is not owned by Agora, a player
CANNOT otherwise transfer it, rules to the contrary notwithstanding.".


[Ensure that no accidental prohibition on collection can happen again.]

Amend Rule 2643 ("Collecting Stones") by replacing "is transferred to
Agora" with "is transferred to Agora, rules to the contrary
notwithstanding"."""
            )
        }

        proposal(8908) {
            title("The Crystal")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
I have yearned for the days of Clork, putting things into knip,
and all of the nonsense that once existed as part of Nomic,
or general self-referential, rule-changing games.
ALAS, this nonsense caused instability in the very foundations of Agora,
AND it was grand.

AND SO, I seek to shaketh the foundations upon which we lie,
upending the system of power and thusly encourage legislative play.

THUSLY, enact a rule entitled "The Crystal" with power=1.0 and the text:
{
The Geologist is the office that tracks crystals.
Each crystal is a liquid asset.
Each crystal has two secured natural integer switches,
one of which is the size, and the other is its identity.
The default size of a crystal is 1.
Each Quarter, the size is reduced by 1 of all crystals with
identifiers that match any rule number in the current ruleset.

Whenever a proposal amends or repeals a rule:
- If a crystal with an identity equal to the number of that rule exists,
  transfer it to the author of the proposal, and increase its size by 1.
- Otherwise, grant the author of the proposal a crystal with the identity
  equal to the number of that rule.

A player CAN, by announcement, Shatter the System, specifying one or more
crystallized entities, provided that no entity has won the game by doing so
in the past 30 days. An entity is crystallized if it owns crystals with a
total
size greater than or equal to the number of rules in the current ruleset.

When the System is Shattered, the specified entities win the game. If an
entity
won the game in this manner 4 or more days ago, any player CAN repeal this
rule
by announcement.
}"""
            )
        }

        proposal(8909) {
            title("Simplify the report report")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2138 (The Associate Director of Personnel) by replacing
item 4 and all text after it with this text:

       4. For offices with a weekly and/or monthly report, the date (if
          any) that each was most recently published.

[The existing items were added by Proposal 8679 last May, possibly at my
  suggestion; but I never got around to updating the ADoP automation to
  implement them, and no one seemed to notice. The proposed new item
  matches current practice, and is also useful for new officeholders
  attempting to catch up on relevant changes since the last report.]

  The rest of Proposal 8679 amended other rules defining Warnings and
  Tardiness.)"""
            )
        }

        proposal(8910) {
            title("Better Charity")
            ai("2.0")
            author(snail)
            coauthors(nix)
            ordinary()

            text(
                """
Amend R2675 ("Dream of Wandering") by replacing:

       - Charity: The Charity Item is the item type that the L&FD owns
         the most of (if there is a tie, the first the L&FD owned, and if
         still tied, the first alphabetically). Immediately after a
         wandering, for each Charity Dreamer, in reverse order of when
         eir Dream was last flipped (and in reverse order of registration
         if tied), one item of the Charity type is transferred from the
         L&FD to em.

with:

       - Charity: A Charity Stamp is a stamp of the type that the L&FD
         owns the most of (if there is a tie, the first the L&FD owned,
         and if still tied, the first alphabetically). Immediately after
         a wandering, for each Charity Dreamer, in reverse order of when
         eir Dream was last flipped (and in reverse order of registration
         if tied), one Charity Stamp is transferred from the L&FD to em.
         If the number of Stamps the L&FD owned during the last
         wandering is greater than 10, this process happens a second
         time. If it is more than 20, this process happens a third time.


[Simpler than the last proposal because it doesn't require knowing the
number of active players, and it also clarifies the number to be looked at
is the stamps owned during the wandering, not after the first set of
transfers.]"""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 8900
            FOR on 8901
            FOR on 8902
            FOR on 8903
            FOR on 8904
            AGAINST on 8905
            FOR on 8906
            FOR on 8907
            endorse(Janet) on 8908
            FOR on 8909
            FOR on 8910
        }

        votes(Forest) {
            endorse(nix) on 8900
            endorse(ais523) on 8901
            endorse(Murphy) on 8902
            InextricableResolvingVote on 8903 comment "Endorsement of self"
            endorse(Janet) on 8904
            endorse(juan) on 8905
            endorse(snail) on 8906
            endorse(RLee) on 8907
            AGAINST on 8908
            endorse(Aspen) on 8909
            endorse(G) on 8910
        }

        votes(Murphy) {
            PRESENT on 8900
            FOR on 8901
            FOR on 8902
            FOR on 8903
            FOR on 8904
            PRESENT on 8905
            PRESENT on 8906
            PRESENT on 8907
            FOR on 8908
            FOR on 8909
            PRESENT on 8910
        }

        votes(juan) {
            PRESENT on 8900
            PRESENT on 8901
            PRESENT on 8902
            FOR on 8903
            FOR on 8904
            FOR on 8905
            PRESENT on 8906
            PRESENT on 8907
            FOR on 8908
            PRESENT on 8909
            PRESENT on 8910
        }
    }
}
