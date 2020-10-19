package org.agoranomic.assessor.lib.proposal.proposal_set

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber

class ImmutableListProposalSet
private constructor(private val list: ImmutableList<Proposal>) : AbstractProposalSet(), ImmutableProposalSet {
    companion object {
        private fun fromListUnchecked(list: List<Proposal>): ImmutableListProposalSet {
            return ImmutableListProposalSet(list.distinct().toImmutableList())
        }

        fun from(list: List<Proposal>) = fromListUnchecked(list.also { checkInitialList(it) })
        fun from(iterable: Iterable<Proposal>) = from(iterable.toList())

        fun empty() = fromListUnchecked(emptyList())
    }

    override fun getOrNull(number: ProposalNumber): Proposal? {
        return list.find { it.number == number }
    }

    override val size: Int get() = list.size

    override fun iterator(): Iterator<Proposal> {
        return list.iterator()
    }
}

class MutableListProposalSet : AbstractMutableProposalSet {
    private val list: MutableList<Proposal>

    private constructor(initialList: List<Proposal>) {
        this.list = initialList.toMutableList() // Defensive copy
    }

    companion object {
        private fun fromListUnchecked(list: List<Proposal>): MutableListProposalSet {
            return MutableListProposalSet(initialList = list)
        }

        fun from(list: List<Proposal>) = fromListUnchecked(list.also { checkInitialList(it) })
        fun from(iterable: Iterable<Proposal>) = from(iterable.toList())

        fun empty() = fromListUnchecked(emptyList())
    }

    override fun addUnchecked(toAdd: Proposal) {
        list += toAdd
    }

    override fun getOrNull(number: ProposalNumber): Proposal? {
        return list.find { it.number == number }
    }

    override val size: Int get() = list.size

    override fun iterator(): MutableIterator<Proposal> {
        return list.iterator()
    }

    override fun remove(toRemove: ProposalNumber) {
        list.removeAll { it.number == toRemove }
    }
}
