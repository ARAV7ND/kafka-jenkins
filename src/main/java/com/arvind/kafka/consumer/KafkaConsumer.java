package com.arvind.kafka.consumer;

import com.arvind.kafka.model.Student;
import com.arvind.kafka.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @KafkaListener(topics = "student", groupId = "my-group")
    public void consume(Student student) {
        LOGGER.info(String.format("====== consuming message: -> %s ======", student.toString()));
        studentRepository.save(student);
    }
}
