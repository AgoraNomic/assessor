package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects addition of Webmastor created by P8388, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html.
//
// The proposal does not specify interests for the new office, so it stays at the default (the empty list).
val INTERESTS_MAP_2020_06_03_WEBMASTOR: Map<Office_2020_06_03_Webmastor, List<MinistryV1>> =
    INTERESTS_MAP_2020_04_02
        .mapKeys { (k, _) -> Office_2020_06_03_Webmastor.fromInitial(k) }
        .toPersistentMap()
        .mutate { interests ->
            interests[Office_2020_06_03_Webmastor.Webmastor] = listOf()
        }

private val MINISTRIES_BONUS_2020_06_03_WEBMASTOR = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_06_03_Webmastor(
    officeMap: OfficeMap<Office_2020_06_03_Webmastor>,
    proposals: ProposalSet,
) = ministriesV1(
    officeMap,
    INTERESTS_MAP_2020_06_03_WEBMASTOR,
    MINISTRIES_BONUS_2020_06_03_WEBMASTOR,
    proposals
)
