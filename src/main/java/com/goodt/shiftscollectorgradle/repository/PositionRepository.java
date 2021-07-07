package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findFirstByName(String name);
}
