package org.tech.mycvtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tech.mycvtech.model.User;
import org.tech.mycvtech.repository.UserMongoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private UserMongoRepository mongoRepository;

    @Autowired
    public UsersService(UserMongoRepository userMongoRepository) {
        this.mongoRepository = userMongoRepository;
    }

    public User addUser(User newUser) {
        return mongoRepository.save(newUser);
    }

    public List<User> allUsers() {
        return mongoRepository.findAll();
    }

    public Optional<User> findById(Long userId) {
        return mongoRepository.findById(userId);
    }
}
