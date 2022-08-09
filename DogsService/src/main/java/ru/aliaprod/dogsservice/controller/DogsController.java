package ru.aliaprod.dogsservice.controller;

import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import ru.aliaprod.dogsservice.dto.DogDto;
import ru.aliaprod.dogsservice.dto.DogListDto;
import ru.aliaprod.dogsservice.service.DogService;
import ru.aliaprod.dogsservice.utils.MapperUtils;

import java.util.List;

@Configuration
@RestController
@RequestMapping("/dogs")
public class DogsController {
    @Setter(onMethod_ = @Autowired)
    private DogService dogService;
    @Setter(onMethod_ = @Autowired)
    private MapperUtils mapperUtils;
    @Setter(onMethod_ = @Autowired)
    private ModelMapper modelMapper;

    @GetMapping
    public List<DogListDto> listAll() {
        return mapperUtils.listMapping(dogService.listAll(), DogListDto.class);
    }

    @GetMapping("/{id}")
    public DogDto getById(@PathVariable Long id) {
        return modelMapper.map(dogService.getById(id), DogDto.class);
    }
}
