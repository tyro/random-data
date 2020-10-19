package com.tyro.oss.randomdata;

import java.time.YearMonth;

import static com.tyro.oss.randomdata.RandomInteger.randomIntegerBetween;
import static java.time.YearMonth.of;

public class RandomYearMonth {

    public static YearMonth randomYearMonth() {
        YearMonth minYearMonth = of(1970, 1);
        YearMonth maxYearMonth = of(2040, 12);

        return randomYearMonthBetween(minYearMonth, maxYearMonth);
    }

    public static YearMonth randomYearMonthBetween(YearMonth start, YearMonth end) {
        return of(randomIntegerBetween(start.getYear(), end.getYear()),
                randomIntegerBetween(start.getMonthValue(), end.getMonthValue()));
    }
}
