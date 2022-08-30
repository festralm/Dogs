package ru.aliaprod.dogsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aliaprod.dogsservice.model.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
}
