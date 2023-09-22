package org.tech.mycvtech.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.tech.mycvtech.model.user.User;

import java.util.Optional;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}
