package com.openwebinars.hexagonal.shared.domain.error;

public class DomainEntityNotFoundException extends RuntimeException {
    public DomainEntityNotFoundException(String entity) {
        super("%s not found".formatted(entity));
    }

    public DomainEntityNotFoundException(String entity, String id) {
        super("%s with id %s not found".formatted(entity, id));
    }
}
