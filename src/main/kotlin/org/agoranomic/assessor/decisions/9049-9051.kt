package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.lib.vote.VoteKind.FOR
import org.agoranomic.assessor.lib.vote.VoteKind.PRESENT

@UseAssessment
fun assessment9049to9051() = assessment {
    name("9049-9051")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)
            powerDream(Goren, 2)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy Kate
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Geologist"(1) heldBy Forest
                "Herald"(2) heldBy snail
                "Illuminator"(1) heldBy snail
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy Janet
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
        proposal(9049) {
            title("Registration restrictions")
            ai("3.0")
            author(Janet)
            coauthors(Aris, ais523)
            democratic()

            text(
                """
Amend Rule 869 by, as a single amendment (in order):

* Replacing the text "No person can be a player if e is part of another
player or another player is part of em." with "Rules to the contrary
notwithstanding, two or more persons CANNOT become Registered
simultaneously.".

* Inserting the following paragraph after the paragraph beginning "An
Unregistered person CAN":

{

The basis of a person is the set of all persons that are (recursively)
part of em, in addition to emself. Rules to the contrary
notwithstanding, a person CANNOT become Registered if eir basis overlaps
with that of any current player.

}


[

This fixes a bug where two group persons [A B] and [B C] could be both
be players, since neither is a part of the other.

In order to let this work, this also prohibits simultaneous
registrations. This is done now because simultaneous registrations would
break the check for overlapping persons (if [A B] and [B C] could
register simultaneously, neither would overlap with any existing player,
even if they overlapped with each other). As a more general matter,
simultaneous registrations seem likely to result in bugs, and
registration order has been used as a tiebreak before (e.g. for Spaaace).

]"""
            )
        }

        proposal(9050) {
            title("Self-ratification limitations")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2201 ("Self-Ratification") by, as a single amendment (in order):

* Replacing "When a public document is continuously undoubted for one
week after publication" with "When a public document published less than
180 days ago is first continuously undoubted for one week after publication"

* Replacing the text "identifying a document and explaining" with
"identifying a public document published less than 180 days ago and
explaining".

[First, prevent self-ratifying documents from ratifying more than once
if they go from undoubted to doubted to undoubted. Next, add a
(generous) time limit on self-ratification and doubts to prevent very
old documents from surprisingly being ratified or imposing a requirement
on their publishers to respond. Also, only allow claims of error on
published documents (which later parts of the rule assume anyway).]


Amend Rule 2201 ("Self-Ratification") by, as a single amendment (in order):

* Inserting the following paragraph before the paragraph beginning "Any
person CAN": "The definition of documents as self-ratifying and the
definition of documents as self-ratifying attestations are secured at
power 3."

* Appending the following paragraph to the Rule:

{

The issuance of a doubt on a documents, the denial of a claim of error,
and the ceasing of a doubt on a document to be a doubt are secured at
power 3.

}

[Prevent low-power dictatorships from making random things
self-ratifying and from automatically making or denying claims of error.
All self-ratifying things (assets, Proposal Pool, switches, Festivity,
decision initiation/termination) are already defined at power >= 3.]"""
            )
        }

        proposal(9051) {
            title("A Mossy Cabinet")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2451 (Executive Orders) by appending the following Cabinet Order:

{
      - Growth (Stonemason): The Prime Minister increases the mossiness of
a specified stone by 2.
}"""
            )
        }
    }

    voting {
        votes(snail) {
            PRESENT on 9049
            PRESENT on 9050
            FOR on 9051
        }

        votes(Janet) {
            endorse(ais523) on 9049
            endorse(ais523) on 9050
            PRESENT on 9051
        }

        votes(Murphy) {
            FOR on 9049
            FOR on 9050
            endorse(Janet) on 9051 comment "${Janet.name} is the Stonemason"
        }
    }
}
