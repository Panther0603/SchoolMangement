package com.example.demo.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Login;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;
    public Student studentSignUp(Student student){
        
        student.setCreatedAt(new Date());
        this.studentRepository.save(student);
        return student;
    }

    public Login studentLogin(Login login){
        List<Student> students=studentRepository.findByLogingId(login.getUserName());
        return entityTodto(students, login); // it will check user name and pass then return accordingly 
    }


    public Login entityTodto(List<Student>students ,Login login){
       
        if(students!=null && students.size()>0){
            System.out.println(students.size());
            if(login.getPassword().equalsIgnoreCase(students.get(0).getPassword())){
                login= new Login();
                login.setValid(true);
            }else{
                login.setValid(false);
            }

        }
        return login;
    }

    
}
