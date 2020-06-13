package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.VotingStrengthDifference
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

// Reflects flipping of interest of Webmastor to [Participation]
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013805.html
val INTERESTS_MAP_JUN_15: Map<OfficeJune3, List<Ministry>> =
    INTERESTS_MAP_JUN_03
        .toPersistentMap()
        .mutate { it[OfficeJune3.Webmastor] = listOf(Ministry.Participation) }

private val MINISTRIES_BONUS_JUN_15 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministriesJun15(
    officeMap: OfficeMap<OfficeJune3>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_JUN_15,
    MINISTRIES_BONUS_JUN_15,
    proposals
)
