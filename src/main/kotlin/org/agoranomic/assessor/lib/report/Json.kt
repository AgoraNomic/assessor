package org.agoranomic.assessor.lib.report

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import org.agoranomic.assessor.lib.proposal.Proposal
import org.agoranomic.assessor.lib.resolve.AssessmentMetadata
import org.agoranomic.assessor.lib.resolve.ProposalResolutionMap
import org.agoranomic.assessor.lib.resolve.ProposalResult
import org.agoranomic.assessor.lib.resolve.ResolutionData
import org.agoranomic.assessor.lib.vote.VoteKind
import org.agoranomic.assessor.lib.vote.VoteStepDescription
import org.agoranomic.assessor.lib.vote.machineIfPresent
import org.agoranomic.assessor.lib.voting_strength.VotingStrengthModificationDescription

@Serializable
private data class AssessmentMetadataDto(
    val name: String,
    val urls: List<String>? = null,
) {
    companion object {
        fun from(metadata: AssessmentMetadata): AssessmentMetadataDto {
            return AssessmentMetadataDto(
                name = metadata.name,
                urls = metadata.urls?.map { it.raw },
            )
        }
    }
}

@Serializable
private data class ProposalDto(
    val version: String,
    val number: Long,
    @SerialName("proposal_ai") val proposalAi: String,
    @SerialName("decision_ai") val decisionAI: String,
    val title: String?,
    @SerialName("author") val authorName: String?,
    @SerialName("coauthors") val coauthorNames: List<String>,
    val text: String,
) {
    companion object {
        fun from(proposal: Proposal): ProposalDto {
            return ProposalDto(
                version = proposal.version.raw.toString(),
                number = proposal.number.raw.longValueExact(),
                proposalAi = proposal.proposalAI.raw.toString(),
                decisionAI = proposal.decisionAI.raw.toString(),
                title = proposal.title,
                authorName = proposal.author?.name,
                coauthorNames = proposal.coauthors.map { it.name },
                text = proposal.text,
            )
        }
    }
}

@Serializable
private data class VoteStepDescriptionParameterDto(
    val name: String,
    val value: String,
)

@Serializable
private data class VoteStepDescriptionDto(
    val kind: String,
    val parameters: List<VoteStepDescriptionParameterDto>,
    val readable: String? = null,
) {
    companion object {
        fun tryFrom(description: VoteStepDescription): VoteStepDescriptionDto? {
            val kind = description.machineIfPresent?.kind
            val parameters = description.machineIfPresent?.parameters?.map { (name, value) ->
                VoteStepDescriptionParameterDto(
                    name = name,
                    value = value,
                )
            }

            return when (description) {
                is VoteStepDescription.None -> null

                is VoteStepDescription.MachineOnly -> {
                    VoteStepDescriptionDto(
                        kind = checkNotNull(kind),
                        parameters = checkNotNull(parameters),
                        readable = null,
                    )
                }

                is VoteStepDescription.WithReadable -> {
                    VoteStepDescriptionDto(
                        kind = checkNotNull(kind),
                        parameters = checkNotNull(parameters),
                        readable = description.readable,
                    )
                }
            }
        }
    }
}

@Serializable
private data class VoteDto(
    @SerialName("voter") val voterName: String,
    val vote: VoteKind,
    val comments: List<VoteStepDescriptionDto>,
)

@Serializable
private data class ResolutionDataDto(
    val result: ProposalResult,
    @SerialName("strength_for") val strengthFor: ULong,
    @SerialName("strength_against") val strengthAgainst: ULong,
    val votes: List<VoteDto>,
) {
    companion object {
        fun from(resolutionData: ResolutionData): ResolutionDataDto {
            return ResolutionDataDto(
                result = resolutionData.result,
                strengthFor = resolutionData.aiStrengths.strengthFor.raw.longValueExact().toULongExact(),
                strengthAgainst = resolutionData.aiStrengths.strengthAgainst.raw.longValueExact().toULongExact(),
                votes = resolutionData.votes.let { voteMap ->
                    voteMap.voters.map { voter ->
                        VoteDto(
                            voterName = voter.name,
                            vote = voteMap.voteFor(voter),
                            comments = voteMap.voteDescriptionsFor(voter).mapNotNull {
                                VoteStepDescriptionDto.tryFrom(it)
                            },
                        )
                    }
                },
            )
        }
    }
}

@Serializable
private data class VotingStrengthModificationDescriptionParameterDto(
    val name: String,
    val value: String,
)

@Serializable
private data class VotingStrengthModificationDescriptionDto(
    val readable: String,
    val kind: String,
    val parameters: List<VotingStrengthModificationDescriptionParameterDto>,
) {
    companion object {
        fun from(description: VotingStrengthModificationDescription): VotingStrengthModificationDescriptionDto {
            return VotingStrengthModificationDescriptionDto(
                readable = description.readable,
                kind = description.kind,
                parameters = description.parameters.map { (name, value) ->
                    VotingStrengthModificationDescriptionParameterDto(
                        name = name,
                        value = value,
                    )
                }
            )
        }
    }
}

@Serializable
private data class VotingStrengthTrailModificationEntryDto(
    val description: VotingStrengthModificationDescriptionDto,
    @SerialName("current_strength") val currentStrength: Long,
)

@Serializable
private data class VotingStrengthTrailForPersonsEntryDto(
    @SerialName("person") val personName: String,
    @SerialName("initial") val initialStrength: Long,
    @SerialName("initial_description") val initialDescription: VotingStrengthModificationDescriptionDto?,
    val modifications: List<VotingStrengthTrailModificationEntryDto>,
    @SerialName("final") val finalStrength: Long,
)

private fun Long.toULongExact(): ULong {
    require(this >= 0) { "Inexact conversion of $this to ULong requested" }
    return toULong()
}

@Serializable
private data class ProposalResolutionEntryDto(
    val proposal: ULong,
    val resolution: ResolutionDataDto,
    val strengths: List<VotingStrengthTrailForPersonsEntryDto>,
) {
    companion object {
        fun from(resolutionData: ResolutionData): ProposalResolutionEntryDto {
            return ProposalResolutionEntryDto(
                proposal = resolutionData.proposal.number.raw.longValueExact().toULongExact(),
                resolution = ResolutionDataDto.from(resolutionData),
                strengths = resolutionData.votingStrengths.overridesMap().map { (person, trail) ->
                    VotingStrengthTrailForPersonsEntryDto(
                        personName = person.name,
                        initialStrength = trail.initial.raw.longValueExact(),
                        initialDescription = trail.initialDescription?.let(VotingStrengthModificationDescriptionDto::from),
                        finalStrength = trail.final.raw.longValueExact(),
                        modifications = trail.modificationsWithValue().map { (modification, strength) ->
                            VotingStrengthTrailModificationEntryDto(
                                description = VotingStrengthModificationDescriptionDto.from(modification.description),
                                currentStrength = strength.raw.longValueExact(),
                            )
                        }
                    )
                },
            )
        }
    }
}

@Serializable
private data class AssessmentDto(
    val metadata: AssessmentMetadataDto,
    val proposals: List<ProposalDto>,
    val quorum: ULong,
    val resolutions: List<ProposalResolutionEntryDto>,
) {
    companion object {
        fun from(resolutionMap: ProposalResolutionMap): AssessmentDto {
            return AssessmentDto(
                metadata = AssessmentMetadataDto.from(resolutionMap.metadata),
                proposals = resolutionMap.proposals.map { ProposalDto.from(it) },
                quorum = resolutionMap.quorum.count().longValueExact().toULongExact(),
                resolutions = resolutionMap.proposals.map { proposal ->
                    ProposalResolutionEntryDto.from(resolutionMap.resolutionOf(proposal.number))
                },
            )
        }
    }
}

fun toJson(resolutionMap: ProposalResolutionMap): JsonObject {
    return Json.encodeToJsonElement(AssessmentDto.from(resolutionMap)).jsonObject
}
