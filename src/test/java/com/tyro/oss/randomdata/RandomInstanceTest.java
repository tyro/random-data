package com.tyro.oss.randomdata;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.tyro.oss.randomdata.RandomInstance.random;
import static org.assertj.core.api.Assertions.assertThat;

class RandomInstanceTest {

    @Test
    void shouldReturnRandomInstanceWithStringArgs() {
        assertThat(random(StringTestObject.class))
                .isInstanceOf(StringTestObject.class)
                .hasNoNullFieldsOrProperties();
    }

    @Test
    void shouldReturnRandomInstanceWithNumericArgs() {
        assertThat(random(NumericTestObject.class))
                .isInstanceOf(NumericTestObject.class)
                .hasNoNullFieldsOrProperties();
    }

    @Test
    void shouldReturnRandomInstanceWithDataAndTimeArgs() {
        assertThat(random(DateAndTimeTestObject.class))
                .isInstanceOf(DateAndTimeTestObject.class)
                .hasNoNullFieldsOrProperties();
    }

    @Test
    void shouldReturnRandomInstanceWithCollectionArgs() {
        assertThat(random(CollectionTestObject.class))
                .isInstanceOf(CollectionTestObject.class)
                .hasNoNullFieldsOrProperties();
    }

    @Test
    void shouldReturnRandomInstanceWithEnumArgs() {
        assertThat(random(EnumTestObject.class))
                .isInstanceOf(EnumTestObject.class)
                .hasNoNullFieldsOrProperties();
    }

    @Test
    void shouldSetUnsupportedTypesToNull() {
        assertThat(random(UnsupportedTestObject.class))
                .isEqualTo(new UnsupportedTestObject(null, null, null));
    }

    static class StringTestObject extends AbstractTestObject {
        private String string;
        private CharSequence charSequenc;

        public StringTestObject(String string, CharSequence charSequenc) {
            this.string = string;
            this.charSequenc = charSequenc;
        }
    }

    static class NumericTestObject extends AbstractTestObject {
        private Number number;
        private BigDecimal bigDecimal;
        private Boolean booleanValue;
        private Integer integer;
        private Long longValue;
        private Double doubleValue;

        public NumericTestObject(Number number, BigDecimal bigDecimal, Boolean booleanValue, Integer integer, Long longValue, Double doubleValue) {
            this.number = number;
            this.bigDecimal = bigDecimal;
            this.booleanValue = booleanValue;
            this.integer = integer;
            this.longValue = longValue;
            this.doubleValue = doubleValue;
        }
    }

    static class DateAndTimeTestObject extends AbstractTestObject {
        private Temporal temporal;
        private LocalDate localDate;
        private LocalDateTime localDateTime;
        private ZonedDateTime zonedDateTime;
        private Instant instant;
        private ZoneOffset zoneOffset;
        private YearMonth yearMonth;

        public DateAndTimeTestObject(Temporal temporal,
                                     LocalDate localDate,
                                     LocalDateTime localDateTime,
                                     ZonedDateTime zonedDateTime,
                                     Instant instant,
                                     ZoneOffset zoneOffset,
                                     YearMonth yearMonth) {
            this.temporal = temporal;
            this.localDate = localDate;
            this.localDateTime = localDateTime;
            this.zonedDateTime = zonedDateTime;
            this.instant = instant;
            this.zoneOffset = zoneOffset;
            this.yearMonth = yearMonth;
        }
    }

    static class CollectionTestObject extends AbstractTestObject {
        private Collection<String> collection;
        private List<CharSequence> list;
        private Set<Integer> set;
        private List<Set<CharSequence>> listSet;

        public CollectionTestObject(Collection<String> collection, List<CharSequence> list, Set<Integer> set, List<Set<CharSequence>> listSet) {
            this.collection = collection;
            this.list = list;
            this.set = set;
            this.listSet = listSet;
        }
    }

    static class EnumTestObject {
        private TestEnum enumValue;

        public EnumTestObject(TestEnum enumValue) {
            this.enumValue = enumValue;
        }

        enum TestEnum {
            value1,
            value2,
            value3
        }
    }

    static class UnsupportedTestObject extends AbstractTestObject {
        private List list;
        private Set set;
        private Map<String, String> map;

        public UnsupportedTestObject(List list, Set set, Map<String, String> map) {
            this.list = list;
            this.set = set;
            this.map = map;
        }
    }

    static abstract class AbstractTestObject {

        @Override
        public boolean equals(Object other) {
            return EqualsBuilder.reflectionEquals(this, other);
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }

    }
}