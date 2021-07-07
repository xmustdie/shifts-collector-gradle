package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Integer> {
}
