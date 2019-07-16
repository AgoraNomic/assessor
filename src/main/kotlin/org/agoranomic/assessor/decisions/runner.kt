package org.agoranomic.assessor.decisions

import org.agoranomic.assessor.lib.AssessmentData
import org.agoranomic.assessor.lib.ReportConfig
import org.agoranomic.assessor.lib.report
import org.agoranomic.assessor.lib.resolve
import org.apache.commons.cli.*
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

private val assessments = mapOf("8188-8195" to `assessment 8188 to 8195`(), "8196-8201" to `assessment 8196 to 8201`())

inline fun <reified T> Option.Builder.type() = this.type(T::class.java)!!

const val VOTE_COMMENTS_YES = "vote-comments"
const val VOTE_COMMENTS_NO = "no-vote-comments"
const val DEST_STDOUT = "stdout"
const val DEST_FILE = "file"
const val DEST_DIR = "dir"
const val FORM_LONG = "long"
const val FORM_SHORT = "short"

enum class Form {
    LONG(
        ReportConfig(voteComments = true, totalBallotCount = true, voteKindBallotCount = true)
    ),
    SHORT(
        ReportConfig(voteComments = false, totalBallotCount = false, voteKindBallotCount = false)
    );

    val reportConfig: ReportConfig

    constructor(reportConfig: ReportConfig) {
        this.reportConfig = reportConfig
    }
}

val DEFAULT_FORM = Form.LONG

fun main(args: Array<String>) {
    val options = Options()

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

    val optGroupDest = OptionGroup().let {
        it.addOption(optDestStdout)
        it.addOption(optDestFile)
        it.addOption(optDestDir)

        it
    }

    options.addOptionGroup(optGroupDest)

    val optVoteCommentsYes = Option.builder().longOpt(VOTE_COMMENTS_YES).desc("Print vote comments").build()
    val optVoteCommentsNo = Option.builder().longOpt(VOTE_COMMENTS_NO).desc("Don't print vote comments").build()
    val optGroupVoteComments = OptionGroup().let {
        it.addOption(optVoteCommentsYes)
        it.addOption(optVoteCommentsNo)

        it
    }

    options.addOptionGroup(optGroupVoteComments)

    val optFormLong = Option.builder().longOpt(FORM_LONG).desc("Generally longer form").build()
    val optFormShort = Option.builder().longOpt(FORM_SHORT).desc("Generally short form").build()
    val optGroupForm = OptionGroup().let {
        it.addOption(optFormLong)
        it.addOption(optFormShort)

        it
    }

    options.addOptionGroup(optGroupForm)

    if (args.isEmpty()) {
        HelpFormatter().let {
            it.optionComparator = null
            it.printHelp("java -jar assessor.jar", options, true)
        }

        return
    }

    val commandLine: CommandLine = run {
        try {
            return@run DefaultParser().parse(options, args)
        } catch (e: AlreadySelectedException) {
            println("Specified conflicting options: \"${e.optionGroup.selected!!}\" and \"${e.option.longOpt}\"")
        }

        return@main
    }

    fun provided(option: Option) = commandLine.options.contains(option)
    fun value(option: Option) = commandLine.options.find { it == option }!!.value ?: null

    val form = run {
        var value = DEFAULT_FORM
        if (provided(optFormLong)) value = Form.LONG
        if (provided(optFormShort)) value = Form.SHORT
        return@run value
    }

    var config = form.reportConfig

    if (provided(optVoteCommentsYes)) config = config.copy(voteComments = true)
    if (provided(optVoteCommentsNo)) config = config.copy(voteComments = false)

    val toAssess: List<Pair<String, AssessmentData>> = run {
        val argList = commandLine.argList

        if (argList.size != 1) {
            println("Must specify a single assessment (or \"all\") to assess.")
            return@main
        }

        val arg = argList[0]!!

        if (arg.equals("all", ignoreCase = true)) {
            return@run assessments.toList()
        } else {
            val assessment = assessments[arg]

            if (assessment == null) {
                println("No such assessment \"$arg\": valid options are \"all\" and ${assessments.keys}.")
                return@main
            }

            return@run listOf(arg to assessment)
        }
    }

    val stringAssessments = toAssess.map { it.first to report(resolve(it.second), config) }

    if (provided(optDestStdout) || optGroupDest.selected == null) {
        for ((name, assessment) in stringAssessments) {
            println(assessment)
            println()
        }
    } else if (provided(optDestFile)) {
        val fileName = value(optDestFile)
        if (fileName != null) {
            Files.newBufferedWriter(Path.of(fileName), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
                .use { writer ->
                    for ((name, assessment) in stringAssessments) {
                        writer.write(assessment)
                        writer.newLine()
                    }
                }
        } else {
            for ((name, assessment) in stringAssessments) {
                Files.newBufferedWriter(
                    Path.of(name + ".txt"),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
                ).use { writer ->
                    writer.write(assessment)
                }
            }
        }
    } else if (provided(optDestDir)) {
        val dirName = value(optDestDir) ?: "out"
        val dirPath = Path.of(dirName)!!

        Files.createDirectories(dirPath)

        for ((name, assessment) in stringAssessments) {
            val filePath = dirPath.resolve(name + ".txt")

            Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
                .use { writer ->
                    writer.write(assessment)
                }
        }
    }
}