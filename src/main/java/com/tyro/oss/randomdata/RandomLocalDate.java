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

import static com.tyro.oss.randomdata.RandomLong.randomLongBetween;
import static java.time.LocalDate.of;
import static java.time.LocalDate.ofEpochDay;

import java.time.LocalDate;

public class RandomLocalDate {

    public static LocalDate randomLocalDate() {
        LocalDate minDay = of(1970, 1, 1);
        LocalDate maxDay = of(2030, 12, 31);
        return randomLocalDateBetween(minDay, maxDay);
    }

    public static LocalDate randomLocalDateBetween(LocalDate start, LocalDate end) {
        return ofEpochDay(randomLongBetween(start.toEpochDay(), end.toEpochDay()));
    }
}
