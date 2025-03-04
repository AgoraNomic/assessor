package org.agoranomic.assessor.cli

import java.nio.file.Files
import java.nio.file.Path

private fun playerName(player: String): String {
    return when (player) {
        "ais523" -> "ais523"
        "Alexis" -> "Alexis"
        "Aris" -> "Aris"
        "ATMunn" -> "ATMunn"
        "Bernie" -> "Bernie"
        "Corona" -> "Corona"
        "D. Margaux", "D Margaux" -> "DMargaux"
        "Falsifian" -> "Falsifian"
        "4st" -> "Forest"
        "G." -> "G"
        "Gaelan" -> "Gaelan"
        "grok" -> "grok"
        "Janet" -> "Janet"
        "juan" -> "juan"
        "Kate", "qenya" -> "Kate"
        "Mischief" -> "Mischief"
        "Murphy" -> "Murphy"
        "nix" -> "nix"
        "omd" -> "omd"
        "PSS", "P.S.S.", "Publius Scribonius Scholasticus" -> "PSS"
        "R. Lee", "R Lee" -> "RLee"
        "Telnaior" -> "Telnaior"
        "Trigon" -> "Trigon"
        "Tarhulinder" -> "Tarhulinder"
        "secretsnail", "snail", "Secretsnail9" -> "snail"
        "Walker" -> "Walker"
        "Jacob Arduino" -> "JacobArduino"
        "Yachay", "Yachay Wayllukuq" -> "Yachay"
        "Zipzap" -> "Zipzap"
        else -> "unknown_player(\"$player\")"
    }
}

private fun String.afterExpected(prefix: String): String {
    require(startsWith(prefix))
    return substring(prefix.length)
}

private fun String.afterExpected(regex: Regex): String {
    val match = regex.find(this)
    require(match != null && match.range.first == 0) { "Unable to match pattern $regex to line $this" }

    return this.substring(match.range.last + 1)
}

private fun String.escapedAndQuoted(): String {
    return "\"" + this.replace("\\", "\\\\").replace("$", "\\\$").replace("\"", "\\\"") + "\""
}

private fun String.escapedAndMultiLineQuoted(): String {
    val body = replace("$", "\${'$'}")
    return "\"\"\"\n$body\"\"\""
}

private const val ID_LINE_INDEX = 0
private const val TITLE_LINE_INDEX = 1
private const val AI_LINE_INDEX = 2
private const val AUTHOR_LINE_INDEX = 3
private const val COAUTHORS_LINE_INDEX = 4
private const val TEXT_START_LINE_INDEX = 5

private fun distributionToDSL(rawDistribution: String): String {
    val distribution = rawDistribution.trim()
    val proposals = distribution.split("//////////////////////////////////////////////////////////////////////")
        .filter { it.isNotEmpty() }

    fun StringBuilder.appendScopeOpen(opener: String) {
        appendLine("$opener {")
    }

    fun StringBuilder.appendScopeClose() {
        appendLine("}")
    }

    fun StringBuilder.appendScope(opener: String, block: () -> Unit) {
        appendScopeOpen(opener)

        try {
            block()
        } finally {
            appendScopeClose()
        }
    }

    fun StringBuilder.appendDecl(decl: String) {
        appendLine(decl)
    }

    return buildString {
        appendScope("proposals(v4)") {
            for (untrimmedProposal in proposals) {
                val proposal = untrimmedProposal.trim()
                val lines = proposal.lines()
                val id = lines[ID_LINE_INDEX].afterExpected("ID: ").toInt()

                appendScope("proposal($id)") {
                    val title = run {
                        val titleLine = lines[TITLE_LINE_INDEX]

                        if (titleLine == "Title:") {
                            null
                        } else {
                            titleLine.afterExpected("Title: ")
                        }
                    }

                    val codeTitle = title?.escapedAndQuoted() ?: "null"

                    appendDecl("title($codeTitle)")

                    val ai = lines[AI_LINE_INDEX].afterExpected(Regex("Adoption [iI]ndex: ")).toBigDecimal()

                    appendDecl("ai(${ai.toString().escapedAndQuoted()})")

                    val author = lines[AUTHOR_LINE_INDEX].afterExpected("Author: ")

                    appendDecl("author(${playerName(author)})")

                    val coauthorsString =
                        lines[COAUTHORS_LINE_INDEX]
                            .afterExpected(Regex("Co-?[aA]uthor(s|\\(s\\))?:"))
                            .trim()

                    val coauthorFullNames = coauthorsString.split(", ").filter { it.isNotBlank() }
                    val coauthorProgramNames = coauthorFullNames.map { playerName(it) }

                    if (coauthorProgramNames.isNotEmpty()) {
                        appendDecl("coauthors(${coauthorProgramNames.joinToString(", ")})")
                    }

                    appendLine()

                    val text =
                        lines
                            .subList(TEXT_START_LINE_INDEX, lines.size)
                            .map { it.trimEnd() }
                            .dropWhile { it.isBlank() }
                            .joinToString("\n")

                    val quotedText = text.escapedAndMultiLineQuoted()

                    appendDecl("text($quotedText)")
                }

                appendLine()
            }
        }
    }
}

fun main(args: Array<String>) {
    val path = Path.of(args.getOrElse(0) { "distribution.txt" })

    println(distributionToDSL(Files.readString(path)))
}
