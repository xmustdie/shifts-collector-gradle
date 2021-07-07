package com.goodt.shiftscollectorgradle.adapter;

import com.goodt.shiftscollectorgradle.client.response.GraphqlResponse;
import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.service.OrganizationUnitService;
import com.goodt.shiftscollectorgradle.service.WorkedEventService;

import java.util.ArrayList;
import java.util.Map;


public class GetTimesheetRosterReportAdapter {

    private static OrganizationUnitService organizationUnitService;
    private static WorkedEventService workedEventService;

    public static void parse(GraphqlResponse response) {
        for (Object o : response.getData().keySet()
        ) {
            if ("organizationUnit".equals(o)) {
                var organizationUnit = new OrganizationUnit();
                OrganizationUnitAdapter.convert((Map) response.getData().get(
                        "organizationUnit"), organizationUnit);
                organizationUnitService.save(organizationUnit);
            }

            if ("workedEvents".equals(o)) {
                var workedEvents = (ArrayList) response.getData().get(
                        "workedEvents");
                for (Object workedEvent : workedEvents) {
                    workedEventService.save(WorkedEventAdapter.convert((Map) workedEvent));
                }
            }
        }
    }
}
