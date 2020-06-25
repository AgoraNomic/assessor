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

private fun json(quorum: Quorum) = json(quorum.count())
private fun json(quorum: ProposalQuorum) = json(quorum.generic())
private fun json(quorum: AssessmentQuorum) = json(quorum.generic())

private fun json(votingStrength: VotingStrength) = json(votingStrength.raw)

private fun json(votingStrength: VotingStrengthWithComment) = json {
    "value" to json(votingStrength.value)
    if (votingStrength.comment != null) "comment" to json(votingStrength.comment)
}

private fun json(description: VotingStrengthModificationDescription) = json {
    "readable" to json(description.readable)
    "kind" to json(description.kind)
    "parameters" to json(description.parameters.entries.map { (name, value) ->
        json {
            "name" to json(name)
            "value" to json(value)
        }
    })
}

private fun json(votingStrengths: VotingStrengthTrailForPersons) =
    json(votingStrengths.overridesMap().map { (person, trail) ->
        json {
            "person" to json(person)
            "initial" to json(trail.initial)
            "modifications" to json(trail.modificationsWithValue().map { (modification, strength) ->
                json {
                    "description" to json(modification.description)
                    "current_strength" to json(strength)
                }
            })
            "final" to json(trail.final)
        }
    })

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
