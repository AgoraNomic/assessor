package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.Ministry
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects addition of Webmastor created by P8388, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html.
//
// The proposal does not specify interests for the new office, so it stays at the default (the empty list).
val INTERESTS_MAP_2020_06_03_WEBMASTOR: Map<OfficeJune3Webmastor, List<Ministry>> =
    INTERESTS_MAP_2020_04_02
        .mapKeys { (k, _) -> OfficeJune3Webmastor.fromInitial(k) }
        .toPersistentMap()
        .mutate { interests ->
            interests[OfficeJune3Webmastor.Webmastor] = listOf()
        }

private val MINISTRIES_BONUS_2020_06_03_WEBMASTOR = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_06_03_Webmastor(
    officeMap: OfficeMap<OfficeJune3Webmastor>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_2020_06_03_WEBMASTOR,
    MINISTRIES_BONUS_2020_06_03_WEBMASTOR,
    proposals
)
