package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.lib.vote.InextricableResolvingVote
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9202to9210() = assessment {
    name("9202-9210")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(1) heldBy juan
                "ADoP"(2) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy null
                "Herald"(2) heldBy null
                "Illuminator"(1) heldBy Mischief
                "Notary"(2) heldBy null
                "Prime Minister"(0) heldBy Mischief
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy null
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9202) {
            title("Track Assets")
            ai("1.0")
            author(Murphy)
            ordinary()

            text(
                """
Amend Rule 2692 (Bang!) by replacing "Bangs are a fungible asset." with
"Bangs are an untracked fungible asset."

Retitle Rule 2603 (Switch Responsibility) to "Default Recordkeepors",
and amend it by replacing "switch" with "switch or asset".

[Unchanged from proto. Encourages assets intended to be untracked to be
  explicitly labeled as such, otherwise materializes an officer, both in
  the same fashion as switches.]"""
            )
        }

        proposal(9203) {
            title("A clarification")
            ai("2.0")
            author(Janet)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 991 ("Calls for Judgement") by appending the following to the
first paragraph: "A case so initiated is an inquiry case."

["inquiry case" is a historical term used for a CFJ on the truth of a
statement. It has a few remaining uses in the rules. Defining it here
removes any ambiguity and helps answer a question that has been asked
multiple times by newer players. This is careful to not redefine "CFJ"
itself, which might affect past CFJs.]"""
            )
        }

        proposal(9204) {
            title("Rare stamps, more differently")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2701 ("Stamp Scamp") to read, in whole:

{

A rare stamp is a stamp that is the only one of its type that exists.

Stamp scamp is a singleton switch tracked by the Collector with possible
values of each player and null (default). Upon a correct announcement
that a specified player owns more rare stamps than any other player, the
stamp scamp switch is flipped to that player.

If no person has done so by this mechanism in this quarter, the value of
the stamp scamp switch, if a player, CAN by announcement cause another
specified player to gain one stamp of that player's type.

}

If exactly one player holds the patent title of Stamp Scamp, the stamp
scamp switch is hereby flipped to that player.

The patent title "Stamp Scamp" is hereby revoked from each player that
holds it.

[Switches are the standard way to track state like this. We shouldn't
use a patent title for this. The current Herald is not actually
reporting, so it will not actually be tracked; the Herald's report
should be used for historical matters, not (new) ephemera; and it will
hand out violet ribbons for very little reason.]"""
            )
        }

        proposal(9205) {
            title("Switch It Up")
            ai("3.0")
            author(Mischief)
            coauthors(Janet)
            democratic()

            text(
                """
[This explicitly allow contracts to define switches. They maybe work
okay anyway, but this puts things on a firmer foundation. The "secured"
definition is deliberately left referencing Rules only, as a contract
doesn't have power.

I considered amending the third paragraph of rule 2698 (Recordkeepors),
but contracts have plenty of flexibility to impose any desired reporting
requirements for their switches (or to leave them untracked).]

Amend rule 2162 (Switches) by making the following replacements, in order:

1) Replace:

       A type of switch is a property that the rules define as a switch,
       and specify the following:

    with:

       A type of switch is a property that a rule or a contract defines
       as a switch (with such rule or contract being its backing
       document) and specifies the following:

2) Replace:

       If a type of switch is not explicitly designated as
       possibly-indeterminate by the rule that defines it, and if an
       action or set of actions would cause the value of an instance of
       that type of switch to become indeterminate, that instance instead
       takes on its last determinate and possible value, if any,
       otherwise it takes on its default value.

    with:

       If a type of switch is not explicitly designated as
       possibly-indeterminate by its backing document, and if an action
       or set of actions would cause the value of an instance of that
       type of switch to become indeterminate, that instance instead
       takes on its last determinate and possible value, if any,
       otherwise it takes on its default value."""
            )
        }

        proposal(9206) {
            title("Let Contracts Own Stamps")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
Amend rule 2659 (Stamps) by replacing:

       Stamps are a category of asset ownable by players.

with:

       Stamps are a category of asset ownable by players and contracts."""
            )
        }

        proposal(9207) {
            title("(n/a)")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
{Any report that contains this text contains no game actions, disclaimers
and text to the contrary notwithstanding.}"""
            )
        }

        proposal(9208) {
            title("Destroy the Office")
            ai("1.0")
            author(Forest)
            democratic()

            text(
                """
Amend Crystals (Rule 2685) by replacing:
"The Geologist is a sortitioned office that tracks crystals."
with:
"Crystals are untracked."
and replacing:
"Once a quarter, the Geologist CAN (and SHALL during its first
      Eastman week) publish a Notice of Crystal Growth, upon which each
      crystal whose identity is not equal to the ID of any rule in the
      current ruleset has its size increased by 3."
with:
"At the beginning of each quarter, all crystals whose identity is not equal
to the ID of any rule in the current ruleset has its size increased by 3."

If this proposal is democratic, repeal Crystals (Rule 2685)."""
            )
        }

        proposal(9209) {
            title("Goblins?")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Yes."""
            )
        }

        proposal(9210) {
            title("Gnomes?")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Yes."""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9202
            FOR on 9203
            FOR on 9204
            FOR on 9205
            PRESENT on 9206
            AGAINST on 9207
            AGAINST on 9208
            AGAINST on 9209
            AGAINST on 9210
        }

        votes(Mischief) {
            FOR on 9202
            FOR on 9203
            FOR on 9204
            FOR on 9205
            FOR on 9206
            AGAINST on 9207
            FOR on 9208
            FOR on 9209
            FOR on 9210
        }

        votes(Kate) {
            FOR on 9202
            FOR on 9203
            AGAINST on 9204
            FOR on 9205
            FOR on 9206
            AGAINST on 9207
            FOR on 9208
            AGAINST on 9209
            AGAINST on 9210
        }

        votes(ais523) {
            FOR on 9202
            FOR on 9203
            AGAINST on 9204
            PRESENT on 9205
            FOR on 9206
            AGAINST on 9207
            FOR on 9208
            AGAINST on 9209
            AGAINST on 9210
        }

        votes(Janet) {
            FOR on 9202
            FOR on 9203
            FOR on 9204
            endorse(ais523) on 9205
            AGAINST on 9206
            AGAINST on 9207
            FOR on 9208
            AGAINST on 9209
            AGAINST on 9210
        }

        votes(sprock) {
            PRESENT on 9202
            FOR on 9203
            PRESENT on 9204
            FOR on 9205
            FOR on 9206
            AGAINST on 9207
            PRESENT on 9208
            PRESENT on 9209
            PRESENT on 9210
        }

        votes(Murphy) {
            FOR on 9202
            FOR on 9203
            endorse(Mischief) on 9204 comment "${Mischief.name} is the Collector"
            FOR on 9205
            FOR on 9206
            AGAINST on 9207
            InextricableResolvingVote on 9208 comment "Geologist is vacant"
            FOR on 9209
            FOR on 9210
        }
    }
}
