package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.VotingStrengthReceiver
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrength

typealias V1Office = V0Office
typealias V1Ministry = V0Ministry

// These interests come from V0 and P8318 (Notorial Economy) which set the Notary's interest to [Economy]
val V1_INTERESTS_MAP: Map<V1Office, List<V1Ministry>> = V0_INTERESTS_MAP.toPersistentMap().mutate { interests ->
    interests[V1Office.Notary] = listOf(V1Ministry.Economy)
}

private val V1_MINISTRY_BONUS = VotingStrength(2)

fun VotingStrengthReceiver.v1Ministries(
    officeMap: Map<V0Office, Person?>,
    chamberBlock: ProposalChamberReceiver<V0Ministry>.() -> Unit
) = ministries(
    officeMap,
    V1_INTERESTS_MAP,
    V1_MINISTRY_BONUS,
    chamberBlock
)
