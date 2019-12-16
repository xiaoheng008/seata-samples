package io.seata.samples.integration.common.utils;

/**
 * 功能：
 * 详细：
 *
 * @author xiaoheng 2019-11-28
 */

import io.seata.samples.integration.common.exception.ServiceException;

import java.util.Collection;

public class ParameterUtil {
    public ParameterUtil() {
    }

    public static void assertBetween(int value, int min, int max, String msg) {
        if (value < min || value > max) {
            throw new ServiceException(msg);
        }
    }

    public static void assertBetween(long value, long min, long max, String msg) {
        if (value < min || value > max) {
            throw new ServiceException(msg);
        }
    }

    public static void assertLarge(int value, int min, String msg) {
        if (value <= min) {
            throw new ServiceException(msg);
        }
    }

    public static void assertLarge(long value, long min, String msg) {
        if (value <= min) {
            throw new ServiceException(msg);
        }
    }

    public static void assertNotNull(Object value, String msg) {
        if (value == null) {
            throw new ServiceException(msg);
        }
    }

    public static void assertNotEmpty(String value, String msg) {
        if (value == null || value.trim().length() == 0) {
            throw new ServiceException(msg);
        }
    }

    public static void assertNotEmpty(Collection<?> value, String msg) {
        if (value == null || value.isEmpty()) {
            throw new ServiceException(msg);
        }
    }

    public static void assertNotEquals(int expect, int value, String msg) {
        if (expect == value) {
            throw new ServiceException(msg);
        }
    }

    public static void assertNotEquals(long expect, long value, String msg) {
        if (expect == value) {
            throw new ServiceException(msg);
        }
    }

    public static void assertIn(Collection<String> expect, String value, String msg) {
        if (expect == null || !expect.contains(value)) {
            throw new ServiceException(msg);
        }
    }

    public static <T> void assertIn(Collection<T> expect, T value, String msg) {
        if (expect == null || !expect.contains(value)) {
            throw new ServiceException(msg);
        }
    }

    public static void assertTrue(boolean value, String msg) {
        if (!value) {
            throw new ServiceException(msg);
        }
    }

    public static void assertFalse(boolean value, String msg) {
        if (value) {
            throw new ServiceException(msg);
        }
    }
}
