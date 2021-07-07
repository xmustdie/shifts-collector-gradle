package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
