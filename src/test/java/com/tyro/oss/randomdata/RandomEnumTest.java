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


import org.junit.jupiter.api.Test;

import static com.tyro.oss.randomdata.RandomEnum.randomEnumValue;
import static com.tyro.oss.randomdata.RandomEnum.randomEnumValueExcept;
import static com.tyro.oss.randomdata.RandomEnumTest.Colour.*;
import static java.util.EnumSet.of;
import static org.assertj.core.api.Assertions.assertThat;

class RandomEnumTest {

    @Test
    void shouldReturnRandomEnumValueFromEnum() {
        assertThat(randomEnumValue(Colour.class)).isIn(Colour.values());
    }

    @Test
    void shouldReturnRandomEnumValueFromEnumSet() {
        assertThat(randomEnumValue(of(Red, Orange, Yellow, Green, Cyan, Blue))).isIn(Red, Orange, Yellow, Green, Cyan, Blue);
    }

    @Test
    void shouldNotReturnTheExcludedEnumValuesFromEnum() {
        assertThat(randomEnumValueExcept(Red)).isNotIn(Red);
        assertThat(randomEnumValueExcept(Red, Orange)).isNotIn(Red, Orange);
    }

    @Test
    void shouldNotReturnTheExcludedEnumValuesFromEnumSet() {
        assertThat(randomEnumValueExcept(of(Red, Orange))).isNotIn(Red, Orange);
    }

    enum Colour {
        Red, Orange, Yellow, Green, Cyan, Blue, Indigo, Violet, Purple, Magenta, Pink, Brown, White, Gray, Black
    }
}
