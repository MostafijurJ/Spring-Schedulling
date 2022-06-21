package com.learn.spring.schedulling.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Information {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private String email;

  private String phone;

  private String address;

  @Nullable
  private Integer randomNumber;

  @Nullable
  private boolean isActive;


}
