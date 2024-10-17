package com.openwebinars.hexagonal.application.usecase.task.delete;

import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.TaskId;
import com.openwebinars.hexagonal.application.ports.out.TaskRepository;
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
