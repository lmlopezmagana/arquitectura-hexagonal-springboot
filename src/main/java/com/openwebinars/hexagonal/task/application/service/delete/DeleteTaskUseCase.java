package com.openwebinars.hexagonal.task.application.service.delete;

import com.openwebinars.hexagonal.task.application.model.Task;
import com.openwebinars.hexagonal.task.application.model.TaskId;
import com.openwebinars.hexagonal.task.application.ports.out.TaskRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTaskUseCase {

    private final TaskRepository taskRepository;

    public void delete(Task t) {
        deleteById(t.getId());
    }

    public void deleteById(TaskId id) {
        taskRepository.delete(id);
    }
}
