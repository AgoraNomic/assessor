package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

val INTERESTS_MAP_2020_12_31 =
    INTERESTS_MAP_2020_11_07
        .filterKeys { it != Office_2020_10_28.Coopor }
        .mapKeys { (k, _) -> Office_2020_12_31.from_2020_10_28(k) }
        .toPersistentMap()
        .put(Office_2020_12_31.Stonemason, emptyList())

private val MINISTRIES_BONUS_2020_12_31 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministries_2020_12_31(
    officeMap: OfficeMap<Office_2020_12_31>,
    proposals: ProposalSet,
) = ministriesV2(officeMap, INTERESTS_MAP_2020_12_31, MINISTRIES_BONUS_2020_12_31, proposals)
