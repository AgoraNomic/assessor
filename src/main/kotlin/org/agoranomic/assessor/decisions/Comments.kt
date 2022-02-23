package org.agoranomic.assessor.decisions

// DO NOT USE IN NEW ASSESSMENTS.
fun legacyConditionalComment(message: String) = "Conditional resolved: $message"

val NO_VETO = legacyConditionalComment("no Notice of Veto was published")
