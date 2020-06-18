package org.agoranomic.assessor.cli

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.ReadableReportConfig
import org.apache.commons.cli.*
import java.io.CharArrayWriter
import java.io.PrintWriter

private const val VOTE_COMMENTS_YES = "vote-comments"
private const val VOTE_COMMENTS_NO = "no-vote-comments"
private const val BALLOTS_LINE_YES = "ballots-line"
private const val BALLOTS_LINE_NO = "no-ballots-line"
private const val VOTE_KIND_COUNTS_YES = "vote-counts"
private const val VOTE_KIND_COUNTS_NO = "no-vote-counts"
private const val DEST_STDOUT = "stdout"
private const val DEST_FILE = "file"
private const val DEST_DIR = "dir"
private const val FORM_LONG = "long"
private const val FORM_SHORT = "short"
private const val FORM_OFFICIAL = "official"
private const val FORM_JSON = "json"
private const val FORM_REWARDS = "rewards"

val CONFIG_LONG = ReadableReportConfig(
    voteComments = true,
    totalBallotCount = true,
    voteKindBallotCount = true,
    popularity = true,
    summaryTable = true
)

val CONFIG_SHORT = ReadableReportConfig(
    voteComments = false,
    totalBallotCount = false,
    popularity = false,
    voteKindBallotCount = false
)

val CONFIG_OFFICIAL = ReadableReportConfig(
    voteComments = false,
    totalBallotCount = true,
    popularity = true,
    voteKindBallotCount = true
)

open class CliException : Exception {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(cause: Exception) : super(cause)
    constructor(message: String, cause: Exception) : super(message, cause)
}

open class CliParseException : CliException {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(cause: Exception) : super(cause)
    constructor(message: String, cause: Exception) : super(message, cause)
}

private inline fun <reified T> Option.Builder.type() = this.type(T::class.java)!!

private fun optionGroupOf(vararg options: Option): OptionGroup {
    val group = OptionGroup()
    for (option in options) group.addOption(option)
    return group
}

private fun destinationOptionGroup(): OptionGroup {
    val optDestStdout = Option.builder().longOpt(DEST_STDOUT).desc("Print resolutions to the standard output").build()
    val optDestFile =
        Option
            .builder()
            .longOpt(DEST_FILE)
            .desc("Print resolutions to the provided file")
            .argName("file")
            .hasArg()
            .argName("file")
            .optionalArg(true)
            .type<String>()
            .build()
    val optDestDir =
        Option
            .builder()
            .longOpt(DEST_DIR)
            .desc("Print resolutions to files in the provided directory")
            .hasArg()
            .argName("directory")
            .optionalArg(true)
            .type<String>()
            .build()

    return optionGroupOf(optDestStdout, optDestFile, optDestDir)
}

private fun commentsOptionGroup(): OptionGroup {
    val optVoteCommentsYes = Option.builder().longOpt(VOTE_COMMENTS_YES).desc("Print vote comments").build()
    val optVoteCommentsNo = Option.builder().longOpt(VOTE_COMMENTS_NO).desc("Don't print vote comments").build()

    return optionGroupOf(optVoteCommentsYes, optVoteCommentsNo)
}

private fun ballotsLineOptionGroup(): OptionGroup {
    val optBallotsLineYes = Option.builder().longOpt(BALLOTS_LINE_YES).desc("Print BALLOTS line").build()
    val optBallotsLineNo = Option.builder().longOpt(BALLOTS_LINE_NO).desc("Don't print BALLOTS line").build()

    return optionGroupOf(optBallotsLineYes, optBallotsLineNo)
}

private fun voteCountsOptionGroup(): OptionGroup {
    val optSubVoteCountYes = Option.builder().longOpt(VOTE_KIND_COUNTS_YES).desc("Print vote counts").build()
    val optSubVoteCountNo = Option.builder().longOpt(VOTE_KIND_COUNTS_NO).desc("Don't print vote counts").build()

    return optionGroupOf(optSubVoteCountYes, optSubVoteCountNo)
}

private fun formOptionGroup(): OptionGroup {
    val optFormLong = Option.builder().longOpt(FORM_LONG).desc("Generally longer form").build()
    val optFormShort = Option.builder().longOpt(FORM_SHORT).desc("Generally short form").build()
    val optFormOfficial = Option.builder().longOpt(FORM_OFFICIAL).desc("Official report form").build()
    val optFormJson = Option.builder().longOpt(FORM_JSON).desc("Machine-readable JSON form").build()
    val optFormRewards = Option.builder().longOpt(FORM_REWARDS).desc("Rewards for proposal adoption").build()

    return optionGroupOf(optFormLong, optFormShort, optFormOfficial, optFormJson, optFormRewards)
}

private fun cliOptions(): Options {
    val options = Options()

    options.addOptionGroup(destinationOptionGroup())
    options.addOptionGroup(commentsOptionGroup())
    options.addOptionGroup(ballotsLineOptionGroup())
    options.addOptionGroup(voteCountsOptionGroup())
    options.addOptionGroup(formOptionGroup())

    return options
}

private enum class CommentsConfig(val value: Boolean) { ENABLED(true), DISABLED(false) }
private enum class BallotsLineConfig(val value: Boolean) { ENABLED(true), DISABLED(false) }
private enum class VoteCountsConfig(val value: Boolean) { ENABLED(true), DISABLED(false) }

private fun ReadableReportConfig.copyWith(config: CommentsConfig) = this.copy(voteComments = config.value)
private fun ReadableReportConfig.copyWith(config: BallotsLineConfig) = this.copy(totalBallotCount = config.value)
private fun ReadableReportConfig.copyWith(config: VoteCountsConfig) = this.copy(voteComments = config.value)

class InvalidAssessmentNameException(val name: String) : CliException("Invalid exception name: $name")

sealed class NeededAssessments {
    /**
     * Returns a list of assessments that should be output.
     *
     * @throws InvalidAssessmentNameException if an assessment name is given that does not exist within [availableAssessments]
     */
    abstract fun selectFrom(availableAssessments: List<AssessmentData>): ImmutableList<AssessmentData>
}

object AllAssessments : NeededAssessments() {
    /**
     * Returns all available assessments.
     */
    override fun selectFrom(availableAssessments: List<AssessmentData>) = availableAssessments.toImmutableList()
}

data class SingleAssessment(val name: String) : NeededAssessments() {
    /**
     * Returns the (sole) assessment whose name is [name]. Throws [InvalidAssessmentNameException] if that one does
     * not exist.
     */
    override fun selectFrom(availableAssessments: List<AssessmentData>): ImmutableList<AssessmentData> {
        val assessmentsByName = availableAssessments.associateBy { it.name }
        val selectedAssessment = assessmentsByName[name]

        if (selectedAssessment != null) return persistentListOf(selectedAssessment)

        throw InvalidAssessmentNameException(name)
    }
}

class AssessmentNotSpecifiedException : CliParseException("Must specify a single assessment (or \"all\") - none were specified")
class MultipleAssessmentsSpecifiedException : CliParseException("Must specify a single assessment (or \"all\") - multiple were specified")

private fun readNeededAssessment(commandLine: CommandLine): NeededAssessments {
    val argList = commandLine.argList as List<String>

    if (argList.size < 1) throw AssessmentNotSpecifiedException()
    if (argList.size > 1) throw MultipleAssessmentsSpecifiedException()

    val assessmentString = argList.first()
    return if (assessmentString.equals("all", ignoreCase = true)) AllAssessments else SingleAssessment(
        assessmentString
    )
}

private fun withOverrides(commandLine: CommandLine, baseConfig: ReadableReportConfig): ReadableReportConfig {
    var config = baseConfig

    val comments = readCommentsConfig(commandLine)
    if (comments != null) config = config.copyWith(comments)

    val ballotsLine = readBallotsLineConfig(commandLine)
    if (ballotsLine != null) config = config.copyWith(ballotsLine)

    val voteCounts = readVoteCountsConfig(commandLine)
    if (voteCounts != null) config = config.copyWith(voteCounts)

    return config
}

private fun readFormatter(commandLine: CommandLine): AssessmentFormatter? {
    return when {
        commandLine.hasOption(FORM_LONG) -> HumanReadableFormatter(
            withOverrides(commandLine, CONFIG_LONG)
        )

        commandLine.hasOption(FORM_OFFICIAL) -> HumanReadableFormatter(
            withOverrides(commandLine, CONFIG_OFFICIAL)
        )

        commandLine.hasOption(FORM_SHORT) -> HumanReadableFormatter(
            withOverrides(commandLine, CONFIG_SHORT)
        )

        commandLine.hasOption(FORM_JSON) -> JsonFormatter

        commandLine.hasOption(FORM_REWARDS) -> RewardsFormatter

        else -> null
    }
}

private fun readDestination(commandLine: CommandLine): AssessmentDestination? {
    return when {
        commandLine.hasOption(DEST_STDOUT) -> StdoutDestination

        commandLine.hasOption(DEST_DIR) -> {
            val dirValue = commandLine.getOptionValue(DEST_DIR)
            if (dirValue != null) NamedDirDestination(dirValue) else UnnamedDirDestination
        }

        commandLine.hasOption(DEST_FILE) -> {
            val fileValue = commandLine.getOptionValue(DEST_FILE)
            if (fileValue != null) NamedFileDestination(fileValue) else UnnamedFileDestination
        }

        else -> null
    }
}

private fun readCommentsConfig(commandLine: CommandLine): CommentsConfig? {
    return when {
        commandLine.hasOption(VOTE_COMMENTS_YES) -> CommentsConfig.ENABLED
        commandLine.hasOption(VOTE_COMMENTS_NO) -> CommentsConfig.DISABLED
        else -> null
    }
}

private fun readBallotsLineConfig(commandLine: CommandLine): BallotsLineConfig? {
    return when {
        commandLine.hasOption(BALLOTS_LINE_YES) -> BallotsLineConfig.ENABLED
        commandLine.hasOption(BALLOTS_LINE_NO) -> BallotsLineConfig.DISABLED
        else -> null
    }
}

private fun readVoteCountsConfig(commandLine: CommandLine): VoteCountsConfig? {
    return when {
        commandLine.hasOption(VOTE_KIND_COUNTS_YES) -> VoteCountsConfig.ENABLED
        commandLine.hasOption(VOTE_KIND_COUNTS_NO) -> VoteCountsConfig.DISABLED
        else -> null
    }
}

private fun readCliConfig(commandLine: CommandLine): CliConfig {
    return CliConfig(
        formatter = readFormatter(commandLine),
        neededAssessments = readNeededAssessment(commandLine),
        destination = readDestination(commandLine)
    )
}

data class CliConfig(
    val formatter: AssessmentFormatter?,
    val neededAssessments: NeededAssessments,
    val destination: AssessmentDestination?
)

fun parseCli(args: Array<String>): CliConfig {
    val parseResult = try {
        DefaultParser().parse(cliOptions(), args)!!
    } catch (e: ParseException) {
        throw CliParseException(e)
    }

    return readCliConfig(parseResult)
}

fun parseCli(args: Iterable<String>) = parseCli(args.toList().toTypedArray())

fun helpString(): String {
    val formatter = HelpFormatter()
    formatter.optionComparator = null

    val writer = CharArrayWriter()
    formatter.printHelp(
        PrintWriter(writer),
        formatter.width,
        "java -jar assessor.jar",
        null,
        cliOptions(),
        formatter.leftPadding,
        formatter.descPadding,
        null,
        true
    )

    writer.flush()
    return writer.toString()
}
