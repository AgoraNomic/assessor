package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.VotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

typealias OfficeV1 = OfficeV0

// These interests come from V0 and P8318 (Notorial Economy) which set the Notary's interest to [Economy]
val INTERESTS_MAP_V1: Map<OfficeV1, List<Ministry>> = INTERESTS_MAP_V0.toPersistentMap().mutate { interests ->
    interests[OfficeV1.Notary] = listOf(Ministry.Economy)
}

private val MINISTRIES_V1_BONUS = VotingStrength(2)

fun VotingStrengthReceiver.ministriesV1(
    officeMap: Map<OfficeV0, Person?>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_V1,
    MINISTRIES_V1_BONUS,
    proposals
)
