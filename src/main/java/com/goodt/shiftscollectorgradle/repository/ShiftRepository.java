package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Integer> {
}
