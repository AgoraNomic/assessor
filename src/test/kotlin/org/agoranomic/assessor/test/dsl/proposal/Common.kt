package org.agoranomic.assessor.test.dsl.proposal

import io.github.random_internet_cat.util.toSetCheckingDistinct
import org.agoranomic.assessor.dsl.receivers.ProposalCommonReceiver
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.emptyPersons
import org.agoranomic.assessor.lib.proposal.DecisionAI
import org.agoranomic.assessor.lib.proposal.ProposalAI
import org.agoranomic.assessor.test.test_objects.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

interface ProposalCommonCompilerTestBase<R : ProposalCommonReceiver> : ProposalCompilerTestBase<R> {
    fun R.setupOnlyCommon(
        specifyTitle: Boolean = true,
        specifyText: Boolean = true,
        specifyAuthor: Boolean = true,
        specifyCoauthors: Boolean = true,
        specifyProposalAI: Boolean = true,
        specifyDecisionAI: Boolean = true,
    ) {
        if (specifyTitle) title(firstTestProposalTitle())
        if (specifyText) text(firstTestProposalText())
        if (specifyAuthor) author(firstTestProposalAuthor())
        if (specifyCoauthors) coauthors(firstTestProposalCoauthors())
        if (specifyProposalAI) proposalAI(ProposalAI(firstTestAI()))
        if (specifyDecisionAI) decisionAI(DecisionAI(firstTestAI()))
    }

    fun R.setupExceptCommon()

    fun R.setupForCommonTests(
        specifyTitle: Boolean = true,
        specifyText: Boolean = true,
        specifyAuthor: Boolean = true,
        specifyCoauthors: Boolean = true,
        specifyProposalAI: Boolean = true,
        specifyDecisionAI: Boolean = true,
    ) {
        setupOnlyCommon(
            specifyTitle = specifyTitle,
            specifyText = specifyText,
            specifyAuthor = specifyAuthor,
            specifyCoauthors = specifyCoauthors,
            specifyProposalAI = specifyProposalAI,
            specifyDecisionAI = specifyDecisionAI,
        )

        setupExceptCommon()
    }
}

interface ProposalCommonCompilerTitleTest<R : ProposalCommonReceiver> : ProposalCommonCompilerTestBase<R> {
    private fun R.setupForTitle() = setupForCommonTests(specifyTitle = false)

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

interface ProposalCommonCompilerTextTest<R : ProposalCommonReceiver> : ProposalCommonCompilerTestBase<R> {
    private fun R.setupForText() = setupForCommonTests(specifyText = false)

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

interface ProposalCommonCompilerAuthorTest<R : ProposalCommonReceiver> : ProposalCommonCompilerTestBase<R> {
    private fun R.setupForAuthor() = setupForCommonTests(specifyAuthor = false)

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

interface ProposalCommonCompilerCoauthorTest<R : ProposalCommonReceiver> : ProposalCommonCompilerTestBase<R> {
    private fun R.setupForCoauthors() = setupForCommonTests(specifyCoauthors = false)

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

interface ProposalCommonCompilerProposalAITest<R : ProposalCommonReceiver> : ProposalCommonCompilerTestBase<R> {
    private fun R.setupForProposalAI() = setupForCommonTests(specifyProposalAI = false)

    @Test
    fun `fails when proposal AI not specified`() {
        assertFails {
            compile {
                setupForProposalAI()
                // Don't set AI
            }
        }
    }

    @Test
    fun `fails when proposal AI specified twice`() {
        val aiToSet = ProposalAI(firstTestAI())

        assertFails {
            compile {
                setupForProposalAI()
                proposalAI(aiToSet)
                proposalAI(aiToSet)
            }
        }
    }

    @Test
    fun `returns expected proposal AI`() {
        val expectedAI = ProposalAI(firstTestAI())

        val proposal = compile {
            setupForProposalAI()
            proposalAI(expectedAI)
        }

        assertEquals(expectedAI, proposal.proposalAI)
    }
}

interface ProposalCommonCompilerDecisionAITest<R : ProposalCommonReceiver> : ProposalCommonCompilerTestBase<R> {
    private fun R.setupForDecisionAI() = setupForCommonTests(specifyDecisionAI = false)

    @Test
    fun `fails when decision AI not specified`() {
        assertFails {
            compile {
                setupForDecisionAI()
                // Don't set AI
            }
        }
    }

    @Test
    fun `fails when decision AI specified twice`() {
        val aiToSet = DecisionAI(firstTestAI())

        assertFails {
            compile {
                setupForDecisionAI()
                decisionAI(aiToSet)
                decisionAI(aiToSet)
            }
        }
    }

    @Test
    fun `returns decision proposal AI`() {
        val expectedAI = DecisionAI(firstTestAI())

        val proposal = compile {
            setupForDecisionAI()
            decisionAI(expectedAI)
        }

        assertEquals(expectedAI, proposal.decisionAI)
    }
}

interface ProposalCommonCompilerTotalAITest<R : ProposalCommonReceiver> : ProposalCommonCompilerTestBase<R> {
    @Test
    fun `string to AI conversion works`() {
        for (integerPart in (0..3).map { it.toString() }) {
            for (decimalPart in (0..9).map { it.toString() }) {
                val aiString = "$integerPart.$decimalPart"

                val expectedAI = aiString.toBigDecimal()

                val proposal = compile {
                    setupForCommonTests(
                        specifyProposalAI = false,
                        specifyDecisionAI = false,
                    )

                    ai(aiString)
                }

                assertEquals(ProposalAI(expectedAI), proposal.proposalAI)
                assertEquals(DecisionAI(expectedAI), proposal.decisionAI)
            }
        }
    }
}

interface ProposalCommonCompilerTest<R : ProposalCommonReceiver> :
    ProposalCommonCompilerTitleTest<R>,
    ProposalCommonCompilerTextTest<R>,
    ProposalCommonCompilerAuthorTest<R>,
    ProposalCommonCompilerCoauthorTest<R>,
    ProposalCommonCompilerProposalAITest<R>,
    ProposalCommonCompilerDecisionAITest<R>,
    ProposalCommonCompilerTotalAITest<R>
