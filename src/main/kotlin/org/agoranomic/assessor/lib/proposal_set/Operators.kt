package org.agoranomic.assessor.lib.proposal_set

import org.agoranomic.assessor.lib.Proposal

/**
 * Equivalent to converting the list containing the [Proposals][Proposal] in this, along with those in `other` into a
 * [ProposalSet].
 */
operator fun ProposalSet.plus(other: ProposalSet): ProposalSet {
    return (this.toList() + other.toList()).toProposalSet()
}

/**
 * Equivalent to `this + proposalSetOf(other)`.
 * @see [ProposalSet.plus]
 */
operator fun ProposalSet.plus(other: Proposal) = this + proposalSetOf(other)

/**
 * Equivalent to `proposalSetOf(this) + other`.
 * @see [ProposalSet.plus]
 */
operator fun Proposal.plus(other: ProposalSet) = proposalSetOf(this) + other

/**
 * Equivalent to creating a (mutable) copy of this [ProposalSet], then calling `removeAll(other)`, and returning that
 * copy.
 */
operator fun ProposalSet.minus(other: ProposalSet): ProposalSet {
    val copy = this.toMutableProposalSet()
    copy.removeAll(other)
    return copy
}

/**
 * Equivalent to `this - proposalSetOf(other)`.
 */
operator fun ProposalSet.minus(other: Proposal) = this - proposalSetOf(other)

/**
 * Equivalent to calling `add(other)`.
 */
operator fun MutableProposalSet.plusAssign(other: Proposal) {
    this.add(other)
}

/**
 * Equivalent to calling `addAll(other)`.
 */
operator fun MutableProposalSet.plusAssign(other: ProposalSet) {
    this.addAll(other)
}

/**
 * Equivalent to calling `remove(other)`.
 */
operator fun MutableProposalSet.minusAssign(other: Proposal) {
    this.remove(other)
}

/**
 * Equivalent to calling `removeAll(other)`.
 */
operator fun MutableProposalSet.minusAssign(other: ProposalSet) {
    this.removeAll(other)
}
