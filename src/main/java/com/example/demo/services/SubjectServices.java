package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.utility.SequenceGenerator;

@Service
public class SubjectServices {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    public Subject savSubject(Subject subject){
        subject.setId(sequenceGenerator.generateSequence("subject_squence"));
        return this.subjectRepository.save(subject);
    }

     public List<Subject> getAllSubject(){
        
        return this.subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id){
        Optional<Subject> optionals=subjectRepository.findById(id);
        if(optionals.isPresent()){
            return optionals.get();
        }else{
            return null;
        }
    }
    
}
