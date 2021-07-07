package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
