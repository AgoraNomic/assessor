package org.agoranomic.assessor.lib.proposal_set

import org.agoranomic.assessor.lib.Proposal

/**
 * Equivalent to converting the list containing the [Proposals][Proposal] in this, along with `other` into a
 * [ProposalSet].
 */
operator fun ProposalSet.plus(other: Proposal): ProposalSet {
    return (this.toList() + other).toProposalSet()
}

/**
 * Equivalent to converting the list containing the [Proposals][Proposal] in `other`, along with `this` into a
 * [ProposalSet].
 */
operator fun Proposal.plus(other: ProposalSet): ProposalSet {
    return other + this
}

/**
 * Equivalent to converting the list containing the [Proposals][Proposal] in this, along with those in `other` into a
 * [ProposalSet].
 */
operator fun ProposalSet.plus(other: ProposalSet): ProposalSet {
    return (this.toList() + other.toList()).toProposalSet()
}

/**
 * Equivalent to converting the list containing the [Proposals][Proposal] in this, excluding `other`, into a
 * [ProposalSet].
 */
operator fun ProposalSet.minus(other: Proposal): ProposalSet {
    return (this.toList() - other).toProposalSet()
}

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
