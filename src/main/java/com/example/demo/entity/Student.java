package com.example.demo.entity;


import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Data
@Document(collection   = "student")

public class Student {

   
   
    private Long studentId;

   @Field("first_name")
    private String firstName;

    @Field("last_name")
    private String lastName;

    @Field("father_name")
    private String fatherName;
    
    @Field("mother_name")
    private String motherName;
    
    @Field("email")
    private String email;

    @Field("mobile_no")
    private String mobileNo;

    @Field("username")
    private String logingId;

    @Field("Password")
    private String password;

    @Field("created_at")
    private Date createdAt;
    
}
