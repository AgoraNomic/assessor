package org.agoranomic.assessor.dsl.votes

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.vote.FunctionVote

fun match(other: Person): FunctionVote {
    return FunctionVote { proposal, context ->
        context.resolve(proposal, other)
    }
}
