package com.learn.spring.schedulling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SchedulerService {


    @Autowired
    private InformationService informationService;

    @Scheduled(fixedDelay = 30000)
    public void startJob1() {
        log.info("Job  one is running... \t started at {}", new Date());
        informationService.updateInformationJob();
        log.info("Job  one is running... \t ended at {}", new Date());
    }


    @Scheduled(fixedDelay = 30000)
    public void startJob2() {
        log.info("Job  two is running... \t started at {}", new Date());
        informationService.updateInformationJob2();
        log.info("Job  two is running... \t ended at {}", new Date());
    }

}
