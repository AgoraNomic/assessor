package org.agoranomic.assessor.lib.proposal_set

import kotlinx.collections.immutable.ImmutableSet
import org.agoranomic.assessor.lib.*

/**
 * Thrown when by a [ProposalSet] when a proposal is requested but does not exist.
 */
data class NoSuchProposalException(
    val number: ProposalNumber
) : Exception("Request for unknown proposal by number: ${number.raw}")

/**
 * A set of [Proposals][Proposal]. Contains only one [Proposal] by each [ProposalNumber]. Two
 * [ProposalSets][ProposalSet] are equal if they contain the same proposals.
 */
interface ProposalSet : Iterable<Proposal> {
    /**
     * Returns a [Proposal] if this [ProposalSet] contains a [Proposal] with the provided [number], or `null` otherwise.
     */
    fun getOrNull(number: ProposalNumber): Proposal?

    /**
     * Returns `true` if this [ProposalSet] contains a [Proposal] with the provided [number], or `false` otherwise.
     */
    fun contains(number: ProposalNumber): Boolean = getOrNull(number) != null

    /**
     * The number of [Proposals][Proposal] contained in this [ProposalSet].
     */
    val size: Int

    /**
     * Returns an [ImmutableSet] of the [numbers][Proposal.number] of the proposals that this [ProposalSet] contains.
     */
    fun numbers(): ProposalNumbers
}

/**
 * Returns a [Proposal] if this [ProposalSet] contains a [Proposal] with the provided [number]
 * @throws NoSuchProposalException if this [ProposalSet] does not contain a [Proposal] with the provided [number]
 */
operator fun ProposalSet.get(number: ProposalNumber): Proposal = getOrNull(number) ?: throw NoSuchProposalException(number)

fun ProposalSet.isEmpty(): Boolean = size == 0
fun ProposalSet.isNotEmpty() = !isEmpty()

fun ProposalSet.checkMismatch(nextProposal: Proposal) {
    val originalProposal = getOrNull(nextProposal.number) ?: return

    check(originalProposal.number == nextProposal.number)
    checkMismatch(originalProposal, nextProposal)
}

fun ProposalSet.checkMismatches(proposals: Iterable<Proposal>) = proposals.forEach(::checkMismatch)

/**
 * A ProposalSet that is immutable by contract. The contents shall not change after creation.
 */
interface ImmutableProposalSet : ProposalSet

/**
 * A mutable [ProposalSet].
 */
interface MutableProposalSet : ProposalSet, MutableIterable<Proposal> {
    /**
     * Adds a proposal. Has no effect if an equivalent [Proposal] is already in this [ProposalSet].
     *
     * @param toAdd the proposal to add
     * @throws ProposalDataMismatchException if this [ProposalSet] already contains a [Proposal] with the same
     * [number][Proposal.number] but different data.
     */
    fun add(toAdd: Proposal)

    /**
     * Removes a proposal.
     *
     * @param toRemove the proposal to remove
     */
    fun remove(toRemove: ProposalNumber)
}

/**
 * Equivalent to calling [MutableProposalSet.add] for each of the members.
 */
fun MutableProposalSet.addAll(toAdd: Iterable<Proposal>) {
    toAdd.forEach { add(it) }
}

/**
 * Checks for a data mismatch, then calls `remove(toRemove.number)`.
 * @throws ProposalDataMismatchException if this [ProposalSet] contains a [Proposal] with the same
 * [number][Proposal.number] but different data.
 */
fun MutableProposalSet.remove(toRemove: Proposal) {
    checkMismatch(toRemove)
    remove(toRemove.number)
}

/**
 * Equivalent to calling [MutableProposalSet.remove] for each of the members.
 */
@JvmName("removeAllNumbers")
fun MutableProposalSet.removeAll(toRemove: Iterable<ProposalNumber>) {
    toRemove.forEach { remove(it) }
}

/**
 * Equivalent to calling [MutableProposalSet.remove] for each of the members.
 * @throws ProposalDataMismatchException if this [ProposalSet] contains a [Proposal] with the same
 * [number][Proposal.number] but different data.
 */
@JvmName("removeAll")
fun MutableProposalSet.removeAll(toRemove: Iterable<Proposal>) {
    toRemove.forEach { remove(it) }
}

/**
 * Returns an empty [ImmutableProposalSet].
 */
fun emptyProposalSet(): ImmutableProposalSet = ImmutableListProposalSet.empty()

/**
 * Returns an empty [MutableProposalSet].
 */
fun emptyMutableProposalSet(): MutableProposalSet = MutableListProposalSet.empty()

/**
 * @throws ProposalDataMismatchException if there are two [Proposals][Proposal] in `this` that have the same
 * [number][Proposal.number] but otherwise different data.
 */
fun Iterable<Proposal>.toImmutableProposalSet(): ImmutableProposalSet {
    // Returning this is not observably different from returning a copy, since this is immutable.
    if (this is ImmutableProposalSet) return this

    return ImmutableListProposalSet.from(this)
}

/**
 * @throws ProposalDataMismatchException if there are two [Proposals][Proposal] in `this` that have the same
 * [number][Proposal.number] but otherwise different data.
 */
fun Iterable<Proposal>.toMutableProposalSet(): MutableProposalSet = MutableListProposalSet.from(this)

/**
 * @throws ProposalDataMismatchException if there are two [Proposals][Proposal] in `this` that have the same
 * [number][Proposal.number] but otherwise different data.
 */
fun Iterable<Proposal>.toProposalSet(): ProposalSet = toImmutableProposalSet()

/**
 * @throws ProposalDataMismatchException if there are two [Proposals][Proposal] in [proposals] that have the same
 * [number][Proposal.number] but otherwise different data.
 */
fun proposalSetOf(vararg proposals: Proposal) = proposals.asList().toProposalSet()

/**
 * @throws ProposalDataMismatchException if there are two [Proposals][Proposal] in [proposals] that have the same
 * [number][Proposal.number] but otherwise different data.
 */
fun mutableProposalSetOf(vararg proposals: Proposal) = proposals.asList().toMutableProposalSet()
