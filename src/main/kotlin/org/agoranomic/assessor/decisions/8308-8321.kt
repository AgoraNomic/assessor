package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.v0Ministries
import org.agoranomic.assessor.dsl.ministries.V0Office.*
import org.agoranomic.assessor.dsl.ministries.V0Ministry.*
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.UseAssessment
import org.agoranomic.assessor.lib.VoteKind
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8308 to 8321`() = assessment {
    name("8308-8321")
    quorum(5)

    val offices = mapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Comptrollor to null,
        Distributor to omd,
        Herald to Alexis,
        Notary to Gaelan,
        PrimeMinister to Alexis,
        Promotor to Aris,
        Referee to twg,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to Falsifian,
        Treasuror to twg,
        Tailor to twg
    )

    strengths {
        default(3)
        Falsifian strength 4 comment SPEAKER

        v0Ministries(offices) {
            8311 chamber Economy
            8312 chamber Efficiency
            8314 chamber Economy
            8317 chamber Economy
            8318 chamber Efficiency
            8319 chamber Legislation
            8320 chamber Legislation
            8321 chamber Legislation
        }
    }

    proposals {
        proposal(8308) {
            title("Imposing order on the order")
            ai(3.0)
            author(Falsifian)

            text(
                """
If Proposal 8291 has been passed, and Rule 2350 does not have the list
item "* A chamber to which the proposal shall be assigned upon it
creation.", add that list item to the end of the list. If the list
item is present, but it is not at the end of the list, or it is
unclear or otherwise difficult or impossible to determine where in the
list it is, put it at the end of the list."""
            )
        }

        proposal(8309) {
            title("A Degree of Inefficiency")
            ai(3.0)
            author(Alexis)

            text(
                """
Amend Rule 2595 (Performing a Dependent Action) by inserting ", and did not
subsequently withdraw, " immediately after "published" in the first
paragraph."""
            )
        }

        proposal(8310) {
            title("Deputisation timeliness")
            ai(3.0)
            author(Jason)
            coauthors(Alexis)

            text(
                """
Amend Rule 2160 to read, in whole:

{

  A player acting as emself (the deputy) CAN perform an action ordinarily
  reserved for an office-holder as if e held the office if

  1. the player does not hold that office;

  2. it would be POSSIBLE for the deputy to perform the action, other than
  by deputisation, if e held the office;

  3. either (i) there exists an obligation on the holder of that office,
  by virtue of holding that office, to perform the action, or (ii) the
  office is vacant;

  4. either (i) a time limit applicable to that obligation has been
  violated, and the end of that time limit was fewer than 90 days ago, or
  (ii) the office is vacant;

  5. if the office is not interim, the deputy announced between two and
  fourteen days earlier that e intended to deputise for that office for
  the purposes of the particular action; and

  6. the deputy, when performing the action, announces that e is doing so
  by deputisation or by temporary deputisation.


  When a player deputises for an elected office, e becomes the holder of
  that office, unless the action being performed would already install
  someone into that office, and/or unless the deputisation is temporary.

}

[

Added a prohibition on someone for deputising for an office that e
already holds (this was something I thought of, but then I realized it
violate all of the exacerbating factors in R2557.

Rephrased the time limit checks based on Alexis's suggested wording,
also adding a 90-day statute of limitations.

Removed the requirement for prior announcement for most deputisations,
only kept it for non-interim holders (also per Alexis's suggestion).

]"""
            )
        }

        proposal(8311) {
            title("Rewards Patch & Equitable Remedy")
            ai(1.0)
            author(twg)

            text(
                """
Amend Rule 2496, "Rewards", by replacing "CAN once" with "CAN once by
announcement".

Amend Rule 2602, "Glitter", by replacing "CAN once" with "CAN once by
announcement".

For the purposes of this proposal, the "recession" is defined as the
period of time starting at 03:00 am UTC on 29th January 2020 and ending
the instant before the adoption of this proposal.

For each time a player met a reward condition during the recession,
grant that player the assets associated with the reward condition, or
if e is no longer a player, grant the same assets to the Lost and Found
Department.

For each time a player was awarded Glitter during the recession, grant
that player a quantity of coins determined in the manner specified by
Rule 2602, or if e is no longer a player, grant the same quantity to the
Lost and Found Department.

[This ensures no loss of coins, but shifts the responsibility for
 evaluating the missed rewards onto the Treasuror. Which is fair enough
 because it's mostly my fault. I say "mostly" because nobody else caught
 it in drafting either.]"""
            )
        }

        proposal(8312) {
            title("On Possibility")
            ai(1.0)
            author(Alexis)

            text(
                """
Enact a new power-1 rule entitled "Default Mechanisms" reading as follows:
{
  If the Rules other than this one, as a whole, provide that a person CAN
  perform an action, but do not state the mechanism by which e can do so, e
  CAN perform it by announcement.

  If the Rules other than this one, as a whole, provide that a non-person
  entity CAN perform an action, but do not state the mechanism by which e can
  do so, any person CAN cause that entity to perform that action with Agoran
  Consent.

  If the Rules other than this one, as a whole, provide that an action CAN be
  performed but do not specify any entities as being capable of performing
  that action, any person CAN perform that action with Agoran Consent.

  For the purposes of this Rule, the Rules provide a mechanism for an action
  to be performed even if they specify a mechanism with a precondition which
  is not currently met, and they specify that an entity can perform that
  action even if no appropriate entity currently exists. This Rule defers to
  all Rules which permit actions to be performed by specific mechanisms.
}"""
            )
        }

        proposal(8313) {
            title("Support of the Person")
            ai(3.0)
            author(Alexis)
            coauthors(G)

            text(
                """
Amend Rule 2124 (Agoran Satisfaction) by:

  1. Replacing "However, the previous sentence notwithstanding, the initiator
     of the intent is not eligible to support it." with "Announcing intent to
     perform an action implicitly announces support for that action; such
     support may be withdrawn as per usual."
  2. Replacing "The action is to be performed With N support, and there are
     fewer than than N Supporters of that intent." with "The action is to be
     performed With N support, and there equal to or fewer than than N
     Supporters of that intent."
  3. Replacing "The action is to be performed with N Agoran consent, and
     the number of Supporters of the intent is less than or equal to N times the
     number of Objectors to the intent." with "The action is to be performed
     with N Agoran consent, and the number of Supporters of the intent is less
     than or equal to O or less than N * O, where O is the number of Objectors
     to the intent.""""
            )
        }

        proposal(8314) {
            title("Finite Gifting")
            ai(1.0)
            author(Aris)

            text(
                """
Amend Rule 2585, Birthday Gifts, by changing the text

  "Every time it is a player's Agoran Birthday, each of the other players
  CAN grant em 3 coins by announcement."

to read

  "Every time it is a player's Agoran Birthday, each of the other players
  CAN once grant em 3 coins by announcement.""""
            )
        }

        proposal(8315) {
            title("Clearer Resolutions")
            ai(3.0)
            author(Alexis)

            text(
                """
Amend Rule 208 (Resolving Agoran Decisions) by replacing the third and
fourth items in the list with the following:
{
  3. It specifies the quorum of the decision.

  4. It specifies all the valid ballots, and no invalid ballots, on that
  decision, as of the end of the voting period, including each ballot's
  author, eir voting strength, its vote, and, if the vote is a conditional
  one, the unconditional vote to which it is evaluated.

  5. The total strength of all ballots cast for each non-PRESENT option.

  6. It specifies the outcome, as defined by other rules.
}

[Note that the existing "more than one option" text is basically
tautologically true and practically useless anyway. PRESENT is an option,
so only a decision with no other options would only have one. And even if
we changed it, we short-circuit single-candidate elections so we might as
well just drop that text.

This is the main point of the proposal; I apologize to the Assessor that e
does perhaps not wish to do the additional work here, but it was a
longstanding Assessor practice and, as we are getting into the space of
highly variable voting power again, quite necessary.]

Amend Rule 683 (Voting on Agoran Decisions) by appending the following
paragraph to the end of the rule:
{
  When used in reference to a person who has cast a vote on an Agoran
  decision, rather than to a person who is eligible to or otherwise might
  cast a vote, the term "voter" refers only to a person who has a valid
  ballot on that decision.
}

[This is slightly different from the existing definition, as it includes
people whose votes were not valid but became valid, but such a scenario
shouldn't happen and in any case, this lines up with existing language so
as to prevent a weird situation where a person's vote counts towards the
result but not quorum.]

Amend Rule 955 (Determining the Will of Agora) by replacing the text "The
outcome of a decision is determined when it is resolved, and cannot change
thereafter." with "The outcome of a decision is fixed at the end of its
voting period, after evaluating all votes whose values are determined only
at the end of the voting period, and cannot change thereafter."

[This prevents manipulation of voting strength post-decision from affecting
the result because that's an absurd amount of power to offer an Assessor,
to be able to delay or otherwise manipulate the timing of resolutions so as
to modify voting strength after a resolution. It also simplifies eir job
considerably by not requiring em to take into account the effects of
proposals on voting strength as e resolves them, especially if a CoE
results in different ordering of proposals.]

Amend Rule 2034 (Vote Protection and Cutoff for Challenges) to read:
{
  A public message purporting to resolve an Agoran decision is a
  self-ratifying attestation that:

  1. such a decision existed;
  2. it had the outcome indicated;
  3. if the indicated outcome was to adopt a proposal, that such a decision
  existed, was adopted, and took effect by virtue of the resolution;
  4. if the indicated outcome was to elect a person to an office and if the
  person was eligible for that office, that that person won the election and
  took office.
}"""
            )
        }

        proposal(8316) {
            title("Zombie voting package")
            ai(3.0)
            author(Alexis)

            text(
                """
Amend Rule 683 (Voting on Agoran Decisions) by appending the following
paragraph:
{{
  The above notwithstanding, at the end of the voting period for an Agoran
  decision, prior to the evaluation of conditionals, each entity who has
  never submitted a valid ballot for that decision, and for whom the Rules
  provide a default vote for that decision, automatically submits a valid
  vote on that decision for eir default vote and becomes quorum-ineligible
  for that decision. Providing an entity with a default vote on an Agoran
  decision is secured with power threshold 2.
}}

[We do not think that the "never submitted" condition is too onerous on the
Assessor as e will be going through all the votes anyway.

We would even go with "never attempted to", but we suspect that might lead
to too much litigation, particularly because the easiest way to try and
fail is a NttPF.]

Amend Rule 955 (Determining the Will of Agora) by inserting: {
  Designating a voter as quorum-ineligible on an Agoran decision is secured
  with Power Threshold 2; all voters are otherwise quorum-eligible.
}
and by replacing: {
  If there is more than one option, and the number of voters is less than the
  quorum of that decision, the outcome is instead FAILED QUORUM.
} with {
  If there is more than one option on an Agoran decision, and the number of
  quorum-eligible voters on it is less than its quorum, its outcome is
  instead FAILED QUORUM.
}

[Cleaned up this language because there's already a definition of a voter
applicable to R955 here in R208 (possibly moved as a result of my other
proposal). While I don't think Gaelan's suggestion of clearing up the
possibility of a ballot identical to a default ballot was necessary, this
is cleaner IMO.]

Amend Rule 879 (Quorum) by replacing {
  If no other rule defines the quorum of an Agoran Decision, the quorum for
  that decision is equal to 2/3 of the number of voters on the Agoran
  Decision to adopt a proposal that had been most recently resolved at the
  time of that decision's initiation, the whole rounded to the nearest
  integer (breaking ties upward).
} with {
  The Activity Level is equal to 2/3, rounded to the nearest integer and
  breaking ties upward, of the number of quorum-eligible voters on the most
  recently-resolved Agoran decision to adopt a proposal. If no other rules
  define the quorum of an Agoran decision, then the quorum of that decision
  is equal to the Activity Level at the time if its initiation.
}

Enact a new power-2 rule entitled "Zombie Voting" reading as follows:
{{
  A zombie has its voting strength halved.

  The default vote of a zombie is to endorse eir master.

  Zombies are not quorum-eligible for any Agoran decision.
}}
[Rounding is already provided by R2422.]"""
            )
        }

        proposal(8317) {
            title("Zombie trade")
            ai(1.0)
            author(Aris)

            text(
                """
[This proposal allows zombies to collect the fruits of their zombie
auctions, and to allow players to voluntarily enter servitude. Yes, it does
make buying a zombie a risky business!]

Amend Rule 2483 (Economics) by replacing "Agora, players, and contracts"
with "Agora, players, zombie trusts, and contracts".

Amend Rule 2532 (Zombies) by:
- appending "A player CAN, without 3 objections, flip eir own master switch
    to any other player. Other players SHOULD NOT object unless they believe
    that the intent is part of an attempt to flood Agora with the undead."
- inserting "- flip eir master switch;" in the list after the first item
- replacing "A zombie's master CAN flip that zombie's master switch to
    Agora by announcement." with "A zombie's master CAN flip that zombie's
    master switch to Agora or to any player who does not own any zombies by
    announcement."; and
- replacing "resale value" with "integrity".

Amend Rule 2574 (Zombie Life Cycle) by:
- replacing the first two paragraphs with: {
  Any player CAN, with notice, putrefy player who has not made a public
  announcement in the past 60 days. When a player is putrefied:
    - if e is not a zombie, eir master switch is flipped to Agora; and then
    - eir integrity is set to 2.

  Integrity is a secured switch for zombies, tracked by the Registrar, with
  possible values of the natural numbers and "well-maintained" (default). If
  an integrity switch would be modified in a manner that assumes it is
  already a number, such as to increase or decrease it, such a modification
  leaves "well-maintained" as-is. Whenever a zombie's master switch is
  flipped from Agora to a player other than emself, eir integrity is
  decreased by 1. At the end of a zombie auction, every zombie that is an
  excess lot in that auction has eir integrity decreased by 1.
};
- inserting "- if a zombie is master to another zombie, flipping the second
    zombie's master switch to Agora;" after the second item in the list; and
- replacing "resale value" with "integrity" throughout the rule.

Amend Rule 1885 (Zombie Auctions) by:
- replacing "resale value" with "integrity";
- appending "When the winner of a zombie auction pays Agora to fulfill eir
    obligation to satisfy eir bid, the coins so transferred are immediately
    transferred into trust for the zombie."

Create a new power-2 Rule entitled "Zombie Trusts":
{
  Each zombie has a zombie trust, an entity referred to as the "<zombie name>
  Trust". To place assets "in trust" to a zombie is to transfer those assets
  to that zombie's trust, and similarly for other similar language.

  When an active player becomes a zombie, all of eir coins are transferred
  into eir zombie trust unless e flipped eir master switch emself and
  specified otherwise in the same message. Whenever a zombie becomes active,
  all coins held in trust for em are transferred to em immediately before eir
  trust ceases to exist.
}"""
            )
        }

        proposal(8318) {
            title("Notorial Economy")
            ai(1.0)
            author(Aris)

            text(
                """
If the Notary's Interest is the empty set, change it to [Economy]."""
            )
        }

        proposal(8319) {
            title("Sergeant-at-Arms")
            ai(2.0)
            author(Aris)

            text(
                """
Amend the rule entitled "Ministries" by changing the text
"Interest is an office switch" to read "Interest is secured office switch".

Amend the rule entitled "Proposal Classes" by changing the text
"an untracked Class switch" to read "a secured untracked Class switch".

Amend the rule entitled "Proposal Chambers" by changing the text
"Chamber is an untracked ordinary proposal switch" to read
"Chamber is a secured untracked ordinary proposal switch".

[As is, a power 1 proposal can flip interest, giving a certain officer
infinite votes. This potentially allows for escalation of a power 1
dictatorship. The others are secured out of an abundance of caution.]"""
            )
        }

        proposal(8320) {
            title("Promotorial Assignment")
            ai(2.0)
            author(Aris)

            text(
                """
Amend the rule entitled "Proposal Chambers" by adding the text
"If a proposal in the Proposal Pool has its chamber unset, the Promotor
CAN set the chamber to a specified ministry by announcement." at the beginning
of the last paragraph."""
            )
        }

        proposal(8321) {
            title("Untying Quorum")
            ai(2.0)
            author(Aris)

            text(
                """
Amend Rule 879, "Quorum", by deleting the text "(breaking ties upward)".

[This has been bothering me for ages; I added this, but ties are impossible
with a 2/3, so this is just confusing (and has lead to confusion on at
least one proposal).]"""
            )
        }
    }

    voting {
        votes(Aris) {
            FOR on 8308
            AGAINST on 8309
            PRESENT on 8310
            FOR on 8311
            AGAINST on 8312
            AGAINST on 8313
            FOR on 8314
            endorse(offices[Assessor]!!) on 8315
            PRESENT on 8316
            AGAINST on 8317
            FOR on 8318
            FOR on 8319
            FOR on 8320
            FOR on 8321
        }

        votes(Gaelan) {
            FOR on 8308
            AGAINST on 8309
            FOR on 8310
            FOR on 8311
            AGAINST on 8312
            FOR on 8313
            FOR on 8314
            endorse(Alexis) on 8315
            FOR on 8316
            FOR on 8317
            FOR on 8318
            FOR on 8319
            FOR on 8320
            FOR on 8321
        }

        votes(omd) {
            AGAINST on 8308
            AGAINST on 8309
            PRESENT on 8310
            FOR on 8311
            AGAINST on 8312
            PRESENT on 8313
            FOR on 8314
            AGAINST on 8315
            PRESENT on 8316
            FOR on 8317
            PRESENT on 8318
            FOR on 8319
            FOR on 8320
            FOR on 8321
        }

        votes(Falsifian) {
            FOR on 8308
            AGAINST on 8309
            AGAINST on 8310
            // TODO resolve conditional votes on 8311: AGAINST IF VETO ELSE endorse twg
            AGAINST on 8312
            AGAINST on 8313
            // TODO resolve conditional votes on 8314: AGAINST IF VETO ELSE FOR
            AGAINST on 8315
            AGAINST on 8316
            AGAINST on 8317
            // TODO resolve conditional votes on 8318: AGAINST IF VETO ELSE endorse Aris
            endorse(Aris) on 8319
            endorse(Aris) on 8320
            endorse(Aris) on 8321
        }

        votes(twg) {
            endorse(Falsifian) on 8308
            AGAINST on 8309
            PRESENT on 8310
            FOR on 8311
            AGAINST on 8312
            AGAINST on 8313
            endorse(Aris) on 8314
            // TODO resolve conditional vote on 8315: If a proposal has been submitted (since I cast this vote) that would amend Rule 2034 (Vote Protection and Cutoff for Challenges) by reintroducing the text "it had the number of voters indicated", then Endorse Alexis; otherwise AGAINST
            AGAINST on 8316
            endorse(Alexis) on 8317
            endorse(Aris) on 8318
            endorse(Aris) on 8319
            endorse(Aris) on 8320
            endorse(Aris) on 8321
        }

        votes(Bernie) {
            endorse(twg) on all
        }
    }
}
