package ru.aliaprod.dogsservice.service.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.aliaprod.dogsservice.exception.DataNotFoundException;
import ru.aliaprod.dogsservice.model.Dog;
import ru.aliaprod.dogsservice.repository.DogRepository;
import ru.aliaprod.dogsservice.service.DogService;

import java.util.List;
import java.util.Locale;

@Service
public class DogServiceImpl implements DogService {
    @Setter(onMethod_ = @Autowired)
    private DogRepository dogRepository;

    @Setter(onMethod_ = @Autowired)
    private MessageSource messageSource;

    @Override
    public List<Dog> listAll() {
        return dogRepository.findAll();
    }

    @Override
    public Dog getById(Long id) {
        return dogRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(
                                messageSource.getMessage("exception.notFound.dog", null, Locale.getDefault())
                        )
                );
    }
}
