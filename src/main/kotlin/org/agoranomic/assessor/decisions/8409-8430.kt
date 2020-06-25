package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeJune3.*
import org.agoranomic.assessor.dsl.ministries.ministriesJun03
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.Ministry.*
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8409 to 8430`() = assessment {
    name("8409-8430")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013796.html")
    quorum(7)

    val offices = officeMapOf(
        ADoP to RLee,
        Arbitor to G,
        Assessor to Jason,
        Distributor to omd,
        Herald to PSS,
        Notary to null,
        PrimeMinister to Aris,
        Promotor to Aris,
        Referee to PSS,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to Trigon,
        Tailor to PSS,
        Treasuror to Trigon,
        Webmastor to nch
    )

    strengths {
        default(3)
        min(0)
        max(15)

        ministriesJun03(offices, allProposals)
        addToHolder(offices, Speaker, 1)
    }

    proposals(v1) {
        proposal(8409) {
            title("College of Letters, Arts, and Sciences")
            ai("3.0")
            author(Aris)
            democratic()

            text(
                """
[I fixed the problems pointed out with the last version. I also added an
A.N.A. degree (I hadn't done so previously, because I thought it was
unnecessary, but exceptions are messy). I rephrased and reordered some things
too.]

Amend Rule 1367, "Degrees", by changing it to read as follows:

Certain patent titles are known as degrees. The degrees are

  - Associate of Nomic Artistry        (A.N.A.)
  - Associate of Nomic                 (A.N.)
  - Juris Doctorate of Nomic           (J.N.)
  - Baccalaureate of Nomic Artistry    (B.N.A.)
  - Baccalaureate of Nomic             (B.N.)
  - Magisteriate of Nomic Artistry     (M.N.A)
  - Magisteriate of Nomic              (M.N.)
  - Doctorate of Nomic Artistry        (D.N.Art.)
  - Doctorate of Nomic History         (D.N.Hist.)
  - Doctorate of Nomic Law             (D.N.Law.)
  - Doctorate of Nomic Science         (D.N.Sci.)
  - Doctorate of Nomic Philosophy      (D.N.Phil.)

  There are four classes of degrees, ranked in ascending order of merit:
  Associate degrees (A.N.A. and A.N.), Baccalaureate degrees
  (J.N through B.N.), Magisteriate degrees (M.N.A and M.N), and
  Doctorate degrees (D.N.Art. through D.N.Phil.).

  A specified degree CAN be awarded by any player other than the
  awardee, with 2 Agoran consent. It SHOULD only be awarded for the
  publication of an original thesis of scholarly worth (including
  responses to peer-review), published with explicit intent to
  qualify for a degree. The Herald SHOULD coordinate the peer-review
  process and the awarding of degrees.

  Degrees SHOULD be awarded according to the extent to which the thesis
  contributes to Nomic culture or thought: Associate degrees for an
  appreciable contribution, Baccalaureate degrees for a substantial
  contribution, Magisteriate degrees for a remarkable contribution, and
  Doctorate degrees for an exceptional contribution. Any degree at the
  Doctorate level SHOULD take into account the awardee's academic history
  and participation in Agora over time.

  Theses for Artistry degrees SHOULD demonstrate substantial creativity
  and need not be in written form. Theses for all other degrees SHOULD
  demonstrate substantial research or analysis. J.N. and D.N.Law are
  appropriate for high-quality legal analysis, of the sort typical to CFJs,
  but exceeding an ordinary CFJ in depth. The D.N.Hist. degree is
  appropriate for historical research, especially when it presents a
  narrative that educates Agorans about the events of the past. The D.N.Sci.
  degree is appropriate for theses that demonstrate concrete or scientific
  thinking, whereas the D.N.Phil. is appropriate for theses that demonstrate
  abstract or philosophical thinking.

Rename every instance of the first listed patent title on each row to the
second listed patent title on each row:

- Juris Doctor of Nomic, Juris Doctorate of Nomic
- Doctor of Nomic History, Doctorate of Nomic History
- Doctor of Nomic Law, Doctorate of Nomic Law
- Doctor of Nomic Science, Doctorate of Nomic Science
- Doctor of Nomic Philosophy, Doctorate of Nomic Philosophy"""
            )
        }

        proposal(8410) {
            title("Promise Powers Patch")
            ai("2.2")
            author(Aris)
            chamber(Economy)

            text(
                """
[There was a bug in my original version (in the sense of it doing something
other than what I intended); I solved the problem of people acting on behalf of
their zombies to enter promises by putting an "acting as emself" requirement,
forgetting that this also affected contracts and stopped promises from
creating other promises. This proposal remedies my error.]

Amend the rule entitled "Promises" by deleting the text "acting as emself, ".

Amend Rule 2532, "Zombies", by changing the text

  "- enter a contract, pledge, or other type of agreement"

to read

  "- enter a contract, pledge, promise, or other type of agreement""""
            )
        }

        proposal(8411) {
            title("Contract Lawyers")
            ai("1.0")
            author(RLee)
            chamber(Participation)

            text(
                """
Amend Rule 2581 "Official Patent Titles" by appending the following
list item at the end of the list items but before the last paragraph
  {- Terms of Service, awardable by the Notary to any player who creates
  multiple Contracts that achieve fun gameplay and significantly impacts
  Agora as a whole}"""
            )
        }

        proposal(8412) {
            title("Small Pledge Amendments")
            ai("1.7")
            author(RLee)
            chamber(Justice)

            text(
                """
Amend rule 2450 "Pledges" by inserting the following sentence after
the words "explicitly states otherwise":
  {It is also Oathbreaking for a player to let a pledge expire without taking
  an action e pledged to do in that pledge.}

  Also amend the same rule by replacing the text
  {and should do so if and only if the pledge no longer serves any
  significant purpose.}
  with the new text
  {but SHOULD NOT do so unless the pledge no longer serves any significant
  purpose.}

  [Nonbinding comment: The first one is a very common type of pledge but I'm
  worried that they are unenforceable. This does not extend the time limit
  forever because it is a crime for the pledge to expire and there is a
  universal 14-day statute of limitations from that point. The second
  amendment is just to capitalize something that should be capitalised and
  make the sentence a bit better]"""
            )
        }

        proposal(8413) {
            title("Why Track Pendency?")
            ai("1.0")
            author(Aris)
            chamber(Legislation)

            text(
                """
[Currently, Sets would make me track proposals forever. The simplest
fix is just to make the Pended switch untracked. It'll end up getting
effectively tracked anyway, since it determines whether a proposal must
be distributed.]

Amend the rule entitled "Pending Proposals" by changing the text "Pended is a
negative boolean proposal switch tracked by the Promotor." to read
"Pended is an untracked negative boolean proposal switch.""""
            )
        }

        proposal(8414) {
            title("Ministerial Reshuffling")
            ai("2.0")
            author(Aris)
            chamber(Legislation)

            text(
                """
Amend Rule 2605, "Ministries", by changing the lettered list to read:

  A. Ministry of Economy: regulate the economy
  B. Ministry of Efficiency: maximize official efficiency
  C. Ministry of Justice: serve justice
  D. Ministry of Legislation: effectuate legislation
  E. Ministry of Participation: encourage participation"""
            )
        }

        proposal(8415) {
            title("Proposal Recycling Initiative")
            ai("3.0")
            author(Aris)
            democratic()

            text(
                """
[This helps for any proposals that either were distributed before the new
regime and failed quorum, or any proposals that are accidentally distributed
and failed quorum. While I'm at it, there's no reason this needs to be at
power 3.0.]

Amend Rule 2350, "Proposals", by deleting the text:
  If a decision of whether to adopt a proposal was resolved as
  FAILED QUORUM in the last seven days, the Promotor CAN once add
  the proposal back to the Proposal Pool by announcement.

Enact a new rule entitled "Proposal Recycling", with the following text:

  If a decision of whether to adopt a proposal was resolved as
  FAILED QUORUM in the last seven days, the Promotor CAN once recycle
  the proposal by announcement, adding it to the Proposal Pool and causing
  it to become pended."""
            )
        }

        proposal(8416) {
            title("Identity theft protection act v1.1")
            ai("3.1")
            author(Falsifian)
            coauthors(G, PSS)
            democratic()

            text(
                """
Amend Rule 2141 by replacing the text

  Rules have ID numbers, to be assigned by the Rulekeepor.

with

  Every rule shall have an ID number, distinct among current and
  former rules, to be assigned once by the Rulekeepor.

[Comment: this version is designed to prevent the Rulekeepor from
assigning the same ID to two rules in addition to the protection
against changing IDs.]"""
            )
        }

        proposal(8417) {
            title("Properly Prioritized Popular Proposal Proposer Privilege")
            ai("1.0")
            author(Aris)
            coauthors(G)
            chamber(Legislation)

            text(
                """
[I've gone with making this an "honest" popularity system, not affected
by manipulatable mechanics such as proposal strength.]

Amend the rule entitled "Popular Proposal Proposer Privilege"
by changing it to read in full:

  For an Agoran decision on whether to adopt a proposal, let F be the total
  number of valid ballots resolving to FOR, A be the same for AGAINST,
  and T be the total number of valid ballots. The decision's popularity
  is equal to (F - A)/T. The Assessor SHOULD publish the popularity of each
  decision when resolving it.


  The player who proposed the adopted proposal such that the decision on whether
  to adopt it had the greatest popularity, among all such decisions assessed in
  the last 7 days CAN once earn one Legislative Card by announcement, provided
  that no decision on whether to adopt any proposal distributed in the same
  message remains unresolved. If there is a tie, all authors of the tied
  proposals can do so once each."""
            )
        }

        proposal(8418) {
            title("Referenda")
            ai("3.0")
            author(Aris)
            democratic()

            text(
                """
Amend Rule 1607, "Distribution", by replacing:

  Determining whether to adopt a proposal is an Agoran decision. For
  this decision, the vote collector is the Assessor, the adoption
  index is initially the adoption index of the proposal, or 1.0 if
  the proposal does not have one, and the text, author, coauthors,
  class and (if applicable) chamber of the proposal are essential
  parameters. Initiating such a decision is known as distribution,
  and removes the proposal from the Proposal Pool.

with:

  A referendum is the Agoran decision to determine whether to adopt a proposal.
  For this decision, the vote collector is the Assessor, the adoption index is
  initially the adoption index of the proposal, or 1.0 if the proposal does not
  have one, and the text, author, coauthors, class and (if applicable) chamber
  of the proposal are essential parameters. Initiating a referendum is known
  as distribution, and removes the proposal from the Proposal Pool.

Amend Rule 2606, "Proposal Classes", by changing the text "Agoran decision on
its adoption" to read "referendum on it".

Amend Rule 2607, "Proposal Chambers", by changing the text "Agoran decision on
its adoption" to read "referendum on it".

Amend Rule 106, "Adopting Proposals", by changing the text "a decision about
whether to adopt a proposal" to read "a referendum on a proposal".

Amend Rule 879, "Quorum", by changing the text "the Agoran decision on whether
to adopt a proposal" to read "the referendum".

Amend Rule 2168, "Extending the voting period", by changing the text
"whether to adopt a proposal" to read "a referendum on a proposal".

Amend Rule 2496, Rewards, by changing the text "FOR the decision" to read
"FOR the referendum" and replacing:
  Resolving an Agoran Decision on whether to adopt a proposal,
  provided that no other Agoran Decision on whether to adopt that
  or any other proposal had been resolved earlier in that Agoran
  week: 5 coins (ADoP).
with:
  Resolving a referendum, provided that no other referendum had been resolved
  earlier in that Agoran week: 5 coins (ADoP).

Amend Rule 2438, "Ribbons", by changing the text "an Agoran Decision" to
read "a referendum".

If the proposal entitled "Properly Prioritized Popular Proposal Proposer
Privilege" has passed:
  Amend the Rule entitled "Popular Proposal Proposer Privilege" by changing it
  to read in full:
    For a referendum, let F be the total number of valid ballots resolving to
    FOR, A be the same for AGAINST, and T be the total number of valid ballots.
    The referendum's popularity is equal to (F - A)/T. The Assessor SHOULD
    publish the popularity of each referendum when resolving it.

    The player who proposed the adopted proposal whose referendum had
    the greatest popularity among all referenda assessed in the last 7 days CAN
    once earn one Legislative Card by announcement, provided that no referendum
    initiated in the same message as it remains unresolved. If there is a tie,
    all authors of the tied proposals can do so once each.
Otherwise:
  Amend the rule entitled "Popular Proposal Proposer Privilege" by
  changing the text "provided that no decision on whether to adopt any proposal
  distributed in the same message remains open." to read "provided that
  no referendum initiated in the same message remains open."

[Note: One of these will fail.]

Amend Rule 2350, "Proposals", by changing the text "If a decision of whether to
adopt a proposal was resolved as FAILED QUORUM in the last seven days"
to read "If a referendum on a proposal was resolved as FAILED QUORUM in the
last seven days".

Amend the rule entitled "Proposal Recycling" by changing "If a
decision of whether
to adopt a proposal was resolved as FAILED QUORUM in the last seven days"
to read "If a referendum on a proposal was resolved as FAILED QUORUM in the
last seven days"."""
            )
        }

        proposal(8419) {
            title("Executive Expansion")
            ai("2.0")
            author(Aris)
            chamber(Efficiency)

            text(
                """
Amend Rule 2451, "Executive Orders", to read in full:

  Once per week, except as otherwise forbidden by this rule, the
  current Prime Minister CAN issue a Cabinet Order by announcement
  to cause the effect specified by the order. The Prime Minister
  CANNOT issue the same executive order more than once in a month.

  The available Cabinet Orders are:

  - Certiorari: The Prime Minister assigns emself as judge
    of a specified open case.

  - Corram Vobis: The Prime Minister enters a specified case, the current
    judgement of which was assigned within the past quarter, into Moot.

  - Dive: The Prime Minister levies a fine of 2 on a
    specified player. Rules to the contrary notwithstanding, the
    reason for the fine MAY be any grievance held by the Prime
    Minister, not necessarily a violation of the rules, against the
    person to whom the fine is levied.

  - Imprimatur: The Prime Minister acts on behalf of the vote collector
    of an Agoran Decision to resolve that decision.

  - Manifesto: The Prime Minister distributes a specified
    proposal in the Proposal Pool.

  - Pardon: N of a person's blots are expunged, where N is the number
    of blots e received from a specified fine that has not previously been
    pardoned. This power SHOULD be used only when extraordinary factors counsel
    in favor of clemency, and any further mention of the fine SHOULD
    include the fact that it has been pardoned.

  - Reshuffle: The Prime Minister initiates elections for a specified
    set of elected offices."""
            )
        }

        proposal(8420) {
            title("Checks and balances")
            ai("2.0")
            author(G)
            chamber(Efficiency)

            text(
                """
Amend Rule 2451 (Executive Orders) by appending the following paragraph:

  If this rule is changed in any way, then in the 7 days
  following the change, any player CAN issue a Citizens'
  Recall by announcement.  Doing so causes the office of
  Prime Minister to become vacant, and then initiates an
  election for the office if one is not already ongoing."""
            )
        }

//        proposal(8421) {
//            title("Transmutation")
//            ai("2.0")
//            author(nch)
//            coauthors(Trigon)
//            chamber(Economy)
//
//            text(
//                """
//Enact a new Power=1 rule titled "Transmutation" with the text:
//
//  A player CAN pay 3 Cards (syn. transmute) to earn a Card of a
//  specified type."""
//            )
//        }

        proposal(8422) {
            title("No More Numbers!")
            ai("3.0")
            author(PSS)
            coauthors(G, Trigon, Aris, nch)
            democratic()

            text(
                """
Remove the text ", as described in Rule 478" from Rule 2139, "The Registrar".

Remove the text "as described in Rule 1789" from Rule 2139, "The Registrar".

Remove the text "identified in Rule 1728" in Rule 2595."""
            )
        }

        proposal(8423) {
            title("Removing Repetition")
            ai("2.0")
            author(PSS)
            coauthors(G)
            chamber(Efficiency)

            text(
                """
Remove the final paragraph and all included list items from Rule 2139,
"The Registrar"."""
            )
        }

        proposal(8424) {
            title("Certifiable Patches")
            ai("1.0")
            author(Aris)
            coauthors(nch, PSS)
            chamber(Legislation)

            text(
                """
[This may be over-clear, but should be CFJ proof.]

Enact a new power 1.0 rule, entitled "Certifiable Patches", with the following
text:
  Any player CAN, by announcement, certify a specified proposal (as a patch),
  causing it to become pending.

  A player SHALL NOT certify a proposal unless its sole function is to
  minimally rectify a bug, error, or ambiguity (a problem) that relates
  to a) an office e holds; or b) a CFJ, open within the last week, of which
  e is the judge. Certifying a proposal in violation of this paragraph
  is the Class-4 Crime of Uncertain Certification. A player certifying a
  proposal SHOULD explain why doing so does not violate this paragraph.

  For the purposes of this rule:

  1. A bug is a situation in which a rule operates in a way that is clearly
     contrary to legislative intent or common sense.
  2. An error is a change introduced by apparent mistake, such as the
     self-ratification of an incorrect report or a typo in a rule amendment.
  3. An ambiguity is a state of affairs in which reasonable players could
     disagree about the operation of the rules or the state of a rule defined
     property.
  4. A minimal rectification is one that resolves the problem without doing
     substantially more than is necessary to resolve it. For instance,
     rectification that uses more slightly words than necessary to resolve the
     problem may still be minimal, whereas a rectification that makes rule
     changes unrelated to fixing the problem would not be.
  5. A problem relates to an office if it plausibly affects the area of
     the game the office is responsible for and relates to a CFJ if it
     could plausibly be interpreted to affect that CFJ's outcome."""
            )
        }

        proposal(8425) {
            title("Impossibility Defense")
            ai("2.0")
            author(Aris)
            chamber(Justice)

            text(
                """
Amend 2531, "Defendant's Rights", by adding the following after item (2)
of the second numbered list:

  (3) it attempts to levy a fine on a person for failure to take an action
      that e, through no fault of eir own, COULD NOT have performed;
  (4) it attempts to levy a fine on a person for conduct that e, through
      no fault of eir own, was obliged to undertake by a rule of equal
      or greater power to the one e violated;
and renumbering the list accordingly."""
            )
        }

        proposal(8426) {
            title("Impracticability Defense")
            ai("2.0")
            author(Aris)
            chamber(Justice)

            text(
                """
Amend 2531, "Defendant's Rights", by adding the following to the second
numbered list as a new item immediately before the item beginning
"it attempts to levy a fine with a value":
  "it attempts to levy a fine on a person taking an action or inaction e could
  not have avoided when exercising the highest reasonably possible standard
  of care;""""
            )
        }

        proposal(8427) {
            title("Slap on the wrist")
            ai("2.0")
            author(RLee)
            chamber(Justice)

            text(
                """
Amend rule 2555 "Blots" by replacing the text "To levy a fine of N
on a person, where N is a positive integer, is to grant em N blots." with
the text "To levy a fine of N on a person, where N is a positive integer or
zero, is to grant em N blots""""
            )
        }

        proposal(8428) {
            title("Pending Pends")
            ai("3.0")
            author(Aris)
            democratic()

            text(
                """
[This restores my ability to backdate.]

Amend Rule 1607, "Distribution", by replacing:

  In a given Agoran week, the Promotor SHALL distribute each
  pending proposal that was in the Proposal Pool at the beginning
  of that week, except for those excepted from automatic
  distribution by other rules, or those that are otherwise removed
  from the Pool.

with:

  In a given Agoran week, the Promotor SHALL distribute each
  proposal that was in the Proposal Pool and pending at the beginning
  of that week, except for those excepted from automatic
  distribution by other rules, or those that are otherwise removed
  from the Pool."""
            )
        }

        proposal(8429) {
            title("Why Limit Clemency?")
            ai("1.7")
            author(Aris)
            chamber(Justice)

            text(
                """
[This removes the arbitrary three blot limit on apology clemency.]

Amend Rule 2557, "Removing Blots", by replacing:

  Optionally, in the same message in which e imposes justice, the
  investigator CAN specify that the violation is forgivable,
  specifying up to 10 words to be included in an apology.  If the
  investigator does so, the perp CAN, in a timely fashion, expunge P
  blots from emself, where P is the minimum of the value of the fine
  and 3, by publishing a formal apology of at least 200 words and
  including all the specified words, explaining eir error, shame,
  remorse, and ardent desire for self-improvement.

with:

  Optionally, in the same message in which e imposes justice, the
  investigator CAN specify that the violation is forgivable,
  specifying up to 10 words to be included in an apology.  If the
  investigator does so, the perp CAN, in a timely fashion, expunge P
  blots from emself, where P is the value of the fine, by publishing a
  formal apology of at least 200 words and including all the specified words,
  explaining eir error, shame, remorse, and ardent desire for
  self-improvement."""
            )
        }

        proposal(8430) {
            title("Silver Quill 2016")
            ai("2.0")
            author(PSS)
            coauthors(G)
            chamber(Participation)

            text(
                """
ais523 is awarded the patent title of Silver Quill for the year 2016
for eir proposal, "Winning by apathy"."""
            )
        }
    }

    voting {
        votes(RLee) {
            PRESENT on 8409
            FOR on 8410
            FOR on 8411
            FOR on 8412
            FOR on 8413
            AGAINST on 8414
            FOR on 8415
            FOR on 8416
            FOR on 8417
            FOR on 8418
            AGAINST on 8419
            AGAINST on 8420
            // FOR on 8421
            FOR on 8422
            FOR on 8423
            AGAINST on 8424
            AGAINST on 8425
            AGAINST on 8426
            FOR on 8427
            FOR on 8428
            AGAINST on 8429
            FOR on 8430
        }

        votes(Tcbapo) {
            endorse(RLee) on all
        }

        votes(Aris) {
            FOR on 8409
            FOR on 8410
            FOR on 8411
            FOR on 8412
            FOR on 8413
            FOR on 8414
            FOR on 8415
            FOR on 8416
            FOR on 8417
            FOR on 8418
            FOR on 8419
            AGAINST on 8420
            // FOR on 8421
            FOR on 8422
            AGAINST on 8423
            FOR on 8424
            FOR on 8425
            FOR on 8426
            FOR on 8427
            FOR on 8428
            FOR on 8429
            FOR on 8430
        }

        votes(Trigon) {
            FOR on 8409
            PRESENT on 8410
            FOR on 8411
            PRESENT on 8412
            FOR on 8413
            AGAINST on 8414
            FOR on 8415
            FOR on 8416
            PRESENT on 8417
            AGAINST on 8418
            AGAINST on 8419
            AGAINST on 8420
            // FOR on 8421
            FOR on 8422
            FOR on 8423
            PRESENT on 8424
            FOR on 8425
            FOR on 8426
            FOR on 8427
            FOR on 8428
            FOR on 8429
            FOR on 8430
        }

        votes(PSS) {
            FOR on 8409
            FOR on 8410
            FOR on 8411
            AGAINST on 8412
            FOR on 8413
            FOR on 8414
            FOR on 8415
            FOR on 8416
            FOR on 8417
            FOR on 8418
            FOR on 8419
            FOR on 8420
            // FOR on 8421
            FOR on 8422
            PRESENT on 8423
            FOR on 8424
            FOR on 8425
            FOR on 8426
            FOR on 8427
            FOR on 8428
            FOR on 8429
            FOR on 8430
        }

        votes(nch) {
            FOR on 8409
            FOR on 8410
            FOR on 8411
            FOR on 8412
            FOR on 8413
            PRESENT on 8414
            PRESENT on 8415
            FOR on 8416
            FOR on 8417
            PRESENT on 8418
            AGAINST on 8419
            FOR on 8420
            // FOR on 8421
            FOR on 8422
            AGAINST on 8423
            AGAINST on 8424
            PRESENT on 8425
            PRESENT on 8426
            FOR on 8427
            PRESENT on 8428
            PRESENT on 8429
            FOR on 8430
        }

        votes(Jason) {
            FOR on 8409
            FOR on 8410
            PRESENT on 8411
            AGAINST on 8412
            FOR on 8413
            FOR on 8414
            FOR on 8415
            FOR on 8416
            FOR on 8417
            PRESENT on 8418
            FOR on 8419
            PRESENT on 8420
            // FOR on 8421
            FOR on 8422
            FOR on 8423
            FOR on 8424
            FOR on 8425
            PRESENT on 8426
            FOR on 8427
            FOR on 8428
            FOR on 8429
            FOR on 8430
        }

        votes(Falsifian) {
            FOR on 8409
            FOR on 8410
            FOR on 8411
            AGAINST on 8412
            FOR on 8413
            FOR on 8414
            FOR on 8415
            FOR on 8416
            FOR on 8417
            PRESENT on 8418
            FOR on 8419
            FOR on 8420
            // FOR on 8421
            FOR on 8422
            FOR on 8423
            FOR on 8424
            PRESENT on 8425
            PRESENT on 8426
            AGAINST on 8427
            FOR on 8428
            PRESENT on 8429
            FOR on 8430
        }

        votes(ATMunn) {
            FOR on 8409
            FOR on 8410
            FOR on 8411
            AGAINST on 8412
            FOR on 8413
            PRESENT on 8414
            FOR on 8415
            FOR on 8416
            FOR on 8417
            PRESENT on 8418
            FOR on 8419
            FOR on 8420
            // FOR on 8421
            FOR on 8422
            FOR on 8423
            PRESENT on 8424
            FOR on 8425
            FOR on 8426
            PRESENT on 8427
            PRESENT on 8428
            FOR on 8429
            FOR on 8430
        }

        votes(CuddleBeam) {
            FOR on all
        }

        votes(G) {
            FOR on 8409
            AGAINST on 8410
            FOR on 8411
            FOR on 8412
            PRESENT on 8413
            PRESENT on 8414
            FOR on 8415
            FOR on 8416
            FOR on 8417
            FOR on 8418
            FOR on 8419
            FOR on 8420
            // AGAINST on 8421
            FOR on 8422
            FOR on 8423
            AGAINST on 8424
            FOR on 8425
            FOR on 8426
            AGAINST on 8427
            FOR on 8428
            FOR on 8429
            FOR on 8430
        }

        votes(twg) {
            endorse(G) on all
        }
    }
}
