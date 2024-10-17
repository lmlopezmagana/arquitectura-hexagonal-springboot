package com.openwebinars.hexagonal.application.error;

import com.openwebinars.hexagonal.application.model.TaskId;

public class UserNotFoundException extends DomainEntityNotFoundException{

    public UserNotFoundException() {
        super("user");
    }

    public UserNotFoundException(TaskId id) {
        super("user", id.getValue().toString());
    }

}
