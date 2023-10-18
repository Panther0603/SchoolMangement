package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.lang.Long;
import java.util.List;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long> {

    @Query("{username:?0}")
    public List<Student> findByLogingId(String username);
}