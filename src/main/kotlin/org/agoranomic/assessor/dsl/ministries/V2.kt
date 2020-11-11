package org.agoranomic.assessor.dsl.ministries

import kotlinx.collections.immutable.mutate
import kotlinx.collections.immutable.toPersistentMap
import org.agoranomic.assessor.dsl.receivers.GlobalVotingStrengthReceiver
import org.agoranomic.assessor.lib.proposal.MinistryV1
import org.agoranomic.assessor.lib.proposal.proposal_set.ProposalSet
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthDifference

// These interests come from https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-business/2020-April/042508.html,
// in which Murphy flipped the interests of Comptrollor, Distributor, and Speaker.
val INTERESTS_MAP_2020_04_02: Map<OfficeInitial, List<MinistryV1>> =
    INTERESTS_MAP_2020_02_13
        .toPersistentMap()
        .mutate { interests ->
            interests[OfficeInitial.Comptrollor] = listOf(MinistryV1.Legislation)
            interests[OfficeInitial.Distributor] = listOf(MinistryV1.Participation)

            interests[OfficeInitial.Speaker] =
                listOf(
                    MinistryV1.Justice,
                    MinistryV1.Efficiency,
                    MinistryV1.Legislation,
                    MinistryV1.Participation,
                    MinistryV1.Economy
                )
        }

private val MINISTRIES_BONUS_2020_04_02 = VotingStrengthDifference(2)

// The underscores are the clearest way to show the date.
@Suppress("FunctionName")
fun GlobalVotingStrengthReceiver.ministries_2020_04_02(
    officeMap: OfficeMap<OfficeInitial>,
    proposals: ProposalSet,
) = ministriesV1(
    officeMap,
    INTERESTS_MAP_2020_04_02,
    MINISTRIES_BONUS_2020_04_02,
    proposals
)
