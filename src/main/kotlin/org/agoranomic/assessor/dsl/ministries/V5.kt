package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects flipping of interest of Webmastor to [Participation]
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013805.html
val INTERESTS_MAP_2020_06_15: Map<Office_2020_06_03, List<MinistryV1>> =
    INTERESTS_MAP_2020_06_03
        .toPersistentMap()
        .mutate { it[Office_2020_06_03.Webmastor] = listOf(MinistryV1.Participation) }

private val MINISTRIES_BONUS_2020_06_15 = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_06_15(
    officeMap: OfficeMap<Office_2020_06_03>,
    proposals: ProposalSet,
) = ministriesV1(
    officeMap,
    INTERESTS_MAP_2020_06_15,
    MINISTRIES_BONUS_2020_06_15,
    proposals
)
