package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.DateTimeInterval;
import com.goodt.shiftscollectorgradle.entity.WorkedEvent;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Map;

public class WorkedEventAdapter {

    public static WorkedEvent convert(Map<String, Object> workedEventData) {
        WorkedEvent workedEvent = new WorkedEvent();
        workedEvent.setDayType((String) workedEventData.get("__dayType"));
        workedEvent.setStatus((String) workedEventData.get("status"));
        workedEvent.setLunchTime((BigInteger) workedEventData.get("lunchTime"));
        workedEvent.setEmployee(EmployeeAdapter.convert((Map)workedEventData.get("employee")));
        workedEvent.setPosition(PositionAdapter.convert((Map) workedEventData.get("position")));
        DateTimeInterval dateTimeInterval = DateTimeIntervalAdapter.convert((Map) workedEventData.get(
                "dateTimeInterval"));
        workedEvent.setStartDateTime(LocalDateTime.of(dateTimeInterval.getStartDate(),
                dateTimeInterval.getStartTime()));
        workedEvent.setEndDateTime(LocalDateTime.of(dateTimeInterval.getEndDate(),
                dateTimeInterval.getEndTime()));
        workedEvent.setEmployeePosition(EmployeePositionAdapter.convert((Map) workedEventData.get(
                "employeePosition")));

        return workedEvent;
    }
}
