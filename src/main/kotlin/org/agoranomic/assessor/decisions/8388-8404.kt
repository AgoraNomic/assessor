package org.agoranomic.assessor.decisions

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.*
import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV1.*
import org.agoranomic.assessor.lib.proposal.ProposalNumber
import org.agoranomic.assessor.lib.proposal.proposal_set.get
import org.agoranomic.assessor.lib.proposal.proposal_set.proposalSetOf
import org.agoranomic.assessor.lib.proposal.proposal_set.toProposalSet
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8388to8404() = assessment {
    name("8388-8404")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013727.html")
    quorum(8)

    val officesInitial = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Comptrollor to null,
        Distributor to omd,
        Herald to PSS,
        Notary to RLee,
        PrimeMinister to Aspen,
        Promotor to Aspen,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to Trigon,
        Tailor to PSS,
        Treasuror to Trigon
    )

    val offices =
        officesInitial
            .toMap()
            .mapKeys { (k, _) -> Office_2020_06_03_Webmastor.fromInitial(k) }
            .toPersistentMap()
            .mutate { it[Office_2020_06_03_Webmastor.Webmastor] = OfficeState.heldBy(nix) }
            .toOfficeMap()

    strengths {
        default(3)
        min(0)
        max(15)

        // HISTORICAL ERROR: P8400 was adopted, removing Comptrollor. This would affect the interests of P8401-8404.
        // This cannot be reflected in the source code as the results have self-ratified. Thus, this code will remain
        // unchanged in order to preserve the accuracy of the Assessor online archive.

        ministries_2020_04_02(officesInitial, proposalSetOf(allProposals[ProposalNumber(8388)]))

        ministries_2020_06_03_Webmastor(
            offices,
            (allProposals.numbers() - ProposalNumber(8388)).map { allProposals[it] }.toProposalSet()
        )

        addToHolder(offices, Office_2020_06_03_Webmastor.Speaker, 1)
    }

    proposals(v1) {
        proposal(8388) {
            title("The Webmastor")
            ai("1.0")
            author(nix)
            chamber(Efficiency)

            text(
                """
Enact a rule titled "The Webmastor" with Power=1 and the following text:

  The Webmastor is an office.

  The Webmastor's monthly report includes a Directory, a Changelog, a
  Warning Log, and an Error Log. The Directory lists notable
  currently maintained public resources. The Changelog lists notable
  changes to resources. The Warning Log lists notable potential
  issues, such as inaccurate or aging resources or unintended issues
  with a public resource. The Error Log lists notable losses of
  resources - where a resource has become inaccessible, unmaintained,
  or unusable. Where 'notable' is used in this rule its meaning is up
  to the Webmastor's discretion."""
            )
        }

        proposal(8389) {
            title("Just Impeach instead")
            ai("2.0")
            author(G)
            chamber(Efficiency)

            text(
                """
Amend Rule 2531 by deleting:
  If the Referee attempts to levy three or more INEFFECTIVE fines
  in a week, any player CAN, with two support, issue a writ of
  Impartial Arbitration Restoration, immediately making the
  position of Referee vacant. When a writ of Impartial Arbitration
  Restoration is issued, the ADoP SHALL initiate an election for
  the Referee in a timely fashion.

[context:  When this was written, there were very few protections in this
rule, and general impeachment didn't exist.  Now with the full list of
protections the Referee is pretty constrained, and impeachment exists.]"""
            )
        }

        proposal(8390) {
            title("Registror")
            ai("3.0")
            author(RLee)
            democratic()

            text(
                """
Retitle the rule 2139 "The Registrar" to "The Registror"
Amend each rule that contains the text "Registrar" by replacing that text
with "Registror"
(This informational segment in brackets has no legal effects. A list of
those rules as this proposal is written for your information is rules 869,
478, 2139, 1789, 2532, 2574, 1885, 2581)"""
            )
        }

        proposal(8391) {
            title("Notory (Vote Labour)")
            ai("3.0")
            author(RLee)
            democratic()

            text(
                """
Retitle rule 2608 "The Notary" to "The Notory"
Amend rules 2608 and 2450, and also any other rule that contains the text
"Notary", by replacing the word "Notary" with "Notory""""
            )
        }

        proposal(8392) {
            title("Prior violations")
            ai("2.0")
            author(Jason)
            chamber(Justice)

            text(
                """
Amend Rule 2531 by changing the list item labeled (2) to read, in its
entirety:  "(2) it attempts to levy a fine for an action or inaction
which, at the time the inaction or action occurred, was not prohibited
by the rules;"

[This ensures that, as long as an action violated the rules when it was
committed, it can be punished. For instance, the Assessor could commit a
crime immediately before resolving a proposal that changes the
definition of the crime. Currently, it's possible the Assessor could not
be punished, since the rules at the time of the fine being levied would
not prohibit the action, even if it was illegal at the time it occurred.]"""
            )
        }

        proposal(8393) {
            title("Elections Aren't Over Till They End")
            ai("2.0")
            author(Aspen)
            chamber(Efficiency)

            text(
                """
[This avoids the weirdness where having two candidates means new candidates
can join, but if there are fewer the winner is locked in at the end
of the nomination period. This way, new contenders can still join as
long as there's still room for them to change the outcome.]

Amend Rule 2154, "Election Procedure", by changing the text:

  "An election is contested if it has two or more candidates at the
   end of the nomination period, and uncontested otherwise. For a
   contested election, nominations close at the end of the poll's
   voting period. For an uncontested election, nominations close at
   the end of the nomination period."

to read:

  "An election whose nomination period is complete is contested if it has two
   or more candidates, and uncontested otherwise. Nominations close
   at the end of the poll's voting period or when the election is ended,
   whichever comes first.""""
            )
        }

        proposal(8394) {
            title("8228 retry")
            ai("2.0")
            author(Jason)
            chamber(Efficiency)

            text(
                """
[This was originally proposed and adopted in Proposal 8228, but it
failed due to a specification bug. Zombies holding offices should be
banned because it allows people to bypass restrictions on Officers
performing actions that benefit themselves.]

Amend Rule 2472 ("Office Incompatibilities") by inserting the following
paragraph after the paragraph beginning "A player is overpowered if e
holds":

  A zombie is Overpowered if e holds one or more offices."""
            )
        }

        proposal(8395) {
            title("Editorial what?")
            ai("1.1")
            author(Jason)
            chamber(Legislation)

            text(
                """
Repeal rule 2599 (The Editor)."""
            )
        }

        proposal(8396) {
            title("Auction End Clarification")
            ai("1.0")
            author(grok)
            coauthors(G)
            chamber(Economy)

            text(
                """
Replace the first paragraph of rule 2551 Auction End with the following:

"An Auction ends immediately when any of the following conditions are met:

1. The auction was initiated 7 days ago.

2. The auction was initiated at least 96 hours ago, and it has been 96
hours since the most recent placement or withdrawal of a bid in that
auction.

3. The auction was initiated 96 hours ago and no bids have been placed
or withdrawn in that auction.

4. The auction is terminated.""""
            )
        }

        proposal(8397) {
            title("Referral")
            ai("2.0")
            author(PSS)
            chamber(Legislation)

            text(
                """
Amend Rule 2607, "Proposal Chambers", by appending the following paragraph:

  To refer a proposal to a ministry is to set the chamber of that
  proposal to the specified ministry."""
            )
        }

        proposal(8398) {
            title("More conservative implicit announcements")
            ai("3.0")
            author(Murphy)
            coauthors(nix, G)
            democratic()

            text(
                """
Amend Rule 478 (Fora) by appending this text:

  Stating that a person "CAN and SHALL" perform an action, without
  stating a method, implies "by announcement".

[R1023(1) already covers implicit "in a timely fashion".]

Amend Rule 2141 (Role and Attributes of Rules) by replacing this text:

  the Rulekeepor CAN and SHALL assign a title to it by announcement
  in a timely fashion.

with this text:

  the Rulekeepor CAN and SHALL assign a title to it.

Amend Rule 107 (Initiating Agoran Decisions) by replacing this text:

  The vote collector for a decision with less than two options
  CAN and SHALL end the voting period by announcement, if it has not
  ended already, and provided that e resolves the decision in the
  same message.

with this text:

  The vote collector for a decision with less than two options
  CAN and SHALL end the voting period, if it has not ended already,
  and provided that e resolves the decision in the same message.

Amend Rule 991 (Calls for Judgement) by replacing this text:

  When a CFJ's judge is unassigned, the Arbitor CAN assign any
  eligible player to be its judge by announcement, and SHALL do so
  in a timely fashion.

with this text:

  When a CFJ's judge is unassigned, the Arbitor CAN and SHALL assign
  any eligible player to be its judge.

Amend Rule 591 (Delivering Judgements) by replacing this text:

  When a CFJ is open and assigned to a judge, that judge CAN assign
  a valid judgement to it by announcement, and SHALL do so in a
  timely fashion after this becomes possible.

with this text:

  When a CFJ is open and assigned to a judge, that judge CAN and
  SHALL assign a valid judgement to it by announcement.

[Rules 2496 and 2602 use "CAN once" and "SHALL in an officially timely
fashion", so leaving those out for now.]"""
            )
        }

        proposal(8399) {
            title("E had two months!")
            ai("1.0")
            author(RLee)
            chamber(Justice)

            text(
                """
Repeal rule 2609 "Temporary CFJ setup""""
            )
        }

        proposal(8400) {
            title("Clinton v City of New York")
            ai("1.0")
            author(RLee)
            chamber(Legislation)

            text(
                """
Repeal rule 2597, "Line-item Veto""""
            )
        }

        proposal(8401) {
            title("Defense Against the Dark Arts")
            ai("1.0")
            author(Aspen)
            coauthors(PSS)
            chamber(Justice)

            text(
                """
Enact a new power 1.0 rule entitled "Defense Against the Dark Arts" with the
following text:
  A proposal is forbidden if it would, upon successfully taking effect,
  cause Agora to be ossified or to cease to exist.  An action is forbidden
  if it would, upon its successful occurrence, cause Agora to be ossified or to
  cease to exist.

  Attempting a forbidden action is PROHIBITED, and is the Class-4 Crime of
  Engaging in Forbidden Arts.

  Submitting a forbidden proposal is PROHIBITED, and is the Class-1 Crime of
  Contemplating Forbidden Arts.

  Being the author of an adopted forbidden proposal is PROHIBITED, and is the
  Class-2 Crime of Suborning Forbidden Arts.

  Having a final ballot that evaluates to FOR in the Agoran decision on whether
  to adopt a forbidden proposal is PROHIBITED, and is the Class-1 Crime of
  Abetting Forbidden Arts."""
            )
        }

        proposal(8402) {
            title("Promises")
            ai("3.0")
            author(Aspen)
            coauthors(Falsifian)
            democratic()

            text(
                """
Enact a new power 2.2 rule, entitled "Promises", with the following text:

  Promises are a class of assets, tracked by the Notary. Their essential
  attributes are their text and creator. A person CAN, by announcement,
  acting as emself, grant emself a promise, specifying its text and becoming its
  creator. A promise's owner is referred to as its bearer. Promises with the
  same text, creator, and bearer are fungible. Promises with the same text and
  creator SHOULD be referred to by the same title, but the title is not an
  essential attribute of the promise, just a way of referring to it.

  A promise's bearer CAN, by announcement, cash the promise,
  provided that any conditions for cashing it specified by its text are
  unambiguously met. By doing so, e acts on the creator of
  the promise's behalf, causing the creator to act as if e published the
  promise's text, and destroys the promise. The bearer SHOULD recite the
  promise's essential attributes in the same message e cashes it.

  In a promise's text, "the bearer" (or the like) refers to the promise's
  bearer, and "this promise" (or the like) refers to the promise. The text of
  the promise can refer to the context of the message in which it is cashed,
  but the context of the message does not otherwise change the meaning of
  the promise.

  The Library is an entity and CAN own promises. Any player CAN take a specified
  promise from the Library by announcement, provided e cashes the promise in the
  same message. Any player CAN revoke a specified promise from the Library
  without objection.


Amend Rule 2608, "The Notary", by changing the numbered list to read as
follows:

  1. every pledge, along with its title, creator, time window, time
     of creation, and time of expiry;
  2. every contract, with its title, full provisions, and parties; and
  3. every promise, along with its title, text, creator, and bearer.

Amend Rule 2466, "Acting on Behalf", by changing the text

  "A person CANNOT act on behalf of another person to do anything except
   perform a game action; in particular, a person CANNOT act on behalf of
   another person to send a message, only to perform specific actions that
   might be taken within a message."
to read
  "A person CANNOT act on behalf of another person to do anything except
   perform a game action; in particular, a person CANNOT act on behalf of
   another person to send a message, only to perform specific actions that
   might be taken within a message, including actions that would otherwise
   be taken by publishing certain text."

Amend Rule 2519, "Consent", by changing it to read in full:

  A person is deemed to have consented to an action if and only if,
  at the time the action took place:

    1. e, acting as emself, has publicly stated that e agrees to the
       action and not subsequently publicly withdrawn eir statement;
    2. e is party to a contract whose body explicitly and
       unambiguously indicates eir consent;
    3. the action is taken as part of a promise which e created; or
    4. it is reasonably clear from context that e wanted the
       action to take place or assented to it taking place."""
            )
        }

        proposal(8403) {
            title("1698 shortening")
            ai("4.0")
            author(Trigon)
            democratic()

            text(
                """
[ Comment: I'm not sure if it's intentional for "proposals" and "other
   changes to the gamestate" to be separate and have the same clause
   following them, but, assuming there's not, it couldn't hurt to cut
   down a bit on the repeated text. ]

Replace the following paragraph in Rule 1698 "Agora is a Nomic":

  If, but for this rule, the net effect of a proposal would cause
  Agora to become ossified, or would cause Agora to cease to exist,
  it cannot take effect, rules to the contrary notwithstanding. If
  any other single change or inseparable group of changes to the
  gamestate would cause Agora to become ossified, or would cause
  Agora to cease to exist, it is cancelled and does not occur, rules
  to the contrary notwithstanding.

with:

  If, but for this rule, the net effect of a single change or
  inseparable group of changes to the gamestate, including
  proposals, would cause Agora to become ossified, or would cause
  Agora to cease to exist, it cannot take effect, rules to the
  contrary notwithstanding."""
            )
        }

        proposal(8404) {
            title("High Crimes and Treason")
            ai("1.7")
            author(PSS)
            coauthors(G, Jason, Murphy)
            chamber(Justice)

            text(
                """
Amend Rule 2478 by appending the following text to the end of the rule:

  A high crime is any crime specified as being class 4 or greater.
  The Referee CANNOT levy the Cold Hand of Justice to punish a high
  crime, notwithstanding Rule 2478.

Amend Rule 2478 by amending the list to read in full:

  - Imposing the Cold Hand of Justice on the perp for the cited rule
    violation, as described elsewhere;

  - Issuing an Indictment against the perp for the cited rule
    violation, as described elsewhere; or

  - if e believes that no rules violation occurred or that it would
    be ILLEGAL or INEFFECTIVE to levy a fine for it, announcing the
    Finger Pointing to be Shenanigans.

Create a new AI-1.7 rule, "Indictment", with the following text:

  When the rules authorize an investigator to issue an Indictment
  for a violation, e CAN do so by announcement, specifying a fine of
  blots to be issued and the perpetrator and making an argument for
  the conviction of the accused.

  When an investigator has issued an Indictment, the perpetrator
  CAN state a defence. Within 10 days but no less than 4 days after
  the indictment has been issued, the judge SHALL initiate two Agoran
  Decisions, one to determine whether to convict the perpetrator and
  one to determine whether to accept the indictment. For these
  decision, the vote collector is the Judge and the voting method is
  AI-majority with AI=1.5. When initiating the decisions, the Judge
  SHALL, in the same message, publish the full texts of the
  Indictment and the defence. If both decisions are resolved as ADOPTED,
  the investigator CAN and SHALL impose the fine stated in the
  indictment. If the decision to convict is resolved as ADOPTED but the
  decision to accept is resolved as REJECTED, the investigator CAN issue
  a new Indictment. If the decision to convict is resolved as REJECTED,
  a fine SHALL NOT be imposed for the crime stated in the indictment.

  The Judge of the Indictment is the first of the following players
  who is neither the investigator nor the perp: the Arbitor, the
  Speaker, the Prime Minister. If this still fails to specify a
  player, then the Indictment lacks a Judge until that changes."""
            )
        }
    }

    voting {
        votes(PSS) {
            FOR on 8388
            FOR on 8389
            AGAINST on 8390
            AGAINST on 8391
            FOR on 8392
            endorseOfficer(offices, Office_2020_06_03_Webmastor.ADoP) on 8393
            FOR on 8394
            endorseOfficer(offices, Office_2020_06_03_Webmastor.Rulekeepor) on 8395
            FOR on 8396
            FOR on 8397
            AGAINST on 8398
            FOR on 8399

            if (offices[Office_2020_06_03_Webmastor.Comptrollor].isHeld())
                endorseOfficer(
                    offices,
                    Office_2020_06_03_Webmastor.Comptrollor
                ) on 8400 comment legacyConditionalComment("Comptrollor is held")
            else
                endorseOfficer(
                    offices,
                    Office_2020_06_03_Webmastor.ADoP
                ) on 8400 comment legacyConditionalComment("Comptrollor is vacant")

            FOR on 8401
            FOR on 8402
            AGAINST on 8403
            FOR on 8404
        }

        votes(Trigon) {
            FOR on 8388
            FOR on 8389
            AGAINST on 8390
            AGAINST on 8391
            FOR on 8392
            FOR on 8393
            FOR on 8394
            FOR on 8395
            FOR on 8396
            FOR on 8397
            AGAINST on 8398
            FOR on 8399
            FOR on 8400
            FOR on 8401
            PRESENT on 8402
            PRESENT on 8403
            PRESENT on 8404
        }

        votes(nix) {
            FOR on 8388
            FOR on 8389
            PRESENT on 8390
            PRESENT on 8391
            endorseOfficer(offices, Office_2020_06_03_Webmastor.Referee) on 8392
            FOR on 8393
            FOR on 8394
            FOR on 8395
            FOR on 8396
            PRESENT on 8397
            PRESENT on 8398
            FOR on 8399
            FOR on 8400
            FOR on 8401
            PRESENT on 8402
            AGAINST on 8403
            AGAINST on 8404
        }

        votes(RLee) {
            FOR on 8388
            FOR on 8389
            PRESENT on 8390
            FOR on 8391
            FOR on 8392
            FOR on 8393
            FOR on 8394
            FOR on 8395
            FOR on 8396
            AGAINST on 8397
            PRESENT on 8398
            FOR on 8399
            FOR on 8400
            FOR on 8401
            AGAINST on 8402
            AGAINST on 8403
            AGAINST on 8404
        }

        votes(Jason) {
            FOR on 8388
            FOR on 8389
            endorseOfficer(offices, Office_2020_06_03_Webmastor.Registrar) on 8390
            AGAINST on 8391
            FOR on 8392
            FOR on 8393
            FOR on 8394
            FOR on 8395
            FOR on 8396
            FOR on 8397
            AGAINST on 8398
            FOR on 8399
            PRESENT on 8400
            FOR on 8401
            FOR on 8402
            AGAINST on 8403
            FOR on 8404
        }

        votes(G) {
            FOR on 8388
            FOR on 8389
            AGAINST on 8390
            AGAINST on 8391
            FOR on 8392
            AGAINST on 8393
            FOR on 8394
            FOR on 8395
            FOR on 8396
            FOR on 8397
            AGAINST on 8398
            AGAINST on 8399
            AGAINST on 8400
            AGAINST on 8401
            PRESENT on 8402
            PRESENT on 8403
            PRESENT on 8404
        }

        votes(Falsifian) {
            endorse(nix) on 8388 comment NO_VETO
            endorse(G) on 8389
            AGAINST on 8390
            AGAINST on 8391
            endorse(Jason) on 8392
            endorse(Aspen) on 8393
            endorse(Jason) on 8394
            endorse(Jason) on 8395
            FOR on 8396 comment NO_VETO
            endorse(PSS) on 8397
            PRESENT on 8398
            endorse(RLee) on 8399 comment NO_VETO
            endorse(G) on 8400 comment NO_VETO
            PRESENT on 8401 comment NO_VETO
            endorse(Aspen) on 8402
            AGAINST on 8403
            PRESENT on 8404
        }

        votes(ATMunn) {
            FOR on 8388
            FOR on 8389
            AGAINST on 8390
            AGAINST on 8391
            FOR on 8392
            FOR on 8393
            FOR on 8394
            PRESENT on 8395
            FOR on 8396
            FOR on 8397
            FOR on 8398
            FOR on 8399
            PRESENT on 8400
            FOR on 8401
            PRESENT on 8402
            FOR on 8403
            FOR on 8404
        }

        votes(Aspen) {
            FOR on 8388
            FOR on 8389
            AGAINST on 8390
            AGAINST on 8391
            FOR on 8392
            FOR on 8393
            PRESENT on 8394
            AGAINST on 8395
            FOR on 8396
            FOR on 8397
            FOR on 8398
            PRESENT on 8399
            FOR on 8400
            FOR on 8401
            FOR on 8402
            FOR on 8403
            PRESENT on 8404
        }

        votes(Murphy) {
            FOR on 8388
            FOR on 8389
            AGAINST on 8390
            AGAINST on 8391
            FOR on 8392
            AGAINST on 8393
            FOR on 8394
            FOR on 8395
            FOR on 8396
            FOR on 8397
            FOR on 8398
            FOR on 8399
            FOR on 8400
            FOR on 8401
            FOR on 8402
            FOR on 8403
            FOR on 8404
        }
    }
}
