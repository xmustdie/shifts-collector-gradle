package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.Employee;

import java.util.Map;

public class EmployeeAdapter {

    public static Employee convert(Map employeeData) {
        Employee employee = new Employee();
        employee.setLastName((String) employeeData.get("lastname"));
        employee.setOuterId((String) employeeData.get("outer"));
        return employee;
    }
}
