package com.openwebinars.hexagonal.infrastructure.web.rest.task;

import com.openwebinars.hexagonal.application.service.CreateTaskService;
import com.openwebinars.hexagonal.application.usecase.task.create.CreateTaskCommand;
import com.openwebinars.hexagonal.application.usecase.task.create.CreateTaskUseCase;
import com.openwebinars.hexagonal.domain.model.Task;
import com.openwebinars.hexagonal.domain.model.UserTask;
import com.openwebinars.hexagonal.infrastructure.mapper.TaskMapper;
import com.openwebinars.hexagonal.infrastructure.security.model.AuthUser;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.TaskRequest;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.TaskResponse;
import com.openwebinars.hexagonal.infrastructure.web.dto.task.UserTaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskPostController {

    //private final CreateTaskUseCase createTaskUseCase;
    private final CreateTaskService createTaskService;

    @PostMapping
    public ResponseEntity<UserTaskResponse> createTask(@RequestBody TaskRequest taskRequest, @AuthenticationPrincipal AuthUser user) {
        CreateTaskCommand command = TaskMapper.toCommand(taskRequest, user.getIdAsUserId());
        UserTask t = createTaskService.createTask(command);
        return ResponseEntity.status(201).body(TaskMapper.toResponse(t));
    }



}
