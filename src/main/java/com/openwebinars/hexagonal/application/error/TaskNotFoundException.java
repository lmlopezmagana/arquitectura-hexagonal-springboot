package com.openwebinars.hexagonal.application.error;

import com.openwebinars.hexagonal.application.model.TaskId;

public class TaskNotFoundException extends DomainEntityNotFoundException{

    public TaskNotFoundException() {
        super("task");
    }

    public TaskNotFoundException(TaskId id) {
        super("task", id.getValue().toString());
    }

}
