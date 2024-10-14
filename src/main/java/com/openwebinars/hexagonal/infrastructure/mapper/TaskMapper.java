package com.openwebinars.hexagonal.infrastructure.mapper;

import com.openwebinars.hexagonal.domain.model.Task;
import com.openwebinars.hexagonal.domain.model.TaskId;
import com.openwebinars.hexagonal.infrastructure.db.entity.TaskEntity;

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
    }}
