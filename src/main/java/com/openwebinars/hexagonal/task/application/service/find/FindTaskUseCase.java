package com.openwebinars.hexagonal.task.application.service.find;

import com.openwebinars.hexagonal.task.application.error.TaskNotFoundException;
import com.openwebinars.hexagonal.task.application.model.Task;
import com.openwebinars.hexagonal.task.application.model.TaskId;
import com.openwebinars.hexagonal.user.domain.model.UserId;
import com.openwebinars.hexagonal.task.application.ports.out.TaskRepository;
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
