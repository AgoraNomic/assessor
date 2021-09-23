package org.agoranomic.assessor.lib.report

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.proposal.*
import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap
import org.agoranomic.assessor.lib.resolve.adoptedProposals
import org.agoranomic.assessor.lib.vote.votersAgainst
import org.agoranomic.assessor.lib.vote.votersFor
import org.randomcat.util.ceil
import org.randomcat.util.compareTo
import java.math.BigDecimal
import java.math.BigInteger

typealias RawProposalUnroundedReward = BigDecimal

@JvmInline
value class ProposalUnroundedReward(val raw: RawProposalUnroundedReward) {
    override fun toString(): String = raw.toString()
}

typealias RawProposalRoundedReward = BigInteger

@JvmInline
value class ProposalRoundedReward(val raw: RawProposalRoundedReward) {
    override fun toString(): String = raw.toString()
}

fun ProposalUnroundedReward.rounded(): ProposalRoundedReward {
    if (raw <= 0) return ProposalRoundedReward(BigInteger.ZERO)

    return ProposalRoundedReward(ceil(raw))
}

private fun calculateReward(
    voteCountFor: BigInteger,
    voteCountAgainst: BigInteger,
): ProposalUnroundedReward {
    return ProposalUnroundedReward((voteCountFor - voteCountAgainst).toBigDecimal())
}

data class ProposalRewardData(
    val author: Person?,
    val voteCountFor: BigInteger,
    val voteCountAgainst: BigInteger,
    val proposalAI: ProposalAI,
) {
    val unroundedReward
        get() =
            calculateReward(
                voteCountFor = voteCountFor,
                voteCountAgainst = voteCountAgainst
            )

    val roundedReward get() = unroundedReward.rounded()
}

data class ProposalRewardsMap(
    private val data: ImmutableMap<ProposalNumber, ProposalRewardData>,
) {
    constructor(data: Map<ProposalNumber, ProposalRewardData>) : this(data.toImmutableMap())

    val proposals get() = data.keys

    operator fun get(proposal: ProposalNumber) = data.getValue(proposal)
}

private fun Proposal.isRewardable(): Boolean {
    return accept(object : ProposalMapper<Boolean> {
        override fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0): Boolean {
            return true
        }

        override fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1): Boolean {
            return true
        }

        override fun visitV2(commonData: ProposalCommonData, versionedData: ProposalDataV2): Boolean {
            return versionedData.sponsored
        }

        override fun visitV3(commonData: ProposalCommonData, versionedData: ProposalDataV3): Boolean {
            return versionedData.sponsored
        }

        override fun visitV4(commonData: ProposalCommonData, versionedData: ProposalDataV4): Boolean {
            return versionedData.sponsored
        }
    })
}

fun calculateRewards(resolutionMap: ProposalResolutionMap): ProposalRewardsMap {
    return ProposalRewardsMap(
        resolutionMap
            .adoptedProposals()
            .filter { it.isRewardable() }
            .associate { proposal ->
                val proposalVotes = resolutionMap.resolutionOf(proposal.number).votes
                val voteCountFor = proposalVotes.votersFor().size.toBigInteger()
                val voteCountAgainst = proposalVotes.votersAgainst().size.toBigInteger()
                val proposalAI = proposal.proposalAI

                val rewardData = ProposalRewardData(
                    author = proposal.author,
                    voteCountFor = voteCountFor,
                    voteCountAgainst = voteCountAgainst,
                    proposalAI = proposalAI,
                )

                proposal.number to rewardData
            }
    )
}

fun rewardsReport(rewardsMap: ProposalRewardsMap): String {
    return rewardsMap
        .proposals
        .mapNotNull { proposal ->
            val rewardData = rewardsMap[proposal]

            val author = rewardData.author ?: return@mapNotNull null
            val voteCountFor = rewardData.voteCountFor
            val voteCountAgainst = rewardData.voteCountAgainst
            val unroundedReward = rewardData.unroundedReward
            val roundedReward = rewardData.roundedReward

            val amountString =
                if ((unroundedReward.raw).compareTo(roundedReward.raw) == 0)
                    roundedReward.toString()
                else
                    "$unroundedReward -> $roundedReward"

            "For the adoption of Proposal $proposal, I grant ${author.name} $voteCountFor-$voteCountAgainst=$amountString boatloads of coins."
        }
        .joinToString("\n")
}
