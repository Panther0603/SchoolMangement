package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ClassSubject;
@Repository
public interface ClassSubjectReposirtory extends MongoRepository<ClassSubject,Long> {
    
}
