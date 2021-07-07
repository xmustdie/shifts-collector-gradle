package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkedEventRepository extends JpaRepository<WorkedEvent, Integer> {
}
