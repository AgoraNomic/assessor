package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// These interests come from V0 and P8318 (Notorial Economy) which set the Notary's interest to [Economy]
val INTERESTS_MAP_2020_02_13: Map<OfficeInitial, List<MinistryV1>> =
    INTERESTS_MAP_2020_01_29
        .toPersistentMap()
        .mutate { interests -> interests[OfficeInitial.Notary] = listOf(MinistryV1.Economy) }

private val MINISTRIES_BONUS_2020_02_13 = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_02_13(
    officeMap: OfficeMap<OfficeInitial>,
    proposals: ProposalSet,
) = ministriesV1(
    officeMap,
    INTERESTS_MAP_2020_02_13,
    MINISTRIES_BONUS_2020_02_13,
    proposals
)
