package com.openwebinars.hexagonal.user.domain.error;

import com.openwebinars.hexagonal.shared.domain.error.DomainEntityNotFoundException;
import com.openwebinars.hexagonal.task.domain.model.TaskId;

public class UserNotFoundException extends DomainEntityNotFoundException {

    public UserNotFoundException() {
        super("user");
    }

    public UserNotFoundException(TaskId id) {
        super("user", id.getValue().toString());
    }

}
