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
import static java.time.LocalTime.of;
import static java.time.LocalTime.ofSecondOfDay;

import java.time.LocalTime;

public class RandomLocalTime {

    public static LocalTime randomLocalTime() {
        return randomLocalTimeBetween(of(0, 0, 0), of(23, 59, 59));
    }

    public static LocalTime randomLocalTimeBetween(LocalTime start, LocalTime end) {
        return ofSecondOfDay(randomLongBetween(start.toSecondOfDay(), end.toSecondOfDay()));
    }
}
