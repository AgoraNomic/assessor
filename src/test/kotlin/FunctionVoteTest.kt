import org.agoranomic.assessor.lib.VoteFunc
import org.agoranomic.assessor.lib.functionVote
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `HalfFunctionVote tests` {
    @Test
    fun `function returns HalfFunctionVote with same function`() {
        val nullVoteFunc: VoteFunc = { _, _ -> null }

        assertEquals(functionVote(nullVoteFunc).func, nullVoteFunc)
    }
}
