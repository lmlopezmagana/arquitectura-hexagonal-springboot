package com.openwebinars.hexagonal.domain.repository;

import com.openwebinars.hexagonal.domain.model.Task;
import com.openwebinars.hexagonal.domain.model.TaskId;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);
    List<Task> getAll();
    Optional<Task> getById(TaskId id);
    void delete(TaskId id);

}