package org.agoranomic.assessor.test.dsl.proposal

import io.github.random_internet_cat.util.toSetCheckingDistinct
import org.agoranomic.assessor.dsl.receivers.ProposalCommonReceiver
import org.agoranomic.assessor.dsl.receivers.ai
import org.agoranomic.assessor.dsl.receivers.coauthors
import org.agoranomic.assessor.lib.Persons
import org.agoranomic.assessor.lib.emptyPersons
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
        specifyAI: Boolean = true
    ) {
        if (specifyTitle) title(firstTestProposalTitle())
        if (specifyText) text(firstTestProposalText())
        if (specifyAuthor) author(firstTestProposalAuthor())
        if (specifyCoauthors) coauthors(firstTestProposalCoauthors())
        if (specifyAI) ai(firstTestProposalAI())
    }

    fun R.setupExceptCommon()

    fun R.setupForCommonTests(
        specifyTitle: Boolean = true,
        specifyText: Boolean = true,
        specifyAuthor: Boolean = true,
        specifyCoauthors: Boolean = true,
        specifyAI: Boolean = true
    ) {
        setupOnlyCommon(
            specifyTitle = specifyTitle,
            specifyText = specifyText,
            specifyAuthor = specifyAuthor,
            specifyCoauthors = specifyCoauthors,
            specifyAI = specifyAI
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

interface ProposalCommonCompilerAITest<R : ProposalCommonReceiver> : ProposalCommonCompilerTestBase<R> {
    private fun R.setupForAI() = setupForCommonTests(specifyAI = false)

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

interface ProposalCommonCompilerTest<R : ProposalCommonReceiver> :
    ProposalCommonCompilerTitleTest<R>,
    ProposalCommonCompilerTextTest<R>,
    ProposalCommonCompilerAuthorTest<R>,
    ProposalCommonCompilerCoauthorTest<R>,
    ProposalCommonCompilerAITest<R>
