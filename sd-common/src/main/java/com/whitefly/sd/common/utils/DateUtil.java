package com.whitefly.sd.common.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class DateUtil {
    public static final String normal = "yyyy/MM/dd HH:mm:ss";

    /**
     * 默认采用本地市区进行转换
     *
     * @param date
     * @return
     */
    public static String dateToFormat(Date date) {
        return dateToFormat(date, null);
    }

    /**
     * 采用默认格式
     *
     * @param date
     * @param timezoneId
     * @return
     */
    public static String dateToFormat(Date date, String timezoneId) {
        return dateToFormat(date, timezoneId, normal);
    }

    public static String dateToFormat(Date date, String timezoneId, String format) {
        if (Objects.isNull(date)) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = normal;
        }
        SimpleDateFormat f = new SimpleDateFormat(format);
        if (timezoneId != null) {
            f.setTimeZone(TimeZone.getTimeZone(timezoneId));
        }
        return f.format(date);
    }
}
