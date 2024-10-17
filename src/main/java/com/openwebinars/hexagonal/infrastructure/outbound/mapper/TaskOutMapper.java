package com.openwebinars.hexagonal.infrastructure.outbound.mapper;

import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.TaskId;
import com.openwebinars.hexagonal.application.model.UserId;
import com.openwebinars.hexagonal.infrastructure.outbound.db.entity.TaskEntity;

public class TaskOutMapper {

    public static TaskEntity toPersistence(Task task) {
        TaskEntity t = TaskEntity.builder()
                .id(task.getId() != null ? task.getId().getValue() : null)
                .title(task.getTitle())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .completed(task.isCompleted())
                .author(task.getAuthor() != null ? task.getAuthor().getValue() : null)
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
                .author(UserId.of(task.getAuthor()))
                .build();
    }

}
