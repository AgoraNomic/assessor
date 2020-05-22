package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.ministries.OfficeInitial.*
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

// These interests come from the original proposal - P8291
val INTERESTS_MAP_V0 = mapOf(
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

private val MINISTRIES_V0_BONUS = VotingStrength(2)

fun GlobalVotingStrengthReceiver.ministriesV0(
    officeMap: OfficeMap<OfficeInitial>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_V0,
    MINISTRIES_V0_BONUS,
    proposals
)
