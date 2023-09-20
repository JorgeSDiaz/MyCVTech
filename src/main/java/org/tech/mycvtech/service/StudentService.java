package org.tech.mycvtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tech.mycvtech.repository.UserMongoRepository;

@Service
public class StudentService {
    private UserMongoRepository mongoRepository;

    @Autowired
    public StudentService(UserMongoRepository userMongoRepository) {
        this.mongoRepository = userMongoRepository;
    }
}
