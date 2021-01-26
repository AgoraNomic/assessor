package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.Office_2020_12_31.*
import org.agoranomic.assessor.dsl.ministries.endorseOfficer
import org.agoranomic.assessor.dsl.ministries.ministries_2020_12_31
import org.agoranomic.assessor.dsl.ministries.officeMapOf
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.votes.addToHolder
import org.agoranomic.assessor.dsl.votes.blotPenalty
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.proposal.MinistryV2.Legacy
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8530to8531() = assessment {
    name("8530-8531")
    quorum(2)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Jason,
        Distributor to omd,
        Herald to nix,
        Ministor to nix,
        Notary to ATMunn,
        PrimeMinister to ATMunn,
        Promotor to Aris,
        Referee to JTAC,
        Registrar to Falsifian,
        Rulekeepor to Jason,
        Speaker to CuddleBeam,
        Stonemason to Jason,
        Tailor to null,
        Treasuror to Trigon,
        Webmastor to nix,
    )

    strengths {
        min(0)
        max(15)
        default(3)

        blotPenalty(RLee, 7 / 3)

        addToHolder(offices, Speaker, 1)
        ministries_2020_12_31(offices, allProposals)
    }

    proposals(v3) {
        proposal(8530) {
            title("No Honour")
            ai("1.0")
            author(nix)
            coauthors(Jason)
            chamber(Legacy)
            sponsored()

            text("""
Repeal R2510, "Such is Karma".

[Karma gets rare, sporadic usage and I'd prefer not to maintain it if
it's not going to be used. I'm also open to supporting efforts to revive
it, but I don't have the time/interest to write such proposals myself
right now.]""")
        }

        proposal(8531) {
            title("Patent Title Restoration v2")
            ai("1.5")
            author(Jason)
            chamber(Legacy)
            sponsored()

            text("""
Amend Rule 649 by replacing "A Patent Title is a legal title given to a
person in recognition of the person's distinction" with "A Patent Title
is a legal title held by an entity in recognition of eir distinction".

[The current version could plausibly be read to strip patent titles when
an entity ceases to be a person. This makes it so that patent titles can
be held by all entities, but can only be awarded to persons. The
requirement on personhood/citizenship is explicit for most awarding
methods (including the Herald's general method), while the other methods
require 2 Agoran consent, which should be enough to prevent them going
to non-persons if we don't want them to as a group. There's not really
an easy place to put an explicit restriction, because some of the 2
Agoran consent methods are at Power 3, while the patent titles rule is
at Power 1.5.]

Award all Patent Titles to eir former holders that were lost solely due
to the entity not being a person (under any current or former definition
of "person"), other than Hero of Agora Nomic or Grand Hero of Agora Nomic.

[Don't try to award HAN/GHAN because it seems unlikely they were ever
stripped and because this proposal doesn't have high enough AI to do so.]""")
        }
    }

    voting {
        votes(Aris) {
            FOR on 8530
            FOR on 8531
        }

        votes(CuddleBeam) {
            FOR on all
        }

        votes(Jason) {
            PRESENT on 8530
            FOR on 8531
        }

        votes(JTAC) {
            FOR on 8530
            endorse(nix) on 8531
        }

        votes(Gaelan) {
            AGAINST on 8530
            endorse(G) on 8531
        }

        votes(Falsifian) {
            // TODO: resolve conditional vote on 8530: FOR if Herald FOR, else AGAINST
            FOR on 8531
        }

        votes(ATMunn) {
            FOR on 8530
            FOR on 8531
        }

        votes(Noah) {
            PRESENT on 8530
            FOR on 8531
        }

        votes(Murphy) {
            endorseOfficer(offices, Herald) on 8530
            FOR on 8531
        }
    }
}
