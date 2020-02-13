package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.VotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

enum class V0Office {
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
val V0_INTERESTS_MAP = mapOf(
    V0Office.ADoP to listOf(
        Ministry.Efficiency
    ),
    V0Office.Arbitor to listOf(
        Ministry.Justice
    ),
    V0Office.Assessor to listOf(
        Ministry.Efficiency,
        Ministry.Legislation
    ),
    V0Office.Herald to listOf(
        Ministry.Participation
    ),
    V0Office.PrimeMinister to listOf(
        Ministry.Justice,
        Ministry.Efficiency,
        Ministry.Legislation,
        Ministry.Participation,
        Ministry.Economy
    ),
    V0Office.Promotor to listOf(
        Ministry.Legislation
    ),
    V0Office.Referee to listOf(
        Ministry.Justice
    ),
    V0Office.Registrar to listOf(
        Ministry.Efficiency
    ),
    V0Office.Rulekeepor to listOf(
        Ministry.Legislation,
        Ministry.Participation
    ),
    V0Office.Tailor to listOf(
        Ministry.Participation
    ),
    V0Office.Treasuror to listOf(
        Ministry.Economy,
        Ministry.Economy
    )
)

private val V0_MINISTRY_BONUS = VotingStrength(2)

fun VotingStrengthReceiver.v0Ministries(
    officeMap: Map<V0Office, Person?>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    V0_INTERESTS_MAP,
    V0_MINISTRY_BONUS,
    proposals
)
