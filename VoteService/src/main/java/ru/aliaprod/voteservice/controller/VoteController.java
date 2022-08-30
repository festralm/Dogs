package ru.aliaprod.voteservice.controller;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aliaprod.voteservice.dto.VoteDto;
import ru.aliaprod.voteservice.service.VoteService;

import javax.validation.Valid;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Setter(onMethod_ = @Autowired)
    private VoteService voteService;

    @PostMapping
    public void vote(@RequestBody @Valid VoteDto voteDto) {
        // todo auth and security
        voteService.vote(voteDto.getChosenDog(), voteDto.getAnotherDog(), 0L);
    }
}
