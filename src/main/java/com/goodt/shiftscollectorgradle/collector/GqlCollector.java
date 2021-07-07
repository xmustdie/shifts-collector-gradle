package com.goodt.shiftscollectorgradle.collector;

import com.goodt.shiftscollectorgradle.client.response.GraphqlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GqlCollector {
    @Autowired
    private GqlRequestSender gqlRequestSender;
    @Autowired
    private GqlResponseParser gqlResponseParser;

    public void start() {
        GraphqlResponse response = (GraphqlResponse) gqlRequestSender.doSend();
        gqlResponseParser.parseGqlResponse(response);
    }
}
