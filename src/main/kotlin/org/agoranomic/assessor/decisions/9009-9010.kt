package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.complexityBonuses
import org.agoranomic.assessor.dsl.votes.onOrdinaryProposals
import org.agoranomic.assessor.dsl.votes.powerDream
import org.agoranomic.assessor.dsl.votes.powerStone
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment9009to9010() = assessment {
    name("9009-9010")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(15)

        onOrdinaryProposals {
            powerDream(Aris, 2)
            powerDream(Forest, 2)

            powerStone(Janet, 3)

            complexityBonuses {
                maxBonus(3)

                "Absurdor"(0) heldBy juan
                "ADoP"(1) heldBy Murphy
                "Arbitor"(2) heldBy null
                "Assessor"(3) heldBy Janet
                "Collector"(1) heldBy snail
                "Distributor"(0) heldBy omd
                "Dream Keeper"(1) heldBy snail
                "Herald"(2) heldBy null
                "Notary"(2) heldBy snail
                "Prime Minister"(0) heldBy ais523
                "Promotor"(3) heldBy snail
                "Referee"(2) heldBy ais523
                "Registrar"(1) heldBy juan
                "Rulekeepor"(3) heldBy Janet
                "Speaker"(0) heldBy null
                "Stonemason"(1) heldBy Janet
                "Tailor"(1) heldBy Murphy
                "Webmastor"(1) heldBy null
            }
        }
    }

    proposals(v4) {
        proposal(9009) {
            title("Ordered cleanliness")
            ai("3.0")
            author(Janet)
            democratic()

            text(
                """
Amend Rule 2221 by replacing "the rule is amended by this rule as
specified by that person" with "when e does so, if any text changes were
specified, that rule is amended by this rule by applying the changes as
a single amendment (failing as a whole if any fail); then, if any title
changes were specified, that rule is retitled by this rule by applying
the changes as a single retitling (failing as a whole if any fail).""""
            )
        }

        proposal(9010) {
            title("Wizards Wage War")
            ai("2.0")
            author(Forest)
            ordinary()

            text(
                """
(Instead of defining something by what it IS, lets define something by what
it ISN'T! Looking forward to more comments on how to proof this a bit more,
but most of the proofing should be by the weaving itself.)
Enact the following rule entitled "Thaumaturgy" with power=2:
{
Each player, once per month, CAN, by commitment with 1 support, spellweave,
thereby becoming the mage of that spellweave. Supporters of a spellweave
are its apprentices.
The Plaintext thereof MUST clearly, unambiguously, and trivially state that
it shall exist within a single category of magic, otherwise it is a miscast.

The Archmage is an office whose weekly report tracks commitments made by
this rule and any magical instruments created or will be created thereof.

At the beginning of the month, for each spellweave, the mage or apprentices
CAN, by announcement, reveal the corresponding plaintext in a timely manner
(this is called casting). Not revealing the plaintext in a timely manner is
a miscast.
The Archmage CAN and SHALL, by announcement in a timely manner, grant all
mages who miscast or have miscast spells 3 blots for miscasting.

After the time limit expires for casting, all related Plaintext
simultaneously becomes a magical instrument (called a spell) with 0.01
power, and has the category specified in its Plaintext. The mages and
apprentices of a spellweave are also the mages and apprentices of its
respective spell. The Fingerprint of a spellweave is sufficient to specify
the spell its Plaintext becomes.

Spells CANNOT:
- amend, modify, extend, reduce the ruleset or the rules, rules to the
contrary notwithstanding.
- create any instruments, rules to the contrary notwithstanding
- make anything IMPOSSIBLE
- specify conditions for winning
- specify wins
- cause a paradox

Spells CAN, but are not limited to:
- make a mess
- wreak havoc
- exist

Spells cease to exist (are cancelled) at the beginning of the month after
they are created, unless otherwise specified by rules of power 1 or
greater. A spell that is cancelled based on time "expires".

In a conflict between spells, if there is otherwise no precedence, the
spell that was woven first takes precedence, simultaneity to the contrary
notwithstanding.

In a conflict between spells, if one takes precedence over another due to
this rule, it happens before the other's effect, rules and simultaneity to
the contrary notwithstanding.

If a spell would be part of a judgement that is PARADOXICAL, all spells
involved in the judgement are miscast, and instead cancelled before taking
further effect.

CFJs CAN, optionally by announcenemt, be submitted to the Archmage, but
SHALL NOT unless the CFJ relates to spells. CFJs submitted to the Archmage
CAN and are ENCOURAGED to be judged by any player who is not the submitter
and is not barred from the CFJ, in order to expedite the ensuing
thaumaturgic machinations.

When the office of Archmage becomes vacant, all spells are cancelled and
all spellweaving is cancelled, rules to the contrary notwithstanding. The
Archmage SHALL NOT cause eir office to become vacant, this is a Class 40
violation.
}

Enact the following rule entitled "Lower Realms" with power=0.5:
{
The following are additional categories of magic, and their effect.
Categories higher on this list takes precedence over categories lower on
the list, unless otherwise specified by this rule.
- Seraphic: The only effect a seraphic spell CAN have is to cancel exactly
one specified, non-seraphic spell. When a seraphic spell cancels a spell,
it also becomes cancelled.
- Transmogrification: A transmogrification spell CAN ONLY alter definitions
in every spell that happens after it. Transmogrification spells do not
expire.
- Alacritous: Alacritous spells are cancelled after they take effect.
- Eldritch: An eldritch spell CANNOT be violated. If an eldritch spell were
to otherwise be violated, all spells involved in the violation are instead
miscast and cancelled before taking effect, thus preventing the IMPOSSIBLE
violation. Eldritch spells do not expire.
- Quantum: A quantum spell has no effect when it begins existing the first
time. After a quantum spell is cancelled the first time, it is recreated
and begins taking effect. Quantum spells do not expire.
- Feral: Feral spells have no effect except in the context of a Zymotic
spell.
- Zymotic: The text describing zymotic spells is to be considered as the
combination of all extant feral spells in order of spellweaving, with this
text being the default text if no other text exists.
- Lapidarian: Lapidarian spells take precedence over alacritous spells.
- Psionic: A psionic spell CAN ONLY combine exactly two specified, existing
spells in their entirety, but in the specified order. Spells combined this
way are referred to by either fingerprint, have the combined set of mages
and apprentices of the original spells, and have all the categories of the
combined spells. Spells combined this way are considered a new spell that
has started existing for the first time.
}
(
some notes:
- meant for there to be some "rock paper scissors" dynamic here, but I had
left room for others to have more magical categories... then I filled that
room myself.
- Made mages just auto-obtain blots most of the time, to prevent work being
done by the Referee. (requires power 1.7)
- didn't want to give too much advantage for being early in a month: so
made it have some simultaneous nature and otherwise lack of precedence
between instruments (requires power 2)
- this is intended to be a blot engine as players figure out a scam they
*might* be able to do, barring magical interference.
- requiring 1 support means that you probably have to share what magic you
plan to do to get that support, so who do you trust? a team of 2 can get
you somewhere, but it's public that that is the team...
)"""
            )
        }
    }

    voting {
        votes(snail) {
            FOR on 9009
            FOR on 9010
        }

        votes(juan) {
            PRESENT on 9009
            PRESENT on 9010
        }

        votes(kiako) {
            FOR on 9009
            AGAINST on 9010
        }

        votes(Forest) {
            FOR on 9009
            AGAINST on 9010
        }

        votes(Kate) {
            FOR on 9009
            AGAINST on 9010
        }

        votes(Janet) {
            FOR on 9009
            AGAINST on 9010
        }

        votes(Murphy) {
            FOR on 9009
            AGAINST on 9010
        }
    }
}
