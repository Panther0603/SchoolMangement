package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "subject")
public class Subject {

     @Transient
    public static final String SEQUENCE_NAME = "subject_squence";

    @Id
    private Long id;

    @Field("subject_name")
    private String subjectName;

    
}
