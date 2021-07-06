package com.goodt.shiftscollectorgradle;

import com.goodt.shiftscollectorgradle.connector.GQLConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CollectorScheduler {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "${scheduler.cron:-}")
    public void getShiftInfo() {
        GQLConnector gqlConnector = new GQLConnector();
        gqlConnector.sendRequest();
    }
}
