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

import static com.tyro.oss.randomdata.RandomInteger.*;
import static java.lang.Integer.MAX_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RandomIntegerTest {

    @Test
    public void shouldReturnRandomInteger() throws Exception {
        assertThat(randomInteger()).isInstanceOf(Integer.class);
    }

    @Test
    public void shouldReturnRandomPositiveInteger() throws Exception {
        assertThat(randomPositiveInteger()).isBetween(0, MAX_VALUE);
    }

    @Test
    public void shouldReturnRandomIntegerBetween() throws Exception {
        assertThat(randomIntegerBetween(10, 100)).isBetween(10, 100);
        assertThat(randomIntegerBetween(-100, -10)).isBetween(-100, -10);
        assertThat(randomIntegerBetween(-10, 10)).isBetween(-10, 10);
    }
}
