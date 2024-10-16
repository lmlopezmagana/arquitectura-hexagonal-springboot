package com.openwebinars.hexagonal.task.application.edit;

import com.openwebinars.hexagonal.task.domain.error.TaskNotFoundException;
import com.openwebinars.hexagonal.task.domain.model.Task;
import com.openwebinars.hexagonal.task.domain.repository.TaskRepository;
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
