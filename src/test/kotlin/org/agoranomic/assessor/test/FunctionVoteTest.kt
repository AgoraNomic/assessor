package org.agoranomic.assessor.test

import org.agoranomic.assessor.lib.vote.VoteFunc
import org.agoranomic.assessor.lib.vote.functionVote
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("HalfFunctionVote test")
class HalfFunctionVoteTest {
    @Test
    fun `function returns HalfFunctionVote with same function`() {
        val nullVoteFunc: VoteFunc = { _, _ -> null }

        assertEquals(functionVote(nullVoteFunc).func, nullVoteFunc)
    }
}
