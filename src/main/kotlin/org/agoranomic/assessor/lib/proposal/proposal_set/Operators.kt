package org.agoranomic.assessor.lib.proposal.proposal_set

import org.agoranomic.assessor.lib.proposal.Proposal

operator fun ProposalSet.plus(other: ProposalSet) =
    ((this as Iterable<Proposal>) + (other as Iterable<Proposal>)).toProposalSet()

operator fun ProposalSet.plus(other: Proposal) = ((this as Iterable<Proposal>) + other).toProposalSet()

operator fun Proposal.plus(other: ProposalSet) = (listOf(this) + (other as Iterable<Proposal>)).toProposalSet()

operator fun ProposalSet.minus(other: ProposalSet) =
    ((this as Iterable<Proposal>) - (other as Iterable<Proposal>)).toProposalSet()

operator fun ProposalSet.minus(other: Proposal) = ((this as Iterable<Proposal>) - other).toProposalSet()

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
