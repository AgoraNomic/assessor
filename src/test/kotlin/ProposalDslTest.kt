import org.agoranomic.assessor.dsl.DslInit
import org.agoranomic.assessor.dsl.receivers.*
import org.agoranomic.assessor.lib.*
import io.github.random_internet_cat.util.toSetCheckingDistinct
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestFactory
import test_objects.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

abstract class ProposalDslTestBase<ProposalReceiver : ProposalCommonReceiver> {
    protected fun ProposalReceiver.onlyCommonSetup(
        specifyTitle: Boolean = true,
        specifyText: Boolean = true,
        specifyAuthor: Boolean = true,
        specifyCoauthors: Boolean = true,
        specifyAI: Boolean = true
    ) {
        if (specifyTitle) title(firstTestProposalTitle())
        if (specifyText) text(firstTestProposalText())
        if (specifyAuthor) author(firstTestProposalAuthor())
        if (specifyCoauthors) coauthors(firstTestProposalCoauthors())
        if (specifyAI) ai(firstTestProposalAI())
    }

    protected abstract fun ProposalReceiver.extendSetupForCommonTests()

    private fun ProposalReceiver.setupForCommonTests(
        specifyTitle: Boolean = true,
        specifyText: Boolean = true,
        specifyAuthor: Boolean = true,
        specifyCoauthors: Boolean = true,
        specifyAI: Boolean = true
    ) {
        onlyCommonSetup(
            specifyTitle = specifyTitle,
            specifyText = specifyText,
            specifyAuthor = specifyAuthor,
            specifyCoauthors = specifyCoauthors,
            specifyAI = specifyAI
        )

        extendSetupForCommonTests()
    }

    protected abstract fun compile(
        number: ProposalNumber = firstTestProposalNumber(),
        init: DslInit<ProposalReceiver>
    ): Proposal

    @Nested
    @DisplayName("title test")
    inner class TitleTest {
        private fun ProposalReceiver.setupForTitle() = setupForCommonTests(specifyTitle = false)

        @Test
        fun `fails when title not specified`() {
            assertFails {
                compile {
                    setupForTitle()
                    // Don't set title
                }
            }
        }

        @Test
        fun `fails when title specified twice`() {
            val titleToSet = firstTestProposalTitle()

            assertFails {
                compile {
                    setupForTitle()
                    title(titleToSet)
                    title(titleToSet)
                }
            }
        }

        @Test
        fun `returns correct title`() {
            val expectedTitle = firstTestProposalTitle()

            val proposal = compile {
                setupForTitle()
                title(expectedTitle)
            }

            assertEquals(expectedTitle, proposal.title)
        }
    }

    @Nested
    @DisplayName("text test")
    inner class TextTest {
        private fun ProposalReceiver.setupForText() = setupForCommonTests(specifyText = false)

        @Test
        fun `fails when text not specified`() {
            assertFails {
                compile {
                    setupForText()
                    // Don't set text
                }
            }
        }

        @Test
        fun `fails when text specified twice`() {
            val textToSet = firstTestProposalText()

            assertFails {
                compile {
                    setupForText()
                    text(textToSet)
                    text(textToSet)
                }
            }
        }

        @Test
        fun `returns correct text`() {
            val expectedText = firstTestProposalText()

            val proposal = compile {
                setupForText()
                text(expectedText)
            }

            assertEquals(expectedText, proposal.text)
        }
    }

    @Nested
    @DisplayName("author test")
    inner class AuthorTest {
        private fun ProposalReceiver.setupForAuthor() = setupForCommonTests(specifyAuthor = false)

        @Test
        fun `fails when author not specified`() {
            assertFails {
                compile {
                    setupForAuthor()
                    // Don't set author
                }
            }
        }

        @Test
        fun `fails when author specified twice`() {
            val authorToSet = firstTestProposalAuthor()

            assertFails {
                compile {
                    setupForAuthor()
                    author(authorToSet)
                    author(authorToSet)
                }
            }
        }

        @Test
        fun `returns expected author`() {
            val expectedAuthor = firstTestProposalAuthor()

            val proposal = compile {
                setupForAuthor()
                author(expectedAuthor)
            }

            assertEquals(expectedAuthor, proposal.author)
        }
    }

    @Nested
    @DisplayName("coauthors test")
    inner class CoauthorsTest {
        private fun ProposalReceiver.setupForCoauthors() = setupForCommonTests(specifyCoauthors = false)

        @Test
        fun `has empty coauthors when none specified`() {
            val proposal = compile {
                setupForCoauthors()
            }

            assertEquals(emptyPersons(), proposal.coauthors)
        }

        @Test
        fun `fails when coauthors specified twice`() {
            val coauthorsToSet = firstTestProposalCoauthors()

            assertFails {
                compile {
                    setupForCoauthors()
                    coauthors(coauthorsToSet)
                    coauthors(coauthorsToSet)
                }
            }
        }

        @Test
        fun `returns expected coauthors when using Persons argument`() {
            val coauthorsToSet = firstTestProposalCoauthors()

            val proposal = compile {
                setupForCoauthors()
                coauthors(coauthorsToSet)
            }

            assertEquals(coauthorsToSet, proposal.coauthors)
        }

        @Test
        fun `returns expected coauthors when using varargs`() {
            val coauthorsToSet = firstTestProposalCoauthors().toTypedArray()

            val proposal = compile {
                setupForCoauthors()
                coauthors(*coauthorsToSet)
            }

            assertEquals(Persons(coauthorsToSet.asIterable().toSetCheckingDistinct()), proposal.coauthors)
        }
    }

    @Nested
    @DisplayName("AI tests")
    inner class AITest {
        private fun ProposalReceiver.setupForAI() = setupForCommonTests(specifyAI = false)

        @Test
        fun `fails when AI not specified`() {
            assertFails {
                compile {
                    setupForAI()
                    // Don't set AI
                }
            }
        }

        @Test
        fun `fails when AI specified twice`() {
            val aiToSet = firstTestProposalAI()

            assertFails {
                compile {
                    setupForAI()
                    ai(aiToSet)
                    ai(aiToSet)
                }
            }
        }

        @Test
        fun `returns expected AI`() {
            val expectedAI = firstTestProposalAI()

            val proposal = compile {
                setupForAI()
                ai(expectedAI)
            }

            assertEquals(expectedAI, proposal.ai)
        }

        @Test
        fun `string to AI conversion works`() {
            for (integerPart in (0..3).map { it.toString() }) {
                for (decimalPart in (0..9).map { it.toString() }) {
                    val aiString = "$integerPart.$decimalPart"

                    val expectedAI = ProposalAI(aiString.toBigDecimal())

                    val proposal = compile {
                        setupForAI()
                        ai(aiString)
                    }

                    assertEquals(expectedAI, proposal.ai)
                }
            }
        }
    }
}

class ProposalDslV0Test : ProposalDslTestBase<ProposalReceiverV0>() {
    override fun ProposalReceiverV0.extendSetupForCommonTests() {
        // Nothing else to do, since V0 dsl is the same as the common
    }

    override fun compile(number: ProposalNumber, init: ProposalReceiverV0Init): Proposal {
        return buildProposalV0(number, init)
    }

    private fun fullProposal() = compile(firstTestProposalNumber()) {
        onlyCommonSetup()
        extendSetupForCommonTests()
    }

    @Test
    fun `versionedData is version 0`() {
        val proposal = fullProposal()
        assertTrue(proposal.versionedData is ProposalDataV0)
    }
}

class ProposalDslV1Test : ProposalDslTestBase<ProposalReceiverV1>() {
    override fun ProposalReceiverV1.extendSetupForCommonTests() {
        onlyV1SpecificSetup()
    }

    private fun ProposalReceiverV1.onlyV1SpecificSetup(
        specifyClass: Boolean = true
    ) {
        if (specifyClass) classless()
    }

    private fun ProposalReceiverV1.setupForV1Tests(
        specifyTitle: Boolean = true,
        specifyText: Boolean = true,
        specifyAuthor: Boolean = true,
        specifyCoauthors: Boolean = true,
        specifyAI: Boolean = true,
        specifyClass: Boolean = true
    ) {
        onlyCommonSetup(
            specifyTitle = specifyTitle,
            specifyText = specifyText,
            specifyAuthor = specifyAuthor,
            specifyCoauthors = specifyCoauthors,
            specifyAI = specifyAI
        )

        onlyV1SpecificSetup(
            specifyClass = specifyClass
        )
    }

    override fun compile(number: ProposalNumber, init: ProposalReceiverV1Init): Proposal {
        return buildProposalV1(number, init)
    }

    @Nested
    @DisplayName("class and chamber test")
    inner class ClassAndChamberTest {
        private fun ProposalReceiverV1.setupForClassAndChamber() {
            setupForV1Tests(specifyClass = false)
        }

        @Test
        fun `fails if no class or chamber specified`() {
            assertFails {
                compile {
                    setupForClassAndChamber()
                    // Don't set class and chamber
                }
            }
        }

        @Test
        fun `fails if class and chamber specified twice`() {
            assertFails {
                compile {
                    setupForClassAndChamber()
                    classless()
                    classless()
                }
            }
        }

        @Test
        fun `returns expected versioned data`() {
            val initToExpected = mapOf(
                { it: ProposalReceiverV1 -> it.classless() }
                        to ProposalClassAndChamber.Classless,
                { it: ProposalReceiverV1 -> it.democratic() }
                        to ProposalClassAndChamber.DemocraticClass,
                { it: ProposalReceiverV1 -> it.chamber(ProposalChamber.Participation) }
                        to ProposalClassAndChamber.OrdinaryClass(ProposalChamber.Participation),
                { it: ProposalReceiverV1 -> it.chamber(ProposalChamber.Economy) }
                        to ProposalClassAndChamber.OrdinaryClass(ProposalChamber.Economy)
            )

            for ((init, expectedClassAndChamber) in initToExpected) {
                val proposal = compile {
                    setupForClassAndChamber()
                    init(this)
                }

                val versionedData = proposal.versionedData

                assertTrue(versionedData is ProposalDataV1)
                assertEquals(expectedClassAndChamber, versionedData.classAndChamber)
            }
        }
    }
}
