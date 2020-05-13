package org.agoranomic.assessor.dsl.receivers

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import org.agoranomic.assessor.dsl.AssessmentDsl
import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.dsl.DslValueMap
import org.agoranomic.assessor.lib.*

interface VoteCommentable {
    infix fun comment(comment: String)
}

@AssessmentDsl
interface PersonVotesReceiver {
    object All

    val all: All get() = All

    object Others

    val others: Others get() = Others

    infix fun HalfFunctionVote.on(proposal: ProposalNumber): VoteCommentable
    infix fun HalfFunctionVote.on(number: Int) = on(ProposalNumber(number))

    infix fun HalfFunctionVote.on(all: All)
    infix fun HalfFunctionVote.on(others: Others)

    infix fun VoteKind.on(proposal: ProposalNumber): VoteCommentable
    infix fun VoteKind.on(proposal: Int) = on(ProposalNumber(proposal))

    infix fun VoteKind.on(all: All)
    infix fun VoteKind.on(others: Others)

    fun function(func: VoteFunc): HalfFunctionVote
}

typealias PersonVotesReceiverInit = DslInit<PersonVotesReceiver>

interface PersonVotesCompiler {
    fun compile(init: PersonVotesReceiverInit): ImmutableMap<ProposalNumber, PendingVote>
}

@AssessmentDsl
private class DefaultPersonVotesReceiver(private val proposals: ImmutableList<ProposalNumber>) : PersonVotesReceiver {
    constructor(proposals: List<ProposalNumber>) : this(proposals.toImmutableList())

    private val voteMap = DslValueMap<ProposalNumber, MutableVote>()

    private data class MutableVote(val vote: VoteFunc, var comment: String? = null) : VoteCommentable {
        override fun comment(comment: String) {
            this.comment = comment
        }

        fun compile() = PendingVote(vote, comment)
    }

    private fun addVote(proposal: ProposalNumber, vote: MutableVote): VoteCommentable {
        require(proposals.contains(proposal)) { "No such proposal $proposal" }

        voteMap[proposal] = vote
        return vote
    }

    private fun addVote(proposal: ProposalNumber, vote: HalfFunctionVote) = addVote(proposal, MutableVote(vote.func))

    override infix fun HalfFunctionVote.on(proposal: ProposalNumber) = addVote(proposal, MutableVote(this.func))

    override infix fun HalfFunctionVote.on(all: PersonVotesReceiver.All) {
        proposals.forEach { addVote(it, this) }
    }

    override infix fun HalfFunctionVote.on(others: PersonVotesReceiver.Others) {
        for (proposal in proposals.map { it }) {
            if (!voteMap.containsKey(proposal)) addVote(proposal, this)
        }
    }

    override fun function(func: VoteFunc) = functionVote(func)

    private fun simpleVoteFunction(vote: VoteKind) = functionVote { _, _ -> SimpleVote(vote, comment = null) }

    override infix fun VoteKind.on(proposal: ProposalNumber) = simpleVoteFunction(this) on proposal

    override infix fun VoteKind.on(all: PersonVotesReceiver.All) = simpleVoteFunction(this) on all
    override infix fun VoteKind.on(others: PersonVotesReceiver.Others) = simpleVoteFunction(this) on others

    fun compile(): ImmutableMap<ProposalNumber, PendingVote> {
        return voteMap.compile().mapValues { (_, v) -> v.compile() }.toImmutableMap()
    }
}

class DefaultPersonVotesCompiler(private val proposals: ImmutableList<ProposalNumber>) : PersonVotesCompiler {
    constructor(proposals: List<ProposalNumber>) : this(proposals.toImmutableList())

    override fun compile(init: PersonVotesReceiverInit): ImmutableMap<ProposalNumber, PendingVote> {
        return DefaultPersonVotesReceiver(proposals).also(init).compile()
    }
}

fun buildPersonVotes(
    proposals: List<ProposalNumber>,
    block: PersonVotesReceiverInit
): Map<ProposalNumber, PendingVote> {
    return DefaultPersonVotesCompiler(proposals).compile(block)
}
