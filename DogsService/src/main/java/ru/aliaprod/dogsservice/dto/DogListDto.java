package ru.aliaprod.dogsservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DogListDto {
    private Long id;
    private String photoUrl;
}
