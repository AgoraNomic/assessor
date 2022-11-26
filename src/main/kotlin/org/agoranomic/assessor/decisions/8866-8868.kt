package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream

@UseAssessment
fun assessment8866to8868() = assessment {
    name("8866-8868")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Jason, 2)
            powerDream(snail, 2)
        }
    }

    proposals(v4) {
        proposal(8866) {
            title("Restricted confederation")
            ai("3.0")
            author(Jason)
            coauthors(Aspen)
            democratic()

            text(
                """
Amend Rule 869 by replacing "Any entity (including a group of
confederated entities)" with "Any entity (including a group of entities
confederated with the intent of forming a single person under this Rule)".

[Requires intent for the formation of a group person. This prevents a
random group of people confederated for some other purpose (the example
initially raised was BlogNomic, or its set of players) from being
treated as a group person, unless they also wish to confederate for the
purposes of Agora.]"""
            )
        }

        proposal(8867) {
            title("Expectations, Values, Bans, and Forgiveness")
            ai("3.0")
            author(nix)
            coauthors(Jason, RLee, Murphy, G)
            democratic()

            text(
                """
[
The goal of this is to expand on our banning system and implement some
clearly defined values into the rules of Agora. This comprises two main
changes.

The first removes the "free speech" clause from R478 and replaces it
with a bill of expectations that largely seek to maximize participation
while recognizing ways in which that might reasonably be abridged.
Nothing here is strictly binding.

The second one expands on the banning system largely through guidelines.
It does not actually add any new mechanisms for banning or unbanning,
but offers a strongly-worded procedure for what should occur before a
ban, and what kind of actions might constitute bannable offenses. It
also adds an official mechanism to attempt to appeal a ban, and what
should be considered when such an attempt is received.

This is largely informed by Jason's current ban system, Murphy's
response to Anti-Cleisthenes, R. Lee's values proto, and parallel
discussions in other spaces. Hopefully I have done justice to everyone's
viewpoints.
]

Amend R478 by deleting the following text:

        Freedom of speech being essential for the healthy functioning of
        any non-Imperial nomic, it is hereby resolved that no Player shall
        be prohibited from participating in the Fora, nor shall any person
        create physical or technological obstacles that unduly favor some
        players' fora access over others.

Enact a new Power=3 rule titled "Expectations of Participation" with the
following text:

        An "Agoran forum" is a forum with publicity of discussion or
        public. Players of Agora have the following expectations of agoran
        fora:

        * Agoran fora allow equal participation for all players, subject
          to the rules of Agora and the explicitly stated rules of the
          fora.

        * The rules of participation in public fora are as closely
          aligned with the rules of Agora itself as possible; a player
          expects to be able to fully participate in all public fora as
          long as eir participation is in line with Agora's rules.

        * Agoran fora allow all interested persons, even those that are
          otherwise restricted in eir participation, to read all messages.

        * Discussion fora moderators may restrict participation subject to
          eir own clearly stated rules but should only do so to players
          temporarily and proportional to the harm of the rule breakage.

        * The content of discussion fora should primarily be about Agora
          itself, or reasonably adjacent topics.

        If an existing Agoran forum is in violation of these expectations,
        the Agoran community, led by the Registrar, SHOULD remove it or
        replace it with an appropriate forum as soon as possible.

Amend R869 by deleting the following:

        Banned is a secured negative boolean person switch tracked by the
        Registrar. A person is unwelcome if e is Banned or if at least one
        part of em is unwelcome. Rules to the contrary notwithstanding, an
        unwelcome person CANNOT register or be registered, and e is
        immediately deregistered if e is ever a player. Designations of
        unwelcomeness are secured.

        Unwelcomeness is to be used only to make a social statement that
        the Agoran community no longer wishes to interact with certain
        persons; in particular, it is not to be used to acquire gameplay
        advantage. As such, an unwelcome person SHOULD NOT, under any
        circumstances, attempt to bypass unwelcomeness, and e SHOULD
        carefully consider the circumstances of eir becoming unwelcome
        before participating in public or discussion fora.

Enact a new Power=3 rule titled "Restrictions on Participation" with the
following text:

        Banned is a secured negative boolean person switch tracked by the
        Registrar. A person is unwelcome if e is Banned or if at least one
        part of em is unwelcome. Rules to the contrary notwithstanding, an
        unwelcome person CANNOT register or be registered, and e is
        immediately deregistered if e is ever a player. Designations of
        unwelcomeness are secured.

        A Banned switch SHOULD ONLY be flipped by a proposal for the
        express purpose of flipping Banned switches.

        Flipping a Banned switch to True (banning a player) SHOULD ONLY be
        done when:

        * the person's actions have been deemed harmful to Agora, to any
          player of Agora, or the overall community, and

        * the harm has been clearly communicated to the person, and e has
          been given time to consider and respond, and

        * e has made no attempt to make amends, eir attempt was
          unsatisfactory, or e has continued to act in harmful ways.

        Actions that are harmful are subject to the discretion of the
        community of Agora, but may include: any form of identity-based
        discrimination, personal attacks, disrespect of values or beliefs
        of any member of the Agoran community, or provocative/bad-faith
        comments.

        Once a quarter, any unwelcome player may submit a Request for
        Forgiveness to the Registrar. Such a document SHOULD contain
        sincere self-reflection including any appropriate apologies and an
        indication on how e intends to avoid or prevent similar incidents
        in the future.

        The Registrar SHALL publish any Request for Forgiveness e receives
        in a timely manner. If the community deems the Request sincere and
        appropriately reconciliatory, steps should be undertaken to flip
        the submitter's Banned switch to False.

The Banned switch of any player that was unwelcome before this proposal
was enacted is flipped to True."""
            )
        }

        proposal(8868) {
            title("Slippery Stones v2.1")
            ai("2.0")
            author(nix)
            coauthors(G, ais523, Jason, ziproot)
            ordinary()

            text(
                """
Amend R2640, "Stones", by replacing:


      The escape risk of the stone, which must be a percentage between 0%
      and 100% inclusive;

with:

      The smoothness of the stone, which is a non-negative integer;

and appending to the end the following paragraphs:

      Mossiness is a Stone switch with values of non-negative integers
      and a default of 0 tracked by the Stonemason. When a stone is
      transfered, its Mossiness is set to 0. The mossiest stone(s) in a
      set of stone is (are) the stone(s) with the highest Mossiness
      value.

      The Slipperiness of a stone is that stone's smoothness plus its
      mossiness.

Amend R2641, "Wielding Stones", by replacing:

      If a stone has a frequency, then it is IMPOSSIBLE to wield that
      stone if it has been previously wielded in the same Agoran time
      interval as indicated by its frequency (e.g. if its frequency is
      daily, if it has been wielded in the same Agoran day).

with:

      A stone with a frequency that has been wielded in the corresponding
      Agoran time interval is Hot for the remainder of the time period
      (e.g. if the frequency is daily, it is hot for the remainder of the
      Agoran day it was wielded during).

      While a stone is hot, it is IMPOSSIBLE to wield it or to transfer
      it by announcement

Amend R2642, "Distributing Stones", to be titled "Gathering Stones" and
to read in full:

      A player who has not possessed a stone in the last 30 days CAN, by
      announcement, transfer the mossiest stone (if there is a tie, then
      a specified stone tied for mossiest) Agora owns to emself. E SHOULD
      specify the stone when doing so.

Amend R2643, "Collecting Stones", to read in full:

      Once per month, the Stonemason CAN publish a Collection Notice by
      announcement, specifying all necessary information and choices. The
      Stonemason SHALL publish such a notice in a timely fashion after
      the beginning of each Agoran month.

      A Collection Notice includes a random numbers between 1 and 6; this
      is the Escape Minimum.

      When a Collection Notice is published, for each player eir
      non-immune stone with the highest slipperiness equal to or above
      the Escape Minimum is transferred to Agora. If there is a tie, the
      Stone Mason selects which one escapes. If e has no such stones,
      none of eir stones are transferred to Agora. The mossiness of all
      stones that are not transferred is incremented by 1.

Amend R2645, The Stones to read in full:

      The following stones are defined, one per paragraph, with the
      following format: Stone Name (Frequency, Smoothness): Scroll.

      - Power Stone (weekly, 2): A specified player (defaulting to the
        wielder if not specified) is Power Stoned; Power Stoning is
        secured. A player's voting strength on a referendum on an
        ordinary proposal is increased by 3 for each time that e was
        Power Stoned during the referendum's voting period.

      - Soul Stone (weekly, 3): The Soul Stone is hereby transferred
        to the owner of a different specified non-immune stone, then
        that stone is transferred to the wielder.

      - Sabotage Stone (weekly, 4): The adoption index of a specified
        AI-majority Agoran decision is hereby increased by 1.

      - Jockey Stone (monthly, 3): A specified Running horse's Race
        Position is increased by 1.

      - Protection Stone (monthly, 4): A specified stone is granted
        immunity.

      - Recursion Stone (Monthly, 4): The recursion stone can be
        wielded once per month as if it had the power of any other stone
        of your choice.

      - Hot Potato Stone (Weekly, 5):  When this stone is wielded, the
        wielder specifies an eligible player and gains 8 points. The
        stone is transferred to the eligible player. An eligible player
        is one who has not owned this stone since the last time Agora
        owned it. If this  stone is not owned by Agora, it cannot
        otherwise be transferred, other rules notwithstanding. This stone
        is immune if 3 or more players have wielded it since the most
        recent collection notice.

      - Blank Stone (Monthly, 0): This stone has no effect.

      - Mason's Stone (None, 0): If the Mason's Stone is owned by the
        Stonemason, its Mossiness is continuously set to 0. If the
        Mason's Stone is owned by Agora, it is transferred to the
        Stonemason.

      - Anti-Equatorial Stone (Monthly, 5): The mossiest stone is
        transferred to the wielder. When this happens, the
        Anti-Equatorial Stone's mossiness is incremented by 1.

      - Score Stone (Weekly, 3): A specified player's (defaulting to the
        wielder if not specified) Score is increased by 3."""
            )
        }
    }
}