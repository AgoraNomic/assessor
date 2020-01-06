package org.agoranomic.assessor.lib

fun makeEndorsementFor(endorsee: Player, endorseeVote: Vote?): Vote {
    return when (endorseeVote) {
        null -> InextricableVote(comment = "Endorsement of non-voter ${endorsee.name}")
        else -> endorseeVote.copyWithComment("Endorsement of ${endorsee.name}")
    }
}

private fun endorsementFunc(endorsee: Player): VoteFunc = { prop, context ->
    makeEndorsementFor(endorsee, context.resolve(prop, endorsee))
}

private fun endorsementVote(endorsee: Player) = functionVote(endorsementFunc(endorsee))

private fun authorEndorsementFunc(): VoteFunc = { prop, context -> endorsementFunc(prop.author)(prop, context) }
private fun authorEndorsementVote() = functionVote(authorEndorsementFunc())

object _Author

val author = _Author

fun endorse(player: Player) = endorsementVote(player)
fun endorse(author: _Author) = authorEndorsementVote()
