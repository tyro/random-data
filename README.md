# random-data

[![Download](https://maven-badges.herokuapp.com/maven-central/com.tyro.oss/random-data/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.tyro.oss/random-data)
[![Build Status](https://travis-ci.org/tyro/random-data.svg?branch=master)](https://travis-ci.org/tyro/random-data)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

A simple library that populates random Java objects and primitives.

Support for the following types is provided:
* Boolean, Double, Integer, Long
* String
* Enum
* BigDecimal
* LocalDate, LocalDateTime, LocalTime, Instant, YearMonth, ZonedDateTime, ZoneOffset
* Lists and Sets of a supported type
* Classes with constructor parameters of a supported type

## Getting Started

random-data is available on Maven Central.
```xml
<dependency>
    <groupId>com.tyro.oss</groupId>
    <artifactId>random-data</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
</dependency>
```

Example usage.
```kotlin
// generate random values
val integer = randomInteger()
val long = randomLongBetween(1, 100)
val date = randomLocalDate()

// generate a random instance
val customer = random(Customer::class.java)

// generate a set of random numeric strings
val set = randomSet { randomNumericString() }

// generate a list of 10 random strings
val list = randomList({ randomString() }, 10)
```

## Copyright and Licensing

Copyright (C) 2017 - 2021 Tyro Payments Limited

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## Contributing

See [CONTRIBUTING](CONTRIBUTING.md) for details.
