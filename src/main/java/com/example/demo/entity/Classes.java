package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "classes")
public class Classes {

    @Transient
    public static String SEQUENCE_NAME="classes_sequence";

    @Id
    private Long classId;

    @Field("section")
    private String section;

    @Field("standarad_id")
    private Integer standardId;
    
}
