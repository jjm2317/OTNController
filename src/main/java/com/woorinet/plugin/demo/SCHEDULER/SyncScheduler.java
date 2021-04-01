package com.woorinet.plugin.demo.SCHEDULER;

import com.woorinet.plugin.demo.CONTROLLER.SyncController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SyncScheduler {

    @Autowired
    SyncController syncController;
    private static Logger logger = LoggerFactory.getLogger(SyncScheduler.class);

    @Scheduled(cron = "0 0 3 * * *") // 1초 * 3600 * 24 = 1일에 한번씩
    public void alert() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd/HH:00");
        Date time = new Date();
        String syncDate = timeFormat.format(time);

        logger.info("sync 시간 : {} 시작", syncDate);
        syncController.getTL1(syncDate);
        syncController.convertTL1(syncDate);
        logger.info("sync 시간 : {} 완료", syncDate);
    }

}
