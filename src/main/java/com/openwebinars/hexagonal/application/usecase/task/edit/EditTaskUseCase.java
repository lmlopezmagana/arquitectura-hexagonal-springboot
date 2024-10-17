package com.openwebinars.hexagonal.application.usecase.task.edit;

import com.openwebinars.hexagonal.application.error.TaskNotFoundException;
import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.ports.out.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditTaskUseCase {

    private final TaskRepository taskRepository;

    public Task update(EditTaskCommand command) {
        return taskRepository.getById(command.id())
                .map(t -> {
                    t.setTitle(command.title());
                    t.setDescription(command.description());
                    t.setCompleted(command.completed());
                    return taskRepository.save(t);
                }).orElseThrow(() -> new TaskNotFoundException(command.id()));
    }

}
