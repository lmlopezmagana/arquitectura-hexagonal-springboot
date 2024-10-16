package com.openwebinars.hexagonal.user.application.validation;

import com.openwebinars.hexagonal.shared.error.DomainValidationException;

public class EmailAlreadyExistsException extends DomainValidationException {

    public EmailAlreadyExistsException() {
        super("The email must be unique");
    }

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
