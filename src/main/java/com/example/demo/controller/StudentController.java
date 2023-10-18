package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Login;
import com.example.demo.entity.Student;
import com.example.demo.services.StudentServices;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired 
    private StudentServices studentServices;
    
    @PostMapping("/signup")
    public ResponseEntity<?> studentSignup(@RequestBody Student student){
        return ResponseEntity.ok(studentServices.studentSignUp(student));
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> studentLogin(@RequestBody @Validated Login login){
    
        System.out.println("loging controller with useranme "+login.getUserName());

        try{
            return ResponseEntity.status(200).body(studentServices.studentLogin(login));

        } catch(Exception e){

           return ResponseEntity.status(400).body(studentServices.studentLogin(login));
        }
    }
     @GetMapping("/")
    public ResponseEntity<?> getMessage(){
        return ResponseEntity.ok("Hello From my side");
    }
}
