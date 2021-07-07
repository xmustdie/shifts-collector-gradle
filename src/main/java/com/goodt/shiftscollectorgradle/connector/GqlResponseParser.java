package com.goodt.shiftscollectorgradle.connector;

import com.goodt.shiftscollectorgradle.adapter.OrganizationUnitAdapter;
import com.goodt.shiftscollectorgradle.adapter.WorkedEventAdapter;
import com.goodt.shiftscollectorgradle.client.response.GraphqlResponse;
import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.service.OrganizationUnitService;
import com.goodt.shiftscollectorgradle.service.WorkedEventService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@AllArgsConstructor
public class GqlResponseParser {


    private final OrganizationUnitService organizationUnitService;
    private final WorkedEventService workedEventService;

    public void parseGqlResponse(GraphqlResponse response) {
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
