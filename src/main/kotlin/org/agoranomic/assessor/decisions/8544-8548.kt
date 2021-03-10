package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.vote.ResolvedVote
import org.agoranomic.assessor.lib.vote.VoteKind.*
import org.agoranomic.assessor.lib.vote.commented
import org.agoranomic.assessor.lib.vote.finalResolution
import org.agoranomic.assessor.lib.vote.voteIfVoted

@UseAssessment
fun assessment8544to8548() = assessment {
    name("8544-8548")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        blotPenalty(RLee, 7 / 3)
    }

    proposals(v4) {
        proposal(8544) {
            title("Clarify dependent actions")
            ai("3.0")
            author(Murphy)
            democratic()
            sponsored()

            text(
                """
Amend Rule 2595 (Performing a Dependent Action) to read:

  A rule that purports to allow a person (the performer) to perform
  an action by a set of one or more dependent actions thereby allows
  em to perform the action by announcement if all of the following
  are true:

  1. A person (the initiator) published an announcement of intent
    that unambiguously, clearly, conspicuously, and without
    obfuscation specified the action intended to be taken and the
    method(s) to be used, including these values if relevant:

      * If the action is to be taken with T notice, then the value
        of T.

      * If the action is to be taken without N objections, with N
        support, or with N Agoran Consent, and N is not equal to 1,
        then the value of N.

  2. The time between the announcement of intent and the action is
    at most 14 days. In addition:

      * If the action is to be taken without N objections or with N
        Agoran consent, then it is at least 4 days.

      * If the action is to be taken with T notice, then it is at
        least T (minimum of 4 days).

  3. At least one of the following is true:

      * The performer is the initiator.

      * The initiator was authorized to perform the action due to
        holding a rule-defined position now held by the performer.

      * The initiator is authorized to perform the action, the
        action depends on support, the performer has supported the
        intent, and the rule authorizing the performance does not
        explicitly prohibit supporters from performing it.

  4. Agora is Satisfied with the announced intent, as defined by
    other Rules.

  5. If the announcement of intent stated any conditions, then those
    conditions are all met.

  If the action is to be taken with N Agoran consent, then the
  performer SHOULD publish a list of supporters and objectors.

Amend Rule 2124 (Agoran Satisfaction) to read:

  A Supporter of an intent to perform an action is an eligible
  entity who has publicly posted (and not withdrawn) support for an
  announcement of that intent.

  An Objector to an intent to perform an action is an eligible
  entity who has publicly posted (and not withdrawn) an objection to
  the announcement of that intent.

  The entities eligible to support or object to an intent to perform
  an action are, by default, all players, subject to modification by
  the document authorizing the dependent action. However, the
  previous sentence notwithstanding, the initiator of the intent is
  not eligible to support it, and a person CANNOT support or object
  to an announcement of intent before the intent is announced, or
  after e has withdrawn the same type of response.

  Agora is Satisfied with an intent to perform a specific action
  unless at least one of the following is true:

  1. The action is to be performed without N objections, and there
    are at least N Objectors to that intent.

  2. The action is to be performed with N support, and there are
    fewer than than N Supporters of that intent.

  3. The action is to be performed with N Agoran consent, and the
    number of Supporters of that intent is less than or equal to N
    times the number of Objectors to that intent.

  4. The action is to be performed without N objections or with N
    Agora consent, and an objection to that intent was withdrawn
    within the past 24 hours.

  5. The Speaker objected to that intent within the past 48 hours."""
            )
        }

        proposal(8545) {
            title("Uncanny Fixes")
            ai("3.0")
            author(Aris)
            coauthors(Murphy)
            democratic()
            sponsored()

            text(
                """
[CAN requires a method, but there are a bunch of places it occurs
without a method or is otherwise used incorrectly. For instance,
all caps CAN is used in a bunch of places where its narrow, technical
meaning doesn't quite seem to apply.]


Amend Rule 2505, "Random Choices", by replacing:

  The choice CAN be made using any physical or computational process
  whose probability distribution among the possible outcomes is
  reasonably close to that required by the Rules, and for which the
  final choice is not trivially predictable by the selecting person
  in advance.

with:

  The choice can be made using any physical or computational process
  whose probability distribution among the possible outcomes is
  reasonably close to that required by the Rules, and for which the
  final choice is not trivially predictable by the selecting person
  in advance.


Amend Rule 2619, "Indictment", by replacing:

  When an investigator has issued an Indictment, the perpetrator CAN
  state a defence.

with:

  When an investigator has issued an Indictment, the perpetrator may
  state a defence.

Amend Rule 591, "Delivering Judgements", by replacing:

  A CFJ judged as INSUFFICIENT CAN and SHOULD be
  submitted again with sufficient arguments/evidence.

with:

  A CFJ judged as INSUFFICIENT SHOULD be submitted again with
  sufficient arguments/evidence.


Amend Rule 2634, "Buoyancy Control", by replacing:

  The Treasuror CAN and MAY exercise reasonable judgement in
  calculating the Total Buoyancy. The Total Buoyancy will be deemed
  set so long as the value chosen by the Treasuror is not obviously
  and grossly incorrect. The Treasuror CAN and MAY set the Total
  Buoyancy more than once a month, but SHOULD NOT do so unless there
  is reason to believe eir previous setting of the value failed.

with:

  The Treasuror may exercise reasonable judgement in
  calculating the Total Buoyancy. The Total Buoyancy will be deemed
  set so long as the value chosen by the Treasuror is not obviously
  and grossly incorrect. The Treasuror may set the Total
  Buoyancy more than once a month, but SHOULD NOT do so unless there
  is reason to believe eir previous setting of the value failed.


Amend Rule 2231, "Order of the Hero of Agora Nomic", by replacing:

  Grand Hero of Agora Nomic (GHAN) -- This title CAN be awarded to
  any person obviously and directly responsible for the existence of
  Agora and/or Nomic in general. As this title is the highest honour
  that Agora may bestow, a Bearer of this title OUGHT to be treated
  right good forever.

  Hero of Agora Nomic (HAN) -- This title CAN be awarded to any
  person for outstanding meritorious service to Agora above and
  beyond the call of duty.

with:

  Grand Hero of Agora Nomic (GHAN) -- This title may be awarded to
  any person obviously and directly responsible for the existence of
  Agora and/or Nomic in general. As this title is the highest honour
  that Agora may bestow, a Bearer of this title OUGHT to be treated
  right good forever.

  Hero of Agora Nomic (HAN) -- This title may be awarded to any
  person for outstanding meritorious service to Agora above and
  beyond the call of duty.


[Unless there's an objection, just going to yank this. No reason for
free tournaments to be treated differently than other kinds of tournament.]

Amend Rule 2566, "Free Tournaments", by removing:

  Rules to the contrary notwithstanding, only players CAN win the game
  via a free tournament.

Amend Rule 2614, "Eclipse Light", by replacing:

  Emergency Regulations CAN:

with:

  Emergency Regulations CAN, as part of their effect:


Amend Rule 107, "Initiating Agoran Decisions", by replacing:

  The vote collector for a decision with less than two options
  CAN and SHALL end the voting period by announcement, if it has not
  ended already, and provided that e resolves the decision in the
  same message.

with:

  The vote collector for a decision with less than two options
  CAN end the voting period by announcement, if it has not
  ended already, and provided that e resolves the decision in the
  same message.

Amend Rule 2573, "Impeachment", by replacing:

  A player CAN be expelled (impeached) from a specified elected
  office which e holds with 2 Agoran consent.

with:

  Any player CAN, with 2 Agoran consent, expel (impeach) the
  holder of a specified elected office."""
            )
        }

        proposal(8546) {
            title("Talisn't")
            ai("3.0")
            author(G)
            democratic()

            text(
                """
Amend Rule 2575 (The Distributor) by replacing:
  Rules to the contrary notwithstanding, the talisman for the
  Distributor is possessed by emself (and is transferred to em if it
  ever is not), and e CANNOT deregister or be deregistered.
with:
  Rules to the contrary notwithstanding, the
  Distributor CANNOT deregister or be deregistered."""
            )
        }

        proposal(8547) {
            title("ER office restriction")
            ai("3.0")
            author(Jason)
            democratic()

            text(
                """
Amend Rule 2614 ("Eclipse Light") by replacing "Appoint or remove
officeholders." with "Appoint or remove officeholders, other than Prime
Minister or Speaker.""""
            )
        }

        proposal(8548) {
            title("Stone defaults")
            ai("3.0")
            author(Jason)
            ordinary()

            text(
                """
Amend Rule 2645 (The Stones) by replacing each instance of "A specified
player" with "A specified player (defaulting to the wielder if not
specified)".

[This makes it unambiguous that, for example, "I wield the Wealth
Stone." works and grants the wielder coins.]"""
            )
        }
    }

    voting {
        votes(Aris) {
            PRESENT on 8544
            FOR on 8545
            FOR on 8546
            FOR on 8547
            FOR on 8548
        }

        votes(Jason) {
            function { ctx ->
                if (ctx.resolve(ctx.currentProposal, G)?.finalResolution(ctx)?.voteIfVoted == FOR)
                    ResolvedVote(FOR).commented(conditional("G. voted FOR"))
                else
                    ResolvedVote(AGAINST).commented(conditional("G. did not vote FOR"))
            } on 8544
            FOR on 8545
            FOR on 8546
            FOR on 8547
            FOR on 8548
        }

        votes(Falsifian) {
            FOR on 8544
            endorse(Aris) on 8545
            endorse(G) on 8546
            endorse(Jason) on 8547
            endorse(Jason) on 8548
        }
    }
}
