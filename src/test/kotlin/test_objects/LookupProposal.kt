package test_objects

import org.agoranomic.assessor.lib.LookupProposal

val alwaysFailingLookupProposal =
    LookupProposal { _ -> throw UnsupportedOperationException("Invalid request to lookup proposal") }
