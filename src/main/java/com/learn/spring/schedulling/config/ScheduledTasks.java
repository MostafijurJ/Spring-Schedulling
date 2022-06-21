package com.learn.spring.schedulling.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@Slf4j
public class ScheduledTasks {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//  @Scheduled(fixedRate = 50000)
  private void reportCurrentTimeInCron() {
    String namedCurrMethod = new Throwable()
      .getStackTrace()[0]
      .getMethodName();
    log.info("Name of current method: " + namedCurrMethod);
    log.info("The time is now using cron expression {}", dateFormat.format(new Date()));
  }


}
