import org.agoranomic.assessor.dsl.receivers.*
import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.Proposal
import org.agoranomic.assessor.lib.ProposalNumber
import test_objects.firstTestProposalNumber

class `Proposal DSL V0 tests` {
    companion object {
        private fun ProposalReceiverV0.commonSetup(
            specifyTitle: Boolean = true,
            specifyText: Boolean = true,
            specifyAuthor: Boolean = true,
            specifyCoauthors: Boolean = true,
            specifyAI: Boolean = true
        ) {
            if (specifyTitle) title("Some title")
            if (specifyText) text("Some text")
            if (specifyAuthor) author(Person("Some author"))
            if (specifyCoauthors) coauthors(Person("First coauthor"), Person("second coauthor"))
            if (specifyAI) ai(1)
        }

        private fun compile(
            number: ProposalNumber = firstTestProposalNumber(),
            init: ProposalReceiverV0Init
        ): Proposal = buildProposalV0(number, init)
    }
}
