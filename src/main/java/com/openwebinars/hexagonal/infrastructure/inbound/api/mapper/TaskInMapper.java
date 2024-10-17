package com.openwebinars.hexagonal.infrastructure.inbound.api.mapper;

import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.TaskId;
import com.openwebinars.hexagonal.application.model.UserId;
import com.openwebinars.hexagonal.application.model.UserTask;
import com.openwebinars.hexagonal.application.usecase.task.create.CreateTaskCommand;
import com.openwebinars.hexagonal.application.usecase.task.edit.EditTaskCommand;
import com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task.TaskEditRequest;
import com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task.TaskRequest;
import com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task.TaskResponse;
import com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task.UserTaskResponse;

public class TaskInMapper {

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
                userTask.getUser() != null ? UserInMapper.toDto(userTask.getUser()) : null
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
