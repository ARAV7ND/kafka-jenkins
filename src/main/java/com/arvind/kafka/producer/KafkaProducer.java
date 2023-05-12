package com.arvind.kafka.producer;

import com.arvind.kafka.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    public void produce(Student message) {
        LOGGER.info(String.format("======== Producing message: -> %s========", message.toString()));
        kafkaTemplate.send("student", message);
    }
}
