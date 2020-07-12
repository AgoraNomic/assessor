package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.vote.InextricableVote
import org.agoranomic.assessor.lib.vote.Vote
import org.agoranomic.assessor.lib.vote.VoteFunc
import org.agoranomic.assessor.lib.vote.functionVote

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

// author parameter exists for overloading, so it is kept
@Suppress("UNUSED_PARAMETER")
fun endorse(author: _Author) = authorEndorsementVote()
