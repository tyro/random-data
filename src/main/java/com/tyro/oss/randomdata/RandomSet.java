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

import static com.tyro.oss.randomdata.RandomInteger.randomIntegerBetween;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;

import java.util.Set;
import java.util.function.Supplier;

public class RandomSet {

    public static <T> Set<T> randomSet(Supplier<T> supplier) {
        return randomSet(supplier, randomIntegerBetween(1, 20));
    }

    public static <T> Set<T> randomSet(Supplier<T> supplier, int size) {
        return range(0, size)
                .mapToObj(i -> supplier.get())
                .collect(toSet());
    }
}
