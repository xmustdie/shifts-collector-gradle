package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkedEventRepository extends JpaRepository<WorkedEvent, Integer> {
}
