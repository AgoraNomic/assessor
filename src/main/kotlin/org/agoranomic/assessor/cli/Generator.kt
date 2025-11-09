package org.agoranomic.assessor.cli

import org.randomcat.util.groupByPrimaryKey
import java.math.BigInteger
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
        else -> "unknown(${player.escapedAndQuoted()})"
    }
}

private fun String.afterExpected(prefix: String): String {
    require(startsWith(prefix))
    return substring(prefix.length)
}

private fun String.escapedAndQuoted(): String {
    return "\"" + this.replace("\\", "\\\\").replace("$", "\\\$").replace("\"", "\\\"") + "\""
}

private fun String.escapedAndMultiLineQuoted(): String {
    val body = replace("$", "\${'$'}")
    return "\"\"\"\n$body\"\"\""
}

enum class ProposalClass {
    ORDINARY, DEMOCRATIC,
}

data class Header(
    val id: BigInteger,
    val proposalClass: ProposalClass,
    val authors: List<String>,
    val ai: String,
    val title: String,
)

data class ProposalData(
    val header: Header,
    val text: String,
)

private val HEADER_DELIMITER = Regex("-+")
private val PROPOSAL_DELIMITER = Regex("==========")

private fun parseProposals(lines: List<String>): List<ProposalData> {
    var nextLineIndex = 0

    fun hasNext(): Boolean {
        return nextLineIndex < lines.size
    }

    fun peekLine(): String {
        check(nextLineIndex >= 0)

        require(hasNext()) {
            "Attempt to read non-existent next line."
        }

        val line = lines[nextLineIndex]

        require(line.none { it.isSurrogate() }) {
            "BMP only, please."
        }

        return line
    }

    fun nextLine(): String {
        val line = peekLine()
        ++nextLineIndex

        return line
    }

    fun skipBlanks() {
        while (hasNext() && peekLine().isBlank()) {
            nextLine()
        }
    }

    fun requireBlanks() {
        val next = nextLine()
        require(next.isBlank()) { "Expected blank line, but got: $next" }

        skipBlanks()
    }

    skipBlanks()

    val tocHeader = nextLine()
    require(tocHeader.matches(Regex("ID\\s+Author(?:\\(s\\))?\\s+AI\\s+Name\\s*")))
    require(nextLine().matches(HEADER_DELIMITER))

    val idIndex = tocHeader.indexOf("ID ").also { require(it >= 0) }

    val authorIndex = listOf(
        tocHeader.indexOf("Author "),
        tocHeader.indexOf("Author(s) "),
    ).single { it >= 0 }

    val aiIndex = tocHeader.indexOf("AI ").also { require(it >= 0) }
    val nameIndex = tocHeader.indexOf("Name").also { require(it >= 0) }

    val headers = mutableListOf<Header>()
    val pendingAuthors = mutableMapOf<BigInteger, List<String>>()
    val textAuthors = mutableMapOf<BigInteger, List<String>>()

    run {
        while (!peekLine().matches(HEADER_DELIMITER)) {
            val tocLine = nextLine()

            val idPart = tocLine.substring(idIndex, authorIndex).trimEnd()
            val authorPart = tocLine.substring(authorIndex, aiIndex).trimEnd()
            val aiPart = tocLine.substring(aiIndex, nameIndex).trimEnd()
            val titlePart = tocLine.substring(nameIndex).trimEnd()

            val (id, proposalClass) = if (idPart.endsWith("*")) {
                idPart.dropLast(1).toBigInteger() to ProposalClass.DEMOCRATIC
            } else if (idPart.endsWith("~")) {
                idPart.dropLast(1).toBigInteger() to ProposalClass.ORDINARY
            } else {
                throw IllegalArgumentException("Expected ID to have class signifier: $idPart")
            }

            val authors: List<String>

            if (authorPart.endsWith("+")) {
                authors = emptyList()

                val headerAuthors = authorPart.removeSuffix("+").split(",").map { it.trim() }
                require(headerAuthors.size == 1)

                pendingAuthors[id] = headerAuthors
            } else {
                authors = authorPart.split(",").map { it.trim() }
            }

            headers.add(
                Header(
                    id = id,
                    proposalClass = proposalClass,
                    authors = authors,
                    ai = aiPart,
                    title = titlePart,
                )
            )
        }

        // Skip the header delimiter.
        nextLine()
    }

    val headersById = headers.groupByPrimaryKey { it.id }

    skipBlanks()
    require(peekLine().matches(PROPOSAL_DELIMITER))

    val textById = run {
        val out = mutableMapOf<BigInteger, String>()

        while (hasNext()) {
            require(nextLine().matches(PROPOSAL_DELIMITER))

            skipBlanks()

            if (!hasNext()) {
                // Trailing delimiter.
                break
            }

            val id = nextLine().afterExpected("ID ").trim().toBigInteger()

            require(headersById.containsKey(id)) {
                "Unexpected ID in text section: $id"
            }

            val titleAiLine = nextLine()

            val header = headersById.getValue(id)
            require(titleAiLine == "${header.title} (AI=${header.ai})")

            if (peekLine().startsWith("author:", ignoreCase = true)) {
                val authorLine = nextLine()
                val author = (pendingAuthors[id] ?: headers.single { it.id == id }.authors).first()
                require(authorLine.lowercase().removePrefix("author:").trim().equals(author, ignoreCase = true))
            }

            val needsCoauthors = pendingAuthors.containsKey(id)

            if (needsCoauthors || peekLine().startsWith("coauthors", ignoreCase = true)) {
                val coauthorsLine = nextLine()
                val coauthorsParts = coauthorsLine.split(":").map { it.trim() }

                require(coauthorsParts.size <= 2)
                require(coauthorsParts.first().contentEquals("coauthors", ignoreCase = true))

                if (needsCoauthors) {
                    require(coauthorsParts.size == 2)
                    textAuthors[id] = pendingAuthors.getValue(id) + coauthorsParts[1].split(", ").map { it.trim() }
                } else {
                    require(coauthorsParts.size == 1 || coauthorsParts[1].isBlank())
                }
            }

            requireBlanks()

            val textBuilder = StringBuilder()

            while (hasNext() && !peekLine().matches(PROPOSAL_DELIMITER)) {
                textBuilder.appendLine(nextLine())
            }

            check(out.put(id, textBuilder.toString().trim()) == null) {
                "Duplicate ID found in text section: $id"
            }
        }

        out
    }

    require(headersById.keys == textById.keys) {
        "Mismatch in IDs between header and text sections: ${headersById.keys} vs ${textById.keys}"
    }

    require(pendingAuthors.keys == textAuthors.keys) {
        "Mismatch between proposals with \"+\" in author header and proposals with coauthors in text section: " +
                "${pendingAuthors.keys} vs ${textAuthors.keys}"
    }

    return headersById.map { (id, header) ->
        val effectiveHeader = if (textAuthors.keys.contains(id)) {
            check(header.authors.isEmpty())
            header.copy(authors = textAuthors.getValue(id))
        } else {
            header
        }

        ProposalData(header = effectiveHeader, text = textById.getValue(id))
    }
}

private const val ID_LINE_INDEX = 0
private const val TITLE_LINE_INDEX = 1
private const val AI_LINE_INDEX = 2
private const val AUTHOR_LINE_INDEX = 3
private const val COAUTHORS_LINE_INDEX = 4
private const val TEXT_START_LINE_INDEX = 5

private fun distributionToDSL(rawDistribution: String): String {
    val distribution = rawDistribution.trim()
    val proposals = parseProposals(distribution.lines())

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
            for (proposal in proposals) {
                appendScope("proposal(${proposal.header.id})") {
                    appendDecl("title(${proposal.header.title.escapedAndQuoted()})")
                    appendDecl("ai(${proposal.header.ai.escapedAndQuoted()})")

                    val authors = proposal.header.authors

                    if (authors.isNotEmpty()) {
                        appendDecl("author(${playerName(authors.first())})")

                        val coauthors = authors.drop(1)

                        if (coauthors.isNotEmpty()) {
                            appendDecl(
                                "coauthors(${coauthors.joinToString(", ") { playerName(it) }})"
                            )
                        }
                    }

                    when (proposal.header.proposalClass) {
                        ProposalClass.ORDINARY -> appendDecl("ordinary()")
                        ProposalClass.DEMOCRATIC -> appendDecl("democratic()")
                    }

                    appendLine()

                    appendDecl("text(${proposal.text.escapedAndMultiLineQuoted()})")
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
