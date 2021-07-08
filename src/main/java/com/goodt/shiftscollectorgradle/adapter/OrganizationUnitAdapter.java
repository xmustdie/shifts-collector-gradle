package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrganizationUnitAdapter {
    public void convert(Map organizationUnitData, OrganizationUnit organizationUnit) {
        organizationUnit.setOuterId((String)organizationUnitData.get("outerId"));
    }

    public static OrganizationUnit convert(Map organizationUnitData) {
        OrganizationUnit organizationUnit = new OrganizationUnit();
        organizationUnit.setOuterId((String)organizationUnitData.get("outerId"));
        organizationUnit.setTitle("");
        return organizationUnit;
    }
}
