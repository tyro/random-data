package com.tyro.oss.randomdata;

import java.time.ZoneOffset;

import static com.tyro.oss.randomdata.RandomInteger.randomIntegerBetween;
import static java.time.ZoneOffset.ofHours;
import static java.time.ZoneOffset.ofTotalSeconds;

public class RandomZoneOffset {

    public static ZoneOffset randomZoneOffset() {
        return randomZoneOffsetBetween(ofHours(18), ofHours(-18));
    }

    public static ZoneOffset randomZoneOffsetBetween(ZoneOffset start, ZoneOffset end) {
        return ofTotalSeconds(randomIntegerBetween(end.getTotalSeconds(), start.getTotalSeconds()));
    }
}
