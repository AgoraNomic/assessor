package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.Ministry
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects flipping of Notary's interest to [Economy, Participation] by Murphy on 26 July 2020.
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2020-July/044291.html
val INTERESTS_MAP_JUL_26 =
    INTERESTS_MAP_JUN_30
        .toPersistentMap()
        .mutate { it[OfficeJune30.Notary] = listOf(Ministry.Economy, Ministry.Participation) }

private val MINISTRIES_BONUS_JUL_26 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministriesJul26(
    officeMap: OfficeMap<OfficeJune30>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_JUL_26,
    MINISTRIES_BONUS_JUL_26,
    proposals
)
