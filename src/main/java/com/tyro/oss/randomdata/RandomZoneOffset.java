package com.tyro.oss.randomdata;

import java.time.ZoneOffset;

import static com.tyro.oss.randomdata.RandomInteger.randomIntegerBetween;

public class RandomZoneOffset {

    public static ZoneOffset randomZoneOffset() {
        return randomZoneOffsetBetween(ZoneOffset.ofHours(18), ZoneOffset.ofHours(-18));
    }

    public static ZoneOffset randomZoneOffsetBetween(ZoneOffset start, ZoneOffset end) {
        return ZoneOffset.ofTotalSeconds(randomIntegerBetween(end.getTotalSeconds(), start.getTotalSeconds()));
    }
}
