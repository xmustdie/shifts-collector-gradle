package com.goodt.shiftscollectorgradle.connector;

import org.mountcloud.graphql.GraphqlClient;
import org.mountcloud.graphql.request.query.DefaultGraphqlQuery;
import org.mountcloud.graphql.request.query.GraphqlQuery;
import org.mountcloud.graphql.request.result.ResultAttributtes;
import org.mountcloud.graphql.response.GraphqlResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GQLConnector {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final String SERVER_URL = "https://reports-aggregator-dev.goodt.me/graphql";

    private final Integer ORG_UNIT_ID = 192660;
    private final String FROM_DATE = "2021-03-31";
    private final String TO_DATE = "2021-03-31";

    private final GraphqlClient graphqlClient = GraphqlClient.buildGraphqlClient(SERVER_URL);

    public void sendRequest() {
        GraphqlQuery query = new DefaultGraphqlQuery("getTimesheetRosterReport");
        Map<String, Object> timeSheetSettings = new HashMap<>() {{
            put("organizationUnitId", ORG_UNIT_ID);
            put("from", FROM_DATE);
            put("to", TO_DATE);
            put("splitShifts", true);
        }};

        Map<String, String> headers = new HashMap<>();


        graphqlClient.setHttpHeaders(headers);

        log.info("\n" + timeSheetSettings.toString() + "\n");
        query.getRequestParameter().addObjectParameter("timeSheetSettings", timeSheetSettings);

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

        log.info(query.toString());

        Map responseData = new HashMap();
        try {
            GraphqlResponse response = graphqlClient.doQuery(query);
            //this map is graphql result
            responseData = response.getData();

        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(responseData.toString());
    }
}
