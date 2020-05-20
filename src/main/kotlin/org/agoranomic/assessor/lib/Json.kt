package org.agoranomic.assessor.lib

import kotlinx.serialization.json.*
import java.math.BigDecimal
import java.math.BigInteger

private fun json(int: Int) = JsonLiteral(int)
private fun json(bigInteger: BigInteger) = JsonLiteral(bigInteger)
private fun json(bigDecimal: BigDecimal) = JsonLiteral(bigDecimal.toString()) // Avoid floating point insanity
private fun json(string: String) = JsonLiteral(string)
private fun json(list: List<JsonElement>) = JsonArray(list)

private fun json(person: Person) = json(person.name)

@JvmName("jsonOfPlayers")
private fun json(iterable: Iterable<Person>) = json(iterable.map { json(it) })

private fun json(proposalNumber: ProposalNumber) = json(proposalNumber.raw)
private fun json(proposalAI: ProposalAI) = json(proposalAI.raw)

private fun json(proposal: Proposal) = json {
    "number" to json(proposal.number)
    "ai" to json(proposal.ai)
    "title" to json(proposal.title)
    "author" to json(proposal.author)
    "coauthors" to json(proposal.coauthors)
    "text" to json(proposal.text)
}

@JvmName("jsonOfProposals")
private fun json(iterable: Iterable<Proposal>) = json(iterable.map { json(it) })

private fun json(quorum: Quorum) = json(quorum.raw)
private fun json(quorum: ProposalQuorum) = json(quorum.raw)
private fun json(quorum: AssessmentQuorum) = json(quorum.raw)

private fun json(votingStrength: VotingStrength) = json(votingStrength.raw)

private fun json(votingStrength: VotingStrengthWithComment) = json {
    "value" to json(votingStrength.value)
    if (votingStrength.comment != null) "comment" to json(votingStrength.comment)
}

private fun json(votingStrengths: VotingStrengthMap) = json {
    "default" to json(votingStrengths.defaultStrength)
    "players" to json(votingStrengths.specialPeople.map {
        json {
            "player" to json(it)
            "strength" to json(votingStrengths[it])
        }
    })
}

private fun json(propsalResult: ProposalResult) = json(propsalResult.name)

private fun json(vote: SimpleVote) = json {
    "value" to vote.kind.name

    val comment = vote.comment
    if (comment != null) "comment" to json(comment)
}

private fun json(voteMap: SimplifiedSingleProposalVoteMap) = jsonArray {
    for (player in voteMap.voters) {
        +json {
            "voter" to json(player)
            "vote" to json(voteMap[player])
        }
    }
}

private fun json(resolutionData: ResolutionData) = json {
    "result" to json(resolutionData.result)
    "strength_for" to json(resolutionData.strengths.strengthFor)
    "strength_against" to json(resolutionData.strengths.strengthAgainst)
    "votes" to json(resolutionData.votes)
}

fun json(resolutionMap: ProposalResolutionMap) = json {
    "name" to json(resolutionMap.assessmentName)
    "proposals" to json(resolutionMap.proposals)
    "quorum" to json(resolutionMap.quorum)
    "resolutions" to json(resolutionMap.proposals.map { proposal ->
        val proposalNumber = proposal.number
        val resolution = resolutionMap.resolutionOf(proposalNumber)

        json {
            "proposal" to json(proposalNumber)
            "resolution" to json(resolution)
            "strengths" to json(resolutionMap.votingStrengthsFor(proposalNumber))
        }
    })
}
