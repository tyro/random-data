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

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.tyro.oss.randomdata.RandomString.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.generate;
import static org.assertj.core.api.Assertions.assertThat;

class RandomStringTest {

    @Test
    void shouldReturnRandomString() {
        assertThat(randomString()).containsPattern("[ -~]{20}");
    }

    @Test
    void shouldReturnRandomStringWithLengthOf255() {
        assertThat(randomString(255)).containsPattern("[ -~]{255}");
    }

    @Test
    void shouldReturnRandomNumericString() {
        assertThat(randomNumericString()).containsPattern("[0-9]{20}");
    }

    @Test
    void shouldReturnRandomNumericStringWithLengthOf255() {
        assertThat(randomNumericString(255)).containsPattern("[0-9]{255}");
    }

    @Test
    void shouldReturnRandomAlphabeticString() {
        assertThat(randomAlphabeticString()).containsPattern("[A-Za-z]{20}");
    }

    @Test
    void shouldReturnRandomAlphabeticStringWithLengthOf255() {
        assertThat(randomAlphabeticString(255)).containsPattern("[A-Za-z]{255}");
    }

    @Test
    void shouldReturnRandomAlphabeticStringWithSpace() {
        List<String> randomAlphabeticStringWithSpaceList = generate(RandomString::randomAlphabeticStringWithSpace)
                .limit(100)
                .collect(toList());

        assertThat(randomAlphabeticStringWithSpaceList)
                .allMatch(s -> s.matches("[A-Za-z\\s]{20}"))
                .anyMatch(s -> s.contains(" "));
    }

    @Test
    void shouldReturnRandomAlphabeticStringWithSpaceAndLengthOf255() {
        assertThat(randomAlphabeticStringWithSpace(255)).containsPattern("[A-Za-z\\s]{255}");
    }

    @Test
    void shouldReturnSpaceStringWithRandomLength() {
        assertThat(randomSpaceString())
                .containsOnlyWhitespaces()
                .hasSizeGreaterThanOrEqualTo(1)
                .hasSizeLessThanOrEqualTo(20);
    }

    @Test
    void shouldReturnSpaceStringLengthOf100() {
        assertThat(randomSpaceString(100)).containsPattern("\\s{100}");
    }

    @Test
    void shouldReturnRandomAlphanumericString() {
        assertThat(randomAlphanumericString()).containsPattern("[A-Za-z0-9]{20}");
    }

    @Test
    void shouldReturnRandomAlphanumericStringAndLengthOf255() {
        assertThat(randomAlphanumericString(255)).containsPattern("[A-Za-z0-9]{255}");
    }

    @Test
    void shouldReturnRandomUUIDString() {
        assertThat(randomUUID()).is(uuid());
    }

    private Condition<String> uuid() {
        return new Condition<>(s -> {
            try {
                UUID.fromString(s);
            } catch (Exception e) {
                return false;
            }
            return true;
        }, "UUID");
    }
}
