package com.learn.spring.schedulling.service;

import com.learn.spring.schedulling.utils.BufferReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class FileReaderService {

    @Autowired
    private BufferReader reader;

    @Autowired
    private InformationService informationService;
    public void readFileFromProperty() throws IOException {
        var  resource = new ClassPathResource("info.csv").getInputStream();
        try{
           var dataList =  reader.parseFileToList(resource);
           informationService.saveInfo(dataList);
           log.info("file processing done");
        }catch (Exception e){
            log.error("Err: occurred while file processing , "+ e);
        }
    }
}
