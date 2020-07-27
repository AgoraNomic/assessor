package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects addition of Coopor by P8442 with no interest set, adopted 30 June 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013879.html
val INTERESTS_MAP_2020_06_30 =
    INTERESTS_MAP_2020_06_15
        .toPersistentMap()
        .mapKeys { (k, _) -> OfficeJune30.fromJune3(k) }
        .toPersistentMap()
        .mutate { it[OfficeJune30.Coopor] = emptyList() }

private val MINISTRIES_BONUS_2020_06_30 = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_06_30(
    officeMap: OfficeMap<OfficeJune30>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_2020_06_30,
    MINISTRIES_BONUS_2020_06_30,
    proposals
)
