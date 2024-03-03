package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.*
import org.agoranomic.assessor.lib.vote.VoteKind.*
import org.agoranomic.assessor.lib.vote.finalResolution
import org.agoranomic.assessor.lib.vote.voteIfVoted

@UseAssessment
fun assessment9058to9051() = assessment {
    name("9058-9061")
    quorum(5)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Yachay, 2)
            powerDream(Jimmy, 2)

            powerStone(Janet, 3)

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
        proposal(9058) {
            title("Things Mean What They're Meant to Mean")
            ai("3.0")
            author(Aris)
            coauthors(G)
            democratic()

            text(
                """
Amend Rule 105, "Rule Changes", by adding at the end of the paragraph:

  A rule change is any effect that falls into the above classes.
  Rule changes always occur sequentially, never simultaneously.

the text:

  If a specification would ever be interpreted as causing multiple changes
to
  happen at once, it is instead interpreted as attempting to cause them to
  occur separately, in the order they are listed in the specification.

and by replacing the paragraph:

  Any ambiguity in the specification of a rule change causes that
  change to be void and without effect. An inconsequential variation
  in the quotation of an existing rule does not constitute ambiguity
  for the purposes of this rule, but any other variation does.

with:

  Any ambiguity in the specification of a rule change causes that
  change to be void and without effect. An inconsequential variation
  in the quotation of an existing rule does not constitute ambiguity
  for the purposes of this rule. Furthermore, if the change being specified
  would be clear to any reasonable player, the specification is not
ambiguous,
  even if it is incorrect or unclear on its face. This provision does not
  prevent the specification of undesirable changes; for instance, an
amendment
  which adds a typo is not corrected to remove the typo.

and by replacing the text:

   5. retitle (syn. amend the title of) a rule.

with:

   5. retitle a rule.

[Removing the synonym, since it should now be unneeded.]

At 4st's request, it is publicly noted that e is very silly for calling
this proposal an unneeded bug fix.

[Some further examples of what should now work:

1. An amendment to the power of a rule is read as a change in the rule's
power.
2. A repeal of a section of a rule is read as an amendment which removes
that
   section.
3. Ellipses are read sensibly in rule quotations.
4. "Enact the following:" enacts the rule, unless it could sensibly be read
   as enacting a regulation.
5. "Append the following paragraph" works even if two paragraphs are clearly
    specified. (It still fails if it's unclear whether the text means one or
    two paragraphs though.)

You get the point.]"""
            )
        }

        proposal(9059) {
            title("Ambiguity Amendment")
            ai("1.0")
            author(Maloney)
            ordinary()

            text(
                """
Amend the following text of rule 105/23, Rule Changes, as delineated by the
first set quotation marks within this proposal by replacing the entirety of
the bolded, italicised, and underlined portion of the text with the text
delineated by the second set of quotation marks within this proposal:

"*Any ambiguity in the specification of a rule change causes that change to
be void and without effect.* An inconsequential variation in the quotation
of an existing rule does not constitute ambiguity for the purposes of this
rule, but any other variation does."

"Ambiguity which would reasonably alter the function of a rule change or
cause reasonable doubt that a rule change is being made causes that change
to be void and without effect."

All text in this proposal between the given ID of this proposal (which
terminates at the first character 3 within this proposal) and the start of
this sentence (which begins with the phrase "All text" after a line break)
are part of the rule change proposed within this proposal. The text within
this paragraph is not a part of the proposed rule change. This proposal is
proposed as an attempt to make a change in the rules, specifically an
amendment to the rule 105/23, which is titled Rule Changes. The text to be
amended is located within rule 105/23 within the ninth (9th) body of text
within that rule. This proposal is being sent to a public forum, as per the
necessary publicity of a rule announcement. Should the formatting of this
proposal be lost, it should be noted that the bolded, italicised, and
underlined text reads as "*Any ambiguity in the specification of a rule
change causes that change to be void and without effect.*" and that the
amendment proposed in this proposal replaces that text entirely, removing
it from the rule, and applying the replacement text ("Ambiguity which would
reasonably alter the function of a rule change or cause reasonable doubt
that a rule change is being made causes that change to be void and without
effect.") within the same place as the replaced text.

##This is a clearly marked comment clarifying that there are no other
comments within this message not a part of this proposal other than the one
preceding the proposal. The proposal begins with the title of the proposal
(the text "Name: Ambiguity Amendment")."""
            )
        }

        proposal(9060) {
            title("Ambiguity Amendment")
            ai("1.0")
            author(Maloney)
            ordinary()

            text(
                """
Amend the following text of rule 105, Rule Changes, as delineated by the
first set quotation marks within this proposal by replacing the entirety of
the bolded, italicised, and underlined portion of the text with the text
delineated by the second set of quotation marks within this proposal:

"*Any ambiguity in the specification of a rule change causes that change to
be void and without effect.* An inconsequential variation in the quotation
of an existing rule does not constitute ambiguity for the purposes of this
rule, but any other variation does."

"Ambiguity which would reasonably alter the function of a rule change or
cause reasonable doubt that a rule change is being made causes that change
to be void and without effect."

All text in this proposal between the given ID of this proposal (which
terminates at the first character 3 within this proposal) and the start of
this sentence (which begins with the phrase "All text" after a line break)
are part of the rule change proposed within this proposal. The text within
this paragraph is not a part of the proposed rule change. This proposal is
proposed as an attempt to make a change in the rules, specifically an
amendment to the rule 105, which is titled Rule Changes. The text to be
amended is located within rule 105 within the ninth (9th) body of text
within that rule. This proposal is being sent to a public forum, as per the
necessary publicity of a rule announcement. Should the formatting of this
proposal be lost, it should be noted that the bolded, italicised, and
underlined text reads as "*Any ambiguity in the specification of a rule
change causes that change to be void and without effect.*" and that the
amendment proposed in this proposal replaces that text entirely, removing
it from the rule, and applying the replacement text ("Ambiguity which would
reasonably alter the function of a rule change or cause reasonable doubt
that a rule change is being made causes that change to be void and without
effect.") within the same place as the replaced text.

##This is a clearly marked comment clarifying that there are no other
comments within this message not a part of this proposal other than the one
preceding the proposal. The proposal begins with the title of the proposal
(the text "Name: Ambiguity Amendment")."""
            )
        }

        proposal(9061) {
            title("Wake Up Call")
            ai("2.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2675 (Dream of Wandering) by replacing "Dream is a secured
active player switch" with "Dream is an active player switch".

Enact a new Rule with Power 1 and title "Clapping" and the following text:
{
Each player CAN, with 3 support, Clap. When a player Claps, each active
player's Dream is set to Wandering. A player CANNOT Clap if any person has
Clapped in the past 2 weeks.
}"""
            )
        }
    }

    voting {
        votes(snail) {
            endorse(Aris) on 9058
            AGAINST on 9059
            AGAINST on 9060
            FOR on 9061
        }

        votes(Aris) {
            FOR on 9058
            AGAINST on 9059
            AGAINST on 9060

            function { ctx ->
                when (ctx.resolve(ctx.currentProposal, Janet)?.finalResolution(ctx)?.voteIfVoted) {
                    FOR -> resolvedConditional(PRESENT, "Janet voted FOR")
                    PRESENT -> resolvedConditional(PRESENT, "Janet voted PRESENT")
                    else -> resolvedConditional(AGAINST, "Janet did not vote FOR or PRESENT")
                }
            } on 9061
        }

        votes(kiako) {
            endorse(Janet) on 9058 comment "${Janet.name} is the Rulekeepor"
            AGAINST on 9059
            AGAINST on 9060
            PRESENT on 9061
        }

        votes(juan) {
            PRESENT on 9058
            PRESENT on 9059
            PRESENT on 9060
            AGAINST on 9061
        }

        votes(nix) {
            FOR on 9058
            AGAINST on 9059
            AGAINST on 9060
            AGAINST on 9061
        }

        votes(Janet) {
            endorse(ais523) on 9058
            AGAINST on 9059
            AGAINST on 9060
            AGAINST on 9061
        }

        votes(Murphy) {
            FOR on 9058
            AGAINST on 9059
            AGAINST on 9060
            endorse(snail) on 9061 comment "${snail.name} is the Dream Keeper"
        }

        votes(Mercury) {
            FOR on 9058
            PRESENT on 9059
            PRESENT on 9060
            FOR on 9061
        }
    }
}
