package org.agoranomic.assessor.cli

private val DEFAULT_DESTINATION = StdoutDestination
private val DEFAULT_FORMATTER = HumanReadableFormatter(CONFIG_LONG)

data class ProgramConfig(
    val formatter: AssessmentFormatter,
    val neededAssessments: NeededAssessments,
    val destination: AssessmentDestination
) {
    companion object {
        fun withDefaults(cliConfig: CliConfig) =
            ProgramConfig(
                formatter = cliConfig.formatter ?: DEFAULT_FORMATTER,
                neededAssessments = cliConfig.neededAssessments,
                destination = cliConfig.destination ?: DEFAULT_DESTINATION
            )
    }
}
