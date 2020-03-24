import org.agoranomic.assessor.lib.util.*
import test_util.assertSucceeds
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.test.*

class `getOrFail tests` {
    @Test
    fun `returns correct value`() {
        val map = mapOf(1 to "hi", 2 to "bye")
        assertEquals("hi", map.getOrFail(1))
    }

    @Test
    fun `throws on missing value`() {
        val map = mapOf(1 to "hi", 2 to "bye")
        assertFailsWith<IllegalStateException> { map.getOrFail(3) }
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
        assertSucceeds {
            listOf(TestEnum.First, TestEnum.Second).requireExhaustive()
        }

        assertSucceeds {
            listOf(TestEnum.Second, TestEnum.First).requireExhaustive()
        }

        assertSucceeds {
            listOf(TestEnum.Second, TestEnum.First, TestEnum.Second).requireExhaustive()
        }
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

    @Test
    fun `requireAllAreDistinct does not throw for list with all distinct`() {
        val list = listOf(1, 2, 3)

        assertSucceeds {
            list.requireAllAreDistinct()
        }
    }

    @Test
    fun `requireAllAreDistinct throws for list with not all distinct`() {
        val list = listOf(1, 1, 2, 3)
        assertFailsWith<IllegalArgumentException> { list.requireAllAreDistinct() }
    }

    @Test
    fun `toSetCheckingDistinct returns set for list with all distinct`() {
        val list = listOf(1, 2, 3)
        assertEquals(setOf(1, 2, 3), list.toSetCheckingDistinct())
    }

    @Test
    fun `toSetCheckingDistinct throws for list with not all distinct`() {
        val list = listOf(1, 1, 2, 3)
        assertFailsWith<IllegalArgumentException> { list.toSetCheckingDistinct() }
    }

    @Test
    fun `requireAllAreDistinctBy does not throw for list with all selected keys distinct`() {
        val list = listOf("Alice", "Bob", "Charlie")

        assertSucceeds {
            list.requireAllAreDistinctBy { it[0] }
        }
    }

    @Test
    fun `requireAllAreDistinctBy does throws for list with not all selected keys distinct`() {
        val list = listOf("Alice", "Adam", "Bob", "Charlie")
        assertFailsWith<IllegalArgumentException> { list.requireAllAreDistinctBy { it[0] } }
    }
}

class `repeatingElements tests` {
    @Test
    fun `returns empty set for list without repeating elements`() {
        assertEquals(emptySet(), listOf(1, 2, 3).repeatingElements())
    }

    @Test
    fun `returns repeating elements`() {
        assertEquals(setOf(1), listOf(1, 1, 2, 3).repeatingElements())
        assertEquals(setOf(1, 2), listOf(1, 1, 2, 2, 3).repeatingElements())
        assertEquals(setOf(1, 3), listOf(1, 1, 2, 3, 3).repeatingElements())
    }
}

class `BigDecimal util tests` {
    @Test
    fun `addition works`() {
        val bd = BigDecimal.valueOf(5)!!
        val i = 2

        assertEquals(BigDecimal.valueOf(7), bd + i)
        assertEquals(BigDecimal.valueOf(7), i + bd)
    }

    @Test
    fun `subtraction works`() {
        val bd = BigDecimal.valueOf(5)!!
        val i = 2

        assertEquals(BigDecimal.valueOf(3), bd - i)
        assertEquals(BigDecimal.valueOf(-3), i - bd)
    }

    @Test
    fun `multiplication works`() {
        val bd = BigDecimal.valueOf(5)!!
        val i = 2

        assertEquals(BigDecimal.TEN, bd * i)
        assertEquals(BigDecimal.TEN, i * bd)
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

class `asNullable tests` {
    @Test
    fun `returns same object`() {
        val str = "Hi!"
        assertSame(str, str.asNullable())
    }

    @Test
    fun `returns same null object`() {
        val obj = null as String?
        assertSame(obj, obj.asNullable())
    }
}

class `ceil tests` {
    @Test
    fun `ceil(BigDecimal) works`() {
        class CeilTestCase(val input: String, val result: String)

        val testCases = listOf(
            CeilTestCase(input = "0", result = "0"),
            CeilTestCase(input = "0.5", result = "1"),
            CeilTestCase(input = "1.2", result = "2"),
            CeilTestCase(input = "1.7", result = "2"),
            CeilTestCase(input = "2.00000", result = "2"),
            CeilTestCase(input = "-2", result = "-2"),
            CeilTestCase(input = "-2.1", result = "-2"),
            CeilTestCase(input = "-2.5", result = "-2"),
            CeilTestCase(input = "-2.9", result = "-2"),
            CeilTestCase(input = "-3", result = "-3"),
            CeilTestCase(input = "-3.1", result = "-3")
        )

        for (testCase in testCases) {
            assertEquals(BigInteger(testCase.result), ceil(BigDecimal(testCase.input)))
        }
    }
}

class `all are equal tests` {
    @Test
    fun `allAreEqual returns true for empty collection`() {
        assertTrue(emptyList<String>().allAreEqual())
    }

    @Test
    fun `allAreEqual returns true when all elements are equal`() {
        assertTrue(listOf(1).allAreEqual())
        assertTrue(listOf(2, 2, 2, 2).allAreEqual())
    }

    @Test
    fun `allAreEqual returns false when not all elements are equal`() {
        assertFalse(listOf(1, 1, 3).allAreEqual())
        assertFalse(listOf(1, 2, 3).allAreEqual())
    }

    @Test
    fun `requireAllAreEqual does not throw for empty collection`() {
        assertSucceeds {
            emptyList<String>().requireAllAreEqual()
        }
    }

    @Test
    fun `requireAllAreEqual does not throw when all elements are equal`() {
        assertSucceeds {
            listOf(1).requireAllAreEqual()
            listOf(2, 2, 2).requireAllAreEqual()
        }
    }

    @Test
    fun `requireAllAreEqual throws when all elements are not equal`() {
        assertFailsWith<IllegalArgumentException> {
            listOf(1, 1, 3).requireAllAreEqual()
        }

        assertFailsWith<IllegalArgumentException> {
            listOf(1, 2, 3).requireAllAreEqual()
        }
    }
}
