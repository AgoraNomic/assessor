package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum

@UseAssessment
fun assessment9003to9004() = assessment {
    name("9003-9004")
    quorum(3)

    proposals(v4) {
        proposal(9003) {
            title("Process Protection")
            ai("3.0")
            author(Janet)
            coauthors(G)
            democratic()

            text(
                """
Amend Rule 2350 ("Proposals") by appending the following paragraph:

{

The destruction of a proposal and the causing of a proposal to cease
being a proposal are secured. The removal of a proposal from the
Proposal Pool, other than by distribution, is secured.

}


Amend Rule 1607 ("Distribution") by appending the following paragraph:

{

The destruction of a referendum is secured. Causing a referendum to
cease being a referendum is secured.

}


Amend Rule 107 ("Initiating Agoran Decisions") by appending the
following paragraph:

{

The destruction of an Agoran decision and the causing of an Agoran
decision to cease being an Agoran decision are secured at the power of
the Rule authorizing the initiation of such a decision.

}


[Prevents a power-1 dictatorship from vetoing proposals it doesn't like
by just disappearing the proposal or the decision.]"""
            )
        }

        proposal(9004) {
            title("Additional Containment Procedure!!!")
            ai("1.0")
            author(Forest)
            coauthors(Janet, Murphy)
            ordinary()

            text(
                """
In this proposal, all instances of Rule UNDEFINED refer to Rule UNDEFINED
enacted by the Proposal "Secure Contain Protect" submitted on 6/25/23
02:44, by 4st via agora-business.

Amend Rule UNDEFINED by replacing "describe any interaction" with
"interact".
Amend Rule UNDEFINED by replacing "the Agent's regulations" with "the
Agent's administrative regulations".
Amend Rule UNDEFINED by removing "- Rule UNDEFINED CAN cause a player or
players to win, despite it being ILLEGAL."
Amend Rule UNDEFINED by removing "- Calls for Judgement SHALL NOT provide
judgement on Rule UNDEFINED. Violations of this clause are a class 10 crime
of violating Rule UNDEFINED."
Amend Rule UNDEFINED by replacing "contracts or pledges." with "contracts,
promises, or pledges."
Amend Rule UNDEFINED by adding
{
- Rule UNDEFINED CANNOT be amended by an interaction with Rule UNDEFINED
- Rule UNDEFINED CANNOT cause a player or players to win by an interaction
- Rule UNDEFINED CANNOT create, destroy, or transfer assets.
- Rule UNDEFINED CANNOT flip switches.
- Any and all interactions with Rule UNDEFINED happen at power 0.01 during
the Agent's weekly report, approximately six weeks in the future, and the
Agent SHALL track these events before, during, and after their occurence.
}
after "Specifically, at this point in time, it is known that:"

[As part of containment, unfortunately, it looks like Rule UNDEFINED CAN
currently amend Rule UNDEFINED??? HALP!!!]

Amend Rule UNDEFINED by replacing
"- Rule UNDEFINED CANNOT amend itself, enact, re-enact, or repeal rules."
with
"- Rule UNDEFINED CANNOT enact, re-enact, amend, or repeal rules other than
Rule UNDEFINED".

Amend Rule UNDEFINED by appending
{
Immediately before the Rulekeepor publishes eir report, Rule UNDEFINED
modifies Rule UNDEFINED by:
- replacing all instances of "UNDEFINED" with Rule UNDEFINED's ID
- removing this paragraph.
}
to the end of Rule UNDEFINED."""
            )
        }
    }
}
