package com.example.demo.services;

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
    
}
