package com.openwebinars.hexagonal.task.infrastructure.web.rest.user;

import com.openwebinars.hexagonal.task.application.create.CreateTaskService;
import com.openwebinars.hexagonal.task.application.create.CreateTaskCommand;
import com.openwebinars.hexagonal.task.domain.model.UserTask;
import com.openwebinars.hexagonal.task.infrastructure.mapper.TaskMapper;
import com.openwebinars.hexagonal.shared.infrastructure.security.model.AuthUser;
import com.openwebinars.hexagonal.task.infrastructure.web.dto.TaskRequest;
import com.openwebinars.hexagonal.task.infrastructure.web.dto.UserTaskResponse;
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
