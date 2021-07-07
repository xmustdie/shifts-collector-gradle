package com.goodt.shiftscollectorgradle.connector;

import com.goodt.shiftscollectorgradle.client.response.GraphqlResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GqlConnector {
    private GqlRequestSender gqlRequestSender;
    private GqlResponseParser gqlResponseParser;

    public void send() {
        GraphqlResponse response = (GraphqlResponse) gqlRequestSender.doSend();
        gqlResponseParser.parseGqlResponse(response);
    }
}
