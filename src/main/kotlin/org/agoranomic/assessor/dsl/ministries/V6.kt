package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.VotingStrengthDifference
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

// Reflects addition of Coopor by P8442 with no interest set, adopted 30 June 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013879.html
val INTERESTS_MAP_JUN_30 =
    INTERESTS_MAP_JUN_15
        .toPersistentMap()
        .mapKeys { (k, _) -> OfficeJune30.fromJune3(k) }
        .toPersistentMap()
        .mutate { it[OfficeJune30.Coopor] = emptyList() }

private val MINISTRIES_BONUS_JUN_30 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministriesJun30(
    officeMap: OfficeMap<OfficeJune30>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_JUN_30,
    MINISTRIES_BONUS_JUN_30,
    proposals
)
