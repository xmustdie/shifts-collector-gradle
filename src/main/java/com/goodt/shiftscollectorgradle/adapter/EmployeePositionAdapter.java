package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.EmployeePosition;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmployeePositionAdapter {

    public EmployeePosition convert(Map employeePositionData) {
        EmployeePosition employeePosition = new EmployeePosition();
        if (employeePositionData == null) {
            employeePosition.setExternalId(0);
            employeePosition.setCardNumber("Unknown number");
        } else {
            employeePosition.setExternalId((Integer) employeePositionData.get("id"));
            employeePosition.setCardNumber((String) employeePositionData.get("cardNumber"));
        }
        return employeePosition;
    }
}
