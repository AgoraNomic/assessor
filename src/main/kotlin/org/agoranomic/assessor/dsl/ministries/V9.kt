package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.ministries.OfficeOct28.*
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV2.*
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects first used set of interests under AdMinistration.
// https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2020-November/045229.html
val INTERESTS_MAP_2020_11_07 = mapOf(
    ADoP to listOf(Participation),
    Arbitor to listOf(Compliance),
    Assessor to listOf(Participation, Legislation),
    Coopor to listOf(Economy),
    Distributor to listOf(Participation),
    Herald to listOf(Legacy),
    Ministor to listOf(Economy),
    Notary to listOf(Compliance, Economy),
    PrimeMinister to listOf(Compliance, Legacy, Legislation, Participation, Economy),
    Promotor to listOf(Participation, Legislation),
    Referee to listOf(Compliance),
    Registrar to listOf(Participation),
    Rulekeepor to listOf(Legislation, Legacy),
    Speaker to listOf(Compliance, Legacy, Legislation, Participation, Economy),
    Tailor to listOf(Participation),
    Treasuror to listOf(Economy, Economy),
    Webmastor to listOf(Participation),
)

private val MINISTRIES_BONUS_2020_08_02 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministries_2020_11_07(
    officeMap: OfficeMap<OfficeOct28>,
    proposals: ProposalSet,
) = ministriesV2(officeMap, INTERESTS_MAP_2020_11_07, MINISTRIES_BONUS_2020_08_02, proposals)
