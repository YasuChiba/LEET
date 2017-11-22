package com.leet.leet.utils;

import com.leet.leet.common.Enums;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by YasuhiraChiba on 2017/11/04.
 */

//using joda-time-android library.
public class DateHelper {

    final private static String DATE_FORMAT = "MMddyyyy";

    public static LocalDate getCurrentDate() {
        DateTime dt = new DateTime();
        return dt.toLocalDate();
    }

    public static String getCurrentDateString() {
        DateTime dt = new DateTime();
        return dt.toString(DATE_FORMAT);
    }

    public static LocalDate getDateByString(String dateStr) {
        return DateTimeFormat.forPattern(DATE_FORMAT).parseLocalDate(dateStr);
    }

    public static String getStringByDate(LocalDate date) {
        return date.toString(DATE_FORMAT);
    }

    public static LocalDate getPastDate(int minusDays) {
        DateTime dt = new DateTime().minusDays(minusDays);
        return dt.toLocalDate();
    }

    public static LocalDate getFutureDate(int plusDays) {
        DateTime dt = new DateTime().plusDays(plusDays);
        return dt.toLocalDate();
    }

    public static LocalDate getFutureDateOfTheDate(LocalDate date, int plusDays) {
        return date.plusDays(plusDays);
    }

    public static Enums.Week getWeekByString(String dayStr) {
        DateTime dt = DateTimeFormat.forPattern(DATE_FORMAT).parseDateTime(dayStr);
        return Enums.Week.create(dt.getDayOfWeek());
    }

}
