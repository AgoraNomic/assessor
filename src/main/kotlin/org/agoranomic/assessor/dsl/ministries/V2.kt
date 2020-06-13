package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.Ministry
import org.agoranomic.assessor.lib.VotingStrengthDifference
import org.agoranomic.assessor.lib.proposal_set.ProposalSet

// These interests come from https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2020-April/042508.html,
// in which Murphy flipped the interests of Comptrollor, Distributor, and Speaker.
val INTERESTS_MAP_APR_02: Map<OfficeInitial, List<Ministry>> =
    INTERESTS_MAP_FEB_13
        .toPersistentMap()
        .mutate { interests ->
            interests[OfficeInitial.Comptrollor] = listOf(Ministry.Legislation)
            interests[OfficeInitial.Distributor] = listOf(Ministry.Participation)

            interests[OfficeInitial.Speaker] =
                listOf(
                    Ministry.Justice,
                    Ministry.Efficiency,
                    Ministry.Legislation,
                    Ministry.Participation,
                    Ministry.Economy
                )
        }

private val MINISTRIES_BONUS_APR_02 = VotingStrengthDifference(2)

fun GlobalVotingStrengthReceiver.ministriesApr02(
    officeMap: OfficeMap<OfficeInitial>,
    proposals: ProposalSet
) = ministries(
    officeMap,
    INTERESTS_MAP_APR_02,
    MINISTRIES_BONUS_APR_02,
    proposals
)
