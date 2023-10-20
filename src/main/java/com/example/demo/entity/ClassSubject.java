package com.example.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
@Data
@Document(collection = "class_subject")
public class ClassSubject {

    @Transient
    public static String SEQUENCE_NAME="class_cource_seq_id";
    
    @Id
    private Long classSubjectId;

    @DBRef
    @Field("class_idfk")
    private Classes classes;

    @DBRef
    @Field("subject_idfk")
    private Subject subjects;
    
}
