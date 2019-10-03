/*
 * #%L
 * random-data
 * %%
 * Copyright (C) 2016 - 2017 Tyro Payments Pty Ltd
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

import static com.tyro.oss.randomdata.RandomLocalDate.randomLocalDate;
import static com.tyro.oss.randomdata.RandomLocalDate.randomLocalDateBetween;
import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;

class RandomLocalDateTest {

    @Test
    void shouldReturnRandomLocalDateBetween19700101To20301231() {
        assertThat(randomLocalDate())
                .isBetween(of(1970, 1, 1), of(2030, 12, 31));
    }

    @Test
    void shouldReturnRandomLocalDateBetween() {
        assertThat(randomLocalDateBetween(of(2000, 1, 1), of(2000, 12, 31)))
                .isBetween(of(2000, 1, 1), of(2000, 12, 31));
    }
}
