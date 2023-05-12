package com.arvind.kafka.controller;

import com.arvind.kafka.consumer.KafkaConsumer;
import com.arvind.kafka.model.Student;
import com.arvind.kafka.producer.KafkaProducer;
import com.arvind.kafka.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/produce")
    public ResponseEntity<?> produce(@RequestBody Student student) {
        kafkaProducer.produce(student);
        return ResponseEntity.ok("Message produced successfully");
    }

    @GetMapping("/consume")
    public ResponseEntity<?> consume() {
        List<Student> studentList =  studentRepository.findAll();
        return ResponseEntity.ok(studentList);
    }
}
