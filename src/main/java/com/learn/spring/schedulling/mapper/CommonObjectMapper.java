package com.learn.spring.schedulling.mapper;

import com.learn.spring.schedulling.model.Information;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class CommonObjectMapper {

  public List<Information> map(CompletableFuture<List<Information>> informationList) {
    List<Information> infos = new ArrayList<>();
    for (var check : informationList.join()) {
      infos.add(check);
    }
    return infos;
  }
}
