package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.ministries.ministries_2020_02_13
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV1.*
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8349to8356() = assessment {
    name("8349-8356")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-March/013548.html")
    quorum(7)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Comptrollor to null,
        Distributor to omd,
        Herald to Alexis,
        Notary to Gaelan,
        PrimeMinister to Aspen,
        Promotor to Aspen,
        Referee to twg,
        Registrar to Falsifian,
        Rulekeepor to Janet,
        Speaker to twg,
        Tailor to twg,
        Treasuror to twg
    )

    strengths {
        default(3)
        min(0)
        max(15)

        addToHolder(offices, Speaker, 1)
        ministries_2020_02_13(offices, allProposals)
    }

    proposals(v1) {
        proposal(8349) {
            title("Temporary CFJ Setup")
            ai("1.0")
            author(twg)
            chamber(Justice)

            text(
                """
Enact a new Rule of Power 1.0 entitled "Temporary CFJ Setup" with the
following text:

  Rules to the contrary notwithstanding, twg CANNOT publish a Notice
  of Honour.

  twg CAN, by announcement, cause this Rule to repeal itself."""
            )
        }

        proposal(8350) {
            title("Apologies Don't Interfere")
            ai("2.0")
            author(Alexis)
            chamber(Justice)

            text(
                """
Amend rule 2555 by replacing "who has not expunged any blots in the
current Agoran week" with "who has not, by this mechanism, expunged
any blots in the current Agoran week"."""
            )
        }

        proposal(8351) {
            title("Double proposal application fix")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2034 by replacing the text "such a proposal existed, was
adopted, and took effect." with the text "such a proposal existed, was
adopted, and, if it had not previously taken effect, took effect.".

[Intended to make the consequences of Assessorial mishaps significantly
easier to deal with - this will insure that a proposal does not take
effect twice if an assessment is posted twice (the first time because it
succeeded platonically, the second time because of self-ratification).]"""
            )
        }

        proposal(8352) {
            title("zombie auction fix 1.1")
            ai("2.0")
            author(G)
            chamber(Economy)

            text(
                """
Amend Rule 1885 (Zombie Auctions) by replacing:
  For the purpose of such a auction, to transfer a zombie to a player
  is to set that zombie's master switch to that player.
with:
  For the purpose of such a auction, to transfer a zombie to a player
  is to set that zombie's master switch to that player, and Agora CAN
  perform such transfers of the appropriate lots to auction winners.

and by inserting a line break immediately before the resulting text so
that it is a new paragraph.

Amend Rule 2551 (Auction End) by deleting "at will"."""
            )
        }

        proposal(8353) {
            title("All that glisters")
            ai("3.0")
            author(Murphy)
            democratic()

            text(
                """
Amend Rule 2438 (Ribbons) by replacing this text:

  - Otherwise, if e has not been awarded that type of Ribbon or the
    corresponding type of Glitter since e last earned or came to
    qualify for that type of Ribbon, e CAN, by announcement, award
    emself that type of Glitter.

with this text:

 - Otherwise, if e has not been awarded that type of Ribbon or
   the corresponding type of Glitter since e last earned or came
   to qualify for that type of Ribbon, and has not been so
   awarded five or more times within the past 24 hours, e CAN, by
   announcement, award emself that type of Glitter."""
            )
        }

        proposal(8354) {
            title("Statutory Instrumentation")
            ai("3.0")
            author(Alexis)
            coauthors(Murphy, Aspen, Gaelan)
            democratic()

            text(
                """
=Administrative Law Reform. I. Statutory Instrumentation.=

[This first proposal is a reform to the core rules defining what rules
are, with an aim to better supporting subordinate legal documents. The
intent is to enact very little change to the game as it is actually
played, and to operate mostly in the realm of supporting definitions.]

If this proposal has had any provision vetoed, then the entire
proposal has no effect. If this proposal has already taken effect,
then it has no effect.

In this proposal, "I->S" is to amend a rule within the scope specified
by replacing each instance of "an instrument" with "a statute", and
each other instance of "instrument" with "statute". This is not a
case-sensitive match, however, if the word "instrument" being replaced has a
leading capital, then so does the replacement word "statute".

Enact a new power-3.9 rule entitled "Statutory Instrumentation
Simultaneity", reading:
{{
  Rules to the contrary notwithstanding, the proposal which enacted this
  rule CAN effect multiple rule changes, which it could otherwise effect
  individually, simultaneously. When it
  attempts to do so, if any single rule change it attempts is
  INEFFECTIVE, then so is the entire attempt.

  If the proposal which enacted this rule effects a change to the
  definition of a rule then, except for rules which are simultaneously
  and explicitly enacted or repealed with that change, as appropriate,
  the rules after that change are exactly the entities that were rules
  beforehand. This is a definition of the interpretation of the
  amendment to the rules and not, in and of itself, a rule change.
}}

[This proposes to make multiple interlocking amendments to critical
rules defining rules and the interactions between themselves. This
mitigates a real risk that, during a series of sequential changes, the
rules would be in a nonsensical or otherwise broken state. I
considered trying to put in a special clause preserving the effect of
the current rules on rule changes for the duration of the proposal,
but that wouldn't preclude the possibility of some other aspect of the
game, such as asset holdings, doing something weird in the in-between
state. And only a
persistent rule could elegantly paper over that small weird gap in
time. I think simultaneity is the better choice.]

Set the power of all non-rule entities, other than this proposal, to
0. [This is an important safety as the change to the definition of a
rule would potentially cause old non-rule instruments to become rules.
Best not to consider that.]

Apply the following rule changes simultaneously:

{{
  Amend Rule 1688 (Power) by replacing "An Instrument is an entity with
  positive Power." with "A statute is a document with positive Power."
  Apply I->S throughout the remainder of the rule.

  Amend rule 2140 (Power Controls Mutability) by replacing "set or
  modify any other substantive aspect of an instrument with power
  greater than its own." with "set or modify any other substantive
  aspect of an instrument with power greater than its own except as
  otherwise provided in this rule.", applying I->S throughout the rest
  of the rule, and appending a new paragraph reading "An ephemeral
  instrument is bound by prohibitions and limitations specified in rules
  of lower power, unless it explicitly overrides those prohibition(s) as
  provided for in other rules."

  [I don't want to consider what it would mean if PCM prevents rules
  from interfering with higher-powered proposal. Let's pretend this is
  just clarifying something super obvious to everyone.]

  Apply I->S throughout Rule 105 (Rule Changes).

  Enact a new power-3 Rule entitled "Instruments" reading:
  {
    An instrument is a type of document, either ephemeral or enduring,
    that is defined as such by a body of law. An instrument's text, where
    otherwise permitted, can be amended from time to time.

    Rules to the contrary notwithstanding, an instrument other than a
    statute CANNOT become binding on a person without eir willful consent,
    however, consent can be given by implication. In particular,
    consenting to be bound to an instrument can imply consent to be bound
    by amendments to it and consent to be bound by other instruments.
  }

  Enact a new power-3 Rule entitled "Bodies of Law" reading:
  {
  A body of law is a collection of related instruments and bodies of law
  whose effects are collective and possibly interdependent, and which is
  defined as such by a body of law. The statutes of Agora form a body of
  law with unlimited scope. All other bodies of law are defined by a
  different body of law, in such a way as to be able to trace their
  origins back to the statutes of Agora. Two or more bodies of law may
  jointly define another body of law, but only each of them clearly
  expresses the intent to participate in a joint definition with each of
  the others. Otherwise, the definitions are separate, distinct, and
  unrelated.

  A body of law is governed by all bodies of law which, directly or
  indirectly, participate in its definition, as well as any body of law
  specified as governing it by any of its governing law. A body of law
  is subordinate to the law that governs it, other than itself, and a
  body of law is
  superior to the law that it governs, other than itself. For greater
  certainty, rules to
  the contrary notwithstanding, the statutes of Agora govern all law and
  are governed by no law except themselves, and no body of law can be
  both subordinate to and superior to another.

  With respect to interactions between separate bodies of law, a body of
  law is generally to be interpreted as acting harmoniously as a single
  whole. The precedence between, and organization of, instruments in a
  body of law are internal matters to that body of law and generally do
  not affect the effect of other bodies of law, except to the extent
  that they affect the body's operation as a whole.

  The definition of a body of law includes the definition if its scope,
  being the areas of the game that it governs. By definition, the scope
  of a body of law is no greater than the union of the scopes of the
  bodies of law that define it, nor does it include anything which would
  bring it into direct conflict with superior law. To the extent that a
  body of law's scope is not explicitly defined by superior law, it is
  as broad as possible while excluding any effect on any substantive
  aspect of any body of law, besides itself, that it does not govern.

  Every instrument is a direct member of exactly one body of law; if not
  specified in its definition, it is a body of law in itself. A given
  fixation of text may, however, be the text of multiple instruments,
  each in different bodies of law. The scope of an instrument is the
  scope of the body of law it forms a part of. To the extent that the
  provisions of an instrument are outside its scope, they are void and
  without effect.
  }

  [This is the core of the reform: a base framework for multiple
  separate, scoped bodies of law. Rather than an explicit discussion of
  precedence between laws, a framework of scoping is used. This proposal
  does not define anything outside of rules and enacted proposals as
  being instruments and thus part of this framework, in order to allow
  gradual work on areas of the ruleset such as regulations and
  contracts.

  The reason for "bodies of law" as separate from "instruments" is that
  frequently, bodies of law express themselves collectively. The rules
  of Agora, for instance, can only be properly interpreted as a whole.
  Definitions of entities are often spread out, sometimes to the point
  where it's nearly impossible to pinpoint a single instrument as the
  source. Bodies of law capture this concept. They also allow more
  flexibility to be introduced in proposals to come, such as making
  clear that a body of law can modify definitions in superior law
  without a conflict. We can also make rules such as Rule 2125 more
  natural using this technology, see below.

  More importantly, it allows us to create contracts and similar
  documents that impose obligations and have other legal effect, but
  without that possibly "creeping" upwards and affecting things outside
  their scope. Contracts, for instance, can be safely defined without
  fear that they could be used to override lower-powered rules.

  Bodies of law can be nested. This is to allow for, say, the Rules and
  Regulations to collectively act as a single body of law, but the Rules
  to act as a body of law within it. In the future this could be the
  basis for something like Falsifian's modules. I would rather get the
  mechanism solid and well-tested before touching precedence between
  rules, however.

  Governance of bodies of law cannot, however, be circular, because
  while some bodies of law like the rules are self-governing, other
  circularity could cause more significant problems by causing a law to
  be subordinate/superior to itself, and I want to avoid thinking about
  that.

  I've worked hard to prevent any sort of bootstrapping scam by which a
  body of law could be brought into existence out of nowhere or
  otherwise come to govern a superior body without its permission.
  Please examine closely to see if I succeeded!]

  Amend Rule 2125 (Regulated Actions) to read:
  {
    An action is regulated by a body of law if (1) its performance is
    limited, allowed, enabled, or permitted by that body of law; (2) that
    body of law describes the circumstances under which it would succeed
    or fail; or (3) it would, as part of its effect, modify information
    for which some person bound by that body of law is required, by that
    body of law, to be a recordkeepor.

    If a body of law regulates an action, then to the extent that doing so
    is within its scope, that body of law prevents the action from being
    performed except as described within it, including by limiting the
    methods to perform that action to those specified within it. A body of
    law does not proscribed any action which it does not regulate.
  }

  [I'm sad about losing the SHALL NOT there. Violating that would surely
  have been one of the great Agoran crimes, along with failing to
  carefully consider the consequences of not reading the ruleset during
  RtRW.]

  Enact a new power-3 Rule entitled "Effects of Instruments" reading:
  {
    An instrument's effect is defined by its text, as amended from time to
    time in accordance with the law governing its operation. A
    "substantive" aspect of an instrument is any aspect that affects the
    instrument's operation. If an instrument's text contains clearly
    marked comments then, they have no effect on its interpretation or
    operation except as that instrument itself specifies, although they
    remain part of its text. For the purposes of rules concerning the
    methods by which actions are performed, an instrument taking effect is
    such a method.

    An enduring instrument is one that it is always taking effect, to the
    extent it is permitted to so by the Rules and any other applicable
    instruments. An enduring instrument is always speaking; uses of the
    present tense in an enduring instrument are interpreted contextually
    according to the applicable rules of interpretation.

    An ephemeral instrument is one that takes effect only briefly, to
    effect a number of changes on the game. When it takes effect, the
    changes specified in its text are applied, provided that the
    instrument is not prohibited from doing so. Unless otherwise specified
    by the instrument or by its governing law, the provisions of an
    instrument are applied sequentially and independently, in the sense
    that the success or failure of each provision does not depend directly
    on the success or failure of any other provision.

    An ephemeral instrument has no ongoing effect, except to the extent
    that the changes it makes have ongoing consequences. It cannot, except
    by way of an enduring instrument, extend or delay its own effect. An
    ephemeral instrument CAN, where explicitly permitted to do so by the
    law governing it, override the effect of an enduring instrument within
    its scope by modifying, suppressing, or postponing it. Such an
    override is INEFFECTIVE unless the nature and scope of the override
    are clearly specified either in the governing law or, where so
    authorized by the governing law, in the instrument itself.

    An instrument or body of law is not, except where it specifies
    otherwise, bound by or restricted in any way by any subordinate law
    and implicitly overrides and takes precedence over all provisions,
    including outright prohibitions or definitions, of all subordinate
    law.
  }

  [This consolidates the existing rules about proposals and rules into
  one place, since they will need to be reused for other instruments. It
  also provides explicit override language, mainly intended to ensure
  that proposals can have free reign over gamestate modification, though
  that's a separate proposal. Law is not bound by any other law so as to
  make clear that proposals cannot be restricted by a contract, say.]

  Amend Rule 2141 (Role and Attribute of Rules) to by replacing the
  first two paragraphs with the following:
  {
    A rule is an enduring statute. Every rule has a power between 0.1 and
    4.0, inclusive. Rules to the contrary notwithstanding, it is
    IMPOSSIBLE to enact a rule with power outside this range, or to change
    the power of an existing rule to a nonzero value outside this range.
    The set of all currently-existing rules is called the ruleset.
  }

  Amend Rule 106 (Adopting Proposals) to read as follows:
  {
    When a decision about whether to adopt a proposal is resolved, if the
    outcome is ADOPTED, then the proposal in question is adopted, its
    power is set to the minimum of four and its adoption index, it takes
    effect as an ephemeral instrument, and then its power is set to 0.
    This rule defers to rules that would prevent a proposal from taking
    effect.
  }

  [While this proposal does not immediately define any non-rule,
  non-proposal entities as instruments, the intent is that the creation
  of subordinate instruments comes implicitly. Thus, for instance, a
  contract can define a "sub-contract" within the scope of its own
  effect, and this would be recognized within law, once contracts are
  defined as instruments. Proposals ignore all subordinate law except as
  specified otherwise; this is a safety provision.

  Note that the deference provision is equivalent to the existing
  provision about preventing proposals from taking effect being secured,
  because deference does not override power as a determiner of
  precedence. So it will defer to any rule of power 3 or greater but
  take precedence over any lesser-powered rule.]
}}

Repeal the rule "Statutory Instrumentation Simultaneity" enacted
earlier in this proposal."""
            )
        }

        proposal(8355) {
            title("Temporary Suspension of Rules")
            ai("3.0")
            author(Alexis)
            coauthors(Murphy)
            democratic()

            text(
                """
=Administrative Law Reform. II. Temporary Suspension of Rules=

If no proposal entitled "Statutory Instrumentation" has taken effect
in the previous month, this proposal has no effect. If this proposal
has already taken effect, it has no effect.

Amend Rule 106 (Adopting Proposals) by appending a new paragraph
reading "A proposal CAN override the effect of any rule which it
is capable of amending by specifying that it does so."

[This is a small side proposal to allow proposals to temporarily
override rules without having to do so by the enactment and subsequent
repeal of a helper rule. It must be explicit.]"""
            )
        }

        proposal(8356) {
            title("Less Democracy Means More Fun")
            ai("2.0")
            author(Aspen)
            chamber(Legislation)

            text(
                """
Amend Rule 2606, "Proposal Classes", by changing the text

  "When a proposal with an adoption index greater than 2.0 is created,
  its class becomes democratic."

to read
  "When a proposal with an adoption index greater than or equal to
  3.0 is created, its class becomes democratic."

[Note that proposals can still be turned democratic with 2 Agoran Consent.
 However, this reserves democratic status for proposals changing core
 rules or of great public concern.]"""
            )
        }
    }

    voting {
        votes(Aspen) {
            FOR on 8349
            FOR on 8350
            FOR on 8351
            FOR on 8352
            PRESENT on 8353
            PRESENT on 8354
            PRESENT on 8355
            FOR on 8356
        }

        votes(Janet) {
            FOR on 8349
            FOR on 8350
            FOR on 8351
            endorse(G) on 8352
            FOR on 8353
            PRESENT on 8354
            PRESENT on 8355
            FOR on 8356
        }

        votes(Bernie) {
            endorse(Janet) on all
        }

        votes(Alexis) {
            AGAINST on 8349
            FOR on 8350
            FOR on 8351
            FOR on 8352
            FOR on 8353
            FOR on 8354
            FOR on 8355
            FOR on 8356
        }

        votes(Murphy) {
            FOR on all
        }

        votes(sukil) {
            FOR on 8349
            FOR on 8350
            FOR on 8351
            PRESENT on 8352
            FOR on 8353
            PRESENT on 8354
            PRESENT on 8355
            PRESENT on 8356
        }

        votes(Warrigal) {
            FOR on 8349
            FOR on 8350
            FOR on 8351
            FOR on 8352
            FOR on 8353
            AGAINST on 8354
            FOR on 8355
            FOR on 8356
        }

        votes(Falsifian) {
            PRESENT on 8349 comment legacyConditionalComment("Arbitor not AGAINST, and no Notice of Veto was published")
            endorse(Alexis) on 8350
            endorse(Janet) on 8351
            endorse(G) on 8352
            endorse(Murphy) on 8353
            PRESENT on 8354
            PRESENT on 8355
        }

        votes(PSS) {
            PRESENT on 8349 comment legacyConditionalComment("twg not FOR, but Assessor not AGAINST")
            FOR on 8350
            FOR on 8351
            FOR on 8352
            AGAINST on 8353
            FOR on 8354
            FOR on 8355
            AGAINST on 8356
        }

        votes(G) {
            FOR on all
        }

        votes(o) {
            FOR on all
        }
    }
}
