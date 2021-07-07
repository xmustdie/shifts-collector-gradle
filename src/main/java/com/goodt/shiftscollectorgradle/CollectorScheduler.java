package com.goodt.shiftscollectorgradle;

import com.goodt.shiftscollectorgradle.connector.GqlConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CollectorScheduler {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "${scheduler.cron:-}")
    public void getShiftInfo() {
        GqlConnector gqlConnector = new GqlConnector();
        gqlConnector.sendRequest();
    }
}
