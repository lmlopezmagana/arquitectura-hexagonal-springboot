package com.openwebinars.hexagonal.application.usecase.task.find;

import com.openwebinars.hexagonal.application.error.TaskNotFoundException;
import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.TaskId;
import com.openwebinars.hexagonal.application.model.UserId;
import com.openwebinars.hexagonal.application.ports.driven.TaskRepository;
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
