package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.DateTimeInterval;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class DateTimeIntervalAdapter {

    public static DateTimeInterval convert(Map dateTimeIntervalData) {
        DateTimeInterval dateTimeInterval = new DateTimeInterval();
        dateTimeInterval.setStartDate(localDate((String) dateTimeIntervalData.get("startDate")));
        dateTimeInterval.setStartTime(localTime((String) dateTimeIntervalData.get("startTime")));
        dateTimeInterval.setEndDate(localDate((String) dateTimeIntervalData.get("endDate")));
        dateTimeInterval.setEndTime(localTime((String) dateTimeIntervalData.get("endTime")));
        return dateTimeInterval;
    }

    private static LocalDate localDate(String date) {
        return LocalDate.parse(date);
    }

    private static LocalTime localTime(String time) {
        return LocalTime.parse(time);
    }
}

