# Office of the Assessor

This repository contains programs for resolving Agoran decisions to adopt proposals.

##### Warning
The author reserves the right to force-push this repository on any branch at any time.

##### Language
This project is written entirely in Kotlin.

## Structure
The base package is `org.agoranomic.assessor`.

Within that package are the following
- `decisions`: contains the actual votes and proposals for decisions.
- `lib`: contains the code to enable the DSL, resolve decisions, generate reports, etc.

## Usage

### DSL

The form of the DSL is:

```kotlin
assessment {
    quorum(<quorum of the decision>)

    strengths {
        default(<default voting strength>)

        // Simple specification
        <player> strength <override strength>
        // assuming a player object X: X strength 12

        // Optionally, specifying a comment
        <player> strength <override strength> comment <comment>
        // e.g.: X strength 12 comment "Magical!"

        [...]
    }

    proposals {
        proposal {
            title(<title>)
            ai(<adoption index>) // or adoption_index(<...>)
            author(<player>)
            coauthors(<player>, [...])
            text(<text>)
        }

        [...]
    }

    voting {
        votes(<player>) {
            // Simple vote
            <vote> on <proposal #>
            // e.g.: FOR on 9999

            // Vote with comment
            <vote> on <proposal #> comment <comment>
            // e.g.: FOR on 9999 comment "conditional resolved"

            // Endorsing vote
            endorses(<player>) on <proposal #>
            // e.g.: endorses(X) on 9999

            [...]
        }

        [...]

        // For things like zombies, where two players cast the exact same votes
        <player> matches <player>
        // e.g.: X matches Y
        // This is not intended for use where two players just happen to have the same vote
    }
}
```

The above block returns an expression of unspecified type. The only guarantee is that it can be passed to the free function `resolve`.

### Free functions
`resolve` is a free function that returns a value of unspecified type. The only guarantee is that it can be passed to the free function `report`.

`report` is a free function that returns a `String`. `report` also takes an optional argument of type `ReportConfig`, which provides options to configure the report output.

### Naming
Names beginning with an underscore followed by an uppercase letter in the base package are reserved and should not be used.

Private member variables in receiver types are prefixed with `m_`.