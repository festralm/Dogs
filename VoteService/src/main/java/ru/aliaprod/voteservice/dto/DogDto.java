package ru.aliaprod.voteservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DogDto {
    private Long id;
    private String photoUrl;
    private String port;
}