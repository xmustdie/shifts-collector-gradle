package com.goodt.shiftscollectorgradle.collector;

import com.goodt.shiftscollectorgradle.adapter.OrganizationUnitAdapter;
import com.goodt.shiftscollectorgradle.adapter.WorkedEventAdapter;
import com.goodt.shiftscollectorgradle.client.response.GraphqlResponse;
import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.service.OrganizationUnitService;
import com.goodt.shiftscollectorgradle.service.WorkedEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class GqlResponseParser {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrganizationUnitService organizationUnitService;
    @Autowired
    private WorkedEventService workedEventService;

    public void parseGqlResponse(GraphqlResponse response) {
        Map dataContainer = (Map) ((Map) response.getData().get("data")).get(
                "getTimesheetRosterReport");
        for (Object o : dataContainer.keySet()
        ) {
            if ("organizationUnit".equals(o)) {
                var organizationUnit = new OrganizationUnit();
                OrganizationUnitAdapter.convert((Map) dataContainer.get(
                        "organizationUnit"), organizationUnit);
                organizationUnitService.save(organizationUnit);
            }

            if ("workedEvents".equals(o)) {
                var workedEvents = (ArrayList) dataContainer.get(
                        "workedEvents");
                for (Object workedEvent : workedEvents) {
                    workedEventService.save(WorkedEventAdapter.convert((Map) workedEvent));
                }
            }
        }
    }
}
