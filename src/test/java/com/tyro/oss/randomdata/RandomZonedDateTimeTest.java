/*
 * #%L
 * random-data
 * %%
 * Copyright (C) 2017 - 2021 Tyro Payments Limited
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.tyro.oss.randomdata;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static com.tyro.oss.randomdata.RandomZonedDateTime.randomZonedDateTime;
import static com.tyro.oss.randomdata.RandomZonedDateTime.randomZonedDateTimeBetween;
import static java.time.ZoneId.systemDefault;
import static java.time.ZonedDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;

class RandomZonedDateTimeTest {

    @Test
    void shouldReturnRandomZonedDateTimeBetween19700101To20301231() {
        assertThat(randomZonedDateTime())
                .isBetween(of(1970, 1, 1, 0, 0, 0, 0, systemDefault()), of(2030, 12, 31, 23, 59, 0, 0, systemDefault()));
    }

    @Test
    void shouldReturnRandomZonedDateTimeOfSpecificStringZoneId() {
        ZoneId newYorkZoneId = ZoneId.of("America/New_York");

        ZonedDateTime randomNewYorkZonedDateTime = RandomZonedDateTime.randomZonedDateTime("America/New_York");

        assertThat(randomNewYorkZonedDateTime)
                .isBetween(of(1970, 1, 1, 0, 0, 0, 0, newYorkZoneId), of(2030, 12, 31, 23, 59, 0, 0, newYorkZoneId));
        assertThat(randomNewYorkZonedDateTime.getOffset().toString())
                .isIn("-04:00", "-05:00");
    }

    @Test
    void shouldReturnRandomZonedDateTimeBetween() {
        assertThat(randomZonedDateTimeBetween(of(2000, 1, 1, 0, 0, 0, 0, systemDefault()), of(2000, 12, 31, 23, 59, 0, 0, systemDefault())))
                .isBetween(of(2000, 1, 1, 0, 0, 0, 0, systemDefault()), of(2000, 12, 31, 23, 59, 0, 0, systemDefault()));
    }
}
