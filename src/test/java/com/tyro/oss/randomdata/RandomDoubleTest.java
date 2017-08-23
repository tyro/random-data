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

import static com.tyro.oss.randomdata.RandomDouble.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(RepeatRunner.class)
public class RandomDoubleTest {

    @Test
    public void shouldReturnRandomDouble() throws Exception {
        assertThat(randomDouble()).isInstanceOf(Double.class);
    }

    @Test
    public void shouldReturnRandomDoubleInclusive() throws Exception {
        assertThat(randomDoubleBetween(10.0, 100.0)).isBetween(10.0, 100.0);
        assertThat(randomDoubleBetween(-100.0, -10.0)).isBetween(-100.0, -10.0);
        assertThat(randomDoubleBetween(-10.0, 10.0)).isBetween(-10.0, 10.0);
    }

    @Test
    public void shouldReturnRandomPositiveDouble() throws Exception {
        assertThat(randomPositiveDouble()).isPositive();
    }
}
