package ru.aliaprod.voteservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteDto {
    @NotNull(message = "Chosen dog id is mandatory")
    private Long chosenDog;
    @NotNull(message = "Another dog id is mandatory")
    private Long anotherDog;
}
