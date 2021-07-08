package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.EmployeePosition;
import com.goodt.shiftscollectorgradle.repository.EmployeePositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeePositionService {
    private final EmployeePositionRepository repository;
    public EmployeePosition save(EmployeePosition employeePosition) {
        if (employeePosition == null) return null;
        if (!employeePosition.isNew() && checkFoundWithExternalId(employeePosition.getExternalId())) {
            return get(employeePosition.getExternalId());
        } else {
            return repository.save(employeePosition);
        }
    }

    public EmployeePosition get(Integer externalId) {
        return repository.findEmployeePositionByExternalId(externalId);
    }

    private boolean checkFoundWithExternalId(Integer externalId) {
        return repository.existsEmployeePositionByExternalId(externalId);
    }
}
