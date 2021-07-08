package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.*;
import com.goodt.shiftscollectorgradle.service.EmployeePositionService;
import com.goodt.shiftscollectorgradle.service.EmployeeService;
import com.goodt.shiftscollectorgradle.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@AllArgsConstructor
public class WorkedEventAdapter {

    private final EmployeeService employeeService;
    private final PositionService positionService;
    private final EmployeePositionService employeePositionService;

    private final EmployeeAdapter employeeAdapter;
    private final PositionAdapter positionAdapter;
    private final EmployeePositionAdapter employeePositionAdapter;

    public WorkedEvent convert(Map<String, Object> workedEventData) {

        String typename = (String) workedEventData.get("__typename");
        if ("SchedulerRequest".equals(typename)) {
            return null;
        }
        WorkedEvent workedEvent = new WorkedEvent();
        workedEvent.set__typename(typename);
        workedEvent.setStatus((String) workedEventData.get("status"));
        workedEvent.setType((String) workedEventData.get("type"));
        workedEvent.setDayType((String) workedEventData.get("dayType"));
        workedEvent.setLunchTime((Double) workedEventData.get("lunch"));

        Employee employee = employeeAdapter.convert((Map) workedEventData.get("employee"));
        workedEvent.setEmployee(employeeService.save(employee));

        Position position = positionAdapter.convert((Map) workedEventData.get("position"));
        workedEvent.setPosition(positionService.save(position));

        EmployeePosition employeePosition = employeePositionAdapter.convert((Map) workedEventData.get(
                "employeePosition"));
        workedEvent.setEmployeePosition(employeePositionService.save(employeePosition));

        DateTimeInterval dateTimeInterval = DateTimeIntervalAdapter.convert((Map) workedEventData.get(
                "dateTimeInterval"));
        workedEvent.setStartDateTime(LocalDateTime.of(dateTimeInterval.getStartDate(),
                dateTimeInterval.getStartTime()));
        workedEvent.setEndDateTime(LocalDateTime.of(dateTimeInterval.getEndDate(),
                dateTimeInterval.getEndTime()));


        return workedEvent;
    }
}
