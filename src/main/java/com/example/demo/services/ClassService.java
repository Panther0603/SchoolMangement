package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ClassSubject;
import com.example.demo.entity.Classes;
import com.example.demo.entity.Subject;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.ClassSubjectReposirtory;
import com.example.demo.utility.SequenceGenerator;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;
    
    @Autowired 
    private ClassSubjectReposirtory classSubjectReposirtory;
    
    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private SubjectServices subjectServices;
    public Classes savClasses(Classes classes){
        classes.setClassId(this.sequenceGenerator.generateSequence("classes_sequence"));
        return this.classRepository.save(classes);
    }

    public Classes getClassesById(Long id){
        Optional<Classes> optionals= this.classRepository.findById(id);
        if(optionals.isPresent()){
            return optionals.get();    
        }else{
            return new Classes();
        }   
       
    }


    public ClassSubject savClassSubject(ClassSubject classSubject){
        classSubject.setClassSubjectId(this.sequenceGenerator.generateSequence("class_cource_seq_id"));
        Subject subject=this.subjectServices.getSubjectById(classSubject.getSubjects().getId());
        Classes classes=this.getClassesById(classSubject.getSubjects().getId());
        classSubject.setSubjects(subject);
        classSubject.setClasses(classes);
        return this.classSubjectReposirtory.save(classSubject);
    }
}
