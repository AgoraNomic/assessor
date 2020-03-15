package test_objects

import org.agoranomic.assessor.lib.util.plus
import org.agoranomic.assessor.lib.util.rem
import java.math.BigInteger

typealias TestNumber = BigInteger

fun testNumber(raw: Int): TestNumber = BigInteger.valueOf(raw.toLong())

private val INTERNAL_REQ_BASE: BigInteger = BigInteger.valueOf(1000000)
private val INTERNAL_REQ_FACTOR = BigInteger.valueOf(100)

val TEST_ZERO = testNumber(0)
val TEST_ONE = testNumber(1)
val TEST_TWO = testNumber(2)

inline fun <R> testFirst(create: (TestNumber) -> R) = create(TEST_ZERO)
inline fun <R> testSecond(create: (TestNumber) -> R) = create(TEST_ONE)
inline fun <R> testThird(create: (TestNumber) -> R) = create(TEST_TWO)

fun subReqNum(num: TestNumber): TestNumber = INTERNAL_REQ_BASE + INTERNAL_REQ_FACTOR * (num + 1)

fun testString(num: TestNumber, type: String) = "Test $type #$num"

fun firstTestString(type: String) = testString(TEST_ZERO, type)

fun <T> testList(num: TestNumber, map: (TestNumber) -> T): List<T> = List(4) { index -> map(num + index) }

fun <T> testSet(num: TestNumber, map: (TestNumber) -> T): Set<T> {
    val list = testList(num, map)
    val set = list.toSet()

    check(list.size == set.size)

    return set
}

fun <K, V> testMap(num: TestNumber, generator: (TestNumber) -> Pair<K, V>) = testList(num, generator).toMap()

inline fun <reified E : Enum<E>> testValueOf(num: TestNumber): E {
    val values = enumValues<E>()
    val count = values.size

    return values[(((num % count) + count) % count).toInt()]
}
