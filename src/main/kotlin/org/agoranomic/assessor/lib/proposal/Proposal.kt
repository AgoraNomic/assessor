package org.agoranomic.assessor.lib.proposal

import org.agoranomic.assessor.lib.Person
import org.agoranomic.assessor.lib.Persons
import java.math.BigDecimal
import java.math.BigInteger

typealias RawProposalNumber = BigInteger

inline class ProposalNumber(val raw: RawProposalNumber) : Comparable<ProposalNumber> {
    constructor(raw: Int) : this(raw.toBigInteger())
    constructor(raw: Long) : this(raw.toBigInteger())

    override fun compareTo(other: ProposalNumber): Int {
        return (this.raw).compareTo(other.raw)
    }

    override fun toString(): String = raw.toString()
}

typealias RawProposalAI = BigDecimal

inline class ProposalAI(val raw: RawProposalAI) {
    constructor(raw: Int) : this(raw.toBigDecimal())

    override fun toString(): String = raw.toString()
}

/**
 * This exists to allow Proposal to provide these properties without explicitly delegating to each of them. This should
 * exactly mirror the properties in [ProposalCommonData].
 */
private interface ProposalCommonInterface {
    val number: ProposalNumber
    val ai: ProposalAI
    val title: String
    val author: Person
    val coauthors: Persons
    val text: String
}

data class ProposalCommonData(
    override val number: ProposalNumber,
    override val ai: ProposalAI,
    override val title: String,
    override val author: Person,
    override val coauthors: Persons,
    override val text: String
) : ProposalCommonInterface

sealed class ProposalVersionedData {
    abstract fun <R> accept(mapper: ProposalMapper<R>, commonData: ProposalCommonData): R
}

object ProposalDataV0 : ProposalVersionedData() {
    override fun <R> accept(mapper: ProposalMapper<R>, commonData: ProposalCommonData) =
        mapper.visitV0(commonData, this)
}

data class ProposalDataV1(val classAndChamber: ProposalClassAndChamber) : ProposalVersionedData() {
    override fun <R> accept(mapper: ProposalMapper<R>, commonData: ProposalCommonData) =
        mapper.visitV1(commonData, this)
}

interface ProposalMapper<R> {
    fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0): R
    fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1): R
}

typealias ProposalVisitor = ProposalMapper<Unit>

data class Proposal(
    val commonData: ProposalCommonData,
    val versionedData: ProposalVersionedData
) : ProposalCommonInterface by commonData {
    constructor(
        number: ProposalNumber,
        ai: ProposalAI,
        title: String,
        author: Person,
        coauthors: Persons,
        text: String,
        versionedData: ProposalVersionedData
    ) : this(
        ProposalCommonData(
            number = number,
            ai = ai,
            title = title,
            author = author,
            coauthors = coauthors,
            text = text
        ),
        versionedData
    )

    fun <R> accept(mapper: ProposalMapper<R>): R {
        return versionedData.accept(mapper, commonData)
    }
}

enum class Ministry(val readableName: String) {
    Justice("Justice"),
    Efficiency("Efficiency"),
    Legislation("Legislation"),
    Participation("Participation"),
    Economy("Economy"),
    ;
}

typealias ProposalChamber = Ministry

interface ProposalClassAndChamberMapper<R> {
    fun visitClassless(): R
    fun visitDemocratic(): R
    fun visitOrdinary(chamber: ProposalChamber): R
}

typealias ProposalClassAndChamberVisitor = ProposalClassAndChamberMapper<Unit>

sealed class ProposalClassAndChamber {
    abstract fun <R> accept(mapper: ProposalClassAndChamberMapper<R>): R

    object Classless : ProposalClassAndChamber() {
        override fun <R> accept(mapper: ProposalClassAndChamberMapper<R>): R = mapper.visitClassless()
    }

    object DemocraticClass : ProposalClassAndChamber() {
        override fun <R> accept(mapper: ProposalClassAndChamberMapper<R>): R = mapper.visitDemocratic()
    }

    data class OrdinaryClass(val chamber: ProposalChamber) : ProposalClassAndChamber() {
        override fun <R> accept(mapper: ProposalClassAndChamberMapper<R>): R = mapper.visitOrdinary(chamber)
    }
}

/**
 * Indicates that two proposals with the same [number][Proposal.number] but otherwise different data were encountered
 * in a place where that is prohibited.
 * @param next the new proposal with the number, but different data from [original]
 * @param original the first proposal to be encountered with the number
 */
data class ProposalDataMismatchException(
    val next: Proposal,
    val original: Proposal
) : Exception("Proposals with same number but different data found: $next and $original") {
    init {
        require(next.number == original.number)
    }
}

/**
 * Throws [ProposalDataMismatchException] if [original] and [next] have the same number but otherwise different data.
 *
 * If a [ProposalDataMismatchException] `ex` is thrown, `ex.original === [original]` and `ex.next === [next]`.
 *
 * @throws IllegalArgumentException if `original.number != next.number`
 */
fun checkMismatch(original: Proposal, next: Proposal) {
    require(original.number == next.number)

    if (original != next) {
        throw ProposalDataMismatchException(next = next, original = original)
    }
}
