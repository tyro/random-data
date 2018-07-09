package com.tyro.oss.randomdata;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.tyro.oss.randomdata.RandomEnum.randomEnumValue;
import static java.util.Comparator.comparing;

public class RandomInstance {

    private static final Map<Class, Supplier<?>> typeFactories = new LinkedHashMap<>();

    static {
        typeFactories.put(Boolean.class, RandomBoolean::randomBoolean);
        typeFactories.put(Integer.class, RandomInteger::randomInteger);
        typeFactories.put(Long.class, RandomLong::randomLong);
        typeFactories.put(Double.class, RandomDouble::randomDouble);
        typeFactories.put(BigDecimal.class, RandomBigDecimal::randomBigDecimal);
        typeFactories.put(String.class, RandomString::randomString);
        typeFactories.put(LocalDate.class, RandomLocalDate::randomLocalDate);
        typeFactories.put(LocalDateTime.class, RandomLocalDateTime::randomLocalDateTime);
        typeFactories.put(ZonedDateTime.class, RandomZonedDateTime::randomZonedDateTime);
    }

    private static final Map<Class, Function<Supplier<?>, ?>> parameterizedTypeFactories = new LinkedHashMap<>();

    static {
        parameterizedTypeFactories.put(List.class, RandomList::randomList);
        parameterizedTypeFactories.put(Set.class, RandomSet::randomSet);
    }

    public static <T> T random(Class<T> clazz) {
        return randomInstanceOf(clazz);
    }

    private static <T> T randomInstanceOf(Class<T> clazz) {
        try {
            Constructor<?> constructor = getConstructorFor(clazz);
            Object[] arguments = randomArgumentsFor(constructor);
            return (T) constructor.newInstance(arguments);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + clazz, e);
        }
    }

    private static Object[] randomArgumentsFor(Constructor<?> constructor) {
        return Stream.of(constructor.getGenericParameterTypes())
                .map(RandomInstance::randomValueOf)
                .toArray();
    }

    private static Object randomValueOf(Type type) {
        if (type instanceof Class) {
            Class<?> clazz = (Class) type;
            if (clazz.isEnum()) {
                return randomEnumValue((Class<Enum>) clazz);
            } else {
                Supplier<?> factory = findTypeFactory(clazz);
                if (factory != null) {
                    return factory.get();
                }
            }
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments.length == 1) {
                Class<?> rawType = (Class) parameterizedType.getRawType();
                Function<Supplier<?>, ?> factory = findParameterizedTypeFactory(rawType);
                if (factory != null) {
                    return factory.apply(() -> randomValueOf(typeArguments[0]));
                }
            }
        }

        return null;
    }

    private static Supplier<?> findTypeFactory(Class<?> clazz) {
        Supplier<?> supplier = typeFactories.get(clazz);
        if (supplier != null) {
            return supplier;
        }

        for (Map.Entry<Class, Supplier<?>> entry : typeFactories.entrySet()) {
            if (clazz.isAssignableFrom(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    private static Function<Supplier<?>, ?> findParameterizedTypeFactory(Class<?> clazz) {
        Function<Supplier<?>, ?> supplier = parameterizedTypeFactories.get(clazz);
        if (supplier != null) {
            return supplier;
        }

        for (Map.Entry<Class, Function<Supplier<?>, ?>> entry : parameterizedTypeFactories.entrySet()) {
            if (clazz.isAssignableFrom(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    private static Constructor<?> getConstructorFor(Class<?> clazz) {
        return Arrays.stream(clazz.getConstructors())
                .max(comparing(c -> c.getParameterTypes().length))
                .orElseThrow(() -> new RuntimeException("No public constructor found for " + clazz));
    }
}
