package ru.aliaprod.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aliaprod.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
