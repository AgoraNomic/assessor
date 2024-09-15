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
import org.agoranomic.assessor.lib.vote.finalResolution
import org.agoranomic.assessor.lib.vote.voteIfVoted

@UseAssessment
fun assessment9168to9178() = assessment {
    name("9168-9178")
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
                "Illuminator"(1) heldBy Quadrantal
                "Notary"(2) heldBy Forest
                "Prime Minister"(0) heldBy null
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy ais523
                "Spendor"(1) heldBy oliver
                "Stonemason"(1) heldBy null
                "Tailor"(1) heldBy Murphy
                "Tracker of Hats"(1) heldBy Mischief
                "Webmastor"(1) heldBy Quadrantal
            }
        }
    }

    proposals(v4) {
        proposal(9168) {
            title("Erosion in Geological Rhyme")
            ai("2.0")
            author(Kate)
            ordinary()

            text(
                """
Consider each player with one or more stones;
  Take the sum of the Costs of the stones that e owns.
And then, to compense for lost ius utendi,
  That number of times, grant that player a Spendie.

Now, for each person who, from 2020,
  Has owned any stones (even one would be plenty),
In light of the long tradition Stones had
  Grant em this Patent Title: "Stone Badge".

And whereas this Proposal seeks to insist
  On the notion that stones will no longer exist,
  Repeal (in order) the following list.
That's Rules 2640 and 2641,
  2642, 2644 (43's already gone),
  And then 2645, the last to be done.

COMMENTS:

I doubt this proposal will pass now and here,
  But I hope to rhetorically make my point clear.
The stone rules' complexity's always been high;
  Few players to learn have been willing to try.

The most obvious problem's the tracking vocation:
  We simply can't seem to retain a Stonemason.
Janet once held it, for quite a long time,
  But felt that the load was too high and resigned.

Relying on em was unfair, e expressed.
  'Twas frustrating that others showed no interest.
  (E already does too much work, I suggest.)
E doubted another'd take over, and lo!
  Another report did not therefrom follow.
  And in the months since, not a one did up-show.

Without a Stonemason, complexity's worse.
  Work multiplies like a terrible curse.
Now, as well as the rules, we must also know what
  The Stonemason should track, but right now does not.

We selected a victim by random sortition,
  But e failed to manage, despite a petition.
To be clear, e tried! I don't allocate blame.
  But now e's resigned too, the position's the same.

If none of us can the records sustain,
  Then I think it would be a mistake to retain
  A system that's such a great chore to maintain.
So unless the subgame can be fixed at its bones
  I plead with you all to take heed of my moans
  And bring to a close the Era of Stones."""
            )
        }

        proposal(9169) {
            title("Not all the way up")
            ai("3.1")
            author(Yachay)
            democratic()

            text(
                """
In Rule 2481, amend "While Agora's Festivity is zero, the paragraphs above
have no effect and are ignored." to:

"While Agora's Festivity is zero, the paragraphs above in this rule have no
effect and are ignored.""""
            )
        }

        proposal(9170) {
            title("Not all the way up")
            ai("3.1")
            author(Yachay)
            democratic()

            text(
                """
In Rule 2481, amend "While Agora's Festivity is zero, the paragraphs above
have no effect and are ignored." to:

"While Agora's Festivity is zero, the paragraphs above in this rule have no
effect and are ignored.""""
            )
        }

        proposal(9171) {
            title("Rationalizing Recordkeepors v1.2")
            ai("3.0")
            author(Kate)
            coauthors(Murphy, Janet, Forest)
            democratic()

            text(
                """
[The purpose of this proposal is to unify the language around "tracking"
 and "recordkeepors", which is currently subtly different for assets and
 switches and has caused a lot of confusion in the past. In particular,
 the word "recordkeepor" is currently not defined with respect to
 switches, only to assets; this is causing bizarre behaviour around
 Hats, the intention of which is to be tracked, but not by an officer.]

Create a new Rule of Power 3.0, entitled "Recordkeepors", and reading
as follows:

      For some entity or class of entities to be "tracked by" another
      entity is for the latter entity to be its recordkeepor.

      For an entity to be a recordkeepor for a type of switch is for
      that entity to be the recordkeepor for all instances of that
      switch.

      Where the rules specify a recordkeepor for some set of instances
      of a switch, that recordkeepor's (weekly, if not specified
      otherwise) report includes the value of each instance in that set
      whose value is not its default value; a public document purporting
      to be this portion of that recordkeepor's report is
      self-ratifying, and implies that other instances in that set are
      at their default value.

      The recordkeepor of a class of assets is the entity (if any)
      defined as such by, and bound by, its backing document. That
      recordkeepor's report includes a list of all instances of that
      class and their owners. A public document purporting to be this
      portion of that recordkeepor's report is self-ratifying.

Amend Rule 2166 (Assets) by removing the following:

      The recordkeepor of a class of assets is the entity (if any)
      defined as such by, and bound by, its backing document. That
      entity's report includes a list of all instances of that class and
      their owners. A public document purporting to be this portion of
      that entity's report is self-ratifying.

      For a class of assets to be "tracked by" an entity is for that
      entity to be its recordkeepor.

Amend Rule 2162 (Switches) by removing the following:

      3. Optionally, exactly one office whose holder tracks instances of
         that switch. That officer's (weekly, if not specified
         otherwise) report includes the value of each instance of that
         switch whose value is not its default value; a public document
         purporting to be this portion of that officer's report is
         self-ratifying, and implies that other instances are at their
         default value.

Amend Rule 2603 (Switch Responsibility) to read in full:

      For each type of switch that is not defined as untracked and that
      has at least one instance that would otherwise lack a
      recordkeepor, there exists an imposed office named "Tracker of
      [type name]" whose holder tracks those instances.

Rename Rule 2143 (Official Reports and Duties) to "Reports and Duties",
and amend it by replacing this text:

      An officer SHALL publish eir report in plain text, with tabular
      data lining up properly when viewed in a monospaced font.
      Publishing a report that deviates from these restrictions is the
      Class 2 infraction of Making My Eyes Bleed.

      A player CAN, by announcement, petition a specified non-vacant
      office to take a specific action. The holder of that office SHALL
      publicly respond to that petition in a timely fashion.

with this text:

      A person publishing a report SHALL do so in plain text, with
      tabular data lining up properly when viewed in a monospaced font.
      Publishing a report that deviates from these restrictions is the
      Class 2 infraction of Making My Eyes Bleed.

      A player CAN, by announcement, petition a specified person with a
      specified duty to take a specific action related to that duty.
      That person SHOULD publicly respond to that petition in a timely
      fashion. A player CAN petition a specified non-vacant office in
      the same fashion; its holder SHALL respond in the same fashion.

Amend Rule 2694 (Hats) by replacing:

      Unless otherwise specified by the rules: 1) the recordkeepor for
      a player's hat is the player emself, and 2) reporting on hats is
      OPTIONAL.

with:

      The recordkeepor for a player's hat is the player emself. Rules
      to the contrary notwithstanding, reporting on one's own hat is
      OPTIONAL."""
            )
        }

        proposal(9172) {
            title("Veblen Defense")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[Allows the current owner to bid up the cost.]

Amend rule 2695 (The Veblen) by replacing the paragraph reading:

       A player who does not own the Veblen CAN pay a fee of X spendies
       to purchase the Veblen, where X is an integer not less than the
       current Veblen cost. When e does so, the Veblen is transferred to
       em, then the Veblen cost is set to X+1.

with:

       A player CAN pay a fee of X spendies, where X is an integer not
       less than the current Veblen cost, to set the Veblen cost to X+1.
       When e does so, if e does not own the Veblen, the Veblen is
       transferred to em.

and by replacing "Abusrdor" with "Absurdor""""
            )
        }

        proposal(9173) {
            title("Mid-2024 Omnibus Cleanup Act")
            ai("3.0")
            author(Mischief)
            coauthors(Murphy, ais523, Janet, Forest)
            democratic()

            text(
                """
Amend rule 2528 (Voting Methods) by replacing "thereof." with
"thereof)." and inserting a paragraph break immediately after the
replaced string.

[Suggested clarifications from Murphy and ais523]

Amend rule 1023 (Agoran Time) by making the following replacements in
the final top-level list item: 1) "that would otherwise occur" with
"that would otherwise attempt to occur" and 2) "instead occurs on the
following day" with "instead occurs on the first day of the following month"

[Typos identified by Janet]

Amend rules 2160 (Deputisation) and 2438 (Ribbons) -- in that order --
by, in each, replacing "an voluntary office" with "a voluntary office".

[Typo identified by 4st]

Amend rule 2606 (Proposal Classes) by replacing "an referendum" with "a
referendum""""
            )
        }

        proposal(9174) {
            title("Various sortition fixes v2")
            ai("2.0")
            author(Janet)
            coauthors(Kate)
            democratic()

            text(
                """
Amend Rule 2691 ("Sortition Procedure") by, as a single amendment:

* Replacing "CAN become an option for that office" with "CAN by
announcement become an option for that office".

* Replacing "that player becomes the officeholder for that office" with
"that player becomes the officeholder for that office, then the
sortition ends"

* Inserting the following paragraph after the paragraph beginning "Seven
days after":

{

If a sortition's lots period has ended, and the sortition has no valid
options, then it immediately ends with no selection, and any duty to
select an option with respect to it is discharged.

}


Each ongoing sortition that is not in its lots period and that has no
valid options or has previously had an option selected hereby ends."""
            )
        }

        proposal(9175) {
            title("Crystal liquidation")
            ai("1.0")
            author(oliver)
            coauthors(Forest)
            ordinary()

            text(
                """
Amend Rule 2685 "Crystals" by inserting the following text after the end of
the rule:

{

Once per week, a player CAN liquidate a specified crystal that e owns by
announcement. Doing so grants that player spendies equal to the half the
size of the crystal, rounded down, then destroys the crystal.

}"""
            )
        }

        proposal(9176) {
            title("Adjusting the Money Supply")
            ai("1.0")
            author(Mischief)
            ordinary()

            text(
                """
[Giving folks the option to also adjust the base monthly income in light
of the crystals-for-spendies proposal.]

Amend Rule 2690 (Spendies) by replacing "20 Spendies" with "15 Spendies""""
            )
        }

        proposal(9177) {
            title("Prevent cheap Stone wins")
            ai("2.0")
            author(ais523)
            ordinary()

            text(
                """
In rule 2642, amend:
{{{
      Stone Cost is a Stone switch with values of non-negative integers
      and a default of 10.
}}}
to
{{{
      Stone Cost is a Stone switch with values of non-negative integers
      and a default of 20.
}}}

Then increase the Stone Cost of every Stone by 10.

[At present, Stones are sufficiently cheap that the defensive measures
necessary to prevent easy Stone wins by other players are too expensive
for players to take them in practice – and the Stones system was
designed assuming that they would be harder to obtain than that.
Starting a descending-price auction from a price of 10 doesn't function
because Stones are frequently more valuable than that. Doubling the
starting cost should make the Stone gameplay work better.]"""
            )
        }

        proposal(9178) {
            title("Takes Two to Tango in this Town")
            ai("1.0")
            author(snail)
            ordinary()

            text(
                """
Amend Rule 2692 (Bang!) by replacing "after which each alive player gains a
bang." with "after which each alive player is granted 2 bangs."

[Makes the bang subgame playable.]"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9168
            AGAINST on 9169
            AGAINST on 9170
            FOR on 9171
            FOR on 9172
            FOR on 9173
            FOR on 9174
            FOR on 9175
            // TODO: resolve conditional on 9176: FOR if 9175 will pass, else AGAINST
            FOR on 9177
            FOR on 9178
        }

        votes(Mischief) {
            FOR on 9168
            FOR on 9169
            AGAINST on 9170
            FOR on 9171
            FOR on 9172
            FOR on 9173
            FOR on 9174
            FOR on 9175
            FOR on 9176
            FOR on 9177
            FOR on 9178
        }

        votes(juan) {
            FOR on 9168
            endorse(Yachay) on 9169
            endorse(Yachay) on 9170
            FOR on 9171
            PRESENT on 9172
            FOR on 9173
            FOR on 9174
            PRESENT on 9175
            PRESENT on 9176
            PRESENT on 9177
            PRESENT on 9178
        }

        votes(Janet) {
            FOR on 9168
            AGAINST on 9169
            AGAINST on 9170
            FOR on 9171
            FOR on 9172
            PRESENT on 9173
            FOR on 9174
            AGAINST on 9175
            FOR on 9176
            FOR on 9177
            PRESENT on 9178
        }

        votes(kiako) {
            FOR on 9168
            AGAINST on 9169
            AGAINST on 9170

            function { ctx ->
                val kateVote = ctx.resolve(ctx.currentProposal, Kate)?.finalResolution(ctx)?.voteIfVoted
                val janetVote = ctx.resolve(ctx.currentProposal, Janet)?.finalResolution(ctx)?.voteIfVoted

                if (kateVote == AGAINST || janetVote == AGAINST) {
                    resolvedConditional(AGAINST, "Either ${Kate.name} or ${Janet.name} voted AGAINST")
                } else if (kateVote == FOR || janetVote == FOR) {
                    resolvedConditional(FOR, "Either ${Kate.name} or ${Janet.name} voted FOR")
                } else {
                    resolvedConditional(
                        InextricableResolvingVote,
                        "Neither ${Kate.name} nor ${Janet.name} voted FOR or AGAINST"
                    )
                }
            } on 9171

            FOR on 9172
            endorse(Janet) on 9173
            endorse(Janet) on 9174
            AGAINST on 9175
            // TODO: resolve conditional on 9176: FOR if 9175 will pass, else endorse(Janet)
            endorse(Janet) on 9177
            FOR on 9178
        }
    }
}
