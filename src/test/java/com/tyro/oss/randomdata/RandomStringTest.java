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

import static com.tyro.oss.randomdata.RandomString.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RandomStringTest {

    @Test
    public void shouldReturnRandomString() throws Exception {
        assertThat(randomString()).containsPattern("[ -~]{20}");
    }

    @Test
    public void shouldReturnRandomStringWithLengthOf255() throws Exception {
        assertThat(randomString(255)).containsPattern("[ -~]{255}");
    }

    @Test
    public void shouldReturnRandomNumericString() throws Exception {
        assertThat(randomNumericString()).containsPattern("[0-9]{20}");
    }

    @Test
    public void shouldReturnRandomNumericStringWithLengthOf255() throws Exception {
        assertThat(randomNumericString(255)).containsPattern("[0-9]{255}");
    }

    @Test
    public void shouldReturnRandomAlphabeticString() throws Exception {
        assertThat(randomAlphabeticString()).containsPattern("[A-Za-z]{20}");
    }

    @Test
    public void shouldReturnRandomAlphabeticStringWithLengthOf255() throws Exception {
        assertThat(randomAlphabeticString(255)).containsPattern("[A-Za-z]{255}");
    }

    @Test
    public void shouldReturnRandomAlphabeticStringWithSpace() throws Exception {
        assertThat(randomAlphabeticStringWithSpace()).containsPattern("[A-Za-z\\s]{20}");
    }

    @Test
    public void shouldReturnRandomAlphabeticStringWithSpaceAndLengthOf255() throws Exception {
        assertThat(randomAlphabeticStringWithSpace(255)).containsPattern("[A-Za-z\\s]{255}");
    }

    @Test
    public void shouldReturnRandomAlphanumericString() throws Exception {
        assertThat(randomAlphanumericString()).containsPattern("[A-Za-z0-9]{20}");
    }

    @Test
    public void shouldReturnRandomAlphanumericStringAndLengthOf255() throws Exception {
        assertThat(randomAlphanumericString(255)).containsPattern("[A-Za-z0-9]{255}");
    }
}
