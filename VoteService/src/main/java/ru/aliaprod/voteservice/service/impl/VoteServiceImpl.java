package ru.aliaprod.voteservice.service.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.aliaprod.voteservice.dto.DogDto;
import ru.aliaprod.voteservice.exception.BadRequestException;
import ru.aliaprod.voteservice.proxy.DogsServiceProxy;
import ru.aliaprod.voteservice.service.VoteService;

import java.util.Locale;

@Service
public class VoteServiceImpl implements VoteService {
    @Setter(onMethod_ = @Autowired)
    private MessageSource messageSource;

    @Setter(onMethod_ = @Autowired)
    private DogsServiceProxy dogsServiceProxy;

    @Override
    public void vote(Long chosenDogId, Long anotherDogId, Long userId) {
        if (chosenDogId.equals(anotherDogId)) {
            throw new BadRequestException(
                    messageSource.getMessage("exception.dogIdsEqual", null, Locale.getDefault())
            );
        }
        DogDto chosenDog = dogsServiceProxy.getById(chosenDogId);
        DogDto anotherDog = dogsServiceProxy.getById(anotherDogId);
    }
}
