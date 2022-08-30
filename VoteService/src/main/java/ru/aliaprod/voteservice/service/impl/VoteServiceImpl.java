package ru.aliaprod.voteservice.service.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import ru.aliaprod.voteservice.dto.DogDto;
import ru.aliaprod.voteservice.exception.BadRequestException;
import ru.aliaprod.voteservice.proxy.DogsServiceProxy;
import ru.aliaprod.voteservice.service.VoteService;

import java.util.Locale;

@Service
public class VoteServiceImpl implements VoteService {
    @Value("${kafka.topic.dog}")
    private String topic;

    @Setter(onMethod_ = @Autowired)
    private MessageSource messageSource;

    @Setter(onMethod_ = @Autowired)
    private DogsServiceProxy dogsServiceProxy;

    @Setter(onMethod_ = @Autowired)
    private KafkaTemplate<String, Long> kafkaTemplate;

    @Override
    public void vote(Long chosenDogId, Long anotherDogId, Long userId) {
        if (chosenDogId.equals(anotherDogId)) {
            throw new BadRequestException(
                    messageSource.getMessage("exception.dogIdsEqual", null, Locale.getDefault())
            );
        }
        DogDto chosenDog = dogsServiceProxy.getById(chosenDogId);
        DogDto anotherDog = dogsServiceProxy.getById(anotherDogId);
        ListenableFuture<SendResult<String, Long>> future = kafkaTemplate.send(topic, chosenDogId);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}
