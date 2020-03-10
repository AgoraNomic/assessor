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

        // Kotlin doesn't let us explicitly use a vararg of an inline class, so we use a type parameter that is
        // constrained to be derived from ProposalNumber. Since inline classes are final, it can only be deduced as
        // ProposalNumber, which is what we want.
        //
        // Yes, this is hacky, but blame Kotlin.
        @Suppress("FINAL_UPPER_BOUND")
        fun <T : ProposalNumber> of(vararg numbers: T) = checkingDistinct(numbers.toList())
    }
}
