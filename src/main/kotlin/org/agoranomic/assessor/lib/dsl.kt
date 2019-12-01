package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableSet
import org.agoranomic.assessor.lib.dsl_detail._AssessmentReceiver

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class AssessmentDSL

data class AssessmentData(
    val name: String,
    val quorum: Int,
    val votingStrengths: VotingStrengthMap,
    val proposals: ImmutableSet<Proposal>,
    val votes: MultiProposalVoteMap
) {
    constructor(
        name: String,
        quorum: Int,
        votingStrengths: VotingStrengthMap,
        proposals: Set<Proposal>,
        votes: MultiProposalVoteMap
    ) : this(
        name,
        quorum,
        votingStrengths,
        proposals.toImmutableSet(),
        votes
    )
}

fun assessment(block: _AssessmentReceiver.() -> Unit): AssessmentData {
    val receiver = _AssessmentReceiver()
    receiver.block()
    return receiver.compile()
}
