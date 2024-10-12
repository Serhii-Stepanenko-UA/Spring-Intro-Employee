package org.example.app.utils;

import java.util.concurrent.ThreadLocalRandom;

public final class CommonUtils {

    private static final long LOWER_BOUND = 1;
    private static final long UPPER_BOUND = 1000_000;

    private CommonUtils() {}

    public static Long generateId() {
        return ThreadLocalRandom.current().nextLong(LOWER_BOUND, UPPER_BOUND);
    }

    public static void validateId(final Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Parameter [id] must not be null and the value is expected to be greater then zero!");
        }
    }
}