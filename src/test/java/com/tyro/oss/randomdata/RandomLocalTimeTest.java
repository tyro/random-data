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

import static com.tyro.oss.randomdata.RandomLocalTime.randomLocalTime;
import static com.tyro.oss.randomdata.RandomLocalTime.randomLocalTimeBetween;
import static java.time.LocalTime.of;
import static org.assertj.core.api.Assertions.assertThat;

class RandomLocalTimeTest {

    @Test
    void shouldReturnRandomLocalTime() {
        assertThat(randomLocalTime())
                .isBetween(of(0, 0, 0), of(23, 59, 59));
    }

    @Test
    void shouldReturnRandomLocalTimeBetween() {
        assertThat(randomLocalTimeBetween(of(9, 0), of(17, 0)))
                .isBetween(of(9, 0), of(17, 0));
    }
}
