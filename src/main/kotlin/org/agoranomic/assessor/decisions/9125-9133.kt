package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.resolvedConditional
import org.agoranomic.assessor.lib.vote.InextricableResolvingVote
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9125to9133() = assessment {
    name("9125-9133")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy nix
                "Archivist"(1) heldBy Gaelan
                "Assessor"(3) heldBy Janet
                "Collector"(2) heldBy null
                "Distributor"(0) heldBy omd
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Jimmy
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy Jaff
                "Spendor"(1) heldBy nix
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9125) {
            title("(n/a)")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Reenact UNDEFINED"""
            )
        }

        proposal(9126) {
            title("More Stone Cleanup")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
[Removes a remaining reference to Smoothness and eliminates the Loud Stone.]

Amend rule 2645 (The Stones) by deleting ", Smoothness" and by deleting:

       - Loud Stone (monthly): When wielded, a specified player's
         Dream is set to a specified Dream, and then e is Beguiled;
         Beguiling is secured. A player's Dream CANNOT be flipped if e
         was Beguiled in the last 7 days, rules to the contrary
         notwithstanding."""
            )
        }

        proposal(9127) {
            title("There Aren't Many Stone Idioms in English")
            ai("2.0")
            author(Mischief)
            ordinary()

            text(
                """
[This gives us an easy way to refer to when the Stone sub-game last got
reset. This isn't proposing an immediate use for it, but it provides
something for future stone definitions to build off of.]

Amend rule 2644 (Zen Gardening) by replacing "all existing stones are
transferred to Agora" with "Agora Gets Stoned and all existing stones are
transferred to Agora""""
            )
        }

        proposal(9128) {
            title("Stone cost reset v2")
            ai("2.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2644 by replacing the text "all existing stones are
transferred to Agora." with the text "all existing stones are
transferred to Agora, after which the Stone Cost of each stone is set to
its default value.".

For each stone with Stone Cost less than 10, set the Stone Cost of that
stone to 10. [Reset after snail's win.]"""
            )
        }

        proposal(9129) {
            title("Amendments are hard, okay?")
            ai("1.0")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 1681 ("The Logical Rulesets") by replacing "the rule's ID
numberpower, title, and text" with "the rule's ID number, power, title,
and text".

[Accidentally introduced in a previous proposal.]"""
            )
        }

        proposal(9130) {
            title("Revision numbers, revised")
            ai("1.0")
            author(Janet)
            coauthors(Gaelan)
            ordinary()

            text(
                """
Amend Rule 1681 ("The Logical Rulesets") by replacing the paragraph
containing "the rule's revision number" with the following paragraph:

{

The listing of each rule in the SLR must additionally include a revision
number selected by the Rulekeepor. The Rulekeepor SHOULD select revision
numbers such that they can be used retrospectively to determine that the
text of a rule has changed while it maintained the same ID number. The
Rulekeepor may exercise reasonable discretion in calculating revision
numbers.

}"""
            )
        }

        proposal(9131) {
            title("Rare Stamps")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[The idea: create some differences in value among stamp types, open up some
possibilities for deals (what if someone owns the second to last copy of a
stamp?), encourage uncommon stamps to circulate, and try to discourage
large numbers of stamp types sticking around forever. If a player only has
a few rare stamps, when converting them to Radiance it's possible e will be
better off combining them with non-rare stamps via the existing redemption
mechanism. Also, stamps are destructible, so if someone only wants to
receive 1 stamp instead of 2 under the "pay 5 Spendies" mechanism e can
simply destroy one of them.]

Amend rule 2659 ("Stamps") by inserting after:

       Any player CAN, once per week, pay X Stamps, where each specified
       Stamp is a different type, to gain (X^2)-X radiance.

the paragraph:

       Any player CAN, once per week, pay X rare Stamps, where each
       specified Stamp is a different type, to gain (X^2)+X-2 radiance. A
       rare Stamp is a Stamp where exactly one of its type exists."""
            )
        }

        proposal(9132) {
            title("Fashionable Manners")
            ai("3.0")
            author(Mischief)
            coauthors(Janet)
            democratic()

            text(
                """
[Rules use both "timely manner" and "timely fashion" but rule 1023 (Agoran
Time) only defines the latter.]

Amend the following rules, in the order listed, by replacing every instance
of "timely manner" with "timely fashion":

Rule 103 (The Speaker)
Rule 2478 (Justice)
Rule 2585 (Birthday Gifts)
Rule 2679 (Restrictions on Participation)
Rule 2691 (Sortition Procedure)"""
            )
        }

        proposal(9133) {
            title("Last from the Past")
            ai("3.0")
            author(snail)
            democratic()

            text(
                """
[Makes it so the rules only use "Past X Days" instead of "Last X days", the
split was about even with a bit more "Past"s.]

Amend the following rules, in the order listed, by replacing every instance
of "last" with "past":

{

Rule 2625 (Proposal Recycling)
Rule 2630 (The Administrative State)
Rule 2689 (Vacations & Delegation)
Rule 2143 (Official Reports and Duties)
Rule 2478 (Justice)
Rule 2676 (Forgiveness)

}

Amend Rule 2499 (Welcome Packages) by replacing "last 30 days" with "past
30 days".

Amend Rule 2645 (The Stones) by replacing "last 15 days" with "past 15
days".

Amend Rule 2645 (The Stones) by replacing "last 7 days" with "past 7 days"."""
            )
        }
    }

    voting {
        votes(snail) {
            AGAINST on 9125
            FOR on 9126
            AGAINST on 9127
            FOR on 9128
            FOR on 9129
            FOR on 9130
            AGAINST on 9131
            FOR on 9132
            FOR on 9133
        }

        votes(juan) {
            AGAINST on 9125
            PRESENT on 9126
            PRESENT on 9127
            PRESENT on 9128
            FOR on 9129
            FOR on 9130
            PRESENT on 9131
            FOR on 9132
            FOR on 9133
        }

        votes(Janet) {
            AGAINST on 9125
            FOR on 9126
            AGAINST on 9127
            FOR on 9128
            FOR on 9129
            FOR on 9130
            AGAINST on 9131
            FOR on 9132
            PRESENT on 9133
        }

        votes(Mischief) {
            AGAINST on 9125
            FOR on 9126
            FOR on 9127
            FOR on 9128
            FOR on 9129
            FOR on 9130
            FOR on 9131
            FOR on 9132
            endorse(Janet) on 9133 comment "${Janet.name} is the Rulekeepor"
        }

        votes(Quadrantal) {
            endorse(Janet) on 9125 comment "${Janet.name} is the Rulekeepor"
            endorse(Janet) on 9126 comment "${Janet.name} is the Stonemason"
            AGAINST on 9127
            FOR on 9128
            FOR on 9129
            FOR on 9130
            PRESENT on 9131
            FOR on 9132
            AGAINST on 9133
        }

        votes(Murphy) {
            AGAINST on 9125
            endorse(Janet) on 9126 comment "${Janet.name} is the Stonemason"
            FOR on 9127
            endorse(Janet) on 9128 comment "${Janet.name} is the Stonemason"
            FOR on 9129
            FOR on 9130
            resolvedConditional(InextricableResolvingVote, "Collector is vacant") on 9131
            FOR on 9132
            FOR on 9133
        }
    }
}
