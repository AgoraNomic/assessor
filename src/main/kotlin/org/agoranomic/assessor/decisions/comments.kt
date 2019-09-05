package org.agoranomic.assessor.decisions

fun conditional(message: String) = "Conditional resolved: $message"

val NO_VETO = conditional("no Notice of Veto was published")
val YES_VETO = conditional("a Notice of Veto was published")
const val INEXTRICABLE = "Inextricable conditional"
const val PM = "PM"
const val BLOTS = "Blots"