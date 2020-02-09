package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.ProposalStrengthReceiver
import org.agoranomic.assessor.dsl.receivers._VotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrength

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

enum class V0Ministry {
    Justice,
    Efficiency,
    Legislation,
    Participation,
    Economy,
    ;
}

// These interests come from the original proposal - P8291
val V0_INTERESTS_MAP = mapOf(
    V0Office.ADoP to listOf(
        V0Ministry.Efficiency
    ),
    V0Office.Arbitor to listOf(
        V0Ministry.Justice
    ),
    V0Office.Assessor to listOf(
        V0Ministry.Efficiency,
        V0Ministry.Legislation
    ),
    V0Office.Herald to listOf(
        V0Ministry.Participation
    ),
    V0Office.PrimeMinister to listOf(
        V0Ministry.Justice,
        V0Ministry.Efficiency,
        V0Ministry.Legislation,
        V0Ministry.Participation,
        V0Ministry.Economy
    ),
    V0Office.Promotor to listOf(
        V0Ministry.Legislation
    ),
    V0Office.Referee to listOf(
        V0Ministry.Justice
    ),
    V0Office.Registrar to listOf(
        V0Ministry.Efficiency
    ),
    V0Office.Rulekeepor to listOf(
        V0Ministry.Legislation,
        V0Ministry.Participation
    ),
    V0Office.Tailor to listOf(
        V0Ministry.Participation
    ),
    V0Office.Treasuror to listOf(
        V0Ministry.Economy,
        V0Ministry.Economy
    )
)

private val V0_MINISTRY_BONUS = VotingStrength(2)

fun _VotingStrengthReceiver.v0Ministries(
    officeMap: Map<V0Office, Person?>,
    chamberBlock: ProposalChamberReceiver<V0Ministry>.() -> Unit
) = ministries(
    officeMap,
    V0_INTERESTS_MAP,
    V0_MINISTRY_BONUS,
    chamberBlock
)
