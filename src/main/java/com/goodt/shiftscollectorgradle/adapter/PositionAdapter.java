package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.entity.Position;
import com.goodt.shiftscollectorgradle.service.OrganizationUnitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class PositionAdapter {

    @Autowired
    private final OrganizationUnitService organizationUnitService;

    public Position convert(Map positionData) {
        Position position = new Position();
        position.setName((String) positionData.get("name"));

        OrganizationUnit organizationUnit = OrganizationUnitAdapter.convert((Map) positionData.get(
                "organizationUnit"));
        position.setOrganizationUnit(organizationUnitService.save(organizationUnit));
        return position;
    }
}
