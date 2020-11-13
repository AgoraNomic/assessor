package org.agoranomic.assessor.dsl

import org.agoranomic.assessor.dsl.receivers.*
import org.agoranomic.assessor.lib.proposal.proposal_set.ImmutableProposalSet
import org.agoranomic.assessor.lib.resolve.AssessmentData

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class AssessmentDsl

fun assessment(block: AssessmentReceiverInit): AssessmentData {
    return DefaultAssessmentCompiler().compile(block)
}

/**
 * Returns the proposals compiled from [init] using [DefaultProposalsCompilerV0].
 */
@Suppress("UNUSED_PARAMETER")
fun compileProposals(v0: Version0, init: ProposalsReceiverV0Init): ImmutableProposalSet =
    DefaultProposalsCompilerV0().compile(init)

/**
 * Returns the proposals compiled from [init] using [DefaultProposalsCompilerV1].
 */
@Suppress("UNUSED_PARAMETER")
fun compileProposals(v1: Version1, init: ProposalsReceiverV1Init): ImmutableProposalSet =
    DefaultProposalsCompilerV1().compile(init)

/**
 * Returns the proposals compiled from [init] using [DefaultProposalsCompilerV2].
 */
@Suppress("UNUSED_PARAMETER")
fun compileProposals(v2: Version2, init: ProposalsReceiverV2Init): ImmutableProposalSet =
    DefaultProposalsCompilerV2().compile(init)

/**
 * Returns the proposals compiled from [init] using [DefaultProposalsCompilerV3].
 */
@Suppress("UNUSED_PARAMETER")
fun compileProposals(v3: Version3, init: ProposalsReceiverV3Init): ImmutableProposalSet =
    DefaultProposalsCompilerV3().compile(init)
