package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// Reflects removal of Comptrollor by P8400, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html.
val INTERESTS_MAP_2020_06_03: Map<Office_2020_06_03, List<MinistryV1>> =
    INTERESTS_MAP_2020_06_03_WEBMASTOR
        .filterKeys { it != Office_2020_06_03_Webmastor.Comptrollor }
        .mapKeys { (k, _) -> Office_2020_06_03.fromWebmastor(k) }

private val MINISTRIES_BONUS_2020_06_03 = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_06_03(
    officeMap: OfficeMap<Office_2020_06_03>,
    proposals: ProposalSet,
) = ministriesV1(
    officeMap,
    INTERESTS_MAP_2020_06_03,
    MINISTRIES_BONUS_2020_06_03,
    proposals
)
