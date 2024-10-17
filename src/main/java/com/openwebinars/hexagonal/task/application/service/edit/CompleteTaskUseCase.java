package com.openwebinars.hexagonal.task.application.service.edit;

import com.openwebinars.hexagonal.task.application.error.TaskNotFoundException;
import com.openwebinars.hexagonal.task.application.model.Task;
import com.openwebinars.hexagonal.task.application.model.TaskId;
import com.openwebinars.hexagonal.task.application.ports.out.TaskRepository;
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
