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

import java.time.Instant;

import static com.tyro.oss.randomdata.RandomLong.randomLongBetween;
import static java.time.Instant.ofEpochSecond;
import static java.time.LocalDateTime.of;
import static java.time.ZoneOffset.UTC;

public class RandomInstant {

    public static Instant randomInstant() {
        long startInstantInEpochSecond = of(1970, 1, 1, 0, 0, 0).toEpochSecond(UTC);
        long endInstantInEpochSecond = of(2030, 12, 31, 23, 59, 59).toEpochSecond(UTC);

        return randomInstantBetween(startInstantInEpochSecond, endInstantInEpochSecond);
    }

    public static Instant randomInstantBetween(long start, long end) {
        return ofEpochSecond(randomLongBetween(start, end));
    }

}
