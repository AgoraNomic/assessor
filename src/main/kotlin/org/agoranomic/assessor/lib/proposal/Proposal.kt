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

typealias RawProposalVersionNumber = BigDecimal

inline class ProposalVersionNumber(val raw: RawProposalVersionNumber) {
    constructor(raw: Int) : this(raw.toBigDecimal())
}

sealed class ProposalVersionedData {
    abstract val version: ProposalVersionNumber
    abstract fun <R> accept(mapper: ProposalMapper<R>, commonData: ProposalCommonData): R
}

interface ProposalClassAndChamberData {
    val classAndChamber: ProposalClassAndChamber
}

object ProposalDataV0 : ProposalVersionedData() {
    override val version: ProposalVersionNumber
        get() = ProposalVersionNumber(0)

    override fun <R> accept(mapper: ProposalMapper<R>, commonData: ProposalCommonData) =
        mapper.visitV0(commonData, this)
}

data class ProposalDataV1(
    override val classAndChamber: ProposalClassAndChamber
) : ProposalVersionedData(), ProposalClassAndChamberData {
    override val version: ProposalVersionNumber
        get() = ProposalVersionNumber(1)

    override fun <R> accept(mapper: ProposalMapper<R>, commonData: ProposalCommonData) =
        mapper.visitV1(commonData, this)
}

data class ProposalDataV2(
    override val classAndChamber: ProposalClassAndChamber,
    val sponsored: Boolean
) : ProposalVersionedData(), ProposalClassAndChamberData {
    override val version: ProposalVersionNumber
        get() = ProposalVersionNumber(2)

    override fun <R> accept(mapper: ProposalMapper<R>, commonData: ProposalCommonData) =
        mapper.visitV2(commonData, this)
}

interface ProposalMapper<R> {
    fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0): R
    fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1): R
    fun visitV2(commonData: ProposalCommonData, versionedData: ProposalDataV2): R
}

typealias ProposalVisitor = ProposalMapper<Unit>

abstract class ProposalChamberedMapper<R> : ProposalMapper<R> {
    protected abstract fun visitUnchambered(commonData: ProposalCommonData): R
    protected abstract fun visitChambered(commonData: ProposalCommonData, classAndChamber: ProposalClassAndChamber): R

    final override fun visitV0(commonData: ProposalCommonData, versionedData: ProposalDataV0) =
        visitUnchambered(commonData)

    final override fun visitV1(commonData: ProposalCommonData, versionedData: ProposalDataV1) =
        visitChambered(commonData, versionedData.classAndChamber)

    final override fun visitV2(commonData: ProposalCommonData, versionedData: ProposalDataV2) =
        visitChambered(commonData, versionedData.classAndChamber)
}

typealias ProposalChamberedVisitor = ProposalChamberedMapper<Unit>

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

    val version get() = versionedData.version

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
