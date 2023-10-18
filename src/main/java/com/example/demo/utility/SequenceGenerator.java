package com.example.demo.utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Sequence;

@Service
public class SequenceGenerator {
    @Autowired
    private MongoOperations mongoOperations;

    public Long generateSequence(String seqName) {
        Query query = new Query(Criteria.where("_id").is(seqName));
        Update update = new Update().inc("sequence", 1);
        
        Sequence sequence = mongoOperations.findAndModify(query, update, Sequence.class);

        if (sequence == null) {
            sequence = new Sequence();
            sequence.setId(seqName);
            sequence.setSequence(1L);
            mongoOperations.save(sequence);
        }

        return sequence.getSequence();
    }
}
