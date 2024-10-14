package com.openwebinars.hexagonal.application.usecase.task.edit;

import com.openwebinars.hexagonal.domain.model.TaskId;

public record EditTaskCommand(TaskId id, String title, String description, boolean completed) {
}
