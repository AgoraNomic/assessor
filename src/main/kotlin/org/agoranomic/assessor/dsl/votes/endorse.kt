package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.lib.*

fun makeEndorsementFor(endorsee: Person, endorseeVote: Vote?): Vote {
    return when (endorseeVote) {
        null -> InextricableVote(comment = "Endorsement of non-voter ${endorsee.name}")
        else -> endorseeVote.copyWithComment("Endorsement of ${endorsee.name}")
    }
}

private fun endorsementFunc(endorsee: Person): VoteFunc = { prop, context ->
    makeEndorsementFor(endorsee, context.resolve(prop, endorsee))
}

private fun endorsementVote(endorsee: Person) = functionVote(endorsementFunc(endorsee))

private fun authorEndorsementFunc(): VoteFunc = { prop, context -> endorsementFunc(prop.author)(prop, context) }
private fun authorEndorsementVote() = functionVote(authorEndorsementFunc())

object _Author

val author = _Author

fun endorse(person: Person) = endorsementVote(person)
fun endorse(author: _Author) = authorEndorsementVote()
