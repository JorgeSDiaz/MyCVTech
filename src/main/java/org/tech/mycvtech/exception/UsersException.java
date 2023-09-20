package org.tech.mycvtech.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class UsersException extends ResponseStatusException {
    public UsersException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
