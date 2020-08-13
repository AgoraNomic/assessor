package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.vote.FunctionVote
import org.agoranomic.assessor.lib.vote.InextricableVote
import org.agoranomic.assessor.lib.vote.Vote
import org.agoranomic.assessor.lib.vote.VoteFunc

fun makeEndorsementFor(endorsee: Person, endorseeVote: Vote?): Vote {
    return when (endorseeVote) {
        null -> InextricableVote(comment = "Endorsement of non-voter ${endorsee.name}")
        else -> endorseeVote.copyWithComment("Endorsement of ${endorsee.name}")
    }
}

private fun endorsementFunc(endorsee: Person): VoteFunc = { prop, context ->
    makeEndorsementFor(endorsee, context.resolve(prop, endorsee))
}

private fun endorsementVote(endorsee: Person) = FunctionVote(endorsementFunc(endorsee))

private fun authorEndorsementFunc(): VoteFunc = { prop, context -> endorsementFunc(prop.author)(prop, context) }
private fun authorEndorsementVote() = FunctionVote(authorEndorsementFunc())

object AuthorMarker

val author = AuthorMarker

fun endorse(person: Person) = endorsementVote(person)

// author parameter exists for overloading, so it is kept
@Suppress("UNUSED_PARAMETER")
fun endorse(author: AuthorMarker) = authorEndorsementVote()
