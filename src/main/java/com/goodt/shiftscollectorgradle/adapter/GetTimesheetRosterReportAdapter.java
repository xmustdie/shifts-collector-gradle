package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.client.response.GraphqlResponse;
import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.service.OrganizationUnitService;

import java.util.Map;

public class GetTimesheetRosterReportAdapter {
    private static OrganizationUnitService organizationUnitService;

    public static void convert(GraphqlResponse response) {
        for (Object o : response.getData().keySet()
        ) {
            if ("organizationUnit".equals(o)) {
                var organizationUnit = new OrganizationUnit();
                OrganizationUnitAdapter.convert((Map)response.getData().get(
                        "organizationUnit"), organizationUnit);
                organizationUnitService.save(organizationUnit);
            }

            if ("workedEvents".equals(o)) {


            }
        }
    }
}
