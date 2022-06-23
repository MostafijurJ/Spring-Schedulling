package com.learn.spring.schedulling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class SchedulerService {


    @Autowired
    private InformationService informationService;

    @Autowired
    private FileReaderService fileReaderService;

    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");

    @Scheduled(fixedDelay = 30000)
    public void readerJob() throws IOException {
        log.info("file reading job start at {}", dateFormat.format(new Date()));
        fileReaderService.readFileFromProperty();
        log.info("file reading job ended at {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 30000)
    public void startJob1() {
        log.info("Job  1 is started at {}", dateFormat.format(new Date()));
        informationService.updateInformationJob();
        log.info("Job  1 is ended at {}", dateFormat.format(new Date()));
    }


    @Scheduled(fixedDelay = 30000)
    public void startJob2() {
        log.info("Job  2 is started at {}", dateFormat.format(new Date()));
        informationService.updateInformationJob2();
        log.info("Job  2 is ended at {}", dateFormat.format(new Date()));
    }

}
