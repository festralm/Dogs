package ru.aliaprod.dogsservice.utils;

import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperUtils {
    @Setter(onMethod_ = @Autowired)
    private ModelMapper modelMapper;

    public <S, T> List<T> listMapping(List<S> source, Class<T> targetClazz) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClazz))
                .collect(Collectors.toList());
    }
}
