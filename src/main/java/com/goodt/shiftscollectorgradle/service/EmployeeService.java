package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.Employee;
import com.goodt.shiftscollectorgradle.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final EmployeeRepository repository;

    public Employee save(Employee employee) {
        if (employee == null) return null;
        String outerId = employee.getOuterId();
        if (checkFoundWithOuterId(outerId)) {
            log.info("Сотрудник с внешним ID = {} уже существует в базе", outerId);
            return get(employee.getOuterId());
        }
        return repository.save(employee);
    }


    public Employee get(String outerId) {
        return repository.findByOuterId(outerId);
    }

    private boolean checkFoundWithOuterId(String outerId) {
        return repository.existsEmployeeByOuterId(outerId);
    }
}
