package org.agoranomic.assessor.lib.proposal_set

import org.agoranomic.assessor.lib.Proposal

operator fun ProposalSet.plus(other: Proposal): ProposalSet {
    return (this.toList() + other).toProposalSet()
}

operator fun Proposal.plus(other: ProposalSet): ProposalSet {
    return other + this
}

operator fun ProposalSet.plus(other: ProposalSet): ProposalSet {
    return (this.toList() + other.toList()).toProposalSet()
}

operator fun ProposalSet.minus(other: Proposal): ProposalSet {
    return (this.toList() - other).toProposalSet()
}

operator fun MutableProposalSet.plusAssign(other: Proposal) {
    this.add(other)
}

operator fun MutableProposalSet.plusAssign(other: ProposalSet) {
    this.addAll(other)
}

operator fun MutableProposalSet.minusAssign(other: Proposal) {
    this.remove(other)
}

operator fun MutableProposalSet.minusAssign(other: ProposalSet) {
    this.removeAll(other)
}
