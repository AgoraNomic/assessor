package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.dsl.assessment
import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.ministries.endorseOfficer
import org.agoranomic.assessor.dsl.ministries.ministries_2020_04_02
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
fun assessment8357to8365() = assessment {
    name("8357-8365")
    url("https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-April/013569.html")
    quorum(7)

    val offices = officeMapOf(
        ADoP to Murphy,
        Arbitor to G,
        Assessor to Janet,
        Comptrollor to Kate,
        Distributor to omd,
        Herald to Alexis,
        Notary to Gaelan,
        PrimeMinister to Aspen,
        Promotor to Aspen,
        Referee to Kate,
        Registrar to Falsifian,
        Rulekeepor to Janet,
        Speaker to Kate,
        Tailor to Kate,
        Treasuror to Kate
    )

    strengths {
        default(3)
        min(0)
        max(15)

        addToHolder(offices, Speaker, 1)
        ministries_2020_04_02(offices, allProposals)
    }

    proposals(v1) {
        proposal(8357) {
            title("Homework extension fail")
            ai("1.0")
            author(G)
            chamber(Participation)

            text(
                """
Amend Rule 2327 (Read the Ruleset Week) by deleting the second paragraph.

[For reference, it's the "... in the year 2020, Read the Ruleset Week is,
instead, the week of February 24 - March 1" paragraph]."""
            )
        }

        proposal(8358) {
            title("No zombie blot creation v2")
            ai("2.0")
            author(Janet)
            coauthors(Alexis)
            chamber(Justice)

            text(
                """
Amend Rule 2532 (Zombies) by inserting the following list item before
the item that says "deregister.":

    - create blots;

Expunge each blot that a zombie's master caused that zombie to create.

[First attempt was ineffective due to typo in "self-punishment"
proposal. Masters should not be able to hurt their zombies in this way.]"""
            )
        }

        proposal(8359) {
            title("Karmic Linkage")
            ai("1.0")
            author(Alexis)
            chamber(Participation)

            text(
                """
Amend rule 2510 (Such is Karma) by inserting the following as a new
paragraph after the first list:

"The reasons for provided for the gain and loss of karma SHOULD, but
NEED NOT, be related to one another.""""
            )
        }

        proposal(8360) {
            title("Social Distancing")
            ai("3.0")
            author(Alexis)
            democratic()

            text(
                """
Enact a new power-3.01 rule entitled "Eclipse Light", reading as follows:
{{
  An emergency message is one whose subject line contains the text
"[Emergency]".

  The Prime Minister CAN, in an emergency message and with 3 Agoran
  consent, enact, amend, or repeal Emergency Regulations, provided that
  the intent to do so was also contained in an emergency message.

  Emergency Regulations CAN:
    - Extend any deadline provided for by any instrument other than this
  rule, including a deadline for an obligation to be met, or deadline
  prior to which an action must be performed in order to be valid, such
  as the end of voting period. Such an extension CANNOT cause the total
  time period, such as the time from when an obligation was created to
  the deadline or the whole of a voting period, to be more than double
  its original length.
    - Create, destroy, or transfer assets, or require or forbid their
  creation, destruction, or transfer.
    - Cause one or more players to win Agora.
    - Appoint or remove officeholders.
    - Modify the Festivity.
    - Award Patent Titles not mentioned in any Rule and Badges.
    - Modify the Publicity of Fora.

  The Prime Minister CAN, in an emergency message and with 4 Agoran
  Consent, provided that the intent to do so was also contained in an
  emergency message, Extend the Emergency.

  If the Prime Minister has not Extended the Emergency in the past
  month, any player CAN cause this rule to repeal all Emergency
  Regulations and then itself.

  If the Prime Minister has not sent a message to a public forum in the
  preceding four days, the Speaker CAN exercise eir powers under this
  rule as if e were the Prime Minister, and notwithstanding any rule
  that would prohibit a single player from holding both offices.
}}

[I don't think we actually need an emergency rule. But deadline
extensions might be nice, and I figure a little bit of levity might
help us all.]

[Knowing us, we will manage to not only pass it too late, but also too soon.]"""
            )
        }

        proposal(8361) {
            title("Fix Emergencies")
            ai("3.0")
            author(Aspen)
            coauthors(Alexis)
            democratic()

            text(
                """
Amend the rule entitled "Eclipse Light" by changing the text
  "If the Prime Minister has not Extended the Emergency in the past
  month, any player CAN cause this rule to repeal all Emergency
  Regulations and then itself."
to read
  "If there is an Emergency Regulation that has existed for at least a month
  and the Prime Minister has not Extended the Emergency in the past month, any
  player CAN, by announcement, cause this rule to repeal all Emergency
  Regulations and then itself.""""
            )
        }

        proposal(8362) {
            title("Recurring Emergencies")
            ai("3.0")
            author(Aspen)
            democratic()

            text(
                """
Amend the rule entitled "Eclipse Light" by deleting the text "and then itself"."""
            )
        }

        proposal(8363) {
            title("Somebody gets a coin")
            ai("1.0")
            author(Warrigal)
            chamber(Economy)

            text(
                """
Enact a power-1 rule titled "A Coin Award":
  {
      When this rule is enacted, a player other than the
      author of the proposal which enacted this rule earns 1
      coin. Then, if a player earned a coin this way, this
      rule repeals itself.
  }"""
            )
        }

        proposal(8364) {
            title("Mint Regulations")
            ai("3.0")
            author(Aspen)
            democratic()

            text(
                """
Amend Rule 2166, "Assets", by changing the text "A rule defined asset is
public" to read "An asset defined by rule or regulation is public".

Amend Rule 2464, "Tournaments", by appending the text
  "A Tournament's regulations collectively have Mint Authority.".

If there is a Rule entitled "Eclipse Light", amend it by adding, after
the list item beginning "Create, destroy, or transfer assets", a new
list item in the same format as the rest of the list with the text
"Collectively, exercise Mint Authority""""
            )
        }

        proposal(8365) {
            title("Emergency Termination Notice")
            ai("3.0")
            author(Aspen)
            democratic()

            text(
                """
[This gives everyone a bit of warning before someone goes and repeals the
Emergency Regulations, and gives the PM time to potentially extend
the emergency. Note that explicitly specifying the deadline in this rule
means that it can't be extended further.]

Amend the rule entitled "Eclipse Light" by changing the text
  "If there is an Emergency Regulation that has existed for at least a month
  and the Prime Minister has not Extended the Emergency in the past month, any
  player CAN, by announcement, cause this rule to repeal all Emergency
  Regulations and then itself."
to read
  "If there is an Emergency Regulation that has existed for at least a month
  and the Prime Minister has not Extended the Emergency in the past month, any
  player CAN, with 7 days notice, cause this rule to repeal all Emergency
  Regulations and then itself.""""
            )
        }
    }

    voting {
        votes(RLee) {
            AGAINST on 8359
            AGAINST on 8363
            FOR on others
        }

        votes(PSS) {
            FOR on 8357
            FOR on 8358
            FOR on 8359
            FOR on 8360
            FOR on 8361
            FOR on 8362
            AGAINST on 8363
            FOR on 8364
            FOR on 8365
        }

        votes(sukil) {
            FOR on 8357
            FOR on 8358
            FOR on 8359
            FOR on 8360
            FOR on 8361
            FOR on 8362
            FOR on 8363
            FOR on 8364
            FOR on 8365
        }

        votes(Aspen) {
            FOR on 8357
            FOR on 8358
            AGAINST on 8359
            FOR on 8360
            FOR on 8361
            PRESENT on 8362
            FOR on 8363
            FOR on 8364
            FOR on 8365
        }

        votes(Janet) {
            FOR on 8357
            FOR on 8358
            AGAINST on 8359
            FOR on 8360
            FOR on 8361
            FOR on 8362
            FOR on 8363
            FOR on 8364
            FOR on 8365
        }

        votes(Rance) {
            endorse(Janet) on all
        }

        votes(Murphy) {
            FOR on 8357
            FOR on 8358
            FOR on 8359
            FOR on 8360
            FOR on 8361
            FOR on 8362
            AGAINST on 8363
            FOR on 8364
            FOR on 8365
        }

        votes(Alexis) {
            FOR on all
        }

        votes(G) {
            AGAINST on 8359
            FOR on others
        }

        votes(o) {
            endorse(G) on all
        }

        votes(Falsifian) {
            endorse(G) on 8357 comment NO_VETO
            endorseOfficer(offices, Referee) on 8358
            AGAINST on 8359
            endorse(Alexis) on 8360
            endorse(Aspen) on 8361
            PRESENT on 8362
            AGAINST on 8363 comment legacyConditionalComment("No document purporting to be a Treasuror's report has been published in the past 7 days")
            endorse(Aspen) on 8364
            endorse(Aspen) on 8365
        }
    }
}
