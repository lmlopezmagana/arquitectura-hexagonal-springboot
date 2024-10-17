package com.openwebinars.hexagonal.infrastructure.driving.adapter.task;

import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.TaskId;
import com.openwebinars.hexagonal.application.usecase.task.find.FindTaskUseCase;
import com.openwebinars.hexagonal.infrastructure.driving.dto.task.TaskResponse;
import com.openwebinars.hexagonal.infrastructure.driving.mapper.TaskInMapper;
import com.openwebinars.hexagonal.infrastructure.utils.security.model.AuthUser;
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
                .map(TaskInMapper::toResponse)
                .toList();
    }


    @GetMapping("/{id}")
    public TaskResponse taskById(@PathVariable Long id) {
        Task t = findTaskUseCase.findById(TaskId.of(id));
        return TaskInMapper.toResponse(t);

    }


}
