package org.agoranomic.assessor.lib.proposal_set

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableSet
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalDataMismatchException
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.ProposalNumbers
import org.agoranomic.assessor.lib.util.toSetCheckingDistinct

abstract class AbstractProposalSet : ProposalSet {
    companion object {
        /**
         * @throws ProposalDataMismatchException if there are two [Proposals][Proposal] in `this` that have the same
         * [number][Proposal.number] but otherwise different data.
         */
        @JvmStatic
        protected fun checkInitialList(list: List<Proposal>) {
            val distinctList = list.distinctBy { it.number }

            if (distinctList != list) {
                val differingList = list - distinctList
                check(differingList.isNotEmpty())

                val firstDiffering = differingList.first()
                val otherWithSameNumber = list.first { it.number == firstDiffering.number && it != firstDiffering }

                throw ProposalDataMismatchException(
                    next = firstDiffering,
                    original = otherWithSameNumber
                )
            }
        }
    }

    override fun numbers(): ProposalNumbers {
        val numbersSet = map { it.number }.toSetCheckingDistinct()
        return ProposalNumbers(numbersSet)
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
