# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).
Release dates in this changelog follow the [ISO 8601 format](https://www.iso.org/iso-8601-date-and-time-format.html), i.e. YYYY-MM-DD.

Note that, as this project did not start with proper documentation,
dates before public release are unfortunately unavailable.

## [Unreleased]

## [1.4.0] - 2019-12-06
### Added
- transpose(), performs a matrix transposition on Lists and arrays with multiple dimensions

### Changed
- Flattening of arrays of arrays of primitives now uses public methods, rather than internally-called private methods

### Fixed
- flatten() return type meant that the compiler assumed that the output type was the same as the input

## [1.3.1]
### Changed
- Flattening involving arrays of primitives now has all values in one array, itself in one List

## [1.3.0]
### Added
- Partial flatten() support for arrays of primitives

## [1.2.0]
### Added
- ensureSize(), ensures size of list is a given value or greater

## [1.1.0]
### Added
- flatten() support for arrays of objects

## [1.0.0]
### Added
- Initial flatten() version, supports only Lists