package org.agoranomic.assessor.lib

import io.github.random_internet_cat.util.toSetCheckingDistinct
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.toImmutableSet

/**
 * A [Collection] that contains a set of distinct ProposalNumbers.
 */
data class ProposalNumbers(private val data: ImmutableSet<ProposalNumber>) : Collection<ProposalNumber> {
    constructor(data: Set<ProposalNumber>) : this(data.toImmutableSet())

    override val size get() = data.size
    override fun isEmpty() = data.isEmpty()

    override fun contains(element: ProposalNumber): Boolean = data.contains(element)
    override fun containsAll(elements: Collection<ProposalNumber>): Boolean = data.containsAll(elements)

    override fun iterator(): Iterator<ProposalNumber> = data.iterator()
}

/**
 * Returns an empty [ProposalNumbers].
 */
fun emptyProposalNumbers() = ProposalNumbers(emptySet())

/**
 * Returns a [ProposalNumbers] that contains the [ProposalNumber]s in [numbers]. Throws [IllegalArgumentException] if
 * [numbers] contains any [ProposalNumber] more than once.
 */
// Kotlin doesn't let us explicitly use a vararg of an inline class, so we use a type parameter that is
// constrained to be derived from ProposalNumber. Since inline classes are final, it can only be deduced as
// ProposalNumber, which is what we want.
//
// Yes, this is hacky, but blame Kotlin.
@Suppress("FINAL_UPPER_BOUND")
fun <_ProposalNumber : ProposalNumber> proposalNumbersOf(vararg numbers: _ProposalNumber) =
    ProposalNumbers(numbers.asList().toSetCheckingDistinct())
