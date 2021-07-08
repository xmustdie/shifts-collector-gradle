package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrganizationUnitAdapter {
    public void convert(Map organizationUnitData, OrganizationUnit organizationUnit) {
        organizationUnit.setOuterId((String)organizationUnitData.get("outerId"));
        organizationUnit.setTitle((String) organizationUnitData.get("title"));
    }

    public static OrganizationUnit convert(Map organizationUnitData) {
        OrganizationUnit organizationUnit = new OrganizationUnit();
        organizationUnit.setOuterId((String)organizationUnitData.get("outerId"));
        String title = (String) organizationUnitData.get("title");
        if (title != null) organizationUnit.setTitle(title);
        return organizationUnit;
    }
}
