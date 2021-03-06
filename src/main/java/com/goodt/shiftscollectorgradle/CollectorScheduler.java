package com.goodt.shiftscollectorgradle;

import com.goodt.shiftscollectorgradle.collector.GqlCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CollectorScheduler {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private GqlCollector gqlCollector;

    @Scheduled(cron = "${scheduler.cron:-}")
    public void getShiftInfo() {
/*        GqlRequestSender gqlRequestSender = new GqlRequestSender();
        gqlRequestSender.doSend();*/
        gqlCollector.start();
    }
}
