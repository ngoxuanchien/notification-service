package com.hdbank.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberUtil {
    private static final int ZERO = 0;

    public static boolean greaterThanZero(long number) {
        return number > ZERO;
    }
}
