import test_objects.firstTestProposal
import test_objects.secondTestProposal
import test_objects.thirdTestProposal
import org.agoranomic.assessor.lib.lookupOrFail
import kotlin.test.*

class `lookupOrFail tests` {
    @Test
    fun `returns proposal when one exists`() {
        val first = firstTestProposal()
        val second = secondTestProposal()

        assertEquals(listOf(first, second).lookupOrFail(first.number), first)
        assertEquals(listOf(first, second).lookupOrFail(second.number), second)
    }

    @Test
    fun `throws when proposal doesn't exist`() {
        val first = firstTestProposal()
        val second = secondTestProposal()
        val excluded = thirdTestProposal()

        assertFails { listOf(first, second).lookupOrFail(excluded.number) }
    }
}
