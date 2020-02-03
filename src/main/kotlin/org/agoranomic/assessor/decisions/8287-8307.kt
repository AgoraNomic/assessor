package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.UseAssessment
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8287 to 8307`() = assessment {
    name("8287-8307")
    quorum(5)

    strengths {
        default(3)

        // 8290 comes after 8291 because of a CoE
        val after8291 = ((8292..8307).toList() + 8290).map { ProposalNumber(it) }
        val before8291 = proposals.map { it.number } - after8291

        for (prop in before8291) {
            proposal(prop) {
                // Alexis was PM and thus had a bonus for all proposals
                Alexis strength 4
            }
        }

        for (prop in after8291) {
            proposal(prop) {
                // After 8291, the PM only gets a bonus for proposals with ministries, and the speaker gets a bonus for all
                G strength 4
            }
        }
    }

    proposals {
        proposal(8287) {
            title("Blot Stabilisation")
            ai(2.0)
            author(twg)

            text(
                """
/* Now that people can expunge each others' blots when they feel
 * an appropriate sentence has been served, blots don't tend to
 * stick around for more than a month or two, so there's not much
 * value in the quarterly blot decay.
 */

Amend Rule 2555, "Blots", by deleting the following paragraph:

  At the beginning of each quarter, half (rounded down) of each
  fugitive's blots are destroyed."""
            )
        }

        proposal(8288) {
            title("Glitteral")
            ai(1.0)
            author(omd)

            text(
                """
Amend Rule 2602 (Glitter) to read:

  Each time a player earns a type of Ribbon while already owning
  that type of Ribbon, e CAN, once within the next 7 days, claim a
  consolation prize by announcement.  Claiming a consolation prize
  causes em to earn N+1 coins, where N is the number of players
  that do not own the same type of Ribbon.

[Tried to make it as clear as possible without being excessively
verbose.  I split it into two sentences because the change in timing
of the antecedent would otherwise create ambiguity about when "N+1"
should be evaluated.]"""
            )
        }

        proposal(8289) {
            title("You're Banned from the Theater")
            ai(1.0)
            author(Alexis)

            text(
                """
Repeal Rule 2602 (Glitter)."""
            )
        }

        proposal(8290) {
            title("More Headroom")
            ai(3.0)
            author(G)

            text(
                """
[I went and looked - when we inflated base voting power from 1 to 3,
we kept the range 0-5, so we really deflated the range.  Going with
14, a little less than before].

Amend Rule 2422 (Voting Strength) by replacing:
  The voting strength of an entity on an Agoran decision is an
  integer between 0 and 5 inclusive
with:
  The voting strength of an entity on an Agoran decision is an
  integer between 0 and 14 inclusive"""
            )
        }

        proposal(8291) {
            title("Interesting Chambers v3.1")
            ai(3.0)
            author(Bernie)
            coauthors(Trigon, Aris, Gaelan, G, Jason, twg)

            text(
                """
[Enact a new Rule of Power 2.0, entitled "Ministries", with the following
text:

  A Ministry is an entity defined as such by this rule. Each
  Ministry has a goal. The Ministries of Agora, and their goals, are
  as follows:

   A. Ministry of Justice: serve justice to rulebreakers
   B. Ministry of Efficiency: see official duties performed swiftly
   C. Ministry of Legislation: see votes cast on proposals
   D. Ministry of Participation: reward players for achievements
   E. Ministry of Economy: encourage economic activity and contracts

  Interest is an office switch, tracked by the ADoP, whose possible
  values are lists of ministries, defaulting to the empty list. The
  ADoP CAN flip an office's interest without objection.

  For each item of each office's interest, that office's holder's
  voting strength is increased by 2 on proposals whose chamber is
  set to that ministry.


Enact a new Rule of Power 2.0, entitled "Proposal Classes", with the
following text:

  Proposals created since the enactment of this rule have an
  untracked Class switch with possible values ordinary (the default)
  and democratic.

  When a proposal with an adoption index greater than 2.0 is
  created, its class becomes democratic.

  Any player CAN, with 2 Agoran consent, flip an ordinary proposal's
  class to democratic, provided that it is in the Proposal Pool or
  that there is an Agoran decision on its adoption whose voting
  period has not yet ended.


Enact a new Rule of Power 2.0, entitled "Proposal Chambers", with the
following text:

  Chamber is an untracked ordinary proposal switch whose possible
  values include unset (the default) and each of the ministries of
  Agora.

  A proposal's chamber SHOULD only be decided by which ministry's
  goals it effects to the greatest degree.

  Any player CAN, with 2 Agoran consent, flip the chamber of an
  ordinary proposal to any ministry, provided that it is in the
  Proposal Pool or that there is an Agoran decision on its adoption
  whose voting period has not yet ended.


Amend Rule 1607, "Distribution", by changing "the text, author, and
coauthors of the proposal" to "the text, author, coauthors, class and
(if applicable) chamber of the proposal".


Amend Rule 2350, "Proposals", by adding the following to the list:

  * A chamber to which the proposal shall be assigned upon its
    creation.


Amend Rule 2422, "Voting Strength", by changing "between 0 and 5" to
"between 0 and 15".


// Move the PM's casting vote to the Speaker, since the PM already gets
// all ministries:

Amend Rule 2423, "First Among Equals", by removing the second paragraph.

Amend Rule 103, "The Speaker", by changing "For an election of the Prime
Minister, the Speaker" to "The Speaker".


Set the ADoP's Interest to [Efficiency].
Set the Arbitor's Interest to [Justice].
Set the Assessor's Interest to [Efficiency, Legislation].
Set the Herald's Interest to [Participation].
Set the Prime Minister's Interest to [Justice, Efficiency, Legislation,
  Participation, Economy].
Set the Promotor's Interest to [Legislation].
Set the Referee's Interest to [Justice].
Set the Registrar's Interest to [Efficiency].
Set the Rulekeepor's Interest to [Legislation, Participation].
Set the Tailor's Interest to [Participation].
Set the Treasuror's Interest to [Economy, Economy].

// Some of the above have been slightly rejigged given the new
// definition of Participation

/* Treasuror is given Economy twice for balance reasons:
 *  - It is a high-complexity office (was given Complexity=3 under
 *    Politics), like Assessor and Rulekeepor; this makes the power
 *    commensurate to the importance, and there is no ministry it really
 *    fits under besides Economy
 *  - It bumps up the number of voting increases issued for Economy
 *    proposals; all other ministries have 2-3 excluding the PM.
 * Not just trying to give myself votes, I swear :P
 */"""
            )
        }

        proposal(8292) {
            title("Self-Ratification Simplification Act")
            ai(3.0)
            author(Bernie)
            coauthors(twg)

            text(
                """
/* I don't recall any instances in modern times where a CFJ has been
   * used to explicitly doubt a document, and the behaviour is
   * replicable by citations anyway. So let's get rid of it, as it makes
   * R2201 significantly longer and also gives it two lists with the
   * same numbering scheme (always a headache).
   * This also clarifies that non-players are able to issue CoEs - this
   * was already possible (and may be useful as a protection against
   * accidental deregistrations from incorrect Registrar reports) but
   * was a bit non-obvious.
   */

Amend Rule 2201, "Self-Ratification", by replacing its text from
"A doubt is" to "cites the claim of error:" (inclusive) with the
following:

  Any person CAN by announcement issue a doubt (syn. claim of
  error), identifying a document and explaining the scope and nature
  of a perceived error in it (or in a statement it attests to).

  When this happens, the publisher of the original document SHALL
  (if e was required to publish that document) or SHOULD (otherwise)
  do one of the following in a timely fashion, in an announcement
  that clearly cites the claim of error:"""
            )
        }

        proposal(8293) {
            title("CFJ Bait")
            ai(1.0)
            author(Bernie)
            coauthors(twg)

            text(
                """
I register as a player.

I receive a Welcome Package.

I grant myself 9 coins.

I transfer 2 coins to Agora.
I transfer 2 coins to Proposal 8777.
I transfer 2 coins to Trigon.
I transfer 2 coins to the Lost and Found Department.

Notice of Honour:
+1 G. (giving twg the inspiration for my creation)
-1 nch (e's vanished, e doesn't need it)

I vote PRESENT on each Agoran decision whose voting is ongoing."""
            )
        }

        proposal(8294) {
            title("Authorial Intent")
            ai(3.0)
            author(Bernie)
            coauthors(twg)

            text(
                """
// Not actually expecting this to pass, at least not on first reading,
// but hopefully it will provoke some discussion.

Amend Rule 217, "Interpreting the Rules", by inserting "authorial
intent," after "past judgements,"."""
            )
        }

        proposal(8295) {
            title("Rewards Reform Act")
            ai(3.0)
            author(Bernie)
            coauthors(twg, Alexis)

            text(
                """
/* 1. Changes rewards to be issued by relevant officers (mostly ADoP,
   *    Arbitor) in their weekly reports, instead of calculated and
   *    claimed by individual players themselves.
   * 2. Effectively converts Glitter into a reward issued by the Tailor.
   *    (Players must still claim their Glitter by announcement, but the
   *    Tailor calculates the coin amounts and awards them all in
   *    weekly batches.)
   * 3. Makes all Ribbons (except White, Gray, Black) eligible for
   *    Glitter.
   */

Amend Rule 2496 ("Rewards") as follows:

  Replace its first two paragraphs with the following:

    Each time a player fulfills a reward condition, the officer
    associated with the condition CAN once, and SHALL before the end
    of the next Agoran week, grant the associated set of assets to the
    player.

    Below is a list of reward conditions and their associated assets
    and officers.

  Append "(Assessor)" to the first list item.

  Append "(Arbitor)" to the second list item.

  Append "(ADoP)" to the third list item.

  Append "(ADoP)" to the fourth list item.

  Append "(Herald)" to the fifth list item.


Amend Rule 2438 ("Ribbons") as follows:

  Replace the paragraph starting "While a person qualifies..." with
  the following:

    A person qualifies for a type of Ribbon if e has earned that type
    of Ribbon within the preceding 7 days (including earlier in the
    same message).

  [Removed the Gray and Transparent rephrasings as they were
   unnecessarily confusing and had minimal effect.]

  Move the list item starting "Emerald" so that it falls between the
  list items starting "Green" and "Cyan". [This was bothering me.]

  Append the following:

    While a person qualifies for a type of Ribbon:

      - If e has not owned that type of Ribbon within the preceding 7
        days, any player CAN, by announcement, award em that type of
        Ribbon.

      - Otherwise, if e has not been awarded that type of Ribbon or
        the corresponding type of Glitter since e last earned or
        came to qualify for that type of Ribbon, e CAN, by
        announcement, award emself that type of Glitter.

Amend Rule 2602 ("Glitter") to read:

  For each type of Ribbon, there is a type of Glitter with the same
  name. An attempt to award Glitter is INEFFECTIVE if the type of
  Glitter is not specified.

  Each time a player is awarded a type of Glitter, the Tailor CAN
  once, and SHALL before the end of the next Agoran week, grant the
  player N+1 coins, where N is the number of players who did not
  own the corresponding type of Ribbon at the time of the award.

  [If the mechanics of the change are approved, R2602 could later be
   further simplified by merging the first para into 2438 and the
   second into R2496]"""
            )
        }

        proposal(8296) {
            title("Divergence")
            ai(1.0)
            author(Aris)
            coauthors(G)

            text(
                """
Amend Rule 2143, "Official Reports and Duties", by removing the paragraph:

  A convergence is any change to the gamestate that has, in
  accordance with the rules, been designated as such. A change to
  the gamestate SHOULD NOT be designated as a convergence unless it
  is designed to resolve gamestate ambiguity. Designating a change
  as a convergence is secured; any player CAN do so with 3 Agoran
  Consent. When officeholders provide historical information, they
  NEED NOT accurately document the changes made by the convergence
  or related ambiguities, provided that they instead note that the
  convergence occurred. Information about a convergence (but not the
  resulting state) is inherently uncertain and is thus excluded from
  self-ratification.

Amend Rule 1681, "The Logical Rulesets", by changing the text
  "Whenever a rule is changed in any way, the Rulekeepor SHALL record
  a historical annotation to the rule indicating:"
to read
  "Whenever a rule is changed in any way, the Rulekeepor SHALL record and
  thereafter maintain a reasonably accurate historical annotation to the
  rule indicating:""""
            )
        }

        proposal(8297) {
            title("Imminent Failure")
            ai(2.1)
            author(Aris)

            text(
                """
[This is no longer effective; a replacement would be complex to implement
and probably not worth it.]

Amend Rule 2481, "Festival Restrictions", by removing the list item

  "2. Non-Festive players cannot flip the Imminence of any proposal;"

and renumbering the list accordingly."""
            )
        }

        proposal(8298) {
            title("Administrative Adjudication v3")
            ai(2.0)
            author(Aris)
            coauthors(Gaelan, twg, G, Jason, Alexis)

            text(
                """
Enact a new rule, with power 2.0, entitled "Memoranda", with the following text:

  Each officer CAN, by announcement, issue a memorandum, consisting of a
  specified public document. The memorandum is binding as precedent within
  the officer's official domain, broadly construed, and SHOULD be tracked along
  with judicial cases. An officer SHALL only issue a memorandum to clear up
  a matter of urgent concern creating confusion in eir domain;
  officers are ENCOURAGED to exercise discretion in issuing memoranda.

[Suggested domains of current offices:
ADoP - Officer elections, whether reports were published, who holds what office
Arbitor - The existence and assignment of CFJs, but not their resolution
Assessor - Votes, resolutions
Comptrollor - Vetos
Distributor - The operation of the lists
Herald - Patent titles, honour, the birthday tournament
Notary (if passed) - Contracts and pledges
Prime Minister - Anything in the jurisdiction of multiple officers
Promotor - Proposals in the pool, distributions
Referee - Fines and criminal law in general
Registrar - Registration & deregistration, zombie auctions, etc.
Rulekeepor - The state of the rules (e.g. whether proposals worked)
Speaker - Head of State stuff (i.e. nothing)
Tailor - Ribbons
Treasuror - Assets
]"""
            )
        }

        proposal(8299) {
            title("The Reset Button v2")
            ai(3.0)
            author(Aris)
            coauthors(G)

            text(
                """
If no proposal whose title contains the text "Administrative Adjudication"
has passed within the last 30 days, the remainder of this proposal has no
effect.

Create the following power 3.0 rule entitled "The Reset Button":

  An officer CAN, without 3 objections, pursuant to a memorandum finding it
  in the best interests of the game, issue an adjustment, which shall be
  a public document. When the adjustment is issued, all changes that are
  included in the adjustment take effect.

  This is a RECOMMENDED method for resetting aspects of the game in a
  fair and equitable manner following the discovery and/or exploitation
  of unintended loopholes within the Rules,  whether the exploitation
  was accidental or purposeful."""
            )
        }

        proposal(8300) {
            title("Patches")
            ai(3.0)
            author(Aris)

            text(
                """
If no proposal whose title contains the text "Administrative Adjudication"
has passed within the last 30 days, the remainder of this proposal has no
effect.

Create the following power 3.0 rule entitled "Patches":

  An officer CAN, without 3 objections, pursuant to a memorandum finding it
  in the best interests of the game, issue a regulation known as a patch.
  To the extent the patch is not manifestly abusive, disproportionate, or
  unreasonable, the rules are to be interpreted as if they were modified
  in the manner stipulated by the patch.

  Enacting and modifying patches are secured. A patch's promulgator CAN amend
  it without 3 objections. Any person CAN repeal the patch by announcement
  once it has been rendered obsolete."""
            )
        }

        proposal(8301) {
            title("Consolidated Regulatory Recordkeeping v2")
            ai(3.0)
            author(Aris)
            coauthors(Jason)

            text(
                """
[The Rulekeepor is willing to take on this responsibility, and it
makes considerably more sense than making the officer include a random
section in their report; instead, it keeps all of the rules and regulations
together in one easily accessible place.]

Amend Rule 2493, Regulations, by changing the text

  "Regulations are tracked in their Promulgator's weekly report."
to read
  "Regulations are tracked by the Rulekeepor as part of eir
  weekly and monthly reports in a fashion similar to rules.""""
            )
        }

        proposal(8302) {
            title("Generic Petitions")
            ai(1.5)
            author(Aris)

            text(
                """
Amend Rule 649, "Patent Titles", by removing the paragraph:

  If a player publicly petitions that the Herald award a patent
  title to another player for a specified reason, the Herald SHALL
  respond in a timely fashion by either attempting to grant an
  appropriate patent title or explaining publicly why no patent
  title is warranted.

Amend Rule 2143, "Official Reports and Duties", by appending as a new paragraph
at the end:

  If an office has a discretionary power, and a player publicly petitions
  the officer to apply that power in a specific case or manner, the officer
  SHALL publicly respond in a timely fashion.

[No reason this should be specific to Herald (yes, I know I added it in the
first place), and it seems like a good convention to have. It could be
applied to regulations and memoranda, for instance.]"""
            )
        }

        proposal(8303) {
            title("Contract Patency v3")
            ai(3.0)
            author(Aris)
            coauthors(Gaelan, Jason, Falsifian)

            text(
                """
Amend Rule 2519, "Consent", to read in full:
  A person is deemed to have consented to an action if and only if,
  at the time the action took place:

  1. e, acting as emself, has publicly stated that e agrees to the action
     and not subsequently publicly withdrawn eir statement;
  2. e is party to a contract whose body explicitly and unambiguously
     indicates eir consent; or
  3. it is reasonably clear from context that e wanted the
     action to take place or assented to it taking place.

Amend Rule 2124, "Agoran Satisfaction", by removing the text '(syn. "consent")'.

Amend Rule 1742, "Contracts", to read in full:

  Any group of one or more consenting persons (the parties) may
  publicly make an agreement among themselves with the intention that it be
  binding upon them and be governed by the rules. Such an agreement
  is known as a contract. A contract may be modified, including
  by changing the set of parties, with the consent of all
  existing parties. A contract may also be terminated with the
  consent of all parties. A contract automatically terminates if the number of
  parties to it falls below one. It is IMPOSSIBLE for a person to
  become a party to a contract without eir consent.

  Parties to a contract governed by the rules SHALL act in
  accordance with that contract. This obligation is not impaired
  by contradiction between the contract and any other contract, or
  between the contract and the rules.

  Rules to the contrary notwithstanding, any change that would cause the full
  provisions or parties of a contract to become publicly unavailable is canceled
  and does not take effect.

  The portion of a contract's provisions that can be interpreted
  with reference only to information that is either publicly or generally
  available are known as its body; the remainder of the provisions are known
  as the annex.

  A party to a contract CAN perform any of the following actions as
  explicitly and unambiguously permitted by the contract's body:

  * Act on behalf of another party to the contract.

  * By announcement, revoke destructible assets from the contract.

  * By announcement, transfer liquid assets from the contract to a specified
    recipient.

Amend rule 2450, "Pledges", by adding at the end of the first paragraph
"A pledge ceases to exist at the end of its time window."

Destroy every pledge with an expired time window.

Enact a new power 2.0 rule, entitled "The Notary", with the following text:

  The Notary is an office.

  The Notary's weekly report contains:

  1. every pledge, along with its title, creator, time window, time of
     creation, and time of expiry; and
  2. every contract, with its title, full provisions, and parties.

  If the Notary is required to report a title, but none has been otherwise
  publicly provided, e CAN select one.

  The transitional period lasts for at least 90 days after this rule comes
  into force; thereafter, any player CAN end it by announcement.
  A pledge or contract is invisible if it was created before this rule came
  into force, and has not been publicly posted since this rule came into force;
  for a contract, this publication must include its full provisions and list of
  parties, along with a certification or adequate proof of their accuracy and
  completeness. During the transitional period, the Notary NEED NOT report
  any invisible contract or pledge. When the transitional period is ended,
  each invisible contract or pledge ceases to exist in the order they were
  created, and then this rule amends itself by deleting this paragraph.

Make Gaelan the Notary."""
            )
        }

        proposal(8304) {
            title("Rewards Reform Act - v1.1 Patch")
            ai(2.0)
            author(Bernie)
            coauthors(twg, Jason)

            text(
                """
If the proposal titled "Rewards Reform Act" has not been adopted, this
proposal has no effect.

Amend Rule 1023, "Agoran Time", by inserting the following top-level
list item before the one starting "2. Agoran epochs:", and renumbering
the rest of the list as appropriate:

2. The phrase "in an officially timely fashion" means "before the
   end of the next Agoran week". This time period is set when the
   requirement is created (i.e. between 7 and 14 days before the
   period ends).

Amend Rule 2496, "Rewards", by replacing "before the end of the next
Agoran week" with "in an officially timely fashion".

Amend Rule 2602, "Glitter", by replacing "before the end of the next
Agoran week" with "in an officially timely fashion"."""
            )
        }

        proposal(8305) {
            title("Keeping Up With the Times")
            ai(3.0)
            author(Alexis)

            text(
                """
Amend Rule 1367 (Degrees) by replacing "Bachelor" with "Baccalaureate" and
by replacing "Master" with "Magisteriate".

Rename every instance of the Patent Titles "Bachelor of Nomic" and "Master
of Nomic" accordingly."""
            )
        }

        proposal(8306) {
            title("Deregistration")
            ai(3.0)
            author(Gaelan)

            text(
                """
Flip the Citizenship of the following players to Unregistered:
- D. Margaux
- Baron von Vaderham"""
            )
        }

        proposal(8307) {
            title("Deregistration")
            ai(3.0)
            author(DMargaux)

            text(
                """
Flip the Citizenship of the following player to Unregistered:
 - Gaelan"""
            )
        }
    }

    voting {
        votes(G) {
            AGAINST on 8287
            endorse(twg) on 8288 comment "twg is Treasuror"
            AGAINST on 8289
            FOR on 8290
            AGAINST on 8293
            AGAINST on 8294
            FOR on 8296
            FOR on 8297
            AGAINST on 8298
            AGAINST on 8299
            AGAINST on 8300
            AGAINST on 8301
            PRESENT on 8302
            FOR on 8305
            AGAINST on 8306
            AGAINST on 8307
        }

        o matches G

        votes(twg) {
            FOR on 8287
            endorse(omd) on 8288
            AGAINST on 8289
            endorse(G) on 8290
            FOR on 8291
            FOR on 8292
            FOR on 8293
            PRESENT on 8294
            FOR on 8295
            PRESENT on 8296
            endorse(Aris) on 8297
            FOR on 8298
            AGAINST on 8299
            endorse(Aris) on 8300
            endorse(Jason) on 8301
            endorse(Aris) on 8302
            PRESENT on 8303
            FOR on 8304
            endorse(Alexis) on 8305
            AGAINST on 8306
            AGAINST on 8307
        }

        votes(Bernie) {
            endorse(twg) on all
        }

        votes(Aris) {
            PRESENT on 8287
            FOR on 8288
            AGAINST on 8289
            FOR on 8290
            FOR on 8291
            FOR on 8292
            FOR on 8293
            AGAINST on 8294
            FOR on 8295
            FOR on 8296
            FOR on 8297
            FOR on 8298
            AGAINST on 8299
            FOR on 8300
            FOR on 8301
            FOR on 8302
            FOR on 8303
            FOR on 8304
            AGAINST on 8305
            PRESENT on 8306
            AGAINST on 8307
        }

        votes(Alexis) {
            PRESENT on 8287
            FOR on 8288
            FOR on 8289
            FOR on 8290
            FOR on 8291
            endorse(Falsifian) on 8292 comment "Falsifian was first of (omd, G., Falsifian) to vote on this proposal"
            AGAINST on 8293
            AGAINST on 8294
            FOR on 8295 comment conditional("8304 is going to be resolved as ADOPTED")
            FOR on 8296
            FOR on 8297
            AGAINST on 8298
            endorse(G) on 8299
            AGAINST on 8300
            FOR on 8301
            FOR on 8302
            PRESENT on 8303
            FOR on 8304
            FOR on 8305
            AGAINST on 8306
            endorse(DMargaux) on 8307
        }

        votes(Falsifian) {
            PRESENT on 8287
            endorse(omd) on 8288 comment NO_VETO
            PRESENT on 8289 comment NO_VETO
            endorse(G) on 8290
            endorse(twg) on 8291
            endorse(twg) on 8292
            PRESENT on 8293
            AGAINST on 8294
            endorse(twg) on 8295 comment conditional("None of the Assessor, Arbitor, ADoP, and Herald voted AGAINST")
            AGAINST on 8296
            endorse(Aris) on 8297
            endorse(Aris) on 8298
            AGAINST on 8299
            endorse(Aris) on 8300
            endorse(Jason) on 8301 comment "Jason is the Rulekeepor"
            endorse(Aris) on 8302
            endorse(Aris) on 8303
            endorse(twg) on 8304
            endorse(Alexis) on 8305
            AGAINST on 8306
            AGAINST on 8307
        }

        votes(Jason) {
            AGAINST on 8287
            FOR on 8288
            AGAINST on 8289
            FOR on 8290
            FOR on 8291
            PRESENT on 8292
            FOR on 8293
            AGAINST on 8294
            FOR on 8295
            PRESENT on 8296
            FOR on 8297
            endorse(Aris) on 8298
            endorse(Aris) on 8299
            endorse(Aris) on 8300
            FOR on 8301
            FOR on 8302
            FOR on 8303
            FOR on 8304
            PRESENT on 8305
            AGAINST on 8306
            AGAINST on 8307
        }

        votes(Rance) {
            endorse(Jason) on all
        }

        votes(Gaelan) {
            PRESENT on 8287
            endorse(twg) on 8288 comment "twg is the Treasuror"
            AGAINST on 8289
            FOR on 8290
            FOR on 8291
            PRESENT on 8292
            endorse(G) on 8293 comment "G. is the Arbitor"
            AGAINST on 8294
            FOR on 8295
            FOR on 8296
            FOR on 8297
            AGAINST on 8298
            AGAINST on 8299
            AGAINST on 8300
            FOR on 8301
            FOR on 8302
            PRESENT on 8303
            FOR on 8304
            PRESENT on 8305 comment conditional("G. not AGAINST")
            AGAINST on 8306
            AGAINST on 8307
        }

        votes(omd) {
            FOR on 8287
            FOR on 8288
            PRESENT on 8289
            FOR on 8290
            PRESENT on 8291
            FOR on 8292
            AGAINST on 8293
            AGAINST on 8294
            AGAINST on 8295
            FOR on 8296
            FOR on 8297
            AGAINST on 8298
            PRESENT on 8299
            AGAINST on 8300
            endorse(Jason) on 8301 comment "Jason is the Rulekeepor"
            PRESENT on 8302
            PRESENT on 8303
            AGAINST on 8304
            FOR on 8305
            endorse(DMargaux) on 8306
            endorse(Gaelan) on 8307
        }
    }
}
