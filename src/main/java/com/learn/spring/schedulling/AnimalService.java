package com.learn.spring.schedulling;

import com.learn.spring.schedulling.model.Animal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AnimalService {

    public List<Animal> modifyAnimalName(List<Animal> animals) {
        String getMethodName = new Throwable()
            .getStackTrace()[0]
            .getMethodName();
        log.info("Invoking method: " + getMethodName + " at time: " + new Date() +" with animals: " + String.format("%s", animals));
        animals.forEach(a -> a.setName(a.getName().toUpperCase()));

        log.info("Method invocation Returned: " + getMethodName + " at time: " + new Date() +" with animals: " + String.format("%s", animals));

        return animals;
    }

}
