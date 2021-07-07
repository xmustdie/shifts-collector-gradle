package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.entity.Position;
import com.goodt.shiftscollectorgradle.repository.OrganizationUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class PositionAdapter {

    @Autowired
    private static OrganizationUnitRepository organizationUnitRepository;

    public static Position convert(Map positionData) {
        Position position = new Position();
        position.setName((String) positionData.get("name"));
        OrganizationUnit organizationUnit = OrganizationUnitAdapter.convert((Map) positionData.get(
                "organizationUnit"));
        position.setOrganizationUnit(organizationUnitRepository.save(organizationUnit));
        return position;
    }
}
