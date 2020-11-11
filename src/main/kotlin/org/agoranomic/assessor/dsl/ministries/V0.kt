package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// These interests come from the original proposal - P8291
val INTERESTS_MAP_2020_01_29 = mapOf(
    ADoP to listOf(
        MinistryV1.Efficiency
    ),
    Arbitor to listOf(
        MinistryV1.Justice
    ),
    Assessor to listOf(
        MinistryV1.Efficiency,
        MinistryV1.Legislation
    ),
    Herald to listOf(
        MinistryV1.Participation
    ),
    PrimeMinister to listOf(
        MinistryV1.Justice,
        MinistryV1.Efficiency,
        MinistryV1.Legislation,
        MinistryV1.Participation,
        MinistryV1.Economy
    ),
    Promotor to listOf(
        MinistryV1.Legislation
    ),
    Referee to listOf(
        MinistryV1.Justice
    ),
    Registrar to listOf(
        MinistryV1.Efficiency
    ),
    Rulekeepor to listOf(
        MinistryV1.Legislation,
        MinistryV1.Participation
    ),
    Tailor to listOf(
        MinistryV1.Participation
    ),
    Treasuror to listOf(
        MinistryV1.Economy,
        MinistryV1.Economy
    )
)

private val MINISTRIES_BONUS_2020_01_29 = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_01_29(
    officeMap: OfficeMap<OfficeInitial>,
    proposals: ProposalSet,
) = ministriesV1(
    officeMap,
    INTERESTS_MAP_2020_01_29,
    MINISTRIES_BONUS_2020_01_29,
    proposals
)
