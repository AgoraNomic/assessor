package org.agoranomic.assessor.lib

import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableSet

data class ProposalNumbers(val data: ImmutableSet<ProposalNumber>) : Collection<ProposalNumber> by data {
    constructor(data: Set<ProposalNumber>) : this(data.toImmutableSet())

    companion object {
        fun empty() = ProposalNumbers(emptySet())

        fun checkingDistinct(collection: Collection<ProposalNumber>): ProposalNumbers {
            collection.requireAllAreDistinct()
            return ProposalNumbers(collection.toSet())
        }
    }
}
