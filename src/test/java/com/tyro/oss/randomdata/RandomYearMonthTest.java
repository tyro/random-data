package com.tyro.oss.randomdata;

import org.junit.jupiter.api.Test;

import static com.tyro.oss.randomdata.RandomYearMonth.randomYearMonth;
import static com.tyro.oss.randomdata.RandomYearMonth.randomYearMonthBetween;
import static java.time.YearMonth.of;
import static org.assertj.core.api.Assertions.assertThat;

class RandomYearMonthTest {

    @Test
    void shouldReturnRandomYearMonthBetween197001To204012() {
        assertThat(randomYearMonth())
                .isBetween(of(1970, 1), of(2040, 12));
    }

    @Test
    void shouldReturnRandomYearMonthBetween() {
        assertThat(randomYearMonthBetween(of(2000, 1), of(2000, 12)))
                .isBetween(of(2000, 1), of(2000, 12));
    }
}
