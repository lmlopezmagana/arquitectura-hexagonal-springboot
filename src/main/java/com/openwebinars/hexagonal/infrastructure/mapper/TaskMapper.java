package com.openwebinars.hexagonal.infrastructure.mapper;

import com.openwebinars.hexagonal.application.usecase.task.create.CreateTaskCommand;
import com.openwebinars.hexagonal.application.usecase.task.edit.EditTaskCommand;
import com.openwebinars.hexagonal.domain.model.Task;
import com.openwebinars.hexagonal.domain.model.TaskId;
import com.openwebinars.hexagonal.domain.model.UserId;
import com.openwebinars.hexagonal.domain.model.UserTask;
import com.openwebinars.hexagonal.infrastructure.db.entity.TaskEntity;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.TaskEditRequest;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.TaskRequest;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.TaskResponse;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.UserTaskResponse;

public class TaskMapper {

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


    public static CreateTaskCommand toCommand(TaskRequest taskRequest, UserId author) {
        return new CreateTaskCommand(taskRequest.title(), taskRequest.description(), author);
    }

    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(task.getId().getValue(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.isCompleted(),
                task.getAuthor());
    }

    public static UserTaskResponse toResponse(UserTask userTask) {
        return new UserTaskResponse(
                userTask.getTask().getId().getValue(),
                userTask.getTask().getTitle(),
                userTask.getTask().getDescription(),
                userTask.getTask().getCreatedAt(),
                userTask.getTask().isCompleted(),
                userTask.getUser() != null ? UserMapper.toDto(userTask.getUser()) : null
        );
    }

    public static EditTaskCommand toCommand(Long id, TaskEditRequest taskEditRequest) {
        return new EditTaskCommand(
                TaskId.of(id),
                taskEditRequest.title(),
                taskEditRequest.description(),
                taskEditRequest.complete()
        );
    }
}