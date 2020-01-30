package org.agoranomic.assessor.lib

import kotlinx.serialization.json.*

fun json(number: Number) = JsonLiteral(number)
fun json(string: String) = JsonLiteral(string)
fun json(list: List<JsonElement>) = JsonArray(list)

fun json(person: Person) = json(person.name)

@JvmName("jsonOfPlayers")
fun json(iterable: Iterable<Person>) = json(iterable.map { json(it) })

fun json(proposalNumber: ProposalNumber) = json(proposalNumber.raw)
fun json(proposalAI: ProposalAI) = json(proposalAI.raw)

fun json(proposal: Proposal) = json {
    "number" to json(proposal.number)
    "ai" to json(proposal.ai)
    "title" to json(proposal.title)
    "author" to json(proposal.author)
    "coauthors" to json(proposal.coauthors)
    "text" to json(proposal.text)
}

@JvmName("jsonOfProposals")
fun json(iterable: Iterable<Proposal>) = json(iterable.map { json(it) })

fun json(votingStrength: VotingStrength) = json(votingStrength.raw)

fun json(votingStrength: VotingStrengthWithComment) = json {
    "value" to json(votingStrength.value)
    if (votingStrength.comment != null) "comment" to json(votingStrength.comment)
}

fun json(votingStrengths: VotingStrengthMap) = json {
    "default" to json(votingStrengths.defaultStrength)
    "players" to json(votingStrengths.specialPeople.map {
        json {
            "player" to json(it)
            "strength" to json(votingStrengths[it])
        }
    })
}

fun json(propsalResult: ProposalResult) = json(propsalResult.name)

fun json(vote: SimpleVote) = json {
    "value" to vote.kind.name

    val comment = vote.comment
    if (comment != null) "comment" to json(comment)
}

fun json(voteMap: SimplifiedSingleProposalVoteMap) = jsonArray {
    for (player in voteMap.voters) {
        +json {
            "voter" to json(player)
            "vote" to json(voteMap[player])
        }
    }
}

fun json(resolutionData: ResolutionData) = json {
    "result" to json(resolutionData.result)
    "strength_for" to json(resolutionData.strengthFor)
    "strength_against" to json(resolutionData.strengthAgainst)
    "votes" to json(resolutionData.votes)
}

fun json(resolutionMap: ProposalResolutionMap) = json {
    "name" to json(resolutionMap.assessmentName)
    "proposals" to json(resolutionMap.proposals)
    "quorum" to json(resolutionMap.quorum)
    "strengths" to json(resolutionMap.votingStrengths)
    "resolutions" to json(resolutionMap.proposals.map { proposal ->
        val proposalNumber = proposal.number
        val resolution = resolutionMap[proposalNumber]

        json {
            "proposal" to json(proposalNumber)
            "resolution" to json(resolution)
        }
    })
}
