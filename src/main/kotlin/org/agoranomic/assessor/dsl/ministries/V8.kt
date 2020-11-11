package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects flipping of Coopor's interest to [Participation] by Murphy on 2 August 2020.
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2020-August/044365.html
val INTERESTS_MAP_2020_08_02 =
    INTERESTS_MAP_2020_07_26
        .toPersistentMap()
        .mutate {
            it[OfficeJune30.Coopor] = listOf(MinistryV1.Participation)
        }

private val MINISTRIES_BONUS_2020_08_02 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministries_2020_08_02(
    officeMap: OfficeMap<OfficeJune30>,
    proposals: ProposalSet,
) = ministriesV1(
    officeMap,
    INTERESTS_MAP_2020_08_02,
    MINISTRIES_BONUS_2020_08_02,
    proposals
)
