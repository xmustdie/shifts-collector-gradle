package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.entity.Position;

import java.util.Map;

public class PositionAdapter {

    public static Position convert(Map positionData) {
        Position position = new Position();
        position.setName((String) positionData.get("name"));
        position.setOrganizationUnit(OrganizationUnitAdapter.convert((Map) positionData.get(
                "organizationUnit")));
        return position;
    }
}
