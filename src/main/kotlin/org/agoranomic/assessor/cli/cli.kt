package org.agoranomic.assessor.cli

import org.agoranomic.assessor.lib.ReportConfig
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

private val CONFIG_LONG = ReportConfig(voteComments = true, totalBallotCount = true, voteKindBallotCount = true)
private val CONFIG_SHORT = ReportConfig(voteComments = false, totalBallotCount = false, voteKindBallotCount = false)
private val CONFIG_OFFICIAL = ReportConfig(voteComments = false, totalBallotCount = true, voteKindBallotCount = true)

val DEFAULT_FORMATTER =
    HumanReadableFormatter(CONFIG_LONG)

private inline fun <reified T> Option.Builder.type() = this.type(T::class.java)!!

private fun destinationOptionGroup(): OptionGroup {
    val optDestStdout = Option.builder().longOpt(DEST_STDOUT).desc("Print resolutions to the standard output").build()
    val optDestFile =
        Option.builder().longOpt(DEST_FILE).desc("Print resolutions to the provided file").argName("file").hasArg()
            .argName("file").optionalArg(
                true
            ).type<String>().build()
    val optDestDir =
        Option.builder().longOpt(DEST_DIR).desc("Print resolutions to files in the provided directory").hasArg()
            .argName("directory").optionalArg(
                true
            ).type<String>().build()

    val optGroupDest = OptionGroup().also {
        it.addOption(optDestStdout)
        it.addOption(optDestFile)
        it.addOption(optDestDir)
    }

    return optGroupDest
}

private fun commentsOptionGroup(): OptionGroup {
    val optVoteCommentsYes = Option.builder().longOpt(VOTE_COMMENTS_YES).desc("Print vote comments").build()
    val optVoteCommentsNo = Option.builder().longOpt(VOTE_COMMENTS_NO).desc("Don't print vote comments").build()
    val optGroupVoteComments = OptionGroup().also {
        it.addOption(optVoteCommentsYes)
        it.addOption(optVoteCommentsNo)
    }

    return optGroupVoteComments
}

private fun ballotsLineOptionGroup(): OptionGroup {
    val optBallotsLineYes = Option.builder().longOpt(BALLOTS_LINE_YES).desc("Print BALLOTS line").build()
    val optBallotsLineNo = Option.builder().longOpt(BALLOTS_LINE_NO).desc("Don't print BALLOTS line").build()
    val optGroupBallotsLint = OptionGroup().also {
        it.addOption(optBallotsLineYes)
        it.addOption(optBallotsLineNo)
    }

    return optGroupBallotsLint
}

private fun voteCountsOptionGroup(): OptionGroup {
    val optSubVoteCountYes = Option.builder().longOpt(VOTE_KIND_COUNTS_YES).desc("Print vote counts").build()
    val optSubVoteCountNo = Option.builder().longOpt(VOTE_KIND_COUNTS_NO).desc("Don't print vote counts").build()
    val optGroupSubVoteCount = OptionGroup().also {
        it.addOption(optSubVoteCountYes)
        it.addOption(optSubVoteCountNo)
    }

    return optGroupSubVoteCount
}

private fun formOptionGroup(): OptionGroup {
    val optFormLong = Option.builder().longOpt(FORM_LONG).desc("Generally longer form").build()
    val optFormShort = Option.builder().longOpt(FORM_SHORT).desc("Generally short form").build()
    val optFormOfficial = Option.builder().longOpt(FORM_OFFICIAL).desc("Official report form").build()
    val optFormJson = Option.builder().longOpt(FORM_JSON).desc("Machine-readable JSON form").build()
    val optGroupForm = OptionGroup().also {
        it.addOption(optFormLong)
        it.addOption(optFormShort)
        it.addOption(optFormOfficial)
        it.addOption(optFormJson)
    }

    return optGroupForm
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

private fun ReportConfig.copyWith(config: CommentsConfig) = this.copy(voteComments = config.value)
private fun ReportConfig.copyWith(config: BallotsLineConfig) = this.copy(totalBallotCount = config.value)
private fun ReportConfig.copyWith(config: VoteCountsConfig) = this.copy(voteComments = config.value)

sealed class NeededAssessments
object AllAssessments : NeededAssessments()
data class SingleAssessment(val name: String) : NeededAssessments()

private data class ParsedCli(
    val neededAssessments: NeededAssessments,
    val formatter: AssessmentFormatter?,
    val destination: AssessmentDestination?
)

open class CliParseException : Exception {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(cause: Exception) : super(cause)
    constructor(message: String, cause: Exception) : super(message, cause)
}

class BadAssessmentException : CliParseException("Must specify a single assessment (or \"all\")")

private fun readNeededAssessment(commandLine: CommandLine): NeededAssessments {
    val argList = commandLine.argList as List<String>
    if (argList.size != 1) throw BadAssessmentException()

    val assessmentString = argList.first()
    return if (assessmentString.equals("all", ignoreCase = true)) AllAssessments else SingleAssessment(
        assessmentString
    )
}

private fun withOverrides(commandLine: CommandLine, baseConfig: ReportConfig): ReportConfig {
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

private fun readParsedCli(commandLine: CommandLine): ParsedCli {
    return ParsedCli(
        readNeededAssessment(commandLine),
        readFormatter(commandLine),
        readDestination(commandLine)
    )
}

private fun rawParseCli(args: Iterable<String>): ParsedCli {
    val argsArray = args.toList().toTypedArray()

    val parseResult = try {
        DefaultParser().parse(cliOptions(), argsArray)!!
    } catch (e: ParseException) {
        throw CliParseException(e)
    }

    return readParsedCli(parseResult)
}

data class CliConfig(
    val formatter: AssessmentFormatter?,
    val neededAssessments: NeededAssessments,
    val destination: AssessmentDestination?
)

fun parseCli(args: Iterable<String>): CliConfig {
    val parsedCli = rawParseCli(args)
    return CliConfig(
        parsedCli.formatter,
        parsedCli.neededAssessments,
        parsedCli.destination
    )
}

fun parseCli(args: Array<String>) = parseCli(args.toList())

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
