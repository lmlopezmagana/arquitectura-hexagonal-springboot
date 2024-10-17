package com.openwebinars.hexagonal.task.application.error;

import com.openwebinars.hexagonal.shared.error.DomainEntityNotFoundException;
import com.openwebinars.hexagonal.task.application.model.TaskId;

public class TaskNotFoundException extends DomainEntityNotFoundException {

    public TaskNotFoundException() {
        super("task");
    }

    public TaskNotFoundException(TaskId id) {
        super("task", id.getValue().toString());
    }

}
