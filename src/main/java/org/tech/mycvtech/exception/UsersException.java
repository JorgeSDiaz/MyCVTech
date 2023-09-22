package org.tech.mycvtech.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
import org.tech.mycvtech.repository.UserMongoRepository;

public class UsersException extends ResponseStatusException {
    public UsersException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
