package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.votes.endorse
import org.agoranomic.assessor.lib.UseAssessment
import org.agoranomic.assessor.lib.VoteKind.*

@UseAssessment
fun `assessment 8280 to 8286`() = assessment {
    name("8280-8286")
    quorum(4)

    strengths {
        default(3)
    }

    proposals {
        proposal(8280) {
            title("Resolve the troubles v1.1")
            ai(3.0)
            author(Murphy)
            coauthors(JasonCobb)

            text(
                """
If Proposal 8279 (Equitable Detroubling) has been adopted, then do
nothing. Otherwise, ratify the following ~~~-delimited document:

~~~
Each of the following messages was effectively sent via the Public Forum
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

        proposal(8281) {
            title("Nothing to see here, Rule 1030 v2")
            ai(1.0)
            author(Gaelan)

            text(
                """
Create a power-0.1 rule titled "Nothing to see here, Rule 1030,” with the
following text: {
  This rule takes precedence over That One Rule, provisions of That One Rule
  notwithstanding. That One Rule is defined as the rule that Gaelan has most
  recently declared, by announcement, to be That One Rule.

  Additionally, this rule takes precedence over all rules other than Rule 1030,
  provisions of That One Rule notwithstanding.

  Gaelan CAN, by announcement, award emself the patent title of “The
  Powerless”.
}"""
            )
        }

        proposal(8282) {
            title("Let's do this the hard way v1.1")
            ai(1.0)
            author(Falsifian)

            text(
                """
[Begin comment:

The purpose is to reduce uncertainty about the status of messages sent
while the mailing list was having trouble by undoing most of the
actions that happened during that period. I just skimmed the messages
on agora-business, agora-official and the backup list that were sent
during that period.

This doesn't deal with everything: specifically, it doesn't handle:

a) the distribution of Proposal 8277
b) the status of the Prime Minister election
c) the judge of CFJ 3783 (the Arbitor attempted to recuse twg from CFJ
3783 and assign it to omd during the outage)
d) self-ratification of reports

Hopefully these can be handled separately, and (d) may stop being an
issue once future reports self-ratify.

Conditionally setting Comptrollor to vacant isn't an exact reversal,
but hopefully shouldn't be too controversial.

Some other uncertainties should hopefully go away
as reports self-ratify. If not, we can handle them separately. In
particular: 1. I wasn't sure what to do about Proposal 8277's possible
distribution, and 2. reports may have self-ratified during that
period.

end comment]

Within the text of this proposal, The Troubles is defined as the period
starting at 00:15 UTC on Dec 14, 2019 and ending at 01:45 UTC on Dec
28, 2019.

Destroy any Coins that were earned during The Troubles and/or as
rewards for documents published during The Troubles.

Reverse any changes to Karma that happened during The Troubles.

If the Officeholder of Comptroller has not changed since the end of
The Troubles, set it to vacant.

Destroy any CFJs created during The Troubles."""
            )
        }

        proposal(8283) {
            title("Ex Post Ribbon")
            ai(3.0)
            author(Alexis)

            text(
                """
Amend rule 2438 (Ribbons) by changing "When a proposal is adopted and
changes at least one rule with Power >= 3, its proposer earns a Red
Ribbon." to "When a proposal is adopted and changes at least one rule that,
immediately before or after the change, has Power >= 3, its proposer earns
a Red Ribbon.""""
            )
        }

        proposal(8284) {
            title("Line-Item Power")
            ai(3.0)
            author(Alexis)

            text(
                """
Change the power of Rule 2597 (Line-Item Veto) to 3."""
            )
        }

        proposal(8285) {
            title("Line-Item Roulette")
            ai(3.0)
            author(Alexis)

            text(
                """
Amend Rule 2518 (Determinacy) by adding a new paragraph reading "The above
notwithstanding, any information defined by the rules as indeterminate is
indeterminate to the extent specified by the rules."

Amend Rule 2597 (Line-Item Veto) by appending "For the purposes of
evaluating conditional votes, it is indeterminate whether any provision of
any proposal has been vetoed." to the final paragraph."""
            )
        }

        proposal(8286) {
            title("I Forbid Vetos!")
            ai(1.0)
            author(Aris)

            text(
                """
Repeal Rule 2597, "Line-item Veto"."""
            )
        }
    }

    voting {
        votes(Gaelan) {
            PRESENT on 8280
            FOR on 8281
            PRESENT on 8282
            FOR on 8283
            PRESENT on 8284
            FOR on 8285
            AGAINST on 8286
        }

        votes(twg) {
            PRESENT on 8280
            AGAINST on 8281
            PRESENT on 8282
            endorse(Alexis) on 8283
            AGAINST on 8284
            endorse(Alexis) on 8285
            endorse(Aris) on 8286
        }

        votes(JasonCobb) {
            AGAINST on 8280
            FOR on 8281
            AGAINST on 8282
            AGAINST on 8283
            FOR on 8284
            AGAINST on 8285
            PRESENT on 8286
        }
    }
}
