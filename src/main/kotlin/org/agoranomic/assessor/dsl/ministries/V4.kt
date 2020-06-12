package org.agoranomic.assessor.dsl.ministries

import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

// Reflects removal of Comptrollor by P8400, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html.
val INTERESTS_MAP_JUN_03: Map<OfficeJune3, List<Ministry>> =
    INTERESTS_MAP_JUN_03_WEBMASTOR
        .filterKeys { it != OfficeJune3Webmastor.Comptrollor }
        .mapKeys { (k, _) -> OfficeJune3.fromWebmastor(k) }

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
