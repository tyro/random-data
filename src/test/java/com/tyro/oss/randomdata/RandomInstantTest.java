package com.tyro.oss.randomdata;

import org.junit.jupiter.api.Test;

import static com.tyro.oss.randomdata.RandomInstant.randomInstant;
import static com.tyro.oss.randomdata.RandomInstant.randomInstantBetween;
import static java.time.Instant.ofEpochSecond;
import static java.time.LocalDateTime.of;
import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

class RandomInstantTest {

    @Test
    void shouldReturnRandomInstantBetween19700101To20301231() {
        assertThat(randomInstant()).isBetween(
                ofEpochSecond(of(1970, 1, 1, 0, 0, 0).toEpochSecond(UTC)),
                ofEpochSecond(of(2030, 12, 31, 23, 59, 59).toEpochSecond(UTC)));
    }

    @Test
    void shouldReturnRandomInstantBetween() {
        long start = of(2020, 1, 1, 0, 0, 0).toEpochSecond(UTC);
        long end = of(2020, 12, 31, 23, 59, 59).toEpochSecond(UTC);

        assertThat(randomInstantBetween(start, end)).isBetween(ofEpochSecond(start), ofEpochSecond(end));
    }

}
