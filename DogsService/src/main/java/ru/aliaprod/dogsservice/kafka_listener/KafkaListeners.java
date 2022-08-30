package ru.aliaprod.dogsservice.kafka_listener;

import lombok.Setter;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.aliaprod.dogsservice.service.DogService;

@Component
public class KafkaListeners {
    private static final String KAFKA_DOG_TOPIC = "dog";

    @Setter(onMethod_ = @Autowired)
    private DogService dogService;

    @Setter(onMethod_ = @Autowired)
    private ModelMapper modelMapper;

    @KafkaListener(topics = KAFKA_DOG_TOPIC)
    public void msgListener(ConsumerRecord<String, Long> record) {
        //todo async??
        dogService.increaseRatingById(record.value());
    }
}
