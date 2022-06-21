package com.learn.spring.schedulling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
@Slf4j
public class SchedulerService {


    @Autowired
    private InformationService informationService;

    @Autowired
    private FileReaderService fileReaderService;

    @Scheduled(fixedDelay = 30000)
    public void readerJob() throws IOException {
        log.info(" *********** reader job started *********** {}", new Date());
        fileReaderService.readFileFromProperty();
        log.info("file reading job ended at {}", new Date());
    }

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
