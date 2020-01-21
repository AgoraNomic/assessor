package org.agoranomic.assessor.lib.proposal_set

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableSet
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber

abstract class AbstractProposalSet : ProposalSet {
    companion object {
        @JvmStatic
        protected fun checkInitialList(list: List<Proposal>) {
            val allNumbers = list.map { it.number }
            val noRepeatNumbers = list.map { it.number }.distinct().filter { searchNum ->
                list.count { it.number == searchNum } == 1
            }

            if (noRepeatNumbers != allNumbers) {
                throw DuplicateProposalNumberException((allNumbers - noRepeatNumbers).first())
            }
        }
    }

    override fun numbers(): ImmutableSet<ProposalNumber> {
        return map { it.number }.toImmutableSet()
    }

    final override fun equals(other: Any?): Boolean {
        if (other !is ProposalSet) return false

        return this.toSet() == other.toSet()
    }

    final override fun hashCode(): Int {
        return this.toSet().hashCode()
    }

    override fun toString(): String {
        return this.toSet().joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
}

abstract class AbstractMutableProposalSet : AbstractProposalSet(), MutableProposalSet {
    /**
     * Add a proposal, assuming that all necessary checking has already been performed. Will not be called if this
     * [ProposalSet] already contains the [Proposal].
     */
    protected abstract fun addUnchecked(toAdd: Proposal)

    final override fun add(toAdd: Proposal) {
        if (contains(toAdd.number)) {
            checkMismatch(toAdd)
        } else {
            addUnchecked(toAdd)
        }
    }
}
