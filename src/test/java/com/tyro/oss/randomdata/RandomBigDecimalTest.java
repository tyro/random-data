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

import static com.tyro.oss.randomdata.RandomBigDecimal.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(RepeatRunner.class)
public class RandomBigDecimalTest {

    @Test
    public void shouldReturnRandomBigDecimal() throws Exception {
        assertThat(randomBigDecimal()).isInstanceOf(BigDecimal.class);
    }

    @Test
    public void shouldReturnRandomBigDecimalInclusive() throws Exception {
        assertThat(randomBigDecimalBetween(new BigDecimal(10.0), new BigDecimal(100.0))).isBetween(new BigDecimal(10.0), new BigDecimal(100.0));
        assertThat(randomBigDecimalBetween(new BigDecimal(-100.0), new BigDecimal(-10.0))).isBetween(new BigDecimal(-100.0), new BigDecimal(-10.0));
        assertThat(randomBigDecimalBetween(new BigDecimal(-10.0), new BigDecimal(10.0))).isBetween(new BigDecimal(-10.0), new BigDecimal(10.0));
    }

    @Test
    public void shouldReturnRandomPositivBigDecimal() throws Exception {
        assertThat(randomPositiveBigDecimal()).isPositive();
    }
}
