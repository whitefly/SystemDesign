package com.whitefly.sd.common.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

class DateUtilTest {

    @Test
    void testDateToFormat1() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.NORMAL_FORMAT);
        String time = "2022-02-01 06:33:33";
        Date parse = simpleDateFormat.parse(time);

        String action = DateUtil.dateToFormat(parse);
        assertThat(action).isEqualTo(time);
    }

    @Test
    void testDateToStr() {
        assertThat(DateUtil.dateToStr(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "format"))
                .isEqualTo("result");
    }

    @Test
    void testDateToFormat2() {
        assertThat(DateUtil.dateToFormat(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                "timezoneId")).isEqualTo("result");
    }

    @Test
    void testDateToFormat3() {
        assertThat(DateUtil.dateToFormat(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "timezoneId",
                "format")).isEqualTo("result");
    }
}
