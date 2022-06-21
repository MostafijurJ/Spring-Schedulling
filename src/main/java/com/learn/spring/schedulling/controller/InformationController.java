package com.learn.spring.schedulling.controller;

import com.learn.spring.schedulling.model.Information;
import com.learn.spring.schedulling.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class InformationController {

  @Autowired
  private InformationService informationService;

  @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
  public ResponseEntity<List<Information>> saveInformation(@RequestParam("file") MultipartFile information) throws Exception {

    return ResponseEntity.ok(informationService.saveInformations(information));
  }

  @GetMapping(value = "/upload", produces = "application/json")
  public List<Information>  getInformation() {
    return informationService.getInformations();
  }

}
