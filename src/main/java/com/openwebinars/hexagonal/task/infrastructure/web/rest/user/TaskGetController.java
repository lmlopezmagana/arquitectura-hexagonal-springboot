package com.openwebinars.hexagonal.task.infrastructure.web.rest.user;

import com.openwebinars.hexagonal.task.application.find.FindTaskUseCase;
import com.openwebinars.hexagonal.task.domain.model.Task;
import com.openwebinars.hexagonal.task.domain.model.TaskId;
import com.openwebinars.hexagonal.task.infrastructure.mapper.TaskMapper;
import com.openwebinars.hexagonal.shared.infrastructure.security.model.AuthUser;
import com.openwebinars.hexagonal.task.infrastructure.web.dto.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskGetController {

    private final FindTaskUseCase findTaskUseCase;


    // Solamente tiene sentido para el admin
    /*
    @GetMapping
    public List<TaskResponse> allTasks() {
        return findTaskUseCase.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }
     */

    @GetMapping
    public List<TaskResponse> allTask(@AuthenticationPrincipal AuthUser me) {
        return findTaskUseCase.findAllByUserId(me.getIdAsUserId())
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }


    @GetMapping("/{id}")
    public TaskResponse taskById(@PathVariable Long id) {
        Task t = findTaskUseCase.findById(TaskId.of(id));
        return TaskMapper.toResponse(t);

    }


}
