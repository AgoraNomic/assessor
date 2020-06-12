package org.agoranomic.assessor.dsl.ministries

enum class OfficeInitial {
    ADoP,
    Arbitor,
    Assessor,
    Comptrollor,
    Distributor,
    Herald,
    Notary,
    PrimeMinister,
    Promotor,
    Referee,
    Registrar,
    Rulekeepor,
    Speaker,
    Tailor,
    Treasuror,
    ;
}

// Reflects addition of Webmastor created by P8388, adopted ~June 3, 2020
// See https://mailman.agoranomic.org/cgi-bin/mailman/private/agora-official/2020-May/013695.html
enum class OfficeJune3Webmastor {
    ADoP,
    Arbitor,
    Assessor,
    Comptrollor,
    Distributor,
    Herald,
    Notary,
    PrimeMinister,
    Promotor,
    Referee,
    Registrar,
    Rulekeepor,
    Speaker,
    Tailor,
    Treasuror,
    Webmastor,
    ;

    companion object {
        // Relies on enumerators having the same names as OfficeInitial
        fun fromInitial(other: OfficeInitial): OfficeJune3Webmastor {
            return OfficeJune3Webmastor.valueOf(other.name)
        }
    }
}
