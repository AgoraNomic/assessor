package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects flipping of Notary's interest to [Economy, Participation] by Murphy on 26 July 2020.
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2020-July/044291.html
val INTERESTS_MAP_2020_07_26 =
    INTERESTS_MAP_2020_06_30
        .toPersistentMap()
        .mutate { it[OfficeJune30.Notary] = listOf(MinistryV1.Economy, MinistryV1.Participation) }

private val MINISTRIES_BONUS_2020_07_26 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministries_2020_07_26(
    officeMap: OfficeMap<OfficeJune30>,
    proposals: ProposalSet,
) = ministriesV1(
    officeMap,
    INTERESTS_MAP_2020_07_26,
    MINISTRIES_BONUS_2020_07_26,
    proposals
)
