package com.openwebinars.hexagonal.infrastructure.driving.adapter.admin;

import com.openwebinars.hexagonal.application.service.FindTaskService;
import com.openwebinars.hexagonal.infrastructure.driving.dto.task.UserTaskResponse;
import com.openwebinars.hexagonal.infrastructure.driving.mapper.TaskInMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/task")
@RequiredArgsConstructor
public class AdminTaskGetController {

    private final FindTaskService findTaskService;

    @GetMapping
    public List<UserTaskResponse> allTasks() {
        return findTaskService.findAll()
                .stream()
                .map(TaskInMapper::toResponse)
                .toList();
    }


}
