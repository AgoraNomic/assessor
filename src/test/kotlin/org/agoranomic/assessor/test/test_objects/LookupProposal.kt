package org.agoranomic.assessor.test.test_objects

import org.agoranomic.assessor.lib.vote.LookupProposalFunc

val alwaysFailingLookupProposalFunc: LookupProposalFunc =
    { _ -> throw UnsupportedOperationException("Invalid request to lookup proposal") }
