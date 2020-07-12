package org.agoranomic.assessor.test.test_util

import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.proposal.ProposalNumber

fun Proposal.copyWithNumber(number: ProposalNumber) = copy(commonData = commonData.copy(number = number))
