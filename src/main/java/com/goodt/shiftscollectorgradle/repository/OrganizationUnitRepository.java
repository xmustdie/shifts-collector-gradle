package com.goodt.shiftscollectorgradle.repository;

import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationUnitRepository extends JpaRepository<OrganizationUnit, Integer> {
    OrganizationUnit findByOuterId(String outerId);
}
