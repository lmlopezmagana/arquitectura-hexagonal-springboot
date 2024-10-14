package com.openwebinars.hexagonal.domain.error;

import com.openwebinars.hexagonal.domain.model.TaskId;

public class UserNotFoundException extends DomainEntityNotFoundException{

    public UserNotFoundException() {
        super("user");
    }

    public UserNotFoundException(TaskId id) {
        super("user", id.getValue().toString());
    }

}
