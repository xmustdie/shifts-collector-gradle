package com.goodt.shiftscollectorgradle.connector;

import org.mountcloud.graphql.GraphqlClient;
import org.mountcloud.graphql.request.query.DefaultGraphqlQuery;
import org.mountcloud.graphql.request.query.GraphqlQuery;
import org.mountcloud.graphql.response.GraphqlResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Conn2 {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final String SERVER_URL = "http://127.0.0.1:8080/graphql";

    private final GraphqlClient graphqlClient = GraphqlClient.buildGraphqlClient(SERVER_URL);

    public void sendRequest() {
        GraphqlQuery query = new DefaultGraphqlQuery("vehicles");
        Map<String, String> headers = new HashMap<>() {{
            put("token", "graphqltesttoken");
        }};
        graphqlClient.setHttpHeaders(headers);
        query.getRequestParameter().addObjectParameter("count", 1);
        query.addResultAttributes("id", "type", "modelCode");
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
