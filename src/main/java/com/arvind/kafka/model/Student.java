package com.arvind.kafka.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "students")
public class Student {
    private long id;
    private String name;
    private String courseName;
    private String email;
    private int phone;
}
