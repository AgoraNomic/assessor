package org.agoranomic.assessor.lib.proposal_set

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber

class ImmutableListProposalSet private constructor(private val list: ImmutableList<Proposal>) : AbstractProposalSet(), ImmutableProposalSet {
    companion object {
        private fun fromListUnchecked(list: List<Proposal>): ImmutableListProposalSet {
            return ImmutableListProposalSet(list.toImmutableList())
        }

        fun fromList(list: List<Proposal>) = fromListUnchecked(list.also { checkInitialList(it) })

        fun empty() = fromListUnchecked(emptyList())
    }

    override fun getOpt(number: ProposalNumber): Proposal? {
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
        fun fromListUnchecked(list: List<Proposal>): MutableListProposalSet {
            return MutableListProposalSet(initialList = list)
        }

        fun fromList(list: List<Proposal>) = fromListUnchecked(list.also { checkInitialList(it) })

        fun empty() = fromListUnchecked(
            emptyList()
        )
    }

    override fun addUnchecked(toAdd: Proposal) {
        list += toAdd
    }

    override fun getOpt(number: ProposalNumber): Proposal? {
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
