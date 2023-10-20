package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Subject;
import com.example.demo.services.SubjectServices;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    
    @Autowired 
    private SubjectServices subjectServices;
   
   
    @PostMapping("/")
    private ResponseEntity<?> saveSubject(@RequestBody Subject subject){
        try {
            return new  ResponseEntity<>(this.subjectServices.savSubject(subject),HttpStatus.CREATED);
        } catch (Exception e) {
        
            return new  ResponseEntity<>(this.subjectServices.savSubject(subject),HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping("/")
    private ResponseEntity<?> getAllSubejct(){
        return ResponseEntity.ok(this.subjectServices.getAllSubject());
    }
}
