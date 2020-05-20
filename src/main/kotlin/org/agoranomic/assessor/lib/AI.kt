package org.agoranomic.assessor.lib

import io.github.random_internet_cat.util.compareTo
import io.github.random_internet_cat.util.times

data class AIStrengths(val strengthFor: VotingStrength, val strengthAgainst: VotingStrength)

fun isAIAdopted(ai: ProposalAI, aiStrengths: AIStrengths): Boolean {
    val strengthFor = aiStrengths.strengthFor
    val strengthAgainst = aiStrengths.strengthAgainst

    return strengthFor.raw >= (ai.raw * strengthAgainst.raw) && (strengthFor > strengthAgainst)
}

fun aiStrengthsFor(votes: SimplifiedSingleProposalVoteMap, strengths: VotingStrengthMap): AIStrengths {
    return AIStrengths(
        strengthFor = strengthWithVote(VoteKind.FOR, votes, strengths),
        strengthAgainst = strengthWithVote(VoteKind.AGAINST, votes, strengths)
    )
}

