import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalDataMismatchException
import org.agoranomic.assessor.lib.ProposalNumber
import org.agoranomic.assessor.lib.proposal_set.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import test_objects.*
import kotlin.test.*

private typealias CreateProposalSetFunc = (proposals: Array<out Proposal>) -> ProposalSet

class `ProposalSet tests` {
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

        val firstDuplicateProposal = firstTestProposal().copy(number = duplicateNumber)
        val secondDuplicateProposal = secondTestProposal().copy(number = duplicateNumber)
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

        fun assertEqualAndHashCode(first: ProposalSet, second: ProposalSet) {
            assertTrue(first == second)
            assertTrue(first.hashCode() == second.hashCode())
        }

        for (firstCreateProposalSet in createProposalSetFuncs) {
            for (secondCreateProposalSet in createProposalSetFuncs) {
                // Different order is intentional
                assertEqualAndHashCode(
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
    fun `getOpt returns null when no proposal`(createProposalSet: CreateProposalSetFunc) {
        val containedProp = firstTestProposal()
        val proposalSet = createProposalSet(containedProp)

        val otherProp = secondTestProposal()
        assertNull(proposalSet.getOpt(otherProp.number))
    }

    @ParameterizedTest
    @MethodSource("createProposalSetFuncs")
    fun `getOpt returns proposal when contained`(createProposalSet: CreateProposalSetFunc) {
        val containedProp = firstTestProposal()
        val proposalSet = createProposalSet(containedProp)

        assertEquals(containedProp, proposalSet.getOpt(containedProp.number))
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
            setOf<ProposalNumber>(),
            createProposalSet().numbers()
        )

        assertEquals(
            setOf(firstProposal.number),
            createProposalSet(firstProposal).numbers()
        )

        assertEquals(
            setOf(firstProposal.number, secondProposal.number),
            createProposalSet(firstProposal, secondProposal).numbers()
        )

        assertEquals(
            setOf(firstProposal.number, secondProposal.number, thirdProposal.number),
            createProposalSet(firstProposal, secondProposal, thirdProposal).numbers()
        )
    }
}
