package com.whitefly.sd.common.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class DateUtil {
    public static final String NORMAL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认采用本地市区进行转换
     *
     * @return 格式化的时间格式
     */
    public static String dateToFormat(Date date) {
        return dateToFormat(date, null);
    }

    public static String dateToStr(Date date, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(date);

    }

    /**
     * 采用默认格式
     * timezoneId为空,默认使用本机时区
     *
     * @param date 时间
     * @param timezoneId 时区 , 为
     * @return
     */
    public static String dateToFormat(Date date, String timezoneId) {
        return dateToFormat(date, timezoneId, NORMAL_FORMAT);
    }

    public static String dateToFormat(Date date, String timezoneId, String format) {
        if (Objects.isNull(date)) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = NORMAL_FORMAT;
        }
        SimpleDateFormat f = new SimpleDateFormat(format);
        if (timezoneId != null) {
            f.setTimeZone(TimeZone.getTimeZone(timezoneId));
        }
        return f.format(date);
    }
}
