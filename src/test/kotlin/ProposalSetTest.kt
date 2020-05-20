import org.agoranomic.assessor.lib.*
import org.agoranomic.assessor.lib.proposal_set.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import test_objects.firstTestProposal
import test_objects.secondTestProposal
import test_objects.thirdTestProposal
import test_util.assertEqualsAndHashCode
import test_util.assertSucceeds
import test_util.copyWithNumber
import kotlin.test.*

private typealias CreateProposalSetFunc = (proposals: Array<out Proposal>) -> ProposalSet
private typealias CreateMutableProposalSetFunc = (proposals: Array<out Proposal>) -> MutableProposalSet

@DisplayName("ProposalSet test")
class ProposalSetTest {
    private operator fun CreateProposalSetFunc.invoke(vararg proposals: Proposal) = this(proposals)

    companion object {
        @JvmStatic
        private fun createProposalSetFuncs(): List<CreateProposalSetFunc> {
            return listOf(::proposalSetOf, ::mutableProposalSetOf)
        }
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `proposalSetOf throws on duplicate numbers`(createProposalSet: CreateProposalSetFunc) {
        val duplicateNumber = ProposalNumber(12) // Arbitrarily picked

        val firstDuplicateProposal = firstTestProposal().copyWithNumber(duplicateNumber)
        val secondDuplicateProposal = secondTestProposal().copyWithNumber(duplicateNumber)
        val nonduplicateProposal = thirdTestProposal()

        assertFailsWith<ProposalDataMismatchException> {
            createProposalSet(firstDuplicateProposal, secondDuplicateProposal, nonduplicateProposal)
        }
    }

    @Test
    fun `two proposalSetOf calls are equal`() {
        val createProposalSetFuncs = createProposalSetFuncs()

        val firstProp = firstTestProposal()
        val secondProp = secondTestProposal()
        val thirdProp = thirdTestProposal()

        for (firstCreateProposalSet in createProposalSetFuncs) {
            for (secondCreateProposalSet in createProposalSetFuncs) {
                // Different order is intentional
                assertEqualsAndHashCode(
                    firstCreateProposalSet(firstProp, secondProp, thirdProp),
                    secondCreateProposalSet(thirdProp, secondProp, firstProp)
                )
            }
        }
    }

    @Test
    fun `two different proposalSetOf calls are not equal`() {
        val createProposalSetFuncs = createProposalSetFuncs()

        val firstProp = firstTestProposal()
        val secondProp = secondTestProposal()
        val thirdProp = thirdTestProposal()

        for (firstCreateProposalSet in createProposalSetFuncs) {
            for (secondCreateProposalSet in createProposalSetFuncs) {
                assertFalse(
                    firstCreateProposalSet(firstProp, secondProp) == secondCreateProposalSet(secondProp, thirdProp)
                )
            }
        }
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `isEmpty and isNotEmpty work`(createProposalSet: CreateProposalSetFunc) {
        val empty = createProposalSet()

        assertTrue(empty.isEmpty())
        assertFalse(empty.isNotEmpty())

        assertEqualsAndHashCode(emptyProposalSet(), empty)

        val nonempty = createProposalSet(firstTestProposal())

        assertFalse(nonempty.isEmpty())
        assertTrue(nonempty.isNotEmpty())
    }

    @Test
    fun `emptyProposalSet functions work`() {
        for (empty in listOf(emptyProposalSet(), emptyMutableProposalSet())) {
            assertTrue(empty.isEmpty())
            assertFalse(empty.isNotEmpty())
        }
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `comparisons for empty proposals sets and THE emptyProposalSet`(createProposalSet: CreateProposalSetFunc) {
        assertEqualsAndHashCode(emptyProposalSet(), createProposalSet())
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `getOpt returns null when no proposal`(createProposalSet: CreateProposalSetFunc) {
        val containedProp = firstTestProposal()
        val proposalSet = createProposalSet(containedProp)

        val otherProp = secondTestProposal()
        assertNull(proposalSet.getOrNull(otherProp.number))
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `getOpt returns proposal when contained`(createProposalSet: CreateProposalSetFunc) {
        val containedProp = firstTestProposal()
        val proposalSet = createProposalSet(containedProp)

        assertEquals(containedProp, proposalSet.getOrNull(containedProp.number))
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `get fails when no proposal`(createProposalSet: CreateProposalSetFunc) {
        val containedProp = firstTestProposal()
        val proposalSet = createProposalSet(containedProp)

        val otherProposal = secondTestProposal()

        assertFailsWith<NoSuchProposalException> {
            proposalSet[otherProposal.number]
        }
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `get returns proposal when contained`(createProposalSet: CreateProposalSetFunc) {
        val containedProp = firstTestProposal()
        val proposalSet = createProposalSet(containedProp)

        assertEquals(containedProp, proposalSet[containedProp.number])
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `contains(ProposalNumber) returns false when no proposal`(createProposalSet: CreateProposalSetFunc) {
        val containedProp = firstTestProposal()
        val proposalSet = createProposalSet(containedProp)

        val otherProposal = secondTestProposal()

        assertFalse(proposalSet.contains(otherProposal.number))
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `contains(ProposalNumber) returns true when contained`(createProposalSet: CreateProposalSetFunc) {
        val containedProp = firstTestProposal()
        val proposalSet = createProposalSet(containedProp)

        assertTrue(proposalSet.contains(containedProp.number))
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `size works`(createProposalSet: CreateProposalSetFunc) {
        val firstProposal = firstTestProposal()
        val secondProposal = secondTestProposal()
        val thirdProposal = thirdTestProposal()

        assertEquals(0, createProposalSet().size)
        assertEquals(1, createProposalSet(firstProposal).size)
        assertEquals(2, createProposalSet(firstProposal, secondProposal).size)
        assertEquals(3, createProposalSet(firstProposal, secondProposal, thirdProposal).size)
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `numbers works`(createProposalSet: CreateProposalSetFunc) {
        val firstProposal = firstTestProposal()
        val secondProposal = secondTestProposal()
        val thirdProposal = thirdTestProposal()

        assertEquals(
            emptyProposalNumbers(),
            createProposalSet().numbers()
        )

        assertEquals(
            proposalNumbersOf(firstProposal.number),
            createProposalSet(firstProposal).numbers()
        )

        assertEquals(
            proposalNumbersOf(firstProposal.number, secondProposal.number),
            createProposalSet(firstProposal, secondProposal).numbers()
        )

        assertEquals(
            proposalNumbersOf(firstProposal.number, secondProposal.number, thirdProposal.number),
            createProposalSet(firstProposal, secondProposal, thirdProposal).numbers()
        )
    }
}

@DisplayName("MutableProposalSet test")
class MutableProposalSetTest {
    private operator fun CreateMutableProposalSetFunc.invoke(vararg proposals: Proposal) = this(proposals)

    companion object {
        @JvmStatic
        private fun createProposalSetFuncs(): List<CreateMutableProposalSetFunc> {
            return listOf(::mutableProposalSetOf)
        }
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `add works`(createProposalSet: CreateMutableProposalSetFunc) {
        val firstProposal = firstTestProposal()
        val secondProposal = secondTestProposal()

        val mutableProposalSet = createProposalSet()

        mutableProposalSet.add(firstProposal)
        assertEqualsAndHashCode(createProposalSet(firstProposal), mutableProposalSet)

        mutableProposalSet.add(secondProposal)
        assertEqualsAndHashCode(createProposalSet(secondProposal, firstProposal), mutableProposalSet)

        assertEquals(setOf(firstProposal, secondProposal), mutableProposalSet.toSet())
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `add is idempotent`(createProposalSet: CreateMutableProposalSetFunc) {
        val firstProposal = firstTestProposal()
        val secondProposal = secondTestProposal()

        val mutableProposalSet = createProposalSet(firstProposal)
        mutableProposalSet.add(secondProposal)
        mutableProposalSet.add(secondProposal)

        assertEquals(setOf(firstProposal, secondProposal), mutableProposalSet.toSet())

        // Duplicate should have no effect
        assertEqualsAndHashCode(createProposalSet(firstProposal, secondProposal), mutableProposalSet)
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `add of mismatched proposal throws`(createProposalSet: CreateMutableProposalSetFunc) {
        val commonNumber = ProposalNumber(12)

        val original = firstTestProposal().copyWithNumber(commonNumber)
        val next = secondTestProposal().copyWithNumber(commonNumber)

        val mutableProposalSet = createProposalSet(original)

        val thrown = assertFailsWith<ProposalDataMismatchException> {
            mutableProposalSet.add(next)
        }

        assertEquals(original, thrown.original)
        assertEquals(next, thrown.next)
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `remove(ProposalNumber) works`(createProposalSet: CreateMutableProposalSetFunc) {
        val firstProposal = firstTestProposal()
        val secondProposal = secondTestProposal()

        val mutableProposalSet = createProposalSet(firstProposal, secondProposal)

        mutableProposalSet.remove(firstProposal.number)
        assertEqualsAndHashCode(createProposalSet(secondProposal), mutableProposalSet)

        mutableProposalSet.remove(secondProposal.number)
        assertEqualsAndHashCode(createProposalSet(), mutableProposalSet)

        assertTrue(mutableProposalSet.isEmpty())
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `remove(Proposal) works`(createProposalSet: CreateMutableProposalSetFunc) {
        val firstProposal = firstTestProposal()
        val secondProposal = secondTestProposal()

        val mutableProposalSet = createProposalSet(firstProposal, secondProposal)

        mutableProposalSet.remove(firstProposal)
        assertEqualsAndHashCode(createProposalSet(secondProposal), mutableProposalSet)

        mutableProposalSet.remove(secondProposal)
        assertEqualsAndHashCode(createProposalSet(), mutableProposalSet)

        assertTrue(mutableProposalSet.isEmpty())
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `remove of un-contained ProposalNumber works`(createProposalSet: CreateMutableProposalSetFunc) {
        val mutableProposalSet = createProposalSet()

        assertSucceeds {
            mutableProposalSet.remove(firstTestProposal().number)
            mutableProposalSet.remove(secondTestProposal().number)
        }

        assertEquals(createProposalSet(), mutableProposalSet)
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `remove of un-contained Proposal works`(createProposalSet: CreateMutableProposalSetFunc) {
        val mutableProposalSet = createProposalSet()

        assertSucceeds {
            mutableProposalSet.remove(firstTestProposal())
            mutableProposalSet.remove(secondTestProposal())
        }

        assertEquals(createProposalSet(), mutableProposalSet)
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `remove of mismatched Proposal throws`(createProposalSet: CreateMutableProposalSetFunc) {
        val commonNumber = ProposalNumber(12)

        val original = firstTestProposal().copyWithNumber(commonNumber)
        val next = secondTestProposal().copyWithNumber(commonNumber)

        val mutableProposalSet = createProposalSet(original)

        val thrown = assertFailsWith<ProposalDataMismatchException> {
            mutableProposalSet.remove(next)
        }

        assertEquals(original, thrown.original)
        assertEquals(next, thrown.next)
    }
}
