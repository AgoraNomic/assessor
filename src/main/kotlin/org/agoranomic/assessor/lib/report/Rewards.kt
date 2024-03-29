package org.agoranomic.assessor.lib.report

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.proposal.*
import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap
import org.agoranomic.assessor.lib.resolve.ProposalResult
import org.agoranomic.assessor.lib.vote.SimplifiedSingleProposalVoteMap
import org.agoranomic.assessor.lib.vote.votersAgainst
import org.agoranomic.assessor.lib.vote.votersFor
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthTrailForPersons
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

data class ProposalRewardData(
    val author: Person?,
    val coauthors: Persons?,
    val voteCountFor: BigInteger,
    val voteCountAgainst: BigInteger,
    val proposalAI: ProposalAI,
    val result: ProposalResult,
    val votingStrengths: VotingStrengthTrailForPersons,
    val resolvedVotes: SimplifiedSingleProposalVoteMap,
    val sponsored: Boolean,
)

data class ProposalRewardsMap(
    private val data: ImmutableMap<ProposalNumber, ProposalRewardData>,
) {
    constructor(data: Map<ProposalNumber, ProposalRewardData>) : this(data.toImmutableMap())

    val proposals get() = data.keys

    operator fun get(proposal: ProposalNumber) = data.getValue(proposal)
}

private fun Proposal.isSponsored(): Boolean {
    return accept(object : ProposalMapper<Boolean> {
        override fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0): Boolean {
            return false
        }

        override fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1): Boolean {
            return false
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
            .proposals
            .associate { proposal ->
                val resolution = resolutionMap.resolutionOf(proposal.number)

                val proposalVotes = resolution.votes
                val voteCountFor = proposalVotes.votersFor().size.toBigInteger()
                val voteCountAgainst = proposalVotes.votersAgainst().size.toBigInteger()
                val proposalAI = proposal.proposalAI

                val rewardData = ProposalRewardData(
                    author = proposal.author,
                    coauthors = proposal.coauthors,
                    voteCountFor = voteCountFor,
                    voteCountAgainst = voteCountAgainst,
                    proposalAI = proposalAI,
                    result = resolution.result,
                    resolvedVotes = proposalVotes,
                    votingStrengths = resolution.votingStrengths,
                    sponsored = proposal.isSponsored(),
                )

                proposal.number to rewardData
            }
    )
}

private fun ProposalRewardData.authorRewards(proposalNumber: ProposalNumber): List<String> {
    if (result != ProposalResult.ADOPTED) return emptyList()
    if (author == null) return emptyList()

    return buildList {
        add("For the adoption of Proposal $proposalNumber, I increase the score of ${author.name} by 5 points (author).")
    }
}

private fun ProposalRewardData.coauthorRewards(proposalNumber: ProposalNumber): List<String> {
    if (result != ProposalResult.ADOPTED) return emptyList()
    if (coauthors == null) return emptyList()

    return coauthors.map {
        "For the adoption of Proposal $proposalNumber, I increase the score of ${it.name} by 1 point (coauthor)."
    }
}

fun rewardsReport(rewardsMap: ProposalRewardsMap): String {
    return rewardsMap
        .proposals
        .flatMap { proposal ->
            val rewardData = rewardsMap[proposal]

            listOf(
                rewardData.authorRewards(proposal),
                rewardData.coauthorRewards(proposal),
            )
        }
        .flatten()
        .joinToString("\n")
}
