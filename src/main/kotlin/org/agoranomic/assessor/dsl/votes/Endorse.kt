package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.vote.*

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

fun endorse(person: Person) = endorsementVote(person)

object AuthorMarker

// author parameter exists for overloading, so it is kept
@Suppress("UNUSED_PARAMETER")
fun endorse(author: AuthorMarker) = authorEndorsementVote()

fun endorseOrElse(endorsee: Person, default: FunctionVote) = FunctionVote { prop, context ->
    checkNotNull(endorsementFunc(endorsee)(prop, context))
        .takeUnless { it is InextricableVote }
        ?: default.func(prop, context)
}

fun endorseOrElse(endorsee: Person, default: VoteKind): FunctionVote = endorseOrElse(endorsee, FunctionVote { _, _ ->
    SimpleVote(default, comment = "${endorsee.name} would have been endorsed, but eir vote was inextricable")
})
