package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals

@UseAssessment
fun assessment9261to9269() = assessment {
    name("9261-9269")
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
                "Archivist"(1) heldBy kiako
                "Assessor"(3) heldBy Janet
                "Collar"(1) heldBy Mischief
                "Collector"(2) heldBy Mischief
                "Distributor"(0) heldBy omd
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy null
                "Land Managor"(1) heldBy Murphy
                "Notary"(2) heldBy null
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy Cosmo
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy kiako
                "Spendor"(1) heldBy Murphy
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy kiako
            }
        }
    }

    proposals(v4) {
        proposal(9261) {
            title("Further win indirection")
            ai("1.5")
            author(Janet)
            ordinary()

            text(
                """
Amend Rule 2656 ("Radiance") by, as a single amendment (failing as a
whole if any step fails), in order:

* Replacing ", e wins the game" with. ", e Outshines the Sun.".

* Deleting the text after (but not including) "Outshines the Sun."
through the end of the paragraph containing that text.

* Inserting the following paragraph after the paragraph beginning "Upon
a correct announcement":

{

When a player Outshines the Sun, e wins the game. When a player wins the
game this way, the following happen in order:

* Eir radiance is set to 0.

* The radiance of each other player is set to half its current value
(rounded down).

}

[Follow the convention of having a separate action for winning and
ensure that radiance does not reset if the win is prevented (e.g. due to
blots).]


Amend Rule 2659 ("Stamps") by as a single amendment (failing as a whole
if any step fails), in order:

* Replacing "Any active player CAN win" with "Any active player CAN
Profligately Pursue Philately".

* Appending to the paragraph beginning "Any active player CAN
Profligately" the following text: " When e does so, e wins the game.".

[Similarly follow the convention here. This is less necessary, but we've
tried to avoid having winning itself be fee-based on in the past.]"""
            )
        }

        proposal(9262) {
            title("Land epochs")
            ai("1.0")
            author(Janet)
            coauthors(ais523)
            ordinary()

            text(
                """
Amend Rule 2709 ("The Growth Cycle") by replacing the paragraph
beginning "At the end of each Crop Season" with the following paragraphs:

{

When the Fields Wither, all unharvested Crops are lost. For the
avoidance of doubt, the previous paragraph notwithstanding, a player
CANNOT harvest a Crop planted before the most recent time the Fields
Withered.

At the end of each Crop Season, the Fields Wither.

}



Enact a new Rule at power 1 entitled "Light Overexposure" with the
following text:

{ 

When a player wins the game as a result of a correct announcement from a
player that eir radiance is 100 or more (correctly specifying the
amount), the following happen in order:

* All Pyrite is destroyed.

* The Fields Wither.

* All Hectares are destroyed.

* Each player is granted 16 Hectares.

}


If a proposal entitled "Further win indirection" submitted in the 24 hours
before this proposal was submitted has been adopted, amend the Rule just
enacted by  replacing "When a player wins the game as a result of a
correct announcement from a player that eir radiance is 100 or more
(correctly specifying the amount)" with "When a player wins the game as
a result of Outshining the Sun"."""
            )
        }

        proposal(9263) {
            title("Truly Indestructible? v2")
            ai("1.0")
            author(Forest)
            ordinary()

            text(
                """
Amend Rule 2695 "The Veblen" by removing
the text (if it exists):
{
If the Veblen does not exist, any player CAN,
by announcement, Become All Powerful. When e
does so, e wins the game, and the Veblen is
created in eir possession. A player who wins
in this fashion SHOULD submit a proposal to
prevent the destruction from arising again.
}

Amend Rule 2695 "The Veblen" by appending:
{
If the Veblen does not exist and no one has Created
Something E Cannot Destroy in the past week, any
player CAN, by announcement, Create Something E
Cannot Destroy. When e does so, e wins the game,
and the Veblen is created in eir possession. A player
who wins in this fashion SHOULD submit a proposal
to prevent the destruction from arising again.
}"""
            )
        }

        proposal(9264) {
            title("Unique assets")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2576 ("Ownership") by appending the following paragraph:

{

When an asset's backing document defines a "unique" asset and such asset
does not exist, it is immediately created and deemed to be in abeyance,
subject to modification by its backing document.

}


[We currently use this terminology for the Veblen, and we've used the
terminology in the past for stones, so it's probably best to just
explicitly state what it means.]"""
            )
        }

        proposal(9265) {
            title("Somewhat broader decision security")
            ai("3.0")
            author(Janet)
            coauthors(ais523, Forest)
            democratic()

            text(
                """
Amend Rule 107 ("Initiating Agoran Decisions') by replacing the
paragraph beginning "The destruction of an Agoran decision" with the
following paragraph:

{

The destruction of Agoran decisions is secured. An Agoran decision's
matter to be decided, voting method, valid options, and vote collector
are secured at the power of the Rule authorizing the initiation of such
a decision.

}


["Causing an Agoran decision to cease to being an Agoran decision" is
probably a fancy way of destroying it (since no rule would define it)
and thus does not need to be handled separately. (We have no other
clause like this in the rules.) We should, however, secure the other
attributes defined in this rule. (The voting period is secured earlier
in the rule.)]"""
            )
        }

        proposal(9266) {
            title("Repeal Candles")
            ai("1.5")
            author(Mischief)
            ordinary()

            text(
                """
Repeal rule 2700 (Candles)

[The mechanism didn't get the broad use I'd hoped for, and recent
sub-game development -- e.g., Agoriculture -- bypassed it entirely.]"""
            )
        }

        proposal(9267) {
            title("Plague!")
            ai("1.0")
            author(Forest)
            coauthors(kiako, Janet, ais523, snail, oliver)
            ordinary()

            text(
                """
Remove all crop types."""
            )
        }

        proposal(9268) {
            title("Stealing the moon")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Repeal Rule 2614 ("Eclipse Light").

[Emergency Regulations have seen a total of one use in the past four
years and before that have only been used by a dictatorship. It might be
worth considering a repeal?]"""
            )
        }

        proposal(9269) {
            title("Proposal and Referenda Fixes v2")
            ai("3.0")
            author(Forest)
            coauthors(Janet)
            democratic()

            text(
                """
For each proposal with an unresolved referendum initiated in the past
28 days, 4st becomes a co-author if possible.

Amend Rule 2350 "Proposals" by replacing:
"Once a proposal
is created, its text, author, and AI cannot be changed."
with
"Once a proposal
is created, its text, author, coauthors, and AI cannot be changed.""""
            )
        }
    }

    voting {
    }
}
