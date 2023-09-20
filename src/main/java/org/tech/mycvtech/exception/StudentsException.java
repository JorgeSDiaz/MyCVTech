package org.tech.mycvtech.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class StudentsException extends ResponseStatusException {
    public StudentsException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
