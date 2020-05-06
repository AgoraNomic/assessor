package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

enum class OfficeV0 {
    ADoP,
    Arbitor,
    Assessor,
    Comptrollor,
    Distributor,
    Herald,
    Notary,
    PrimeMinister,
    Promotor,
    Referee,
    Registrar,
    Rulekeepor,
    Speaker,
    Tailor,
    Treasuror,
    ;
}

// These interests come from the original proposal - P8291
val INTERESTS_MAP_V0 = mapOf(
    OfficeV0.ADoP to listOf(
        Ministry.Efficiency
    ),
    OfficeV0.Arbitor to listOf(
        Ministry.Justice
    ),
    OfficeV0.Assessor to listOf(
        Ministry.Efficiency,
        Ministry.Legislation
    ),
    OfficeV0.Herald to listOf(
        Ministry.Participation
    ),
    OfficeV0.PrimeMinister to listOf(
        Ministry.Justice,
        Ministry.Efficiency,
        Ministry.Legislation,
        Ministry.Participation,
        Ministry.Economy
    ),
    OfficeV0.Promotor to listOf(
        Ministry.Legislation
    ),
    OfficeV0.Referee to listOf(
        Ministry.Justice
    ),
    OfficeV0.Registrar to listOf(
        Ministry.Efficiency
    ),
    OfficeV0.Rulekeepor to listOf(
        Ministry.Legislation,
        Ministry.Participation
    ),
    OfficeV0.Tailor to listOf(
        Ministry.Participation
    ),
    OfficeV0.Treasuror to listOf(
        Ministry.Economy,
        Ministry.Economy
    )
)

private val MINISTRIES_V0_BONUS = VotingStrength(2)

fun GlobalVotingStrengthReceiver.ministriesV0(
    officeMap: OfficeMap<OfficeV0>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_V0,
    MINISTRIES_V0_BONUS,
    proposals
)
