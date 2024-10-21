package com.hdbank.common.log;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class StringUtil {
    public static String toString(Object obj) {
        if (obj == null) {
            return "NULL";
        }

        if (obj instanceof String || obj instanceof Date) {
            return obj.toString();
        }

        if (WrapperType.isWrapperType(obj.getClass())) {
            return obj.toString();
        }

        return ToStringBuilder.reflectionToString(obj, LogSetting.def_style);
    }
}
