package org.agoranomic.assessor.lib.resolve

import io.github.random_internet_cat.util.compareTo
import io.github.random_internet_cat.util.times
import org.agoranomic.assessor.lib.proposal.DecisionAI
import org.agoranomic.assessor.lib.vote.SimplifiedSingleProposalVoteMap
import org.agoranomic.assessor.lib.vote.VoteKind
import org.agoranomic.assessor.lib.vote.strengthWithVote
import org.agoranomic.assessor.lib.voting_strength.VotingStrength
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthTrailForPersons
import org.agoranomic.assessor.lib.voting_strength.compareTo

data class AIStrengths(val strengthFor: VotingStrength, val strengthAgainst: VotingStrength)

fun isAIAdopted(ai: DecisionAI, aiStrengths: AIStrengths): Boolean {
    val strengthFor = aiStrengths.strengthFor
    val strengthAgainst = aiStrengths.strengthAgainst

    return strengthFor.raw >= (ai.raw * strengthAgainst.raw) && (strengthFor > strengthAgainst)
}

fun aiStrengthsFor(votes: SimplifiedSingleProposalVoteMap, strengths: VotingStrengthTrailForPersons): AIStrengths {
    return AIStrengths(
        strengthFor = strengthWithVote(
            VoteKind.FOR,
            votes,
            strengths
        ),
        strengthAgainst = strengthWithVote(
            VoteKind.AGAINST,
            votes,
            strengths
        )
    )
}

