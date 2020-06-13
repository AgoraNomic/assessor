package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.VotingStrengthDifference
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

// These interests come from V0 and P8318 (Notorial Economy) which set the Notary's interest to [Economy]
val INTERESTS_MAP_FEB_13: Map<OfficeInitial, List<Ministry>> =
    INTERESTS_MAP_JAN_29
        .toPersistentMap()
        .mutate { interests -> interests[OfficeInitial.Notary] = listOf(Ministry.Economy) }

private val MINISTRIES_BONUS_FEB_13 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministriesFeb13(
    officeMap: OfficeMap<OfficeInitial>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_FEB_13,
    MINISTRIES_BONUS_FEB_13,
    proposals
)
