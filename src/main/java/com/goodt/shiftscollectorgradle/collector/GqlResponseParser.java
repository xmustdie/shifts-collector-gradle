package com.goodt.shiftscollectorgradle.collector;

import com.goodt.shiftscollectorgradle.adapter.OrganizationUnitAdapter;
import com.goodt.shiftscollectorgradle.adapter.WorkedEventAdapter;
import com.goodt.shiftscollectorgradle.client.response.GraphqlResponse;
import com.goodt.shiftscollectorgradle.entity.OrganizationUnit;
import com.goodt.shiftscollectorgradle.entity.WorkedEvent;
import com.goodt.shiftscollectorgradle.service.OrganizationUnitService;
import com.goodt.shiftscollectorgradle.service.WorkedEventService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
@AllArgsConstructor
public class GqlResponseParser {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OrganizationUnitService organizationUnitService;
    private final WorkedEventService workedEventService;
    private final WorkedEventAdapter workedEventAdapter;
    private final OrganizationUnitAdapter organizationUnitAdapter;

    public void parseGqlResponse(GraphqlResponse response) {
        if (response.getData().get("data") != null) {
            Map dataContainer = (Map) ((Map) response.getData().get("data")).get(
                    "getTimesheetRosterReport");
            var organizationUnit = new OrganizationUnit();
            organizationUnitAdapter.convert((Map) dataContainer.get(
                    "organizationUnit"), organizationUnit);
            organizationUnitService.save(organizationUnit);

            var workedEvents = (ArrayList) dataContainer.get(
                    "workedEvents");
            for (Object responseWorkedEvent : workedEvents) {
                WorkedEvent workedEvent = workedEventAdapter.convert((Map) responseWorkedEvent);
                if (workedEvent != null) {
                    workedEventService.save(workedEvent);
                }
            }
        } else {
            log.error("Error receiving data from service, plz check request of remote server " +
                    "status");
        }
    }
}
