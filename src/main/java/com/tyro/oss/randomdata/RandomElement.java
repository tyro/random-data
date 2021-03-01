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

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

import static com.tyro.oss.randomdata.RandomInteger.randomIntegerBetween;

public class RandomElement {

    @SafeVarargs
    public static <T> T randomElementOf(T object, T... objects) {
        int index = randomIntegerBetween(0, objects.length);
        if (index == 0) {
            return object;
        }
        return objects[index - 1];
    }

    public static <T> T randomElementOf(Collection<T> objects) {
        int index = randomIntegerBetween(0, objects.size() - 1);
        return new ArrayList<>(objects).get(index);
    }

    @SafeVarargs
    public static <T> T randomElementOf(Supplier<T> object, Supplier<T>... objects) {
        int index = randomIntegerBetween(0, objects.length);
        if (index == 0) {
            return object.get();
        }
        return objects[index - 1].get();
    }
}
