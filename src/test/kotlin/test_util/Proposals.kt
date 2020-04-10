package test_util

import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber

fun Proposal.copyWithNumber(number: ProposalNumber) = copy(commonData = commonData.copy(number = number))
