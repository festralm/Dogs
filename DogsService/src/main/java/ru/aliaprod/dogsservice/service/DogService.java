package ru.aliaprod.dogsservice.service;

import org.springframework.stereotype.Service;
import ru.aliaprod.dogsservice.model.Dog;

import java.util.List;

@Service
public interface DogService {
    List<Dog> listAll();

    Dog getById(Long id);

    void increaseRatingById(Long id);
}
