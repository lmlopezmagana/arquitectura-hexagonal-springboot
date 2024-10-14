package com.openwebinars.hexagonal.application.usecase.task.find;

import com.openwebinars.hexagonal.domain.error.TaskNotFoundException;
import com.openwebinars.hexagonal.domain.model.Task;
import com.openwebinars.hexagonal.domain.model.TaskId;
import com.openwebinars.hexagonal.domain.model.UserId;
import com.openwebinars.hexagonal.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindTaskUseCase {

    private final TaskRepository taskRepository;

    public Task findById(TaskId id) {

        return taskRepository.getById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public List<Task> findAll() {
        List<Task> result = taskRepository.getAll();
        if (result.isEmpty())
            throw new TaskNotFoundException();

        return result;
    }

    public List<Task> findAllByUserId(UserId id) {
        List<Task> result = taskRepository.getByUserId(id);
        if (result.isEmpty())
            throw new TaskNotFoundException();

        return result;
    }


}
