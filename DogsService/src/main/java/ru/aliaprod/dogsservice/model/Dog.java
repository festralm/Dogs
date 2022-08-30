package ru.aliaprod.dogsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dog {
    @Id
    @GeneratedValue
    private Long id;

    private String photoUrl;

    @Column(columnDefinition = "integer default 0")
    private Long rating;
}
