package com.openwebinars.hexagonal.infrastructure.mapper;

import com.openwebinars.hexagonal.application.usecase.task.create.CreateTaskCommand;
import com.openwebinars.hexagonal.domain.model.Task;
import com.openwebinars.hexagonal.domain.model.TaskId;
import com.openwebinars.hexagonal.infrastructure.db.entity.TaskEntity;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.TaskRequest;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.TaskResponse;

public class TaskMapper {

    public static TaskEntity toPersistence(Task task) {
        TaskEntity t = TaskEntity.builder()
                .id(task.getId() != null ? task.getId().getValue() : null)
                .title(task.getTitle())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .completed(task.isCompleted())
                .build();
        return t;
    }

    public static Task toDomain(TaskEntity task) {
        return Task.builder()
                .id(TaskId.of(task.getId()))
                .title(task.getTitle())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .completed(task.isCompleted())
                .build();
    }


    public static CreateTaskCommand toCommand(TaskRequest taskRequest) {
        return new CreateTaskCommand(taskRequest.title(), taskRequest.description());
    }

    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(task.getId().getValue(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.isCompleted());
    }
}