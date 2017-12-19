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

import static com.tyro.oss.randomdata.Constants.RANDOM;
import static java.lang.Math.abs;
import static java.lang.Math.addExact;

public class RandomLong {

    public static long randomLong() {
        return RANDOM.nextLong();
    }

    public static long randomLongBetween(long startInclusive, long endInclusive) {
        return RANDOM.longs(startInclusive, addExact(endInclusive, 1))
                .findFirst()
                .getAsLong();
    }

    public static long randomPositiveLong() {
        return abs(randomLong());
    }
}
