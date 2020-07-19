package org.agoranomic.assessor.cli

import java.nio.file.Files
import java.nio.file.Path

private fun playerName(player: String): String {
    return when (player) {
        "Alexis" -> "Alexis"
        "Aris" -> "Aris"
        "ATMunn" -> "ATMunn"
        "Bernie" -> "Bernie"
        "Corona" -> "Corona"
        "D. Margaux", "D Margaux" -> "DMargaux"
        "Falsifian" -> "Falsifian"
        "G." -> "G"
        "Gaelan" -> "Gaelan"
        "grok" -> "grok"
        "Jason Cobb", "Jason" -> "Jason"
        "Murphy" -> "Murphy"
        "nch" -> "nch"
        "omd" -> "omd"
        "PSS", "P.S.S.", "Publius Scribonius Scholasticus" -> "PSS"
        "R. Lee", "R Lee" -> "RLee"
        "Telnaior" -> "Telnaior"
        "Trigon" -> "Trigon"
        "twg" -> "twg"
        "Walker" -> "Walker"
        "Tarhulinder" -> "Tarhulinder"
        "Jacob Arduino" -> "JacobArduino"
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

    return this.substring(match.range.endInclusive + 1)
}

private fun String.escapedAndQuoted(): String {
    return "\"" + this.replace("\\", "\\\\").replace("$", "\\\$").replace("\"", "\\\"") + "\""
}

private fun String.escapedAndMultiLineQuoted(): String {
    val body = replace("$", "\${'$'}")
    return "\"\"\"\n$body\"\"\""
}

private fun distributionToDSL(rawDistribution: String): String {
    val distribution = rawDistribution.trim()
    val proposals = distribution.split("//////////////////////////////////////////////////////////////////////")
        .filter { it.isNotEmpty() }

    val stringBuilder = StringBuilder()

    fun emit(string: String) {
        stringBuilder.append(string)
    }

    fun emitln() {
        stringBuilder.appendln()
    }

    fun emitln(string: String) {
        stringBuilder.appendln(string)
    }

    fun emitScopeOpen(opener: String) {
        emit(opener)
        emit(" {")
        emitln()
    }

    fun emitScopeClose() {
        emitln("}")
    }

    fun scope(opener: String, block: () -> Unit) {
        emitScopeOpen(opener)
        block()
        emitScopeClose()
    }

    fun emitDecl(decl: String) {
        emitln(decl)
    }

    scope("proposals(v1)") {
        for (untrimmedProposal in proposals) {
            val proposal = untrimmedProposal.trim()

            val lines = proposal.lines()

            val id = lines[0].afterExpected("ID: ").toInt()

            scope("proposal($id)") {

                val title = lines[1].afterExpected("Title: ")
                val quotedTitle = title.escapedAndQuoted()

                emitDecl("title($quotedTitle)")

                val ai = lines[2].afterExpected("Adoption index: ").toBigDecimal()

                emitDecl("ai(${ai.toString().escapedAndQuoted()})")

                val author = lines[3].afterExpected("Author: ")

                emitDecl("author(${playerName(author)})")

                val coauthorsString = lines[4].afterExpected(Regex("Co-author(s|\\(s\\)):")).trim()
                val coauthors = coauthorsString.split(", ").filter { it.isNotBlank() }

                if (coauthors.isNotEmpty()) {
                    val coauthorsListStr = coauthors.joinToString(", ") { playerName(it) }
                    val coauthorsDecl = "coauthors($coauthorsListStr)"

                    emitDecl(coauthorsDecl)
                }

                emitln()

                val text =
                    lines.subList(5, lines.size).map { it.trimEnd() }.dropWhile { it.isBlank() }.joinToString("\n")
                val quotedText = text.escapedAndMultiLineQuoted()

                emitDecl("text($quotedText)")
            }

            emitln()
        }
    }

    return stringBuilder.toString()
}

fun main(args: Array<String>) {
    val path = Path.of(args.getOrElse(0) { "distribution.txt" })

    println(distributionToDSL(Files.readString(path)))
}
