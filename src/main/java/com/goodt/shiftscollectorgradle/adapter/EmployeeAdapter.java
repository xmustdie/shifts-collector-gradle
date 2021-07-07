package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmployeeAdapter {

    public static Employee convert(Map employeeData) {
        Employee employee = new Employee();
        employee.setLastName((String) employeeData.get("lastName"));
        employee.setOuterId((String) employeeData.get("outerId"));
        return employee;
    }
}
