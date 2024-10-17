package com.openwebinars.hexagonal.application.validation;

import com.openwebinars.hexagonal.application.error.DomainValidationException;

public class EmailAlreadyExistsException extends DomainValidationException {

    public EmailAlreadyExistsException() {
        super("The email must be unique");
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
