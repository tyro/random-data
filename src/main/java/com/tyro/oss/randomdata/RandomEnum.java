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
import java.util.EnumSet;

import static com.tyro.oss.randomdata.RandomInteger.randomIntegerBetween;
import static java.util.EnumSet.complementOf;
import static java.util.EnumSet.of;

public class RandomEnum {

    public static <T extends Enum> T randomEnumValue(Class<T> enumClass) {
        T[] constants = enumClass.getEnumConstants();
        return constants[randomIntegerBetween(0, constants.length - 1)];
    }

    public static <T extends Enum<T>> T randomEnumValue(EnumSet<T> enumSet) {
        return new ArrayList<>(enumSet).get(randomIntegerBetween(0, enumSet.size() - 1));
    }

    public static <T extends Enum<T>> T randomEnumValueExcept(T first, T... rest) {
        return randomEnumValue(complementOf(of(first, rest)));
    }

    public static <T extends Enum<T>> T randomEnumValueExcept(EnumSet<T> values) {
        return randomEnumValue(complementOf(values));
    }
}
