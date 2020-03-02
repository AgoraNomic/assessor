import org.agoranomic.assessor.lib.*
import java.math.BigDecimal
import kotlin.test.*

class `getOrFail tests` {
    @Test
    fun `returns correct non-null value`() {
        val map = mapOf(1 to "hi", 2 to "bye")
        assertEquals(map.getOrFail(1), "hi")
    }

    @Test
    fun `returns correct null value`() {
        val map = mapOf(1 to "hi", 2 to null)
        assertEquals(map.getOrFail(2), null)
    }

    @Test
    fun `throws on missing value`() {
        val map = mapOf(1 to "hi", 2 to "bye")
        assertFails { map.getOrFail(3) }
    }
}

class `Exhaustive Enum tests` {
    private enum class TestEnum {
        First, Second
    }

    @Test
    fun `isExhaustive correctly returns false`() {
        assertFalse(listOf<TestEnum>().isExhaustive())
        assertFalse(listOf(TestEnum.First).isExhaustive())
        assertFalse(listOf(TestEnum.First, TestEnum.First).isExhaustive())
        assertFalse(listOf(TestEnum.Second).isExhaustive())
    }

    @Test
    fun `isExhaustive correctly returns true`() {
        assertTrue(listOf(TestEnum.First, TestEnum.Second).isExhaustive())
        assertTrue(listOf(TestEnum.Second, TestEnum.First).isExhaustive())
        assertTrue(listOf(TestEnum.Second, TestEnum.First, TestEnum.Second).isExhaustive())
    }

    @Test
    fun `requireExhaustive correctly succeeds`() {
        // Tests will fail if call throws
        listOf(TestEnum.First, TestEnum.Second).requireExhaustive()
        listOf(TestEnum.Second, TestEnum.First).requireExhaustive()
        listOf(TestEnum.Second, TestEnum.First, TestEnum.Second).requireExhaustive()
    }

    @Test
    fun `requireExhaustive correctly fails`() {
        assertFailsWith<IllegalArgumentException> { listOf<TestEnum>().requireExhaustive() }
        assertFailsWith<IllegalArgumentException> { listOf(TestEnum.First).requireExhaustive() }
        assertFailsWith<IllegalArgumentException> { listOf(TestEnum.First, TestEnum.First).requireExhaustive() }
        assertFailsWith<IllegalArgumentException> { listOf(TestEnum.Second).requireExhaustive() }
    }
}

class `allAreDistinct tests` {
    @Test
    fun `allAreDistinct returns true for set with all distinct`() {
        val list = listOf(1, 2, 3, 4)
        assertTrue(list.allAreDistinct())
    }

    @Test
    fun `allAreDistinct returns false for set with not all distinct`() {
        val list = listOf(1, 1, 2, 3)
        assertFalse(list.allAreDistinct())
    }

    @Test
    fun `allAreDistinctBy returns true for set with all selected keys distinct`() {
        val list = listOf("Alice", "Bob", "Charlie")
        assertTrue(list.allAreDistinctBy { it[0] })
    }

    @Test
    fun `allAreDistinctBy returns false for set with not all selected keys distinct`() {
        val list = listOf("Alice", "Adam", "Bob", "Charlie")
        assertFalse(list.allAreDistinctBy { it[0] })
    }
}

class `BigDecimal util tests` {
    @Test
    fun `multiplication works`() {
        val bd = BigDecimal.valueOf(5)!!
        val i = 2

        assertEquals(bd * i, BigDecimal.TEN)
        assertEquals(i * bd, BigDecimal.TEN)
    }

    @Test
    fun `comparison works`() {
        val i = 1
        val bd = BigDecimal.valueOf(5)!!

        assertTrue(i < bd)
        assertTrue(i <= bd)
        assertFalse(i > bd)
        assertFalse(i >= bd)

        assertFalse(bd < i)
        assertFalse(bd <= i)
        assertTrue(bd > i)
        assertTrue(bd >= i)
    }
}
