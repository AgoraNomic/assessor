package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.Ministry
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// These interests come from the original proposal - P8291
val INTERESTS_MAP_2020_01_29 = mapOf(
    ADoP to listOf(
        Ministry.Efficiency
    ),
    Arbitor to listOf(
        Ministry.Justice
    ),
    Assessor to listOf(
        Ministry.Efficiency,
        Ministry.Legislation
    ),
    Herald to listOf(
        Ministry.Participation
    ),
    PrimeMinister to listOf(
        Ministry.Justice,
        Ministry.Efficiency,
        Ministry.Legislation,
        Ministry.Participation,
        Ministry.Economy
    ),
    Promotor to listOf(
        Ministry.Legislation
    ),
    Referee to listOf(
        Ministry.Justice
    ),
    Registrar to listOf(
        Ministry.Efficiency
    ),
    Rulekeepor to listOf(
        Ministry.Legislation,
        Ministry.Participation
    ),
    Tailor to listOf(
        Ministry.Participation
    ),
    Treasuror to listOf(
        Ministry.Economy,
        Ministry.Economy
    )
)

private val MINISTRIES_BONUS_2020_01_29 = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_01_29(
    officeMap: OfficeMap<OfficeInitial>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_2020_01_29,
    MINISTRIES_BONUS_2020_01_29,
    proposals
)
