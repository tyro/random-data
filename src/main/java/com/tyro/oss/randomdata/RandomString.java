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

import java.util.UUID;
import java.util.function.IntPredicate;

import static com.tyro.oss.randomdata.Constants.RANDOM;
import static com.tyro.oss.randomdata.RandomInteger.randomIntegerBetween;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.generate;

public class RandomString {

    private static final int LENGTH = 20;

    public static String randomString() {
        return randomString(LENGTH);
    }

    public static String randomString(int length) {
        return random(length, ' ', '~');
    }

    public static String randomNumericString() {
        return randomNumericString(LENGTH);
    }

    public static String randomNumericString(int length) {
        return random(length, '0', '9', Character::isDigit);
    }

    public static String randomAlphabeticString() {
        return randomAlphabeticString(LENGTH);
    }

    public static String randomAlphabeticString(int length) {
        return random(length, 'A', 'z', Character::isAlphabetic);
    }

    public static String randomAlphabeticStringWithSpace() {
        return randomAlphabeticStringWithSpace(LENGTH);
    }

    public static String randomAlphabeticStringWithSpace(int length) {
        IntPredicate isAlphabetic = Character::isAlphabetic;
        IntPredicate isSpace = Character::isSpaceChar;
        return random(length, ' ', 'z', isAlphabetic.or(isSpace));
    }

    public static String randomAlphanumericString() {
        return randomAlphanumericString(LENGTH);
    }

    public static String randomAlphanumericString(int length) {
        IntPredicate isAlphabetic = Character::isAlphabetic;
        IntPredicate isDigit = Character::isDigit;

        return random(length, '0', 'z', isAlphabetic.or(isDigit));
    }

    public static String randomSpaceString() {
        return randomSpaceString(randomIntegerBetween(1, 20));
    }

    public static String randomSpaceString(int length) {
        return generate(() -> " ")
                .limit(length)
                .collect(joining());
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    private static String toCharacter(int integer) {
        return Character.toString((char) integer);
    }

    private static String random(int length, int begin, int end) {
        return RANDOM.ints(begin, end + 1)
                .limit(length)
                .mapToObj(RandomString::toCharacter)
                .collect(joining());
    }

    private static String random(int length, int begin, int end, IntPredicate rule) {
        return RANDOM.ints(begin, end + 1)
                .filter(rule)
                .limit(length)
                .mapToObj(RandomString::toCharacter)
                .collect(joining());
    }
}
