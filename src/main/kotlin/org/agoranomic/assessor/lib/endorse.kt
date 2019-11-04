package org.agoranomic.assessor.lib

private fun endorsementFunc(endorsee: Player): VoteFunc = { prop, resolve ->
    when (val endorseeVote = resolve(prop, endorsee)) {
        null -> InextricableVote(comment = "Endorsement of non-voter ${endorsee.name}")
        is SimpleVote, is InextricableVote -> endorseeVote.copyWithComment("Endorsement of ${endorsee.name}")
    }
}

private fun endorsementVote(endorsee: Player) = function(endorsementFunc(endorsee))

private fun authorEndorsementFunc(): VoteFunc = { prop, resolve -> endorsementFunc(prop.author)(prop, resolve) }
private fun authorEndorsementVote() = function(authorEndorsementFunc())

object _Author

val author = _Author

fun endorse(player: Player) = endorsementVote(player)
fun endorse(author: _Author) = authorEndorsementVote()
