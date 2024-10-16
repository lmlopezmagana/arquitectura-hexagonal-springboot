package com.openwebinars.hexagonal.task.application.delete;

import com.openwebinars.hexagonal.task.domain.model.Task;
import com.openwebinars.hexagonal.task.domain.model.TaskId;
import com.openwebinars.hexagonal.task.domain.repository.TaskRepository;
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
