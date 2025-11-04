package ru.oop.dz.util;

public final class ValidationUtils {
    public ValidationUtils() {
    }

    public static boolean notBlank(String value) {
        return !value.isEmpty() && !value.trim().isEmpty();
    }

    public static boolean positive(long value) {
        return value >= 0;
    }

    public static boolean requireBefore(long start, long end) {
        return start < end;
    }
}
