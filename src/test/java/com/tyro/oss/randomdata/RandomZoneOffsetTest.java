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

import static com.tyro.oss.randomdata.RandomZoneOffset.randomZoneOffset;
import static com.tyro.oss.randomdata.RandomZoneOffset.randomZoneOffsetBetween;
import static java.time.ZoneOffset.ofHours;
import static java.time.ZoneOffset.ofHoursMinutes;
import static org.assertj.core.api.Assertions.assertThat;

class RandomZoneOffsetTest {

    @Test
    void shouldReturnRandomZoneOffsetBetween18ToNegative18() {
        assertThat(randomZoneOffset())
                .isBetween(ofHours(18), ofHours(-18));
    }

    @Test
    void shouldReturnRandomZoneOffsetBetween() {
        assertThat(randomZoneOffsetBetween(ofHours(2), ofHours(-2)))
                .isBetween(ofHoursMinutes(2, 0), ofHoursMinutes(-2, 0));
    }
}
