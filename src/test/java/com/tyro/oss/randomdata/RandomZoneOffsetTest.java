package com.tyro.oss.randomdata;

import org.junit.jupiter.api.Test;

import static com.tyro.oss.randomdata.RandomZoneOffset.randomZoneOffset;
import static com.tyro.oss.randomdata.RandomZoneOffset.randomZoneOffsetBetween;
import static java.time.ZoneOffset.ofHours;
import static java.time.ZoneOffset.ofHoursMinutes;
import static org.assertj.core.api.Assertions.assertThat;

class RandomZoneOffsetTest {

    @Test
    void shouldReturnRandomZoneOffsetBetween18ToNegative18() {
        assertThat(randomZoneOffset())
                .isBetween(ofHours(18), ofHours(-18));
    }

    @Test
    void shouldReturnRandomZoneOffsetBetween() {
        assertThat(randomZoneOffsetBetween(ofHours(2), ofHours(-2)))
                .isBetween(ofHoursMinutes(2, 0), ofHoursMinutes(-2, 0));
    }
}
