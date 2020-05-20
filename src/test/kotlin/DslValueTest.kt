import org.agoranomic.assessor.dsl.DslValue
import org.agoranomic.assessor.dsl.DslValueMap
import org.agoranomic.assessor.dsl.getOrDefault
import org.agoranomic.assessor.dsl.getOrNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import test_util.assertSucceeds
import kotlin.test.*

@DisplayName("DslValue test")
class DslValueTest {
    @Nested
    @DisplayName("before set")
    inner class BeforeSet {
        @Test
        fun `get fails`() {
            val dslValue = DslValue<String>()
            assertFailsWith<IllegalStateException> { dslValue.get() }
        }

        @Test
        fun `set does not fail`() {
            val dslValue = DslValue<String>()

            assertSucceeds {
                dslValue.set("I'm a string")
            }
        }

        @Test
        fun `getOrDefault returns default`() {
            val dslValue = DslValue<String>()
            val default = "I'm a string"

            assertSame(default, dslValue.getOrDefault(default))
        }

        @Test
        fun `getOrNull returns null`() {
            val dslValue = DslValue<String>()
            assertNull(dslValue.getOrNull())
        }

        @Test
        fun `hasValue returns false`() {
            val dslValue = DslValue<String>()
            assertFalse(dslValue.hasValue())
        }
    }

    @Nested
    @DisplayName("after set")
    inner class AfterSet {
        @Test
        fun `get returns value`() {
            val dslValue = DslValue<String>()
            val value = "I'm a string"

            dslValue.set(value)

            assertSame(value, dslValue.get())
        }

        @Test
        fun `set fails`() {
            val dslValue = DslValue<String>()
            val value = "I'm a string"

            dslValue.set(value)

            assertFailsWith<IllegalStateException> { dslValue.set(value) }
        }

        @Test
        fun `getOrDefault returns value`() {
            val dslValue = DslValue<String>()
            val value = "First string"

            dslValue.set(value)

            assertSame(value, dslValue.getOrDefault("I'm a default"))
        }

        @Test
        fun `getOrNull returns value`() {
            val dslValue = DslValue<String>()
            val value = "First string"

            dslValue.set(value)

            assertSame(value, dslValue.getOrNull())
        }

        @Test
        fun `hasValue returns false`() {
            val dslValue = DslValue<String>()
            val value = "I'm a string"

            dslValue.set(value)

            assertTrue(dslValue.hasValue())
        }
    }
}

@DisplayName("DslValueMap test")
class DslValueMapTest {
    private data class KeyType(val value: String)
    private data class ValueType(val value: String)

    private val testKey = KeyType("Key")
    private val testValue = ValueType("Value")

    private val defaultValue = ValueType("Default value")

    private fun emptyTestMap(): DslValueMap<KeyType, ValueType> {
        return DslValueMap()
    }

    private fun filledTestMap(): DslValueMap<KeyType, ValueType> {
        return emptyTestMap().also { it[testKey] = testValue }
    }

    @Nested
    @DisplayName("before set")
    inner class BeforeSet {
        @Test
        fun `set works`() {
            val map = emptyTestMap()

            assertSucceeds {
                map[testKey] = testValue
            }
        }

        @Test
        fun `get fails`() {
            val map = emptyTestMap()

            assertFailsWith<IllegalStateException> { map[testKey] }
        }

        @Test
        fun `getOrDefault returns default`() {
            val map = emptyTestMap()

            assertEquals(defaultValue, map.getOrDefault(testKey, defaultValue))
        }

        @Test
        fun `containsKey returns false`() {
            val map = emptyTestMap()

            assertFalse(map.containsKey(testKey))
        }

        @Test
        fun `getOrNull returns null`() {
            val map = emptyTestMap()

            assertNull(map.getOrNull(testKey))
        }
    }

    @Nested
    @DisplayName("after set")
    inner class AfterSet {
        @Test
        fun `set fails`() {
            val map = filledTestMap()

            assertFailsWith<IllegalStateException> { map[testKey] = testValue }
        }

        @Test
        fun `get returns expected value`() {
            val map = filledTestMap()

            assertEquals(testValue, map[testKey])
        }

        @Test
        fun `containsKey returns true`() {
            val map = filledTestMap()

            assertTrue(map.containsKey(testKey))
        }

        @Test
        fun `getOrDefault returns expected value`() {
            val map = filledTestMap()

            assertEquals(testValue, map.getOrDefault(testKey, defaultValue))
        }

        @Test
        fun `getOrNull returns expected value`() {
            val map = filledTestMap()

            assertEquals(testValue, map.getOrNull(testKey))
        }
    }

    @Test
    fun `compile with empty returns empty`() {
        assertEquals(mapOf<KeyType, ValueType>(), emptyTestMap().compile())
    }

    @Test
    fun `compile with values works`() {
        val firstKey = KeyType("First key")
        val firstValue = ValueType("First value")

        val secondKey = KeyType("Second key")
        val secondValue = ValueType("Second value")

        val map = emptyTestMap()
        map[firstKey] = firstValue
        map[secondKey] = secondValue

        assertEquals(
            mapOf(
                firstKey to firstValue,
                secondKey to secondValue
            ),
            map.compile()
        )
    }
}
