package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.repository.OrganizationUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationUnitService {

    private final OrganizationUnitRepository repository;

    public OrganizationUnit save(OrganizationUnit organizationUnit) {
        if (get(organizationUnit.getOuterId()) != null) {
            return get(organizationUnit.getOuterId());
        } else {
            return repository.save(organizationUnit);
        }
    }

    public OrganizationUnit get(String outerId) {
        return repository.findByOuterId(outerId);
    }
}
