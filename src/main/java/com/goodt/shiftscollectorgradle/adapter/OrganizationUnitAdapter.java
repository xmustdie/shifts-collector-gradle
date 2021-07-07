package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;

import java.util.Map;

public class OrganizationUnitAdapter {
    public static void convert(Map organizationUnitData, OrganizationUnit organizationUnit) {
        organizationUnit.setOuterId((String)organizationUnitData.get("outerId"));
    }


    public static OrganizationUnit convert(Map organizationUnitData) {
        OrganizationUnit organizationUnit = new OrganizationUnit();
        organizationUnit.setOuterId((String)organizationUnitData.get("outerId"));
        return organizationUnit;
    }
}
