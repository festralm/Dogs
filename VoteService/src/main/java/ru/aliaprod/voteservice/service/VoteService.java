package ru.aliaprod.voteservice.service;

import org.springframework.stereotype.Service;

@Service
public interface VoteService {
    void vote(Long chosenDog, Long anotherDog, Long userId);
}

