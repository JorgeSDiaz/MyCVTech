package org.tech.mycvtech.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.tech.mycvtech.model.User;

@Repository
public interface UserMongoRepository extends MongoRepository<User, Long> {
}
