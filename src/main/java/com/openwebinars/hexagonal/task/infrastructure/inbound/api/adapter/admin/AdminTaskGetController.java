package com.openwebinars.hexagonal.task.infrastructure.inbound.api.adapter.admin;

import com.openwebinars.hexagonal.task.application.service.find.FindTaskService;
import com.openwebinars.hexagonal.task.infrastructure.inbound.api.mapper.TaskMapper;
import com.openwebinars.hexagonal.task.infrastructure.inbound.api.dto.UserTaskResponse;
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
                .map(TaskMapper::toResponse)
                .toList();
    }


}
