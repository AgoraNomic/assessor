package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

// Reflects addition of Webmastor created by P8388, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html.
//
// The proposal does not specify interests for the new office, so it stays at the default (the empty list).
val INTERESTS_MAP_JUN_03: Map<OfficeJune3, List<Ministry>> =
    INTERESTS_MAP_APR_02
        .mapKeys { (k, _) -> OfficeJune3.fromInitial(k) }
        .toPersistentMap()
        .mutate { interests ->
            interests[OfficeJune3.Webmastor] = listOf()
        }

private val MINISTRIES_BONUS_JUN_03 = VotingStrength(2)

fun GlobalVotingStrengthReceiver.ministriesJun03(
    officeMap: OfficeMap<OfficeJune3>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_JUN_03,
    MINISTRIES_BONUS_JUN_03,
    proposals
)
