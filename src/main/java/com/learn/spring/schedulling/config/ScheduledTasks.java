package com.learn.spring.schedulling.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@Slf4j
public class ScheduledTasks {


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/3 * * * * *")
    private void reportCurrentTimeInCron() {
        this.reportCurrentTimeInCron2();
        log.info("The time is now using cron expression {}", dateFormat.format(new Date()));
    }


    private void reportCurrentTimeInCron2() {
        log.info("The time is now inner cron expression {}", dateFormat.format(new Date()));
    }
}
