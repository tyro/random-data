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

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tyro.oss.randomdata.RandomElement.randomElementOf;
import static com.tyro.oss.randomdata.RandomInteger.randomInteger;
import static com.tyro.oss.randomdata.RandomString.randomString;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class RandomElementTest {

    @Test
    void shouldReturnRandomElementOfVarargs() {
        String str1 = randomString();
        String str2 = randomString();
        assertThat(randomElementOf(str1)).isEqualTo(str1);
        assertThat(randomElementOf(str1, str2)).isIn(str1, str2);
    }

    @Test
    void shouldReturnRandomElementOfCollections() {
        int int1 = randomInteger();
        int int2 = randomInteger();
        List<Integer> integers = asList(int1, int2);

        assertThat(randomElementOf(integers)).isIn(int1, int2);
    }

    @Test
    void shouldReturnRandomElementOfSuppliers() {
        String str1 = randomString();
        String str2 = randomString();

        assertThat(randomElementOf(() -> str1)).isEqualTo(str1);
        assertThat(randomElementOf(() -> str1, () -> str2)).isIn(str1, str2);
    }
}
