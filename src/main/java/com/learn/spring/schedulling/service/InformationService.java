package com.learn.spring.schedulling.service;

import com.learn.spring.schedulling.mapper.CommonObjectMapper;
import com.learn.spring.schedulling.model.Information;
import com.learn.spring.schedulling.repo.InformationRepo;
import com.learn.spring.schedulling.utils.BufferReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class InformationService {

  @Autowired
  private InformationRepo informationRepo;
  @Autowired
  private CommonObjectMapper mapper;

  public List<Information> saveInformations(MultipartFile file) throws Exception {
    long startTime = System.currentTimeMillis();
    log.info("task started at {}", startTime, "------------------------------- Thread name: ", Thread.currentThread().getName());
    var infos = parseCSVFile(file);
    log.info("parsed files in {}",infos);

    saveInfo(infos);
    return infos;
  }

  public void saveInfo(List<Information> infos) {
    try{
      informationRepo.saveAll(infos);
      log.info(" list of data save to db,  data size {}",infos.size());
    }catch (Exception e){
      log.error("Failed to save information list \n",e);
    }
  }


  public List<Information> getInformations() {
    return informationRepo.findAll();
  }


  public List<Information> parseCSVFile(final MultipartFile file) throws Exception {
    final List<Information> Informations = new ArrayList<>();
    try {
      try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
        // skip header line
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {

          Informations.add(BufferReader.delimeter(line));
        }
        return Informations;
      }
    } catch (final IOException e) {
      log.error("Failed to parse CSV file {}", e);
      throw new Exception("Failed to parse CSV file {}", e);
    }
  }


  public void updateInformationJob() {
    log.info("Job  one is running... \t started at {}", new Date());
    log.info("Getting informations from database");
    final List<Information> informations = informationRepo.findAll();
    for(Information information : informations){
      information.setRandomNumber(new Random().nextInt(100));
    };
    log.info("Updating informations in database");
    informationRepo.saveAll(informations);
    log.info("Job one is finished... \t finished at {}", new Date());
  }

  public void updateInformationJob2() {
    log.info("Job  two is running... \t started at {}", new Date());
    final List<Information> informations = informationRepo.findAll();
    for(Information information : informations){
      information.setActive(true);
    };
    log.info("Updating informations in database");
    informationRepo.saveAll(informations);
    log.info("Job two is finished... \t finished at {}", new Date());
  }
}
