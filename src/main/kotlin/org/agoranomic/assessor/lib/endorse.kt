package org.agoranomic.assessor.lib

fun makeEndorsementFor(endorsee: Player, endorseeVote: Vote?): Vote {
    return when (endorseeVote) {
        null -> InextricableVote(comment = "Endorsement of non-voter ${endorsee.name}")
        else -> endorseeVote.copyWithComment("Endorsement of ${endorsee.name}")
    }
}

private fun endorsementFunc(endorsee: Player): VoteFunc = { prop, resolve ->
    makeEndorsementFor(endorsee, resolve(prop, endorsee))
}

private fun endorsementVote(endorsee: Player) = function(endorsementFunc(endorsee))

private fun authorEndorsementFunc(): VoteFunc = { prop, resolve -> endorsementFunc(prop.author)(prop, resolve) }
private fun authorEndorsementVote() = function(authorEndorsementFunc())

object _Author

val author = _Author

fun endorse(player: Player) = endorsementVote(player)
fun endorse(author: _Author) = authorEndorsementVote()
