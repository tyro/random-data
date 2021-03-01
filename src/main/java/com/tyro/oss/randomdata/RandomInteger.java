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

import static com.tyro.oss.randomdata.Constants.RANDOM;
import static java.lang.Math.abs;
import static java.lang.Math.addExact;

public class RandomInteger {

    public static int randomInteger() {
        return RANDOM.nextInt();
    }

    public static int randomPositiveInteger() {
        return abs(randomInteger());
    }

    public static int randomIntegerBetween(int startInclusive, int endInclusive) {
        return RANDOM.ints(startInclusive, addExact(endInclusive, 1))
                .findFirst()
                .getAsInt();
    }
}
