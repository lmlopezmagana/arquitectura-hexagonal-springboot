package com.openwebinars.hexagonal.application.usecase.task.create;

import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.ports.driven.TaskRepository;
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



