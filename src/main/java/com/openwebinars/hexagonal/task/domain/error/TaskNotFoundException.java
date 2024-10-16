package com.openwebinars.hexagonal.task.domain.error;

import com.openwebinars.hexagonal.shared.domain.error.DomainEntityNotFoundException;
import com.openwebinars.hexagonal.task.domain.model.TaskId;

public class TaskNotFoundException extends DomainEntityNotFoundException {

    public TaskNotFoundException() {
        super("task");
    }

    public TaskNotFoundException(TaskId id) {
        super("task", id.getValue().toString());
    }

}
