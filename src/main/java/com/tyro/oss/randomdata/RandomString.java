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

import static java.lang.System.currentTimeMillis;
import static java.util.stream.Collectors.joining;

import java.util.Random;
import java.util.function.IntPredicate;

public class RandomString {

    private static final Random RANDOM = new Random(currentTimeMillis());
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
        return random(length, 'A', 'z', isAlphabetic.or(isSpace));
    }

    public static String randomAlphanumericString() {
        return randomAlphanumericString(LENGTH);
    }

    public static String randomAlphanumericString(int length) {
        IntPredicate isAlphabetic = Character::isAlphabetic;
        IntPredicate isDigit = Character::isDigit;

        return random(length, '0', 'z', isAlphabetic.or(isDigit));
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
