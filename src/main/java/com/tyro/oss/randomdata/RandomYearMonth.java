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

import java.time.YearMonth;

import static com.tyro.oss.randomdata.RandomInteger.randomIntegerBetween;
import static java.time.YearMonth.of;

public class RandomYearMonth {

    public static YearMonth randomYearMonth() {
        YearMonth minYearMonth = of(1970, 1);
        YearMonth maxYearMonth = of(2040, 12);

        return randomYearMonthBetween(minYearMonth, maxYearMonth);
    }

    public static YearMonth randomYearMonthBetween(YearMonth start, YearMonth end) {
        return of(randomIntegerBetween(start.getYear(), end.getYear()),
                randomIntegerBetween(start.getMonthValue(), end.getMonthValue()));
    }
}
