package org.tech.mycvtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tech.mycvtech.model.Admin;
import org.tech.mycvtech.model.Student;
import org.tech.mycvtech.model.User;
import org.tech.mycvtech.repository.UserMongoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UserMongoRepository mongoRepository;

    @Autowired
    public UsersService(UserMongoRepository userMongoRepository) {
        this.mongoRepository = userMongoRepository;
    }

    // Users
    public List<User> allUsers() {
        return mongoRepository.findAll();
    }

    public Optional<User> findById(String userId) {
        return mongoRepository.findById(userId);
    }

    // Students
    public Student addStudent(Student newStudent) {
        return mongoRepository.save(newStudent);
    }

    // Admins
    public Admin addAdmin(Admin newAdmin) {
        return mongoRepository.save(newAdmin);
    }
}
