package com.openwebinars.hexagonal.task.application.model;

import lombok.Value;

@Value
public class TaskId {
    Long value;

    public static TaskId of(Long value) {
        return new TaskId(value);
    }

}
