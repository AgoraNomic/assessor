package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.dsl.receivers.quorum
import org.agoranomic.assessor.dsl.receivers.url
import org.agoranomic.assessor.lib.vote.VoteKind.*

@UseAssessment
fun assessment8277to8279() = assessment {
    name("8277-8279")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-January/013319.html")
    quorum(3)

    strengths {
        default(3)
        min(0)
        max(5)
    }

    proposals(v0) {
        proposal(8277) {
            title("Minor Giveaway")
            ai("1.0")
            author(G)

            text(
                """
I transfer 5 coins to each active player, in the order that they
are listed in the most recent Registrar's Weekly Report."""
            )
        }

        proposal(8278) {
            title("Resolve the troubles")
            ai("3.0")
            author(Murphy)

            text(
                """
[The normal standard set by CFJ 1905 is "a message has not been sent via
  a forum until most persons who have arranged to receive messages via
  the forum receive it". This is a sensible place to draw the line, but
  verifying that for a whole set of messages is arguably more trouble
  than it's worth. AFAIK no scams were attempted, apart from a Win by
  Apathy that was already objected to; and even once we verify that a
  message was received by enough people, we still have to keep track of
  which of those messages have or haven't already been verified.

H. Distributor omd advises that the problems started on Dec 14, so this
includes all messages from the a-o and a-b archives from Dec 13 onward.]

Ratify the following ~~~-delimited document:

~~~
Each of the following messages was effectively sent to the Public Forum
on or about the Date: stamp shown in the archives. Claims within these
messages (in particular, claims to perform actions) may still be
ineffective for other reasons.

Relevant messages from
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2019-December/date.html

BUS: Re: OFF: [Treasuror] Forbes 500   James Cook
OFF: [Rulekeepor] Short Logical Ruleset   Jason Cobb
BUS: Re: OFF: [Treasuror] Forbes 500   James Cook
OFF: [Promotor] Distribution of Proposal 8277   Aris Merchant
OFF: [Registrar] Agoran Directory   James Cook
OFF: [Registrar] Forbes 500   James Cook
OFF: [Rulekeepor] Full Logical Ruleset: October 2019   James Cook
OFF: Round 2, fight!   Edward Murphy
OFF: Fwd: [dicelog] Selection of Comptrollor   Edward Murphy
OFF: [ADoP] Metareport   Edward Murphy
OFF: [Distributor] list status   omd
OFF: [Arbitor] CFJ 3783 Assigned to omd   Kerim Aydin
OFF: [Registrar] Agoran Directory   James Cook
OFF: [Treasuror] Forbes 500   James Cook
OFF: [Distributor] list status   omd
Fwd: OFF: [Distributor] list status   omd
OFF: [ADoP] Metareport   Edward Murphy

Relevant messages from
https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2019-December/date.html

BUS: Re: OFF: [Treasuror] Forbes 500   James Cook
BUS: Re: OFF: [Treasuror] Forbes 500   James Cook
BUS: Re: OFF: [Rulekeepor] Short Logical Ruleset   Jason Cobb
BUS: Judgement of CFJs 3780 and 3782   James Cook
BUS: Judgement of CFJs 3780 and 3782   James Cook
BUS: Re: OFF: [Arbitor] CFJ 3779 Assigned to Jason Cobb   James Cook
DIS: Re: BUS: Re: OFF: [Arbitor] CFJ 3779 Assigned to Jason Cobb   James
Cook
BUS: End of Zombie lease   James Cook
BUS: Re: [Promotor] Distribution of Proposal 8277   Aris Merchant
BUS: Re: OFF: [Registrar] Forbes 500   James Cook
BUS: Income   James Cook
BUS: Re: OFF: [Rulekeepor] Short Logical Ruleset   James Cook
BUS: Notice of Honour   James Cook
BUS: Re: OFF: [Promotor] Distribution of Proposal 8277   Edward Murphy
BUS: Resolution of Prime Minister election   Edward Murphy
BUS: Vote on Proposal 8277   James Cook
BUS: PM Candidacy   James Cook
BUS: Might as well try   James Cook
BUS: Might as well try   Jason Cobb
BUS: Might as well try   omd
BUS: CoE on ADoP report   James Cook
BUS: Notice of Honour   James Cook
BUS: Re: OFF: [Distributor] list status   Aris Merchant
BUS: Re: OFF: [Promotor] Distribution of Proposal 8277   Jason Cobb
BUS: Favoring   Aris Merchant
BUS: CoE on ADoP report   Edward Murphy
BUS: Re: OFF: [ADoP] Metareport   Edward Murphy
BUS: Income   James Cook
BUS: Re: OFF: [Rulekeepor] Full Logical Ruleset: October 2019   James Cook
BUS: Re: OFF: [Rulekeepor] Short Logical Ruleset   James Cook
BUS: PM Candidacy   James Cook
BUS: Re: OFF: [Registrar] Agoran Directory   James Cook
BUS: End of Zombie lease   James Cook
BUS: Re: OFF: [Registrar] Agoran Directory   James Cook
BUS: Re: DIS: [MUD] New Agoran MUD   Aris Merchant
BUS: Income   James Cook
BUS: Re: OFF: [Treasuror] Forbes 500   James Cook
BUS: I like money too   Edward Murphy
BUS: PM Candidacy   Edward Murphy
BUS: PM Candidacy   Edward Murphy
BUS: PM Candidacy   Edward Murphy
BUS: I still like money   Edward Murphy
BUS: PM Candidacy   Jason Cobb
~~~"""
            )
        }

        proposal(8279) {
            title("Equitable Detroubling")
            ai("3.0")
            author(Aris)
            coauthors(Murphy)

            text(
                """
Ratify the following ~~~-delimited document:

~~~
No message sent to the fora agora-official or agora-business between
Dec 14 00:15:00 UTC 2019 and Dec 28 01:45:00 UTC 2019 is, or was ever,
a public message.
~~~"""
            )
        }
    }

    voting {
        votes(Murphy) {
            FOR on 8277
            FOR on 8278
            FOR on 8279 comment conditional("Proposal 8278 does not have sufficient votes to be adopted")
        }

        votes(Aris) {
            FOR on 8277
            AGAINST on 8278
            FOR on 8279
        }

        votes(G) {
            FOR on 8277
            FOR on 8278
            AGAINST on 8279
        }

        votes(Rance) {
            FOR on 8278
            AGAINST on 8279
        }

        votes(Gaelan) {
            FOR on 8277
            PRESENT on 8278
            PRESENT on 8279
        }

        votes(Falsifian) {
            FOR on 8277 comment NO_VETO
            AGAINST on 8278
            AGAINST on 8279
        }

        votes(Jason) {
            FOR on 8277
            AGAINST on 8278
            PRESENT on 8279
        }
    }
}
