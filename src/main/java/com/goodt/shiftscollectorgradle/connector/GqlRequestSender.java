package com.goodt.shiftscollectorgradle.connector;

import com.goodt.shiftscollectorgradle.client.GraphqlClient;
import com.goodt.shiftscollectorgradle.client.request.query.DefaultGraphqlQuery;
import com.goodt.shiftscollectorgradle.client.request.query.GraphqlQuery;
import com.goodt.shiftscollectorgradle.client.request.result.ResultAttributtes;
import com.goodt.shiftscollectorgradle.client.response.GraphqlResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GqlRequestSender {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final String SERVER_URL = "https://reports-aggregator-dev.goodt.me/graphql";

    private final Integer ORG_UNIT_ID = 192660;
    private final String FROM_DATE = "2021-03-31";
    private final String TO_DATE = "2021-03-31";

    private final GraphqlClient graphqlClient = GraphqlClient.buildGraphqlClient(SERVER_URL);
    private Map responseData = new HashMap<>();
    private final Map<String, Object> timeSheetSettings = new HashMap<>();

    public Map doSend() {
        GraphqlQuery query = new DefaultGraphqlQuery("getTimesheetRosterReport");
        setQueryParameters(query);
        setQueryResultAttributes(query);
        log.info(query.toString());

        try {
            GraphqlResponse response = graphqlClient.doQuery(query);
            responseData = response.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(responseData.toString());
        return responseData;
    }

    private void setQueryParameters(GraphqlQuery query) {
        timeSheetSettings.put("organizationUnitId", ORG_UNIT_ID);
        timeSheetSettings.put("from", FROM_DATE);
        timeSheetSettings.put("to", TO_DATE);
        timeSheetSettings.put("splitShifts", true);
        query.getRequestParameter().addObjectParameter("timeSheetSettings", timeSheetSettings);
    }

    private void setQueryResultAttributes(GraphqlQuery query) {
        ResultAttributtes orgUnit = new ResultAttributtes("organizationUnit");
        orgUnit.addResultAttributes("title", "outerId");

        ResultAttributtes employee = new ResultAttributtes("employee");
        employee.addResultAttributes("outerId", "lastName");

        ResultAttributtes organizationUnit = new ResultAttributtes("organizationUnit");
        organizationUnit.addResultAttributes("outerId");

        ResultAttributtes position = new ResultAttributtes("position");
        position.addResultAttributes("name");
        position.addResultAttributes(organizationUnit);

        ResultAttributtes dateTimeInterval = new ResultAttributtes("dateTimeInterval");
        dateTimeInterval.addResultAttributes("startDate", "startTime", "endDate", "endTime");

        ResultAttributtes employeePosition = new ResultAttributtes("employeePosition");
        employeePosition.addResultAttributes("id", "cardNumber");

        ResultAttributtes workedEvents = new ResultAttributtes("workedEvents");
        workedEvents.addResultAttributes("__typename", "status", "type", "dayType", "lunch");
        workedEvents.addResultAttributes(employee, position, dateTimeInterval, employeePosition);
        query.addResultAttributes(orgUnit, workedEvents);
    }
}
