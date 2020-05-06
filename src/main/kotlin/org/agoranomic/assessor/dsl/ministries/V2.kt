package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.VotingStrength
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

typealias OfficeV2 = OfficeV1

// These interests come from https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2020-April/042508.html,
// in which Murphy flipped the interests of Comptrollor, Distributor, and Speaker.
val INTERESTS_MAP_V2: Map<OfficeV2, List<Ministry>> = INTERESTS_MAP_V1.toPersistentMap().mutate { interests ->
    interests[OfficeV2.Comptrollor] = listOf(Ministry.Legislation)
    interests[OfficeV2.Distributor] = listOf(Ministry.Participation)
    interests[OfficeV2.Speaker] =
        listOf(Ministry.Justice, Ministry.Efficiency, Ministry.Legislation, Ministry.Participation, Ministry.Economy)
}

private val MINISTRIES_V2_BONUS = VotingStrength(2)

fun GlobalVotingStrengthReceiver.ministriesV2(
    officeMap: OfficeMap<OfficeV2>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_V2,
    MINISTRIES_V2_BONUS,
    proposals
)
