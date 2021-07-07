package com.goodt.shiftscollectorgradle.service;

import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.repository.OrganizationUnitRepository;

public class OrganizationUnitService {
    OrganizationUnitRepository repository;

    public OrganizationUnit save(OrganizationUnit organizationUnit) {
        if (!organizationUnit.isNew() && get(organizationUnit.getOuterId()) == null) {
            return repository.save(organizationUnit);
        } else {
            return get(organizationUnit.getOuterId());
        }
    }

    public OrganizationUnit get(String outerId) {
        return repository.findByOuterId(outerId);
    }
}
