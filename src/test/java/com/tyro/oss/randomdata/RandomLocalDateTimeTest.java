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

import static com.tyro.oss.randomdata.RandomLocalDateTime.randomLocalDateTime;
import static com.tyro.oss.randomdata.RandomLocalDateTime.randomLocalDateTimeBetween;
import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RandomLocalDateTimeTest {

    @Test
    public void shouldReturnRandomLocalDateTimeBetween19700101To20301231() throws Exception {
        assertThat(randomLocalDateTime())
                .isBetween(of(1970, 1, 1, 0, 0), of(2030, 12, 31, 23, 59));
    }

    @Test
    public void shouldReturnRandomLocalDateTimeBetween() throws Exception {
        assertThat(randomLocalDateTimeBetween(of(2000, 1, 1, 0, 0), of(2000, 12, 31, 23, 59)))
                .isBetween(of(2000, 1, 1, 0, 0), of(2000, 12, 31, 23, 59));
    }
}
