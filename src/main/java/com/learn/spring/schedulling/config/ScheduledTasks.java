package com.learn.spring.schedulling.config;

import com.learn.spring.schedulling.AnimalService;
import com.learn.spring.schedulling.MethodName;
import com.learn.spring.schedulling.model.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Configuration
@Slf4j
public class ScheduledTasks {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Autowired
  private AnimalService animalService;

  private String[] animals = {
    "cat",
    "dog",
    "bird",
    "fish",
    "lizard",
    "snake",
    "turtle",
    "tiger",
    "bear",
    "pig",
    "cow",
    "sheep",
    "goat",
    "horse",
    "deer",
    "elephant",
    "monkey",
    "chicken",
    "duck",
    "goose",
    "pigeon",
    "rooster",
    "turkey",
    "ostrich",
    "camel",
    "crocodile",
    "dolphin",
    "eel",
    "giraffe",
    "kangaroo",
    "lion",
    "panther",
    "rhinoceros",
    "tiger",
    "zebra"
  };

  //@Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    log.info("The time is now {}", dateFormat.format(new Date()));
  }

//  @Scheduled(cron = "0/3 * * * * *")
@Scheduled(fixedRate = 50000)
  private void reportCurrentTimeInCron() {
    String namedCurrMethod = new Throwable()
      .getStackTrace()[0]
      .getMethodName();
    log.info("Name of current method: " + namedCurrMethod);
    this.reportCurrentTimeInCron2();
    log.info("The time is now using cron expression {}", dateFormat.format(new Date()));
  }

  private void reportCurrentTimeInCron2() {
    String namedCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    log.info("Invoking method: " + namedCurrMethod + " at time: " + dateFormat.format(new Date()));
    var animals  = this.getListOfAnimals();
    animalService.modifyAnimalName(animals);
    log.info("Method invocation Returned: " + namedCurrMethod + " at time: " + dateFormat.format(new Date()));
  }

  private List<Animal> getListOfAnimals() {
    List<Animal> animals = new ArrayList<>();
    for (String animal : this.animals) {
      Animal animalObj = new Animal();
      animalObj.setName(animal);
      animalObj.setAge(new Random().nextInt(10));
      animals.add(animalObj);
    }
    return animals;
  }
}
