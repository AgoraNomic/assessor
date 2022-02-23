package org.agoranomic.assessor.decisions

// DO NOT USE IN NEW ASSESSMENTS. Use resolvedConditional instead, which integrates into the vote resolution system.
fun legacyConditionalComment(message: String) = "Conditional resolved: $message"

val NO_VETO = legacyConditionalComment("no Notice of Veto was published")
