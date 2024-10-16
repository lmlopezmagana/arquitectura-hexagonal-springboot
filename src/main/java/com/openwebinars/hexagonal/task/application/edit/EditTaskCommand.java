package com.openwebinars.hexagonal.task.application.edit;

import com.openwebinars.hexagonal.task.domain.model.TaskId;

public record EditTaskCommand(TaskId id, String title, String description, boolean completed) {
}
