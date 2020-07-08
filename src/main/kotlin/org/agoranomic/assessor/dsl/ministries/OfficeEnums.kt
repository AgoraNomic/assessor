package org.agoranomic.assessor.dsl.ministries

interface OfficeID {
    val readableName: String
    val programmaticName: String
}

enum class OfficeInitial : OfficeID {
    ADoP,
    Arbitor,
    Assessor,
    Comptrollor,
    Distributor,
    Herald,
    Notary,
    PrimeMinister("Prime Minister"),
    Promotor,
    Referee,
    Registrar,
    Rulekeepor,
    Speaker,
    Tailor,
    Treasuror,
    ;

    override val readableName: String

    override val programmaticName: String
        get() = name

    constructor(readableName: String) {
        this.readableName = readableName
    }

    constructor() {
        this.readableName = this.name
    }
}

// Reflects addition of Webmastor created by P8388, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html
enum class OfficeJune3Webmastor : OfficeID {
    ADoP,
    Arbitor,
    Assessor,
    Comptrollor,
    Distributor,
    Herald,
    Notary,
    PrimeMinister("Prime Minister"),
    Promotor,
    Referee,
    Registrar,
    Rulekeepor,
    Speaker,
    Tailor,
    Treasuror,
    Webmastor,
    ;

    override val readableName: String

    override val programmaticName: String
        get() = name

    constructor(readableName: String) {
        this.readableName = readableName
    }

    constructor() {
        this.readableName = this.name
    }

    companion object {
        // Relies on enumerators having the same names as OfficeInitial
        fun fromInitial(other: OfficeInitial): OfficeJune3Webmastor {
            return OfficeJune3Webmastor.valueOf(other.name)
        }
    }
}

// Reflects removal of Comptrollor by P8400, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html
enum class OfficeJune3 : OfficeID {
    ADoP,
    Arbitor,
    Assessor,
    Distributor,
    Herald,
    Notary,
    PrimeMinister("Prime Minister"),
    Promotor,
    Referee,
    Registrar,
    Rulekeepor,
    Speaker,
    Tailor,
    Treasuror,
    Webmastor,
    ;

    override val readableName: String

    override val programmaticName: String
        get() = name

    constructor(readableName: String) {
        this.readableName = readableName
    }

    constructor() {
        this.readableName = this.name
    }

    companion object {
        // Relies on enumerators having the same names as OfficeInitial
        fun fromWebmastor(other: OfficeJune3Webmastor): OfficeJune3 {
            require(other != OfficeJune3Webmastor.Comptrollor) { "Cannot convert Comptrollor, as it was removed" }
            return valueOf(other.name)
        }
    }
}

// Reflects addition of Coopor by P8442, adopted 30 June 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013879.html
enum class OfficeJune30 : OfficeID {
    ADoP,
    Arbitor,
    Assessor,
    Coopor,
    Distributor,
    Herald,
    Notary,
    PrimeMinister("Prime Minister"),
    Promotor,
    Referee,
    Registrar,
    Rulekeepor,
    Speaker,
    Tailor,
    Treasuror,
    Webmastor,
    ;

    override val readableName: String

    override val programmaticName: String
        get() = name

    constructor(readableName: String) {
        this.readableName = readableName
    }

    constructor() {
        this.readableName = this.name
    }

    companion object {
        // Relies on enumerators having the same names as OfficeInitial
        fun fromJune3(other: OfficeJune3): OfficeJune30 {
            return valueOf(other.name)
        }
    }
}
