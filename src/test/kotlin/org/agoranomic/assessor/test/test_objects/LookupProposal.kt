package org.agoranomic.assessor.test.test_objects

import org.agoranomic.assessor.lib.vote.LookupProposal

val alwaysFailingLookupProposal =
    LookupProposal { _ -> throw UnsupportedOperationException("Invalid request to lookup proposal") }
