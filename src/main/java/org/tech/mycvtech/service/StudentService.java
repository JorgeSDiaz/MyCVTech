package org.tech.mycvtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tech.mycvtech.repository.StudentsMongoRepository;

@Service
public class StudentService {
    private StudentsMongoRepository mongoRepository;

    @Autowired
    public StudentService(StudentsMongoRepository studentsMongoRepository) {
        this.mongoRepository = studentsMongoRepository;
    }
}
