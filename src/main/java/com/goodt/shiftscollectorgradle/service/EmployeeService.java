package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.Employee;
import com.goodt.shiftscollectorgradle.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Employee save(Employee employee) {
        if (employee == null) return null;
        if (!employee.isNew() && checkFoundWithOuterId(employee.getOuterId())) {
            return get(employee.getOuterId());
        } else {
            return repository.save(employee);
        }
    }

    public Employee get(String outerId) {
        return repository.findByOuterId(outerId);
    }

    private boolean checkFoundWithOuterId(String outerId) {
        return repository.existsEmployeeByOuterId(outerId);
    }
}
