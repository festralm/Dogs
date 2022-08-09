package ru.aliaprod.voteservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.aliaprod.voteservice.dto.DogDto;

@FeignClient(name = "dogs-service", url = "http://localhost:8000")
public interface DogsServiceProxy {
    @GetMapping("/dogs/{id}")
    DogDto getById(@PathVariable Long id);
}
