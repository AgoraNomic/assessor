package org.agoranomic.assessor.lib.proposal_set

import kotlinx.collections.immutable.ImmutableSet
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.checkMismatch

data class NoSuchProposalException(
    val number: ProposalNumber
) : Exception("Request for unknown proposal by number: ${number.raw}")

data class ProposalDataMismatchException(
    val next: Proposal,
    val original: Proposal
) : Exception("Proposals with same number but different data found: $next and $original") {
    init {
        require(next.number == original.number)
    }
}

/**
 * A set of [Proposals][Proposal]. Contains only one [Proposal] by each [ProposalNumber]. Two
 * [ProposalSets][ProposalSet] are equal if they contain the same proposals.
 */
interface ProposalSet : Iterable<Proposal> {
    /**
     * Returns a [Proposal] if this [ProposalSet] contains a [Proposal] with the provided [number], or `null` otherwise.
     */
    fun getOpt(number: ProposalNumber): Proposal?

    /**
     * Returns a [Proposal] if this [ProposalSet] contains a [Proposal] with the provided [number]
     * @throws NoSuchProposalException if this [ProposalSet] does not contain a [Proposal] with the provided [number]
     */
    operator fun get(number: ProposalNumber): Proposal = getOpt(number) ?: throw NoSuchProposalException(number)

    /**
     * Returns `true` if this [ProposalSet] contains a [Proposal] with the provided [number], or `false` otherwise.
     */
    fun contains(number: ProposalNumber): Boolean = getOpt(number) != null

    /**
     * The number of [Proposals][Proposal] contained in this [ProposalSet].
     */
    val size: Int

    /**
     * Returns whether or not this [ProposalSet] is empty.
     */
    fun isEmpty(): Boolean = size != 0

    /**
     * Returns an [ImmutableSet] of the [numbers][Proposal.number] of the proposals that this [ProposalSet] contains.
     */
    fun numbers(): ImmutableSet<ProposalNumber>
}

fun ProposalSet.isNotEmpty() = !isEmpty()

fun ProposalSet.checkMismatch(nextProposal: Proposal) {
    val originalProposal = getOpt(nextProposal.number) ?: return

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

fun emptyProposalSet(): ImmutableProposalSet = ImmutableListProposalSet.empty()
fun emptyMutableProposalSet(): MutableProposalSet = MutableListProposalSet.empty()

data class DuplicateProposalNumberException(
    val number: ProposalNumber
) : Exception("Duplicate proposal number: ${number.raw}")

/**
 * @throws DuplicateProposalNumberException if there are two [Proposals][Proposal] in [proposals] that have the same
 * [number][Proposal.number]
 */
fun List<Proposal>.toProposalSet(): ProposalSet = ImmutableListProposalSet.fromList(this)

/**
 * @throws DuplicateProposalNumberException if there are two [Proposals][Proposal] in [proposals] that have the same
 * [number][Proposal.number]
 */
fun List<Proposal>.toImmutableProposalSet(): ImmutableProposalSet = ImmutableListProposalSet.fromList(this)

/**
 * @throws DuplicateProposalNumberException if there are two [Proposals][Proposal] in [proposals] that have the same
 * [number][Proposal.number]
 */
fun List<Proposal>.toMutableProposalSet(): MutableProposalSet = MutableListProposalSet.fromList(this)

/**
 * @throws DuplicateProposalNumberException if there are two [Proposals][Proposal] in [proposals] that have the same
 * [number][Proposal.number]
 */
fun proposalSetOf(vararg proposals: Proposal) = proposals.toList().toProposalSet()

/**
 * @throws DuplicateProposalNumberException if there are two [Proposals][Proposal] in [proposals] that have the same
 * [number][Proposal.number]
 */
fun mutableProposalSetOf(vararg proposals: Proposal) = proposals.toList().toMutableProposalSet()

/**
 * Returns a [ImmutableProposalSet] that contains the same proposals as this [ProposalSet].
 */
fun ProposalSet.immutableCopy(): ImmutableProposalSet = this.toList().toImmutableProposalSet()

/**
 * Returns a [MutableProposalSet] that contains the same proposals as this [ProposalSet].
 */
fun ProposalSet.mutableCopy(): MutableProposalSet = this.toList().toMutableProposalSet()
