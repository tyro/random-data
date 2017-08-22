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

import static com.tyro.oss.randomdata.RandomLocalDate.randomLocalDate;
import static com.tyro.oss.randomdata.RandomLocalDate.randomLocalDateBetween;
import static com.tyro.oss.randomdata.RandomLocalTime.randomLocalTime;
import static com.tyro.oss.randomdata.RandomLocalTime.randomLocalTimeBetween;
import static java.time.LocalDateTime.of;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RandomLocalDateTime {

    public static LocalDateTime randomLocalDateTime() {
        return of(randomLocalDate(), randomLocalTime());
    }

    public static LocalDateTime randomLocalDateTimeBetween(LocalDateTime start, LocalDateTime end) {
        LocalDate randomLocalDate = randomLocalDateBetween(start.toLocalDate(), end.toLocalDate());
        LocalTime randomLocalTime = randomLocalTimeBetween(start.toLocalTime(), end.toLocalTime());
        return of(randomLocalDate, randomLocalTime);
    }
}
