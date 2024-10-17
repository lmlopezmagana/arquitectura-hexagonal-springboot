package com.openwebinars.hexagonal.task.application.service.edit;

import com.openwebinars.hexagonal.task.application.model.TaskId;

public record EditTaskCommand(TaskId id, String title, String description, boolean completed) {
}
