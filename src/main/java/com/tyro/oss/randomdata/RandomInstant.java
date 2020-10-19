package com.tyro.oss.randomdata;

import java.time.Instant;

import static com.tyro.oss.randomdata.RandomLong.randomLongBetween;
import static java.time.Instant.ofEpochSecond;
import static java.time.LocalDateTime.of;
import static java.time.ZoneOffset.UTC;

public class RandomInstant {

    public static Instant randomInstant() {
        long startInstantInEpochSecond = of(1970, 1, 1, 0, 0, 0).toEpochSecond(UTC);
        long endInstantInEpochSecond = of(2030, 12, 31, 23, 59, 59).toEpochSecond(UTC);

        return randomInstantBetween(startInstantInEpochSecond, endInstantInEpochSecond);
    }

    public static Instant randomInstantBetween(long start, long end) {
        return ofEpochSecond(randomLongBetween(start, end));
    }

}
