package com.openwebinars.hexagonal.task.application.service.create;

import com.openwebinars.hexagonal.task.application.model.Task;
import com.openwebinars.hexagonal.task.application.ports.out.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CreateTaskUseCase {

    private final TaskRepository taskRepository;

    public Task create(CreateTaskCommand command) {
        Task t = Task.builder()
                .title(command.title())
                .description(command.description())
                .createdAt(LocalDateTime.now())
                .completed(false)
                .author(command.author())
                .build();
        return taskRepository.save(t);
    }


}



