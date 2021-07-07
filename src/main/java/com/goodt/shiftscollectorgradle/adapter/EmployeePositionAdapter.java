package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.EmployeePosition;

import java.util.Map;

public class EmployeePositionAdapter {

    public static EmployeePosition convert(Map employeePositionData) {
        EmployeePosition employeePosition = new EmployeePosition();
        employeePosition.setExternalId((Integer) employeePositionData.get("id"));
        employeePosition.setCardNumber((String) employeePositionData.get("cardNumber"));

        return employeePosition;
    }
}
