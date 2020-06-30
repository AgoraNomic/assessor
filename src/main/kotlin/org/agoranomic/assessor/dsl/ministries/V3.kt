package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.VotingStrengthDifference
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

// Reflects addition of Webmastor created by P8388, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html.
//
// The proposal does not specify interests for the new office, so it stays at the default (the empty list).
val INTERESTS_MAP_JUN_03_WEBMASTOR: Map<OfficeJune3Webmastor, List<Ministry>> =
    INTERESTS_MAP_APR_02
        .mapKeys { (k, _) -> OfficeJune3Webmastor.fromInitial(k) }
        .toPersistentMap()
        .mutate { interests ->
            interests[OfficeJune3Webmastor.Webmastor] = listOf()
        }

private val MINISTRIES_BONUS_JUN_03_WEBMASTOR = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministriesJun03Webmastor(
    officeMap: OfficeMap<OfficeJune3Webmastor>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_JUN_03_WEBMASTOR,
    MINISTRIES_BONUS_JUN_03_WEBMASTOR,
    proposals
)