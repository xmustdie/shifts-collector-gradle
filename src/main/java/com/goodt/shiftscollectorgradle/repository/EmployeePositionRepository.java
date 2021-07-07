package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Integer> {
}
