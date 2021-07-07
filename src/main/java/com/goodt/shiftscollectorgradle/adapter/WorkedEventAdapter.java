package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.DateTimeInterval;
import com.goodt.shiftscollectorgradle.entity.Employee;
import com.goodt.shiftscollectorgradle.entity.Position;
import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import com.goodt.shiftscollectorgradle.service.EmployeeService;
import com.goodt.shiftscollectorgradle.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Map;

@Component
@AllArgsConstructor
public class WorkedEventAdapter {

    private EmployeeService employeeService;
    private PositionService positionService;
    private EmployeeAdapter employeeAdapter;
    private PositionAdapter positionAdapter;
    private EmployeePositionAdapter employeePositionAdapter;

    public WorkedEvent convert(Map<String, Object> workedEventData) {
        WorkedEvent workedEvent = new WorkedEvent();
        workedEvent.setDayType((String) workedEventData.get("dayType"));
        workedEvent.setStatus((String) workedEventData.get("status"));
        workedEvent.setLunchTime((BigInteger) workedEventData.get("lunchTime"));

        Employee employee = employeeAdapter.convert((Map)workedEventData.get("employee"));
        workedEvent.setEmployee(employeeService.save(employee));

        Position position = positionAdapter.convert((Map) workedEventData.get("position"));
        workedEvent.setPosition(positionService.save(position));

        DateTimeInterval dateTimeInterval = DateTimeIntervalAdapter.convert((Map) workedEventData.get(
                "dateTimeInterval"));
        workedEvent.setStartDateTime(LocalDateTime.of(dateTimeInterval.getStartDate(),
                dateTimeInterval.getStartTime()));
        workedEvent.setEndDateTime(LocalDateTime.of(dateTimeInterval.getEndDate(),
                dateTimeInterval.getEndTime()));
        workedEvent.setEmployeePosition(employeePositionAdapter.convert((Map) workedEventData.get(
                "employeePosition")));

        return workedEvent;
    }
}
