package org.agoranomic.assessor.lib

import io.github.random_internet_cat.util.ceil
import io.github.random_internet_cat.util.compareTo
import io.github.random_internet_cat.util.getOrFail
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import java.math.BigDecimal
import java.math.BigInteger

typealias RawProposalUnroundedReward = BigDecimal

inline class ProposalUnroundedReward(val raw: RawProposalUnroundedReward) {
    override fun toString(): String = raw.toString()
}

typealias RawProposalRoundedReward = BigInteger

inline class ProposalRoundedReward(val raw: RawProposalRoundedReward) {
    override fun toString(): String = raw.toString()
}

fun ProposalUnroundedReward.rounded(): ProposalRoundedReward {
    if (raw <= 0) return ProposalRoundedReward(BigInteger.ZERO)

    return ProposalRoundedReward(ceil(raw))
}

private fun calculateReward(
    ai: ProposalAI,
    voteCountFor: BigInteger,
    voteCountAgainst: BigInteger
): ProposalUnroundedReward {
    return ProposalUnroundedReward((voteCountFor - voteCountAgainst).toBigDecimal())
}

data class ProposalRewardData(
    val author: Person,
    val voteCountFor: BigInteger,
    val voteCountAgainst: BigInteger,
    val ai: ProposalAI
) {
    val unroundedReward
        get() =
            calculateReward(
                ai = ai,
                voteCountFor = voteCountFor,
                voteCountAgainst = voteCountAgainst
            )

    val roundedReward get() = unroundedReward.rounded()
}

data class ProposalRewardsMap(
    private val data: ImmutableMap<ProposalNumber, ProposalRewardData>
) {
    constructor(data: Map<ProposalNumber, ProposalRewardData>) : this(data.toImmutableMap())

    val proposals get() = data.keys

    operator fun get(proposal: ProposalNumber) = data.getOrFail(proposal)
}

fun calculateRewards(resolutionMap: ProposalResolutionMap): ProposalRewardsMap {
    return ProposalRewardsMap(
        resolutionMap
            .adoptedProposals()
            .associate { proposal ->
                val proposalVotes = resolutionMap.resolutionOf(proposal.number).votes
                val voteCountFor = proposalVotes.votersFor().size.toBigInteger()
                val voteCountAgainst = proposalVotes.votersAgainst().size.toBigInteger()
                val ai = proposal.ai

                val rewardData = ProposalRewardData(
                    author = proposal.author,
                    voteCountFor = voteCountFor,
                    voteCountAgainst = voteCountAgainst,
                    ai = ai
                )

                proposal.number to rewardData
            }
    )
}

fun rewardsReport(rewardsMap: ProposalRewardsMap): String {
    val result =
        rewardsMap
            .proposals
            .map { proposal ->
                val rewardData = rewardsMap[proposal]

                val author = rewardData.author
                val voteCountFor = rewardData.voteCountFor
                val voteCountAgainst = rewardData.voteCountAgainst
                val unroundedReward = rewardData.unroundedReward
                val roundedReward = rewardData.roundedReward

                val coinAmountString =
                    if ((unroundedReward.raw).compareTo(roundedReward.raw) == 0)
                        roundedReward.toString()
                    else
                        "$unroundedReward -> $roundedReward"

                "For the adoption of Proposal $proposal, I grant ${author.name} $voteCountFor-$voteCountAgainst=$coinAmountString coins."
            }
            .joinToString("\n")

    return result
}
