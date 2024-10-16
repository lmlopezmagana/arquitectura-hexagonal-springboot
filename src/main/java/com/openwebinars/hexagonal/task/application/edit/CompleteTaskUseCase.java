package com.openwebinars.hexagonal.task.application.edit;

import com.openwebinars.hexagonal.task.domain.error.TaskNotFoundException;
import com.openwebinars.hexagonal.task.domain.model.Task;
import com.openwebinars.hexagonal.task.domain.model.TaskId;
import com.openwebinars.hexagonal.task.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompleteTaskUseCase {

    private final TaskRepository taskRepository;

    public Task completeTask(Task t) {
        t.taskCompleted();
        return taskRepository.save(t);
    }

    public Task completeTask(TaskId id) {
        return taskRepository.getById(id)
                .map(t -> {
                    t.taskCompleted();
                    return taskRepository.save(t);
                }).orElseThrow(() -> new TaskNotFoundException(id));
    }


}
