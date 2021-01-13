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
enum class Office_2020_06_03_Webmastor : OfficeID {
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
        fun fromInitial(other: OfficeInitial): Office_2020_06_03_Webmastor {
            return Office_2020_06_03_Webmastor.valueOf(other.name)
        }
    }
}

// Reflects removal of Comptrollor by P8400, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html
enum class Office_2020_06_03 : OfficeID {
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
        fun fromWebmastor(other: Office_2020_06_03_Webmastor): Office_2020_06_03 {
            require(other != Office_2020_06_03_Webmastor.Comptrollor) { "Cannot convert Comptrollor, as it was removed" }
            return valueOf(other.name)
        }
    }
}

// Reflects addition of Coopor by P8442, adopted 30 June 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-June/013879.html
enum class Office_2020_06_30 : OfficeID {
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
        fun fromJune3(other: Office_2020_06_03): Office_2020_06_30 {
            return valueOf(other.name)
        }
    }
}

// Reflects addition of Ministor by P8515, adopted on 28 Oct 2020.
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-October/014335.html
enum class Office_2020_10_28 : OfficeID {
    ADoP,
    Arbitor,
    Assessor,
    Coopor,
    Distributor,
    Herald,
    Ministor,
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
}
