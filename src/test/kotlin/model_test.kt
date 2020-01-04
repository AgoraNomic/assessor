import test_objects.firstTestProposal
import test_objects.secondTestProposal
import test_objects.thirdTestProposal
import org.agoranomic.assessor.lib.lookupIn
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

class `lookupIn tests` {
    @Test
    fun `returns proposal when in list`() {
        val first = firstTestProposal()
        val second = secondTestProposal()
        val list = listOf(first, second)

        assertEquals(first.number.lookupIn(list), first)
        assertEquals(second.number.lookupIn(list), second)
    }

    @Test
    fun `throws when proposal not in list`() {
        val first = firstTestProposal()
        val second = secondTestProposal()
        val list = listOf(first, second)

        val excluded = thirdTestProposal()

        assertFails { excluded.number.lookupIn(list) }
    }
}
